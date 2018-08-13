$(function () {
    $("[rel='tooltip']").tooltip();
});

jQuery(document).ready(function() {
	$('#mytable').DataTable({
		"searching" : false,
		"paging"    : false,
		"info"      : false
	});
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
	
	$("#form-login").on('submit', function(event) {
		var isValid = isValidLoginForm();
		
		if (!isValid) {
			event.preventDefault();
		}
	});
	
	$("#form-create").on('submit', function(event) {
		var isValid = isValidCreateForm();
		
		if (!isValid) {
			event.preventDefault();
		}
	});
	
	$("#form-search").on('submit', function(event) {
		var isValid = isValidSearchForm();
		
		if (!isValid) {
			event.preventDefault();
		}
	});
	
	/*
	 * Xử lý event khi user click submit form update sinh viên
	 */
	$("#form-update").on('submit', function(event) {	
		event.preventDefault();
		
		var isValid = isValidUpdateForm();
		
		if (isValid) {
			var html = '';
			//send POST request chứa thong tin cập nhật của sinh viên đến controller
			sendPost('/datnt/admin/update', $(this).serialize()).done(function(result) {
				//nếu kết quả từ controller trả về != null
				if ($.trim(result)) {
					//Khởi tạo các element
					html += '<td><input type="checkbox" class="checkthis" name="id" value="' + result.studentId + '" onclick="checkBox()"/></td>' +
					' <td>' + result.studentCode + '</td>' +
					' <td>' + result.studentName + '</td>' +
					' <td>' + result.dateOfBirth + '</td>' +
					' <td>' + result.avgScore    + '</td>' +
					' <td>' + result.address     + '</td>' +
					'<td><p><button class="btn btn-primary btn-xs edit-btn" ' +
					'data-title="Edit" data-toggle="modal" '         +
					'data-target="#edit" data-placement="top" '      +
					'rel="tooltip" onclick="getInfoUpdate(' + result.studentId + ');"><span class="glyphicon glyphicon-pencil"></span></button></p></td> ';
					//render
					$("#stdRow-" + result.studentId).html(html);
					alert("Update success.");
				} else {
					alert("Can not update this student!");
				}
			});
			$('#edit').modal('hide');
		}
	});

	/*
	 * Xử lý event khi user click vào button đông ý xóa danh sách sinh viên đã được chọn.
	 */
	$("#accept-deletes").click(function(event) {
		//checked chứa danh sách id sẽ xóa
		var checked = [];

		//Lấy dnah sách các id trong các checkbox đã được checked
		$(".checkthis:checkbox:checked").each(function() {
			checked.push(this.value);
		});

		//Gửi Get request đến controller
		sendGet('/datnt/admin/delete', {values: checked}).done(function(result) {
			//Nếu kết quả từ controller trả về != null
			if ($.trim(result)) {
				//render student
				renderStudents(result.students);

				//render pagenation
				renderPage(result.pagenation);
				alert("Delete student success.");
				window.location.href="/datnt/admin";
			} else {
				alert("Delete student errors!")
			}
		});
		disableCheck();
		$('#delete').modal('hide');
	});
	
	$("#create-btn").click(function(event) {
		console.log("sdsd");
		resetCreateForm();
	});
});

/*
 * Render student list on datatable.
 *
 * @param result  Student list from controller.
 */
function renderStudents(result) {
	var html = '';

	result.forEach(function(item) {
		html += '<tr id="stdRow-'+ item.studentId + '">' +
		'<td><input type="checkbox" class="checkthis" name="id" value="' + item.studentId + '" onclick="checkBox()"/></td>' +
		' <td>' + item.studentCode + '</td>' +
		' <td>' + item.studentName + '</td>' +
		' <td>' + item.dateOfBirth + '</td>' +
		' <td>' + item.avgScore    + '</td>' +
		' <td>' + item.address     + '</td>' +
		'<td><p><button class="btn btn-primary btn-xs edit-btn" ' +
		'data-title="Edit" data-toggle="modal" '         +
		'data-target="#edit" data-placement="top" '      +
		'rel="tooltip" onclick="getInfoUpdate(' + item.studentId + ');">' +
		'<span class="glyphicon glyphicon-pencil"></span></button></p></td> ';
	});
	$("#table-result").html(html);
}

/*
 * Render buttons pagenation
 *
 * @param result  Pagenation info from controller.
 */
function renderPage(result) {
	var curPage   = result.curPage;
	var startPage = result.startPage;
	var endPage   = result.endPage;
	var href      = '/datnt/admin/search?studentCode=' + result.studentCode + '&studentName=' + result.studentName +
					'&page=';
	var prevPage  = '';
	var nextPage  = '';
	var pages     = '';

	if (curPage > 1) {
		prevPage  = '<li id="prev"><a href="' + href + (curPage - 1) +'" data-toggle="tooltip" title="Previous"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
	} else {
		prevPage  = '<li id="prev" class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
	}
	if (curPage == result.maxPage) {

		nextPage  = '<li id="next" class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
	} else {
		nextPage  = '<li id="next"><a href="' + href + (curPage + 1) + '" data-toggle="tooltip" title="Next"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
	}

	for (var i = startPage; i <= endPage; i++) {
		if (curPage == i) {
			pages += ' <li class="active"><a href="' + href + i + '">'+ i + '</a></li>';
		} else {
			pages += ' <li><a href="' + href + i + '">'+ i + '</a></li>';
		}
	}
	$(".pagination").html(prevPage + pages + nextPage);
}

/*
 * send student id to controller and then get sutdent info from controller,
 * render student info on form update
 *
 * @param param   Student id
 */
function getInfoUpdate(param) {
	sendGet('/datnt/admin/update/' + param).done(function(result) {
		if ($.trim(result)) {
			//render result from controller on form update
			$("#invalid-name-update").html("");
			$("#invalid-date-update").html("");
			$("#invalid-score-update").html("");
			$("#code-update").val(result.studentCode);
			$("#name-update").val(result.studentName);
			$("#scores-update").val(result.avgScore);
			$("#address-update").val(result.address);
			$("#date-update").val(result.dateOfBirth);
			$("#id-update").val(result.studentId);
		}
	});
}

function reset() {
	$("#create-form input").val('');
}

function showAlert(message) {
	alert(message);
}

function checkBox() {
	var checkAll = true;
	
	$(".checkthis").each(function() {
		if (!$(this).is(':checked')) {
			checkAll = false;
		}
	});
	
	if (checkAll) {
		$("#mytable #checkall").prop('checked', true);
	} else {
		$("#mytable #checkall").prop('checked', false);
	}
}

function hasSelect() {
	$("#mytable input[type=checkbox]").each(function() {
		if ($(this).is(':checked')) {
			return true;
		}
	});
}

function disableCheck() {
	if ($("#mytable #checkall").is(':checked')) {
		$("#mytable #checkall").prop('checked', false);
	}
}

function resetCreateForm() {
	$("#invalid-name").html("");
	$("#invalid-date").html("");
	$("#name-create").val("");
	$("#date-create").val("");
	$("#address-create").val("");
}

/*
 * Send một POST request đến controller
 *
 * @param url
 * @param data
 *
 * @return result
 */
function sendPost(url, data) {
	return $.ajax({
		type  : 'post',
		url   : url,
		data  : data,
		cache : false
	});
}

/*
 * Send một GET request đến controller
 *
 * @param url
 * @param data
 *
 * @return result
 */
function sendGet(url, data) {
	return $.ajax({
		type  : 'get',
		url   : url,
		data  : data,
		cache : false
	});
}
