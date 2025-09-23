-- Limpiar por si ya corriste antes (H2 acepta DELETE sin WHERE en memoria)
DELETE FROM detalle_pedido;
DELETE FROM pedido;
DELETE FROM cliente;
DELETE FROM perfume;
DELETE FROM marca;
DELETE FROM categoria;

-- Catálogo
INSERT INTO marca (id, nombre) VALUES (1,'Dior'), (2,'Chanel');
INSERT INTO categoria (id, nombre) VALUES (1,'Amaderada'), (2,'Cítrica');

INSERT INTO perfume (id, nombre, precio, stock, marca_id, categoria_id) VALUES
 (1,'Sauvage EDT', 79990, 20, 1, 1),
 (2,'Bleu de Chanel EDP', 99990, 15, 2, 1),
 (3,'Dior Homme Cologne', 69990, 10, 1, 2);

-- Clientes
INSERT INTO cliente (id, nombre, email) VALUES
 (1,'Juan Pérez','juan@example.com'),
 (2,'María López','maria@example.com');

-- Pedidos
INSERT INTO pedido (id, cliente_id, fecha) VALUES
 (1, 1, CURRENT_TIMESTAMP()),
 (2, 2, DATEADD('DAY', -1, CURRENT_TIMESTAMP()));

-- Detalles (precioUnit copiado del perfume al momento de la venta)
INSERT INTO detalle_pedido (id, pedido_id, perfume_id, cantidad, precio_unit) VALUES
 (1, 1, 1, 2, 79990),   -- Juan compra 2 Sauvage
 (2, 1, 3, 1, 69990),   -- Juan compra 1 Dior Homme Cologne
 (3, 2, 2, 1, 99990);   -- María compra 1 Bleu de Chanel

