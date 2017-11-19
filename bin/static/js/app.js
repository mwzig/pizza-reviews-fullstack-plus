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
/*
element.addEventListener('mouseout', function() {
	this.style[cssProp] = value2;
});
 */