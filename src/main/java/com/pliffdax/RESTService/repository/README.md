# repository

Ця тека містить інтерфейси-репозиторії для роботи з базою даних через Spring Data JPA.

---

## Призначення

Папка `repository` реалізує шар доступу до даних (DAO) у додатку.  
Кожен репозиторій відповідає за збереження, пошук, оновлення й видалення сутностей певного типу в базі даних, а також надає можливість створювати свої власні запити без написання SQL-коду.

---

## Основні репозиторії:

- [`UserRepository.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/repository/UserRepository.java) — робота з таблицею користувачів (`User`).
- [`RoleRepository.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/repository/RoleRepository.java) — робота з таблицею ролей (`Role`).
- [`MemberRepository.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/repository/MemberRepository.java) — робота з членством користувача в ролі (`Member`).
- [`BanRepository.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/repository/BanRepository.java) — робота з банами користувачів (`Ban`).

---

## Коротко про функціонал:

- Розширюють стандартний інтерфейс `JpaRepository` (або `CrudRepository`).
- Дозволяють виконувати базові CRUD-операції без написання SQL-запитів.
- Можуть містити додаткові методи для пошуку за унікальними критеріями (наприклад, пошук по імені, email, статусу).
- Забезпечують зв’язок між Java-кодом і реальною базою даних через ORM.

---

## Приклад використання

```java
// Пошук користувача за іменем
Optional<User> findByName(String name);

// Перевірка наявності ролі у користувача
boolean existsByUserIdAndRoleName(Integer userId, String roleName);
```