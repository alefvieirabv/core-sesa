package com.example.core_sesa.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;

public enum TipoContato {

    TELEFONE, EMAIL, CELULAR;

    private static Map<String, TipoContato> situacoes = HashMap.of("telefone", TELEFONE, "email", EMAIL, "celular", CELULAR);

    @JsonCreator
    public static TipoContato paraValor(String valor) {
        return situacoes.get(valor.toLowerCase()).getOrElseThrow(() -> new IllegalArgumentException("O valor [%s] não corresponde a uma operação válida. Os valores aceitos são: RTELEFONE, EMAIL, CELULAR.".concat(valor)));
    }
}
