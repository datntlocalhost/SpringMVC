window.onload = function() {
	
	var create = document.getElementById('create');
	var createBtn = document.getElementById('create-btn');
	var submitBtn = document.getElementById("create-submit");
	
	createBtn.onclick = function() {
		create.style.display = "block";
	}
	
	
	
	window.onclick = function() {
		if (event.target == create || event.target == submitBtn) {
			create.style.display = "none";
		}
	}
	
	$('#search-submit').click(function() {
		e.preventDefault();
		$.ajax({
			type : 'post',
			url : "/datnt/admin",
			data : $('#create-form').serialize(),
			success : function(result) {			
				if(result) {
					alert("asddsad");
				} else {
					alert("asddsad");
				}
			}
		});
	});
	
	
	$('#create-form').on('submit', function() {

		e.preventDefault();
		/*
		$.post({
			url : "/datnt/admin/create",
			data : $(this).serialize(),
			success : function(result) {
				
				if(result) {
					alert("asddsad");
				} else {
					
				}
			}
		});*/
	});
};

/*jQuery(document).ready(function() {
	alert("asdsad");
	
	$('#test').click(function() {
		alert("adsad");
	});
	
	$('#create-form').on('submit', function() {
		alert("adsaad");/*
		e.preventDefault();
		
		$.post({
			url : "/datnt/admin/create",
			data : $(this).serialize(),
			success : function(result) {
				
				if(result) {
					alert("asddsad");
				} else {
					
				}
			}
		});
	});
	
});*/