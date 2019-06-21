import { Injectable } from '@angular/core';

@Injectable( {
    providedIn: 'root'
} )
export class Utils {

    constructor() {

    }

    public saveDate( event, index, propertie, object ) {
        if ( object[index] == undefined || object[index] == null ) {
            object[index] = {};
        }
        object[index][propertie] = event;
        return object;
    }

    public hiddenMultiComboBox( index, object ) {
        let bRet: boolean = true;
        if ( object != undefined && object != null && object[index].apirRest != undefined && object[index].apirRest != null && object[index].apirRest.length >= 2 ) {
            bRet = false;
        }
        return bRet;
    }
    
    public hiddenText( index, object ) {
        let bRet: boolean = true;
        if (this.hiddenMultiComboBox(index, object) && object != undefined && object != null && object[index].typeOfData != undefined && object[index].typeOfData != null && ( object[index].typeOfData.toLowerCase() == 'string' || object[index].typeOfData.toLowerCase() == 'number' ) ) {
            bRet = false;
        }
        return bRet;
    }

    public hiddenDate( index, object ) {
        let bRet: boolean = true;
        if ( object != undefined && object != null && object[index].typeOfData != undefined && object[index].typeOfData != null && ( object[index].typeOfData.toLowerCase() == 'date' ) ) {
            bRet = false;
        }
        return bRet;
    }

}