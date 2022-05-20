package com.example.demo.Services;

import com.example.demo.DTO.TradeDetail;

import java.util.List;
import java.util.Map;

public interface TradeService {

    public List<TradeDetail> getTradeById(Integer tradeId);

    public List<TradeDetail> getAllTrades();

    public Map<String, Integer> getTradePosition();
}
