![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Sumativa 3 Semana 8 – Desarrollo Orientado a Objetos II

## 👤 Autor del proyecto
- **Nombre completo:** Cinthya Guzmán
- **Sección:** 002A
- **Carrera:** Analista Programador Computacional
- **Sede:** Duoc Online

---

## 📘 Descripción general del sistema

SpeedFast es una aplicación de escritorio desarrollada en Java con Swing, que permite gestionar pedidos y asignar repartidores utilizando una base de datos de MySQL.
El sistema implementa el patrón de arquitectura MVC (Model-View-Controller) junto con el patrón DAO (Data Access Object) para separar responsabilidades y mantener una estructura limpia y escalable.
La aplicación permite: 

- Registrar nuevos pedidos
- Listar pedidos almacenados en la base de datos
- Registrar repartidores
- Asignar repartidores a pedidos
- Persistir la información en MySQL mediante JDBC

La interfaz g´rafica fue desarrolada con Swing, utilizando componentes como JFrame,
JTable, DefaultTableModel, JButton, JOptionPane para la interacción con el usuario.

En la capa de datos se utiliza

- PreparedStatement para prevenir inyección de SQL
- Enum (Tipo y Estado) para tipar corrctamente los valores del sistema
- Conexión JDBC y MySQL mediante mysql-connector-j

Este proyecto demuestra la aplicación práctica de;

- Programación orientada a objetos
- Arquitectura en capas
- Conexión a base de datos
- Manejo de eventos en interfaces gráficas
- Implementación CRUD completo



---

## 🧱 Estructura general del proyecto

```plaintext

SpeedFast/
 ├── .idea/
 ├── .mvn/
 ├── src/
 │    └── main/
 │        └──  java/
 │               └── org.cvguzman/
 │                  └── conexion/
 │                  │      └── ConexionBD.java
 |                  |      └── TestConexion.java
 |                  ├── controlador/       
 │                  │      └── ControladoresDePedidos.java
 │                  ├──  dao/        
 │                  │      └── ClienteDAO.java
 │                  │      └── EntregasDAO.java
 │                  │      └── PedidosDAO.java
 │                  │      └── RepartidoresDAO.java
 │                  ├── main/
 |                  │      └── Main.java
 │                  ├── modelo/
 |                  |      └── Entregas.java
 |                  |      └── Estado.java
 |                  |      └── Pedidos.java
 |                  |      └── Repartidores.java
 |                  |      └──Tipo.java
 |                  ├── vista/
 |                  |      └──VentanaListaPedidos.java
 |                  |      └──VentanaPrincipal.java
 |                  └────- └── VentanaRegistroPedidos.java          
 ├── target/
 ├── .gitignore
 ├── pom.xml
 └──  README.md

````


## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/cvguzman/speed-fast.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Ejecuta el archivo `Main.java` desde el paquete `gestores` para resultados en consola.

4. Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).


---

**Repositorio GitHub:** https://github.com/cvguzman/speed-fast
**Fecha de entrega:** 09/02/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones |  