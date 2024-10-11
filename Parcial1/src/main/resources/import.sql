INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('John', 'Doe', 'john.doe@example.com', 'Password123!', 'Cliente', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', 'Password123!', 'Administrador', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Alice', 'Johnson', 'alice.johnson@example.com', 'Password123!', 'Cliente', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Bob', 'Brown', 'bobi.brown@example.com', 'Password123!', 'Cliente', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Alejo', 'Doe', 'alejon.doe@example.com', 'Password123!', 'Cliente', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Pedro', 'Smith', 'jper.smith@example.com', 'Password123!', 'Administrador', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Juan', 'Johnson', 'juance.johnson@example.com', 'Password123!', 'Cliente', NOW());
INSERT INTO usuarios (name, lastname, email, password, role, create_at)
VALUES ('Charli', 'Brown', 'charh.brown@example.com', 'Password123!', 'Cliente', NOW());

INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 1', 'Descripción del producto 1', 1000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 2', 'Descripción del producto 2', 2000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 3', 'Descripción del producto 3', 3000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 4', 'Descripción del producto 4', 4000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 5', 'Descripción del producto 5', 5000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 6', 'Descripción del producto 6', 1000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 7', 'Descripción del producto 7', 2000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 8', 'Descripción del producto 8', 3000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 9', 'Descripción del producto 9', 4000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 10', 'Descripción del producto 10', 5000, 20);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 11', 'Descripción del producto 11', 6000, 15);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 12', 'Descripción del producto 12', 7000, 15);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 13', 'Descripción del producto 13', 8000, 10);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 14', 'Descripción del producto 14', 9000, 10);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 15', 'Descripción del producto 15', 10000, 5);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 16', 'Descripción del producto 16', 11000, 5);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 17', 'Descripción del producto 17', 12000, 8);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 18', 'Descripción del producto 18', 13000, 8);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 19', 'Descripción del producto 19', 14000, 6);
INSERT INTO productos (name, description, unit_value, stock)
VALUES ('Producto 20', 'Descripción del producto 20', 15000, 4);

INSERT INTO compras (user_id, subtotal, total, discount_total, create_at)
VALUES (1, 5000, 2000, 3000, '2024-07-28');
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (1, 1, 2, 2000, 2000);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (1, 3, 1, 3000, 1000);

INSERT INTO compras (user_id, subtotal, total, discount_total, create_at)
VALUES (3, 40000, 18000, 22000, '2024-09-28');
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (2, 4, 6, 24000, 12000);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (2, 7, 8, 16000, 10000);

INSERT INTO compras (user_id, subtotal, total, discount_total, create_at)
VALUES (7, 25000, 12000, 13000, '2024-11-02');
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (3, 11, 2, 12000, 6000);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (3, 13, 1, 8000, 4000);

INSERT INTO compras (user_id, subtotal, total, discount_total, create_at)
VALUES (4, 60000, 24000, 36000, '2024-10-02');
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (4, 15, 4, 40000, 20000);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (4, 18, 2, 26000, 16000);

INSERT INTO compras (user_id, subtotal, total, discount_total, create_at)
VALUES (5, 15000, 7000, 8000, '2024-10-28');
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (5, 12, 1, 7000, 3000);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount)
VALUES (5, 16, 1, 11000, 5000);
