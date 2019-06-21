package pe.com.hiper.hcenter2.reportes.dto;

public class TransactionDTO {

	private String sid;
	private String scTxMerchantId;
	private String scTxTerminalNum;
	private String scTxTxnNumber;
	private String sfTxTxnDate;
	private String shTxTxnHour;
	private String scTxBatchId;
	private String scTxType;
	private String scTxResultId;
	private String scTxCurrency;
	private String snTxAmount;
	private String snTxCardNumber;
	private String scTxReadType;

	public TransactionDTO() {

	}

	public String getId() {
		return sid;
	}

	public void setId(String sid) {
		this.sid = sid;
	}

	public String getcTxMerchantId() {
		return scTxMerchantId;
	}

	public void setcTxMerchantId(String scTxMerchantId) {
		this.scTxMerchantId = scTxMerchantId;
	}

	public String getcTxTerminalNum() {
		return scTxTerminalNum;
	}

	public void setcTxTerminalNum(String scTxTerminalNum) {
		this.scTxTerminalNum = scTxTerminalNum;
	}

	public String getcTxTxnNumber() {
		return scTxTxnNumber;
	}

	public void setcTxTxnNumber(String scTxTxnNumber) {
		this.scTxTxnNumber = scTxTxnNumber;
	}

	public String getfTxTxnDate() {
		return sfTxTxnDate;
	}

	public void setfTxTxnDate(String sfTxTxnDate) {
		this.sfTxTxnDate = sfTxTxnDate;
	}

	public String gethTxTxnHour() {
		return shTxTxnHour;
	}

	public void sethTxTxnHour(String shTxTxnHour) {
		this.shTxTxnHour = shTxTxnHour;
	}

	public String getcTxBatchId() {
		return scTxBatchId;
	}

	public void setcTxBatchId(String scTxBatchId) {
		this.scTxBatchId = scTxBatchId;
	}

	public String getcTxType() {
		return scTxType;
	}

	public void setcTxType(String scTxType) {
		this.scTxType = scTxType;
	}

	public String getcTxResultId() {
		return scTxResultId;
	}

	public void setcTxResultId(String scTxResultId) {
		this.scTxResultId = scTxResultId;
	}

	public String getcTxCurrency() {
		return scTxCurrency;
	}

	public void setcTxCurrency(String scTxCurrency) {
		this.scTxCurrency = scTxCurrency;
	}

	public String getnTxAmount() {
		return snTxAmount;
	}

	public void setnTxAmount(String snTxAmount) {
		this.snTxAmount = snTxAmount;
	}

	public String getnTxCardNumber() {
		return snTxCardNumber;
	}

	public void setnTxCardNumber(String snTxCardNumber) {
		this.snTxCardNumber = snTxCardNumber;
	}

	public String getcTxReadType() {
		return scTxReadType;
	}

	public void setcTxReadType(String scTxReadType) {
		this.scTxReadType = scTxReadType;
	}

}
