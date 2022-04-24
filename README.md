# spring-webservice
참고 도서 : [스프링 부트와 AWS로 혼자 구현하는 웹 서비스, 이동욱 저자](http://www.yes24.com/Product/Goods/83849117)

## Project Setting              
* Spring boot version : 2.1.9 RELEASE    
* Gradle : 4.10.2               
* Dependencies
  - Spring Web
  - Mustache
  - Lombok      
  - Spring Data JPA
  - OAuth2
  - Spring Session JDBC
  - H2 Database                         

## 새롭게 알게 된 내용
- `@Column(columnDefinition = "TEXT")` : 직접 Column 정의, 타입을 TEXT로 변환하여 기본값인 varchar(255)를 변환
- `@Column(length = 500)` : 길이를 500으로 제한 , 기본값인 varchar(255)를 500으로 늘림
- Entity 클래스에 Setter를 두지 않아야 한다.
  - 클래스의 인스턴스 값이 언제, 어디서 변경되는지 추적하기 어려워져 차후 기능 변경 시 문제 야기
  - 인스턴스 생성 시 값을 채워넣어야 할 때는 Constructor, Builder 패턴을 통해 삽입
  - 필드 값 변경 필요 시 setter 대신 명확한 목적과 의도를 나타내는 메서드를 추가하는 방향으로 설계
```java
(X)
public void 주문취소() {
    order.setStatus(false);
}

(O)
public void cancelOrder() {
    this.status = false;
}
public void 주문취소() {
    order.cancelOrder();
}
```
- .js와 같은 파일 내용을 수정했는데도 브라우저에서 동작을 안한다면, 브라우저에서 수정 전 파일의 캐시를 가져옴으로써 생기는 문제일 수 있다. 브라우저의 캐시를 비우고 다시 시도해본다.
