package homemaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.server.UID;
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
import homemaking.mapping.GoodsMapper;
import homemaking.mapping.GoodsOrderMapper;

@Controller
public class GoodsOrderInterface {
	@Resource
	private GoodsOrderMapper goodsOrderMapper;
	@Resource
	private GoodsMapper goodsMapper;
	
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
			temp.put("tprice", i.getTprice());
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/add",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String add(String orderType,int sum,int goods,int uid) throws JSONException{
		ans = new JSONObject();
		double price = goodsMapper.findById(goods).getPrice();
		GoodsOrder goodsOrder = new GoodsOrder(orderType, price, sum, goods,uid,price*sum);
		goodsOrderMapper.add(goodsOrder);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/addByUser",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String addByUser(String orderType,int sum,int goods,HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		double price = goodsMapper.findById(goods).getPrice();
		String tel = goodsMapper.findById(goods).getTel();
		double tprice = price * sum;
		GoodsOrder goodsOrder = new GoodsOrder(orderType, price, sum, goods,uid,tprice);
		goodsOrderMapper.add(goodsOrder);
		
		ans.put("code",1);
		ans.put("tel", tel);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/state",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String state(int id,int state) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		goods.setState(state);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/check",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String check(int id) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		if(goods.getState() != 0){
			ans.put("code",0);
			ans.put("msg","该订单并非等待确认状态");
			return ans.toString();
		}
		goods.setState(goods.getState()+1);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/pay",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String pay(int id) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		if(goods.getState() != 1){
			ans.put("code",0);
			ans.put("msg","该订单并非等待支付状态");
			return ans.toString();
		}
		goods.setState(goods.getState()+1);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/hasdone",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String hasdone(int id) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		if(goods.getState() != 3){
			ans.put("code",0);
			ans.put("msg","该订单并非等待完成状态");
			return ans.toString();
		}
		goods.setState(goods.getState()+1);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/cancel",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String cancel(int id) throws JSONException{
		ans = new JSONObject();
		GoodsOrder goods = goodsOrderMapper.findById(id);
		if(goods.getState() == 4){
			ans.put("code",0);
			ans.put("msg","该订单已经完成");
			return ans.toString();
		}
		goods.setState(goods.getState()+1);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getAllSum",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAllSum(HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		int confirm = goodsOrderMapper.findByState(0,uid).size();
		int ready = goodsOrderMapper.findByState(1,uid).size();
		int haspay1 = goodsOrderMapper.findByState(2,uid).size();
		int haspay2 = goodsOrderMapper.findByState(3,uid).size();
		int hasdone = goodsOrderMapper.findByState(4,uid).size();
		int del = goodsOrderMapper.findByState(-1,uid).size();
		int invalid = goodsOrderMapper.findByState(-2,uid).size();
		
		
		ans.put("code",1);
		ans.put("confirm",confirm);
		ans.put("ready",ready);
		ans.put("haspay1",haspay1);
		ans.put("haspay2",haspay2);
		ans.put("hasdone",hasdone);
		ans.put("del",del);
		ans.put("invalid",invalid);
		return ans.toString();
	}
}
