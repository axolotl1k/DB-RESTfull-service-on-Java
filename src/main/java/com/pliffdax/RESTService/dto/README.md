# dto

Ця тека містить **Data Transfer Objects (DTO)** — спеціальні класи для передачі даних між клієнтом і сервером, а також між різними шарами застосунку.

---

## Навіщо потрібні DTO?

- DTO дозволяють відокремити зовнішні дані (які отримує або повертає API) від внутрішньої моделі сутностей (`entity`).
- Захищають внутрішню структуру бази даних і бізнес-логіку від випадкового чи навмисного втручання ззовні.
- Дають можливість передавати тільки потрібні поля, уникати надлишкової або чутливої інформації.
- Полегшують валідацію даних на вхід/вихід.

---

## Основні DTO в проекті:

- [`RegisterRequest.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/dto/RegisterRequest.java) — дані для реєстрації користувача.
- [`LoginRequest.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/dto/LoginRequest.java) — дані для входу в систему.
- [`LoginResponse.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/dto/LoginResponse.java) — відповідь сервера після успішного входу.
- [`EditUserDataRequest.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/dto/EditUserDataRequest.java) — зміна даних профілю користувача.
- [`BanUserRequest.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/dto/BanUserRequest.java) — запит на блокування користувача.

---

## Приклад (спрощено):

```java
public record RegisterRequest(String username, String password, String email) {}
```

---

DTO допомагають зробити API безпечним, зрозумілим і зручним для використання на фронтенді чи іншими сервісами.