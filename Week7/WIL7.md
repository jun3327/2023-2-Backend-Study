## GDSC 백엔드 스터디 7주차

#### 1. 과제하면서 오류난 점
  - 컨트롤러에서 JSON 바인딩 직렬화 오류
    - 클라이언트에게 값을 반환할 때 반환하는 객체를 Json으로 직렬화 하는 경우, 이 때 해당 객체 클래스에 Getter가 있어야함 (Jackson이 Getter를 필요)
  
    
  - Lazy 로딩으로 인한 프록시 객체와 Json 바인딩 시 오류
    - 에러 화면

      <img width="405" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/8a81076d-1f86-4058-8a01-62d0cf8f77eb">
      <img width="875" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/53996603-8d83-4181-9b59-dafae2ec8409">
    - Lazy 로딩 ( <-> Eager 로딩)
      - DB로부터 어떤 객체가 호출될 때 그 객체와 연관되어 있는 다른 객체를 바로 불러오지 않고 프록시, 즉 가짜 객체를 가져와 대기시키고 연관된 객체가 실행될 때서야 비로소 진짜 객체를 DB로부터 불러옴(이를 초기화라 함)
      - 위 에러 화면에서는 Doctor 객체를 리스트로 가져와 Get 요청에 대해 JSON으로 바인딩 후 응답하는 도중에 생긴 에러인데, Doctor 엔티티는 아래와 같이 MedicalDepartment 사이에 lazy 로딩설정이 되어있다.
        <img width="434" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/a0565395-f8b6-4045-bc3f-0a401c6b5711">
    - 오류 원인
      - Jackson이 직렬화를 할 때 이 프록시 객체를 인식하지 못한다. 
    - 해결
      - Repository에서 Custom Query로 가져올 때 fetch join 사용. 페치 조인은 지연로딩 설정 다 무시하고 실제 엔티티를 가져옴.
           <img width="449" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/7f0171ba-9ab4-4420-b4d8-f5bd011902d1">
      - 위 코드에서 MedicalDepartment와 Hopsital 엔티티 사이에도 lazy 설정이 되어있어 전부 페치 조인했다. 과제에서는 직접 엔티티를 응답 API에 노출하고 있기 때문에 어쩔 수 없지만 DTO를 사용한다면 필요한 값만 골라 페치 조인해서 반환하면 될듯하다
------------------------------------------------------
#### 2. 예시 api테스트 결과

  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/4420bd99-a881-4af1-89f0-77075385ca2c" width="500">
------------------------------------------------------
  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/32c44133-ef75-4b81-ba17-4ee55af391e0" width="500">
------------------------------------------------------
  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/e35f2fba-0644-4edd-a7d1-90d5b14270c5" width="500">
------------------------------------------------------
#### 3. 프로그램 구현(환자, 의사, 예약) api 테스트 결과

  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/4fa5492d-8c2f-4636-8003-b461356bdd7a" width="500">
------------------------------------------------------
  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/d93dc77e-47b3-460c-acdf-87e5d8d35447" width="500">
------------------------------------------------------
  <img src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/521a7fde-ac78-4b4d-81b1-74c2ceca87e0" width="500">