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
import homemaking.mapping.GoodsMapper;

@Controller
public class GoodsInterface {
	@Resource
	private GoodsMapper goodsMapper;
	
	JSONObject ans = null;
	
	@ResponseBody
	@RequestMapping(value="api/goods/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<Goods> ga = goodsMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Goods i : ga){
			if(i.getGoodstype().equals("套餐")) continue;
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("name",i.getName());
			temp.put("price", i.getPrice());
			temp.put("isSell",i.getIsSell());
			temp.put("goodstype",i.getGoodstype());
			temp.put("address",i.getAddress());
			temp.put("sex",i.getSex());
			temp.put("age",i.getAge());
			temp.put("img",i.getImg());
			temp.put("des",i.getDes());
			temp.put("tel",i.getTel());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/getAllByAdmin",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAllByAdmin() throws JSONException{
		ans = new JSONObject();
		List<Goods> ga = goodsMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Goods i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("name",i.getName());
			temp.put("price", i.getPrice());
			temp.put("isSell",i.getIsSell());
			temp.put("goodstype",i.getGoodstype());
			temp.put("address",i.getAddress());
			temp.put("sex",i.getSex());
			temp.put("age",i.getAge());
			temp.put("img",i.getImg());
			temp.put("des",i.getDes());
			temp.put("tel",i.getTel());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/getType",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getType() throws JSONException{
		ans = new JSONObject();
		List<String> ga = goodsMapper.getType();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		int y=0;
		for(String i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",y);
			temp.put("type", i);
			gl.put(temp);
			y++;
		}
		ans.put("types", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/searchByType",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String searchByType(String type) throws JSONException{
		ans = new JSONObject();
		List<Goods> ga = goodsMapper.searchByType(type);
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Goods i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("name",i.getName());
			temp.put("price", i.getPrice());
			temp.put("isSell",i.getIsSell());
			temp.put("goodstype",i.getGoodstype());
			temp.put("address",i.getAddress());
			temp.put("sex",i.getSex());
			temp.put("age",i.getAge());
			temp.put("img",i.getImg());
			temp.put("des",i.getDes());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/searchByName",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String searchByName(String name) throws JSONException{
		ans = new JSONObject();
		String dname = "%"+name+"%";
		List<Goods> ga = goodsMapper.searchByName(dname);
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(Goods i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("name",i.getName());
			temp.put("price", i.getPrice());
			temp.put("isSell",i.getIsSell());
			temp.put("goodstype",i.getGoodstype());
			temp.put("address",i.getAddress());
			temp.put("sex",i.getSex());
			temp.put("age",i.getAge());
			temp.put("img",i.getImg());
			temp.put("des",i.getDes());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/add",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String add(String name,String price,String des,int isSell,String goodstype,String address,String sex,int age,String tel,String img) throws JSONException{
		ans = new JSONObject();
		Goods goods = new Goods(name, Double.parseDouble(price), des, isSell,goodstype,address,sex,age, img,tel);
		goodsMapper.add(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goods/isSell",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String isSell(int id,int isSell) throws JSONException{
		ans = new JSONObject();
		Goods goods = goodsMapper.findById(id);
		goods.setIsSell(isSell);
		goodsMapper.isSell(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	@ResponseBody
	@RequestMapping(value="api/goods/del",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String del(int id) throws JSONException{
		ans = new JSONObject();
		goodsMapper.del(id);
		
		ans.put("code",1);
		return ans.toString();
	}
}
