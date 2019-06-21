package pe.com.hiper.hcenter2.reportes.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import pe.com.hiper.hcenter2.reportes.dto.UserCache;

public class Cache {

	private static Map<String, UserCache> mUserCache;

	public static UserCache getUserCache(String sCodUsuario) {
		if (mUserCache == null) {
			System.out.println("La cache no está instanciada");
			System.out.println("Instanciando Cache..");
			mUserCache = new HashMap<String, UserCache>();
		}
		return mUserCache.get(sCodUsuario);
	}

	public static void setUserCache(String sCodUsuario, ResultSet rs, Connection con) {
		if (mUserCache == null)
			mUserCache = new HashMap<String, UserCache>();
		mUserCache.put(sCodUsuario, new UserCache(sCodUsuario, rs, con));
	}

}
