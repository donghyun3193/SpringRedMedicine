// function checkInput() {
//     // 이름과 휴대폰 번호를 입력란에서 가져옵니다.
//     var name = document.getElementById("input-name").value.trim();
//     var phone = document.getElementById("input-phone").value.trim();
//
//     // 이름과 휴대폰 번호가 모두 입력되었는지 확인합니다.
//     if (name === "" || phone === "") {
//       // 입력되지 않은 경우, inputresult를 숨깁니다.
//       document.querySelector(".inputresult").style.display = "none";
//     } else {
//       // 입력된 경우, inputresult를 표시하고 비교합니다.
//       if (checkMatching(name, phone)) {
//         document.querySelector(".inputresult").textContent = ""; // 일치하면 빈 문자열로 설정하여 숨깁니다.
//       } else {
//         document.querySelector(".inputresult").textContent = '"이름" 또는 "휴대폰 번호" 가 일치 하지 않습니다.';
//         document.querySelector(".inputresult").style.display = "block"; // 일치하지 않으면 메시지를 표시합니다.
//       }
//     }
//   }

  // function checkMatching(name, phone) {
    // 여기에 이름과 휴대폰 번호를 비교하는 로직을 작성합니다.
    // 예를 들어, 서버로 요청하여 검증하거나 데이터베이스와 비교할 수 있습니다.
    // 이 함수는 실제 비교 로직을 대체해야 합니다.
    // 일치하면 true, 그렇지 않으면 false를 반환합니다.
    // 예: return name === "예시이름" && phone === "예시휴대폰번호";
  // }
//
// $('.idfindbutton').on('click', function () {
//     $('.inputresult').show();
// });

$('.idfindbutton').on('click', function () {
    let userName = $('#nameInput').val();
    let userPhone = $('#phoneInput').val();

    $.ajax({
        url : '/users/findId',
        type : 'get',
        data : {userName : userName, userPhone : userPhone},
        success : function (resultText) {
            console.log(resultText);

            $('.inputresult').css('display','block');
            $('.inputresult').text(resultText);
        }
    })
});

// $(document).ready(function () {
//     console.log("=======================찍히니")
//     $('.idfindbutton').on('click', function (e) {
//         e.preventDefault();
//
//         let userName = $('#nameInput').val();
//         let userPhone = $('#phoneInput').val();
//         console.log("=======================찍히나요");
//         console.log(userName);
//         console.log(userPhone);
//         $.ajax({
//             url: '/user/findId',
//             type: 'post',
//             data: { userName: userName, userPhone: userPhone },
//             dataType: 'text',
//             success: function (resultText) {
//                 console.log(resultText);
//                 $('.inputresult').html(resultText);
//                 $('.inputresult').show();
//             },
//             error: function (xhr, status, error) {
//                 console.error('AJAX 요청 실패:', error);
//             }
//         });
//     });
// });

// function checkInput() {
//     // 이름과 휴대폰 번호를 입력란에서 가져옵니다.
//     var name = document.getElementById("nameInput").value.trim();
//     var phone = document.getElementById("phoneInput").value.trim();
//
//     // 이름과 휴대폰 번호가 모두 입력되었는지 확인합니다.
//     if (name === "" || phone === "") {
//         // 입력되지 않은 경우, inputresult를 숨깁니다.
//         document.querySelector(".inputresult").style.display = "none";
//     } else {
//         // 입력된 경우, 서버로 데이터를 전송하여 비교합니다.
//         $.ajax({
//             url: "/user/findId", // 서버 요청을 보낼 URL을 지정합니다.
//             type: "POST",
//             dataType: "json", // 서버 응답 데이터 타입을 JSON으로 지정합니다.
//             data: JSON.stringify({ name: name, phone: phone }), // JSON 형식으로 데이터를 전송합니다.
//             contentType: "application/json", // Content-Type을 JSON으로 설정합니다.
//             success: function (response) {
//                 if (response.matching) {
//                     document.querySelector(".inputresult").textContent = ""; // 일치하면 빈 문자열로 설정하여 숨깁니다.
//                 } else {
//                     document.querySelector(".inputresult").textContent = '"이름" 또는 "휴대폰 번호" 가 일치 하지 않습니다.';
//                     document.querySelector(".inputresult").style.display = "block"; // 일치하지 않으면 메시지를 표시합니다.
//                 }
//             },
//             error: function (xhr, status, error) {
//                 console.error("서버 요청 실패:", error);
//             }
//         });
//     }
// }