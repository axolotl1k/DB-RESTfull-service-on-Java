# test

Ця тека містить модульні та інтеграційні тести для перевірки роботи застосунку.

---

## Навіщо це потрібно?

- Тести дозволяють переконатися, що додаток запускається і працює коректно.
- Автоматичне тестування спрощує пошук помилок при розробці та під час змін у коді.
- Дозволяє впевнено оновлювати та розширювати функціонал без страху "поламати" щось існуюче.

---

## Що тут є?

- [`RestServiceApplicationTests.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/test/java/com/pliffdax/RESTService/RestServiceApplicationTests.java) — базовий інтеграційний тест, який перевіряє, чи успішно стартує весь Spring Boot застосунок.
    - Метод [`contextLoads()`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/test/java/com/pliffdax/RESTService/RestServiceApplicationTests.java#L10) автоматично викликається при тестуванні й перевіряє, що контекст Spring Boot піднімається без помилок.

---

## Приклад

```java
@SpringBootTest
class RestServiceApplicationTests {
    @Test
    void contextLoads() { }
}
```

---

Усі нові функції рекомендується супроводжувати власними тестами для підвищення надійності та якості коду.