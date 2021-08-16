package com.example.core_sesa.Entity;

import com.example.core_sesa.Enum.TipoContato;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Contato implements Serializable {

    @JsonProperty("valor")
    @Column(name = "valor", nullable = false)
    private String valor;

    @JsonProperty("tipoContato")
    @Column(name = "tipo_contato", nullable = false)
    private TipoContato tipoContato;
}
