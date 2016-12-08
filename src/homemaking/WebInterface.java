package homemaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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
	
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public ModelAndView admin(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("error");
			return modelAndView;
		}
        modelAndView.setViewName("admin");  
        return modelAndView;
    }
	
	@ResponseBody
	@RequestMapping(value="api/picUpload",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public String upload(@RequestParam(value = "file", required = false)MultipartFile file,HttpServletRequest request, ModelMap model) throws JSONException{
		System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileNames = file.getOriginalFilename().substring(file.getOriginalFilename().length()-4,file.getOriginalFilename().length());  
        String fileName = new Date().getTime()+fileNames;  
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
        
        ans = new JSONObject();
        ans.put("fileUrl", request.getContextPath()+"/upload/"+fileName);
  
        return ans.toString();  
	}
}
