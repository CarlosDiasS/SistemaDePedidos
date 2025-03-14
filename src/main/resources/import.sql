
insert into estado values('060e382fd037850f50766555de8dd81a', 'RJ');
insert into estado values('a3dfe6149563c1ae4497dd7d47bb8e4b', 'BA');
insert into estado values('cea6867804f1e2fbbc4ddbcd8ec16d60', 'MT');
insert into estado values('f4d493d339188fd5dbb3f04f57384f20', 'ES');
insert into estado values('222ff00c87906dbbfd6c3801597849a4', 'AC');
insert into estado values('dd7672da475bd984647f31b08e12435e', 'MG');

insert into cidade values('88eed0934043da4f0f2973f323f3c8d3','060e382fd037850f50766555de8dd81a','Petropolis');
insert into cidade values('2a3ede760789722b8c6a9a9cfacc57c9','a3dfe6149563c1ae4497dd7d47bb8e4b','Fortaleza');
insert into cidade values('20d93de9c8b6272f40f57f39cfc3ccc1','dd7672da475bd984647f31b08e12435e', 'Ouro Preto');

INSERT INTO cozinha (id, nome, categoria) VALUES ('5d41402abc4b2a76b9719d911017c592', 'Japonesa', 'BOM');
INSERT INTO cozinha (id, nome, categoria) VALUES ('7d793037a0760186574b0282f2f435e7', 'Mexicana', 'BOM');
INSERT INTO cozinha (id, nome, categoria) VALUES ('9e107d9d372bb6826bd81d3542a419d6', 'Brasileira', 'MUITO_BOM');
INSERT INTO cozinha (id, nome, categoria) VALUES ('e4d909c290d0fb1ca068ffaddf22cbd0', 'Francesa', 'MEDIANO');

INSERT INTO forma_pagamento (id, descricao) VALUES ('9b3e65604a56aad7f418fc761c820d35','debito');
INSERT INTO forma_pagamento (id, descricao) VALUES ('4d65d1ae642800fb0cfad39771abd2fc','credito');

INSERT INTO restaurante (id, nome, taxa_frete, data_cadastro, data_update, cozinha_id, forma_pagamento_id) VALUES ('c56a4180-65aa-42ec-a945-5fd21dec0538', 'Restaurante Guanamar', 5.99, NOW(), NOW(), 'e4d909c290d0fb1ca068ffaddf22cbd0', '9b3e65604a56aad7f418fc761c820d35');
INSERT INTO restaurante (id, nome, taxa_frete, data_cadastro, data_update, cozinha_id, forma_pagamento_id) VALUES ('545e54176dc3c2a1b90af61916468e47', 'Restaurante Mexicano', 5.99, NOW(), NOW(), '7d793037a0760186574b0282f2f435e7', '9b3e65604a56aad7f418fc761c820d35');

INSERT INTO produtos(id, ativo, preco, restaurante, nome) VALUES ('c57cf501d6c95302f08ab3b7a9726dbd',true,29.99,'545e54176dc3c2a1b90af61916468e47','taco');