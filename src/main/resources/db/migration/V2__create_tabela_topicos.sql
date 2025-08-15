CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_topicos_usuario FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
);