# Portafolio TLP2: Talleres de Lenguajes de Programación 2

Este repositorio contiene la colección de proyectos, laboratorios y evaluaciones desarrollados durante la asignatura de **Lenguajes de Programación 2**. El enfoque principal es el desarrollo Backend con **Java Spring Boot**, la implementación de seguridad, persistencia de datos (SQL y NoSQL) y la integración con Frontends modernos.

**Autor:** Sebastián López Osorno
**Tecnología Principal:** Java 17 / Spring Boot 3

-----

## 🛠️ Stack Tecnológico Global

El ecosistema de desarrollo abarca las siguientes tecnologías:

| Área | Tecnologías |
| :--- | :--- |
| **Backend** | Java 17, Spring Boot (Web, Data JPA, Security, JDBC), Maven |
| **Frontend** | Thymeleaf, Bootstrap 5, JavaScript (SweetAlert2), React.js, Tailwind CSS |
| **Base de Datos** | MySQL, H2 (In-memory), Supabase (PostgreSQL) |
| **Herramientas** | Postman, Git, IntelliJ IDEA / VS Code |

-----

## 📂 Estructura del Repositorio

El repositorio se organiza en módulos independientes según el progreso del aprendizaje:

### 1\. 🛒 Parcial 1: Sistema E-Commerce Completo

**Ubicación:** `/Parcial1`

Este es el proyecto más robusto del repositorio. Es una aplicación web monolítica MVC para la gestión de un comercio electrónico.

  * **Características Principales:**
      * **Seguridad:** Implementación de `Spring Security` con encriptación `BCrypt` y manejo de sesiones.
      * **Roles:** Diferenciación entre `Administrador` (CRUD completo) y `Cliente` (Carrito de compras).
      * **Lógica de Negocio:**
          * Gestión de Inventario (Productos y Stock).
          * Sistema de Facturación (Cabecera `Purchase` y Detalle `Detail`).
          * Validaciones de Backend (`@Valid`, `BindingResult`).
      * **Frontend:** Vistas dinámicas con Thymeleaf y alertas interactivas con SweetAlert2.
      * **Base de Datos:** MySQL con relaciones One-To-Many y Many-To-One.

### 2\. 🧪 Demos Introductorios

**Ubicación:** `/demo` y `/demo_h2`

Proyectos base para entender los fundamentos del framework Spring.

  * **Demo 1 (`/demo`):**
      * Manejo de controladores (`@Controller`).
      * Inyección de dependencias y paso de parámetros por URL (`@RequestParam`, `@PathVariable`).
      * Vistas básicas con Thymeleaf.
  * **Demo H2 (`/demo_h2`):**
      * Introducción a JPA/Hibernate.
      * Uso de base de datos en memoria **H2** para prototipado rápido.
      * Implementación del patrón DAO (Data Access Object).

### 3\. ⚛️ Integración Frontend (React)

**Ubicación:** `/react_app`

Proyecto separado para demostrar la capacidad de crear interfaces modernas desacopladas del backend.

  * **Tecnología:** React.js + Tailwind CSS.
  * **Objetivo:** Consumo de APIs REST (potencialmente conectada a los backends de Spring Boot).
  * **Componentes:** Listados de estudiantes y estilización moderna.

### 4\. ☁️ Servicios en la Nube

**Ubicación:** `/SupaBase`

Integración de Spring Boot con servicios BaaS (Backend as a Service).

  * **Objetivo:** Conectar la aplicación Java con **Supabase** (PostgreSQL en la nube).
  * **Funcionalidad:** Gestión de usuarios remota y persistencia en la nube.

-----

## 🚀 Instrucciones de Ejecución

Cada subcarpeta es un proyecto independiente (generalmente un proyecto Maven).

### Requisitos Previos

  * **Java JDK 17** o superior.
  * **Maven** (opcional, ya que los proyectos incluyen el wrapper `mvnw`).
  * **MySQL Server** (Para el proyecto `Parcial1`).
  * **Node.js** (Para el proyecto `react_app`).

### Pasos Generales (Spring Boot)

1.  Navega a la carpeta del proyecto (ej. `Parcial1`):
    ```bash
    cd Parcial1
    ```
2.  Configura la base de datos en `src/main/resources/application.properties` (si aplica).
3.  Ejecuta la aplicación:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  Accede desde el navegador (usualmente `http://localhost:8090` o el puerto configurado).

### Pasos para React App

1.  Navega a la carpeta:
    ```bash
    cd react_app
    ```
2.  Instala dependencias y ejecuta:
    ```bash
    npm install
    npm start
    ```

-----

## 🧠 Conceptos Clave Aprendidos

A lo largo de estos talleres se han aplicado patrones de diseño y arquitecturas estándar de la industria:

1.  **Patrón MVC (Modelo-Vista-Controlador):** Separación clara de la lógica de negocio, la interfaz de usuario y el control de flujo.
2.  **Inyección de Dependencias (DI):** Uso del contenedor de Spring para gestionar los beans (`@Autowired`, `@Service`, `@Repository`).
3.  **ORM (Object-Relational Mapping):** Mapeo de objetos Java a tablas relacionales usando Hibernate/JPA.
4.  **Seguridad Web:** Autenticación y Autorización basada en roles.

-----

### Estado del Proyecto

  * ✅ **Parcial 1:** Completado y funcional.
  * ✅ **Talleres Básicos:** Completados.
  * 🚧 **React App:** En desarrollo/Integración.

-----

*Documentación generada para la asignatura TLP2 - Ingeniería Informática.*

Para que esta documentación brille aún más, especialmente la sección del **Parcial 1**, te sugiero agregar un diagrama de la base de datos, ya que es el proyecto más complejo.

**¿Te gustaría que genere el código Mermaid para el diagrama Entidad-Relación (ER) del Parcial 1 basándome en tus entidades (`User`, `Product`, `Purchase`, `Detail`) para que lo incluyas en el README?**
