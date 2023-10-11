$('.idfindbutton').on('click', function () {
    let passwordInput = $('.userPassword').val();
    console.log('===============passwordInput: '+ passwordInput);
    $.ajax({
        url : '/users/checkPw',
        type : 'get',
        success : function (userPassword) {
            console.log('===============userPassword: '+userPassword);
            console.log(passwordInput);
            if(userPassword === passwordInput){
                console.log("비밀번호 일치");
                window.location.href = '/user/showmypage';
            }else{
                alert("비밀번호가 일치하지 않습니다.");
            }
        }
    })
});
