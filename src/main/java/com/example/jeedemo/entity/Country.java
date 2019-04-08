package com.example.jeedemo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country")
public class Country extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 2455720402236448613L;

    @NotNull
    private String name;

    @NotNull
    @Size(max = 3,min = 3)
    @Column(name = "three_char_code",unique = true)
    private String threeCharCode;

    @NotNull
    @Size(max = 2,min = 2)
    @Column(name = "two_char_code",unique = true)
    private String twoCharCode;

    @NotNull
    @Size(max = 10)
    @Column(name = "phone_code")
    private String phoneCode;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreeCharCode() {
        return threeCharCode;
    }

    public void setThreeCharCode(String threeCharCode) {
        this.threeCharCode = threeCharCode;
    }

    public String getTwoCharCode() {
        return twoCharCode;
    }

    public void setTwoCharCode(String twoCharCode) {
        this.twoCharCode = twoCharCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
