//여기서 부터 검색 리스트
  let page = 1;
  let keyword = $('.keyword').val();
  let cate = $('.cate').val();

  myModule(cate, keyword, showResult);

  //상담 취소 버튼
  $('.content').on('click', '.td-nobutton', function () {
    if (confirm("예약을 정말 취소 하시겠습니까?")) {
      alert("취소 처리 되었습니다!");
      let bookNumber = $(this).data('number');
      window.location.href = '/counselor/remove?bookNumber=' + bookNumber;
    } else {
    }
  });

  //상담 완료 버튼
  $('.content').on('click', '.td-okbutton', function () {
    if(confirm("상담을 완료 하시겠습니까?")){
      alert("완료 되었습니다!");
      let bookNumber = $(this).data('number');
      window.location.href = '/counselor/update?bookNumber=' + bookNumber;
    } else {
    }
  });


// 검색 버튼(.btn-search)이 클릭되었을 때 이벤트 핸들러를 등록합니다.
$('.btn-search').on('click', function () {
  // 검색 페이지를 1로 초기화합니다.
  page = 1;

  // 입력 필드로부터 검색어를 가져와 변수 'keyword'에 저장합니다.
  keyword = $('.keyword').val();

  // 입력 필드로부터 카테고리를 가져와 변수 'cate'에 저장합니다.
  cate = $('.cate').val();

  // 'myModule' 함수를 호출하여 선택한 카테고리('cate')와 검색어('keyword')를 인자로 전달하고,
  // 검색 결과를 표시할 'showResult' 함수도 함께 전달합니다.
  myModule(cate, keyword, showResult);
});


/* 아래 함수는 반복문을 사용하여 목록에 데이터를 뿌려주고
* 상태에 따라 버튼 style이 변경 되며
* 페이징 처리가 되어 있다.
**/
function showResult(result) {
  console.log(result)

  let text = '';
  result.list.forEach(r => {
    text += `
<tr>
  <td >${r.rnum}</td>
    <td> <button class="btn-open-popup" data-num="${r.bookNumber}">${r.userName}</button></td>
    <td>${r.bookDate}</td>
    <td>${r.bookTime}</td>
    <td>
        `;
    if (r.bookStatus == 2) {
      text += `
          <input class="td-okbutton1" type="button" data-number="${r.bookNumber}" value="상담완료">
       </td>
<td>
          <input class="td-okbutton1" type="button" data-number="${r.bookNumber}" value="상담완료">
          `;
    } else {
      text += `
          <input class="td-nobutton" type="submit" data-number="${r.bookNumber}" value="상담취소">
       </td>
<td>
          <input class="td-okbutton" type="submit" data-number="${r.bookNumber}" value="상담완료">
          `;
    }

      text +=`</td>
    </tr>
			`;
    });

    $('.content').html(text);
    let pageVo = result.pageVo;
    let block = '';

    if (pageVo.prev) {
      block += `<li class="page-num prev" data-page="${pageVo.startPage - 1}">&lt</li>`;
    }
    for (let i = pageVo.startPage; i <= pageVo.endPage; i++) {
      if (pageVo.criteria.page == i) {
        block += `<li class="page-num active" data-page="${i}">${i}</li>`;
      } else {
        block += `<li class="page-num" data-page="${i}">${i}</li>`;
      }
    }
    if (pageVo.next) {
      block += `<li class="page-num next" data-page="${pageVo.endPage + 1}">&gt</li>`;
    }
    $('.page-box').html(block);
  }

// .content 요소에 대한 클릭 이벤트 핸들러를 등록
$('.content').on('click', '.btn-open-popup', function(){
  // 모달 창에 'show' 클래스를 추가하여 모달을 표시
  $('.modal').addClass('show');

  // 현재 클릭한 요소의 data-num 속성 값을 가져와서 'bookNumber' 변수에 저장
  let bookNumber = $(this).data('num');
  console.log(bookNumber); // bookNumber를 콘솔에 출력

  //비동기통신
  $.ajax({
    // 요청할 URL을 지정
    url: `/counselor/counselorBook/modal`,
    // HTTP 요청 메서드를 설정 (GET 요청).
    type : 'get',
    // 서버로 보낼 데이터를 설정합니다. 'bookNumber'를 포함
    data : {bookNumber : bookNumber},
    // 서버로부터 예상되는 데이터 형식을 JSON으로 설정
    dataType: 'json',
    // 요청이 성공했을 때 실행할 콜백 함수를 정의
    success : function (result){
      // 서버로부터 받은 결과 데이터를 콘솔에 출력
      console.log(result);
      // 모달 창에 사용자 이름을 설정
      $('.modal__userName').text(result.userName);
      // 모달 창에 사용자 휴대폰 번호를 설정
      $('.modal__userPhone').text('휴대폰 번호 : ' + result.userPhone);
      // 모달 창에 사용자 이메일을 설정
      $('.modal__userEmail').text('이메일 : ' + result.userEmail);
      // 모달 창에 도서 내용을 설정
      $('.modal__bookContent').text(result.bookContent);
    }
  });
});

// '.modal' 클래스를 가진 모든 요소에 대한 클릭 이벤트 핸들러를 등록합니다.
$('.modal').on('click', function(e){
  // 클릭 이벤트의 대상 요소(e.target)가 'modal' 클래스를 가지고 있는지 확인합니다.
  if($(e.target).hasClass('modal')){
    // 대상 요소가 'modal' 클래스를 가지고 있다면 모달을 숨깁니다.
    $('.modal').removeClass('show');
  }
})

// myModule 함수 정의
function myModule(cate, keyword, callback) {
  // jQuery를 사용한 AJAX 요청 시작
  $.ajax({
    // 서버로 보낼 요청 URL을 구성합니다.
    url: `/counselor/counselorBook/${page}`, // 페이지 변수(page)가 누락되어 있음
    // HTTP 요청 메서드를 'GET'으로 설정
    type: 'get',
    // 서버로부터 기대하는 응답 데이터 형식을 JSON으로 설정
    dataType: 'json',
    // 요청에 포함할 데이터를 설정 (cate 및 keyword 매개변수 사용)
    data: { cate: cate, keyword: keyword },
    // 요청이 성공했을 때 실행할 함수
    success: function (result) {
      // 서버로부터 받은 결과를 콘솔에 출력
      console.log(result);
      // 만약 콜백 함수(callback)가 제공되었다면 해당 함수를 호출합니다.
      if (callback) {
        callback(result);
      }
    },
    // 요청이 실패했을 때 실행할 함수
    error: function (a, b, c) {
      // 에러 메시지를 콘솔에 출력
      console.log(c);
    }
  });
}

// 페이지 내에서 '.page-box' 클래스를 가진 요소를 찾아서, 그 안에 있는 '.page-num' 클래스를 가진 요소 클릭 시 이벤트를 처리합니다.
$('.page-box').on('click', '.page-num', function () {
  console.log("click"); // 콘솔에 "click" 메시지를 출력합니다.

  // 클릭한 요소의 'data-page' 속성 값을 가져와서 'page' 변수에 저장합니다.
  page = $(this).data('page');

  // 'cate', 'keyword', 'showResult' 변수를 이용하여 myModule 함수를 호출합니다.
  myModule(cate, keyword, showResult);
});
