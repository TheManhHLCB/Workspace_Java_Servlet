CREATE DATABASE IF NOT EXISTS final_exam_db;
USE final_exam_db;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (name, price, quantity) VALUES 
('Laptop Dell XPS 15', 1500.0, 10),
('iPhone 15 Pro Max', 1200.0, 20),
('Bàn phím cơ Keychron', 100.0, 50);
