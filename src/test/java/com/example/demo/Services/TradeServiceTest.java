package com.example.demo.Services;

import com.example.demo.DAO.TradeDetailsDao;
import com.example.demo.DTO.TradeDetail;
import com.example.demo.DTO.TransactionStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {

    @Mock
    TradeDetailsDao tradeDetailDaoMock;

    @InjectMocks
    TradeServiceImpl tradeService;

    @Test
    public void shouldReturnTrades() {
        // given
        when (tradeDetailDaoMock.getAllTrades()).thenReturn(new ArrayList<TradeDetail>());

        // when
        List<TradeDetail> trades = tradeService.getAllTrades();

        // then
        assertThat(trades, isNotNull());
    }


    @Test
    public void shouldReturnNullTrades() {
        // given
        when (tradeDetailDaoMock.getAllTrades()).thenReturn(null);

        // when
        List<TradeDetail> trades = tradeService.getAllTrades();

        // then
        assertThat(trades, isNull());
    }

    @Test
    public void shouldGenerateTradePosition() {
        //given
        when (tradeDetailDaoMock.getAllTrades()).thenReturn(getupMockTrades());

        //when
        Map<String, Integer> tradePosition = tradeService.getTradePosition();

        //then
        assertEquals(tradePosition, isNotNull());
        assertEquals(tradePosition.size(), 1);
        assertEquals(tradePosition.get("IFY"), Integer.valueOf(10));
    }

    private List<TradeDetail> getupMockTrades() {
        List<TradeDetail> tradeDetails = new ArrayList<TradeDetail>();

        //I could have created Builder class to generate Trade Object but time constraint so creating manually
        TradeDetail td1 = new TradeDetail(1, 1, 1, "IFY", 20, TransactionStatus.INSERT, "BUY");
        TradeDetail td2 = new TradeDetail(2, 1, 2, "IFY", 10, TransactionStatus.UPDATE, "SELL");
        tradeDetails.add(td1);
        tradeDetails.add(td2);
        return tradeDetails;
    }

}
