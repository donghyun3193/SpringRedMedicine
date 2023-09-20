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