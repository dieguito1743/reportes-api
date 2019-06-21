package pe.com.hiper.hcenter2.reportes.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.hiper.hcenter2.reportes.dto.UserConfigurationOfTransactionDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.interfaces.IServices;

@Service("userConf")
public class UCTServiceImpl implements IServices<UserConfigurationOfTransactionDTO> {

	@Autowired
	ICRUD<UserConfigurationOfTransactionDTO> icrud;

	@Override
	public List<UserConfigurationOfTransactionDTO> getList(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		// return null;
		String sCodUser = (String) parameter0;
		return icrud.findByCuztomQuery(sCodUser);
	}

	@Override
	public File getFile(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean executeProccess(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserConfigurationOfTransactionDTO getObject(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

}
