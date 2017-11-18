package pizzareviewsfullstack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PizzaReview {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageURL;
	@Lob
	private String content;

	private String address;
	private String website;
	private String date;
	private int rating;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "review")
	Set<ReviewComment> comments;

	@ManyToMany
	private Set<Tag> tags;

	public PizzaReview() {
	}

	public PizzaReview(String title, String imageURL, String content, String address, String website, String date,
			int rating, Category category, Tag... tag) {

		this.title = title;
		this.imageURL = imageURL;
		this.content = content;
		this.address = address;
		this.website = website;
		this.date = date;
		this.rating = rating;
		this.category = category;
		this.tags = new HashSet<Tag>(Arrays.asList(tag));
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void addComment(ReviewComment comment) {
		comments.add(comment);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getContent() {
		return content;
	}

	public String getAddress() {
		return address;
	}

	public String getWebsite() {
		return website;
	}

	public String getDate() {
		return date;
	}

	public int getRating() {
		return rating;
	}

	public Category getCategory() {
		return category;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public Set<ReviewComment> getComments() {
		return comments;
	}

	public int getTagCount() {
		return tags.size();
	}

	public int getCommentCount() {
		return comments.size();
	}

	@Override
	public String toString() {

		String returnString = "PizzaReview [id=" + id + ", title=" + title + ", imageURL=" + imageURL + ", content="
				+ content + ", address=" + address + ", website=" + website + ", date=" + date + ", rating=" + rating
				+ ", category=" + category;

		if (comments.size() > 0) {
			returnString += ", comment(s)=" + comments;
		}

		if (tags.size() > 0) {
			returnString += ", tag(s)=" + tags;
		}

		return returnString;
	}

}
