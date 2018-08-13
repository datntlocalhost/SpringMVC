/*
 * Check validation username and password of login form
 */
function isValidLoginForm() {
	var username = $("#form-username").val();
	var password = $("#form-password").val();
	
	var checkUsr = isValidUsername(username);
	var checkPwd = isValidPassword(password);
	
	if (!checkUsr || !checkPwd) {
		if (!checkUsr) {
			$("#invalid-usr").html("Invalid username");
			$("#form-username").focus();
		}
		if (!checkPwd) {
			$("#invalid-pwd").html("Invalid password");
			$("#form-password").focus();
		}
		return false;
	}
	return true;
}

/*
 * Check validation student code, student name of search form
 */
function isValidSearchForm() {
	var code = $("#code-search").val();
	var name = $("#name-search").val();
	
	var checkCode = isValidCodeSearch(code);
	var checkName = isValidNameSearch(name);
	
	$("#invalid-code-search").html("");
	$("#invalid-name-search").html("");
	
	if (!checkCode || !checkName) {
		if (!checkCode) {
			$("#invalid-code-search").html("Invalid student's code");
		}
		if (!checkName) {
			$("#invalid-name-search").html("Invalid student's name");
		}
		return false;
	}
	return true;
}
/*
 * Check validation student's name, student's date of birh of create new student form
 */
function isValidCreateForm() {
	var name = $("#name-create").val();
	var date = $("#date-create").val();
	var checkName = isValidName(name);
	var checkDate = isValidDate(date);
	
	$("#invalid-name").html("");
	$("#invalid-date").html("");
	
	if (!checkName || !checkDate) {
		if (!checkName) {
			$("#invalid-name").html("Invalid student's name");
		}
		if (!checkDate) {
			$("#invalid-date").html("Invalid student's date");
		}
		return false;
	}
	return true;
}

/*
 * Check validation name, date, score of Update Form 
 * */
function isValidUpdateForm() {
	var name = $("#name-update").val();
	var date = $("#date-update").val();
	var score = $("#scores-update").val();
	
	var checkName = isValidName(name);
	var checkDate = isValidDate(date);
	var checkScore = isValidScore(score);
	
	$("#invalid-name-update").html("");
	$("#invalid-date-update").html("");
	$("#invalid-score-update").html("");
	
	if (!checkName || !checkDate || !checkScore) {
		if (!checkName) {
			$("#invalid-name-update").html("Invalid student's name");
		}
		if (!checkDate) {
			$("#invalid-date-update").html("Invalid student's date");
		}
		if (!checkScore) {
			$("#invalid-score-update").html("Invalid student's score");
		}
		return false;
	}
	return true;
}

function isValidUsername(username) {
	var regex = /^[a-zA-Z0-9]{4,}$/;
	return checkRegex(username, regex);
}

function isValidPassword(password) {
	var regex = /^[a-zA-Z0-9!@#$%^&]{4,}$/;
	return checkRegex(password, regex);
}

function isValidName(name) {
	var regex = /^[a-zA-Z ]{5,}$/;
	return checkRegex(name, regex);
}

function isValidNameSearch(name) {
	var regex = /^[a-zA-Z ]{0,}$/;
	return checkRegex(name, regex);
}

function isValidCodeSearch(code) {
	var regex = /^[a-zA-Z0-9]{0,}$/;
	return checkRegex(code, regex);
}

function isValidCode(code) {
	var regex = /^[a-zA-Z0-9]{5,}$/;
	return checkRegex(code, regex);
}

function isValidDate(date) {
	var regex = /^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	return regex.test(date);
}

function isValidScore(score) {
	var isFloat = !isNaN(score);
	
	if (isFloat) {
		var floatScore = parseFloat(score);
		if (floatScore >= 0.0 && floatScore <= 10.0) {
			return true;
		}
	}
	return false;
}

function checkRegex(string, regex) {
	var result = string.match(regex);
	
	if (result == null) {
		return false;
	}
	return true;
}