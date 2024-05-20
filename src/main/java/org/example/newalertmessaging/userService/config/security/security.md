# 보안 관련 설정
## 인증
  - session manager close
  - jwt filter add
  - exception endpoint add
## 암호화
  - password: BCryptPasswordEncoder
## api
  - 인증 필요 api와 불필요 api의 구분
    - 인증 없는 api는 DDOS공격에 취약
    - 추후 recapcha 등을 통해 막아야 할 필요성 있음
  - 추후 권한에 따라 분리 추가 필요
    - 관리자(admin), 유저(user)

## 보안 정책
  - cors: 