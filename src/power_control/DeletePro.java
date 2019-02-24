package power_control;

import java.util.HashMap;

import dal.User;

public class DeletePro extends Action  {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		 User u=new User();    
		 String result="0";
	     try {
		          
	        result=u.delete_pro(Integer.parseInt(m.get("proid")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
	}

}
