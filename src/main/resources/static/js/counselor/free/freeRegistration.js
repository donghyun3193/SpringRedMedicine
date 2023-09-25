function call_confirm1(){
    if(confirm("등록을 취소 하시겠습니까?")){
        alert("등록이 취소 되었습니다.");
    }else{

    }
}
function call_confirm2(){
    if(confirm("등록 하시겠습니까?")){
        alert("등록 되었습니다.");
    }else{

    }
}

$('.btn').on('click', function() {

    makeCheck1();
    makeCheck2();
    makeCheck3();
    makeCheck4();

    $('.frm').submit();
})

function makeCheck1(){
    let result = [];
    $('.ch:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num').val(result.join(', '));
}


function makeCheck2(){
    let result = [];
    $('.ch1:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num1').val(result.join(', '));
}

function makeCheck3(){
    let result = [];
    $('.ch2:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num2').val(result.join(', '));
}

function makeCheck4(){
    let result = [];
    $('.ch3:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num3').val(result.join(', '));
}

//    파일처리

//파일 길이 체크 함수(체크할 files객체, 제한할 길이)
function checkLength(files, num) {
    if (files.length > num) {
        alert(`파일은 최대 ${num}개까지만 첨부 가능합니다.`);
        // 최대 수를 넘으면 비어있는 files객체 반환
        return new DataTransfer().files;
    }
    return files;
}