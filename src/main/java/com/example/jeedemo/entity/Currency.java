package com.example.jeedemo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "currency")
public class Currency extends GenericEntity implements Serializable{

    private static final long serialVersionUID = 3736847363204090299L;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String name;

    @NotNull
    private String symbol;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
