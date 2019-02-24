package user;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import power_control.Action;
import power_control.AllUser;
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    doGet(request, response);
		    response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");//
	       

	        try (PrintWriter out = response.getWriter()) {

	           
	            String username = request.getParameter("username").trim();
	            String password = request.getParameter("password").trim();
	            String power="1";
	            power = request.getParameter("power").trim();
	            System.out.println(power);   
	            String result="0";         
	            String userid="0";
	            int power_i=1;
	            
	            power_i=Integer.parseInt(power);
	            if(power_i==1)
	            {
	            	HashMap<String, String> m=new HashMap<String, String>();
	            	m.put("username", username);
	            	m.put("password", password);
	            	AllUser person1=new AllUser(power_i);
	            	Action obj=person1.login();
	            	result=obj.action(m);
	            	
	            }	
	            else if(power_i==2)
	            {
	            	HashMap<String, String> m=new HashMap<String, String>();
	            	m.put("username", username);
	            	m.put("password", password);
	            	Seller person2=new Seller(power_i);
	            	Action obj=person2.login();
	            	result=obj.action(m);
	            }
	            User u=new User();  
	            int id=0;
            	//if(result=="1")
    	           id=u.getid(username, password);
	            userid=Integer.toString(id);
	            System.out.println("userid:"+userid);
	            
	        	out.append(result); 
	        	System.out.println(result);
	        	
	        	
	            HttpSession session=request.getSession(true);
	            session.setAttribute("username", username);
	            session.setAttribute("role", result);
	            session.setAttribute("userid",id);
	            session.setAttribute("power",power_i);
	            
	           
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
