package resource;


import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Automation.PaymentAPI.PojoBillPayment;
import Automation.PaymentAPI.PojoUserCreation;
import Automation.PaymentAPI.PojoWallet;


public class PojoToJson {
	
	public String serial(String email) throws JsonProcessingException {
		PojoUserCreation user = new PojoUserCreation();

	user.setEmail(email);
	// ObjectMapper class to serialize Pojo object to JSON
	ObjectMapper objectMapper = new ObjectMapper();
	String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	System.out.println("Json Object is :-");
	System.out.println(json);
	return json;
	}
	
	public String BillPaymentserial(String email, String billID) throws JsonProcessingException {
		PojoBillPayment Bill = new PojoBillPayment();

		Bill.setEmail(email);
		Bill.setBillID(billID);
		
	// ObjectMapper class to serialize Pojo object to JSON
	ObjectMapper objectMapper = new ObjectMapper();
	String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Bill);
	System.out.println("Json Object is :-");
	System.out.println(json);
	return json;
	}
	
	public String WalletAmount(String emailid, int walletamount, String source ) throws JsonProcessingException {
		PojoWallet wallet = new PojoWallet();

		wallet.setEmail(emailid);
		wallet.setWalletAmount(walletamount);
		wallet.setSource(source);
		
	// ObjectMapper class to serialize Pojo object to JSON
	ObjectMapper objectMapper = new ObjectMapper();
	String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wallet);
	System.out.println("Json Object is :-");
	System.out.println(json);
	return json;
	}
	
	
	 

	
}
