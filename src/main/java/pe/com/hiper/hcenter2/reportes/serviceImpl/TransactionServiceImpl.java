package pe.com.hiper.hcenter2.reportes.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.hiper.hcenter2.reportes.dto.TransactionDTO;
import pe.com.hiper.hcenter2.reportes.dto.UserCache;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.interfaces.IServices;
import pe.com.hiper.hcenter2.reportes.util.Cache;
import pe.com.hiper.hcenter2.reportes.util.MakeExcelFile;;

@Service("transaction")
public class TransactionServiceImpl implements IServices<TransactionDTO> {

	@Autowired
	ICRUD<TransactionDTO> icrud;

	@Override
	public List<TransactionDTO> getList(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		// return null;
		return icrud.findAll();
	}

	@Override
	public File getFile(Object parameter0, Object parameter1, Object parameter2) {
		// este es un método generico
		// recuperamos la cache de usuario
		// el código de usuario debe venir como parametro
		String codUsuario = String.valueOf(parameter0);
		UserCache userCache = Cache.getUserCache(codUsuario);
		MakeExcelFile.iniciar(userCache, "transaccion.xlsx");
		return MakeExcelFile.getFile();
	}

	@Override
	public boolean executeProccess(Object parameter0, Object parameter1, Object parameter2s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransactionDTO getObject(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

}
