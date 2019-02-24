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

import model.Productinfo;
import dal.User;

/**
 * Servlet implementation class Kind
 */
@WebServlet("/Kind")
public class Kind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kind() {
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

        	String kind = request.getParameter("kind").trim();
        	System.out.println(kind);
            User u=new User();    //ʵ�����û���
            List<Productinfo> p=new ArrayList<Productinfo>();    
            try {
				p=u.Kind(kind); 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(p);
          
            out.print(jsonArray);
          
        }
	}

}
