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


/*결국 해냈다 회원가입 시 날짜 입력될 수 있도록 유도!*/
//Join에서 사용했던 회원 생년월일 그대로 받아와서 사용해볼것!
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

/*취소 버튼 클릭 시 메인 페이지로 이동할 수 있도록*/
$('.btn-join').on('click',function(){
  window.location.href = '/main/index';
})


/*-----유효성 검사의 시작-----*/
// 유효성 검사 메서드
function Validation() {
  //변수에 저장
  let pw = document.getElementById("userPassword")
  let cpw = document.getElementById("confirm-password")
  let mail = document.getElementById("userEmail")
  let updateForm = document.updateForm;

  // 정규식
  // id, pw
  let regIdPw = /^(?=.*[a-z])[a-zA-Z0-9]{8,12}$/;
  // 이메일
  let regMail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;


  //비밀번호 확인
  if(pw.value == ""){
    alert("새로운 비밀번호를 입력하세요.")
    pw.focus();
    return false;
  }
  //비밀번호 영어 소문자 확인
  else if(!regIdPw.test(pw.value)){
    alert("비밀번호를 8~12자,영문 소문자를 최소 1글자 이상 포함해 주세요.")
    pw.focus();
    return false;
  }
  //비밀번호 확인
  if(cpw.value !== pw.value){
    alert("비밀번호가 일치하지 않습니다.")
    cpw.focus();
    return false;
  }

  //메일주소 확인
  if(mail.value.length == 0){
    alert("변경 할 메일주소를 입력하세요.")
    mail.focus();
    return false;
  }else if(!regMail.test(mail.value)){
    alert("잘못된 이메일 형식입니다.")
    mail.focus();
    return false;
  }

  // 유효성 문제 없을 시 폼에 submit
  document.updateForm.submit();
}
/*-----유효성 검사의 종료-----*/