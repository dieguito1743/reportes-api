import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { ApiService } from '../service/api.service';
import { ExcelService } from '../service/excel.service';
import { Transaccion } from '../modelo/transaccion';
import { Utils } from '../commons/utils';
import { Userconfiguration } from '../modelo/userconfiguration';
import { Filter } from '../modelo/filter';
import { Column } from '../modelo/column';
import { ColumnDefinition } from '../modelo/columnDefinition';

@Component( {
    selector: 'app-transaccion',
    templateUrl: './transaccion.component.html',
    styleUrls: ['./transaccion.component.css']
} )
export class TransaccionComponent implements OnInit {

    @ViewChild( MatSort ) sort: MatSort;
    @ViewChild( MatPaginator ) paginator: MatPaginator;
    transaccion: Transaccion[];

    userconfigurations: Userconfiguration[];
    filters: Filter[];
    columns: Column[];

    selected: Userconfiguration = null;
    languaje = 'es';

    ngColumnas: Filter[];
    ngFiltros: Column[];
    aNgFiltros: any[];

    filtersaux: Filter[] = [];
    columnsaux: ColumnDefinition[] = [];

    displayedColumns = this.columnsaux.map( c => c.columnDef );

    dataSource: MatTableDataSource<Transaccion>;

    now: Date = new Date();
    
    hidden: boolean = true;

    constructor( private apiService: ApiService, private excelService: ExcelService, public utils: Utils ) {
        this.apiService.getFilter().subscribe(
            success => {
                if ( success.type == 4 ) {
                    this.parseFilter( success );
                }
            },
            error => {
                console.log( 'doSomeThing' );
                console.log( error );
            }
        );

        this.apiService.getColumn().subscribe(
            success => {
                if ( success.type == 4 ) {
                    this.parseColumn( success );
                }
            },
            error => {
                console.log( 'doSomeThing' );
                console.log( error );
            }
        );

        this.apiService.getUserConfiguration().subscribe(
            success => {
                if ( success.type == 4 ) {
                    this.parseUserConfig( success );
                }
            },
            error => {
                console.log( 'doSomeThing' );
                console.log( error );
            }
        );

        this.apiService.getTransacciones().subscribe(
            success => {
                if ( success.type == 4 ) {
                    this.parseTransaction( success );
                }
            },
            error => {
                console.log( 'doSomeThing' );
                console.log( error );
            }
        );
    }

    exportAsXLSX(): void {
        this.hidden = false; 
        this.createColumns();
        //this.excelService.exportAsExcelFile(this.transaccion, 'sample');
    }

    ngOnInit() {
    }

    parseTransaction( success: any ) {
        this.transaccion = success.body as Transaccion[];
        this.dataSource = new MatTableDataSource( this.transaccion );
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
    }

    parseUserConfig( success: any ) {
        this.userconfigurations = success.body as Userconfiguration[];
        this.userconfigurations.forEach( function( object: Userconfiguration ) {
            if ( object.status == '1' ) {
                this.selected = object;
                //id:status
                let vfilters: string[] = object.filterId.split( ';' );
                vfilters.forEach( function( option: string ) {
                    let aux: string[] = option.split( ':' );
                    if ( aux[1] == '1' ) {
                        let ng;
                        if ( this.aNgFiltros == undefined || this.aNgFiltros == null ) {
                            this.aNgFiltros = [];
                        }
                        this.filters.forEach( function( fil: Filter ) {
                            if ( fil.id == aux[0] ) {
                                this.filtersaux.push( fil );
                                this.aNgFiltros.push( ng );
                                if ( this.ngFiltros == undefined || this.ngFiltros == null )
                                    this.ngFiltros = [];
                                ( this.ngFiltros as Filter[] ).push( fil );
                            }
                        }, this
                        );
                    }
                }, this
                );
                //id:status
                let vcolumns: string[] = object.columnId.split( ';' );
                vcolumns.forEach( function( option: string ) {
                    let aux: string[] = option.split( ':' );
                    if ( aux[1] == '1' ) {
                        this.columns.forEach( function( col: Column ) {
                            if ( col.id == aux[0] ) {
                                if ( this.ngColumnas == undefined || this.ngColumnas == null )
                                    this.ngColumnas = [];
                                ( this.ngColumnas as Column[] ).push( col );
                            }
                        }, this );
                    }
                }, this
                );
            }
        }, this );
    }

