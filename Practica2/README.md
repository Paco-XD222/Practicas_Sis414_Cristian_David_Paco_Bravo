# Practica 3 - API de Películas

## 👨‍💻 Estudiante

Cristian David Paco Bravo

---

## 📌 Descripción

API desarrollada con Spring Boot que permite gestionar una lista de películas.
Incluye operaciones CRUD y documentación interactiva con Swagger.

---

## 🌐 Despliegue en Render

API:
https://practicas-sis414-cristian-david-paco.onrender.com/

Swagger:
https://practicas-sis414-cristian-david-paco.onrender.com/swagger-ui/index.html

---

## 🚀 Endpoints

### 🔹 GET sin parámetros

* `/` → verificar API
* `/peliculas` → lista de películas
* `/futuro` → mensaje personal

---

### 🔹 GET con parámetros

* `/pelicula?nombre=&genero=&anio=&director=` → buscar película

---

### 🔹 POST

* `/pelicula` → agregar película

---

### 🔹 PUT

* `/pelicula` → actualizar película

---

### 🔹 DELETE

* `/pelicula` → eliminar película

---

## 🛠 Tecnologías

* Java
* Spring Boot
* Gradle
* Swagger (OpenAPI)
* Render
* GitHub

---

## 📖 Notas

* La API utiliza una lista en memoria (no base de datos).
* Swagger permite probar todos los endpoints directamente desde el navegador.
