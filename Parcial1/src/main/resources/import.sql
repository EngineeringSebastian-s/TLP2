INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES ('John', 'Doe', 'john.doe@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Jane', 'Smith', 'jane.smith@example.com', 'Password123!', 'Administrador','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Alice', 'Johnson', 'alice.johnson@example.com', 'Password123!', 'Cliente','2023-12-28');
INSERT INTO usuarios (name, lastname, email, password, role, create_at) VALUES('Bob', 'Brown', 'bob.brown@example.com', 'Password123!', 'Cliente','2023-12-28');

INSERT INTO productos (name, description, unit_value) VALUES('Producto 1', 'Descripción del producto 1', 1000);
INSERT INTO productos (name, description, unit_value) VALUES('Producto 2', 'Descripción del producto 2', 2000);
INSERT INTO productos (name, description, unit_value) VALUES('Producto 3', 'Descripción del producto 3', 3000);
INSERT INTO productos (name, description, unit_value) VALUES('Producto 4', 'Descripción del producto 4', 4000);
INSERT INTO productos (name, description, unit_value) VALUES('Producto 5', 'Descripción del producto 5', 5000);
INSERT INTO inventario (product_id, status) VALUES (1, 'Disponible');
INSERT INTO inventario (product_id, status) VALUES(2, 'Agotado');
INSERT INTO inventario (product_id, status) VALUES(3, 'Disponible');
INSERT INTO inventario (product_id, status) VALUES(4, 'Disponible');
INSERT INTO inventario (product_id, status) VALUES(5, 'Disponible');
INSERT INTO compras (user_id, subtotal, total, discount_total) VALUES (1, 2000, 2000, 0);
INSERT INTO detalles (purchase_id, inventory_id, amount, price, discount) VALUES (1, 1, 2, 2000, 0);  -- 2 unidades del Producto 1
INSERT INTO detalles (purchase_id, inventory_id, amount, price, discount) VALUES (1, 3, 1, 3000, 0);  -- 1 unidad del Producto 3
