# smilegate auth_server project

아직 미완성입니다.

미완성 부분 (우선순위 순)
---
- 사용자 관리 페이지 제작 (백엔드는 완료, 프론트엔드 연결 미완)
- 권한(토큰) 확인 연결
- 로그아웃 연결
- msa 환경 설정

기술스택
---
- 스프링 부트 (코틀린)
    - 스프링 jpa
- mysql
- tailwindcss
- vite 

디렉토리별 설명
---
> frontend

메인페이지, 회원가입 페이지, 로그인페이지

> auth_server

회원가입 시 유저 생성(비밀번호 sha-256 으로 암호화)

로그인 시 토큰 생성

토큰의 경우 (이메일, 만든 시간, 갱신 시간)이 있음

```
추가 해야할 기능
웹페이지 갱신 마다 갱신 시간 업데이트 프론트엔드 연결 
유저 관리 페이지 연결
```

> api_server

msa 환경으로 만들었을 시 사용할 임의의 api 

실행법
---
init.sql 으로 데이터 베이스 설정 후 api_server, auth_server 실행

프론트엔드의 경우 frontend 디렉토리에서
```shell
# npm install
# npm run dev
```