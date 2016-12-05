package homemaking.data;

public class Goods {
	private int id;
	private String name;
	private double price;
	private String des;
	private String img;
	private int isSell;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescribe() {
		return des;
	}
	public void setDescribe(String describe) {
		this.des = describe;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	
	public Goods(String name,double price,String des,int isSell,String img){
		this.name = name;
		this.price = price;
		this.des = des;
		this.isSell = isSell;
		this.img = img;
	}
	public Goods(){
		
	}
}
