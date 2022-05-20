package com.example.demo.Services;

import com.example.demo.DAO.TradeDetailsDao;
import com.example.demo.DTO.TradeDetail;
import com.example.demo.DTO.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeDetailsDao tradeDetailDao;

    @Override
    public List<TradeDetail> getTradeById(Integer tradeId) {
        return null;
    }

    @Override
    public List<TradeDetail> getAllTrades() {
        return tradeDetailDao.getAllTrades();
    }

    @Override
    public Map<String, Integer> getTradePosition() {
        List<TradeDetail> tradeDetails = getAllTrades();

        Map<String, List<TradeDetail>> tradesGrpBySecurityCode =
                tradeDetails.stream().collect(Collectors.groupingBy(TradeDetail::getSecurityCode));

        Map<String, Integer> tradePositions = new HashMap<>();
        tradesGrpBySecurityCode.keySet().forEach(key -> {
            tradesGrpBySecurityCode.get(key).stream().forEach(tradeDetail -> {

              if (TransactionStatus.CANCEL.equals(tradeDetail.getTransactionStatus())) {
                    tradeDetail.setFinalTradeCount(0);
                    tradeDetail.setCancelTrade(true);
              } else {
                  tradeDetail.getFinalTradeUnit();
              }
              tradePositions.put(key, tradeDetail.getFinalTradeCount());
            });
        });
        return tradePositions;
    }

}
