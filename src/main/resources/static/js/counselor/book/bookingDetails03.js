// textarea 요소와 버튼 요소를 가져옵니다.
const textarea = document.getElementById("writing-area");
const submitButton = document.getElementById("submitButton");

// textarea 내용이 변경될 때마다 이벤트를 감지하여 처리합니다.
textarea.addEventListener("input", function () {
    // textarea 내용이 비어 있는지 확인합니다.
    if (textarea.value.trim() === "") {
        // textarea가 비어 있다면 버튼을 비활성화합니다.
        submitButton.disabled = true;
    } else {
        // textarea에 내용이 있다면 버튼을 활성화합니다.
        submitButton.disabled = false;
    }
});


// 예약 날짜와 시간을 sessionStorage에서 가져옴
const bookDate = sessionStorage.getItem('bookDate');
const bookTime = sessionStorage.getItem('bookTime');
const userCNumber = sessionStorage.getItem('userCNumber');

console.log('Book Date:', bookDate);
console.log('Book Time:', bookTime);
console.log('userCNumber:', userCNumber);


// const textarea = document.getElementById("writing-area");
// const submitButton = document.getElementById("submitButton");
const bookingForm = document.getElementById("bookingForm");
const bookDateInput = document.getElementById("bookDate");
const bookTimeInput = document.getElementById("bookTime");
const userCNumberInput = document.getElementById("userCNumber");

textarea.addEventListener("input", function () {
    if (textarea.value.trim() === "") {
        submitButton.disabled = true;
    } else {
        submitButton.disabled = false;
    }
});

userCNumberInput.value = userCNumber;
bookDateInput.value = bookDate;
bookTimeInput.value = bookTime;

submitButton.addEventListener("click", function () {
    // alert("메인 페이지로 이동합니다.");
    //
    // window.location.href = "/src/main/resources/templates/main/index.html";

    alert("예약이 완료되었습니다.");

    sessionStorage.clear();

});


