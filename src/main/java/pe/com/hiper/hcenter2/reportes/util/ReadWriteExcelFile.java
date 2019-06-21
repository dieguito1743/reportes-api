package pe.com.hiper.hcenter2.reportes.util;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import pe.com.hiper.hcenter2.reportes.dto.UserCache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dbermudez
 */
public class ReadWriteExcelFile {

	static Logger logger = LoggerFactory.getLogger(ReadWriteExcelFile.class);

	private File file;

	public boolean reWriteSXLSXFile(String nombreArchivo, UserCache userCache) throws IOException {
		boolean resp = false;

		int rowNow, rowCount, y;
		FileInputStream ExcelFileToRead = null;
		XSSFWorkbook wb = null;
		SXSSFWorkbook swb = null;
		SXSSFRow sXSSFRow = null;
		SXSSFCell sXSSFCell = null;
		SXSSFSheet xsheet;
		String xsheetAux;
		String cadena = "";

		FileOutputStream fileOut = null;

		String excelFileName = "";

		excelFileName = System.getProperty("user.dir") + nombreArchivo;

		try {
			rowNow = 0;
			rowCount = 0;
			y = 0;
			swb = new SXSSFWorkbook(100);
			// <editor-fold desc="Crear Reporte Sin Plantilla sin dependencias de ningun
			// tipo">
			cadena = "";
			xsheetAux = "Reporte";
			int numberOfColumn = userCache.getNumberOfColumn();
			userCache.getResultSet().last();
			double totalRow = userCache.getResultSet().getRow();
			double avance = 1;
			userCache.getResultSet().first();
			if (!userCache.getResultSet().next()) {
				logger.info(" No hay resultados en la consulta... ");
			} else {
				userCache.getResultSet().first();
				do {
					if (((avance / totalRow) * 100) % 20 == 0) {
						logger.info(((avance / totalRow) * 100) + "%");
					}
					avance++;
					try {
						xsheet = swb.createSheet(xsheetAux + cadena);
					} catch (Exception ex) {
						xsheet = swb.getSheet(xsheetAux + cadena);
					}
					// 1000000 cantidad de registros por sheet, llega al limite y cambia de sheet
					if ((rowCount % 500000 == 0) && rowCount != 0) {
						y++;
						rowCount = 0;
						rowNow = 0;
						cadena = "_" + y;
						try {
							xsheet = swb.createSheet(xsheetAux + cadena);
							xsheet.flushRows();
						} catch (Exception ex) {
							xsheet = swb.getSheet(xsheetAux + cadena);
						}
					}
					
					// Crea las cabeceras
					if (rowNow == 0) {
						sXSSFRow = xsheet.createRow(rowNow);
						logger.info("crear cabecera");
						for (int column = 1; column <= numberOfColumn; column++) {
							sXSSFCell = sXSSFRow.createCell(column - 1);
							sXSSFCell.setCellValue(userCache.getResultSet().getMetaData().getColumnName(column));
						}
					}
					// Fin de crear cabeceras
					
					// Crea una Row cuando rowNow es distinto al Row del RS.
					if (userCache.getResultSet().getRow() != rowNow) {
						sXSSFRow = xsheet.createRow(rowCount + 1);
						rowNow = userCache.getResultSet().getRow();
						rowCount++;
					}
					for (int column = 1; column <= numberOfColumn; column++) {
						// se comenta el tipo de columna para optimizar en tiemop el código
						/*
						 * if (userCache.getrResultSet().getMetaData().getColumnTypeName(column).equals(
						 * "int")) { sXSSFCell = sXSSFRow.createCell(column - 1);
						 * sXSSFCell.setCellValue(userCache.getrResultSet().getInt(column)); } else if
						 * (userCache.getrResultSet().getMetaData().getColumnTypeName(column)
						 * .equals("numeric")) { sXSSFCell = sXSSFRow.createCell(column - 1);
						 * sXSSFCell.setCellValue(userCache.getrResultSet().getInt(column)); } else if
						 * (userCache.getrResultSet().getMetaData().getColumnTypeName(column).equals(
						 * "double")) { sXSSFCell = sXSSFRow.createCell(column - 1);
						 * sXSSFCell.setCellValue(userCache.getrResultSet().getInt(column)); } else {
						 * sXSSFCell = sXSSFRow.createCell(column - 1);
						 * sXSSFCell.setCellValue(userCache.getrResultSet().getString(column)); }
						 */
						sXSSFCell = sXSSFRow.createCell(column - 1);
						sXSSFCell.setCellValue(userCache.getResultSet().getString(column));
					}
					swb.setSheetVisibility(swb.getSheetIndex(xsheet.getSheetName()), SheetVisibility.VISIBLE);
				} while (userCache.getResultSet().next());

			}
			file = new File(excelFileName);
			fileOut = new FileOutputStream(file);
		} catch (FileNotFoundException ex) {
			logger.error("  El directorio No existe, No se creo el archivo :  " + excelFileName + "\t" + ex.getMessage()
					+ " " + ex.getLocalizedMessage());
		} catch (SQLServerException ex) {
			logger.error(" Se cerro el archivo : " + excelFileName + "\t"
					+ " No se pudo consultar por Rst Cerrado - revisar Conexion");
			ex.printStackTrace();
			fileOut = new FileOutputStream(excelFileName);
		} catch (Exception ex) {
			logger.error(" No se creo el archivo : " + excelFileName + "\t" + ex.getMessage() + " "
					+ ex.getLocalizedMessage());
		} finally {
			try {
				swb.write(fileOut);
				fileOut.close();
				swb.close();
				try {
					wb.close();
					ExcelFileToRead.close();
				} catch (Exception ex) {
				}
				swb.dispose();
				resp = true;
			} catch (NullPointerException ex) {
				resp = false;
				logger.error(ex.getMessage() + " " + ex.getLocalizedMessage());
			} catch (OpenXML4JRuntimeException ex) {
				resp = false;
				logger.error(ex.getMessage() + " " + ex.getLocalizedMessage());
			} catch (Exception ex) {
				resp = false;
				logger.error(ex.getMessage() + " " + ex.getLocalizedMessage());
			}
		}
		excelFileName = null;
		wb = null;
		swb = null;
		xsheet = null;
		sXSSFRow = null;
		sXSSFCell = null;
		ExcelFileToRead = null;
		return resp;
	}

	public File getFile() {
		return file;
	}
}
