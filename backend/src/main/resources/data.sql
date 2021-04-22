
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

INSERT INTO tb_estado (nome) VALUES ('Rio de Janeiro');
INSERT INTO tb_estado (nome) VALUES ('São Paulo');

INSERT INTO tb_cidade (nome, estado_id) VALUES ('Rio das Ostras', 1);
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Macaé', 1);

INSERT INTO tb_cliente (nome, email, cpf_Ou_Cnpj, tipo) VALUES ('Arnald Queiroga', 'arnald@email', '885.383.292-43', 1);

INSERT INTO tb_endereco (bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) VALUES ('Marielia', '123456', 'Casa', 'Chacara', '18', 1, 1);

INSERT INTO tb_telefone (cliente_id, telefones) VALUES (1, '89898989');







