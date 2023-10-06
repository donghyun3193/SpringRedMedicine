//댓글 js 시작
import * as cReply from '../module/cReply.js';
//모듈을 불러와 사용할 것 따라서 import를 가져올것이다!
// 모듈 경로는 상대경로로 접근해야한다.
// 파일명 뒤에 반드시 확장자를 작성한다!!
let counselorNumber = $('.counsel-num').val();

//리플 작성 완료 처리 즉 작성완료 버튼을 클릭했을 때 add될 수 있도록!
$('.btn-reply').on('click', function () {
    let content = $('#reply-content').val();
    console.log(content);
    if(!(content && loginNumber)){
        alert('오류의 상황 비로그인 or 내용없음');
        return;//밑으로 코드를 읽지 못하도록!
    }
    // console.log(content);
    // value로 텍스트를 가져오는것이 맞았다
    // 내용, 작성자 정보 등등

    let replyObj = {
        ccommentContent : content,//서버에서 인지불가 cCommentContent -> ccommentContent 수정
        counselorNumber : counselorNumber,
        userNumber : loginNumber//html 세션을 가져온 것!
    };

    cReply.add(replyObj, function(){ //콜백이 cReply.js로 갈 것
        cReply.getList(counselorNumber, showReply);
    });//여기로 넘겨줘야지! 그런 뿅 날아간다~~ reply.js의 ajax로!

    $('#reply-content').val('');//매개변수를 쓴다면 빈 문자열이 여기로 이동된다
});



// reply.getList(profileNumber, showReply);
let page = 1;

cReply.getListPage({counselorNumber:counselorNumber, page : page}, appendReply);


function appendReply(map){//result는 배열을 받아오는 것 List의
    console.log(map);

    let text = '';

    map.cCommentList.forEach( r => {//반복을 돌리겠다
        text += `
            <div class="reply" data-num="${r.ccommentNumber}">
            <!--댓 삭제를 위해선 number가 필요했기에 임으로 삽입!-->
              <div class="reply-box">
                <div class="reply-box__writer">${r.userName}</div>
                <div class="reply-box__content">${r.ccommentContent}</div>
                <!--화면에서 정보를 받을 수 있도록 cCommentContent -> ccommentContent-->
              </div>
            
              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').append(text);
}

//무한 스크롤 페이징의 이벤트 처리
$(window).on('scroll', function (){

    // 현재 브라우저의 스크롤 위치를 의미함
    console.log(`scrollTop : ${ $(window).scrollTop() }`);
    // 문서 전체의 높이를 구함
    console.log(`document : ${ $(document).height() }`);
    //브라우저 화면의 높이를 구함
    console.log(`window : ${ $(window).height() }`);

    if(Math.ceil($(window).scrollTop()) == $(document).height() - $(window).height()){
        console.log(++page);
        cReply.getListPage({counselorNumber:counselorNumber, page : page}, appendReply);
    }

});

/**
 * 리플 목록을 만들어주는 콜백 함수
 *
 * @param result 리플 정보를 가진 배열객체
 */
function showReply(result){//result는 배열을 받아오는 것 List의
    console.log(result);

    let text = '';

    result.forEach( r => {
        text += `
            <div class="reply" data-num="${r.ccommentNumber}">
              <div class="reply-box">
                <div class="reply-box__writer">${r.userName}</div>
                <div class="reply-box__content">${r.ccommentContent}</div>
                <!--받은 정보를 다시 뿌리기 위해서 cCommentContent -> ccommentContent-->
              </div>
              
              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );//text변수에 Content가 누적 될 것!

    $('.reply-list-wrap').html(text);
}





$('.reply-list-wrap').on('click', '.reply-btns', function () {
    let $replyBtnBox = $(this).closest('.reply-btn-box').find('.reply-btns__box');

    $('.reply-btns__box').addClass('none');

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


// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    $('.reply-btns__box').addClass('none');

    let ccommentNumber = $(this).closest('.reply').data('num');

    cReply.remove(ccommentNumber, function (){
        cReply.getList(counselorNumber, showReply);
    });//새로고침없이 바로바로 삭제되도록 설정 콜백을 통해서
    //reply.remove(cCommentNumber)만 있다면 삭제되나 화면에는 그대로 따라서 새로고침이 필요했다
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
    //넘버는 삭제와 동일한 방식으로 불러올 수 있다 왜냐하면 처음에 조상을 잡았기 때문에
    let ccommentNumber = $(this).closest('.reply').data('num');
    //수정완료 버튼의 형제요소인 textarea를 찾아서 적용해라!-부모중 modify-box를 찾아서 그 하위 중 .modify-content를 찾아라!
    let ccommentContent = $(this).closest('.modify-box').find('.modify-content').val();
    //위에서 찾은 num과 content를 넘겨줘야한다
    //이 때 찾은 내용을 Obj에 저장해라!
    let replyObj = {ccommentContent : ccommentContent};

    //여기에 콜백을 사용해서 바로바로 적용되도록!
    cReply.modify(ccommentNumber, replyObj, function (){
        cReply.getList(counselorNumber, showReply);
    });
});


