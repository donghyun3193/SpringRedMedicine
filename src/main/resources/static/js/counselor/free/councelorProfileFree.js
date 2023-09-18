// JavaScript 함수를 정의하여 페이지 이동을 처리
function reservation() {
    // 페이지 이동을 원하는 URL로 변경
    window.location.href = '../html/bookingDetails.html'; // 이동하려는 URL을 여기에 입력
}

//강사님의 js입니다. 
$('.reply-list-wrap').on('click', '.reply-btns', function () {
    let $replyBtnBox = $(this).closest('.reply-btn-box').find('.reply-btns__box');

    $replyBtnBox.toggleClass('none');
});

$('body').click(function (e) {
    if ($(e.target).hasClass('reply-btns')) {
        //console.log('aa');
        return;
    }
    if (!$('.reply-btns__box').has(e.target).length) {
        $('.reply-btns__box').addClass('none');
    }
});

$('.btn-back').on('click', function (){
    window.location.href = '/board/boardList';
})

// 리플 작성 완료 처리
$('.btn-reply').on('click', function (){

});

// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    $('.reply-btns__box').addClass('none');
});

// 리플 수정 버튼 처리
$('.reply-list-wrap').on('click', '.reply-modify-btn', function () {
    let $content = $(this).closest('.reply').find('.reply-box__content');
    $content.replaceWith(`
  <div class='modify-box'>
    <textarea class='modify-content'>${$content.text()}</textarea>
    <button type='button' class='modify-content-btn'>수정 완료</button>
  </div>
  `);
    $('.reply-btns__box').addClass('none');
});

// 리플 수정 완료 처리
$('.reply-list-wrap').on('click', '.modify-content-btn', function () {
    console.log('modify!!!');
});


/*모달창 시작합니다.*/
// 모달 열기
function openModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "block";
  }
  
  // 모달 닫기
  function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
  }
  
  // 모달 닫기 버튼에 이벤트 리스너 추가
  var closeBtn = document.querySelector(".close");
  closeBtn.addEventListener("click", closeModal);
  
  // 모달 열기 함수 호출 (예를 들어, 버튼을 클릭할 때 호출)
  // openModal();

/**session 모달창 입니다. */
// 모달 열기
function openSessionModal() {
    var sModal = document.getElementById("sessionModal");
    sModal.style.display = "block";
  }
  
  // 모달 닫기
  function closeSessionModal() {
    var sModal = document.getElementById("sessionModal");
    sModal.style.display = "none";
  }
  
  // 모달 닫기 버튼에 이벤트 리스너 추가
  var closeSBtn = document.querySelector(".sModal-close");
  closeSBtn.addEventListener("click", closeSessionModal);
  
  // 모달 열기 함수 호출 (예를 들어, 버튼을 클릭할 때 호출)
  // openModal();
