INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Joao', 'Silva', 'joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Silveira', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);






INSERT INTO tb_categoria (nome) VALUES ('Decoração');
INSERT INTO tb_categoria (nome)  VALUES ('Acessórios');
INSERT INTO tb_categoria (nome)  VALUES ('Painéis Decorativos');

INSERT INTO tb_produto (nome, preco, date, descricao, img_url) VALUES ('Espelho', 90.5, TIMESTAMP WITH TIME ZONE '2021-04-21T20:50:07.12345Z', 'Espelho tipo Mandala, cores diversas', 'https://www.instagram.com/p/CK_cyDRrNPM/');
INSERT INTO tb_produto (nome, preco, date, descricao, img_url) VALUES ('Painel Amor', 100.0, TIMESTAMP WITH TIME ZONE '2021-04-21T20:50:07.12345Z', 'Painel feito no galho natural com barbante de algodão na cor bordô', 'https://www.instagram.com/p/CGir8qlsJKI/');
INSERT INTO tb_produto (nome, preco, date, descricao, img_url) VALUES ('Triangulo Energético', 145.0, TIMESTAMP WITH TIME ZONE '2021-04-21T20:50:07.12345Z', 'Triangulo Geométrico', 'https://www.instagram.com/p/CIQOS2Jspac/');
INSERT INTO tb_produto (nome, preco, date, descricao, img_url) VALUES ('Suporte de plantas', 50.00, TIMESTAMP WITH TIME ZONE '2021-04-21T20:50:07.12345Z', 'Suporte na cor bordô', 'https://www.instagram.com/p/CKjNzzjr5Um/');
INSERT INTO tb_produto (nome, preco, date, descricao, img_url) VALUES ('Luminaria', 50.00, TIMESTAMP WITH TIME ZONE '2021-04-21T20:50:07.12345Z', 'Luminária pendente em Macramê', 'https://www.instagram.com/p/CG5ueeqsugV/');

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2, 2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3, 2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5, 2);

INSERT INTO tb_cliente (nome, endereco, telefone, email, cpf) VALUES ('Arnald Queiroga', 'Rua das Flores, N49, Rio das Ostras', '9934567890', 'arnald@email', '885.383.292-43');



INSERT INTO tb_pedido (date, cliente_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-04-22T20:50:07.12345Z', 1);
INSERT INTO tb_pagamento (pedido_id, estado) VALUES (1, 2);
INSERT INTO tb_pagamento_dinheiro (data_Pagamento, pedido_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-04-22T21:50:07.12345Z', 1);


INSERT INTO tb_item_pedido (preco, quantidade, produto_id, pedido_id) VALUES (90.5, 1, 1, 1);







