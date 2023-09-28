// reply.js는 모듈을 만들어 두는 파일이다.
// 자바스크립트의 함수, 클래스를 모듈화 시켜 저장하는 공간이다.
// 우리는 함수를 부품처럼 만들어두고 다른 파일에서 사용할 것이다.
// 이 모듈들을 밖에서 사용할 수 있도록 내보내는 키워드가 export이다.

// jquery ajax 프로퍼티 종류
// url : 요청보내는 경로
// type : method (요청 방식)
// data : 요청 보낼때 전송할 데이터
// dataType : 받는 데이터의 타입 -> 'json'
// contentType : 전송할 데이터의 타입 -> 'application/json; charset=utf-8'
// success : 성공했을 때 실행할 함수
// error :  실패 했을 때 실행할 함수

// JSON.stringify()
//    js 객체 -> json
// JSON.parse()
//    json -> js 객체

// add 함수를 정의합니다. 이 함수는 서버에 데이터를 전송합니다.
export function add(reply, callback) {
    // jQuery의 AJAX 메서드를 사용하여 서버에 데이터를 전송합니다.
    $.ajax({
        // 전송할 URL을 지정합니다.
        url: "/replies",
        // HTTP 요청 방식을 POST로 설정합니다.
        type: "post",
        // 전송할 데이터를 JSON 문자열로 변환하고 설정합니다.
        data: JSON.stringify(reply),
        // 전송할 데이터의 형식을 JSON으로 지정합니다.
        contentType: 'application/json; charset=utf-8',
        // 요청이 성공했을 때 실행할 콜백 함수를 설정합니다.
        success: function () {
            // 만약 callback 함수가 제공되었다면 실행합니다.
            if (callback) {
                callback();
            }
        },
        // 요청이 실패했을 때 실행할 에러 처리 함수를 설정합니다.
        error: function (a, b, c) {
            // 콘솔에 에러 메시지를 출력합니다.
            console.error(c);
        }
    });
}


// 'getList' 함수를 정의합니다. 이 함수는 서버에서 데이터를 비동기적으로 가져오는 역할을 합니다.
// 'profileNumber'는 서버에서 어떤 프로필의 데이터를 가져올지를 나타내는 매개변수입니다.
// 'callback'은 데이터를 성공적으로 가져온 후에 실행할 함수를 나타냅니다.
export function getList(profileNumber, callback) {
    // jQuery의 $.ajax 함수를 사용하여 서버로 HTTP GET 요청을 보냅니다.
    $.ajax({
        // 요청할 URL을 지정합니다. ${profileNumber}는 프로필 번호를 나타내며 요청 URL에 동적으로 삽입됩니다.
        url: `/replies/list/${profileNumber}`,
        // 요청의 HTTP 메서드를 지정합니다.
        type: 'get',
        // 서버에서 반환되는 데이터의 형식을 JSON으로 지정합니다.
        dataType: 'json',
        // 요청이 성공한 경우 실행되는 콜백 함수를 정의합니다.
        success: function (result) {
            // 'callback' 매개변수가 전달되었을 경우, 이를 호출하여 서버에서 받아온 데이터를 처리합니다.
            if (callback) {
                callback(result);
            }
        },
        // 요청이 실패한 경우 실행되는 콜백 함수를 정의합니다.
        error: function (a, b, c) {
            // 콘솔에 에러 메시지를 출력합니다.
            console.error(c);
        }
    });
}


export function getDetails(pfCommentNumber, callback){
    $.ajax({
        url : `/replies/${pfCommentNumber}`,
        type : 'get',
        dataType : 'json',
        success : function (result){
            if(callback){
                callback(result);
            }
        },
        error : function (a, b, c){
            console.error(c);
        }
    });
}

// modify 함수 정의
export function modify(pfCommentNumber, reply, callback){
    // jQuery의 $.ajax() 메서드를 사용하여 서버로 HTTP PATCH 요청을 보냄
    $.ajax({
        // 요청을 보낼 URL. URL 내에 pfCommentNumber 변수 값을 포함함
        url : `/replies/${pfCommentNumber}`,
        // HTTP 요청의 타입을 'patch'로 설정 (업데이트 요청)
        type : 'patch',
        // 서버에 전송할 데이터를 JSON 문자열로 변환하고 전송
        data : JSON.stringify(reply),
        // 요청의 Content-Type 헤더를 JSON 형식으로 설정
        contentType : 'application/json; charset=utf-8',
        // 요청이 성공했을 때 실행되는 함수
        success : function (){
            // 콜백 함수(callback)가 제공되었다면 실행
            if(callback){
                callback();
            }
        },
        // 요청이 실패했을 때 실행되는 함수
        error : function (a, b, c){
            // 콘솔에 오류 메시지 출력
            console.error(c);
        }
    });
}



// 'remove'라는 이름의 JavaScript 함수를 정의합니다.
// 이 함수는 두 개의 매개변수를 받습니다.
// 1. pfCommentNumber: 삭제할 댓글 번호를 나타내는 매개변수입니다.
// 2. callback: 삭제가 성공한 경우 호출할 콜백 함수를 나타내는 매개변수입니다.
export function remove(pfCommentNumber, callback) {
    // jQuery를 사용하여 AJAX 요청을 보냅니다.
    $.ajax({
        // 요청할 URL을 설정합니다. URL은 '/replies/{pfCommentNumber}' 형식입니다.
        url: `/replies/${pfCommentNumber}`,
        // HTTP 요청 메서드를 'delete'로 설정하여 DELETE 요청을 보냅니다.
        type: 'delete',
        success: function () {
            // 성공적으로 요청이 처리되면 이 함수가 호출됩니다.
            // 성공 콜백 함수를 호출합니다.
            if (callback) {
                callback();
            }
        },
        error: function (a, b, c) {
            // 요청이 실패하면 이 함수가 호출됩니다.
            // 콘솔에 오류 메시지를 출력합니다.
            console.error(c);
        }
    });
}



export function getListPage(pageInfo, callback){
    $.ajax({
        url: `/replies/list/${pageInfo.profileNumber}/${pageInfo.page}`,
        type : 'get',
        dataType : 'json',
        success : function (result){
            if(callback){
                callback(result);
            }
        },
        error : function (a,b,c){
            console.error(c);
        }
    });
}


export function timeForToday(value){
    const today = new Date(); //현재 날짜와 시간을 가진 객체
    const timeValue = new Date(value);

    // getTime() 1970년 1/1일을 기준으로 지금까지 몇 ms가 지났는지 알려준다.
    //Math.floor() 는 소수점을 버림 처리 해준다.
    const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);

    if(betweenTime < 1) { return "방금 전"; }

    if(betweenTime < 60) { return `${betweenTime}분 전`; }

    const betweenTimeHour = Math.floor(betweenTime/60);
    if(betweenTimeHour < 24) { return `${betweenTimeHour}시간 전`; }

    const betweenTimeDay = Math.floor(betweenTimeHour/ 24);
    if(betweenTimeDay < 365) { return `${betweenTimeDay}일 전`; }

    return `${Math.floor(betweenTimeDay / 365)}년 전`;
}







































