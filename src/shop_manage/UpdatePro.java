package shop_manage;

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
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class UpdatePro
 */
@WebServlet("/UpdatePro")
public class UpdatePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try (PrintWriter out = response.getWriter()) {
			String pro_name = request.getParameter("pro_name").trim();
        	String pro_content = request.getParameter("pro_content").trim();
        	String pro_picture1 = request.getParameter("pro_picture1").trim();
        	String pro_picture2 = request.getParameter("pro_picture2").trim();
        	String pro_picture3 = request.getParameter("pro_picture3").trim();
        	String pro_kind = request.getParameter("pro_kind").trim();
        	String pro_price = request.getParameter("pro_price").trim();
			String pro_id= request.getParameter("pro_id").trim();
	    	
	    	String sessionid=request.getHeader("cookie");
	    	HttpSession session = Mysession.getSession(sessionid);
	    	
	    	String userid=(String)session.getAttribute("userid");
	    	int power_i=(int)session.getAttribute("power");
	    	String result="0";
	    	
	       if(power_i==2)
	        {
	        	HashMap<String, String> m=new HashMap<String, String>();
	        	m.put("pro_name", pro_name);
            	m.put("pro_content", pro_content);
            	m.put("pro_picture1", pro_picture1);
            	m.put("pro_picture2", pro_picture2);
            	m.put("pro_picture3", pro_picture3);
            	m.put("pro_kind", pro_kind);
            	m.put("pro_shop", pro_price);
	        	m.put("proid", pro_id);
	        	m.put("userid", userid);
	        	Seller person2=new Seller(power_i);
	        	Action obj=person2.updatepro();
	        	result=obj.action(m);
	        }
	       
	      
	       out.append(result); 
	    	//response.getWriter().append(result.toString()); 
			}
	}

}
