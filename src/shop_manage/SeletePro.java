package shop_manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import model.Productinfo;
import power_control.Action;
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class Shop
 */
@WebServlet("/SeletePro")
public class SeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeletePro() {
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
        	int power_i=(int)session.getAttribute("power"); 
        	int userid=(int)session.getAttribute("userid");
        	
        	String result="0";
        
           if(power_i==2)
            {
            	HashMap<String, String> m=new HashMap<String, String>();
            	m.put("userid", Integer.toString(userid));
            	Seller person2=new Seller(power_i);
            	Action obj=person2.seletepro();
            	result=obj.action(m);
            }
            //net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(p);
          
        	//response.getWriter().append(jsonArray.toString()); 
            out.append(result); 
            
        }
	}

}