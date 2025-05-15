# main/resources

У цій теці зберігаються ресурси, необхідні для роботи додатку, зокрема конфігураційний файл **application.properties** для Spring Boot.

---

## Що таке application.properties?

Цей файл містить основні налаштування Spring Boot застосунку, зокрема параметри підключення до бази даних, режим роботи Hibernate та інші опції.

---

## Основні параметри у файлі:

```properties
spring.application.name=RESTService

spring.datasource.url=jdbc:mysql://localhost:3306/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### Що таке environment variables (`${DB_NAME}`, `${DB_USER}`, `${DB_PASS}`)?

**Environment variables (змінні оточення)** — це змінні, які задаються на рівні операційної системи або середовища запуску й дозволяють зберігати чутливу інформацію (наприклад, логіни й паролі) окремо від коду.

- **${DB_NAME}** — назва бази даних MySQL, до якої буде підключатися застосунок.
- **${DB_USER}** — ім'я користувача бази даних.
- **${DB_PASS}** — пароль користувача бази даних.

---

### Як налаштувати environment variables?

**Для Windows:**

Перед запуском додатку у терміналі виконайте:

```cmd
set DB_NAME=my_database
set DB_USER=my_user
set DB_PASS=my_password
```

**Для Linux / MacOS:**

```cmd
export DB_NAME=my_database
export DB_USER=my_user
export DB_PASS=my_password
```
Після цього запускайте додаток звичайним чином, наприклад, через:
```bash
mvn spring-boot:run
```

### Чому це важливо?
Зберігання даних для підключення через environment variables — це безпечніше, ніж зберігати логін і пароль прямо у файлі, який може потрапити у відкритий репозиторій.