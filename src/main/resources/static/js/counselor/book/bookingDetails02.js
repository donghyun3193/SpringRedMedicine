// // 예약 날짜와 시간을 sessionStorage에서 가져옴
// const bookDate = sessionStorage.getItem('bookDate');
// const bookTime = sessionStorage.getItem('bookTime');
// const userCNumber = sessionStorage.getItem('userCNumber', cnumber);;
//
// console.log('Book Date:', bookDate);
// console.log('Book Time:', bookTime);
// console.log('userCNumber:', userCNumber);

function choiceDateAndTime() {
        // 예약 날짜와 시간을 sessionStorage에서 가져옴
        const bookDate = sessionStorage.getItem('bookDate');
        const bookTime = sessionStorage.getItem('bookTime');

        // 여기서 userCNumber를 가져오거나 설정하는 방법에 따라서 아래 코드 중 하나를 선택하세요.
        // 예시 1: userCNumber를 가져오는 경우
        const userCNumber = sessionStorage.getItem('userCNumber');

        console.log('Book Date:', bookDate);
        console.log('Book Time:', bookTime);
        console.log('userCNumber:', userCNumber);

        // 데이터를 sessionStorage에 저장
        sessionStorage.setItem('bookDate', bookDate);
        sessionStorage.setItem('bookTime', bookTime);
        sessionStorage.setItem('userCNumber', userCNumber);

        const checkboxes = document.querySelectorAll('.checkbox1');
        let allChecked = true;

        checkboxes.forEach(checkbox => {
                if (!checkbox.checked) {
                        allChecked = false;
                        return;
                }
        });

        if (allChecked) {
                // 모든 체크박스가 체크되었을 때 다음 단계로 이동
                window.location.href = '/counselor/bookingDetails03';
        } else {
                // 얼럿창 표시
                alert('모든 동의 항목에 체크해주세요.');
        }

}

