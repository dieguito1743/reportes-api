package pe.com.hiper.hcenter2.reportes.util;

import java.util.ArrayList;
import java.util.List;

import pe.com.hiper.hcenter2.reportes.dto.ColumnDTO;
import pe.com.hiper.hcenter2.reportes.dto.FilterDTO;
import pe.com.hiper.hcenter2.reportes.dto.TransactionDTO;
import pe.com.hiper.hcenter2.reportes.dto.UserConfigurationOfTransactionDTO;

public class ForTestingAPIS {

	public static List<TransactionDTO> lRet;

	public static List<ColumnDTO> getListColumnDTO(int status, int estado) {
		List<ColumnDTO> lRetList = new ArrayList<>();
		ColumnDTO objectDTO = new ColumnDTO();

		objectDTO.setId(1);
		objectDTO.setColumnOfTranasctionLog("cTxMerchantId");
		objectDTO.setDisplay("es=Comercio;en=Merchant");
		objectDTO.setColumnOfRelationalTable("cMrMerchantId");
		objectDTO.setInnierTable("tmMerchant");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(2);
		objectDTO.setColumnOfTranasctionLog("cTxTerminalNum");
		objectDTO.setDisplay("es=Número de Termianl;en=Terminal Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(3);
		objectDTO.setColumnOfTranasctionLog("cTxTxnNumber");
		objectDTO.setDisplay("es=Número de transacción;en=Trace Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(4);
		objectDTO.setColumnOfTranasctionLog("fTxTxnDate");
		objectDTO.setDisplay("es=Fecha;en=Date");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(5);
		objectDTO.setColumnOfTranasctionLog("hTxTxnHour");
		objectDTO.setDisplay("es=Hora;en=Hour");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(6);
		objectDTO.setColumnOfTranasctionLog("cTxBatchId");
		objectDTO.setDisplay("es=Lote;en=Batch");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(7);
		objectDTO.setColumnOfTranasctionLog("cTxType");
		objectDTO.setDisplay("es=Tipo de Transacción;en=Transactino Type");
		objectDTO.setColumnOfRelationalTable("cTTTransactionId");
		objectDTO.setInnierTable("tmTransactionType");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(8);
		objectDTO.setColumnOfTranasctionLog("cTxResultId");
		objectDTO.setDisplay("es=Código de Resultado;en=Result");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(9);
		objectDTO.setColumnOfTranasctionLog("cTxCurrency");
		objectDTO.setDisplay("es=Moneda;en=Currency");
		objectDTO.setColumnOfRelationalTable("cMOCodigo");
		objectDTO.setInnierTable("tmMoneda");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(10);
		objectDTO.setColumnOfTranasctionLog("nTxAmount");
		objectDTO.setDisplay("es=Monto;en=Amount");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(11);
		objectDTO.setColumnOfTranasctionLog("nTxCardNumber");
		objectDTO.setDisplay("es=Número de Tarjeta;en=Card Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		objectDTO = new ColumnDTO();
		objectDTO.setId(12);
		objectDTO.setColumnOfTranasctionLog("cTxReadType");
		objectDTO.setDisplay("es=Tipo de Lectura;en=Read Type");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		lRetList.add(objectDTO);

		return lRetList;
	}

	public static List<FilterDTO> getListFilterDTO(int status, int estado) {
		List<FilterDTO> lRetList = new ArrayList<>();
		FilterDTO objectDTO = new FilterDTO();

		objectDTO.setId(1);
		objectDTO.setColumnOfTranasctionLog("cTxMerchantId");
		objectDTO.setDisplay("es=Comercio;en=Merchant");
		objectDTO.setColumnOfRelationalTable("cMrMerchantId");
		objectDTO.setInnierTable("tmMerchant");
		objectDTO.setTypeOfData("number");
		objectDTO.setApirRest("/api/merchant");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(2);
		objectDTO.setColumnOfTranasctionLog("cTxTerminalNum");
		objectDTO.setDisplay("es=Número de Terminal;en=Terminal Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("number");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(3);
		objectDTO.setColumnOfTranasctionLog("cTxTxnNumber");
		objectDTO.setDisplay("es=Número de transacción;en=Trace Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("number");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(4);
		objectDTO.setColumnOfTranasctionLog("fTxTxnDate");
		objectDTO.setDisplay("es=Fecha;en=Date");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("date");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(5);
		objectDTO.setColumnOfTranasctionLog("hTxTxnHour");
		objectDTO.setDisplay("es=Hora;en=Hour");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("hour");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(6);
		objectDTO.setColumnOfTranasctionLog("cTxType");
		objectDTO.setDisplay("es=Tipo de Transacción;en=Transactino Type");
		objectDTO.setColumnOfRelationalTable("cTTTransactionId");
		objectDTO.setInnierTable("tmTransactionType");
		objectDTO.setTypeOfData("string");
		objectDTO.setApirRest("/api/transactiontype");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(7);
		objectDTO.setColumnOfTranasctionLog("cTxResultId");
		objectDTO.setDisplay("es=Código de Resultado;en=Result");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("string");
		objectDTO.setApirRest("/api/result");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(8);
		objectDTO.setColumnOfTranasctionLog("cTxCurrency");
		objectDTO.setDisplay("es=Moneda;en=Currency");
		objectDTO.setColumnOfRelationalTable("cMOCodigo");
		objectDTO.setInnierTable("tmMoneda");
		objectDTO.setTypeOfData("string");
		objectDTO.setApirRest("/api/currency");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(9);
		objectDTO.setColumnOfTranasctionLog("nTxCardNumber");
		objectDTO.setDisplay("es=Número de Tarjeta;en=Card Number");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("number");
		lRetList.add(objectDTO);

		objectDTO = new FilterDTO();
		objectDTO.setId(10);
		objectDTO.setColumnOfTranasctionLog("cTxReadType");
		objectDTO.setDisplay("es=Tipo de Lectura;en=Read Type");
		objectDTO.setColumnOfRelationalTable("");
		objectDTO.setInnierTable("");
		objectDTO.setTypeOfData("string");
		objectDTO.setApirRest("/api/readtype");
		lRetList.add(objectDTO);

		return lRetList;
	}

	public static List<UserConfigurationOfTransactionDTO> getUserConfigurationOfTransactionDTO(String sCodUser) {
		List<UserConfigurationOfTransactionDTO> lRetList = new ArrayList<>();
		UserConfigurationOfTransactionDTO objectDTO;

		objectDTO = new UserConfigurationOfTransactionDTO();
		objectDTO.setId(1);
		objectDTO.setStatus("1");
		objectDTO.setCodUsuario("U0000001");
		objectDTO.setColumnId("1:1;2:1;3:0;4:1;5:0;6:0");
		objectDTO.setFilterId("1:1;2:1;3:1;4:1;5:0;6:0");
		objectDTO.setNameConf("Análisis");
		lRetList.add(objectDTO);

		objectDTO = new UserConfigurationOfTransactionDTO();
		objectDTO.setId(2);
		objectDTO.setStatus("0");
		objectDTO.setCodUsuario("U0000001");
		objectDTO.setColumnId("1:0;2:0;3:0;4:0;5:0;6:0");
		objectDTO.setFilterId("1:1;2:1;3:1;4:1;5:0;6:0");
		objectDTO.setNameConf("Test");
		lRetList.add(objectDTO);

		objectDTO = new UserConfigurationOfTransactionDTO();
		objectDTO.setId(3);
		objectDTO.setStatus("0");
		objectDTO.setCodUsuario("U0000001");
		objectDTO.setColumnId("1:0;2:0;3:0;4:0;5:0;6:0");
		objectDTO.setFilterId("1:1;2:1;3:1;4:1;5:0;6:0");
		objectDTO.setNameConf("Test2");
		lRetList.add(objectDTO);

		return lRetList;
	}

	public static List<TransactionDTO> getTransactionDTO() {
		int lim = 1000;
		if (lRet == null) {
			crearLista(lim);
			return lRet;
		} else if (lRet.size() > 0) {
			return lRet;
		} else {
			crearLista(lim);
			return lRet;
		}
	}

	public static void crearLista(int lim) {
		lRet = new ArrayList<TransactionDTO>();
		TransactionDTO object;
		int i = 1;
		String ok = "00";
		String fail = "99";
		String deposito = "05";
		String retiro = "04";
		String pago_tarj = "08";
		while (i <= lim) {
			object = new TransactionDTO();
			object.setId("" + i);
			object.setcTxMerchantId((i + ""));
			object.setcTxResultId(ok);
			if (i % 4 == 0) {
				object.setcTxResultId(fail);
			}
			object.setcTxType(deposito);
			if (i % 3 == 0) {
				object.setcTxType(retiro);
			}
			if (i % 5 == 0) {
				object.setcTxType(pago_tarj);
			}
			object.setnTxAmount((i + "0000").substring(0, 3) + ".00");
			object.setcTxCurrency("188");
			if (i % 5 == 0 || i % 4 == 0) {
				object.setcTxCurrency("840");
			}
			object.setcTxBatchId("00001");
			object.setfTxTxnDate("20190415");
			object.sethTxTxnHour("120260");
			object.setcTxTerminalNum((i + 1235) + "");

			object.setnTxCardNumber("602923******2510");
			if (i % 5 == 0) {
				object.setnTxCardNumber("999999****9999");
			}

			lRet.add(object);
			i++;
		}
	}
}
