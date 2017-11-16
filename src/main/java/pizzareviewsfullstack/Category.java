package pizzareviewsfullstack;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageURL;

	@OneToMany(mappedBy = "category")
	Set<PizzaReview> pizzaReviews;

	public Category() {

	}

	public Category(String name, String imageURL) {
		this.name = name;
		this.imageURL = imageURL;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<PizzaReview> getPizzaReviews() {
		return pizzaReviews;
	}

	public String getImageURL() {
		return imageURL;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", imageURL=" + imageURL + ", pizzaReviews=" + pizzaReviews
				+ "]";
	}

}
