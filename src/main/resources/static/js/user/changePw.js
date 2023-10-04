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
//
//   function checkMatching(name, phone) {
//     // 여기에 이름과 휴대폰 번호를 비교하는 로직을 작성합니다.
//     // 예를 들어, 서버로 요청하여 검증하거나 데이터베이스와 비교할 수 있습니다.
//     // 이 함수는 실제 비교 로직을 대체해야 합니다.
//     // 일치하면 true, 그렇지 않으면 false를 반환합니다.
//     // 예: return name === "예시이름" && phone === "예시휴대폰번호";
//   }


let newPassword = $('.inputpw').val();
let confirmPassword = $('.inputpw2').val();

if(newPassword == "" || confirmPassword == "") {
    $('.inputresult').css('display', 'none');
}else if(newPassword = ""){
    $('.inputresult').css('display', 'none');
    $('.inputpw2').css('display', 'none');
}

//유효성검사
$('.inputpw').keypress(function () {
    let newPassword = $('.inputpw').val();
    let num = newPassword.search(/[0-9]/g);
    let eng = newPassword.search(/[a-z]/ig);

    if(newPassword.length < 8 || newPassword.length > 12){
        $('.inputresult').css('display', 'block');
        $('.inputresult').text("8자리 ~ 12자리 이내로 입력해주세요.");

    }else if(newPassword.search(/\s/) != -1){
        $('.inputresult').css('display', 'block');
        $('.inputresult').text("비밀번호는 공백 없이 입력해주세요.");

    }else if( (num < 0 || eng < 0)){
        $('.inputresult').css('display', 'block');
        $('.inputresult').text("영문 대소문자, 숫자를 혼합하여 입력해주세요.");

    }else{
        $('.inputpw2').css('display', 'block');
    }

    // if((newPassword.length > 7 && newPassword.length < 13) &&
    //     (newPassword.search(/\s/) == -1) &&
    //     (num > 0 && eng > 0)){
    //
    //     $('.inputpw2').css('display', 'block');
    // }

})

$('.inputpw2').keyup(function () {
    let newPassword = $('.inputpw').val();
    let confirmPassword = $('.inputpw2').val();

    let num = newPassword.search(/[0-9]/g);
    let eng = newPassword.search(/[a-z]/ig);

    if (newPassword == confirmPassword) {
        $('.inputresult').css('display', 'block');
        $('.inputresult').text("비밀번호가 일치합니다");
        $('.idfindbutton').attr('disabled',false);

    } else {
        $('.inputresult').css('display', 'block');
        $('.inputresult').text("비밀번호가 일치하지 않습니다");
    }
})


$('.idfindbutton').on('click', function () {
    // let newPassword = $('.inputpw').val();
    // let confirmPassword = $('.inputpw2').val();
    //
    // if(newPassword != confirmPassword){
    //     alert("비밀번호가 일치하지 않습니다")
    // }
    if(confirm("비밀번호를 변경하시겠습니까?")){
        let newPassword = $('.inputpw').val();
        let param = {
            newPassword : newPassword
        }

        $.ajax({
            url : '/users/changePw',
            type : 'post',
            data : JSON.stringify(param),
            contentType : 'application/json; charset=utf-8',
            success : function () {
                alert("비밀변호가 변경되었습니다")

            }
        })
        window.location.href = '/user/login';
    }

})


