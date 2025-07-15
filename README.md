# E-Commerce API Project

This is a basic e-commerce backend application built using Spring Boot. It includes JWT-based login for customers and admins, and supports product management, cart handling, and order placement.

## Features

- User registration and login (JWT-based)
- Role-based access: Admin and Customer
- Admin can add products
- Customer can view products, add to cart, and place orders
- Cart and order tracking
- H2 in-memory database

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Maven

## How to Run

1. Clone the project
2. Import it into your IDE (IntelliJ/VS Code/Eclipse)
3. Run the main class: `EcommerceApplication.java`
4. Open browser and go to:  
   - `http://localhost:8080/index.html` for the frontend  
   - `http://localhost:8080/h2-console` for the database (use `jdbc:h2:mem:ecomdb`)

## API Endpoints

### Authentication
- `POST /api/auth/register`
- `POST /api/auth/login`

### Products
- `GET /api/products`
- `POST /api/products` (Admin only)

### Cart
- `POST /api/cart/add`
- `GET /api/cart`
- `POST /api/cart/clear`

### Orders
- `POST /api/orders/place`
- `GET /api/orders`

