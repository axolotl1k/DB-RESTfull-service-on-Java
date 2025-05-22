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

### 1. Отримати всіх користувачів

`GET /api/users/all`

### 2. Реєстрація користувача
`POST /api/users/register`

```json
{
  "username": "newuser",
  "password": "password123",
  "email": "newuser@email.com"
}
```

**Відповідь:**

```json
{
  "code": "201",
  "message": "User registered successfully"
}
```

### 3. Логін користувача
`POST /api/users/login`

```json
{
  "username": "newuser",
  "password": "password123"
}
```

**Відповідь:**

```json
{
   "code": "200",
   "message": "Login successful",
   "data": {
      "id": 1,
      "name": "newuser",
      "email": "newuser@email.com",
      "avatar": "images/user.png",
      "status": "Active"
   }
}
```

### 4. Редагування користувача
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

**Відповідь:**

```json
{
   "code": "200",
   "message": "User edited successfully"
}
```

### 5. Видалення користувача
`DELETE /api/users/{id}?editorId={editorId}`

**Відповідь:**

```json
{
   "code": "200",
   "message": "User deleted successfully"
}
```

### 6. Додати роль користувачу
`POST /api/users/{id}/roles?adminId={adminId}&role={role}`

**Відповідь:**

```json
{
   "code": "200",
   "message": "Role added to user"
}
```

### 7. Отримати ролі користувача
`GET /api/users/{id}/roles`

**Відповідь:**

```json
{
   "code": "200",
   "message": "User roles retrieved",
   "data": ["USER", "ADMIN"]
}
```

### 8. Видалити роль користувача
`DELETE /api/users/{id}/roles?adminId={adminId}&role={role}`

**Відповідь:**

```json
{
   "code": "200",
   "message": "Role removed from user"
}
```

### 9. Забанити користувача
`POST /api/users/ban?adminId={adminId}`

```json
{
  "username": "user",
  "reason": "spam",
  "untilDate": "2024-12-01T23:59:00"
}
```

**Відповідь:**

```json
{
   "code": "200",
   "message": "User banned"
}
```

### 10. Розбанити користувача
`POST /api/users/unban?adminId={adminId}&userId={userId}`

**Відповідь:**

```json
{
   "code": "200",
   "message": "User unbanned"
}
```