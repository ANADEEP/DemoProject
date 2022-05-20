package com.example.demo.Controller;

import com.example.demo.DTO.TradeDetail;
import com.example.demo.Services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tradeDetail")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @GetMapping(value = "/getAll", produces = "application/json")
    public @ResponseBody List<TradeDetail> getAllTrade() {
        return tradeService.getAllTrades();
    }

    @GetMapping(value = "/getTradePosition", produces = "application/json")
    public @ResponseBody Map<String, Integer> getTradeConsolidation() {
        return tradeService.getTradePosition();
    }
}
