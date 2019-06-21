package pe.com.hiper.hcenter2.reportes.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.hiper.hcenter2.reportes.dto.FilterDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.interfaces.IServices;

@Service("filter")
public class FilterServiceImpl implements IServices<FilterDTO> {
	
	@Autowired
	ICRUD<FilterDTO> icrud;

	@Override
	public List<FilterDTO> getList(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		//return null;
		return icrud.findAll();
	}

	@Override
	public File getFile(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean executeProccess(Object Parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FilterDTO getObject(Object parameter0, Object parameter1, Object parameter2) {
		// TODO Auto-generated method stub
		return null;
	}

}
