create database condado2;
use condado2;

create table cliente(
	id_cliente varchar(25) PRIMARY KEY, 
    nome_cliente varchar(255),
    data_nascimento_cliente date,
    email_cliente varchar(255),
    contato_cliente varchar(20)
);

-- Tabela pedido
CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT, 
    id_cliente VARCHAR(25),
    data_pedido DATE,
    forma_pagamento VARCHAR(20),
    preco_pedido DECIMAL(10, 2), -- Alterado para DECIMAL para precisão
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Tabela livro
CREATE TABLE livro (
    isbn VARCHAR(36) PRIMARY KEY,
    autor VARCHAR(255),
    genero VARCHAR(255),
    titulo VARCHAR(255),
    qtd_estoque INT,
    preco_livro DECIMAL(10, 2), -- Alterado para DECIMAL para precisão
    sinopse VARCHAR(700),
    editora VARCHAR(255),
    foto LONGBLOB
);


-- Tabela pedido_livro ajustada
CREATE TABLE pedido_livro (
    isbn VARCHAR(36),
    id_pedido INT auto_increment,
    qtd_pedido INT,
    PRIMARY KEY (isbn, id_pedido),
    FOREIGN KEY (isbn) REFERENCES livro(isbn) ON DELETE CASCADE,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE
);

 -- drop database condado2;
/*INSERINDO DADOS*/

INSERT INTO cliente (id_cliente, nome_cliente, data_nascimento_cliente, email_cliente, contato_cliente)
VALUES
('284.053.619-78', 'Bilbo Bolseiro', '1950-01-01', 'hobbit_precioso@gmail.com', '555-3579-1268'),
('730.615.982-84', 'Naruto Uzumaki', '1987-10-10', 'futurohokage@hotmail.com', '555-1234-5678'),
('651.320.182-85', 'Saul Goodman', '1960-11-12', 'melhoradvogadoconfia@gmail.com', '555-9876-5430'),
('805.694.213-72', 'Saint Seiya', '1973-03-15', 'SaintSeiya@gmail.com', '555-2468-1357'),
('149.532.860-27', 'Manuel Gomes', '1965-04-25', 'ManuelGomescanetaazuloficial@gmail.com', '555-8642-0975'),
('860.194.237-52', 'Paola Oliveira', '1982-05-18', 'PaolaOliveira@icloud.com', '555-3197-8024'),
('372.841.560-96', 'Daenerys Targaryen', '1988-06-16', 'mae_de_dragoes@hotmail.com', '555-4002-8922'),
('651.320.784-97', 'Ednaldo Pereira', '1970-08-20', 'EdnaldoPereirarealoficial@hotmail.com', '555-6051-3847'),
('70.513.249/8620-47', 'Hermione Granger', '1990-09-19', 'HermioneGranger@gmail.com', '555-4381-9562'),
('36.951.842/0765-93', 'Marciano Lourenço', '1995-11-15', 'MarcianoLourenco@ifce.edu.br', '555-6702-3418'),
('81.406.275/3249-18', 'Bruce Wayne', '1975-02-19', 'naosouobatman@icloud.com', '555-7382-6901'),
('53.029.864/1724-76', 'Walter White', '1958-09-07', 'ProffWalterWhite@gmail.com', '555-4763-9285'),
('24.967.035/1827-84', 'Barry Allen', '1992-03-23', 'naosouoflashconfia@gmail.com', '555-8109-2736'),
('18.503.749/2630-21', 'Geralt de Rívia', '1980-12-25', 'Bruxaomatador123@hotmail.com', '555-9876-5432'),
('96.041.325/7384-12', 'Bill Gates', '1955-10-28', 'billg@microsoft.com', '555-9218-5074');

