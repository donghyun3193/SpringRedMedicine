let bookDate = $('.bookDateInput').text().replace('00:00:00','');

$('.submitButton').on('click', function () {
    let userName = $('.userNameInput').text();
    let userPhoneNumber = $('.userPhoneNumberInput').val().replaceAll('-','');
    let counselorName = $('.counselorNameInput').text();
    let bookDate = $('.bookDateInput').text().replace('00:00:00','');
    let bookTime = $('.bookTimeInput').text();

    console.log(userName);
    console.log(counselorName);
    console.log(bookDate);
    console.log(bookTime);

    let params = {
        userName: userName,
        userPhone : userPhoneNumber,
        counselorName :counselorName,
        bookDate : bookDate,
        bookTime : bookTime
    }

    $.ajax({

        url: '/sms/v1/sendBookMsg',
        type: 'post',
        data: JSON.stringify(params),
        contentType: 'application/json; charset=utf-8',
        success: function () {

            alert("입력하신 번호로 예약하신 내용이 발송되었습니다.")
        }
    })
})