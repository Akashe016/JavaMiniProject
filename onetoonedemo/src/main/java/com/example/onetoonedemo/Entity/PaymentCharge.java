package com.example.onetoonedemo.Entity;

public class PaymentCharge {

	
	private Long id;
    private String token;
    private int amount;

    public PaymentCharge() {
    }

    public PaymentCharge(String token, int amount) {
        this.token = token;
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
