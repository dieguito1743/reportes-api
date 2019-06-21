package pe.com.hiper.hcenter2.reportes.dto;

public class ColumnDTO {

	private int id;
	private String sColumnOfTranasctionLog;
	private String sDisplay;
	private String sColumnOfRelationalTable;
	private String sInnierTable;

	public ColumnDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumnOfTranasctionLog() {
		return sColumnOfTranasctionLog;
	}

	public void setColumnOfTranasctionLog(String sColumnOfTranasctionLog) {
		this.sColumnOfTranasctionLog = sColumnOfTranasctionLog;
	}

	public void setDisplay(String sDisplay) {
		this.sDisplay = sDisplay;
	}

	public String getDisplay() {
		return sDisplay;
	}

	public void setColumnOfRelationalTable(String sColumnOfRelationalTable) {
		this.sColumnOfRelationalTable = sColumnOfRelationalTable;
	}

	public String getColumnOfRelationalTable() {
		return sColumnOfRelationalTable;
	}

	public void setInnierTable(String sInnierTable) {
		this.sInnierTable = sInnierTable;
	}

	public String getInnierTable() {
		return sInnierTable;
	}
}
