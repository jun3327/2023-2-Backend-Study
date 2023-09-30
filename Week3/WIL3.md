## 백엔드 3주차 과제
### 1.Spring Bean이란 무엇인가?
- Spring Bean: 스프링 IoC 컨테이너에 의해 관리되는 자바 객체. 이런 Bean들은 메타 데이터(XML, Java 파일 등)을 반영해서 만들어진다. 메타 데이터를 통해 Bean Definition을 생성하고, POJO와 함께 빈 생성


- IoC 컨테이너: 빈을 관리하는 객체 (ApplicationContext). 관리되는 빈들은 기본적으로 싱글톤 패턴을 보장하며, 싱글톤 패턴의 단점을 모두 IoC 컨테이너가 해결해준다. 또한 빈들 사이에 의존성 주입을 해줌(제어역전)

### 3. Spring Bean을 등록하는 방법
- @Bean 사용
  - 빈으로 등록할 클래스 위에 @Bean 어노테이션을 붙여준다
- @Component, @ComponentScan 사용
  - 빈으로 등록할 클래스 위에 @Component 어노테이션을 붙이고, AppConfig 클래스 위에 @ComponentScan 어노테이션을 붙여줌. 
    - @ComponentScan: 스프링이 애플리케이션의 클래스를 검색하고, 자동으로 스프링 빈을 등록하는 방법


### 과제 스샷
<img width="679" alt="image" src="https://github.com/wjdtkdgns/2023-2-BE-Study/assets/121341289/cb189ad1-c1d0-4abd-b8cf-8d35ae8c4dd9">
<img width="636" alt="image" src="https://github.com/wjdtkdgns/2023-2-BE-Study/assets/121341289/e91f15c4-74a9-44d6-987c-ea318d5a7d5b">
