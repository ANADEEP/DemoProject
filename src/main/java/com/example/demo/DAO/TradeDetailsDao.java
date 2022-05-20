package com.example.demo.DAO;

import com.example.demo.DTO.TradeDetail;

import java.util.List;

public interface TradeDetailsDao {
    List<TradeDetail> getTradeById(Integer tradeId);

    //This could be call to DB/External Rest end point to fetch trade or to some messaging queue to read trade feed
    List<TradeDetail> getAllTrades();
}
