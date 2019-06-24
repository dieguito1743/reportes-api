package pe.com.hiper.hcenter2.reportes.repository.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pe.com.hiper.hcenter2.reportes.dto.TransactionDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.ICRUD;
import pe.com.hiper.hcenter2.reportes.util.Cache;
import pe.com.hiper.hcenter2.reportes.util.ForTestingAPIS;

@Repository
public class SQLServerTransaccionDAO implements ICRUD<TransactionDTO> {

	@Qualifier("datasource1")
	@Autowired
	private DataSource dataSource;

	private Connection conN;

	@Override
	public List<TransactionDTO> findAll() {
		// TODO Auto-generated method stub
		// return null;
		String query = "select top(100) cTxMerchantId,cTxTerminalNum,cTxTxnNumber,fTxTxnDate,hTxTxnHour,cTxCompany,cTxStatus,cTxSettleStatus,cTxBatchId,cTxType,cTxForm,cTxResultId,cTxResultExt,nTxRRN,nTxAutorization,cTxCurrency,nTxAmount,cTxPaymentType,cTxDiffPayType,nTxDiffPayMonth,cTxDiffPayMFree,nTxCardNumber,dTxSitCpyCompany,cTxOrigTxnNumber,fTxOrigTxnDate from  tptransactionLog with(nolock)";
		PreparedStatement pst;
		ResultSet rs;
		try {
			conN = dataSource.getConnection();
			pst = conN.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
			Cache.setUserCache("U000001", rs, conN);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ForTestingAPIS.getTransactionDTO();
	}

	@Override
	public List<TransactionDTO> findByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		ResultSet rs;
		String query = "select top(100000) cTxMerchantId, cTxBatchId, cTxCurrency, cTxReadType, cTxResultId, cTxTerminalNum, cTxTxnNumber, cTxType, fTxTxnDate, hTxTxnHour, nTxAmount, TxCardNumber, cTxMerchantId from tptransactionlog";
		List<TransactionDTO> lRet = null;
		try {
			conN = dataSource.getConnection();
			ps = conN.prepareStatement(query);
			rs = ps.executeQuery();
			int i = 1;
			while (rs.next()) {
				if (lRet == null) {
					lRet = new ArrayList<TransactionDTO>();
				}
				TransactionDTO object = new TransactionDTO();
				object.setcTxBatchId(rs.getString("cTxBatchId"));
				object.setcTxCurrency(rs.getString("cTxCurrency"));
				object.setcTxReadType(rs.getString("cTxReadType"));
				object.setcTxResultId(rs.getString("cTxResultId"));
				object.setcTxTerminalNum(rs.getString("cTxTerminalNum"));
				object.setcTxTxnNumber(rs.getString("cTxTxnNumber"));
				object.setcTxType(rs.getString("cTxType"));
				object.setfTxTxnDate(rs.getString("fTxTxnDate"));
				object.sethTxTxnHour(rs.getString("hTxTxnHour"));
				object.setId(i + "");
				i++;
				object.setnTxAmount(rs.getString("nTxAmount"));
				object.setnTxCardNumber(rs.getString("TxCardNumber"));
				object.setcTxMerchantId(rs.getString("cTxMerchantId"));
				lRet.add(object);
			}
		} catch (Exception sql) {
			sql.printStackTrace();
		}
		return lRet;
	}

	@Override
	public ResultSet findRsByCuztomQuery(String cuztomQuery) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean singleInsert(TransactionDTO object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean singleUpdate(TransactionDTO object) {
		// TODO Auto-generated method stub
		return false;
	}

}
