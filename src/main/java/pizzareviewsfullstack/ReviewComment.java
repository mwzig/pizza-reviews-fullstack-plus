package pizzareviewsfullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ReviewComment {

	@Id
	@GeneratedValue
	private Long id;
	@Lob
	private String text;

	@ManyToOne
	private PizzaReview review;

	public ReviewComment() {
	}

	public ReviewComment(String text, PizzaReview review) {
		this.text = text;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public PizzaReview getReview() {
		return review;
	}

	@Override
	public String toString() {
		return "ReviewComment [id=" + id + ", text=" + text + ", review=" + review + "]";
	}

}
