
jQuery(document).ready(function() {
	
	$("#mytable #checkall").click(function () {
        if ($("#mytable #checkall").is(':checked')) {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });
	
    /*
     * validation cho form login
     */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    /*
     * Validation cho form login
     */
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
    
    /*
     * Xử lý sự kiện click submit cho form login, gửi POST request đến controller 
     * nhận kết quả trả về từ controller và chuyển hướng đến trang admin nếu login
     * thành công.  
     */
	$('#login').on('submit', function(e) {
		e.preventDefault();
		$.ajax({
			async   : false,
			type    : 'post',
			url     : '/datnt/login',
			data    : $(this).serialize(),
			success : function(result) {
				if ($.trim(result)) {
					window.location.href=result;
				} else {
					alert("Invalid username or password!");
				}
			}
		});
	});
	
	
	/*
	 * Xử lý sự kiện click submit cho form create new student, gửi POST request chứa thông tin
	 * new student đến controller, nhận kết quả trả về từ controller và thông báo cho client.
	 */
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
	
	/*
	 * Xử lý sự kiện click submit trong form tìm kiếm, gửi POST request chứa thông tin
	 * student code và student name để tìm kiếm đến controller, nhận kết quả trả về từ
	 * controller và render view.
	 */
	$("#form-search").on('submit', function(e) {
		e.preventDefault();
		
		$.ajax({
			type : 'post',
			url  : '/datnt/admin/search',
			data : $(this).serialize(),
			success : function(result) {
				if ($.trim(result)) {
					showResults(result.students);
					showPagenation(result.indexPage, result.startPage, result.endPage, result.maxPage);
				} else {
					alert("Invalid student code or student name");
				}
			}
		});
		
	});
	
	/*
	 * Xử lý sự kiện client submit form update thông tin sinh viên,
	 * gửi một post request tới controller, nhận kết quả trả về từ 
	 * controller và thông báo cho client.
	 */
	$("#form-update").on('submit', function(e) {
		
		e.preventDefault();
		
		$.ajax({
			type : 'post',
			url  : '/datnt/admin/update',
			data : $(this).serialize(),
			success : function(result) {
				if (result == true) {
					alert("Update successful.");
				} else {
					alert("Invalid input");
				}
			}
		});
	});
	
	/*
	 * Xử lý sự kiện client click vào button xác nhận xóa sinh viên theo danh sách.
	 */
	$("#accept-deletes").click(function() {
		var checked = [];
		$(".checkthis:checkbox:checked").each(function() {
			checked.push(this.value);
		});
		
		$.ajax({
			type : 'get',
			url  : '/datnt/admin/delete',
			data : {values: checked},
			contentType: "application/json; charset=utf-8",
            dataType: "json",
			success : function(result) {
				if ($.trim(result)) {
					showResults(result.students);
					showPagenation(result.indexPage, result.startPage, result.endPage, result.maxPage);
				} else {
					alert("Can not delete this student.");
				}
			}
		});
	});
	
	
});

/*
 * Render thông tin danh sách sinh viên lên datatable.
 * 
 * @param list danh sách sinh viên.
 */
function showResults(list) {
	var html = '';
	list.forEach(function(item) {
		html += '<tr>'+
		'<td><input type="checkbox" class="checkthis" name="id" value="' + item.studentId + '"/></td>' +
		' <td>' + item.studentCode + '</td>' + 
		' <td>' + item.studentName + '</td>' +
		' <td>' + item.dateOfBirth + '</td>' +
		' <td>' + item.avgScore    + '</td>' + 
		' <td>' + item.address     + '</td>' +
		'<td><p><button class="btn btn-primary btn-xs edit-btn" ' + 
		'data-title="Edit" data-toggle="modal" '         +
		'data-target="#edit" data-placement="top" '      + 
		'rel="tooltip" onclick="getInfoUpdate(' + item.studentId + ');"><span class="glyphicon glyphicon-pencil"></span></button></p></td> ' + 
		'<td><p><button class="btn btn-danger btn-xs remove-btn" '  + 
		'data-title="Delete" data-toggle="modal" '       + 
		'data-target="#delete" data-placement="top" '    + 
		'rel="tooltip" onclick="deleteStudent(' + item.studentId + ');"><span class="glyphicon glyphicon-trash"></span></button></p></td>';
	});
	$("#table-result").html(html);
}

/*
 * Xử lý sự kiện khi client click vào button chọn trang,
 * gửi get request chứa thông điệp về số trang đến controller, 
 * nhận kết quả trả về từ controller và render view.
 * 
 *  @param param vị trí trang cần đến.
 */
function pageClick(param) {
	$.ajax({
		type : 'get',
		url  : '/datnt/admin/search?page=' + param,
		success : function(result) {
			if ($.trim(result)) {
				showResults(result.students);
				showPagenation(result.indexPage, result.startPage, result.endPage, result.maxPage);
			}
		}
	});
}

/*
 * Gửi một get request mang thông điệp prev hoặc next của page 
 * tới controller, kết quả nhận được sẽ hiển thị cho user trên 
 * datatable sinh viên.
 * 
 * @param  param  là chuỗi "next" hoặc "prev"
 */
function pageDirect(param) {

	$.ajax({
		type : 'get',
		url  : '/datnt/admin/search/direct?type=' + param,
		success : function(result) {
			if ($.trim(result)) {
				showResults(result.students);
				showPagenation(result.indexPage, result.startPage, result.endPage, result.maxPage);
			}
		}
	});
}

/*
 * Gửi một get request chứa param là studentId đến controller 
 * để lấy thông tin sinh viên sau đó set thông tin vào form 
 * update .
 * 
 * @param param  id sinh viên 
 */
function getInfoUpdate(param) {
	
	$.ajax({
		type : 'get',
		url  : '/datnt/admin/update/' + param,
		success : function(result) {
			if ($.trim(result)) {
				$("#code-update").val(result.studentCode);
				$("#name-update").val(result.studentName);
				$("#scores-update").val(result.avgScore);
				$("#address-update").val(result.address);
				$("#date-update").val(result.dateOfBirth);
				$("#id-update").val(result.studentId);
			}
		}
	});
}

/*
 * Render các button chọn page
 * 
 * @param index    vi trí page hiện tại
 * @param start    vị trị page bắt đầu 
 * @param end      vị trí page kết thúc 
 * @param maxPage  tổng số page 
 */
function showPagenation(index, start, end, maxPage) {
	var pre = '';
	var next = '';
	var pages = '';
	
	if (index > 1) {
		pre = '<li id="prev"><a href="#" data-toggle="tooltip" title="Previous" onclick="pageDirect(-1);"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
	} else {
		pre = '<li id="prev" class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
	}
	if (index == maxPage) {
		next = '<li id="next" class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
	} else {
		next = '<li id="next"><a href="#" data-toggle="tooltip" title="Next" onclick="pageDirect(1)"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
	}
	for ( let i = start; i <= end; i++) {
		if (index == i) {
			pages += ' <li class="active"><a href="#">'+ i + '</a></li>';
		} else {
			pages += ' <li><a href="#" onclick="pageClick(' + i + ')">'+ i + '</a></li>';
		}
	}

	$(".pagination").html(pre + pages + next);
}

/*
 * Xử lý sự kiện khi client chọn delete student, gửi một get request chứa thông tin
 *  mã sinh viên đến controller, nhận kết quả trả về từ controller, thông báo cho client
 *  và render kết quả mới cho client.
 *  
 *  @param param id sinh viên 
 */
function deleteStudent(param) {
	$.ajax({
		type : 'get',
		url  : '/datnt/admin/delete/' + param,
		success : function(result) {
			if ($.trim(result)) {
				showResults(result.students);
				showPagenation(result.indexPage, result.startPage, result.endPage, result.maxPage);
			}
		}
	});
}

$(function () {
    $("[rel='tooltip']").tooltip();
});