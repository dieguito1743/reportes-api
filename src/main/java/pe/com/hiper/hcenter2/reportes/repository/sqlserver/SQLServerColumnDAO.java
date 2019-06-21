package pe.com.hiper.hcenter2.reportes.repository.sqlserver;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pe.com.hiper.hcenter2.reportes.dto.ColumnDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.util.ForTestingAPIS;

@Repository
public class SQLServerColumnDAO implements ICRUD<ColumnDTO> {

	@Qualifier("datasource1")
	@Autowired
	private DataSource dataSource;

	@Override
	public List<ColumnDTO> findAll() {
		// TODO Auto-generated method stub
		//return null;
		return ForTestingAPIS.getListColumnDTO(0, 0);
	}

	@Override
	public List<ColumnDTO> findByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findRsByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean singleInsert(ColumnDTO object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean singleUpdate(ColumnDTO object) {
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
		return null;
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
