package com.example.demo.DAO;

import com.example.demo.DTO.TradeDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TradeDetailsDaoTest {

    @InjectMocks
    TradeDetailsDaoImpl tradeDetailsDao;

    @Test
    public void shouldGetTradeDetailsWhenGetAllTradeCall() {
        //given

        //when
        List<TradeDetail> tradeDetails = tradeDetailsDao.getAllTrades();

        //then
        //assertThat(tradeDetails, isNotNull());
        assertThat(tradeDetails, isNotNull());
        assertEquals(tradeDetails.size(), 6);
    }
}