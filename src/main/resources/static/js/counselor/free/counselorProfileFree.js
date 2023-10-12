//댓글 관련 js
import * as reply from '../../module/reply.js';
//모듈 경로는 상대경로로 접근해야한다.
// 파일명 뒤에 반드시 확장자를 작성한다!!!!!!!!!
let profileNumber = $('.profile-num').val();

reply.getList(profileNumber, showReply);
//페이지 들어가면 댓글 리스트 화면에 뿌려 줌.

//리플 작성 완료 처리
// 댓글 작성 버튼인 '.btn-reply' 요소에 클릭 이벤트 핸들러를 등록합니다.
$('.btn-reply').on('click', function () {
    // '#reply-content' 요소에서 입력된 내용을 가져와 변수 'content'에 저장합니다.
    let content = $('#reply-content').val();

    // 'content'가 존재하고 'loginNumber'도 존재할 경우에만 아래 코드를 실행합니다.
    if (!(content && loginNumber)) {
        // 댓글이나 로그인이 되어 있지 않을 경우 경고창을 띄우고 함수를 종료합니다.
        alert('댓글을 입력 해주세요!');
        return;
    }

    // 'replyObj'라는 객체를 생성합니다.
    let replyObj = {
        // 'pfCommentContent' 속성에 'content' 변수 값을 저장합니다.
        pfCommentContent: content,
        // 'profileNumber' 속성에 'profileNumber' 변수 값을 저장합니다.
        profileNumber: profileNumber,
        // 'userNumber' 속성에 'loginNumber' 변수 값을 저장합니다.
        userNumber: loginNumber
    };

    // 'reply' 객체의 'add' 함수를 호출하고 'replyObj' 객체를 전달합니다.
    // 이 함수는 댓글을 추가하는 동작을 수행할 것입니다.
    reply.add(replyObj, function(){
        // 콜백 함수로 넘겨준 함수가 실행될 수 있습니다.
        reply.getList(profileNumber, showReply);
    });



    // '#reply-content' 요소의 값을 비웁니다.
    $('#reply-content').val('');
});




// reply.getList(profileNumber, showReply);
let page = 1;

reply.getListPage({profileNumber:profileNumber, page : page}, appendReply);


