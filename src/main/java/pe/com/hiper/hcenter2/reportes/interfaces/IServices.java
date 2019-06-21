package pe.com.hiper.hcenter2.reportes.interfaces;

import java.io.File;
import java.util.List;

public interface IServices<T> {

	public List<T> getList(Object parameter0, Object parameter1, Object parameter2);

	public File getFile(Object parameter0, Object parameter1, Object parameter2);

	public boolean executeProccess(Object parameter0, Object parameter1, Object parameter2);
	
	public T getObject(Object parameter0, Object parameter1, Object parameter2);

}
