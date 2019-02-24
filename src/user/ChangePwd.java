package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import power_control.Action;
import power_control.AllUser;
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class ChangePwd
 */
@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwd() {
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
    	String oldpwd = request.getParameter("oldpwd").trim();
    	String newpwd = request.getParameter("newpwd").trim();
    	String sessionid=request.getHeader("cookie");
    	HttpSession session = Mysession.getSession(sessionid);
        try (PrintWriter out = response.getWriter()) {
        	
            String userid=(String)session.getAttribute("userid");
        	int power_i=(int)session.getAttribute("power");
        	String result="0";
            if(power_i==1)
            {
            	HashMap<String, String> m=new HashMap<String, String>();
            	m.put("oldpwd", oldpwd);
            	m.put("newpwd", newpwd);
            	m.put("userid", userid);
            	AllUser person1=new AllUser(power_i);
            	Action obj=person1.login();
            	result=obj.action(m);
            	
            }	
            else if(power_i==2)
            {
            	HashMap<String, String> m=new HashMap<String, String>();
            	m.put("oldpwd", oldpwd);
            	m.put("newpwd", newpwd);
            	m.put("userid", userid);
            	Seller person2=new Seller(power_i);
            	Action obj=person2.login();
            	result=obj.action(m);
            }
        
        out.append(result);
        }
	}

}
