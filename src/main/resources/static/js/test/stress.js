  // 
  
  // 결과를 계산하고 표시하는 함수
  function calculateResult() {
    // 질문 1부터 20까지의 값을 더합니다.
    let totalScore = 0;
    for (let i = 1; i <= 20; i++) {
      const radioButtons = document.getElementsByName('ques' + i);
      for (let j = 0; j < radioButtons.length; j++) {
        if (radioButtons[j].checked) {
          totalScore += parseInt(radioButtons[j].value);
          break; // 선택된 라디오 버튼을 찾으면 루프를 종료합니다.
        }
      }
    }

    // 결과를 계산하여 결과창에 표시합니다.
    const resultDiv = document.getElementById('result_div');
    const resultTitle = resultDiv.querySelector('.result-title');
    const resultText = resultDiv.querySelector('.result-text');

    resultTitle.textContent = '진단결과: ' + totalScore + ' 점 입니다.';
    
    // 점수 범위에 따라 결과 메시지를 표시합니다.
    if (totalScore >= 0 && totalScore <= 15) {
      resultText.textContent = '편안한 상태입니다. 지속적으로 정신건강에 관심을 갖고 예방을 위해 년 1회 정기검사도 잊지 마세요.';
    } else if (totalScore >= 16 && totalScore <= 24) {
      resultText.textContent = '가벼운 우울감을 겪고 있는 상태입니다. 우울증 예방을 위해 운동, 여가활동, 대인관계 맺기 등 즐거움을 주는 활동에 적극적으로 참여해보세요.';
    } else if (totalScore >= 25) {
      resultText.textContent = '다양한 우울증상으로 일상생활에 영향을 주고 있는 상태입니다. 이러한 상태가 2주 이상 지속된다면 전문가와의 상담을 반드시 받아보세요.';
    }
  }

  // "결과확인하기" 버튼에 이벤트 리스너를 추가합니다.
  const checkResultButton = document.querySelector('.b-button');
  checkResultButton.addEventListener('click', calculateResult);


// 경고창 뜨는 js 코드
  // 결과를 계산하고 표시하는 함수
  function calculateResult() {
    // 모든 라디오 버튼이 체크되었는지 확인하기 위한 변수
    let allQuestionsAnswered = true;

    // 질문 1부터 20까지의 값을 더합니다.
    let totalScore = 0;
    for (let i = 1; i <= 20; i++) {
      const radioButtons = document.getElementsByName('ques' + i);
      let radioButtonChecked = false; // 현재 질문에 대한 라디오 버튼이 체크되었는지 여부

      for (let j = 0; j < radioButtons.length; j++) {
        if (radioButtons[j].checked) {
          totalScore += parseInt(radioButtons[j].value);
          radioButtonChecked = true;
          break; // 선택된 라디오 버튼을 찾으면 루프를 종료합니다.
        }
      }

      if (!radioButtonChecked) {
        allQuestionsAnswered = false;
        // 아직 답변되지 않은 질문이 있다면 allQuestionsAnswered를 false로 설정
      }
    }

    // 만약 모든 문항이 체크되지 않았다면 경고를 표시하고 결과를 표시하지 않음
    if (!allQuestionsAnswered) {
      alert('모든 문항을 체크해 주세요.');
      return;
    }

    // 결과를 계산하여 결과창에 표시합니다.
    const resultDiv = document.getElementById('result_div');
    const resultTitle = resultDiv.querySelector('.result-title');
    const resultText = resultDiv.querySelector('.result-text');

    resultTitle.textContent = '진단결과: ' + totalScore + ' 점 입니다.';
    
    // 점수 범위에 따라 결과 메시지를 표시합니다.
    if (totalScore >= 0 && totalScore <= 15) {
      resultText.textContent = '편안한 상태입니다. 지속적으로 정신건강에 관심을 갖고 예방을 위해 년 1회 정기검사도 잊지 마세요.';
    } else if (totalScore >= 16 && totalScore <= 24) {
      resultText.textContent = '가벼운 우울감을 겪고 있는 상태입니다. 우울증 예방을 위해 운동, 여가활동, 대인관계 맺기 등 즐거움을 주는 활동에 적극적으로 참여해보세요.';
    } else if (totalScore >= 25) {
      resultText.textContent = '다양한 우울증상으로 일상생활에 영향을 주고 있는 상태입니다. 이러한 상태가 2주 이상 지속된다면 전문가와의 상담을 반드시 받아보세요.';
    }
  }

  // "결과확인하기" 버튼에 이벤트 리스너를 추가합니다.
  const checkResultButton1 = document.querySelector('.b-button');
  checkResultButton1.addEventListener('click', calculateResult);



