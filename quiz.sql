drop database quiz;

create database quiz;

use quiz;

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'O que é um monolítico em relação a uma arquitetura de software?',  
	'a) Um componente que representa uma funcionalidade específica.',
	'b) Uma arquitetura em que todos os componentes são independentes e autônomos.',
	'c) Um sistema em que todos os componentes são agrupados em um único artefato.',
    'd) Uma arquitetura em que os componentes são divididos em diferentes serviços.',
	'c'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'O que é um ORM (Object-Relational Mapping)?',  
	'a) Uma técnica para criar consultas SQL otimizadas.',
	'b) Um padrão de projeto para mapear objetos para tabelas de banco de dados.',
	'c) Uma biblioteca para criar interfaces de usuário em aplicativos web.',
    'd) Um método para armazenar objetos em cache na memória.',
	'b'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é a função principal de um ORM em uma aplicação Spring Boot?',  
	'a) Gerenciar a segurança da aplicação.',
	'b) Facilitar a comunicação entre diferentes serviços.',
	'c) Mapear objetos Java para tabelas de banco de dados.',
    'd) Controlar o fluxo de dados entre o cliente e o servidor.',
	'c'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é o ORM padrão utilizado pelo Spring Boot?',  
	'a) Hibernate',
	'b) MyBatis',
	'c) JDBC',
    'd) JPA',
	'a'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é a principal vantagem de usar um ORM em uma aplicação Spring Boot?',  
	'a) Melhorar a segurança da aplicação.',
	'b) Simplificar o processo de persistência de dados.',
	'c) Aumentar o desempenho da aplicação.',
    'd) Facilitar a integração com outros sistemas.',
	'b'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é a anotação usada para mapear uma classe de entidade no Hibernate?',  
	'a) @Entity',
	'b) @Table',
	'c) @EntityClass',
    'd) @EntityMapping',
	'a'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'O que é uma transação em um contexto de ORM?',  
	'a) Uma operação para atualizar o esquema do banco de dados.',
	'b) Um mecanismo para registrar alterações nos objetos mapeados.',
	'c) Uma unidade lógica de trabalho que envolve operações de leitura e gravação no banco de dados.',
    'd) Um processo para otimizar consultas de banco de dados.',
	'c'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é a finalidade da anotação @Column em uma classe de entidade?',  
	'a) Definir a chave primária da tabela no banco de dados.',
	'b) Especificar o nome da coluna na tabela correspondente.',
	'c) Mapear a classe de entidade para uma tabela no banco de dados.',
    'd) Configurar a relação de herança entre classes de entidade.',
	'b'
);

insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Quais são os principais tipos de relacionamentos suportados pelo ORM Hibernate',  
	'a) Um-para-um, Um-para-muitos e Muitos-para-um.',
	'b) Um-para-um, Um-para-muitos e Muitos-para-muitos.',
	'c) Muitos-para-um, Muitos-para-muitos e Herança.',
    'd) Herança, Composição e Agregação.',
	'b'
);


insert into question_orm(question, option_a, option_b, option_c, option_d, response) 
values(	 
	'Qual é a finalidade da anotação @JoinColumn em uma classe de entidade no Spring Boot?',  
	'a) Definir o nome da tabela no banco de dados.',
	'b) Especificar o tipo de dado de uma coluna na tabela.',
	'c) Configurar a geração automática de valores para uma coluna de chave primária.',
    'd) Mapear uma coluna de chave estrangeira em uma relação entre entidades.',
	'd'
);

select * from user_table;
select * from document_table;
select * from address_table;
select * from user_address;

select * from question_orm;

select * from user_responses_orm;
select * from user_result_orm;




