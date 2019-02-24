package bossmanage;

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

/**
 * Servlet implementation class AddShop
 */
@WebServlet("/AddShop")
public class AddShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShop() {
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
		try (PrintWriter out = response.getWriter()) {

	           
            String shop_name = request.getParameter("shop_name").trim();
            User u=new User();   
    		String result="";
    		HttpSession session=request.getSession(true);
    		int userid=(int)session.getAttribute("userid");
    		//String id=Integer.toString(userid);
    	    try {
    	    	
    			result=u.add_shop(shop_name, Integer.toString(userid));
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
        	out.append(result); 
        	System.out.println("addshop"+result+userid);
        	
        	
           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
