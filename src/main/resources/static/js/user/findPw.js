  //타이머 js
  var time = 300; //기준시간 작성
    var min = ""; //분
    var sec = ""; //초
  
    //setInterval(함수, 시간) : 주기적인 실행
    var x = setInterval(function() {
      //parseInt() : 정수를 반환
      min = parseInt(time/60); //몫을 계산
      sec = time%60; //나머지를 계산
  
      document.getElementById("time").innerHTML = min + "분" + sec + "초";
      time--;
  
      //타임아웃 시
      if (time < 0) {
        clearInterval(x); //setInterval() 실행을 끝냄
        document.getElementById("time").innerHTML = "시간초과";
      }
    }, 1000);
  //타이머 js 끝


  //유효성 검사 js
  
    // JavaScript 함수를 정의합니다.
    function checkInput() {
      // HTML에서 인증번호 입력란의 값을 가져옵니다.
      var inputNumber = document.querySelector('.main-label1-input2').value;
  
      // 만약 인증번호가 비어있거나 '123456'이 아니면
      if (inputNumber === '' || inputNumber !== '123456') { // 여기서 '123456'은 예시입니다.
        // inputresult 요소를 가져와서 스타일을 변경하여 화면에 표시합니다.
        var inputResultElement = document.querySelector('.inputresult');
        inputResultElement.style.display = 'flex';
      } else {
        // 인증번호가 일치하면 inputresult 요소를 숨깁니다.
        var inputResultElement = document.querySelector('.inputresult');
        inputResultElement.style.display = 'none';
      }
    }