# 팀명 : 빨간약

# 프로젝트 이름 : 몽글몽글 - Spring Boot Project

## 📚프로젝트 주제 

마음의 안정이 필요로 하는 사람들이 이용하고 쉴 수 있는 공간이 될 수 있는 사이트
1. 무료 **상담사 등록** 기능 및 유료 상담사로의 변경
2. 일반회원의 **상담사 매칭** 기능
3. 본인만의 **일기장**이 되어줄 일기쓰기 게시판
4. 우리나라에 있는 상담소에 대한 정보
5. 마음에 안정을 줄 수 있는 음악감상

## 목차
- [팀명 : 빨간약](#팀명--빨간약)
- [프로젝트 이름 : 몽글몽글 - Spring Boot Project](#프로젝트-이름--몽글몽글---spring-boot-project)
  - [📚프로젝트 주제](#프로젝트-주제)
  - [목차](#목차)
  - [팀 구성](#팀-구성)
  - [ERD구성](#erd구성)
  - [Tools](#tools)
  - [나의 작업](#나의-작업)
    - [회원가입  기능소개 WIKI로 이동](#회원가입--기능소개-wiki로-이동)
    - [산책 게시판 리스트 기능소개 WIKI로 이동](#산책-게시판-리스트-기능소개-wiki로-이동)
    - [산책 게시판 글 보기 기능소개 WIKI로 이동](#산책-게시판-글-보기-기능소개-wiki로-이동)
    - [산책 게시판 댓글 기능소개 WIKI로 이동](#산책-게시판-댓글-기능소개-wiki로-이동)
    - [메인화면 조건에 따른 게시글 노출 기능소개 WIKI로 이동](#메인화면-조건에-따른-게시글-노출-기능소개-wiki로-이동)
    - [챗봇 기능소개 WIKI로 이동](#챗봇-기능소개-wiki로-이동)
    - [AOP 활용 실행속도 측정 어노테이션 기능소개 WIKI로 이동](#aop-활용-실행속도-측정-어노테이션-기능소개-wiki로-이동)
    - [커스텀 에러페이지 기능소개 WIKI로 이동](#커스텀-에러페이지-기능소개-wiki로-이동)
    - [Interceptor활용 회원 세션검사 기능소개 WIKI로 이동](#interceptor활용-회원-세션검사-기능소개-wiki로-이동)

## 팀 구성

|팀장|노의진|           
|:--:|:--:|
|부팀장|이지윤| 
|**팀원**|**이동현**| 
|팀원|유대훈| 

## ERD구성

<details open>
<summary>ERD이미지</summary>

<a href='https://ifh.cc/v-H9Fj40' target='_blank'><img src='https://ifh.cc/g/H9Fj40.jpg' border='0'></a>

</details>

 ## Tools
- **Java**
- **Spring Boot**
- **Intellij**
- **Mybatis**
- **Oracle**

## 나의 작업

### 회원 가입 기능 <a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EC%88%98%EC%A0%95"> 기능소개 WIKI로 이동</a>
- 회원 가입 시 필요한 정보 입력할 수 있도록
- 아이디 유효성 검사(비동기)
- 휴대전화 문자 인증

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EC%9E%91%EC%84%B1-%EB%B0%8F-%EC%88%98%EC%A0%95"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTYx/MDAxNjkwOTQ5MTY5NzE4.frpd021Y49mnOixxx1MYTmdrq6DxUBwiX5Vt2ZqjMEIg.73elE9Iu_Hudk0qQ5yOwTLVgpq5aVMdRs_cbKnV9jvwg.GIF.rlaeodus1306/%EC%9E%91%EC%84%B1.gif?type=w580" width="500">
</a>

### 로그인 기능<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A6%AC%EC%8A%A4%ED%8A%B8"> 기능소개 WIKI로 이동</a>
- 아이디와 비밀번호를 입력받아서 회원 번호를 비교 후 로그인

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A6%AC%EC%8A%A4%ED%8A%B8"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMjAy/MDAxNjkwOTU2ODI5MjQx.LHCyCmG-zfXfw_p4XKIAjgsc0O5-sGet3jbEclPO0Esg.7tMPJ68E5kIyQutSYMGIP5-N8E-ekY--S7Mf6XDqhmMg.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%A6%AC%EC%8A%A4%ED%8A%B81.gif?type=w580" width="500">
</a>

### 회원 정보 수정<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EB%B3%B4%EA%B8%B0"> 기능소개 WIKI로 이동</a>
- 회원 정보 수정 전 비밀번호 재입력 후 검증
- 회원 정보 수정 페이지에서는 기존 회원의 정보를 가져올 수 있도록

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B8%80-%EB%B3%B4%EA%B8%B0"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTY2/MDAxNjkwOTU1NTczMzQ1.hsV1p_eLlEXjpquZmI8klCv46YDsh4Z4wjAWWV0cF2og.KkOmv5kMnsXfIktidSF8uV0YKmiVMbZWBfGVN-OECyMg.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%B3%B4%EA%B8%B03.gif?type=w580" width="500">
</a>

### 상담 게시판<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%8C%93%EA%B8%80"> 기능소개 WIKI로 이동</a>
- 리스트에 보여줄 내용 가져오기
- 페이징 처리 (비동기)
- 게시글 쓰기, 수정, 삭제
- 이미지 파일 첨부하기

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%82%B0%EC%B1%85-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%8C%93%EA%B8%80"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MDJfMTEy/MDAxNjkwOTU3NjMwNDY5.CLFAAMZtE1MwFJKlz85AifEaqPsRQsGuH5OlWN_zGqkg.z-NGtCeoLXaexDAgOBknqy2TcWn22W9Dr1HJDJ53Y7Ug.GIF.rlaeodus1306/%EA%B2%8C%EC%8B%9C%EA%B8%80%EB%8C%93%EA%B8%80.gif?type=w580" width="500">
</a>

### 상담 게시판 댓글<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4%EC%97%90%EC%84%9C-%EC%A1%B0%EA%B1%B4%EC%97%90-%EB%94%B0%EB%A5%B8-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%85%B8%EC%B6%9C"> 기능소개 WIKI로 이동</a>
- 댓글 리스트 띄우기 및 페이징 처리 (비동기)
- 댓글 날짜(1분 전, 1시간 전, 1일 전 형식으로 띄우기)
- 댓글 수정, 삭제

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4%EC%97%90%EC%84%9C-%EC%A1%B0%EA%B1%B4%EC%97%90-%EB%94%B0%EB%A5%B8-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%85%B8%EC%B6%9C"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MTJfMjY2/MDAxNjkxODUyMzI5ODg1.I1y2iQ4CqNQOuRbhhEix4OmOOTvf5ZZ2SFyFE30QQIEg.T6cu57x-OgBHSpCa3Tg5CnVjqKzJAaoVNa6zsHt9mnMg.PNG.rlaeodus1306/%EB%A9%94%EC%9D%B8_%EC%82%B0%EC%B1%85%EB%AA%A8%EC%9E%84%EA%B2%8C%EC%8B%9C%ED%8C%90.png?type=w580" width="500">
</a>

### 커스텀 에러페이지<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%BB%A4%EC%8A%A4%ED%85%80-%EC%97%90%EB%9F%AC%ED%8E%98%EC%9D%B4%EC%A7%80"> 기능소개 WIKI로 이동</a>

<a href="https://github.com/gimdaeyeon/happy_pets_day/wiki/%EC%BB%A4%EC%8A%A4%ED%85%80-%EC%97%90%EB%9F%AC%ED%8E%98%EC%9D%B4%EC%A7%80"> 
 <img src="https://postfiles.pstatic.net/MjAyMzA4MTJfMjk1/MDAxNjkxODUyMzY2OTUz.or9inuAqE4fZeZaXzz44u4I5ZVo-rgLLmEwB6c3WVrUg.uyU3P3reKXM7WeQKg05sorxFLGuThmsXWgH8U_Bn1hYg.PNG.rlaeodus1306/Untitled_(4).png?type=w580" width="500">
</a>
