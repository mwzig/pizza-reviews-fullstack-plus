package pizzareviewsfullstack;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	Long id;
	String name;

	@ManyToMany(mappedBy = "tags")
	private Set<PizzaReview> taggedPizzaReviews;

	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<PizzaReview> getTaggedPizzaReviews() {
		return taggedPizzaReviews;
	}

	public int getTaggedPizzaReviewsSize() {
		return taggedPizzaReviews.size();
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", taggedPizzaReviews=" + taggedPizzaReviews + "]";
	}

}
