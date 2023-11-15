## GDSC 백엔드 스터디 8주차

### 전 주차 코드와 비교해 수정한 점
  - 예약 시간을 예약 생성 시간으로 이해하고 처리했었는데, 이걸 클라이언트 측에서 보낸 값으로 설정하도록 변경
  - 저번에는 모든 예약 객체를 반환할 때 엔티티 그대로 반환했지만 이번 주차에서 id로 Reservation 반환하는 메소드에선 Dto로 반환하도록 했음


#### 1. Update API 테스트
<img width="638" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/61f7b651-c0a9-4967-bbc0-fb63a676ca7c">
<img width="612" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/4739d0ab-152b-41f2-bff5-d7435c63504b">
<img width="638" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/66ef6f21-11d6-4979-afd3-5af0de56ec8b">

#### 2. Delete API 테스트
<img width="620" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/d59ed251-8020-437d-9bf0-d3d8ecb7a268">
<img width="614" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/6b7bc054-6ceb-4842-8079-a8f61f4e0f90">

(없는 것을 조회했기 때문에 설정한대로 아래 사진에서 RuntimeException이 발생하는 것이 정상임)
<img width="617" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/cb8c9d89-9bc4-499d-bc7d-23fcc7709236">
<img width="818" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/e4ebb908-76fa-4892-80d0-445e5d30a85a">

#### 3. 예약 시간 수정 API 테스트
<img width="616" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/9447bafd-5d79-42ea-b961-45fdabd8b984">
<img width="614" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/6de92d86-e3d0-47c0-aedf-bff08379d39d">
<img width="610" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/3f49e5e7-3c80-4c87-a60a-e9a35347f64e">

#### 4. 예약 취소 API 테스트
<img width="600" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/5bfcf685-a897-4cb5-a233-b947e250ea0c">


(삭제 했으므로 설정한대로 RuntimeException 발생)
<img width="626" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/eff0cc5b-dd5c-4862-9da4-85d29a2cee49">
<img width="828" alt="image" src="https://github.com/jun3327/2023-2-Backend-Study/assets/121341289/944617b0-e1f3-4621-bfae-9bc821d9b30f">