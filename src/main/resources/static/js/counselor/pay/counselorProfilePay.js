// JavaScript 함수를 정의하여 페이지 이동을 처리
function reservation() {
    // 페이지 이동을 원하는 URL로 변경
    window.location.href = '/counselor/book/bookingDetails'; // 이동하려는 URL을 여기에 입력
}
function modifybtn() {
    // 페이지 이동을 원하는 URL로 변경
    window.location.href = '/counselor/pay/registration'; // 이동하려는 URL을 여기에 입력
}
function removebtn() {
    // 페이지 이동을 원하는 URL로 변경
    window.location.href = '/counselor/pay/payMate'; // 이동하려는 URL을 여기에 입력
}
/*모달창 시작합니다.*/
// 모달 열기
  function openModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "block";
  }
  
  // 모달 닫기
  function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
  }
  
  // 모달 닫기 버튼에 이벤트 리스너 추가
  var closeBtn = document.querySelector(".close");
  closeBtn.addEventListener("click", closeModal);
  
  // 모달 열기 함수 호출 (예를 들어, 버튼을 클릭할 때 호출)
  // openModal();

/**session 모달창 입니다. */
// 모달 열기
function openSessionModal() {
    var sModal = document.getElementById("sessionModal");
    sModal.style.display = "block";
  }
  
  // 모달 닫기
  function closeSessionModal() {
    var sModal = document.getElementById("sessionModal");
    sModal.style.display = "none";
  }
  
  // 모달 닫기 버튼에 이벤트 리스너 추가
  var closeSBtn = document.querySelector(".sModal-close");
  closeSBtn.addEventListener("click", closeSessionModal);
  
  // 모달 열기 함수 호출 (예를 들어, 버튼을 클릭할 때 호출)
  // openModal();



let $input = $('#post-image');
let $imgList = $('.img-list');
// console.log($input);

// file change이벤트로 미리보기 갱신하기
$input.on('change', function () {
    let files = this.files;
    //   console.log(files);

    // 길이 체크함수 (files, 원하는 길이)
    let newFiles = checkLength(files, 4);

    appendImg(newFiles);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
$imgList.on('click', function (e) {
    let name = $(e.target).data('name');
    removeImg(name);
    appendImg($input[0].files);
});

//미리보기 삭제 함수
function removeImg(name) {
    let dt = new DataTransfer();

    let files = $input[0].files;

    for (let i = 0; i < files.length; i++) {
        if (files[i].name !== name) {
            dt.items.add(files[i]);
        }
    }
    $input[0].files = dt.files;
}

//파일 길이 체크 함수(체크할 files객체, 제한할 길이)
function checkLength(files, num) {
    if (files.length > num) {
        alert(`파일은 최대 ${num}개까지만 첨부 가능합니다.`);
        // 최대 수를 넘으면 비어있는 files객체 반환
        return new DataTransfer().files;
    }
    return files;
}

// 이미지 미리보기 처리 함수
// 이미지 수가 4개보다 적으면 기본이미지로 대체함
function appendImg(files) {
    for (let i = 0; i < 4; i++) {
        if (i < files.length) {
            let src = URL.createObjectURL(files[i]);

            $imgList.eq(i).css('background-image', `url(${src})`).css('background-size', 'cover').data('name', `${files[i].name}`);

            $imgList.eq(i).addClass('x-box');
        } else {
            $imgList
                .eq(i)
                .css(
                    'background',
                    'url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzNiIgaGVpZ2h0PSIzNiI+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48ZyBzdHJva2U9IiNCNUI1QjUiIHN0cm9rZS13aWR0aD0iMS41IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0IDQpIj48cmVjdCB3aWR0aD0iMjgiIGhlaWdodD0iMjgiIHJ4PSIzLjUiLz48Y2lyY2xlIGN4PSI4LjU1NiIgY3k9IjguNTU2IiByPSIyLjMzMyIvPjxwYXRoIGQ9Ik0yOCAxOC42NjdsLTcuNzc3LTcuNzc4TDMuMTExIDI4Ii8+PC9nPjxwYXRoIGQ9Ik0wIDBoMzZ2MzZIMHoiLz48L2c+PC9zdmc+) no-repeat 50% #f2f2f2'
                )
                .data('name', null);
            $imgList.eq(i).removeClass('x-box');
        }
    }
}

























