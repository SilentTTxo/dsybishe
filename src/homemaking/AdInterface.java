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

import homemaking.data.Ad;
import homemaking.mapping.AdMapper;

@Controller
public class AdInterface {
	@Resource
	private AdMapper adMapper;
	
	JSONObject ans = null;
	
	@ResponseBody
	@RequestMapping(value="api/ad/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<Ad> ga = adMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Ad i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("img",i.getImg());
			temp.put("url", i.getUrl());
			temp.put("goodsid",i.getGoodsid());
			temp.put("msg",i.getMsg());
			gl.put(temp);
		}
		ans.put("ad", gl);
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/ad/add",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String add(String img,String url,int goodsid,String msg) throws JSONException{
		ans = new JSONObject();
		Ad ad = new Ad(img, url, goodsid, msg);
		adMapper.add(ad);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/ad/del",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String del(int id) throws JSONException{
		ans = new JSONObject();
		adMapper.del(id);
		
		ans.put("code",1);
		return ans.toString();
	}
	
}
