# Тестування REST API через Postman

У цій теці зібрано колекцію запитів Postman для перевірки роботи всіх основних ендпоїнтів `UserController`.

---

## Як користуватися

1. Імпортуйте файл колекції (наприклад, `RESTService.postman_collection.json`) у свій Postman.
2. Переконайтесь, що сервер Spring Boot запущено на `http://localhost:8080`.
3. Виконуйте запити у порядку:
    - Створення користувача
    - Логін
    - Редагування / видалення профілю
    - Додавання / видалення ролі
    - Бан / розбан

---

## Опис ендпоїнтів та приклади запитів

### 1. Реєстрація користувача
`POST /api/users/register`

```json
{
  "username": "newuser",
  "password": "password123",
  "email": "newuser@email.com"
}
```

### 2. Логін користувача
`POST /api/users/login`

```json
{
  "username": "newuser",
  "password": "password123"
}
```

### 3. Редагування користувача
`PUT /api/users/{id}?editorId={editorId}`

```json
{
  "username": "updateduser",
  "password": "newpassword",
  "email": "user@email.com",
  "avatar": "images/avatar.png",
  "status": "Active"
}
```

### 4. Видалення користувача
`DELETE /api/users/{id}?editorId={editorId}`

### 5. Додати роль користувачу
`POST /api/users/{id}/roles?adminId={adminId}&role={role}`

### 6. Отримати ролі користувача
`GET /api/users/{id}/roles`

### 7. Видалити роль користувача
`DELETE /api/users/{id}/roles?adminId={adminId}&role={role}`

### 8. Забанити користувача
`POST /api/users/ban?adminId={adminId}`

```json
{
  "username": "user",
  "reason": "spam",
  "untilDate": "2024-12-01T23:59:00"
}
```

### 9. Розбанити користувача
`POST /api/users/unban?adminId={adminId}&userId={userId}`
