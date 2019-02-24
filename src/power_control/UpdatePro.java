package power_control;

import java.util.HashMap;

import dal.User;

public class UpdatePro extends Action {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		String result="0";
		User u=new User();    
	    try {
		          
	        result=u.update_pro(m.get("pro_name"),m.get("pro_content"),m.get("pro_picture1"),m.get("pro_picture2"),m.get("picture3"),m.get("pro_shop"),m.get("pro_kind"),m.get("price"),m.get("userid"),m.get("proid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
	}

}