INSERT INTO pedido (id_cliente, data_pedido, forma_pagamento, preco_pedido)
VALUES
    ('284.053.619-78', '2022-03-01', 'Crédito', 45.99),
    ('284.053.619-78', '2022-03-02', 'Débito', 124.80),
    ('284.053.619-78', '2022-03-03', 'Boleto', 704.50),
    ('730.615.982-84', '2022-03-04', 'Pix', 32.90),
    ('730.615.982-84', '2022-03-05', 'Débito', 120.17),
    ('730.615.982-84', '2022-03-06', 'Crédito', 114.90),
    ('651.320.182-85', '2022-03-07', 'Pix', 82.02),
    ('651.320.182-85', '2022-03-08', 'Boleto', 107.70),
    ('651.320.182-85', '2022-01-03', 'Crédito', 46.12),
    ('805.694.213-72', '2022-04-08', 'Débito', 159.90),
    ('805.694.213-72', '2022-07-13', 'Boleto', 92.80),
    ('149.532.860-27', '2022-10-18', 'Pix', 459.90),
    ('149.532.860-27', '2023-02-02', 'Crédito', 102.54),
    ('860.194.237-52', '2023-04-09', 'Boleto', 55.71),
    ('860.194.237-52', '2023-07-14', 'Pix', 164.70),
    ('372.841.560-96', '2023-10-19', 'Débito', 119.80),
    ('372.841.560-96', '2022-02-05', 'Pix', 59.90),
    ('651.320.784-97', '2022-05-10', 'Crédito', 134.80),
    ('651.320.784-97', '2022-08-15', 'Boleto', 152.47),
    ('70.513.249/8620-47', '2022-11-20', 'Débito', 45.99),
    ('36.951.842/0765-93', '2023-05-07', 'Crédito', 194.70),
    ('81.406.275/3249-18', '2023-06-11', 'Pix', 117.07),
    ('53.029.864/1724-76', '2023-09-16', 'Boleto', 279.60),
    ('24.967.035/1827-84', '2023-12-21', 'Débito', 190.76),
    ('18.503.749/2630-21', '2022-02-07', 'Crédito', 128.92),
    ('96.041.325/7384-12', '2022-05-12', 'Boleto', 399.90);


