
//var footerCopyrightText = document.getElementById('footer-copyright');
var footerCopyrightText = document.querySelector('#footer-copyright');

footerCopyrightText.addEventListener('click', function() {
	footerCopyrightText.innerText = "Created by Mary Ziegler";
});

footerCopyrightText.addEventListener('mouseover', function() {
	footerCopyrightText.innerText = "Created by Mary Ziegler";
});

footerCopyrightText.addEventListener('mouseout', function() {
	footerCopyrightText.innerText = "WCCI Week 7 Project - copyright 2017";
});



/*
var footerp = document.querySelector('#footer-copyright');
footerp.innerText = 'this is my substitute h1 text';
*/
/*
element.addEventListener('mouseout', function() {
	this.style[cssProp] = value2;
});
 */