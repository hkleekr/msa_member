## MSADemo: msa_member
### 개요
CQRS를 활용한 MSA 구축 Demo (주문-배송 애플리케이션)

### MSA 구성
|번호 | 애플리케이션 | DB | 포트번호(애플리케이션/DB) |
|---|---|---|---|
|1 | msa_member | postgres | 8080/5432 |
|2 | msa_order | mariadb | 8081/3306 |
|3 | msa_inventory | mysql | 8082/3308 |
|4 | msa_shipping | sqlserver | 8083/1433 |

### 개발 환경
- JDK: 17
- Build Tools: Gradle
- Spring Boot: 3.4.0
- jpa: 3.4.0
- postgres: 42.7.4
- Lombok: 1.18.24
