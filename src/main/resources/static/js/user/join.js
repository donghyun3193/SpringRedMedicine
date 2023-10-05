
/*===문자 인증 관련 js 시작===*/

$('#startTimer').on('click', function (){
  let userPhone = $('.inputphone').val();//폰 번호를 입력받은 input의 정보를 userPhone에 저장하겠다

  let para = {
    userPhone : userPhone
  }
  $.ajax({

    url : '/sms/v1/msgSend',
    type : 'post',// type : method(요청 방식)
    data : JSON.stringify(para),// data : 요청 보낼 때 전송할 데이터 -> 내가 컨트롤러에서 작성한 메서드의 매개변수를 보내게된다
    //요청 보낼 때 전송할 데이터 JSON형태로 보내야 하는데 관련 메서드가 필요하다
    contentType : 'application/json; charset=utf-8',// dataType : 받는 데이터의 타입 -> 'json'
    success : function () {
      $('.inputresult').css('display','block');
      $('.inputresult').text("입력하신 번호로 인증번호가 발송되었습니다.");
    }

  })

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
})


/*인증번호 발송 후 이용자가 인증번호를 입력하는 순간*/
$('#startTimer').on('click', function () {
  let checkNumber = $('#confirm-num').val();//가입자가 입력한 값을 value로 받아와 저장하겠다

  let param = {
    checkNumber : checkNumber,
  }

  $.ajax({
    url : '/sms/v1/msgCheck',
    type : 'post',
    data : JSON.stringify(param),
    contentType : 'application/json; charset=utf-8',
    success : function (result) {
      console.log(result);

      $('.inputresult').text(result);

      if(result == "인증이 완료되었습니다."){
        // $('#confirm-num').css('display','block');
        $('.main-time').css('display','none');
      }
    }
  })
})
/*===문자 인증 관련 js 종료===*/

// '출생 연도' 셀렉트 박스 option 목록 동적 생성
const birthYearEl = document.querySelector('#birth-year')
// option 목록 생성 여부 확인
isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isYearOptionExisted) {
    isYearOptionExisted = true
    for(var i = 1940; i <= 2023; i++) {
      // option element 생성
      const YearOption = document.createElement('option')
      YearOption.setAttribute('value', i)
      YearOption.innerText = i
      // birthYearEl의 자식 요소로 추가
      this.appendChild(YearOption);
    }
  }
});

const birthMonthEl = document.querySelector('#birth-month')
// option 목록 생성 여부 확인
isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isMonthOptionExisted) {
    isMonthOptionExisted = true
    for(var i = 1; i <= 12; i++) {
      // option element 생성
      const MonthOption = document.createElement('option')
      MonthOption.setAttribute('value', i)
      MonthOption.innerText = i
      // birthMonthEl의 자식 요소로 추가
      this.appendChild(MonthOption);
    }
  }
});

const birthDayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인
isDayOptionExisted = false;
birthDayEl.addEventListener('focus', function () {
  // day 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isDayOptionExisted) {
    isDayOptionExisted = true
    for(var i = 1; i <= 31; i++) {
      // option element 생성
      const DayOption = document.createElement('option')
      DayOption.setAttribute('value', i)
      DayOption.innerText = i
      // birthDayEl의 자식 요소로 추가
      this.appendChild(DayOption);
    }
  }
});

    var $all = $(".section2-checkbox");
    var $inputs = $(".main-checkbox");
    
    $all.on('click',function(){
        //"all" 클래스를 가진 요소들에 대해 클릭 이벤트 리스너를 등록
        if($(this).is(":checked")){
            $inputs.prop('checked',true);
        }else{
            $inputs.prop('checked',false);
        }
    });




// '이용약관' 모달 열기
$('.btn-open-popup').on('click', function(){
  $('section.terms-modal').removeClass('none');
});

// '개인정보수집 및 이용동의' 모달 열기
$('.btn-open-popup2').on('click', function(){
  $('section.privacy-modal').removeClass('none');
});

// 모달 외부를 클릭하면 모달 닫기
$('section').on('click', function(){
  $(this).addClass('none');
});

