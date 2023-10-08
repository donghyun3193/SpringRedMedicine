let page = 1;
let keyword = $('.keyword').val();
let cate = $('.cate').val();

myModule(cate, keyword, showResult);

//삭제 버튼
$('.content').on('click', '.td-button', function () {
    if (confirm("정말로 탈퇴 시키겠습니까?")) {
        alert("탈퇴 처리 되었습니다!");
        let userNumber = $(this).data('number');
        window.location.href = '/admin/remove?userNumber=' + userNumber;
    } else {
    }
});


//검색 기능
$('.btn-search').on('click', function () {
    page = 1;
    keyword = $('.keyword').val();
    cate = $('.cate').val();

    myModule(cate, keyword, showResult);
});

function showResult(result) {
    let text = '';
    result.list.forEach(r => {
        text += `
			                <tr>
                                <td>${r.userNumber}</td>
                				<td>${r.userEmail}</td>
                				<td>${r.userName}</td>
                				<td>${r.userJoindate}</td>
                         		<td>
									<span>
										${r.userLevel === 1 ? '일반회원' : (r.userLevel === 2 ? '무료상담사' : '유료상담사')}
									</span>
                				</td>
                                <td>
                                    <button class="td-button" type="button" data-number="${r.userNumber}">탈퇴</button>
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
        url: `/admin/memberShipMm/${page}`,
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