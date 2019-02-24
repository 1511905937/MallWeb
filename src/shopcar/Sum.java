package shopcar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import session.Mysession;

/**
 * Servlet implementation class Sum
 */
@WebServlet("/Sum")
public class Sum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sum() {
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
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
        	
        	String sum = request.getParameter("sum").trim();
        	String sessionid=request.getHeader("cookie");
        	
            User u=new User();    
            HttpSession session = Mysession.getSession(sessionid);
          
             int userid=(int)session.getAttribute("userid");
	      
	       
            String p="0";
            try {
            	 
				p=u.sum(userid,sum);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
           
            out.append(p);
           System.out.println(p);
          
        }
	}
	

}
