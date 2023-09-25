
//삭제 버튼
 $('.td-button').on('click', function (){

	 	if(confirm("정말로 탈퇴 시키겠습니까?")) {
			alert("탈퇴 처리 되었습니다!");
			let userNumber = $(this).data('number');
			window.location.href = '/admin/remove?userNumber=' + userNumber;
		}else{

		}
 });