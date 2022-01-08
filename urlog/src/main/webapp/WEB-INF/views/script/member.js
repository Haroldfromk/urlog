/**
 * 
 */


function loginCheck(){
	if(document.form.id.value.length == 0){
		alert("아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	if(document.form.pass.value == ""){
		alert("비밀번호를 입력해주세요.");
		frm.pass.focus();
		return false;
	}
	
	return true;
	
}

function idCheck(){
	if(document.form.id.value == ""){
		alert("아이디를 입력해주세요.");
		document.form.id.focus();
		return;
	}
	
	var url = "idCheck.do?id="+document.form.id.value;
	/*idCheck.do => idcheck.jsp*/
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	
}

/*id중복체크를 완료한 후 처리하는 메서드*/
function idok(){
	opener.frm.id.value = document.form.id.value;
	opener.frm.reid.value = document.form.id.value;
	/*self.close();*/
	
	window.close();
}

/*회원가입 폼에 유효성 검사 체크를 위한 메서드*/
function joinCheck(){
	if(document.form.name.value.length == 0){
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
	if(document.form.id.value.length == 0){
		alert("아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(document.form.reid.value.length == 0){
		alert("아이디 중복체크를 해주세요.");
		frm.id.focus();
		return false;
	}
		
	if(document.form.pass.value.length == 0){
		alert("비밀번호를 입력해주세요.");
		frm.pass.focus();
		return false;
	}
	
	if(document.form.pass.value != document.frm.pass_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pass.focus();
		return false;
	}
	
	if(document.form.id.value.length < 3){
		alert("아이디는 3글자 이상이어야 합니다. ")
		frm.id.focus();
		return false;
	}
	
	return true;
}