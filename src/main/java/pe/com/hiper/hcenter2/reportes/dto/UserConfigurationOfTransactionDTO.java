package pe.com.hiper.hcenter2.reportes.dto;

public class UserConfigurationOfTransactionDTO {

	private int id;
	private String sCodUsuario;
	private String sColumnId;
	private String sFilterId;
	private String sStatus;
	private String sNameConf;

	public UserConfigurationOfTransactionDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodUsuario() {
		return sCodUsuario;
	}

	public void setCodUsuario(String sCodUsuario) {
		this.sCodUsuario = sCodUsuario;
	}

	public String getColumnId() {
		return sColumnId;
	}

	public void setColumnId(String sColumnId) {
		this.sColumnId = sColumnId;
	}

	public String getFilterId() {
		return sFilterId;
	}

	public void setFilterId(String sFilterId) {
		this.sFilterId = sFilterId;
	}

	public void setStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	public String getStatus() {
		return sStatus;
	}
	
	public void setNameConf(String sNameConf) {
		this.sNameConf = sNameConf;
	}

	public String getNameConf() {
		return sNameConf;
	}

}
