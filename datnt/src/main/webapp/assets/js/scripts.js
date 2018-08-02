
jQuery(document).ready(function() {
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
	$('#login').on('submit', function(e) {
		alert("Invalid username or password!");
		e.preventDefault();
		$.ajax({
			type    : 'post',
			url     : '/datnt/login',
			data    : $(this).serialize(),
			success : function(result) {
				if (result != null) {
					window.location.href=result;
				} else {
					alert("Invalid username or password.");
				}
			}
		});
	});
	
	$('#create-form').on('submit', function(e) {
		e.preventDefault();
		$.ajax({
			type    : 'post',
			url     : '/datnt/admin/create',
			data    : $(this).serialize(),
			success : function(result) {
				
				if (result) {
					alert("Create new student successful.");
				} else {
					alert("Can not create new student.");
				}
			}
		});
	});
	
	$("#search-form").on('submit', function(e) {
		e.preventDefault();
		
		$.ajax({
			type : 'post',
			url  : '/datnt/admin/search',
			data : $(this).serialize(),
			success : function(result) {
				showPagenation(result.indexPage, result.startPage, result.endPage);
			}
		});
		
	});
	
	$(".alele").click(function(e) {
		e.preventDefault();
		alert($(this).val());
	});
	
	function showResults(result) {
		
	}
	
	function showPagenation(index, start, end) {
		var html = '';
		for (var i = start; i < end + 1; i++) {
			if (i == index) {
				html += '<a href="/datnt/views/admin.html?page=' + i + '" class="alele active">' + i + '</a>';
			} else {
				html += '<a href="/datnt/views/admin.html?page=' + i + '" class="alele">' + i + '</a>';
			}
		}
		$('.pagination .page-list').html(html);
	}

});
