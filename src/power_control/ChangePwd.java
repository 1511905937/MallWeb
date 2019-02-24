package power_control;

import java.util.HashMap;
import dal.User;

public class ChangePwd extends Action {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		User u=new User();
		String result="0";
		try {
			result=u.change_pwd(Integer.parseInt(m.get("userid")),m.get("oldpwd"),m.get("newpwd"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
