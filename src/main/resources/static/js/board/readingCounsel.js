// 목록 버튼
$('#list-button').on('click', function (){
    window.location.href = '/board/counselBoard';
})

// 수정 버튼
$('#modify-button').on('click', function (){
    let counselorNumber = $(this).data('number');
    window.location.href = '/board/modifyCounsel?counselorNumber=' + counselorNumber;
});

//삭제 버튼
$('#remove-button').on('click', function () {
    let counselorNumber = $(this).data('number');
    if(confirm("글을 삭제 하시겠습니끼?")){
        window.location.href = '/board/removeCounsel?counselorNumber=' + counselorNumber;
    }
});



//detail페이지 이미지 띄우기 처리
displayAjax();

function displayAjax(){
    let counselorNumber = $('.counsel-num').val();

    $.ajax({
        url : '/cFiles/imgList',
        type : 'get',
        data : {counselorNumber : counselorNumber},
        success : function (cFileList) {
            let text = '';

            cFileList.forEach(file => {
                // console.log(file);
                let cFileName = file.cFileRoute + '/' + file.cFileUuid + '_' + file.cFileName;

                text += `<img src="/cFiles/display?cFileName=${cFileName}" data-number=${file.cFileNumber} />`;

            });

            $('.post-images').html(text);
        }
    });
}