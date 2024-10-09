INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES ('John', 'Doe', 'john.doe@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Jane', 'Smith', 'jane.smith@example.com', 'Password123!', 'Administrador','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Alice', 'Johnson', 'alice.johnson@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Bob', 'Brown', 'bobi.brown@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES ('Alejo', 'Doe', 'alejon.doe@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Pedro', 'Smith', 'jper.smith@example.com', 'Password123!', 'Administrador','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Juan', 'Johnson', 'juance.johnson@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Charli', 'Brown', 'charh.brown@example.com', 'Password123!', 'Cliente','2023-12-28');

INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 1', 'Descripción del producto 1', 1000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 2', 'Descripción del producto 2', 2000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 3', 'Descripción del producto 3', 3000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 4', 'Descripción del producto 4', 4000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 5', 'Descripción del producto 5', 5000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 6', 'Descripción del producto 1', 1000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 7', 'Descripción del producto 2', 2000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 8', 'Descripción del producto 3', 3000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 9', 'Descripción del producto 4', 4000,20);
INSERT INTO productos (name, description, unit_value, stock) VALUES('Producto 10', 'Descripción del producto 5', 5000,20);
INSERT INTO compras (user_id, subtotal, total, discount_total) VALUES (1, 2000, 2000, 0);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount) VALUES (1, 1, 2, 2000, 2000);  -- 2 unidades del Producto 1
INSERT INTO detalles (purchase_id, product_id, amount, price, discount) VALUES (1, 3, 1, 3000, 1000);  -- 1 unidad del Producto 3
INSERT INTO compras (user_id, subtotal, total, discount_total) VALUES (2, 2000, 2000, 0);
INSERT INTO detalles (purchase_id, product_id, amount, price, discount) VALUES (2, 4, 6, 2000, 1000);  -- 2 unidades del Producto 1
INSERT INTO detalles (purchase_id, product_id, amount, price, discount) VALUES (2, 7, 8, 3000, 1000);  -- 1 unidad del Producto 3
