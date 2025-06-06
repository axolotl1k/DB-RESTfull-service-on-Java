# controller

У цій теці знаходяться контролери — класи, що обробляють HTTP-запити й відповідають за взаємодію клієнта з сервером через REST API.

---

## Навіщо це потрібно?

- Контролери (`controller`) реалізують “точки входу” (ендпоїнти) для взаємодії з клієнтом (наприклад, фронтендом, Postman, чи іншим сервісом).
- Вони приймають, валідуюють і передають дані далі у сервіси.
- Формують відповідь клієнту, обробляють винятки та налаштовують коди статусу HTTP.

---

## Приклад (UserController):

- [`UserController.java`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/controller/UserController.java) — контролер для управління користувачами.
    - Реєстрація та авторизація користувачів (`/register`, `/login`)
    - Оновлення, видалення профілю, робота з ролями
    - Бан/розбан користувача (тільки для адміністратора)
    - Отримання списку ролей користувача

---

## Як це працює?

- Запит надходить на певний endpoint (наприклад, `POST /api/users/register`)
- Контролер отримує дані з запиту, викликає відповідний метод сервісу ([`UserService`](https://github.com/axolotl1k/DB-RESTfull-service-on-Java/blob/master/src/main/java/com/pliffdax/RESTService/service/UserService.java))
- Повертає відповідь у вигляді JSON, статус коду (200, 201, 204 тощо)
- Контролери не містять складної бізнес-логіки — вся “серйозна робота” делегується у сервіси

---

Контролери роблять API зручним, стандартизованим і безпечним для зовнішньої взаємодії.
