package pe.com.hiper.hcenter2.reportes.api.restcontroller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.hiper.hcenter2.reportes.dto.ColumnDTO;
import pe.com.hiper.hcenter2.reportes.dto.FilterDTO;
import pe.com.hiper.hcenter2.reportes.dto.TransactionDTO;
import pe.com.hiper.hcenter2.reportes.dto.UserConfigurationOfTransactionDTO;
import pe.com.hiper.hcenter2.reportes.interfaces.IServices;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReportTransactionRestController {

	@Autowired
	@Qualifier("transaction")
	IServices<TransactionDTO> transactionServiceImpl;

	@Autowired
	@Qualifier("filter")
	IServices<FilterDTO> filterServiceImpl;

	@Autowired
	@Qualifier("column")
	IServices<ColumnDTO> columnServiceImpl;

	@Autowired
	@Qualifier("userConf")
	IServices<UserConfigurationOfTransactionDTO> ucotServiceImpl;

	@GetMapping("/filter")
	@ResponseBody
	public List<FilterDTO> getFilterDTO() {
		return filterServiceImpl.getList(null, null, null);
	}

	@GetMapping("/column")
	@ResponseBody
	public List<ColumnDTO> getColumnDTO() {
		return columnServiceImpl.getList(null, null, null);
	}

	@GetMapping("/config/codUsuario/{sCodUser}")
	@ResponseBody
	public List<UserConfigurationOfTransactionDTO> getUserConfigurationOfTransactionDTO(
			@PathVariable(name = "sCodUser", required = true) String sCodUser) {
		return ucotServiceImpl.getList(sCodUser, null, null);
	}

	@GetMapping("/transaction")
	@ResponseBody
	public List<TransactionDTO> getTransactionDTO() {
		return transactionServiceImpl.getList(null, null, null);
	}

	@GetMapping(path = "/download/user/{sCodUsuario}/file.xlsx")
	public ResponseEntity<Resource> download(@PathVariable("sCodUsuario") String sCodUsuario){
		File file = transactionServiceImpl.getFile("U000001", null, null);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = null;
		try {
			resource = new ByteArrayResource(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}

}
