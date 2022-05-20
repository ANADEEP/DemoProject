package com.example.demo.DAO;

import com.example.demo.DTO.TradeDetail;
import com.example.demo.DTO.TransactionStatus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class TradeDetailsDaoImpl implements TradeDetailsDao {

    private Logger LOGGER = Logger.getLogger(String.valueOf(TradeDetailsDaoImpl.class));

    @Override
    public List<TradeDetail> getTradeById(Integer tradeId) {
        return null;
    }

    @Override
    public List<TradeDetail> getAllTrades() {
        List<TradeDetail> tradeDetails = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/TradeData.txt"));

            String tradeDataReceived = null;
            String[] fetchedRecords;

            int startCounter = 0;
            while (true) {
                tradeDataReceived = bufferedReader.readLine();

                //Skipping the header in input file
                if (startCounter == 0) {
                    startCounter++;
                    continue;
                }

                //If last row reached or no record in file then break the loop
                if (tradeDataReceived == null) {
                    break;
                } else {
                    fetchedRecords = tradeDataReceived.split("\t", 7);
                    TradeDetail tradeDetail = new TradeDetail();
                    tradeDetail.setTransactionId(Integer.parseInt(fetchedRecords[0]));
                    tradeDetail.setTradeId(Integer.parseInt(fetchedRecords[1]));
                    tradeDetail.setVersion(Integer.parseInt(fetchedRecords[2]));
                    tradeDetail.setSecurityCode(fetchedRecords[3]);
                    tradeDetail.setQuantity(Integer.parseInt(fetchedRecords[4]));
                    tradeDetail.setTransactionStatus(TransactionStatus.valueOf(fetchedRecords[5]));
                    tradeDetail.setTransactionType(fetchedRecords[6]);

                    tradeDetails.add(tradeDetail);
                }
            }
            bufferedReader.close();
        } catch(Exception e) {
            LOGGER.info("Exception while fetching/processing Trade Data");
        }

        return tradeDetails;
    }
}
