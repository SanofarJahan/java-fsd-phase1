package demo;

public class Authentication {
	
	public boolean authentication(String username,String password) {
		
		
		if((username==null)||(password==null)) {
			return false;
		}
	
		if(username.equalsIgnoreCase("san@gmail.com")) {
			if(password.equals("123")) {
				System.out.println("Logged In !!");
				return true;
			}
		}
		
		
		return false;
		
		
	}

}