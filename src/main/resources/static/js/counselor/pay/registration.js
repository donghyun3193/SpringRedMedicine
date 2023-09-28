// function call_confirm1(){
//     if(confirm("등록을 취소 하시겠습니까?")){
//         alert("등록이 취소 되었습니다.");
//     }else{
//         window.location.href = '/counselor/pay/payMate'
//     }
// }
function call_confirm(){
    if(confirm("사진을 넣어주세요!")){
        window.location.href = '/counselor/pay/registration'
    }else{

    }
}

// input 상담 대상 데이터 뽑기
$('.btn').on('click', function() {

    makeCheck1();
    makeCheck2();
    makeCheck3();
    makeCheck4();

    $('.frm').submit();
})

// 'makeCheck1' 함수 정의
function makeCheck1() {
    // 빈 배열 'result'를 생성하여 선택된 체크박스의 값을 저장할 준비를 합니다.
    let result = [];

    // 선택된 클래스 'ch'를 가진 체크박스 요소들을 찾아서 각각에 대해 다음 동작을 수행합니다.
    $('.ch:checked').each((i, ele) => {
        // 'ele'은 현재 처리 중인 체크박스 요소를 나타냅니다.

        // 선택된 체크박스 요소의 값을 가져와서 'result' 배열에 추가합니다.
        result.push($(ele).val());
    });

    // 선택된 값들을 쉼표와 공백으로 구분된 문자열로 변환하고,
    // 이 문자열을 클래스 'num'을 가진 입력란에 설정합니다.
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