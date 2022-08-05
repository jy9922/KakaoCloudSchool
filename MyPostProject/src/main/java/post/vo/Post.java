package post.vo;

public class Post {
	private int bnum;
	private String btitle;
	private String bid;
	private String bdetail;
	private String bdate;
	private int blike;
	private int bview;
	private int bcount;
	
	public Post() {
		
	}
	
	public Post(int bnum, String btitle, String bid, String bdetail, String bdate, int blike, int bview, int bcount) {
		super();
		this.bnum = bnum;
		this.btitle = btitle;
		this.bid = bid;
		this.bdetail = bdetail;
		this.bdate = bdate;
		this.blike = blike;
		this.bview = bview;
		this.bcount = bcount;
	}

	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBdetail() {
		return bdetail;
	}
	public void setBdetail(String bdetail) {
		this.bdetail = bdetail;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}	
	
}


