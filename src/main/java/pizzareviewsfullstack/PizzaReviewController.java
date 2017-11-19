package pizzareviewsfullstack;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Note - a future change to better handle sizing the tags would be as follows:
//	Have a TagSizer class that is passed the tagRepo in a method called sizeTags().
//	It would return a hashmap of tagname or id to string (a string indicating the size, 
//	for example, "small" or "med-1" or "med-2", etc.) Then, the controller can pass
//	that hashmap to whatever view needs to display sized tags.   The TagSizer
//	would have an algorithm to determine size based on the highest number of
//	occurances of the Tag. For example, if the tag with the most occurances had
//	showed up 3 times, you would only want small, med, large.  If the highest was 60,
//	then you would want to divide the tags into more size definitions - say 0-10 was small,
//	11-20, med-1, etc.)

@Controller
public class PizzaReviewController {

	@Resource
	TagRepository tagRepo;

	@Resource
	PizzaReviewRepository reviewRepo;

	@Resource
	CategoryRepository categoryRepo;

	@RequestMapping("/categoryList")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("allTags", tagRepo.findAll());
		return "categories"; // the html page for the list of categories
	}

	@RequestMapping("/singleCategory")
	public String getOneCategory(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category"; // the html page for a specific category
	}

	@RequestMapping("/singleTag")
	public String getOneTag(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tag"; // the html page for a specific tag
	}

	@RequestMapping("/singleReview")
	public String getOneCourse(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review"; // the html page for the single review
	}

	@RequestMapping("/add-tag")
	public String addTag(@RequestParam(value = "id") Long id, String tagName) {

		Tag tagBeingAdded = tagRepo.findByName(tagName);
		if (tagBeingAdded == null) {
			tagBeingAdded = new Tag(tagName);
			tagRepo.save(tagBeingAdded);
		}

		// find the review object - use reviewRepo.findOne(id)
		PizzaReview pizzaReview = reviewRepo.findOne(id);

		// Determine if the tag is already on the review
		Set<Tag> existingTagsOnReview = pizzaReview.getTags();

		if (!existingTagsOnReview.contains(tagBeingAdded)) {
			// add the new tag to the Review java object tag Set
			pizzaReview.addTag(tagBeingAdded);
			// save the review
			reviewRepo.save(pizzaReview);
		}
		return "redirect:/singleReview?id=" + id.toString();
	}

	@RequestMapping("/remove-tag")
	public String removeTag(@RequestParam(value = "id") Long id, String tagName) {

		Tag tagBeingRemoved = tagRepo.findByName(tagName);
		// if the tag being removed exists in the database
		// then we need to remove it from the review
		if (tagBeingRemoved != null) {

			// find the review object - use reviewRepo.findOne(id)
			PizzaReview pizzaReview = reviewRepo.findOne(id);

			// Determine if the tag is already on the review
			Set<Tag> existingTagsOnReview = pizzaReview.getTags();

			if (existingTagsOnReview.contains(tagBeingRemoved)) {
				// add the new tag to the Review java object tag Set
				pizzaReview.removeTag(tagBeingRemoved);
				// save the review
				reviewRepo.save(pizzaReview);
			}
		}
		// think about a javascript message here if tag being
		// removed doesn't exist
		return "redirect:/singleReview?id=" + id.toString();
	}

	@RequestMapping("/remove-tag-delete-cancelled")
	public String removeTagDeleteCancelled(@RequestParam(value = "id") Long id, String tagName) {
		return "redirect:/singleReview?id=" + id.toString();
	}

}
