// 'main-buttons-button' 클릭 이벤트 핸들러 정의
$('#main-buttons-button').on('click', function (event) {
    event.preventDefault();

    // 각 입력 필드에서 값 가져오기
    let open0 = $('input[name="profileSuper"]').val();
    let open1 = $('input[name="profileCareer"]').val();
    // let open2 = $('input[name="profileFee"]').val();
    let open3 = $('.ch:checked').length > 0;
    let open4 = $('.ch1:checked').length > 0;
    let open5 = $('.ch2:checked').length > 0;
    let open6 = $('.ch3:checked').length > 0;
    let open7 = $('#post-image').val();
    let content = $('#content').val();

    // 조건 확인 및 알림 메시지 표시
    if (open0 === "") {
        alert("슈퍼비전을 확인해 주세요.");
    } else if (open1 === "") {
        alert("상담경력을 확인해 주세요.");
    // } else if (open2 === "") {
    //     alert("비용을 확인해 주세요.");
    } else if (!open3) {
        alert("상담대상을 체크해 주세요.");
    } else if (!open4) {
        alert("상담영역을 체크해 주세요.");
    } else if (!open5) {
        alert("상담 가능 요일을 체크해 주세요.");
    } else if (!open6) {
        alert("상담 가능 시간을 체크해 주세요.");
    } else if (content === "") {
        alert("상담 내용을 확인해 주세요.");
    } else if (open7 === "") {
        alert("이미지 첨부 파일은 필수입니다.");
    } else {
        // 모든 조건이 충족되었으므로 양식 제출을 진행합니다.
        submitForm();
    }
});

// 'btn' 클래스를 가진 요소 클릭 이벤트 핸들러 정의
$('.btn').on('click', function() {
    // 체크된 항목 확인
    let open3 = $('.ch:checked').length > 0;
    let open4 = $('.ch1:checked').length > 0;
    let open5 = $('.ch2:checked').length > 0;
    let open6 = $('.ch3:checked').length > 0;

    // 조건 확인 및 알림 메시지 표시
    if (!open3) {
        alert("상담대상을 체크해 주세요.");
    } else if (!open4) {
        alert("상담영역을 체크해 주세요.");
    } else if (!open5) {
        alert("상담 가능 요일을 체크해 주세요.");
    } else if (!open6) {
        alert("상담 가능 시간을 체크해 주세요.");
    } else {
        // 모든 조건이 충족되었으므로 양식 제출을 진행합니다.
        submitForm();
    }
});

// 'submitForm' 함수 정의 - 양식 제출을 처리합니다.
function submitForm() {
    makeCheck1();
    makeCheck2();
    makeCheck3();
    makeCheck4();

    $('.frm').submit(); // 양식 제출
}

// 'makeCheck1' 함수 정의 - 체크박스 그룹 1의 선택된 값을 가져와서 입력란에 설정합니다.
function makeCheck1() {
    let result = [];

    // 선택된 'ch' 클래스를 가진 체크박스 요소를 찾아서 각각에 대해 다음 작업을 수행합니다.
    $('.ch:checked').each((i, ele) => {
        // 'ele'은 현재 처리 중인 체크박스 요소를 나타냅니다.

        // 선택된 체크박스 요소의 값을 가져와서 'result' 배열에 추가합니다.
        result.push($(ele).val());
    });

    // 선택된 값들을 쉼표와 공백으로 구분된 문자열로 변환하고,
    // 이 문자열을 'num' 클래스를 가진 입력란에 설정합니다.
    $('.num').val(result.join(', '));
}

// 'makeCheck2' 함수 정의 - 체크박스 그룹 2의 선택된 값을 가져와서 입력란에 설정합니다.
function makeCheck2(){
    let result = [];

    // 선택된 'ch1' 클래스를 가진 체크박스 요소를 찾아서 각각에 대해 다음 작업을 수행합니다.
    $('.ch1:checked').each((i, ele) => {
        // 'ele'은 현재 처리 중인 체크박스 요소를 나타냅니다.

        // 선택된 체크박스 요소의 값을 가져와서 'result' 배열에 추가합니다.
        result.push($(ele).val());
    });

    // 선택된 값들을 쉼표와 공백으로 구분된 문자열로 변환하고,
    // 이 문자열을 'num1' 클래스를 가진 입력란에 설정합니다.
    $('.num1').val(result.join(', '));
}

// 'makeCheck3' 함수 정의 - 체크박스 그룹 3의 선택된 값을 가져와서 입력란에 설정합니다.
function makeCheck3(){
    let result = [];

    // 선택된 'ch2' 클래스를 가진 체크박스 요소를 찾아서 각각에 대해 다음 작업을 수행합니다.
    $('.ch2:checked').each((i, ele) => {
        // 'ele'은 현재 처리 중인 체크박스 요소를 나타냅니다.

        // 선택된 체크박스 요소의 값을 가져와서 'result' 배열에 추가합니다.
        result.push($(ele).val());
    });

    // 선택된 값들을 쉼표와 공백으로 구분된 문자열로 변환하고,
    // 이 문자열을 'num2' 클래스를 가진 입력란에 설정합니다.
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