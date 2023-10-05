## GDSC 백엔드 스터디 4주차

#### 1. DI란?
- DI(Dependency Injection)란 의존성 주입을 말한다. 객체들 간 의존 관계를 외부에서 주입해주는 것.
```java
public class ClassA {
    private ClassB classB;
    
    public ClassA(ClassB classB) {
        this.classB = classB;
    }
}

public class ClassB {
    public ClassB {
    }
}
```
- 위 코드를 바탕으로 ClassA 생성 시점에 ClassB를 인자로 넘겨줘서 의존 관계를 외부에서 주입할 수 있다. 스프링은 이런 의존성 주입을 편리하게 해주는 기능을 제공한다. 생성자 주입, setter 주입, 필드 주입, 메서드 주입이 있지만 필드 주입과 메서드 주입은 잘 사용하지 않는다.

    1. #### 생성자 주입
        ```java
       @Component
        public class ClassA {
            private ClassB classB;
            
            @Autowired
            public ClassA(ClassB classB) {
                this.classB = classB;
            }
        }
        
       @Component
        public class ClassB {
            public ClassB {
            }
        }
        ```
       - 스프링은 컴포넌트 스캔을 통해 @Component 어노테이션이 붙은 클래스들을 스프링 컨테이너에 빈으로 등록한다. 이 때 @Autowired를 ClassA의 생성자 위에 붙여주면 스프링은 컨테이너에 등록된 빈 중 ClassB 타입에 해당하는 것을 가져와 의존성 주입을 해준다.
       - 이렇게 생성자에서 의존성 주입을 해주는 것을 생성자 주입이라고 한다. 주입받은 객체가 변하지 않거나, 반드시 객체의 주입이 필요한 경우에 강제하기 위해 사용할 수 있다.  
       - 생성자가 하나일 경우에는 @Autowired를 생략해도 된다.
       - 생성자 주입은 (완전한 생성자라는 가정 하에) 객체 생성 시점에 모든 의존성을 주입해주므로 Null을 의도적으로 넣어주지 않는 한 NullPointerException이 발생할 수 없다.

    2. #### setter 주입
       ```java
        @Component
        public class Pizza {
            private Cheese cheese;
            
            public void setCheese(Cheese cheese) {
                this. cheese = cheese;
            }    
       }
       ```
       
       - setter 메서드를 통해 의존성 주입을 해준다. 빈 객체를 생성하고 setter를 통해 의존성 주입을 해주기 때문에 빈 생성자가 필요하다. 
       - 이때 빈 객체를 만들고 setter로 의존성을 주입해주기 때문에 빈 생성자가 필요하다.
         때문에 파이널 필드를 만들 수 없고 의존성의 불변을 보장할 수 없다는 특징이 있다. 
  
#### 1.1 lombok 라이브러리
- lombok은 getter, setter, equals, hashCode 및 toString 메서드 등을 편리하게 제공해주는 Java 라이브러리이다.


- 아래는 lombok이 생성자 관련 제공하는 어노테이션

  1. @NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
  2. @RequiredArgsConstructor : final 또는 @NonNull로 표시된 필드만을 파라미터로 하는 생성자를 생성
  3. @AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성

- 위 어노테이션을 이용하면 생성자 코드를 생략가능.

```java
/** 
 * lombok 사용
 */
@Component
@AllArgsConstructor
public class Pizza {
    private Cheese cheese;
}

//------------------위 아래는 서로 동일한 코드---------------------

/**
 * lombok 사용 x 
 */
@Component
public class Pizza {
    private Cheese cheese;

    public Pizza(Cheese cheese) {
        this.cheese = cheese;
    }
}
```
#### 2. SpringBoot
- 스프링부트는 스프링 어플리케이션을 편리하게 만들기 위해 만들어진 프레임워크. 개발에 필요한 복잡한 설정을 대신 해주고 여러 기능을 제공


- 특징
    - WAS: Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
    - 라이브러리 관리: 손쉬운 빌드 구성을 위한 스타터 종속성 제공 및 라이브러리 버전 관리
    - 자동 구성: 프로젝트 시작에 필요한 스프링과 외부 라이브러리의 빈을 자동 등록,
  스프링 애플리케이션에 공통으로 필요한 애플리케이션 기능을 자동으로 구성
    - 외부 설정: 환경에 따라 달라져야 하는 외부 설정 공통화
    - 프로덕션 준비: 모니터링을 위한 메트릭, 상태 확인 기능 제공

--------------------------------------------------------------------------------
#### *과제 스크린샷*
<img width="896" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/3efad085-825c-4d69-8ff5-9c23c6693da6">