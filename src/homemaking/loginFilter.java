package homemaking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

public class loginFilter implements Filter {  
	  
    @Override  
    public void destroy() {  
          
  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
          
            HttpServletRequest req = (HttpServletRequest)request;  
            HttpServletResponse res = (HttpServletResponse)response;  
            //基于http协议的servlet  
              
            //如果没有登录.  
            String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/",1),req.getRequestURI().length());  
            String[] allowUrl = {"/api/user/regist","/api/user/login","/servlet/AuthImageServlet","/api/goods/searchByType","/api/goods/getType","/api/goods/getAll","/api/goods/searchByName"};
            boolean key = true;
            for (String str : allowUrl) {
				if(str.equals(requestURI)) key=false;
			}
            //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面就不去检查.  
            if(key)  
            {  
            	JSONObject ans = new JSONObject();
                //取得session. 如果没有session则自动会创建一个, 我们用false表示没有取得到session则设置为session为空.  
                HttpSession session = req.getSession(false);  
                //如果session中没有任何东西.  
                if(session == null ||session.getAttribute("userid")==null)  
                {  
                	res.setCharacterEncoding("UTF-8");
                	res.setContentType("application/json; charset=utf-8");
                	try {
						ans.put("code", 3);
						ans.put("msg", "Please login");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	PrintWriter out = response.getWriter();
                	out.write(ans.toString());  
                    //返回  
                    return;  
                }  
                  
            }  
            //session中的内容等于登录页面, 则可以继续访问其他区资源.  
            chain.doFilter(req, res);  
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}  
}
