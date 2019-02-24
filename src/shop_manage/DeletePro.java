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

import dal.User;
import power_control.Action;
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class Delete_pro
 */
@WebServlet("/DeletePro")
public class DeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePro() {
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
		String pro_id= request.getParameter("pro_id").trim();
    	
		HttpSession session=request.getSession(true);
    	
    	int power=(int)session.getAttribute("power");
    	System.out.println(power);
    	String result="0";
    	
       if(power==2)
        {
        	HashMap<String, String> m=new HashMap<String, String>();
        	m.put("proid", pro_id);
        	Seller person2=new Seller(power);
        	Action obj=person2.Deletepro();
        	result=obj.action(m);
        }
       
       System.out.println("delete:"+result);
       out.append(result); 
    	//response.getWriter().append(result.toString()); 
		}
	}

}
