package homemaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import homemaking.data.User;
import homemaking.mapping.UserMapper;

@Controller
public class WebInterface {
	@Resource
	private UserMapper userMapper;
	
	JSONObject ans = null;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView index(){   
        ModelAndView modelAndView = new ModelAndView();    
        modelAndView.setViewName("login");  
        return modelAndView;
    }
	
	public String upload(@RequestParam(value = "file", required = false)MultipartFile file,HttpServletRequest request, ModelMap model){
		System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {
            e.printStackTrace(); 
            return "error"; 
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
  
        return "ok";  
	}
}
