package Automation.PaymentAPI;

public class PojoWallet {
	

	private String email;
	private int walletAmount;
	private String source;
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getWalletAmount() {
		return walletAmount;
	}
 
	public void setWalletAmount(int walletAmount) {
		this.walletAmount = walletAmount;
	}
	
	public String getSource() {
		return source;
	}
 
	public void setSource(String source) {
		this.source = source;
	}


}
