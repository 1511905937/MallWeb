package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserMsg
 */
@WebServlet("/UserMsg")
public class UserMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMsg() {
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
			 HttpSession session=request.getSession(true);
				net.sf.json.JSONArray jsonArray=new net.sf.json.JSONArray();
				
				if(session.getAttribute("username")!=null)
				{
					String username=(String)session.getAttribute("username");
					int userid=(int)session.getAttribute("userid");
					int power=(int)session.getAttribute("power");
					
					jsonArray.add(username);
					jsonArray.add(power);
					jsonArray.add(userid);
					out.append(jsonArray.toString()); 
				}
				else
				{
					out.append("-1");
				}
				
				System.out.println("session"+jsonArray.toString());
		 }
	}

}
