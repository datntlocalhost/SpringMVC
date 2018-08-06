$(function () {
    $("[rel='tooltip']").tooltip();
});

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
	 * Gửi post request chứ thông tin student đến controller khi user click vào button Create student,
	 * nhận response từ controller và thông báo cho user
	 */
	$("#create-form").on('submit', function(event) {
		event.preventDefault();
		sendPost($(this).attr('action'), $(this).serialize()).done(function(result) {
			if (result) {
				alert("Create new student success.");
			} else {
				alert("Can not create new student!");
			}
		});
	});
	
	/*
	 * 
	$("#form-search").on('submit', function(event) {
		event.preventDefault();
		sendPost('admin/search', $(this).serialize()).done(function(result) {
			if ($.trim(result)) {
				renderStudents(result.students);
				renderPage(result.pagenation);
			} else {
				alert("Empty result!");
			}
		});
	});
	*/
	$("#form-update").on('submit', function(event) {
		event.preventDefault();
		var html = '';
		sendPost('/datnt/admin/update', $(this).serialize()).done(function(result) {
			if ($.trim(result)) {
				html += '<td><input type="checkbox" class="checkthis" name="id" value="' + result.studentId + '"/></td>' +
				' <td>' + result.studentCode + '</td>' + 
				' <td>' + result.studentName + '</td>' +
				' <td>' + result.dateOfBirth + '</td>' +
				' <td>' + result.avgScore    + '</td>' + 
				' <td>' + result.address     + '</td>' +
				'<td><p><button class="btn btn-primary btn-xs edit-btn" ' + 
				'data-title="Edit" data-toggle="modal" '         +
				'data-target="#edit" data-placement="top" '      + 
				'rel="tooltip" onclick="getInfoUpdate(' + result.studentId + ');"><span class="glyphicon glyphicon-pencil"></span></button></p></td> ' + 
				'<td><p><button class="btn btn-danger btn-xs remove-btn" '  + 
				'data-title="Delete" data-toggle="modal" '       + 
				'data-target="#delete" data-placement="top" '    + 
				'rel="tooltip" onclick="deleteStudent(' + result.studentId + ');"><span class="glyphicon glyphicon-trash"></span></button></p></td>';
				$("#stdRow-" + result.studentId).html(html);
			} else {
				alert("Can not update this student!");
			}
		});
	});
	
	$("#accept-deletes").click(function(event) {
		var checked = [];
		$(".checkthis:checkbox:checked").each(function() {
			checked.push(this.value);
		});
		sendGet('/datnt/admin/delete', {values: checked}).done(function(result) {
			if ($.trim(result)) {
				renderStudents(result.students);
				renderPage(result.pagenation);
				alert("Delete student success.");
			} else {
				alert("Delete student errors!")
			}
		});
		
	});
	
	$("#agree-delete").click(function(event) {
		var id = $("#id-delete").val();
		
		sendGet('/datnt/admin/delete/' + id, null).done(function(result) {
			if ($.trim(result)) {
				renderStudents(result.students);
				renderPage(result.pagenation);
				alert("Delete student success.");
			} else {
				alert("Delete student errors!")
			}
		});
	});
});

/*
 * 
 * */
function renderStudents(result) {
	var html = '';
	result.forEach(function(item) {
		html += '<tr id="stdRow-'+ item.studentId + '">' +
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
 * 
 * */
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
 * 
 * */
function getInfoUpdate(param) {
	sendGet('/datnt/admin/update/' + param).done(function(result) {
		if ($.trim(result)) {
			$("#code-update").val(result.studentCode);
			$("#name-update").val(result.studentName);
			$("#scores-update").val(result.avgScore);
			$("#address-update").val(result.address);
			$("#date-update").val(result.dateOfBirth);
			$("#id-update").val(result.studentId);
		}
	});
}

function deleteStudent(param) {
	$("#id-delete").val(param);
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