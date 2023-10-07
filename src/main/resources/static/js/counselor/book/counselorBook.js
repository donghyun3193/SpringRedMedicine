

//여기서 부터 검색 리스트
  let page = 1;
  let keyword = $('.keyword').val();
  let cate = $('.cate').val();

  myModule(cate, keyword, showResult);

  //상담 취소 버튼
  $('.content').on('click', '.td-nobutton', function () {
    if (confirm("예약을 정말 취소 하시겠습니까?")) {
      alert("취소 처리 되었습니다!");
      let bookNumber = $(this).data('number');
      window.location.href = '/counselor/remove?bookNumber=' + bookNumber;
    } else {
    }
  });
  //상담 완료 버튼
  // $('.content').on('click', '.td-okbutton', function () {
  //   if(confirm("상담을 완료 하시겠습니까?")){
  //     alert("완료 되었습니다!");
  //     let userNumber = $(this).data('number');
  //     window.location.href = '/counselor/remove?bookNumber=' + bookNumber;
  //   } else {
  //   }
  // });

  //검색 기능
  $('.btn-search').on('click', function () {
    page = 1;
    keyword = $('.keyword').val();
    cate = $('.cate').val();

    myModule(cate, keyword, showResult);
  });

  function showResult(result) {
    console.log(result)

    let text = '';
    result.list.forEach(r => {
      text += `
<tr>
    <td>${r.userNumber}</td>
    <!-- 모달 창 들어 가는 부분  -->
    <div class="modal">
        <div class="modal_body">
            <strong style="font-size: 30px; ">
                ${r.userName}
            </strong>
            <br><br><br>
            <hr>
            <br><br>

            <span class="modal_span">
            <span style="font-size: 20px;">휴대폰 번호 : ${r.userPhone}</span>
            <br>
            <br>
            
            <span style="font-size: 20px;">이메일 : ${r.userEmail}</span>
            <br>
            <br>
            <br><hr><br><br>
            <strong style="font-size: 20px;">
              상담내용
              </strong>
            <br><br><br>
            <span style="font-size: 20px;">${r.bookContent}</span>
            
            <br><br><br><br><br><br><br><br><br>
            <hr>
            </span>
            </div>
        </div>
        <!-- 모달 창 들어 가는 부분 끝 -->
        <td> <button class="btn-open-popup">${r.userName}</button></td>
        <td>${r.bookDate}</td>
        <td>${r.bookTime}</td>
        <td>
          <input class="td-nobutton" type="submit" data-number="${r.bookNumber}" value="상담취소">
       </td>
        <td>
            <input class="td-okbutton" type="submit"  value="상담완료">
        </td>
    </tr>
			`;
    });

    $('.content').html(text);
    let pageVo = result.pageVo;
    let block = '';

    if (pageVo.prev) {
      block += `<li class="page-num prev" data-page="${pageVo.startPage - 1}">&lt</li>`;
    }

    for (let i = pageVo.startPage; i <= pageVo.endPage; i++) {
      if (pageVo.criteria.page == i) {
        block += `<li class="page-num active" data-page="${i}">${i}</li>`;
      } else {
        block += `<li class="page-num" data-page="${i}">${i}</li>`;
      }
    }

    if (pageVo.next) {
      block += `<li class="page-num next" data-page="${pageVo.endPage + 1}">&gt</li>`;
    }

    $('.page-box').html(block);

  }

  function myModule(cate, keyword, callback) {
    $.ajax({
      url: `/counselor/counselorBook/${page}`,
      type: 'get',
      dataType: 'json',
      data: {cate: cate, keyword: keyword},
      success: function (result) {
        console.log(result);
        if (callback) {
          callback(result);
        }
      },
      error: function (a, b, c) {
        console.log(c);
      }
    });
  }

  $('.page-box').on('click', '.page-num', function () {
    console.log("click")

    page = $(this).data('page');
    myModule(cate, keyword, showResult);
  });