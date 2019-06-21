package pe.com.hiper.hcenter2.reportes.interfaces;

import java.sql.ResultSet;
import java.util.List;

public interface ICRUD<T> {

	public List<T> findAll();

	public List<T> findByCuztomQuery(String cuztomQuery);

	public ResultSet findRsByCuztomQuery(String cuztomQuery);

	public boolean singleInsert(T object);

	public boolean singleUpdate(T object);

	public String createCuztomQuery(Object parameters);

	public String createCuztomQuery(Object parameters0, Object parameters1);

	public String createCuztomQuery(Object parameters0, Object parameters1, Object parameters2);

	public String createCuztomQuery(Object parameters0, Object parameters1, Object parameters2, Object parameter3);

}
