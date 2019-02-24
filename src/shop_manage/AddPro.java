package shop_manage;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileItemFactory;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import dal.User;
import power_control.Action;
import power_control.AllUser;
import power_control.Seller;
import session.Mysession;

/**
 * Servlet implementation class Add_pro
 */
@WebServlet("/AddPro")
public class AddPro extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPro() {
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
        	
        	boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        	// 涓婁紶鏂囦欢鐨勫瓨鍌ㄨ矾寰勶紙鏈嶅姟鍣ㄦ枃浠剁郴缁熶笂鐨勭粷瀵规枃浠惰矾寰勶級  
        	String uploadFilePath = "G:\\eclipse3\\workspace\\mymall\\WebContent\\image\\";//request.getSession().getServletContext().getRealPath("image/");  
        	if (isMultipart) { 
        	FileItemFactory factory = new DiskFileItemFactory();  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            
            String fileName = "";               // 琛ㄥ崟瀛楁鍏冪礌鐨刵ame灞炴�у�� 
            String filedName = "";              //鑾峰彇鏂囦欢鍚嶇О  
            String pro_name ="";
        	String pro_content = "";
        	String pro_picture1 = "";
        	String pro_picture2 ="";
        	String pro_picture3 ="";
        	String pro_shop="";
        	String pro_kind ="";
        	String pro_price =""; 
        	User u=new User();
        	HttpSession session=request.getSession(true);
        	int userid=(int)session.getAttribute("userid");
        	pro_shop=u.findshop(userid);
        	System.out.println("pro_shop"+pro_shop);
            // 瑙ｆ瀽from琛ㄥ崟涓墍鏈夋枃浠�  
            List<FileItem> items = upload.parseRequest(request);  
            Iterator<FileItem> iter = items.iterator();  
            while (iter.hasNext()) {
                FileItem item = (FileItem)iter.next();
                if (item.isFormField()) {  
                	// 鍒ゆ柇锛屾槸鏅�氳〃鍗�  
                    fileName = item.getFieldName();  
                    // 琛ㄥ崟瀛楁鐨刵ame灞炴��  
                    if (fileName.equals("pro_name")) {  
                    	pro_name = item.getString("utf-8");  
                    } else if (fileName.equals("pro_content")) {  
                    	pro_content = item.getString("utf-8");  
                    } else if (fileName.equals("pro_price")) {  
                    	pro_price = item.getString("utf-8");  
                    } else if (fileName.equals("pro_kind")) {  
                    	pro_kind = item.getString("utf-8");  
                    }  
                    System.out.println(pro_name);
                } else {       
                	fileName = item.getFieldName();  
                    if (fileName.equals("pro_picture1")) {  
                        filedName = item.getName();  
                        System.out.println(filedName);
                        if (fileName != null && !filedName.equals("")) {  
                        	try {
                        		 FileUtils.copyInputStreamToFile(item.getInputStream(),new File(uploadFilePath+pro_name+"1.jpg"));  
                        	}
                        	catch(Exception e)
                        	{
                        		System.out.println(e.toString());
                        	}
                        	pro_picture1="image/"+pro_name+"1.jpg";
                        }  
                    } else if (fileName.equals("pro_picture2")) {  
                        filedName = item.getName();  
                        if (fileName != null && !filedName.equals("")) {  
                        	try {
                       		 FileUtils.copyInputStreamToFile(item.getInputStream(),new File(uploadFilePath+pro_name+"2.jpg"));  
                       	}
                       	catch(Exception e)
                       	{
                       		System.out.println(e.toString());
                       	}
                        	pro_picture2="image/"+pro_name+"2.jpg";
                        }  
                    } 
                    else if (fileName.equals("pro_picture3")) {  
                        filedName = item.getName();  
                        if (fileName != null && !filedName.equals("")) {  
                        	try {
                       		 FileUtils.copyInputStreamToFile(item.getInputStream(),new File(uploadFilePath+pro_name+"3.jpg"));  
                       	}
                       	catch(Exception e)
                       	{
                       		System.out.println(e.toString());
                       	}
                        	pro_picture3="image/"+pro_name+"3.jpg";
                        }  
                    } 
                }
            }
          
        	
        //String userid=(String)session.getAttribute("userid");
        	int power_i=2;//(int)session.getAttribute("power");
        	String result="0";
        	
           if(power_i==2)
            {
            	HashMap<String, String> m=new HashMap<String, String>();
            	m.put("pro_name", pro_name);
            	m.put("pro_content", pro_content);
            	m.put("pro_picture1", pro_picture1);
            	m.put("pro_picture2", pro_picture2);
            	m.put("pro_picture3", pro_picture3);
            	m.put("pro_shop", pro_shop);
            	m.put("pro_kind", pro_kind);
            	m.put("pro_price", pro_price);
            	Seller person2=new Seller(power_i);
            	Action obj=person2.addpro();
            	result=obj.action(m);
            }
           System.out.println(result);
           out.append("<script>娣诲姞鎴愬姛锛�</script>");
           response.sendRedirect("addproduct.jsp");
            }
        	/*System.out.println("1");
        	String pro_name = request.getParameter("pro_name").trim();
        	String pro_content = request.getParameter("pro_content").trim();
        	String pro_picture1 = request.getParameter("pro_picture1").trim();
        	String pro_picture2 = request.getParameter("pro_picture2").trim();
        	String pro_picture3 = request.getParameter("pro_picture3").trim();
        	/*String pro_shop = request.getParameter("pro_shop").trim();
        	String pro_kind = request.getParameter("pro_kind").trim();
        	String pro_price = request.getParameter("pro_price").trim();
        	 System.out.println(pro_picture1);
        	
        	ServletContext servletContext = this.getServletConfig().getServletContext();
        	String realPath = servletContext.getRealPath(UPLOAD_DIR)+"/";//鑾峰彇鐩稿璺緞
            String fileName = "test.jpg";//淇濆瓨涓轰粈涔堝悕瀛�
            String filePath = realPath+fileName;
           
            File realPathFile = new File(realPath);
            if (!realPathFile.exists()) {
                realPathFile.mkdirs();
            }

            //璇诲啓閮ㄥ垎
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            //浼犵粰椤甸潰鐨勮緭鍑烘祦
            ServletInputStream sis = request.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;;
            while ((len=sis.read(b))!=-1) {
                fos.write(b, 0, len);
            }

            //鍏抽棴
            fos.close();
            sis.close();
        	
        	
        	String sessionid=request.getHeader("cookie");
        	HttpSession session = Mysession.getSession(sessionid);
        	
        	String userid=(String)session.getAttribute("userid");
        	int power_i=2;//(int)session.getAttribute("power");
        	String result="0";
        	
           if(power_i==2)
            {
            	HashMap<String, String> m=new HashMap<String, String>();
            	m.put("pro_name", pro_name);
            	m.put("pro_content", pro_content);
            	m.put("pro_picture1", pro_picture1);
            	m.put("pro_picture2", pro_picture2);
            	m.put("pro_picture3", pro_picture3);
            	m.put("pro_shop", pro_shop);
            	m.put("pro_kind", pro_kind);
            	m.put("pro_shop", pro_price);
            	Seller person2=new Seller(power_i);
            	Action obj=person2.addpro();
            	result=obj.action(m);
            }
           
           out.append(result);*/ 
          
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}