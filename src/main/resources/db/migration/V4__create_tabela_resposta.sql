CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuario_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_respostas_usuario FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id),  -- corrigido para "usuarios"

    CONSTRAINT fk_respostas_topico FOREIGN KEY (topico_id)
        REFERENCES topicos(id)
);
