var footerCopyrightText = document.querySelector('#footer-copyright');

footerCopyrightText.addEventListener('mouseover', function() {
	footerCopyrightText.innerText = "Created by Mary Ziegler";
});

footerCopyrightText.addEventListener('mouseout', function() {
	footerCopyrightText.innerText = "WCCI Week 7 Project - copyright 2017";
});

// This is done only on the main page intentionally
var pizzaLike = document.querySelector('#pizza-like-stmt');

pizzaLike.addEventListener('mouseover', function() {
	this.style.fontSize = '130%';
	this.style.fontWeight = 'bold';
});
pizzaLike.addEventListener('mouseout', function() {
	this.style.fontSize = '100%';
	this.style.fontWeight = 'normal';
});