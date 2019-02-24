package power_control;

import java.util.HashMap;

import dal.User;

public class AddPro extends Action {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		 User u=new User();    
         String result="0";
         try {
	           result=u.add_pro(m.get("pro_name"),m.get("pro_content"),m.get("pro_picture1"),m.get("pro_picture2"),m.get("pro_picture3"),m.get("pro_shop"),m.get("pro_kind"),m.get("pro_price"));
	
			} catch (Exception e) {
				
				e.printStackTrace();
			}
         return result;
	}

}
