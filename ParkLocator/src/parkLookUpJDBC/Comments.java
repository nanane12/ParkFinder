package parkLookUpJDBC;

public class Comments {
	
	private int commentId;
	private String ChildAge;
	private String rating;
	private String freeText;
	private int park_id;
	
	public Comments (int commentId, String ChildAge, String rating, String freeText, int park_id){
		this.commentId=commentId;
		this.ChildAge=ChildAge;
		this.rating=rating;
		this.freeText=freeText;
		this.park_id=park_id;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getChildAge() {
		return ChildAge;
	}
	public void setChildAge(String childAge) {
		ChildAge = childAge;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFreeText() {
		return freeText;
	}
	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}
	public int getPark_id() {
		return park_id;
	}
	public void setPark_id(int park_id) {
		this.park_id = park_id;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" +commentId + ", ChildAge=" + ChildAge + ", rating=" + rating + ", freeText=" + freeText
				+ ", park_id=" + park_id + "]";
	}
}
