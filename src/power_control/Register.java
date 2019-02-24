package power_control;

import java.util.HashMap;

import dal.User;

public class Register extends Action {

	private static Register instance=null;
	
	private Register()
	{
		
	}
	
	public static Register getInstance()
	{
		if(instance==null)
			instance=new Register();
		return instance;
	}
	
	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		User u=new User();   
		String result="";
	    try {
			result=u.register(m.get("username"), m.get("password"),m.get("power"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("register2:"+result);
		return result;
	}

}
