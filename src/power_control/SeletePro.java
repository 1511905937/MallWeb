package power_control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dal.User;
import model.Productinfo;

public class SeletePro extends Action {

	@Override
	public String action(HashMap<String, String> m) {
		// TODO Auto-generated method stub
		String result="0";
		ProList l=new ProList(m);
		
		Seletepro_Interator i=l.createList();
		net.sf.json.JSONArray jsonArray=new net.sf.json.JSONArray(); //= net.sf.json.JSONArray.fromObject(p);
		while(!i.isLast())
		{
			Productinfo o=new Productinfo();
			o=(Productinfo) i.current();
			jsonArray.add(o);
			i.next();
		}
     //   net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(p);
      
    	result=jsonArray.toString(); 
    	return result;
	}

}

