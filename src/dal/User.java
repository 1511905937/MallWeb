package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Evaluateinfo;
import model.Productinfo;
import net.sf.json.JSONArray;
import conn.Sql;



public class User {
	  public int getid(String name,String pwd) throws SQLException, ClassNotFoundException
	  {
		String sql="select * from user where user_name='"+name+"' and user_pwd='"+pwd+"'";
		Sql s=new Sql();
		ResultSet rs=s.select(sql);
		while(rs.next()) {
			return rs.getInt("user_id");
			
		}
		   return 0;
	  }
	  public String findshop(int userid) throws SQLException, ClassNotFoundException
	  {
		String sql="select shop_name from shop where shop_owner_id="+userid+"";
		Sql s=new Sql();
		ResultSet rs=s.select(sql);
		while(rs.next()) {
			return rs.getString("shop_name");
			
		}
		   return "0";
	  }
	
		public String login(String name,String pwd) throws SQLException, ClassNotFoundException
		{
			String sql="select * from user where user_name='"+name+"' and user_pwd='"+pwd+"'";
			Sql s=new Sql();
			ResultSet rs=s.select(sql);
			while(rs.next()) {
				 
				
					return "1";    
				   
			}
			return "0";    //锟斤拷录失锟斤拷
		}
		public String register(String name,String pwd,String role) throws ClassNotFoundException 
		{
			int result=0;
			String sql="insert into user values(null,'"+name+"','"+pwd+"','"+role+"')";
			Sql s=new Sql();
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "2";
		}
		public List<Productinfo> index() throws ClassNotFoundException, SQLException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products order by pro_sale asc";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					info.setPro_id(rs.getInt("pro_id"));
					info.setPro_name(rs.getString("pro_name"));
					info.setPro_kind(rs.getString("pro_kind"));
					info.setPro_content(rs.getString("pro_content"));
					info.setPro_picture1(rs.getString("pro_picture1"));
					info.setPro_picture2(rs.getString("pro_picture2"));
					info.setPro_picture3(rs.getString("pro_picture3"));
					info.setPro_sale(rs.getInt("pro_sale"));
					info.setPro_shop(rs.getString("pro_shop"));
					info.setPro_price(rs.getString("pro_price"));
					list.add(info);
				}
			
			return list;
		}
		public List<Productinfo> Kind(String kind) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products  order by pro_sale asc ";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					if(rs.getString("pro_kind").equals(kind))
					{
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture1"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getString("pro_shop"));
						info.setPro_price(rs.getString("pro_price"));
						list.add(info);
					}
					
				}
				
			
			return list;
		}
		public List<Productinfo> shopcar(int id) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from shopcar,products where shopcar_userid="+id+" and shopcar.shopcar_proid=products.pro_id";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					//if(rs.getString("shopcar_userid").equals(id))
					//{
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture1"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getString("pro_shop"));
						info.setPro_price(rs.getString("pro_price"));
						list.add(info);
				//	}
					
				}
				
			
			return list;
		}
		public String add_to_car(int userid,int pro_id) throws ClassNotFoundException 
		{
			
			String sql="insert into shopcar values(null,"+userid+","+pro_id+")";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "0";
		}
		public String add_pro(String name,String content,String picture1,String picture2,String picture3,String shop,String kind,String price) throws ClassNotFoundException 
		{
			
			String sql="insert into products values(null,'"+name+"','"+content+"','"+picture1+"','"+picture2+"','"+picture3+"',null,'"+shop+"','"+kind+"','"+price+"')";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "0";
		}
		public String update_pro(String name,String content,String picture1,String picture2,String picture3,String shop,String kind,String price,String proid,String userid)throws ClassNotFoundException 
		{
			
			String sql="update products set pro_name='"+name+"' ,pro_content='"+content+"' ,pro_picture1='"+picture1+"',pro_picture2='"+picture2+"',pro_picture3='"+picture3+"',pro_kind='"+kind+"',pro_price='"+price+"' where proid='"+proid+"' and pro_shop = (select shop_id from shop where shop_owner_id='"+userid+"')";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "0";
		}
		public String change_pwd(int userid,String oldpwd,String newpwd) throws ClassNotFoundException 
		{
			
			String sql="update user set user_pwd='"+newpwd+"' where user_id="+userid+" and user_pwd='"+oldpwd+"'";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "0";
		}
		public List<Productinfo> shop(int userid) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products where pro_shop = (select shop_name from shop where shop_owner_id="+userid+")";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture2"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getString("pro_shop"));
						info.setPro_price(rs.getString("pro_price"));
						list.add(info);
					
				}
				
			return list;
		}
		public String delete_pro(int pro_id) throws ClassNotFoundException 
		{
			
			String sql="delete from products where pro_id="+pro_id+"";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //锟斤拷锟斤拷晒锟�
			{
				return "1";
			}
			else                //锟斤拷锟斤拷失锟斤拷
			    return "0";
		}
		public List<Productinfo> pro_detail(int proid) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products where pro_id="+proid+"";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next()) 
				{
					Productinfo info =new Productinfo ();
					
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture2"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getString("pro_shop"));
						info.setPro_price(rs.getString("pro_price"));
						list.add(info);
					
				}
				
			
			return list;
		}
		public List<Evaluateinfo> evaluate(int proid) throws SQLException, ClassNotFoundException{
			List<Evaluateinfo> list=new ArrayList<Evaluateinfo>();
			String sql="select evaluate_content,user_name  from evaluate,user where evaluate_pro="+proid+" and evaluate.user_id=user.user_id";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Evaluateinfo info =new Evaluateinfo ();
					
						
						//info.setEvaluate_id(rs.getInt("evaluate_id"));
						info.setUser_name(rs.getString("user_name"));
						info.setEvaluate_content(rs.getString("evaluate_content"));
						//info.setEvaluate_picture1(rs.getString("evaluate_picture1"));
						//info.setEvaluate_pro(rs.getInt("evaluate_pro"));
						
						list.add(info);
					
				}
				
			
			return list;
		}
		public String sum(int userid,String sum) throws ClassNotFoundException  //缁撶畻
		{
			 JSONArray pro=JSONArray.fromObject(sum);
			System.out.println(pro.toString());
			 for (int i = 0; i < pro.size(); i++) {
				
				 int pro_id=(int)pro.get(i);
				
				 String sql="delete from shopcar where shopcar_proid="+pro_id+"";
				 Sql s=new Sql();
				int result=0;
				result=s.update(sql);
				if(result!=1)       //锟斤拷锟斤拷晒锟�
				{
					return "0";
				}
				
				   
			 } 
			return "1";
			
		}
		public String add_shop(String name,String userid) throws ClassNotFoundException 
		{
			int result=0;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String sql="insert into shop values('"+name+"','"+userid+"','"+df.format(new Date())+"')";
			Sql s=new Sql();
			result=s.update(sql);
			if(result==1)     
			{
				return "1";
			}
			else                
			    return "2";
		}
}
