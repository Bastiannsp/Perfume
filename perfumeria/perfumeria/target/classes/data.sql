INSERT INTO marca (id, nombre) VALUES (1,'Dior'), (2,'Chanel');
INSERT INTO categoria (id, nombre) VALUES (1,'Amaderada'), (2,'Cítrica');

INSERT INTO perfume (id, nombre, precio, stock, marca_id, categoria_id) VALUES
 (1,'Sauvage EDT', 79990, 20, 1, 1),
 (2,'Bleu de Chanel EDP', 99990, 15, 2, 1),
 (3,'Dior Homme Cologne', 69990, 10, 1, 2);
