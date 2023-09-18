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

// 전송 버튼 클릭 시 페이지 이동을 처리합니다.
submitButton.addEventListener("click", function () {
    // 입력된 텍스트를 서버로 전송 (이 부분은 서버 측 코드로 대체되어야 합니다).
    const content = textarea.value.trim();
    // 서버로 데이터를 전송하는 코드를 여기에 추가하세요.

    alert("메인 페이지로 이동합니다.");
    // 페이지 이동을 수행합니다.
    window.location.href = "/html/index.html"; // 이동할 페이지의 URL로 변경하세요.
});