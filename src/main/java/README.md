# main/java

Ця директорія містить основний вихідний код застосунку на Java.

## Основна структура:
Уся основна структура коду розміщена у теці
`com.pliffdax.RESTService`, яка містить такі структуровані теки та файли:

- [`config/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/config) — конфігурації Spring Boot та налаштування застосунку
- [`controller/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/controller) — контролери, які обробляють REST-запити
- [`dto/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/dto) — обʼєктні моделі для передачі даних між шарами застосунку
- [`entity/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/entity) — сутності (Entities), які відображають таблиці бази даних
- [`exeption/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/exeption) — обробка помилок і винятків у застосунку
- [`repository/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/repository) — інтерфейси для взаємодії з базою даних (DAO)
- [`service/`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/tree/master/src/main/java/com/pliffdax/RESTService/service) — бізнес-логіка, основні операції з даними
- [`RestServiceApplication.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/RestServiceApplication.java) — головний клас запуску Spring Boot застосунку

---

Ця структура відповідає принципам чистої архітектури та дозволяє зручно масштабувати та підтримувати проєкт.

