import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { ApiService } from '../service/api.service';
import { ExcelService } from '../service/excel.service';
import { Transaccion } from '../modelo/transaccion';
import { Utils } from '../commons/utils';
import { Userconfiguration } from '../modelo/userconfiguration';
import { Filter } from '../modelo/filter';
import { Column } from '../modelo/column';
import { ColumnDefinition } from '../modelo/columnDefinition';
import { FilterDefinition } from '../modelo/filterDefinition';
import { ReplaySubject, Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { FormControl } from '@angular/forms';

@Component({
	selector: 'app-transaccion',
	templateUrl: './transaccion.component.html',
	styleUrls: ['./transaccion.component.scss']
})
export class TransaccionComponent implements OnInit {

	sort: MatSort;
	paginator: MatPaginator;
	transaccion: Transaccion[];

	userconfigurations: Userconfiguration[];
	filters: Filter[];
	columns: Column[];

	selected: Userconfiguration = null;
	languaje = 'es';

	ngColumnas: Column[];
	ngFiltros: Filter[];
	aNgFiltros: any[];
	aFcFiltros: FormControl[] = [];
	aFilterDefinition: FilterDefinition[];

	fcSearchFiltros: FormControl = new FormControl();
	filteredFiltrosMulti: ReplaySubject<Filter[]> = new ReplaySubject<Filter[]>(1);

	fcSearchColumnas: FormControl = new FormControl();
	filteredColumnasMulti: ReplaySubject<Column[]> = new ReplaySubject<Column[]>(1);

	protected _onDestroy = new Subject<void>();

	filtersaux: Filter[] = [];
	columnsaux: ColumnDefinition[] = [];

	displayedColumns = this.columnsaux.map(c => c.columnDef);

	dataSource: MatTableDataSource<Transaccion>;

	now: Date = new Date();

	hidden: boolean = true;

	constructor(private apiService: ApiService, private excelService: ExcelService, public utils: Utils, private route: ActivatedRoute) {
		this.getFiltros();
		this.getColumnas();
	}

	/*
	* utilizar este método cuando se necesite exportar deesde el front cuando la cant de reg < 50 000
	*/
	exportAsXLSX(): void {
		this.excelService.exportAsExcelFile(this.transaccion, 'sample');
	}

	aplicar() {
		/*actualiza los filtros*/
		this.filtersaux = [];
		this.aNgFiltros = [];
		this.aFcFiltros = [];
		this.ngFiltros.forEach(function(fill: Filter){
			let ng: any;
			let fc = new FormControl();
			this.aNgFiltros.push(ng);
			this.aFcFiltros.push(fc);
			this.filtersaux.push(fill);
		},this);
	}

	guardar() {
		/*mandar a guardar al backend la configuracion*/
	}

	ngOnInit() {
		this.utils.wait(3000);
		this.getConfiguracion(this.getUser());
		this.listengChangeValueOfSearFilter();
		this.listengChangeValueOfSearColumn();
	}

	parseTransaction(success: any) {
		this.transaccion = success.body as Transaccion[];
		this.dataSource = new MatTableDataSource(this.transaccion);
		this.dataSource.sort = this.sort;
		this.dataSource.paginator = this.paginator;
	}

	createColumns() {
		this.columnsaux = [];
		if (this.ngColumnas != undefined && this.ngColumnas != null && (this.ngColumnas as Column[]).length >= 1) {
			(this.ngColumnas as Column[]).forEach(
				function (col) {
					let aux = {};
					(aux as ColumnDefinition).columnDef = col.columnOfTranasctionLog;
					(aux as ColumnDefinition).header = col.display;
					(aux as ColumnDefinition).cell = (element: Object) => `${element[col.columnOfTranasctionLog]}`;
					this.columnsaux.push(aux);
				}, this
			);
			let aux = {};
			(aux as ColumnDefinition).columnDef = 'id';
			(aux as ColumnDefinition).header = 'Id';
			(aux as ColumnDefinition).cell = (element: any) => `${element['id']}`;
			this.columnsaux.unshift((aux as ColumnDefinition));
			this.displayedColumns = this.columnsaux.map(c => c.columnDef);
		} else {
			this.columnsaux = [];
			this.displayedColumns = this.columnsaux.map(c => c.columnDef);
		}

	}

	getUser(): string {
		let codUsuario: string = this.route.snapshot.paramMap.get('codUsuario');
		return codUsuario;
	}

	getFiltros() {
		this.apiService.getFilter().subscribe(
			success => {
				if (success.type == 4) {
					this.parseFilter(success);
				}
			},
			error => {
				console.log('doSomeThing');
				console.log(error);
			}
		);
	}

	getColumnas() {
		this.apiService.getColumn().subscribe(
			success => {
				if (success.type == 4) {
					this.parseColumn(success);
				}
			},
			error => {
				console.log('doSomeThing');
				console.log(error);
			}
		);
	}

	getConfiguracion(codUsuario: string) {
		this.apiService.getUserConfiguration(codUsuario).subscribe(
			success => {
				if (success.type == 4) {
					this.parseUserConfig(success);
				}
			},
			error => {
				console.log('doSomeThing');
				console.log(error);
			}
		);
	}

	parseUserConfig(success: any) {
		this.userconfigurations = success.body as Userconfiguration[];
		this.userconfigurations.forEach(function (object: Userconfiguration) {
			if (object.status == '1') {
				this.selected = object;
				//id:status
				let vfilters: string[] = object.filterId.split(';');
				vfilters.forEach(function (option: string) {
					let aux: string[] = option.split(':');
					if (aux[1] == '1') {
						let ng: any;
						let fc = new FormControl();
						if (this.aNgFiltros == undefined || this.aNgFiltros == null) {
							this.aNgFiltros = [];
						}
						this.filters.filter(function (fil: Filter) {
							if (fil.id == aux[0]) {
								this.filtersaux.push(fil);
								this.aNgFiltros.push(ng);
								this.aFcFiltros.push(fc);
								if (this.ngFiltros == undefined || this.ngFiltros == null)
									this.ngFiltros = [];
								(this.ngFiltros as Filter[]).push(fil);
							}
						}, this);
						/*this.filters.forEach(function (fil: Filter) {
							if (fil.id == aux[0]) {
								this.filtersaux.push(fil);
								this.aNgFiltros.push(ng);
								this.aFcFiltros.push(fc);
								if (this.ngFiltros == undefined || this.ngFiltros == null)
									this.ngFiltros = [];
								(this.ngFiltros as Filter[]).push(fil);
							}
						}, this);*/
					}
				}, this);
				//id:status
				let vcolumns: string[] = object.columnId.split(';');
				vcolumns.forEach(function (option: string) {
					let aux: string[] = option.split(':');
					if (aux[1] == '1') {
						this.columns.filter(function (col: Column) {
							if (col.id == aux[0]) {
								if (this.ngColumnas == undefined || this.ngColumnas == null)
									this.ngColumnas = [];
								(this.ngColumnas as Column[]).push(col);
							}
						}, this);
						/*this.columns.forEach(function (col: Column) {
							if (col.id == aux[0]) {
								if (this.ngColumnas == undefined || this.ngColumnas == null)
									this.ngColumnas = [];
								(this.ngColumnas as Column[]).push(col);
							}
						}, this);*/
					}
				}, this);
			}
		}, this);
	}

	parseFilter(success: any) {
		this.filters = success.body as Filter[];
		this.filters.forEach(function (object: Filter) {
			var languajes: string[];
			try {
				languajes = (object.display as string).split(';');
			}
			catch (ex) {
				return;
			}

			languajes.forEach(function (value) {
				if (value.indexOf('es=') > -1 && this.languaje == 'es') {
					object.display = value.replace('es=', '');
				} else if (value.indexOf('en=') > -1 && this.languaje == 'en') {
					object.display = value.replace('en=', '');
				}
			}, this);
		}, this);

		this.filteredFiltrosMulti.next(this.filters.slice());
	}

	parseColumn(success: any) {
		this.columns = success.body as Column[];
		this.columns.forEach(function (object: Column) {
			var languajes: string[];
			try {
				languajes = (object.display as string).split(';');
			}
			catch (ex) {
				return;
			}

			languajes.forEach(function (value) {
				if (value.indexOf('es=') > -1 && this.languaje == 'es') {
					object.display = value.replace('es=', '');
				} else if (value.indexOf('en=') > -1 && this.languaje == 'en') {
					object.display = value.replace('en=', '');
				}
			}, this);
		}, this);
		this.filteredColumnasMulti.next(this.columns.slice());
	}

	getTransacciones() {
		this.apiService.getTransacciones().subscribe(
			success => {
				if (success.type == 4) {
					this.parseTransaction(success);
					this.hidden = false;
					this.createColumns();
				}
			},
			error => {
				console.log('doSomeThing');
				console.log(error);
			}
		);
	}

	isSticky(column: string): boolean {
		if (column.toLowerCase() == 'id') {
			return true;
		}
		return false;
	}

	@ViewChild(MatSort) set matSort(ms: MatSort) {
		this.sort = ms;
		this.setDataSourceAttributes();
	}

	@ViewChild(MatPaginator) set matPaginator(mp: MatPaginator) {
		this.paginator = mp;
		this.setDataSourceAttributes();
	}

	setDataSourceAttributes() {
		this.dataSource = new MatTableDataSource(this.transaccion);
		this.dataSource.paginator = this.paginator;
		this.dataSource.sort = this.sort;
	}

	listengChangeValueOfSearFilter() {
		this.fcSearchFiltros.valueChanges
			.pipe(takeUntil(this._onDestroy))
			.subscribe(() => {
				if (!this.filters) {
					return;
				}
				let search = this.fcSearchFiltros.value;
				if (!search) {
					this.filteredFiltrosMulti.next(this.filters.slice());
					return;
				} else {
					search = search.toLowerCase();
				}
				this.filteredFiltrosMulti.next(
					this.filters.filter(filtro => filtro.display.toLowerCase().indexOf(search) > -1)
				);
			});
	}

	listengChangeValueOfSearColumn() {
		this.fcSearchColumnas.valueChanges
			.pipe(takeUntil(this._onDestroy))
			.subscribe(() => {
				if (!this.columns) {
					return;
				}
				let search = this.fcSearchColumnas.value;
				if (!search) {
					this.filteredColumnasMulti.next(this.columns.slice());
					return;
				} else {
					search = search.toLowerCase();
				}
				this.filteredColumnasMulti.next(
					this.columns.filter(columna => columna.display.toLowerCase().indexOf(search) > -1)
				);
			});
	}
}

