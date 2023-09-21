## GDSC 백엔드 스터디 2주차

### HTTP란?
- HTTP(HyperText Transfer Protocol)는 서로 다른 시스템 사이에서 통신을 주고 받게 하는 application 계층의 protocol이다.
- protocol: 규약, 규칙
- application 계층: 인터넷 프로토콜 4계층 중 하나. 여기서 4계층은 네트워크 인터페이스 계층, 인터넷 계층(IP), 전송 계층(TCP/UDP), 애플리케이션 계층(HTTP, FTP)이다.
- TCP/IP 기반으로 클라이언트와 서버 간 요청과 응답을 전송한다.
- 비연결성, 무상태성

### TCP/IP:
- IP만으로 통신하는 것을 보완하기 위해 TCP를 사용. TCP는 가상연결 3-way-handshake(syn, syn/ack, ack)로 상대방과 연결하고, 데이터 전달을 보증하며, 전달되는 패킷의 순서를 보장한다(신뢰성 기반).
- 반대로 UDP는 순서를 보장하지 않고, 3-way-handshake를 하지 않으며 데이터 전달이 보증되지 않는다. 그만큼 UDP가 TCP에 비해 속도는 빠르다.
- 현재 대부분은 TCP를 사용하고 있고, UDP를 사용하는 HTTP3도 점점 증가하고 있다.

### 비연결성
- 클라이언트와 서버가 연결을 맺은 후 클라이언트가 서버의 응답을 받으면 연결을 끊어버린다. 서버의 자원을 효율적으로 사용하기 위한 것이다. 하지만 TCP/IP 연결을 여러번 해야 하는 단점이 있다. 이런 한계는 'HTTP 지속 연결'로 해결하고, HTTP2, HTTP3을 거쳐 최적화되었다.

### 무상태성
- 클라이언트의 상태를 서버가 알고있지 못한다는 것이다(클라이언트 식별 x). 클라이언트의 상태나 정보를 서버가 알지 못한다면, 클라이언트는 계속 본인의 상태를 만나는 서버마다 일일이 알려줄 수 밖에 없다.


- 장점: 수평적 확장(scale out)이 유리하다는 것이다. 서버가 무상태이고 클라이언트가 자신의 상태정보를 계속 들고 있다면 같은 기능을 하는 추가 서버를 충분히 증설할 수 있다.


- 단점: 클라이언트가 추가 데이터를 전송해야만 한다는 것이다. 또한 로그인 같이 클라이언트의 상태를 서버가 유지해야하는 경우도 존재한다.

### HTTP 연결
- TCP 연결 열기 -> HTTP 메시지 전송 -> 서버가 보낸 응답을 읽는다 -> 연결을 닫거나 다른 요청을 위해 재사용

### HTTP 메시지와 구조
- HTTP는 HTTP 메시지로 데이터를 주고받는다. HTTP 메시지에는 요청과 응답이 있다
- 구조: stat-line, header, empty line(CRLF), message body로 이루어져 있음.

### HTTP 메소드
- 클라이언트가 서버에 특정 요청을 보낼 때, 웹서버에게 그 목적과 종류를 알리는 수단
- 주로 사용하는 종류
    1) GET: 리소스 조회
    2) POST: 요청 데이터 처리, 주로 등록에 사용
    3) PUT: 리소스를 대체, 해당 리소스가 없으면 생성
    4) PATCH: 리소스 부분 변경
    5) DELETE: 리소스 삭제

### HTTP 상태코드
- 서버측에서 클라이언트로 요청에 대한 응답을 보낼 때, 해당 요청에 관한 처리 상태를 알려주는 기능
- 종류:
    1) 1xx (Informational): 요청이 수신되어 처리중
    2) 2xx (Successful): 요청 정상 처리
    3) 3xx (Redirection): 요청을 완료하려면 추가 행동이 필요
    4) 4xx (Client Error): 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음
    5) 5xx (Server Error): 서버 오류, 서버가 정상 요청을 처리하지 못함

### HTTPS란? 
- HTTP의 보안이 강화된 버전. HTTPS는 소켓 통신에서 일반 텍스트를 이용하는 대신에, SSL이나 TLS 프로토콜을 통해 세션 데이터를 암호화


- HTTP는 암호화되지 않은 방법으로 데이터를 전송하기 때문에 서버와 클라이언트가 주고 받는 메시지를 감청하는 것이 매우 쉽다. 예를들어 로그인을 위해서 서버로 비밀번호를 전송하거나, 또는 중요한 기밀 문서를 열람하는 과정에서 악의적인 감청이나 데이터의 변조등이 일어날 수 있다는 것이다. 이를 보안한 것이 HTTPS다.


- SSL/TLS(Transport Layer Security, 전송 계층 보안) :  컴퓨터 네트워크에 통신 보안을 제공하기 위해 설계된 암호 규약

### RESTful URI 설계 과제
- 이벤트 목록 조회 : GET /events
- 이벤트 조회 : GET /events/{eventId}
- 이벤트 등록: POST /events
- 이벤트 수정: PUT /events/{eventId}
- 이벤트 삭제: DELETE /events/{eventId}
- 이벤트 상태 변경: PUT /events/{eventId}/status 
- 특정 이벤트의 주문 목록 조회: GET /events/{eventId}/orders
- 멤버 목록 조회: GET /members
- 특정 멤버 권한 변경: PUT /members/{memberId}/permissions
- 특정 멤버 정보 조회: GET /members/{memberId}
- 특정 멤버 정보 변경: PUT /members/{memberId}
- 멤버 등록: POST /members