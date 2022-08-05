package book.vo;

public class Book {
	private String bisbn;
	private String btitle;
	private int bprice;
	private String bauthor;
	private String bimgurl;
	
	public Book() {
		
	}
	
	public Book(String bisbn, String btitle, int bprice, String bauthor, String bimgurl) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.bimgurl = bimgurl;
	}

	public String getBisbn() {
		return bisbn;
	}
	public void setBsibn(String bisbn) {
		this.bisbn = bisbn;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBimgurl() {
		return bimgurl;
	}
	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}
}
