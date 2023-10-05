$('.submitButton').on('click',function (){
    let title = $('#title').val();
    let content = $('#content').val();
    let open0 = $('#open0').is(':checked');
    let open1 = $('#open1').is(':checked');

    if(title == ""){
        alert("글 제목을 입력해주세요.")
    }else if(content == ""){
        alert("글 내용을 입력해 주세요.")
    }else if(open0 == false && open1 == false){
        alert("공개 여부를 선택해 주세요.")
    }else{
        $('.writingForm').submit();
    }

})