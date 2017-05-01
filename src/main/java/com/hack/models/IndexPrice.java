package com.hack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Represents an IndexPrice for this web application.
 */
@Entity
@Table(name = "IndexPrice")
public class IndexPrice {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String iCode;

    @NotNull
    private String iName;

    private Double price;

    private Timestamp priceTime;

    private String currency;

    private String exchange;

    private String iGroup;

    private String source;

    private Boolean isLatest;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public IndexPrice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getiCode() {
        return iCode;
    }

    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(Timestamp priceTime) {
        this.priceTime = priceTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getiGroup() {
        return iGroup;
    }

    public void setiGroup(String iGroup) {
        this.iGroup = iGroup;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getLatest() {
        return isLatest;
    }

    public void setLatest(Boolean latest) {
        isLatest = latest;
    }
} // class IndexPrice
