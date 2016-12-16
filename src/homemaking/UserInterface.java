package homemaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import homemaking.data.Goods;
import homemaking.data.User;
import homemaking.mapping.UserMapper;

@Controller
public class UserInterface {
	@Resource
	private UserMapper userMapper;
	
	JSONObject ans = null;
	
	@ResponseBody
	@RequestMapping(value="api/user/login",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String login(String username,String password,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findByName(username);
		if(xx == null){
			ans.put("code", 0);
			ans.put("msg","用户名不存在");
		}
		else{
			if(xx.getPassword().equals(password)){
				ans.put("code", 1);
				ans.put("msg","登录成功");
				ans.put("userid", xx.getId());
				session.setAttribute("userid", xx.getId());
				session.setAttribute("username", xx.getUsername());
				session.setAttribute("power", xx.getPower());
			}
			else {
				ans.put("code", 0);
				ans.put("msg","密码错误");
			}
		}
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/regist",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String regist(String username,String password,String img) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findByName(username);
		if(xx != null){
			ans.put("code", 0);
			ans.put("msg","用户名已存在");
			return ans.toString();
		}
		
		User temp = new User(username,password,img);
		userMapper.register(temp);
		ans.put("code", 1);
		ans.put("msg", "注册成功");
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/registByAdmin",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String registByAdmin(String username,String password,String img,int power,int money) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findByName(username);
		if(xx != null){
			ans.put("code", 0);
			ans.put("msg","用户名已存在");
			return ans.toString();
		}
		
		User temp = new User(username,password,img,power,money);
		userMapper.register(temp);
		ans.put("code", 1);
		ans.put("msg", "注册成功");
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/user/fixImg",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String fixImg(String img,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		xx.setImg(img);
		userMapper.fixImg(xx);
		
		ans.put("code", 1);
		ans.put("msg", "修改成功");
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/fixPower",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String fixPower(int id,int power,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(id);
		xx.setPower(power);
		userMapper.fixPower(xx);
		
		ans.put("code", 1);
		ans.put("msg", "修改成功");
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/fixPaypassword",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String fixPaypassword(String loginpassword,String password,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		if(xx.getPassword().equals(loginpassword)){
			xx.setPaypassword(password);
			userMapper.fixPaypassword(xx);
			
			ans.put("code", 1);
			ans.put("msg", "修改成功");
		}
		else {
			ans.put("code", 0);
			ans.put("msg", "修改失败，密码错误");
		}
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/fixPassword",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String fixPassword(String loginpassword,String password,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		if(xx.getPassword().equals(loginpassword)){
			xx.setPassword(password);
			userMapper.fixPassword(xx);
			
			ans.put("code", 1);
			ans.put("msg", "修改成功");
		}
		else {
			ans.put("code", 0);
			ans.put("msg", "修改失败，密码错误");
		}
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/paypassword",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String paypassword(String paypassword,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		if(xx.getPaypassword().equals(paypassword)){
			
			ans.put("code", 1);
			ans.put("msg", "正确");
		}
		else {
			ans.put("code", 0);
			ans.put("msg", "密码错误");
		}
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/logout",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String logout(HttpSession session) throws JSONException{
		ans = new JSONObject();
		session.removeAttribute("userid");
		session.removeAttribute("username");
		session.removeAttribute("power");
		
		ans.put("code", 1);
		ans.put("msg", "退出成功");
		
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<User> ga = userMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(User i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("username",i.getUsername());
			temp.put("password", i.getPassword());
			temp.put("power",i.getPower());
			temp.put("img",i.getImg());
			temp.put("money",i.getMoney());
			gl.put(temp);
		}
		ans.put("user", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/getInfo",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getInfo(HttpSession session) throws JSONException{
		ans = new JSONObject();
		User ga = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		ans.put("code",1);
		
			JSONObject temp = new JSONObject();
			ans.put("id",ga.getId());
			ans.put("username",ga.getUsername());
			ans.put("img",ga.getImg());
			ans.put("money",ga.getMoney());
			ans.put("isSetPay", ga.getPaypassword().isEmpty());
			
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/user/del",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String del(int id) throws JSONException{
		ans = new JSONObject();
		userMapper.del(id);
		
		ans.put("code",1);
		return ans.toString();
	}
}
