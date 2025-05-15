# entity

Ця тека містить Java-класи-сутності, які відображають таблиці бази даних (ORM) для Spring Data JPA.

---

## Навіщо це потрібно?

- Сутності (`entity`) — це основні бізнес-об'єкти, які зберігаються у базі даних.
- Кожен клас містить анотації (`@Entity`, `@Table`, `@Id`, тощо), які описують структуру відповідної таблиці, поля, зв'язки між таблицями (наприклад, один-до-багатьох, багато-до-багатьох).
- Ці класи використовуються у всіх основних частинах програми: в сервісах, репозиторіях, контролерах.

---

## Основні сутності в проекті:

- [`User.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/entity/User.java) — інформація про користувача.
- [`Role.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/entity/Role.java) — ролі, які може мати користувач.
- [`Member.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/entity/Member.java) — зв'язок між користувачем і роллю (членство).
- [`Ban.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/entity/Ban.java) — інформація про блокування користувача.

---

## Приклад (спрощено):

```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    // інші поля
}
```

---

Сутності забезпечують звʼязок між об'єктами Java-коду і даними в реальній базі даних, дозволяють працювати з даними об'єктно-орієнтованим способом.
