const numberElement = document.getElementById("number");
const priceElement = document.getElementById("price");
const increaseButton = document.getElementById("increase");
const decreaseButton = document.getElementById("decrease");
const paymentButton = document.querySelector(".payment");

let quantity = 1; // 상품 수량 초기값을 1로 설정
let price = 50000; // 상품 가격 초기값을 50000으로 설정

function updatePriceAndQuantity() {
    priceElement.innerText = price.toLocaleString() + ""; // 상품 가격과 수량 업데이트
    numberElement.innerText = quantity;
}

increaseButton.onclick = () => {
    quantity++; // 수량 증가
    price = quantity * 50000; // 가격 재계산
    updatePriceAndQuantity(); // 가격과 수량 업데이트 함수 호출
};

decreaseButton.onclick = () => {
    if (quantity <= 1) { // 수량이 1 이하면 경고 메시지 출력
        alert("최소 결제는 1개월 입니다.");
    } else {
        quantity--; // 수량 감소
        price = quantity * 50000; // 가격 재계산
        updatePriceAndQuantity(); // 가격과 수량 업데이트 함수 호출
    }
};

//카카오 페이
$("#check_module").click(function () {

const payAmount = parseInt($('#price').text().replace(',',''));
// .replace(',','') 를 사용해서 , -> 제거 하여 준다.

var IMP = window.IMP;
// 생략가능
// i'mport 모듈을 사용하기 위해 초기화

IMP.init('imp24106650');
// i'mport 관리자 페이지에서 발급한 가맹점 식별코드를 설정
// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.

IMP.request_pay({
   pg: 'kakaopay.TC0ONETIME',  // 결제 수단을 카카오페이로 설정
   pay_method: 'card', // 결제 방법을 카드로 설정
   merchant_uid: 'merchant_' + new Date().getTime(),
    // 가맹점 주문 번호를 생성하여 설정
   /*
    *  merchant_uid에 경우
    *  https://docs.iamport.kr/implementation/payment
    *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
    */
   name: '주문명 : 몽글몽글 월 결제',
   // 결제창에서 보여질 이름
   amount: payAmount,
    // 결제할 총 금액 설정
   buyer_name: '', //구매자 이름 설정 (필요한 경우 변경 가능)
   buyer_postcode: '123-456', // 구매자 우편번호 설정 (필요한 경우 변경 가능)
   }, function (rsp) {
      console.log(rsp);// 결제 응답 데이터를 콘솔에 출력
   if (rsp.success) {// 결제가 성공한 경우
      var msg = '결제가 완료되었습니다.';
      msg += '결제 금액 : ' + rsp.paid_amount;
       // 성공 메시지 생성 및 결제된 금액 표시

       console.log(payAmount)
       // $.ajax()를 사용하여 서버에 결제 정보를 전송
       $.ajax({
           type: "POST",
           url: "/counselors/payment",
           data: JSON.stringify({
               payAmount: payAmount
           }),
           // JSON.stringify()를 사용하여 데이터를 JSON 형식으로 변환
           contentType : "application/json; charset=utf-8",
           success: function(response) {
               console.log(response); // 서버에서의 응답을 처리할 수 있습니다.
               // 메인 페이지로 리디렉션하거나 다른 동작을 수행할 수 있습니다.
               location.href = '/counselor/pay/registration';
           },
           error: function(a, b, c) {
               console.error(c);
           }
       });
   } else { // 결제가 실패한 경우
      var msg = '결제에 실패하였습니다.';
      msg += '에러내용 : ' + rsp.msg;
   }
   alert(msg); // 결제 결과 메시지 출력
    });
 });
