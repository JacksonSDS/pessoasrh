create table pessoas(

    id bigserial not null,
    nome varchar(75) not null,
    cpf varchar(11) not null unique,
    formacaoAcademica varchar(75) not null,
    telefone varchar(11) not null,
    email varchar(100) not null,
    experiencia varchar(35) not null,
    estado varchar(25) not null,
    cidade varchar(40) not null,
    cep varchar(9) not null,
    numero varchar(5) not null,
    logradouro varchar(50) not null,
    
    primary key(id)
);
