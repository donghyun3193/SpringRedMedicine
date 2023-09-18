// 버튼 요소를 가져옵니다.
const toggleButton = document.getElementById('toggleButton');

// 버튼 클릭 시 실행할 함수를 정의합니다.
toggleButton.addEventListener('click', function () {
    // 버튼의 현재 텍스트 내용을 가져옵니다.
    const buttonText = toggleButton.textContent;

    // 텍스트가 "공개"인 경우 "비공개"로, "비공개"인 경우 "공개"로 변경합니다.
    if (buttonText === '공개') {
        toggleButton.textContent = '비공개';
        alert('비공개로 변경 되었습니다.');
    } else {
        toggleButton.textContent = '공개';
        alert('공개로 변경 되었습니다.');
    }
});