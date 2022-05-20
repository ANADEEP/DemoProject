package com.example.demo.DTO;


import com.example.demo.utils.TradeConstants;

import java.util.Objects;

public class TradeDetail
{
    private Integer transactionId;
    private Integer tradeId;
    private Integer version;
    private String securityCode;
    private Integer quantity;
    private TransactionStatus transactionStatus;
    private String transactionType;
    private boolean hasCancelTrade;

    public TradeDetail() {
    }

    //TODO Not needed created for unit test case
    public TradeDetail(Integer transactionId, Integer tradeId, Integer version, String securityCode, Integer quantity, TransactionStatus transactionStatus, String transactionType) {
        this.transactionId = transactionId;
        this.tradeId = tradeId;
        this.version = version;
        this.securityCode = securityCode;
        this.quantity = quantity;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
    }

    public Integer getFinalTradeCount() {
        return finalTradeCount;
    }

    public void setFinalTradeCount(int finalTradeCount) {
        this.finalTradeCount = finalTradeCount;
    }

    private int finalTradeCount = 0;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {

        this.transactionStatus = transactionStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeDetail that = (TradeDetail) o;
        return transactionId.equals(that.transactionId) &&
                tradeId.equals(that.tradeId) &&
                version.equals(that.version) &&
                securityCode.equals(that.securityCode) &&
                transactionStatus == that.transactionStatus &&
                transactionType.equals(that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, tradeId, version, securityCode, transactionStatus, transactionType);
    }

    public int getFinalTradeUnit() {
        if (! isCancelTradeSecurity()) {
            if (TradeConstants.BUY_TRADE.equals(this.transactionStatus.toString().toUpperCase())) {
                finalTradeCount += this.quantity;
            } else if (TradeConstants.SELL_TRADE.equals(this.transactionStatus.toString().toUpperCase())) {
                finalTradeCount -= this.quantity;
            }
            return finalTradeCount;
        }
        return 0;
    }


    public void setCancelTrade(boolean value) {
        this.hasCancelTrade =  value;
    }

    public boolean isCancelTradeSecurity() {
        return this.hasCancelTrade;
    }
}
