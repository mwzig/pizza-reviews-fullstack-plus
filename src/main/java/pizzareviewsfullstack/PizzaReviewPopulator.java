package pizzareviewsfullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PizzaReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewCommentRepository commentRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private PizzaReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {

		Tag thinCrust = new Tag("Thin Crust");
		tagRepo.save(thinCrust);

		Tag medCrust = new Tag("Medium Crust");
		tagRepo.save(medCrust);

		Tag thickCrust = new Tag("Thick Crust");
		tagRepo.save(thickCrust);

		Tag woodFired = new Tag("Wood-Fired");
		tagRepo.save(woodFired);

		Tag triangleCut = new Tag("Triangle-Cut");
		tagRepo.save(triangleCut);

		Tag squareCut = new Tag("Square-Cut");
		tagRepo.save(squareCut);

		Tag pepperoni = new Tag("Pepperoni");
		tagRepo.save(pepperoni);

		Category frozen = new Category("Frozen", "../images/googleimages-frozen-pizza-img.jpg");
		categoryRepo.save(frozen);

		Category carryOut = new Category("Carry-Out", "../images/carryoutpizza.jpg");
		categoryRepo.save(carryOut);

		Category restaurant = new Category("Restaurant", "../images/pexels-vegetables-italian-pizza-restaurant.jpg");
		categoryRepo.save(restaurant);

		PizzaReview rev1 = new PizzaReview("Digiorno Rising Crust Pizza", "../images/Digiorno.png",
				"Self-rising crust has big, juicy toppings that are paired with a delicious signature sauce", "",
				"http://www.digiorno.com", "10/27/2017", 3, frozen, medCrust, pepperoni);

		PizzaReview rev2 = new PizzaReview("Freschetta Naturally Rising Crust Pizza", "../images/Freschetta.jpg",
				"The cheesier the better. Mozzarella, cheddar, provolone and parmesan make the 4-Cheese pizza a sure bet on any pizza night.",
				"", "http://www.Freschetta.com", "10/27/2017", 3, frozen, pepperoni);

		PizzaReview rev3 = new PizzaReview("Benny's Pizza", "../images/Bennys.jpg",
				"The best. Always great, dine in or carry out.  Nice crust, tasty sauce, plenty of cheese and good toppings.",
				"Marysville", "http://www.bennyspizza.com", "10/27/2017", 5, restaurant, thinCrust, squareCut,
				pepperoni);

		PizzaReview rev4 = new PizzaReview("Dewey's Pizza", "../images/Deweys.jpg",
				"Delicious pizza made from scratch.  Fast, friendly service. Great dine-in experience. (Carry-out has not been good).",
				"Worthington", "http://www.deweyspizza.com", "10/27/2017", 5, restaurant, triangleCut, thinCrust,
				pepperoni);

		PizzaReview rev5 = new PizzaReview("Panzera's Pizza", "../images/Panzeras.jpg",
				"Great neighborhood pizza maker - consistently delicious pizza.",
				"near Riverside Drive & Fishinger Road, Arlington", "http://uapanzeras-com.webnode.com", "10/27/2017",
				4, carryOut, thinCrust, squareCut, pepperoni);

		PizzaReview rev6 = new PizzaReview("Rotolo's Pizza", "../images/Rotolos.jpg",
				"No-frills branch of a family-owned chain offering pizza, subs & pasta to carry out.",
				"Grandview - 5th Avenue", "http://www.rotolospizza.com/", "10/27/2017", 4, carryOut, pepperoni);

		reviewRepo.save(rev1);
		reviewRepo.save(rev2);
		reviewRepo.save(rev3);
		reviewRepo.save(rev4);
		reviewRepo.save(rev5);
		reviewRepo.save(rev6);

		PizzaReview rev7 = new PizzaReview("LotsOText Pizza", "../images/Rotolos.jpg",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer at mi sed turpis pretium sodales. Curabitur vestibulum sapien ac tellus lobortis, ac interdum ex condimentum. Pellentesque tristique dui eu auctor fringilla. Fusce porta in magna ut ultrices. Donec hendrerit nulla et ullamcorper venenatis. Quisque ullamcorper laoreet dui eu posuere. Duis condimentum odio at justo tristique, quis cursus turpis dapibus. "
						+ "Cras dui arcu, laoreet at erat eget, dictum fermentum lectus. Quisque semper orci non leo rutrum scelerisque eget ut leo. Sed interdum varius leo vel scelerisque. Vestibulum mollis lacinia sem ac imperdiet. Ut tempor pulvinar enim, eget congue sem semper in. Pellentesque at lacinia enim, aliquam hendrerit metus. Sed vel massa eu tellus malesuada finibus. Praesent nibh risus, maximus in feugiat aliquet, aliquam vitae arcu. Nullam id nisl ac turpis congue fermentum nec vel est. Aenean nec risus vel velit accumsan viverra. Praesent vitae leo porta, varius nisl vitae, rhoncus enim. Vivamus aliquam, nibh et porttitor varius, mi mi consectetur nisi, hendrerit imperdiet risus velit eget lectus. "
						+ "Aenean erat lacus, fermentum ac tellus ac, consectetur ornare risus. Duis vel lacus tortor. Mauris venenatis at metus et lobortis. Mauris a fermentum mauris. Quisque commodo dignissim ligula ut ornare. Suspendisse at turpis et erat vehicula varius. Donec id gravida turpis. Curabitur ut ultrices purus, eu viverra orci. Phasellus dapibus placerat sem ut eleifend. Pellentesque dapibus eu ligula scelerisque tincidunt. Nam eros nisl, fringilla vel tincidunt posuere, euismod nec tortor. Duis pulvinar ut sem non volutpat. Vestibulum pretium orci ipsum, ac lacinia augue ultricies ut. Mauris interdum dui tellus, at tincidunt lacus hendrerit ac. Donec iaculis ante id dui venenatis euismod. Nunc faucibus, nisi non dictum maximus, enim arcu placerat orci, nec maximus ligula quam quis enim. "
						+ "In interdum, est semper tempor tincidunt, justo mi feugiat ex, aliquet porttitor enim ipsum eget augue. Sed ornare, ligula vel rutrum accumsan, tellus ligula fringilla enim, vitae imperdiet ligula risus nec sem. Fusce diam metus, semper non semper id, ullamcorper non justo. Praesent dictum dapibus tortor ac viverra. Maecenas rutrum ex eget magna mattis, quis mattis mi tincidunt. Cras arcu lacus, mattis nec congue quis, vehicula malesuada nulla. Morbi justo mauris, mollis et faucibus ac, aliquet non felis. In congue velit et lectus iaculis egestas. "
						+ "Etiam eu dui viverra, commodo elit et, rutrum urna. Suspendisse potenti. Maecenas euismod ipsum vitae erat aliquet, vitae feugiat odio eleifend. Sed tempor feugiat ante, sed posuere nunc tempor vel. Sed tincidunt at nibh at sollicitudin. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla porta turpis et est egestas tincidunt. Nulla ut hendrerit arcu, id interdum diam.",
				"Timbuktu", "http://www.rotolospizza.com/", "10/27/2017", 4, carryOut, pepperoni);

		reviewRepo.save(rev7);

		ReviewComment comment1 = new ReviewComment("It tasted like cardboard", rev1);
		ReviewComment comment2 = new ReviewComment(
				"Oops, I forgot to remove the cardboard under the pizza when I cooked it!", rev1);
		commentRepo.save(comment1);
		commentRepo.save(comment2);

	}

}
