// 목록 버튼
$('#list-button').on('click', function (){
    window.location.href = '/notice/list';
})

// 수정 버튼
$('#modify-button').on('click', function (){
    let noticeNumber = $(this).data('number');
    window.location.href = '/notice/modify?noticeNumber=' + noticeNumber;
});

//삭제 버튼
$('#remove-button').on('click', function () {
    let noticeNumber = $(this).data('number');
    if(confirm("글을 삭제 하시겠습니끼?")){
    window.location.href = '/notice/remove?noticeNumber=' + noticeNumber;
    }
});

let content = $('.content-text').text();
content.replaceAll('\n', '<br/>');