//댓글 관련 js
import * as reply from '../../module/reply.js';
//모듈 경로는 상대경로로 접근해야한다.
// 파일명 뒤에 반드시 확장자를 작성한다!!!!!!!!!
let profileNumber = $('.profile-num').val();

//리플 작성 완료 처리
$('.btn-reply').on('click', function () {
    let content = $('#reply-content').val();

console.log(content)

    if(!(content && loginNumber)){
        alert('댓글을 입력 해주세요!');
        return;
    }

    let replyObj = {
        pfCommentContent : content,
        profileNumber : profileNumber,
        userNumber : loginNumber
    };

    reply.add(replyObj, function(){
        reply.getList(profileNumber, showReply);
    });

    $('#reply-content').val('');
});



// reply.getList(profileNumber, showReply);
let page = 1;

reply.getListPage({profileNumber:profileNumber, page : page}, appendReply);


function appendReply(map){
    console.log(map);

    let text = '';

    map.replyList.forEach( r => {
        text += `
            <div class="reply" data-num="${r.pfCommentNumber}">
              <div class="reply-box">
                <div class="reply-box__writer">${r.userName}</div>
                <div class="reply-box__content">${r.pfCommentContent}</div>
              </div>
            
            <div class="reply-time">
                ${reply.timeForToday(r.pfCommentDate)}
            </div>  
            
              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="btn-remove">삭제</div>
                  <div class="btn-modify">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').append(text);
}

//무한 스크롤 페이징
// $(window).on('scroll', function (){
//
//     // 현재 브라우저의 스크롤 위치를 의미함
//     console.log(`scrollTop : ${ $(window).scrollTop() }`);
//     // 문서 전체의 높이를 구함
//     console.log(`document : ${ $(document).height() }`);
//     //브라우저 화면의 높이를 구함
//     console.log(`window : ${ $(window).height() }`);
//
//     if(Math.round($(window).scrollTop()) == $(document).height() - $(window).height()){
//         console.log(++page);
//         reply.getListPage({profileNumber:profileNumber, page : page}, appendReply);
//     }
//
// });
/**
 * 리플 목록을 만들어주는 콜백 함수
 *
 * @param result 리플 정보를 가진 배열객체
 */
function showReply(result){
    console.log(result);

    let text = '';

    result.forEach( r => {
        text += `
            <div class="reply" data-num="${r.pfCommentNumber}">
              <div class="reply-box">
                <div class="reply-box__writer">${r.userName}</div>
                <div class="reply-box__content">${r.pfCommentContent}</div>
              </div>
              
                            <div class="reply-time">
                ${reply.timeForToday(r.pfCommentDate)}
              </div>  

              <div class="reply-btn-box">
              `;

        if(r.userNumber == loginNumber) {
            text += `<span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="btn-remove">삭제</div>
                  <div class="btn-modify">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

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



//삭제 버튼
$('.btn-remove').on('click', function (){
    let profileNumber = $(this).data('number');
    window.location.href = '/counselor/pay/counselorProfilePay/remove?profileNumber=' + profileNumber;

});

// 수정 버튼
$('.btn-modify').on('click', function (){
    let profileNumber = $(this).data('number');
    window.location.href = '/counselor/pay/counselorProfilePay/modify?profileNumber=' + profileNumber;
});

// 리플 작성 완료 처리
$('.btn-reply').on('click', function (){

});



// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    $('.reply-btns__box').addClass('none');

    let pfCommentNumber = $(this).closest('.reply').data('num');

    console.log(pfCommentNumber)

    reply.remove(pfCommentNumber, function (){
        reply.getList(profileNumber, showReply);
    });
});

// 리플 수정 버튼 처리
$('.reply-list-wrap').on('click', '.reply-modify-btn', function () {
    let $content = $(this).closest('.reply').find('.reply-box__content');

    console.log($content)

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
    let pfCommentNumber = $(this).closest('.reply').data('num');
    let pfCommentContent = $(this).closest('.modify-box').find('.modify-content').val();
    console.log(pfCommentContent);
    let replyObj = {pfCommentContent : pfCommentContent};

    reply.modify(pfCommentNumber, replyObj, function (){
        reply.getList(profileNumber, showReply);
    });
});