INSERT INTO livro (isbn, autor, genero, titulo, qtd_estoque, preco_livro, sinopse, editora)
VALUES
('9788532523051', 'J.K. Rowling', 'Fantasia', 'Harry Potter e a Pedra Filosofal', 2, 45.99, 'Harry Potter, órfão maltratado, descobre aos 11 anos seu destino mágico. Herói marcado por sobreviver a um ataque bruxo, ele enfrentará o assassino dos pais. Magricela e desengonçado, torna-se líder e símbolo de poder entre os feiticeiros.', 'Rocco'),
('9788532505705', 'J.K. Rowling', 'Fantasia', 'Harry Potter BOX', 2, 399.90, 'Harry Potter, jovem bruxo, luta contra as trevas de Lord Voldemort, descobrindo amizades e segredos na Escola de Magia de Hogwarts, em uma saga épica de magia e coragem.', 'Rocco'),
('9788551008881', 'Rick Riordan', 'Aventura', 'Box Percy Jackson e os olimpianos', 5, 299.50, 'Percy Jackson, semideus, embarca em missões perigosas para evitar conflitos entre deuses, enfrentando criaturas míticas, descobrindo seu destino e desvendando mistérios no mundo dos semideuses.', 'Intrínseca'),
('9788580575392', 'Rick Riordan', 'Aventura', 'O Ladrão de Raios - Percy Jackson e os Olimpianos 1', 3, 34.90, 'Percy Jackson, filho de Poseidon, é acusado de roubo no Olimpo. Com seus amigos, ele enfrenta deuses e monstros para desvendar uma traição ameaçadora. A saga combina mitologia grega, aventura contemporânea e desafios para jovens heróis.', 'Intrínseca'),
('9788594541833', 'Katherine Ramsland', 'True crime', 'BTK Profile: Máscara da Maldade', 20, 79.90, 'Explora os crimes brutais do assassino em série BTK, mergulhando nas mentes obscuras e nas investigações angustiantes que revelam seu lado aterrador.', 'DarkSide Books'),
('9788594541475', 'Tori Telfer', 'True crime', 'Lady Killers: Assassinas em Série', 10, 79.90, 'Revela histórias chocantes de mulheres criminosas, desafiando estereótipos e explorando os motivos obscuros por trás de seus atos mortais.', 'DarkSide Books'),
('9788584391400', 'Taylor Jenkins Reid', 'Romance', 'Daisy Jones and The Six', 18, 24.99, 'O livro narra a história fictícia de uma banda de rock dos anos 1970 chamada Daisy Jones & The Six. A narrativa é construída por meio de entrevistas com os membros da banda, revelando os altos e baixos de suas carreiras, relacionamentos e os eventos que levaram à sua separação.', 'Companhia das Letras'),
('9788584391509', 'Taylor Jenkins Reid', 'Romance', 'Os Sete Maridos de Evelyn Hugo', 20, 59.90, 'Evelyn Hugo, estrela de cinema, revela seus sete casamentos e segredos na glamorosa Hollywood, oferecendo uma narrativa cativante e reveladora.', 'Companhia das Letras'),
('9788560280940', 'Stephen King', 'Terror', 'It: A Coisa', 20, 114.90, 'Uma presença maligna assombra a cidade de Derry, ressurgindo a cada 27 anos. Um grupo de amigos enfrenta seus maiores medos para combatê-la.', 'Suma'),
('9788556511348', 'Stephen King', 'Terror', 'Carrie, a Estranha', 20, 69.90, 'Stephen King revela o sobrenatural na vida de uma adolescente com poderes telecinéticos, desencadeando eventos trágicos em sua jornada pelo ensino médio.', 'Suma'),
('9786555112511', 'J.R.R. Tolkien', 'Fantasia', 'O Senhor dos Anéis: edição única', 5, 299.90, 'A saga "Senhor dos Anéis" narra a busca para destruir um anel do poder e derrotar o mal que ameaça a Terra-média, explorando amizade, coragem e o embate entre o bem e o mal.', 'HarperCollins Brasil'),
('9788595084742', 'J.R.R. Tolkien', 'Fantasia', 'O Hobbit', 20, 69.90, 'Bilbo Bolseiro embarca em uma inesperada jornada com treze anões para recuperar um tesouro guardado por Smaug, o dragão. Aventura, magia e coragem definem sua saga.', 'HarperCollins Brasil'),
('9786586799156', 'Jane Austen', 'Romance', 'Emma', 7, 70.19, 'A história gira em torno da protagonista, Emma Woodhouse, uma jovem rica que gosta de fazer combinações amorosas entre seus conhecidos. No entanto, suas tentativas muitas vezes resultam em situações cômicas e complexas.', 'Martin Claret'),
('9788544001820', 'Jane Austen', 'Romance', 'Orgulho e Preconceito', 20, 55.71, 'Elizabeth Bennet enfrenta um turbilhão de sentimentos diante do orgulho e preconceito que mascaram a realidade.', 'Martin Claret'),
('9788535933925', 'Yuval Noah Harari', 'História', 'Sapiens: Uma Breve Historia da Humanidade', 15, 64.46, 'Obra de Yuval Noah Harari explora a evolução humana, destacando marcos como a Revolução Cognitiva, Agrícola e Científica que moldaram nossa sociedade.', 'L&PM Editores'),
('9786584956193', 'Maquiavel', 'Filosofia', 'O Príncipe', 18, 61.03, 'O Príncipe de Maquiavel revela estratégias e reflexões sobre poder e governança na política, uma obra atemporal da filosofia política.', 'Martin Claret');


INSERT INTO pedido_livro (isbn, qtd_pedido)
VALUES
('9788532523051', 2),
('9788532505705', 2),
('9788551008881', 5),
('9788580575392', 3),
('9788594541833', 7),
('9788594541475', 7),
('9788584391400', 7),
('9788584391509', 2),
('9788560280940', 7),
('9788556511348', 1),
('9786555112511', 5),
('9788595084742', 1),
('9786586799156', 1),
('9788544001820', 3),
('9788535933925', 2),
('9786584956193', 1);
