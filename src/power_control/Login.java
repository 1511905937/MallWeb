package power_control;

import java.util.HashMap;

import dal.User;

public class Login extends Action {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		User u=new User();   
		String result="";
	    try {
			result=u.login(m.get("username"), m.get("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
