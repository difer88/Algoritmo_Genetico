package main.java.com.transportanalysis.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    protected long id;
    protected double amount;
    protected String name;
    protected double value;

    public Product(long id, double amount, String name, double value) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.value = value;
    }

    @JsonProperty("transaction_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("transaction_id")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("transaction_id")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("transaction_id")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
