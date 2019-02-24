package user;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import power_control.Action;
import power_control.AllUser;
import power_control.Seller;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		//// TODO Auto-generated method stub
		doGet(request, response);
		    response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");

	        try (PrintWriter out = response.getWriter()) {

	           
	            String username = request.getParameter("username").trim();
	            String password = request.getParameter("password").trim();
	            String power = "0";//request.getParameter("power").trim();
	            System.out.println(power);
	            String result="0";         
	            int power_i=0;
	            
	            power_i=Integer.parseInt(power);
	            if(power_i==1)
	            {
	            	HashMap<String, String> m=new HashMap<String, String>();
	            	m.put("username", username);
	            	m.put("password", password);
	            	m.put("power",power);
	            	AllUser person1=new AllUser(power_i);
	            	Action obj=person1.register();
	            	result=obj.action(m);
	            	
	            }	
	            else if(power_i==2)
	            {
	            	HashMap<String, String> m=new HashMap<String, String>();
	            	m.put("username", username);
	            	m.put("password", password);
	            	m.put("power",power);
	            	Seller person2=new Seller(power_i);
	            	Action obj=person2.register();
	            	result=obj.action(m);
	            }

	            out.append(result);   
	            System.out.println("register:"+result);
	        }
	}

}
