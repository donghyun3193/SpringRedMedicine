  //모달창 js
  const body = document.querySelector('body');
  const modal = document.querySelector('.modal');
  const btnOpenPopup = document.querySelector('.btn-open-popup');
  
  btnOpenPopup.addEventListener('click', () => {
   modal.classList.toggle('show');
  //모달 on
  
  if (modal.classList.contains('show')) {
  body.style.overflow = 'hidden';
  //모달 off
  }
  });
  
  modal.addEventListener('click', (event) => { if (event.target === modal) {
  modal.classList.toggle('show');
  //class를 이용한 모달 on/off
  
  if (!modal.classList.contains('show')) {
  body.style.overflow = 'auto';
  }
  }
  });
  //모달창 js 끝

  // 취소 컨펌 시작
function call_confirm1(){

	if(confirm("상담을 취소 하시겠습니까?")){
        alert("취소 되었습니다!");
        // window.location.href= "../../html/counselorBook.html";
	}else{
		
	}
}

  // 완료 컨펌 시작
  function call_confirm2(){

    if(confirm("상담을 완료 하시겠습니까?")){
          alert("완료 되었습니다!");
          // window.location.href= "../../html/counselorBook.html";
    }else{
      
    }
  }