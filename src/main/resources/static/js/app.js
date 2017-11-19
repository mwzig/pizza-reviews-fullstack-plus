var commentNbr = 0;
var addCommentButton = document.getElementById('addCommentButton');

function deleteComment(number) {

	var idNameToDelete = 'commentDiv' + number;
	var elementToDelete = document.getElementById(idNameToDelete);
	alert(idNameToDelete);
	elementToDelete.parentNode.removeChild(elementToDelete);
}

addCommentButton.addEventListener('click', function() {
	commentNbr = commentNbr + 1;
	var userResponse = prompt('Enter your comment:');

	var para = document.createElement("p");
	para.className = 'commentNbr' + commentNbr;
	var node = document.createTextNode(userResponse);
	para.appendChild(node);

	var delButton = document.createElement("button");
	delButton.className = 'commentNbr' + commentNbr;

	delButton.addEventListener('click', function() {
		deleteComment(commentNbr);
	});

	var node2 = document.createTextNode("delete this comment");
	delButton.appendChild(node2);

	var element = document.getElementById("comments");
	
	var div = document.createElement("div");
	var specificClass = 'commentNbr' + commentNbr;
	div.classList.add(specificClass, "aComment");
	div.id = 'commentDiv' + commentNbr;
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