// 모달 내부를 클릭해도 모달이 닫히지 않도록 처리
$('.modal').on('click', function(event){
  event.stopPropagation();
});

//타이머 js
// 전송 버튼을 클릭할 때 타이머 시작
// document.getElementById("startTimer").addEventListener("click", function() {
//   var time = 300; // 기준시간 작성
//   var min = ""; // 분
//   var sec = ""; // 초
//
//   var x = setInterval(function() {
//     min = parseInt(time / 60); // 몫을 계산
//     sec = time % 60; // 나머지를 계산
//
//     document.getElementById("time").innerHTML = min + "분" + sec + "초";
//     time--;
//
//     // 타임아웃 시
//     if (time < 0) {
//       clearInterval(x); // setInterval() 실행을 끝냄
//       document.getElementById("time").innerHTML = "시간초과";
//     }
//   }, 1000);
// });


// var timerInterval; // 타이머의 setInterval 반환값을 저장하는 전역 변수
//
// document.getElementById("startTimer").addEventListener("click", function() {
//   if (timerInterval) {
//     clearInterval(timerInterval); // 이전 타이머를 정지시킴
//   }
//
//   var time = 300; // 기준시간 작성
//   var min = ""; // 분
//   var sec = ""; // 초
//
//   timerInterval = setInterval(function() {
//     min = parseInt(time / 60); // 몫을 계산
//     sec = time % 60; // 나머지를 계산
//
//     document.getElementById("time").innerHTML = min + "분" + sec + "초";
//     time--;
//
//     // 타임아웃 시
//     if (time < 0) {
//       clearInterval(timerInterval); // setInterval() 실행을 끝냄
//       document.getElementById("time").innerHTML = "시간초과";
//     }
//   }, 1000);
// });
  //타이머 js 끝

//성별 선택!
let $radioGender = $('.radio-gender');

$radioGender.on('click', function(e){
  let idx = $radioGender.index(this);
  console.log(idx);
  for(let i=0;i<$radioGender.length; i++){
    if (i == idx) {
      $radioGender.eq(i).addClass('checked');
    } else {
      $radioGender.eq(i).removeClass('checked');
    }
  }
});

/*결국 해냈다 회원가입 시 날짜 입력될 수 있도록 유도!*/
const birthYearSelect = document.getElementById('birth-year');
const birthMonthSelect = document.getElementById('birth-month');
const birthDaySelect = document.getElementById('birth-day');
const userBirthInput = document.getElementById('userBirth');

// 선택한 년, 월, 일 값을 가져와서 userBirth input 필드에 설정
function updateUserBirth() {
  const selectedYear = birthYearSelect.value;
  let selectedMonth = birthMonthSelect.value;
  let selectedDay = birthDaySelect.value;

  // 월과 일이 한 자릿수일 경우 앞에 0을 추가해줍니다.
  if (selectedMonth.length === 1) {
    selectedMonth = '0' + selectedMonth;
  }
  if (selectedDay.length === 1) {
    selectedDay = '0' + selectedDay;
  }

  // 연도, 월, 일을 하이픈(-)으로 구분된 문자열로 설정합니다.
  userBirthInput.value = selectedYear + '-' + selectedMonth + '-' + selectedDay;
}

// 선택한 값이 변경될 때마다 updateUserBirth 함수 호출
birthYearSelect.addEventListener('change', updateUserBirth);
birthMonthSelect.addEventListener('change', updateUserBirth);
birthDaySelect.addEventListener('change', updateUserBirth);

// 초기화시에도 실행
updateUserBirth();

