package shopcar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import model.Productinfo;
import session.Mysession;

/**
 * Servlet implementation class Shopcar
 */
@WebServlet("/Shopcar")
public class Shopcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopcar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
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
            User u=new User();    
            List<Productinfo> p=new ArrayList<Productinfo>();    
            try {
            	
 	            int id=(int)session.getAttribute("userid");
				p=u.shopcar(id);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(p);
          
            out.print(jsonArray);
            System.out.println(jsonArray.toString());
          
        }
	}

}