function appendReply(map){
    console.log(map);

    let text = '';

    map.pfCommentList.forEach( r => {
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
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').append(text);
}

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
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>`;
        }

        text +=`</div>
            </div>`;
    } );

    $('.reply-list-wrap').html(text);
}



// 댓글 버튼을 클릭할 때 발생하는 이벤트 핸들러
$('.reply-list-wrap').on('click', '.reply-btns', function () {
    // 클릭한 댓글 버튼의 가장 가까운 부모 요소 중 'reply-btn-box' 클래스를 가진 요소를 찾음
    let $replyBtnBox = $(this).closest('.reply-btn-box').find('.reply-btns__box');

    // 모든 'reply-btns__box' 요소에 'none' 클래스를 추가하여 숨김
    $('.reply-btns__box').addClass('none');

    // 클릭한 댓글 버튼의 부모 요소인 'reply-btn-box' 안의 'reply-btns__box'를 토글(숨기기/보이기)합니다.
    $replyBtnBox.toggleClass('none');
});
// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    // "reply-list-wrap" 클래스를 가진 요소 안에서 "reply-remove-btn" 클래스를 가진 요소가 클릭되면 이 함수가 실행됩니다.

    // "reply-btns__box" 클래스를 가진 요소에 "none" 클래스를 추가합니다.
    $('.reply-btns__box').addClass('none');

    // 클릭된 요소(삭제 버튼)의 가장 가까운 상위 부모 요소 중 "reply" 클래스를 가진 요소를 찾고, 이 요소의 "num" 데이터 속성 값을 가져옵니다.
    let pfCommentNumber = $(this).closest('.reply').data('num');

    // "pfCommentNumber" 변수에 저장된 값(리플 번호)을 콘솔에 출력합니다.
    console.log(pfCommentNumber)

    // "reply" 객체의 "remove" 함수를 호출하여 해당 "pfCommentNumber" 값을 전달하고, 콜백 함수를 실행합니다.
    // 이 함수는 아마도 서버에서 리플을 삭제하는 작업을 수행할 것으로 보입니다.
    reply.remove(pfCommentNumber, function (){
        // "reply" 객체의 "getList" 함수를 호출하여 "profileNumber"와 "showReply" 함수를 전달하고, 콜백 함수를 실행합니다.
        // 이 함수는 아마도 서버에서 프로필 관련 리플 목록을 가져와서 "showReply" 함수로 표시할 것으로 보입니다.
        reply.getList(profileNumber, showReply);
    });
});

// 문서(body)를 클릭할 때 발생하는 이벤트 핸들러
$('body').click(function (e) {
    // 클릭한 요소가 'reply-btns' 클래스를 가지고 있다면 아무것도 수행하지 않고 종료합니다.
    if ($(e.target).hasClass('reply-btns')) {
        //console.log('aa');
        return;
    }
    // 클릭한 요소가 'reply-btns__box' 요소 안에 없다면 모든 'reply-btns__box' 요소에 'none' 클래스를 추가하여 숨깁니다.
    if (!$('.reply-btns__box').has(e.target).length) {
        $('.reply-btns__box').addClass('none');
    }
});

// 페이지 삭제 버튼을 클릭했을 때 발생하는 이벤트 핸들러
$('.profile-rm-button').on('click',  function () {
    // 클릭한 삭제 버튼의 데이터 속성 'number' 값을 가져옵니다.
    let profileNumber = $(this).data('number');
    // profileNumber 값을 콘솔에 출력합니다.
    console.log(profileNumber);

    // window.location.href를 사용하여 현재 창을 새로운 URL로 리다이렉션합니다.
    // 삭제 동작을 수행하기 위해 '/counselor/pay/counselorProfilePay/remove' URL로 이동하며,
    // 'profileNumber' 매개변수로 클릭한 버튼의 데이터 속성 'number' 값을 전달합니다.
    window.location.href = '/counselor/free/counselorProfileFree/remove?profileNumber=' + profileNumber;
});


// 삭제 버튼을 클릭했을 때 발생하는 이벤트 핸들러
$('.btn-remove').on('click',  function () {
    // 클릭한 삭제 버튼의 데이터 속성 'number' 값을 가져옵니다.
    let profileNumber = $(this).data('profileNumber');
    // profileNumber 값을 콘솔에 출력합니다.
    console.log(profileNumber);

    // window.location.href를 사용하여 현재 창을 새로운 URL로 리다이렉션합니다.
    // 삭제 동작을 수행하기 위해 '/counselor/pay/counselorProfilePay/remove' URL로 이동하며,
    // 'profileNumber' 매개변수로 클릭한 버튼의 데이터 속성 'number' 값을 전달합니다.
    window.location.href = '/counselor/free/counselorProfileFree/remove?profileNumber=' + profileNumber;
});

// 수정 버튼을 클릭했을 때 발생하는 이벤트 핸들러
$('.btn-modify').on('click', function () {
    // 실질적으로 존재 하는 클래스에 -> 뒤에 생기는 클래스에 위임처리 하는 방법.
    // 클릭한 수정 버튼의 데이터 속성 'number' 값을 가져옵니다.
    let profileNumber = $(this).data('number');
    // profileNumber 값을 콘솔에 출력합니다.
    console.log(profileNumber);

    // window.location.href를 사용하여 현재 창을 새로운 URL로 리다이렉션합니다.
    // 수정 동작을 수행하기 위해 '/counselor/pay/counselorProfilePay/modify' URL로 이동하며,
    // 'profileNumber' 매개변수로 클릭한 버튼의 데이터 속성 'number' 값을 전달합니다.
    window.location.href = '/counselor/free/counselorProfileFree/modify?profileNumber=' + profileNumber;
});


// 리플 작성 완료 처리
$('.btn-reply').on('click', function (){

});



// 리플 삭제 버튼 처리
$('.reply-list-wrap').on('click', '.reply-remove-btn', function () {
    // "reply-list-wrap" 클래스를 가진 요소 안에서 "reply-remove-btn" 클래스를 가진 요소가 클릭되면 이 함수가 실행됩니다.

    // "reply-btns__box" 클래스를 가진 요소에 "none" 클래스를 추가합니다.
    $('.reply-btns__box').addClass('none');

    // 클릭된 요소(삭제 버튼)의 가장 가까운 상위 부모 요소 중 "reply" 클래스를 가진 요소를 찾고, 이 요소의 "num" 데이터 속성 값을 가져옵니다.
    let pfCommentNumber = $(this).closest('.reply').data('num');

    // "pfCommentNumber" 변수에 저장된 값(리플 번호)을 콘솔에 출력합니다.
    console.log(pfCommentNumber)

    // "reply" 객체의 "remove" 함수를 호출하여 해당 "pfCommentNumber" 값을 전달하고, 콜백 함수를 실행합니다.
    // 이 함수는 아마도 서버에서 리플을 삭제하는 작업을 수행할 것으로 보입니다.
    reply.remove(pfCommentNumber, function (){
        // "reply" 객체의 "getList" 함수를 호출하여 "profileNumber"와 "showReply" 함수를 전달하고, 콜백 함수를 실행합니다.
        // 이 함수는 아마도 서버에서 프로필 관련 리플 목록을 가져와서 "showReply" 함수로 표시할 것으로 보입니다.
        reply.getList(profileNumber, showReply);
    });
});


// 리플 수정 버튼이 클릭되면 아래의 함수가 실행됩니다.
$('.reply-list-wrap').on('click', '.reply-modify-btn', function () {
    // 클릭된 수정 버튼이 속한 리플(reply) 요소를 찾아서 그 안의 리플 내용을 가져옵니다.
    let $content = $(this).closest('.reply').find('.reply-box__content');

    // 리플 내용을 콘솔에 출력합니다.
    console.log($content)

    // 리플 내용을 수정할 수 있는 입력 폼과 수정 완료 버튼으로 대체합니다.
    $content.replaceWith(`
        <div class='modify-box'>
            <textarea style="resize: none;" class='modify-content'>${$content.text()}</textarea>
            <button type='button' class='modify-content-btn'>수정 완료</button>
        </div>
    `);

    // "수정 완료" 버튼이 추가된 후, 리플 버튼 박스에 'none' 클래스를 추가하여 숨깁니다.
    $('.reply-btns__box').addClass('none');
});


// 리플 수정 완료 처리
$('.reply-list-wrap').on('click', '.modify-content-btn', function () {
    // 'modify-content-btn' 클래스를 가진 요소가 클릭되었을 때 실행되는 함수

    console.log('modify!!!'); // 콘솔에 'modify!!!' 출력

    // 클릭된 요소의 가장 가까운 부모(.reply) 요소에서 'num' 데이터 속성 값을 가져옴
    let pfCommentNumber = $(this).closest('.reply').data('num');

    // 클릭된 요소의 가장 가까운 부모(.modify-box) 요소에서 'modify-content' 클래스를 가진 요소의 값을 가져옴
    let pfCommentContent = $(this).closest('.modify-box').find('.modify-content').val();

    console.log(pfCommentContent); // 콘솔에 'pfCommentContent' 변수의 값을 출력

    // 'replyObj' 객체를 생성하고 'pfCommentContent' 값을 가진 속성을 추가
    let replyObj = { pfCommentContent: pfCommentContent };

    // 'reply' 객체의 'modify' 함수를 호출하여 리플 수정 요청을 보냄
    // 'pfCommentNumber'는 수정 대상 리플의 식별 번호, 'replyObj'는 수정할 내용을 담은 객체
    // 수정 요청이 완료되면 콜백 함수가 실행됨
    reply.modify(pfCommentNumber, replyObj, function () {
        // 수정이 완료되면 'reply.getList' 함수를 호출하여 리플 목록을 다시 가져옴
        // 'profileNumber'와 'showReply'는 다른 곳에서 정의된 변수 또는 함수로 보이며, 이와 관련된 추가 정보가 필요함
        reply.getList(profileNumber, showReply);
    });
});
























