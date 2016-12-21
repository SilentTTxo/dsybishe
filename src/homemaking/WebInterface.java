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
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_user_add",method=RequestMethod.GET)
	public ModelAndView user_add(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_user_add");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_user_power",method=RequestMethod.GET)
	public ModelAndView user_power(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_user_power");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_user_list",method=RequestMethod.GET)
	public ModelAndView user_list(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_user_list");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_goods_add",method=RequestMethod.GET)
	public ModelAndView goods_add(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_goods_add");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_goods_list",method=RequestMethod.GET)
	public ModelAndView goods_list(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_goods_list");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_goods_setmeal",method=RequestMethod.GET)
	public ModelAndView goods_setmeal(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_goods_setmeal");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_goods_setIsSell",method=RequestMethod.GET)
	public ModelAndView goods_setIsSell(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_goods_setIsSell");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_order_add",method=RequestMethod.GET)
	public ModelAndView order_add(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_order_add");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_order_list",method=RequestMethod.GET)
	public ModelAndView order_list(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_order_list");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_order_state",method=RequestMethod.GET)
	public ModelAndView order_state(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_order_state");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_order_serch",method=RequestMethod.GET)
	public ModelAndView order_serch(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_order_serch");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_order_pay",method=RequestMethod.GET)
	public ModelAndView order_pay(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_order_pay");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_ad_add",method=RequestMethod.GET)
	public ModelAndView ad_add(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_ad_add");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_ad_list",method=RequestMethod.GET)
	public ModelAndView ad_list(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_ad_list");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_notice_add",method=RequestMethod.GET)
	public ModelAndView notice_add(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_notice_add");  
        return modelAndView;
    }
	
	@RequestMapping(value="admin_notice_list",method=RequestMethod.GET)
	public ModelAndView notice_list(HttpSession session){ 
		ModelAndView modelAndView = new ModelAndView();    
		if(session.getAttribute("power").toString() != "0"){
			modelAndView.setViewName("login");
			return modelAndView;
		}
        modelAndView.setViewName("admin_notice_list");  
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
