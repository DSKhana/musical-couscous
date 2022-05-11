# musical-couscous
"설문조사 어플리케이션" 구현
-  GIT 사용(GIT HUB에 소스 올려서 관리. branch, push, pull 사용)
- 할 수 있다면 JUnit5 찾아 테스트케이스 작성(선택사항)

구현을 위한 설계해보기 (모두 문서화. 형식 자유)
- 요구사항 정의 : 어떤 결과가 구현되어야 하는가
- 데이터베이스 모델링: 결과 동작을 위해 필요한 데이터가 무엇인가
- 콘솔 출력 포멧 설계(UI): 결과를 어떤 형태로 보여줄 것인가
- 기능설계 : 결과 동작을 위한 클래스를 어떻게 정의할 것인가

결과제출(강사 메일로)
	- 소스코드 (GITHUB 링크)
	- 각 설계 단계에서 나온 산출물



요구사항 정의:
- 거주지역 설문조사 어플리케이션을 만들거
- '1'을 입력하면 설문 투표 참여, '2' 입력시 설문 현황 열람
- 설문참여시 현황 자동출력


데이터베이스 모델링 :
- 거주지 이름, 투표수

콘솔 출력포멧 설계(UI) :
- 결과를 리스트 형식으로 출력하여 표시

기능 설계 :
- 클래스 정의를 PollDAO, PollVO, JdbcTemplate, Main으로 설정.
