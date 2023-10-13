## GDSC 백엔드 스터디 5주차 
### 1. MVC란?
- MVC(Model-View-Controller)는 주로 웹 어플리케이션을 설계할 때 사용하는 디자인 패턴
  - Model: 데이터와 비즈니스 로직을 처리
  - View: 화면에 표시되는 User Interface 부분
  - Controller: Model과 View 사이의 중개자. 업무를 수행하는 Model 컴포넌트 호출 후, 그 결과를 View에 전달.
  
### 2. Spring MVC
- Spring은 기본적으로 이 MVC 패턴을 지원
- Spring의 MVC 내부 처리 방식은 아래 그림과 같음
  <img width="503" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/feb86853-2590-45f4-acf7-bcc0efa3556c">

### 3. 계층 구조(Controller-Service-Repository)
- 서비스의 유지보수성과 확장성을 위해 어플리케이션은 계층구조를 따른다
- API 통신에서 계층 구조를 사용하여 데이터를 주고 받는 과정은 다음과 같다.
  1) Controller가 클라이언트로부터 요청을 받음
  2) Controller는 비즈니스 로직을 처리할 Service 계층을 호출
  3) Service 계층에서는 DB와 상호작용할 Respotiroy 계층을 호출한다
  4) Respotiroy 계층에서는 엔티티를 사용해 DB에 접근한다.
  5) 이 과정에서 Repository와 DB 사이에서는 엔티티로 통신하고(DTO도 가능하긴함), 나머지는 모두 DTO를 사용해서 통신한다.
 