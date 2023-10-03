const toggleButtons = document.querySelectorAll('.td-open');

toggleButtons.forEach(button => {
    button.addEventListener('click', function () {
        const buttonText = button.textContent.trim();
        button.textContent = buttonText === '공개' ? '비공개' : '공개';
        alert(`일기 공개여부가 "${button.textContent}"으로 변경되었습니다.`);
    });
});