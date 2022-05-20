package com.example.demo.DTO;

import java.util.Objects;

public class TradePosition {

    public TradePosition(String securityCode, int quantity) {
        this.securityCode = securityCode;
        this.quantity = quantity;
    }

    private String securityCode;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradePosition that = (TradePosition) o;
        return quantity == that.quantity &&
                Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityCode, quantity);
    }
}
