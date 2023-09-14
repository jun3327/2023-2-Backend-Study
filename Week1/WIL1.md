# GDSC 백엔드 스터디 1주차

## Java와 객체 지향 프로그래밍
### 1. Java
#### - 썬마이크로시스템즈에서 1995년에 발표한 객체지향 프로그래밍 언어
#### - 객체지향프로그래밍 언어, 가비지 컬렉션, JVM
#### - JVM은 자바가 운영체제에 독립적으로 실행될 수 있게하는 소프트웨어. 바이트코드를 OS에 맞게 머신코드로 해석해준다. --> 이식성
### 2. 객체지향 프로그래밍
#### - 객체지향 프로그래밍이란 현실 속에 존재하는 사물을 최대한 유사하게 모방해 소프트웨어 내부로 옮겨오는 작업
#### - 객체는 행위와 상태를 가지고 있다. 예를 들어 자동차라는 객체가 있을 때, 액셀과 브레이크는 행위(동작)이고 속도와 기어단수는 상태이다.
#### - 특징
#### 1) 추상화: 객체 간 공통된 특성을 추출하는 것 (공통의 속성, 상태와 행위 찾기).
#### 2) 캡슐화: 한 클래스 안에 데이터의 형태와 데이터를 다루는 방법을 묶어 놓는 것. 상태 필드와 메소드를 통해 접근제어자를 통해 정보은닉 가능
#### 3) 상속: 어떤 클래스의 속성와 행위를 하위 클래스에 물려 주는 것.
#### 4) 다형성: 이용방법은 똑같지만 그 결과가 여러가지로 나오는 것. 예를 들어 어떤 프로그램에서 db의 종류를 메모리에서 MySQL로 바꿔도 '저장소'(인터페이스라고 가정)의 기본 기능은 하지만 구체적인 결과는 다름. 메소드 오버라이딩과 오버로딩을 통해 다형성 구현 가능.
#### 오버라이딩 - 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의해서 사용하는 것
#### 오버로딩 - 같은 이름의 메서드가 인자의 개수나 자료형에 따라 다른 기능을 하는 것
#### - 객체지향 설계 원칙(SOLID)
#### 1) 단일 책임 원칙: 하나의 클래스는 단 하나의 책임만 가져야 한다.
#### 2) 개방-폐쇄 원칙: 소프트웨어 요소는 확장에는 열려 있고 변경에는 닫혀 있어야 한다. f1 머신을 생각해보면, 경기중에 딱딱한 타이어에서 부드러운 타이어로 교체한다고 하더라도 기존 차량의 서스펜션이나 브레이크 같은 다른 기능들에 영향을 주지 않는다. 즉 서스펜션이나 브레이크 입장에서는 타이어(추상화)의 구체적인 종류(구현체)에 대해 어떤 정보도 가지고 있지 않는 것 --> DIP와 연결.
#### 3) 리스코프 치환 원칙: 프로그램 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
#### 4) 인터페이스 분리 원칙: 인터페이스의 단일 책임
#### 5) 의존관계 역전 원칙(DIP): 클라이언트(어떤 행위나 속성에 대해 요청하는 쪽)는 추상화에 의존해야지 구체화에 의존하면 안된다. 자바 코드로 예를 들면, 인터페이스에 의존하고 그 구현체에 의존하면 안된다. 여기서 의존한다라는 것은, 해당 인터페이스나 그 구현체를 클라이언트 객체가 가지고 있다는 것을 말함. 즉 구현체에 의존하게 되면 구현체가 바뀔 때마다 요청자의 코드도 변경해야 해서 원칙에 위반된다.

## 과제 프로그램 코드
##
```java
package org.example;

public class Main {
public static void main(String[] args) {

        Calculator calculator = new Calculator() {
            @Override
            public int plus(int a, int b) {
                return a + b;
            }

            @Override
            public int minus(int a, int b) {
                return a - b;
            }

            @Override
            public int mul(int a, int b) {
                return a * b;
            }

            @Override
            public int div(int a, int b) {
                return a / b;
            }
        };

        System.out.println("1234 + 4321 = " + calculator.plus(1234, 4321));
        System.out.println("911 - 170 = " + calculator.minus(911, 170));
        System.out.println("2 * 3 = " + calculator.mul(2, 3));
        System.out.println("33 / 11 = " + calculator.div(33, 11));

        System.out.println("\n");

        Cat cat = new Cat(); // 다른 동물 하셔도 상관 없습니다!
        Dog dog = new Dog();
        Animal[] animals = {cat, dog};
        for (Animal animal : animals) {
            animal.speak();
        }
    }
}
```
```java
package org.example;

public abstract class Animal {
    public abstract void speak();
}
```
```java
package org.example;

public class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("cat says Meow!");
    }
}
```
```java
package org.example;

public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("cat says Meow!");
    }
}
```
#### 코드 설명: caculator 인터페이스를 main 함수의 caculator 객체에서 오버라이딩해서 구현했다. 각각의 기능들을 정의하고 prinlnt 함수에서 그 기능들을 사용하고 있다. Animal 클래스와 메소드를 추상화 했고, 그 자식 클래스들인 Cat과 Dog에서 오버라이딩하여 각각의 speak() 기능에 맞게 재정의했다.
