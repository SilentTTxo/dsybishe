package homemaking.data;

public class User {
	private int id;
	private String username;
	private String password;
	private int power;
	private double money;
	private String img;
	private String paypassword;
	public int getId() {
		return id;
	}
	public String getPaypassword() {
		return paypassword;
	}
	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username,String password,String img){
		this.username = username;
		this.password = password;
		this.img = img;
		power = -1;
		money = 0;
		paypassword = "";
	}
	public User(String username,String password,String img,int power,int money){
		this.username = username;
		this.password = password;
		this.img = img;
		this.power = power;
		this.money = money;
		paypassword = "";
	}
	public User(){
		
	}
	
}
