package pe.com.hiper.hcenter2.reportes.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.hiper.hcenter2.reportes.dto.UserCache;

/**
 *
 * @author dbermudez
 */
public class MakeExcelFile {

	static Logger logger = LoggerFactory.getLogger(MakeExcelFile.class);

	private static ReadWriteExcelFile rwef;

	public static boolean iniciar(UserCache userCache, String archivo) {
		boolean resp = false;
		if (makeExcelFile(userCache, archivo)) {
			resp = true;
			logger.info(" Proceso terminado");
		}
		System.gc();// intenta invocar al recolector para liberar memoria.
		return resp;
	}

	private static boolean makeExcelFile(UserCache userCache, String archivo) {
		boolean resp = false;
		if (rwef == null) {
			rwef = new ReadWriteExcelFile();
		}

		try {
			if (rwef.reWriteSXLSXFile(archivo, userCache)) {
				logger.info(" Se creo correctamente el archivo");
			}
		} catch (IOException ex) {
			logger.error(ex.getMessage() + " " + ex.getLocalizedMessage());
		} catch (Exception ex) {
			logger.error(ex.getMessage() + " " + ex.getLocalizedMessage());
		}

		System.gc();
		return resp;
	}

	public static File getFile() {
		return rwef.getFile();
	}
}
