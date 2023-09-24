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

// input 상담 대상 데이터 뽑기
$('.btn').on('click', function() {
    console.log($('.ch:checked'));
    let result = [];
    $('.ch:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num').val(result.join(', '));
    // $('.frm').submit();
})
// input 상담 영역 데이터 뽑기
$('.btn').on('click', function() {
    console.log($('.ch1:checked'));
    let result = [];
    $('.ch1:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num1').val(result.join(', '));
    // $('.frm').submit();
})
// input 상담 가능 요일 데이터 뽑기
$('.btn').on('click', function() {
    console.log($('.ch2:checked'));
    let result = [];
    $('.ch2:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num2').val(result.join(', '));
    // $('.frm').submit();
})
// input 상담 가능 시간 데이터 뽑기
$('.btn').on('click', function() {
    console.log($('.ch3:checked'));
    let result = [];
    $('.ch3:checked').each((i, ele) => {
        result.push($(ele).val());
    });

    $('.num3').val(result.join(', '));
    // $('.frm').submit();
})

