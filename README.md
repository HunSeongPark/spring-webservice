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
