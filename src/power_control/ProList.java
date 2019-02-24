package power_control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import dal.User;
import model.Productinfo;

public class ProList implements ListP {

	private List<Productinfo> p=new ArrayList<Productinfo>();
	
	
	public ProList(HashMap<String, String> m) {
		// TODO Auto-generated constructor stub
		User u=new User();    
	     
	    try {
	    	p=u.shop(Integer.parseInt(m.get("userid")));
			                                                                                                                                                                                                                                                                    
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Seletepro_Interator createList() {
		// TODO Auto-generated method stub
		return new Iter();
	}
	
	private class Iter implements Seletepro_Interator{

		private int currentIndex=0;
		
		@Override
		public void next() {
			// TODO Auto-generated method stub
			if(currentIndex<p.size())
			{
				currentIndex++;
			}
		}

		@Override
		public void previous() {
			// TODO Auto-generated method stub
			if(currentIndex>0)
			{
				currentIndex--;
			}
		}

		@Override
		public boolean isLast() {
			// TODO Auto-generated method stub
			return currentIndex==p.size();
		}


		@Override
		public boolean isFirst() {
			// TODO Auto-generated method stub
			return currentIndex==0;
		}

		@Override
		public Object current() {
			// TODO Auto-generated method stub
			return p.get(currentIndex);
		}
		
	}

}
