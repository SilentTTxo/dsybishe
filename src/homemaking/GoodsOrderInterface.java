package homemaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.server.UID;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import homemaking.data.Goods;
import homemaking.data.GoodsOrder;
import homemaking.data.GoodsOrder2GoodsView;
import homemaking.data.GoodsOrderView;
import homemaking.data.State;
import homemaking.data.User;
import homemaking.mapping.GoodsMapper;
import homemaking.mapping.GoodsOrder2GoodsViewMapper;
import homemaking.mapping.GoodsOrderMapper;
import homemaking.mapping.GoodsOrderViewMapper;
import homemaking.mapping.UserMapper;

@Controller
public class GoodsOrderInterface {
	@Resource
	private GoodsOrderMapper goodsOrderMapper;
	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private GoodsOrderViewMapper goodsOrderViewMapper;
	@Resource
	private GoodsOrder2GoodsViewMapper goodsOrder2GoodsViewMapper;
	
	JSONObject ans = null;
	
	private String stateInt2Str(int state){
		String temp = "";
		if(state == -1) temp =  "del";
		if(state == -2) temp =  "invalid";
		if(state == 0) temp =  "confirm";
		if(state == 1) temp =  "ready";
		if(state == 2) temp =  "haspay1";
		if(state == 3) temp =  "haspay2";
		if(state == 4) temp =  "hasdone";
		return temp;
	}
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAll() throws JSONException{
		ans = new JSONObject();
		List<GoodsOrderView> ga = goodsOrderViewMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrderView i : ga){
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("tprice", i.getTprice());
			temp.put("sum",i.getSum());
			temp.put("goodsname",i.getGoodsname());
			temp.put("username",i.getUsername());
			temp.put("state",i.getState());
			
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getPayAll",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getPayAll() throws JSONException{
		ans = new JSONObject();
		List<GoodsOrderView> ga = goodsOrderViewMapper.findAll();
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrderView i : ga){
			if(!i.getOrdertype().equals("充钱")) continue;
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("tprice", i.getTprice());
			temp.put("sum",i.getSum());
			temp.put("goodsname",i.getGoodsname());
			temp.put("username",i.getUsername());
			temp.put("state",i.getState());
			
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getById(int id) throws JSONException{
		ans = new JSONObject();
		GoodsOrder ga = goodsOrderMapper.findById(id);
		if(ga==null){
			ans.put("code",0);
			ans.put("msg","no such a order");
			return ans.toString();
		}
		ans.put("code",1);

			JSONObject temp = new JSONObject();
			ans.put("order_id",ga.getId());
			ans.put("order_ordertype",ga.getOrdertype());
			ans.put("order_price", ga.getPrice());
			ans.put("order_tprice", ga.getTprice());
			ans.put("order_sum",ga.getSum());
			ans.put("order_goods",ga.getGoods());
			ans.put("order_uid",ga.getUid());
			ans.put("order_state",ga.getState());
			
			Goods i = goodsMapper.findById(ga.getGoods());
			ans.put("goods_name",i.getName());
			ans.put("goods_goodstype",i.getGoodstype());
			ans.put("goods_address",i.getAddress());
			ans.put("goods_sex",i.getSex());
			ans.put("goods_age",i.getAge());
			ans.put("goods_img",i.getImg());
			ans.put("goods_des",i.getDes());
			ans.put("goods_tel",i.getTel());
			
			User y = userMapper.findById(ga.getUid());
			ans.put("user_img",y.getImg()==null?"":y.getImg());
			ans.put("user_username",y.getUsername());
			ans.put("user_money",y.getMoney());
			
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getUserOrder",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getUserOrder(HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		List<GoodsOrder2GoodsView> ga = goodsOrder2GoodsViewMapper.findByUser(uid);
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrder2GoodsView i : ga){
			if(i.getGoods() == 1) continue;
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("sumprice",i.getSum());
			temp.put("goods",i.getGoods());
			temp.put("uid",i.getUid());
			temp.put("state",stateInt2Str(i.getState()));
			temp.put("tprice", i.getTprice());
			temp.put("goodsname", i.getGoodsname());
			temp.put("goodsphone", i.getPrice());
			temp.put("goodsimg", i.getGoodsimg());
			temp.put("goodstype", i.getGoodstype());
			
			gl.put(temp);
		}
		ans.put("goods", gl);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getUserOrderByState",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getUserOrderByType(int state,HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		List<GoodsOrder2GoodsView> ga = goodsOrder2GoodsViewMapper.findByUser(uid);
		ans.put("code",1);
		JSONArray gl = new JSONArray();
		for(GoodsOrder2GoodsView i : ga){
			if(i.getState() != state) continue;
			JSONObject temp = new JSONObject();
			temp.put("id",i.getId());
			temp.put("ordertype",i.getOrdertype());
			temp.put("price", i.getPrice());
			temp.put("sumprice",i.getSum());
			temp.put("goods",i.getGoods());
			temp.put("uid",i.getUid());
			temp.put("state",stateInt2Str(i.getState()));
			temp.put("tprice", i.getTprice());
			temp.put("goodsname", i.getGoodsname());
			temp.put("goodsphone", i.getPrice());
			temp.put("goodsimg", i.getGoodsimg());
			temp.put("goodstype", i.getGoodstype());
			
			
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
	public String state(int id,String state) throws JSONException{
		ans = new JSONObject();
		int data=0;
		if(isNumeric(state)) data = Integer.parseInt(state);
		else{
			String[] str = {"confirm","ready","haspay1","haspay2","hasdone","del","invalid"};
			for(int i=-2;i<5;i++){
				int y=0;
				if(str[i].equals(state)){
					if(i==-2) y=6;
					else if(i==-1) y=5;
					else y=i;
					data = y;
				}
			}
		}
		GoodsOrder goods = goodsOrderMapper.findById(id);
		goods.setState(data);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	/*
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
	}*/
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/pay",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String pay(int id,String payPassword,HttpSession session) throws JSONException{
		ans = new JSONObject();
		User xx = userMapper.findById(Integer.parseInt(session.getAttribute("userid").toString()));
		GoodsOrder goods = goodsOrderMapper.findById(id);
		if(!xx.getPaypassword().equals(payPassword)){
			ans.put("code",0);
			ans.put("msg","支付密码错误");
			return ans.toString();
		}
		if(xx.getMoney() < goods.getTprice()){
			ans.put("code",0);
			ans.put("msg","余额不足");
			return ans.toString();
		}
		
		if(goods.getState() != 0){
			ans.put("code",0);
			ans.put("msg","该订单并非等待支付状态");
			return ans.toString();
		}
		goods.setState(goods.getState()+2);
		goodsOrderMapper.state(goods);
		xx.setMoney(xx.getMoney() - goods.getTprice());
		userMapper.fixMoney(xx);
		
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
		goods.setState(-1);
		goodsOrderMapper.state(goods);
		
		ans.put("code",1);
		return ans.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/getAllSum",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getAllSum(HttpSession session) throws JSONException{
		ans = new JSONObject();
		int uid = Integer.parseInt(session.getAttribute("userid").toString());
		List<State> data = goodsOrderMapper.findByStateCount(uid);
		ans.put("code",1);
		String[] str = {"confirm","ready","haspay1","haspay2","hasdone","del","invalid"};
		for (State i : data){
			int ss = i.getState();
			if(ss == -1 ){
				ss +=6;
			}
			if(ss == -2){
				ss +=8;
			}
			ans.put(str[ss]+"",i.getSum());
		}
		for(int i=0;i<7;i++){
			if(i == 1) continue;
			if(!ans.has(str[i])){
				ans.put(str[i], 0);
			}
		}
		
		return ans.toString();
	}
	@ResponseBody
	@RequestMapping(value="api/goodsOrder/del",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String del(int id) throws JSONException{
		ans = new JSONObject();
		goodsOrderMapper.del(id);
		
		ans.put("code",1);
		return ans.toString();
	}
	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("^-?[0-9]+"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}
