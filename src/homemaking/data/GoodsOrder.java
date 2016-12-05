package homemaking.data;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class GoodsOrder {
	private int id;
	private String ordertype;
	private double price;
	private int sum;
	private int goods;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSumprice() {
		return sum;
	}
	public void setSumprice(double sumprice) {
		this.sum = sum;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public GoodsOrder(String ordertype,double price,int sum,int goods) {
		// TODO Auto-generated constructor stub
		this.ordertype = ordertype;
		this.price = price;
		this.sum = sum;
		this.goods = goods;
		this.state = 0;
	}
	public GoodsOrder(){
		
	}
}
