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
import homemaking.data.Notice;
import homemaking.mapping.AdMapper;
import homemaking.mapping.NoticeMapper;

@Controller
public class NoticeInterface {
	@Resource
	private NoticeMapper noticeMapper;
	
	JSONObject ans = null;
	
	@ResponseBody
	@RequestMapping(value="api/notice/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<Notice> ga = noticeMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Notice i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("title",i.getTitle());
			temp.put("describe", i.getNdescribe());
			temp.put("type",i.getType());
			temp.put("time",i.getNtime());
			temp.put("url",i.getUrl());
			gl.put(temp);
		}
		ans.put("notice", gl);
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/notice/add",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String add(String title,String describe,String type,String time,String url) throws JSONException{
		ans = new JSONObject();
		Notice ad = new Notice(title, describe, time, url, type);
		noticeMapper.add(ad);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/notice/del",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String del(int id) throws JSONException{
		ans = new JSONObject();
		noticeMapper.del(id);
		
		ans.put("code",1);
		return ans.toString();
	}
	
}