    parseFilter( success: any ) {
        this.filters = success.body as Filter[];
        this.filters.forEach( function( object: Filter ) {
            var languajes: string[];
            try {
                languajes = ( object.display as string ).split( ';' );
            }
            catch ( ex ) {
                return;
            }

            languajes.forEach( function( value ) {
                if ( value.indexOf( 'es=' ) > -1 && this.languaje == 'es' ) {
                    object.display = value.replace( 'es=', '' );
                } else if ( value.indexOf( 'en=' ) > -1 && this.languaje == 'en' ) {
                    object.display = value.replace( 'en=', '' );
                }
            }, this );
        }, this );
    }

    parseColumn( success: any ) {
        this.columns = success.body as Column[];
        this.columns.forEach( function( object: Column ) {
            var languajes: string[];
            try {
                languajes = ( object.display as string ).split( ';' );
            }
            catch ( ex ) {
                return;
            }

            languajes.forEach( function( value ) {
                if ( value.indexOf( 'es=' ) > -1 && this.languaje == 'es' ) {
                    object.display = value.replace( 'es=', '' );
                } else if ( value.indexOf( 'en=' ) > -1 && this.languaje == 'en' ) {
                    object.display = value.replace( 'en=', '' );
                }
            }, this );
        }, this );
    }

    createColumns() {
        this.columnsaux = [];
        if ( this.ngColumnas != undefined && this.ngColumnas != null && ( this.ngColumnas as Column[] ).length >= 1 ) {
            ( this.ngColumnas as Column[] ).forEach(
                function( col ) {
                    let aux = {};
                    ( aux as ColumnDefinition ).columnDef = col.columnOfTranasctionLog;
                    ( aux as ColumnDefinition ).header = col.display;
                    ( aux as ColumnDefinition ).cell = ( element: Object ) => `${element[col.columnOfTranasctionLog]}`;
                    this.columnsaux.push( aux );
                }, this
            );
            let aux = {};
            ( aux as ColumnDefinition ).columnDef = 'id';
            ( aux as ColumnDefinition ).header = 'Id';
            ( aux as ColumnDefinition ).cell = ( element: any ) => `${element['id']}`;
            this.columnsaux.unshift(( aux as ColumnDefinition ) );
            this.displayedColumns = this.columnsaux.map( c => c.columnDef );
        } else {
            this.columnsaux = [];
            this.displayedColumns = this.columnsaux.map( c => c.columnDef );
        }

    }

    isSticky( column: string ): boolean {
        if ( column == 'id' || column == 'Id' ) {
            return true;
        }
        return false;
    }

    trackByIndex( index: number, obj: any ): any {
        return index;
    }

    getPrintValue( index ): string {
        let sRet: string;
        sRet = this.filtersaux[index].display;
        return sRet;
    }

    hiddenMultiComboBox( index ) {
        let bRet: boolean = true;
        if ( this.filtersaux[index].apirRest != undefined && this.filtersaux[index].apirRest != null && this.filtersaux[index].apirRest.length >= 2 ) {
            bRet = false;
        }
        return bRet;
    }

    hiddenDate( index ) {
        let bRet: boolean = true;
        if ( this.filtersaux[index].typeOfData != undefined && this.filtersaux[index].typeOfData != null && ( this.filtersaux[index].typeOfData == 'date' || this.filtersaux[index].typeOfData == 'Date' ) ) {
            bRet = false;
        }
        return bRet;
    }
}

