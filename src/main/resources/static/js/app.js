var commentNbr = 0;
var addCommentButton = document.getElementById('addCommentButton');

//*********************************************************************//
//Since we start w/o comments, remove the border around the comment div
//*********************************************************************//
function displayBoxAroundComments() {
	var commentsExist = document.querySelector(".aComment");
	if (commentsExist == null) {
		document.querySelector(".user-comments").style.border = "none";
	} else {
		document.querySelector(".user-comments").style.border = "1px dotted grey";
	}
}

// *********************************************************************//
// This EventListener is called when the user clicks the
// Add Comment button. It has the logic to handle adding comments.
// *********************************************************************//
addCommentButton.addEventListener('click', function() {

	// Increment the commentNbr so it will have a unique id we can use to delete
	// it
	commentNbr = commentNbr + 1;

	// Give the user a prompt to enter their comment
	var userResponse = prompt('Enter your comment:');

	if (userResponse == null || userResponse == "") {
		// don't add a null or empty comment
	} else {

		// Create a paragraph element that will show the comment the user
		// entered.
		var para = document.createElement("p");
		// Give the paragraph element a class name of "commentNbrn" where n is
		// the incremented number
		para.className = 'commentNbr' + commentNbr;

		// Do the stuff to put the text the user entered in the prompt into the
		// element
		var node = document.createTextNode(userResponse);
		para.appendChild(node);

		// Create a delete button that will go next to the comment so that
		// comment can be
		// individually deleted.
		var delButton = document.createElement("button");
		// Give it our incremented commentNbrn class so it can be identifiable
		delButton.className = 'commentNbr' + commentNbr;
		delButton.id = commentNbr;

		// Add an EventListener to that delete button so we can delete that
		// comment if the user clicks it
		delButton.addEventListener('click', function() {
			var confirmDelete = prompt('Enter YES to confirm delete');
			if (confirmDelete == "YES" || confirmDelete == "yes") {
				var idName = this.id;
				var idNameToDelete = 'commentDiv' + idName;
				var elementToDelete = document.getElementById(idNameToDelete);
				elementToDelete.parentNode.removeChild(elementToDelete);
				displayBoxAroundComments();
			} else {
				alert("You choose not to delete this comment.");
			}
		});

		// Put text on the button
		var node2 = document.createTextNode("delete");
		delButton.appendChild(node2);

		// Create a div to put the delete button and comments into
		var div = document.createElement("div");
		// Give it identifying class and id
		var specificClass = 'commentNbr' + commentNbr;
		div.classList.add(specificClass, "aComment");
		div.id = 'commentDiv' + commentNbr;

		// Now get the area where we want to append the delete button and
		// comments
		// Then put all the stuff onto it!
		var element = document.getElementById("comments");
		element.appendChild(div);
		div.appendChild(delButton);
		div.appendChild(para);
	}
	displayBoxAroundComments();
});

// *********************************************************************//
// This EventListener is called when the user clicks the
// Delete button to delete a tag. It just has the user confirm
// that they do indeed want to delete the tag.
// Change the Thymeleaf form action if they cancel their delete
// So that the Controller class will not do the delete logic,
// It will just redisplay the review.
// *********************************************************************//

var deleteTagButton = document.getElementById('deleteTagButton');

deleteTagButton.addEventListener('click', function() {

	var confirmDelete = prompt('Enter YES to confirm delete');

	if (confirmDelete == "YES" || confirmDelete == "yes") {
		//alert("You want to delete this tag.");
	} else {
		deleteTagButton.setAttribute("th:formaction",
				"@{/remove-tag-delete-cancelled(id=${review.id})}");
	}
});

// Leaving this in as an example of looping through elements and
// setting up EventListeners on all of a set
// Decided not to implement because it doesn't look good.
// Implemented a mouseover on the footer line "I like Pizza" on
// the main page because it looks better to do it there.
/*
 * var categoryName = document.querySelectorAll('.cat-name');
 * 
 * for (var i=0; i < categoryName.length; i++) {
 * categoryName[i].addEventListener('mouseover', function() {
 * this.style.fontSize = '130%'; }) categoryName[i].addEventListener('mouseout',
 * function() { this.style.fontSize = '100%'; }); }
 */