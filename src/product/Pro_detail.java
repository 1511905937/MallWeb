package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.User;
import model.Productinfo;

/**
 * Servlet implementation class Pro_detail
 */
@WebServlet("/Pro_detail")
public class Pro_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pro_detail() {
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

		String pro_id= request.getParameter("pro_id").trim();
    	int proid=Integer.parseInt(pro_id);
        User u=new User();    
        List<Productinfo> p=new ArrayList<Productinfo>(); 
        try {
	          
	         p=u.pro_detail(proid); 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
      
      
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(p);
        
        out.append(jsonArray.toString());

	}
	}

}
