package pe.com.hiper.hcenter2.reportes.repository.sqlserver;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pe.com.hiper.hcenter2.reportes.dto.UserConfigurationOfTransactionDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.util.ForTestingAPIS;

@Repository
public class SQLServerUserConfigOfTransactionDAO implements ICRUD<UserConfigurationOfTransactionDTO> {

	@Qualifier("datasource1")
	@Autowired
	private DataSource dataSource;

	@Override
	public List<UserConfigurationOfTransactionDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserConfigurationOfTransactionDTO> findByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		// return null;
		String sCodUser = cuztomQuery;
		return ForTestingAPIS.getUserConfigurationOfTransactionDTO(sCodUser);
	}

	@Override
	public ResultSet findRsByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean singleInsert(UserConfigurationOfTransactionDTO object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean singleUpdate(UserConfigurationOfTransactionDTO object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String createCuztomQuery(Object parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCuztomQuery(Object parameters0, Object parameters1) {
		// TODO Auto-generated method stub
		// return null;
		return ((String) parameters0) + ";" + ((String) parameters1);
	}

	@Override
	public String createCuztomQuery(Object parameters0, Object parameters1, Object parameters2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCuztomQuery(Object parameters0, Object parameters1, Object parameters2, Object parameter3) {
		// TODO Auto-generated method stub
		return null;
	}

}
