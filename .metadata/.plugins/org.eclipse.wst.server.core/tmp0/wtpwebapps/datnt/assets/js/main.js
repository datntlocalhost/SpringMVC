window.onload = function() {
	
	var create = document.getElementById('create');
	var createBtn = document.getElementById('create-student');
	var submitBtn = document.getElementById("create-submit");
	
	createBtn.onclick = function() {
		create.style.display = "block";
	}
	
	
	
	window.onclick = function() {
		if (event.target == create || event.target == submitBtn) {
			create.style.display = "none";
		}
	}
};
