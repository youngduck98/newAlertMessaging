# dto factory 문서

## 역할
- 특정 dto 생성시 자동으로 부여되는 특정 역할 부여
  - ex) mail이 ture -> 해당 dto생성시 관리자에게 
  mail알림 전송

## 구조
- ResponseDTOFactory를 상속 받아 생성