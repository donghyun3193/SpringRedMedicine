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