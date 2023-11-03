## GDSC 백엔드 스터디 6주차
#### 1. DB
  - 여러 사용자가 공유하여 사용할 수 있도록 통합해서 저장한 운영 데이터의 집합. DB에 데이터가 저장되는 방식은 SQL과 NoSQL로 나뉜다.


  - SQL: 우리가 흔히 RDB (Relational DataBase)라고 부르는 것
    - 특징
        1. 데이터는 정해진 데이터 스키마(명세)에 따라 테이블에 저장
        2. 데이터는 관계를 통해 여러 테이블에 분산
        3. 중복 데이터는 저장하지 않음(무결성 보장)
        4. 수정이 빈번하고, 구조와 중요도가 높을 경우 사용하면 좋음.
    - MySQL, Oracle, MsSQL 등이 있음. 


  - NoSQL: SQL이 아닌, 즉 스키마도 없고 관계도 없는 자료 형식
    - 특징: 
        1. 스키마도 없고 관계도 없는 자료 형식
        2. 관련 데이터를 동일한 ‘컬렉션’에 넣는다
        3. 유연한 구조, 빠른 속도, 확장 편리
    - MongoDB, Redis 등

#### 2. ORM
  - Entity: DB에 넣을 객체 
  - ORM(Object Relational Mapping)
    - 데이터베이스와 객체 지향 프로그래밍 언어 사이의 관계형 데이터를 객체로 매핑하는 기술이나 프로그래밍 기술
    - 엔티티 객체를 데이터베이스의 데이터 형식으로 바꿔 저장해주는 역할을 함.
    - 장점
        1. 추상화 : 데이터베이스와의 상호 작용을 객체 지향적인 방식으로 처리
        2. 데이터베이스 독립성 : 다양한 데이터베이스 시스템에 대해 동일한 코드를 사용할 수 있게 도와줌
        3. 생산성 : SQL 쿼리를 직접 작성하지 않아도 됨
        4. 유지 보수 : 코드 변경이 필요할 때, 객체 모델만 수정
    - 단점
      1. 성능 : 개발자가 작성한 쿼리보다 비효율적일 수 있음
      2. 복잡성 : 복잡한 쿼리나 특정 데이터베이스 최적화 기술을 사용하려면 ORM을 벗어나야 함

#### 3. JPA(Java Persistence API)
- 자바 애플리케이션에서 관계형 데이터베이스를 사용하는 방법을 정의한 자바 API 


- 자바 ORM 기술에 대한 표준 사양으로, 객체와 데이터베이스 테이블 간의 매핑을 처리. 스프링에서는 JPA 구현체인 Hibernate를 주로 이용. 


- JPA는 영속성 컨텍스트를 통해 아래와 같은 특성을 가짐

  1. 객체-테이블 매핑 : 어노테이션 또는 XML을 사용하여 자바 객체와 데이터베이스 테이블을 매핑함
  2. 쿼리 언어 사용 : JPQL (Java Persistence Query Language)라는 객체지향 쿼리 언어를 제공하여 데이터베이스에 질의할 수 있음
  3. 생명주기 관리 : 엔티티의 생명 주기 (예: 생성, 조회, 수정, 삭제)를 관리함
  4. 캐싱 : 기본적인 캐시 전략을 지원함
  5. 자동 스키마 생성: 데이터베이스 스키마를 자동으로 생성하거나 업데이트 할 수 있음


- 영속성 컨텍스트
  - 
#### 4. Mapping
- 엔티티는 데이터베이스의 테이블과 자바 클래스를 매핑하는 역할을 한다. 


- DB 테이블의 레코드를 객체로 표현


- ERD(Entity Relation Diagram)로 다양한 엔티티 간 관계를 표현할 수 있음. ERD에는 DB 구조에 관한 메타데이터를 적는다.


- 객체(엔티티) 간의 관계를 크게 3가지 경우로 나눌 수 있음
  1. 1:1(일대일)
     - 각 개체가 서로를 하나만 가질 수 있을 때.
     - ex) 남편과 아내의 관계
     - ```@OneToOne```어노테이션을 이용해서 표현. 
  2. 1:N(일대다)
     - ex) 프로야구 팀과 프로야구 선수의 관계
     - 선수가 여러 팀에 소속되어 있을 순 없음.
     - 1에 해당하는 부분에 ```@OneToMany```, N에 해당하는 부분에 ```@ManyToOne```
  3. M:N(다대다)
     - ex) 고객과 서점의 책 사이의 관계
     - 고객 개체와 책 개체 모두 서로 다른 여러 개체와 관계를 맺을 수 있음
     - ```@ManyToMany```사용
     - 실무에서는 다대다를 그대로 사용하지 않고, 두 테이블을 연결하는 또 다른 테이블을 추가해 Book  N - 1  Order 1 - N Client 처럼 풀어 매핑한다.

  - 양방향/단방향 접근
     1. 양방향: 엔티티간 서로가 서로를 알아서 양쪽에서 서로에게 접근할 수 있을 때
    ```java
        @Entity
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public class Husband {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
    
            @OneToOne
            private Wife wife;
    
            private String name;
        }
        
        @Entity
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public class Wife {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
    
            @OneToOne
            private Husband husband;
    
            private String name;
        }
    ```

     2. 단방향: 한 쪽이 한 쪽만을 알고 있을 때
    ```java
    @Entity
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Husband {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
            private String name;
    }
    
    @Entity
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Wife {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @OneToOne
        private Husband husband;
    
            private String name;
    }
    ```
    
#### 4. Spring Data JPA
- Spring Framework의 일부로, 데이터 접근 계층을 쉽게 구현할 수 있도록 지원하는 모듈
- 특징
  1. Repository 인터페이스 : Repository 인터페이스를 사용하여 CRUD (Create, Read, Update, Delete) 연산을 추상화. 개발자는 이 인터페이스를 상속받아 필요한 메서드를 선언하기만 하면 됨
  2. 쿼리 메서드 : 메서드 이름을 분석하여 자동으로 SQL 쿼리를 생성하는 기능을 제공
  3. Custom Query : @Query 애노테이션을 사용하여 사용자 정의 쿼리를 작성할 수 있음
  4. Pagination and Sorting : 페이징과 정렬 기능을 지원
  5. Transaction Management : 트랜잭션을 쉽게 관리할 수 있게 해줌