import { Injectable } from '@angular/core';
import { Filter } from '../modelo/filter';

@Injectable({
	providedIn: 'root'
})
export class Utils {

	constructor() {

	}

	public saveDate(event: any, index: any, propertie: any, object: any) {
		if (object[index] == undefined || object[index] == null) {
			object[index] = {};
		}
		object[index][propertie] = event;
		return object;
	}

	public hiddenMultiComboBox(index: any, object: any) {
		let bRet: boolean = true;
		if (object != undefined && object != null && object[index].apirRest != undefined && object[index].apirRest != null && object[index].apirRest.length >= 2) {
			bRet = false;
		}
		return bRet;
	}

	public hiddenText(index: any, object: any) {
		let bRet: boolean = true;
		if (this.hiddenMultiComboBox(index, object) && object != undefined && object != null && object[index].typeOfData != undefined && object[index].typeOfData != null && (object[index].typeOfData.toLowerCase() == 'string' || object[index].typeOfData.toLowerCase() == 'number')) {
			bRet = false;
		}
		return bRet;
	}

	public hiddenDate(index: any, object: any) {
		let bRet: boolean = true;
		if (object != undefined && object != null && object[index].typeOfData != undefined && object[index].typeOfData != null && (object[index].typeOfData.toLowerCase() == 'date')) {
			bRet = false;
		}
		return bRet;
	}

	public trackByIndex(index: number, obj: any): any {
		return index;
	}

	getPrintValue(index: any, object: any): string {
		let sRet: string;
		sRet = object[index].display;
		return sRet;
	}

	validateFilter(valueString: any, fil: Filter) {
		if (fil != undefined && fil != null && fil.typeOfData.toLowerCase() == 'number') {
			if (valueString.length > 0 && isNaN(valueString)) {
				return new Object((valueString as string).substring(0, valueString.length - 1));
			}
		}
		if (fil != undefined && fil != null && fil.typeOfData.toLowerCase() == 'string') {
			if (valueString.length > 0 && isNaN(valueString)) {
				return new Object((valueString as string).toLowerCase());
			}
		}
		return new Object(valueString);
	}

}