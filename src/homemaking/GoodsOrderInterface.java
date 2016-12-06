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
import javax.websocket.Session;

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

import homemaking.data.GoodsOrder;
import homemaking.mapping.GoodsOrderMapper;

@Controller
public class GoodsOrderInterface {
	@Resource
	private GoodsOrderMapper goodsOrderMapper;
	
	JSONObject ans = null;
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<GoodsOrder> ga = goodsOrderMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrder i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("sumprice",i.getSum());
			temp.put("goods",i.getGoods());
			temp.put("uid",i.getUid());
			temp.put("state",i.getState());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getUserOrder",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getUserOrder(HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		List<GoodsOrder> ga = goodsOrderMapper.findByUser(uid);
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrder i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("sumprice",i.getSum());
			temp.put("goods",i.getGoods());
			temp.put("uid",i.getUid());
			temp.put("state",i.getState());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/add",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String add(String orderType,String price,int sum,int goods,int uid) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goodsOrder = new GoodsOrder(orderType, Double.parseDouble(price), sum, goods,uid);
		goodsOrderMapper.add(goodsOrder);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/addByUser",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String addByUser(String orderType,String price,int sum,int goods,HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		GoodsOrder goodsOrder = new GoodsOrder(orderType, Double.parseDouble(price), sum, goods,uid);
		goodsOrderMapper.add(goodsOrder);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/state",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String isSell(int id,int state) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		goods.setState(state);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
}
