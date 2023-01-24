import Automation.PaymentAPI.PojoUserCreation;

public class TestData {

	
	public PojoUserCreation user(String email) 
	{
		PojoUserCreation a = new PojoUserCreation();
		a.setEmail(email);
		return a;
		
	}
}
