import { Injectable } from '@angular/core';

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

}