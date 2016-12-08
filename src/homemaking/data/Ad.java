package homemaking.data;

public class Ad {
	private int id;
	private String img;
	private String url;
	private int goodsid;
	private String msg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Ad(String img,String url,int goodsid,String msg){
		this.img = img;
		this.url = url;
		this.goodsid = goodsid;
		this.msg = msg;	
	}
	public Ad(){
		
	}
}