/*-----유효성 검사의 시작-----*/
// 유효성 검사 메서드
function Validation() {
  //변수에 저장
  let id = document.getElementById("userId")
  let pw = document.getElementById("userPassword")
  let cpw = document.getElementById("confirm-password")
  let name = document.getElementById("userName")
  let mail = document.getElementById("userEmail")
  let privacy = document.getElementsByName("check-privacy")
  let terms = document.getElementsByName("check-terms")
  let joinForm = document.joinForm;

  // 정규식
  // id, pw
  let regIdPw = /^[a-zA-Z0-9]{8,12}$/;
  // 이름
  let regName = /^[가-힣a-zA-Z]{2,15}$/;
  // 이메일
  let regMail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;


  //아이디 확인
  if(id.value.length == 0){
    alert("아이디를 입력하세요.")
    id.focus();
    return false;
  }
  //아이디 영어 대소문자 확인
  else if(!regIdPw.test(id.value)){
    alert("아이디를 8~12자 영문 대소문자, 숫자만 입력하세요.")
    id.focus();
    return false;
  }


  //비밀번호 확인
  if(pw.value == ""){
    alert("비밀번호를 입력하세요.")
    pw.focus();
    return false;
  }
  //비밀번호 영어 대소문자 확인
  else if(!regIdPw.test(pw.value)){
    alert("비밀번호를 8~12자 영문 대소문자, 숫자만 입력하세요.")
    pw.focus();
    return false;
  }
  //비밀번호 확인
  if(cpw.value !== pw.value){
    alert("비밀번호가 동일하지 않습니다.")
    cpw.focus();
    return false;
  }

  //이름 확인 = 한글과 영어만 가능하도록
  if(name.value == ""){
    alert("이름을 입력해주세요")
    name.focus();
    return false;
  } else if(!regName.test(name.value)){
    alert("이름을 최소 2글자 이상, 한글과 영어만 입력하세요.")
    name.focus();
    return false;
  }

  //메일주소 확인
  if(mail.value.length == 0){
    alert("메일주소를 입력하세요.")
    mail.focus();
    return false;
  }else if(!regMail.test(mail.value)){
    alert("잘못된 이메일 형식입니다.")
    mail.focus();
    return false;
  }

  //이용약관 확인
  if(!checkedTerms(terms)){
    alert("이용약관을 체크하세요.")
    terms.focus();
    return false;
  }
  //이용약관 체크 확인
  function checkedTerms(arr){
    for(let i=0; i<arr.length; i++){
      if(arr[i].checked == true){
        return true;
      }
    }
    return false;
  }

  //개인정보처리방침 확인
  if(!checkedPrivacy(privacy)){
    alert("개인정보처리방침을 체크하세요.")
    privacy.focus();
    return false;
  }
  //개인정보처리방침 체크 확인
  function checkedPrivacy(arr){
    for(let i=0; i<arr.length; i++){
      if(arr[i].checked == true){
        return true;
      }
    }
    return false;
  }

  // 유효성 문제 없을 시 폼에 submit
  document.joinForm.submit();
}

  /*아이디 중복 유효성 검사*/
  // $('#userId').on('change', function () {
  //   console.log("change!!")
  //
  //   let userId = $(this).val();
  //   $.ajax({
  //     url: `/users/check`,
  //     type: 'get',
  //     data: { userId: userId },
  //     success: function (result) {
  //       console.log(result);
  //
  //       let checkIdElement = $('.check-id');
  //       if (result == 1) {
  //         checkIdElement.text("중복된 아이디입니다.");
  //         checkIdElement.css('color', 'red');
  //       } else {
  //         checkIdElement.text("사용 가능한 아이디입니다.");
  //         checkIdElement.css('color', 'blue');
  //       }
  //     }
  //   })
  // })

/*아이디 중복 유효성 검사*/
$('#userId').on('change', function () {
  console.log("change!!")

  let userId = $(this).val();
  $.ajax({
    url: `/users/check`,
    type: 'get',
    data: { userId: userId },
    success: function (result) {
      console.log(result);

      let regIdPw = /^[a-zA-Z0-9]{8,12}$/;
      let checkIdElement = $('.check-id');
      if (result == 1) {
        checkIdElement.text("중복된 아이디입니다.");
        checkIdElement.css('color', 'red');

        // 회원가입 버튼을 비활성화
        document.getElementById('join-btn').disabled = true;
      }
      else {
        checkIdElement.text("중복된 아이디가 아닙니다.");
        checkIdElement.css('color', 'blue');

        // 중복된 아이디가 없을 때 입력 필드와 회원가입 버튼을 다시 활성화
        document.getElementById('userId').disabled = false;
        document.getElementById('join-btn').disabled = false;
      }
    }
  })
})



/*-----유효성 검사의 종료-----*/


