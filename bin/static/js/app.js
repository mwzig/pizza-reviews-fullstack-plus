var commentNbr = 0;
var addCommentButton = document.getElementById('addCommentButton');

//*********************************************************************//
//This function actually deletes a specific comment 
//*********************************************************************//
function deleteComment(number) {

	var idNameToDelete = 'commentDiv' + number;
	var elementToDelete = document.getElementById(idNameToDelete);
	alert(idNameToDelete);
	elementToDelete.parentNode.removeChild(elementToDelete);
}
//*********************************************************************//
// This EventListener is called when the user clicks the
// Add Comment button.  It has the logic to handle adding comments. 
//*********************************************************************//
addCommentButton.addEventListener('click', function() {
	
	// Increment the commentNbr so it will have a unique id we can use to delete it
	commentNbr = commentNbr + 1;
	
	// Give the user a prompt to enter their comment
	var userResponse = prompt('Enter your comment:');

	// Create a paragraph element that will show the comment the user entered.
	var para = document.createElement("p");
	// Give the paragraph element a class name of "commentNbrn" where n is the incremented number
	para.className = 'commentNbr' + commentNbr;
	
	// Do the stuff to put the text the user entered in the prompt into the element
	var node = document.createTextNode(userResponse);
	para.appendChild(node);

	// Create a delete button that will go next to the comment so that comment can be
	// individually deleted.
	var delButton = document.createElement("button");
	// Give it our incremented commentNbrn class so it can be identifiable
	delButton.className = 'commentNbr' + commentNbr;

	// Add an EventListener to that delete button so we can delete that
	// comment if the user clicks it
	delButton.addEventListener('click', function() {
		deleteComment(commentNbr);
	});

	// Put text on the button 
	var node2 = document.createTextNode("delete this comment");
	delButton.appendChild(node2);

	// Create a div to put the delete button and comments into
	var div = document.createElement("div");
	// Give it identifying class and id 
	var specificClass = 'commentNbr' + commentNbr;
	div.classList.add(specificClass, "aComment");
	div.id = 'commentDiv' + commentNbr;
	
	// Now get the area where we want to append the delete button and comments
	// Then put all the stuff onto it!
	var element = document.getElementById("comments");
	element.appendChild(div);
	div.appendChild(delButton);
	div.appendChild(para);

});

// Leaving this in as an example of looping through elements and 
// setting up EventListeners on all of a set
// Decided not to implement because it doesn't look good.
// Implemented a mouseover on the footer line "I like Pizza" on
// the main page because it looks better to do it there.
/*
 var categoryName = document.querySelectorAll('.cat-name');

 for (var i=0; i < categoryName.length; i++) {
 categoryName[i].addEventListener('mouseover', 
 function() {
 this.style.fontSize = '130%';
 })
 categoryName[i].addEventListener('mouseout', 
 function() {
 this.style.fontSize = '100%';
 });
 }
 */