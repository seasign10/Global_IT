# 팀프로젝트

**프로젝트란?**

프로젝트 관리 입장에서 프로젝트란

- <u>기간과 목표</u>가 정해진 일을 수행하는 것
- 기간과 목표가 정해져야 프로젝트를 관리할 수 있음


\* 기간과 목표를 잘 산정해야 프로젝트 성공률이 높아짐

*예) 프로젝트를 완성하기 위해 충분히 멤버들이 관련 지식을 갖고 있는가?*
​	*부족 하다면 교육/스터디 먼저 > 교육/스터디 일정은 따로 준비*




> **팀프로젝트 관리**
>
> 1. 일정관리
> 2. 우선순위관리
>    - 우선순위 높은 것을 먼저, 반드시 완성
>
>    - <u>기능별로 우선순위</u>를 설정
>
>      *예) 쇼핑몰 구현시 우선순위에 대한 고찰*
>
>      1. 상품목록
>      2. 주문
>      3. 회원가입/로그인
>      4. 게시판
>
>      :arrow_right: 99% ≠ 100%
>
>      :arrow_right: 모든 기능이 완성된 것 없이 흐지부지 되면 다음 개발계획 세우기가 어렵다.
>
>      :arrow_right: 인수인계시에도 문제될 수 있음
>
>    - 특정기능을 구현할 때도 목적과 수단이 있을 때 목적이 우선
>      *예) 목적: 로그인구현*
>      수단: 1. 직접구현 / 2. 소셜로그인
>      ​
> 3. 이슈(issue)/위험(risk) 관리
>    \* <u>이슈?</u> 프로젝트 진행 중 처리해야 할 일.
>
>    - `issue level 0` 구현하면 되는 일 (생략하기도 함)
>    - `issue level 1` 신경쓰이는 일
>    - `issue level 2` 많이 신경쓰이는 일
>    - 위험 - 우선적으로 해결하지 않으면 프로젝트 성패에 중요한 영향을 미치는 일
> 4. 소스코드 형상관리
>



#### 소스코드 형상관리

1. 체크포인트 저장
   - 특정 기능이 완성되면 백업
     *예) board_list)01.zip*
2. 현재 작업중인 파일들 따로 저장
   - *예)board.zip*

\** 통합을 할때는 기능이 활성된 백업본 사용 **

### Git

- 리누스 토발즈가 만든 <u>소스코드 형상관리 도구</u>
  - 리눅스 개발자인 리누스 토발즈가 기존 형상관리 도구의 단점을 개선해서 만듦
  - 인터넷 속도가 느린 환경에서 매번 원격서버에 저장하는 것을 불편하게 생각해서 만들게 되었다고 함

> **:seedling: branch?**
>
> - 브랜치를 몇 개 만들지 어떻게 운영을 할지 전략이 필요
> - 회사마다 다를 수 있음
>
> 1. `git flow` 가장 복잡
> 2. `github flow` 가장 단수
> 3. `gitlab flow` 중간
>
> \* 1~3을 참고해서 회사마다 고유한 branch 전략을 수립
>
> - 현재 github에서는 github flow를 사용 권장
>
> 
>
> :warning: github에 push할 때 여러 사람이 같은 파일을 push 하몀 충돌 위험성이 :arrow_double_up:
>
> - 어느 특정 파일 push는 한 사람만
> - A가 list.jsp를 작업하다가 B가 다시 맡아서 작업을 했다면, B가 작업한 파일을 A에게 반영해서 A가 push
> - ​





### 프로토타입(prototype)

#### 01.wireframe

화면의 대략적 ui를 그린 것. 다른 화면과 연결

#### 02.prototype

wireframe 보다는 상대적으로 더 자세히 최종산출물에 가깝게 만든 것

#### 03.mock(=sample) up

prototype과 wireframe 중간, 정확한 기준이 X



### UI 설계서가 중요한 이유

1. 전체화면별 기능을 정리할 수 있다
2. 협업할 때도 다른 개발자의 진행사항을 파악할 때 유용
3. wireframe, prototype, mock 을 먼저 작성해서 회의해야 의사결정에 유리

\** prototype을 만들어서 clident와 회의의 장점

1. cliden의 적극적인 참여를 유도
2. 의사결정을 초기에 함 :arrow_right: <u>차후 수정요구사항을 최소화</u>하는데 도움이 됨

