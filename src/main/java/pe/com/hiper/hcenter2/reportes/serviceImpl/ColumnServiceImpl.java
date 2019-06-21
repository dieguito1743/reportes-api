package pe.com.hiper.hcenter2.reportes.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.hiper.hcenter2.reportes.dto.ColumnDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.interfaces.IServices;

@Service("column")
public class ColumnServiceImpl implements IServices<ColumnDTO> {

	@Autowired
	ICRUD<ColumnDTO> icrud;

	@Override
	public List<ColumnDTO> getList(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		// return null;
		return icrud.findAll();
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
	public ColumnDTO getObject(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

}
