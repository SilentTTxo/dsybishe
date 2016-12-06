package homemaking.data;

public class Goods {
	private int id;
	private String name;
	private double price;
	private String des;
	private String img;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String goodstype;
	private String address;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String sex;
	private int age;
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
	
	public Goods(String name,double price,String des,int isSell,String goodstype,String address,String sex,int age,String img){
		this.name = name;
		this.price = price;
		this.des = des;
		this.isSell = isSell;
		this.goodstype = goodstype;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.img = img;
	}
	public Goods(){
		
	}
}
