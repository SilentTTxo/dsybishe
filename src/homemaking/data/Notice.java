package homemaking.data;

public class Notice {
	private int id;
	private String title;
	private String ndescribe;
	private String ntime;
	private String type;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNdescribe() {
		return ndescribe;
	}
	public void setNdescribe(String ndescribe) {
		this.ndescribe = ndescribe;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Notice(String title,String ndescribe,String ntime,String url,String type){
		this.ndescribe = ndescribe;
		this.ntime = ntime;
		this.title = title;
		this.type = type;
		this.url = url;
	}
	public Notice(){
		
	}
}
