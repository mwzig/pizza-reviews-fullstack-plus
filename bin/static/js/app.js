	
var commentNbr =0;
var addCommentButton = document.getElementById('addCommentButton');


addCommentButton.addEventListener('click', function() {
		commentNbr = commentNbr + 1;
	  var userResponse = prompt('Enter your comment:');
	    
	    var para = document.createElement("p");
	    var node = document.createTextNode(userResponse);
	    para.appendChild(node);
	  
	    var delButton = document.createElement("button");
	    var node2 = document.createTextNode("delete this comment");
	    delButton.appendChild(node2);
	    
	    var element = document.getElementById("comments");
	    element.appendChild(delButton);
	    element.appendChild(para);
	    
	    /* test stuff here */
		var div = document.createElement("div");
		div.id='comment' + commentNbr;
		div.className='newComment';
		element.appendChild(div);
		div.appendChild(delButton);
		div.appendChild(para);
	    /*
		var iDiv = document.createElement('div');
		iDiv.id = 'block';
		iDiv.className = 'block';
		document.getElementsByTagName('body')[0].appendChild(iDiv);

		// Now create and append to iDiv
		var innerDiv = document.createElement('div');
		innerDiv.className = 'block-2';
		*/
		
		
		   
});

    /*
    element.addEventListener('mouseout', function() {
		this.style[cssProp] = value2;
	});
    */