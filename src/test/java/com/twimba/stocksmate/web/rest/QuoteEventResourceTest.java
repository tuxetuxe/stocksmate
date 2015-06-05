package com.twimba.stocksmate.web.rest;

import com.twimba.stocksmate.Application;
import com.twimba.stocksmate.domain.QuoteEvent;
import com.twimba.stocksmate.repository.QuoteEventRepository;
import com.twimba.stocksmate.repository.search.QuoteEventSearchRepository;
import com.twimba.stocksmate.web.rest.mapper.QuoteEventMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasItem;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the QuoteEventResource REST controller.
 *
 * @see QuoteEventResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class QuoteEventResourceTest {


    private static final BigDecimal DEFAULT_ASK = new BigDecimal(0);
    private static final BigDecimal UPDATED_ASK = new BigDecimal(1);
    private static final String DEFAULT_AVERAGE_DAILY_VOLUME = "SAMPLE_TEXT";
    private static final String UPDATED_AVERAGE_DAILY_VOLUME = "UPDATED_TEXT";
    private static final String DEFAULT_BID = "SAMPLE_TEXT";
    private static final String UPDATED_BID = "UPDATED_TEXT";
    private static final String DEFAULT_ASK_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_ASK_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_BID_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_BID_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_BOOK_VALUE = "SAMPLE_TEXT";
    private static final String UPDATED_BOOK_VALUE = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_PERCENT_CHANGE = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_PERCENT_CHANGE = "UPDATED_TEXT";

    private static final BigDecimal DEFAULT_CHANGE = new BigDecimal(0);
    private static final BigDecimal UPDATED_CHANGE = new BigDecimal(1);
    private static final String DEFAULT_COMMISSION = "SAMPLE_TEXT";
    private static final String UPDATED_COMMISSION = "UPDATED_TEXT";
    private static final String DEFAULT_CURRENCY = "SAMPLE_TEXT";
    private static final String UPDATED_CURRENCY = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_AFTER_HOURS_CHANGE_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_AFTER_HOURS_CHANGE_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_DIVIDEND_SHARE = "SAMPLE_TEXT";
    private static final String UPDATED_DIVIDEND_SHARE = "UPDATED_TEXT";
    private static final String DEFAULT_LAST_TRADE_DATE = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_TRADE_DATE = "UPDATED_TEXT";
    private static final String DEFAULT_TRADE_DATE = "SAMPLE_TEXT";
    private static final String UPDATED_TRADE_DATE = "UPDATED_TEXT";
    private static final String DEFAULT_EARNINGS_SHARE = "SAMPLE_TEXT";
    private static final String UPDATED_EARNINGS_SHARE = "UPDATED_TEXT";
    private static final String DEFAULT_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID = "SAMPLE_TEXT";
    private static final String UPDATED_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID = "UPDATED_TEXT";
    private static final String DEFAULT_E_P_S_ESTIMATE_CURRENT_YEAR = "SAMPLE_TEXT";
    private static final String UPDATED_E_P_S_ESTIMATE_CURRENT_YEAR = "UPDATED_TEXT";
    private static final String DEFAULT_E_P_S_ESTIMATE_NEXT_YEAR = "SAMPLE_TEXT";
    private static final String UPDATED_E_P_S_ESTIMATE_NEXT_YEAR = "UPDATED_TEXT";
    private static final String DEFAULT_E_P_S_ESTIMATE_NEXT_QUARTER = "SAMPLE_TEXT";
    private static final String UPDATED_E_P_S_ESTIMATE_NEXT_QUARTER = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_LOW = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_LOW = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_HIGH = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_HIGH = "UPDATED_TEXT";
    private static final String DEFAULT_YEAR_LOW = "SAMPLE_TEXT";
    private static final String UPDATED_YEAR_LOW = "UPDATED_TEXT";
    private static final String DEFAULT_YEAR_HIGH = "SAMPLE_TEXT";
    private static final String UPDATED_YEAR_HIGH = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_GAIN_PERCENT = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_GAIN_PERCENT = "UPDATED_TEXT";
    private static final String DEFAULT_ANNUALIZED_GAIN = "SAMPLE_TEXT";
    private static final String UPDATED_ANNUALIZED_GAIN = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_GAIN = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_GAIN = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_GAIN_PERCENT_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_GAIN_PERCENT_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_GAIN_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_GAIN_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_MORE_INFO = "SAMPLE_TEXT";
    private static final String UPDATED_MORE_INFO = "UPDATED_TEXT";
    private static final String DEFAULT_ORDER_BOOK_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_ORDER_BOOK_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_MARKET_CAPITALIZATION = "SAMPLE_TEXT";
    private static final String UPDATED_MARKET_CAPITALIZATION = "UPDATED_TEXT";
    private static final String DEFAULT_MARKET_CAP_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_MARKET_CAP_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_EBITDA = "SAMPLE_TEXT";
    private static final String UPDATED_EBITDA = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_FROM_YEAR_LOW = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_FROM_YEAR_LOW = "UPDATED_TEXT";
    private static final String DEFAULT_PERCENT_CHANGE_FROM_YEAR_LOW = "SAMPLE_TEXT";
    private static final String UPDATED_PERCENT_CHANGE_FROM_YEAR_LOW = "UPDATED_TEXT";
    private static final String DEFAULT_LAST_TRADE_REALTIME_WITH_TIME = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_TRADE_REALTIME_WITH_TIME = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_PERCENT_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_PERCENT_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_FROM_YEAR_HIGH = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_FROM_YEAR_HIGH = "UPDATED_TEXT";
    private static final String DEFAULT_PERCEBT_CHANGE_FROM_YEAR_HIGH = "SAMPLE_TEXT";
    private static final String UPDATED_PERCEBT_CHANGE_FROM_YEAR_HIGH = "UPDATED_TEXT";
    private static final String DEFAULT_LAST_TRADE_WITH_TIME = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_TRADE_WITH_TIME = "UPDATED_TEXT";
    private static final String DEFAULT_LAST_TRADE_PRICE_ONLY = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_TRADE_PRICE_ONLY = "UPDATED_TEXT";
    private static final String DEFAULT_HIGH_LIMIT = "SAMPLE_TEXT";
    private static final String UPDATED_HIGH_LIMIT = "UPDATED_TEXT";
    private static final String DEFAULT_LOW_LIMIT = "SAMPLE_TEXT";
    private static final String UPDATED_LOW_LIMIT = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_RANGE = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_RANGE = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_RANGE_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_RANGE_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_FIFTYDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_FIFTYDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_TWO_HUNDREDDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_TWO_HUNDREDDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE = "SAMPLE_TEXT";
    private static final String UPDATED_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE = "UPDATED_TEXT";
    private static final String DEFAULT_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_NAME = "UPDATED_TEXT";
    private static final String DEFAULT_NOTES = "SAMPLE_TEXT";
    private static final String UPDATED_NOTES = "UPDATED_TEXT";
    private static final String DEFAULT_OPEN = "SAMPLE_TEXT";
    private static final String UPDATED_OPEN = "UPDATED_TEXT";
    private static final String DEFAULT_PREVIOUS_CLOSE = "SAMPLE_TEXT";
    private static final String UPDATED_PREVIOUS_CLOSE = "UPDATED_TEXT";
    private static final String DEFAULT_PRICE_PAID = "SAMPLE_TEXT";
    private static final String UPDATED_PRICE_PAID = "UPDATED_TEXT";
    private static final String DEFAULT_CHANGEIN_PERCENT = "SAMPLE_TEXT";
    private static final String UPDATED_CHANGEIN_PERCENT = "UPDATED_TEXT";
    private static final String DEFAULT_PRICE_SALES = "SAMPLE_TEXT";
    private static final String UPDATED_PRICE_SALES = "UPDATED_TEXT";
    private static final String DEFAULT_PRICE_BOOK = "SAMPLE_TEXT";
    private static final String UPDATED_PRICE_BOOK = "UPDATED_TEXT";
    private static final String DEFAULT_EX_DIVIDEND_DATE = "SAMPLE_TEXT";
    private static final String UPDATED_EX_DIVIDEND_DATE = "UPDATED_TEXT";
    private static final String DEFAULT_P_E_RATIO = "SAMPLE_TEXT";
    private static final String UPDATED_P_E_RATIO = "UPDATED_TEXT";
    private static final String DEFAULT_DIVIDEND_PAY_DATE = "SAMPLE_TEXT";
    private static final String UPDATED_DIVIDEND_PAY_DATE = "UPDATED_TEXT";
    private static final String DEFAULT_P_E_RATIO_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_P_E_RATIO_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_P_E_G_RATIO = "SAMPLE_TEXT";
    private static final String UPDATED_P_E_G_RATIO = "UPDATED_TEXT";
    private static final String DEFAULT_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR = "SAMPLE_TEXT";
    private static final String UPDATED_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR = "UPDATED_TEXT";
    private static final String DEFAULT_PRICE_E_P_S_ESTIMATE_NEXT_YEAR = "SAMPLE_TEXT";
    private static final String UPDATED_PRICE_E_P_S_ESTIMATE_NEXT_YEAR = "UPDATED_TEXT";
    private static final String DEFAULT_SYMBOL = "SAMPLE_TEXT";
    private static final String UPDATED_SYMBOL = "UPDATED_TEXT";
    private static final String DEFAULT_SHARES_OWNED = "SAMPLE_TEXT";
    private static final String UPDATED_SHARES_OWNED = "UPDATED_TEXT";
    private static final String DEFAULT_SHORT_RATIO = "SAMPLE_TEXT";
    private static final String UPDATED_SHORT_RATIO = "UPDATED_TEXT";
    private static final String DEFAULT_LAST_TRADE_TIME = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_TRADE_TIME = "UPDATED_TEXT";
    private static final String DEFAULT_TICKER_TREND = "SAMPLE_TEXT";
    private static final String UPDATED_TICKER_TREND = "UPDATED_TEXT";
    private static final String DEFAULT_ONEYR_TARGET_PRICE = "SAMPLE_TEXT";
    private static final String UPDATED_ONEYR_TARGET_PRICE = "UPDATED_TEXT";
    private static final String DEFAULT_VOLUME = "SAMPLE_TEXT";
    private static final String UPDATED_VOLUME = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_VALUE = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_VALUE = "UPDATED_TEXT";
    private static final String DEFAULT_HOLDINGS_VALUE_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_HOLDINGS_VALUE_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_YEAR_RANGE = "SAMPLE_TEXT";
    private static final String UPDATED_YEAR_RANGE = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_VALUE_CHANGE = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_VALUE_CHANGE = "UPDATED_TEXT";
    private static final String DEFAULT_DAYS_VALUE_CHANGE_REALTIME = "SAMPLE_TEXT";
    private static final String UPDATED_DAYS_VALUE_CHANGE_REALTIME = "UPDATED_TEXT";
    private static final String DEFAULT_STOCK_EXCHANGE = "SAMPLE_TEXT";
    private static final String UPDATED_STOCK_EXCHANGE = "UPDATED_TEXT";
    private static final String DEFAULT_DIVIDEND_YIELD = "SAMPLE_TEXT";
    private static final String UPDATED_DIVIDEND_YIELD = "UPDATED_TEXT";
    private static final String DEFAULT_PERCENT_CHANGE = "SAMPLE_TEXT";
    private static final String UPDATED_PERCENT_CHANGE = "UPDATED_TEXT";

    @Inject
    private QuoteEventRepository quoteEventRepository;

    @Inject
    private QuoteEventMapper quoteEventMapper;

    @Inject
    private QuoteEventSearchRepository quoteEventSearchRepository;

    private MockMvc restQuoteEventMockMvc;

    private QuoteEvent quoteEvent;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        QuoteEventResource quoteEventResource = new QuoteEventResource();
        ReflectionTestUtils.setField(quoteEventResource, "quoteEventRepository", quoteEventRepository);
        ReflectionTestUtils.setField(quoteEventResource, "quoteEventMapper", quoteEventMapper);
        ReflectionTestUtils.setField(quoteEventResource, "quoteEventSearchRepository", quoteEventSearchRepository);
        this.restQuoteEventMockMvc = MockMvcBuilders.standaloneSetup(quoteEventResource).build();
    }

    @Before
    public void initTest() {
        quoteEvent = new QuoteEvent();
        quoteEvent.setAsk(DEFAULT_ASK);
        quoteEvent.setAverageDailyVolume(DEFAULT_AVERAGE_DAILY_VOLUME);
        quoteEvent.setBid(DEFAULT_BID);
        quoteEvent.setAskRealtime(DEFAULT_ASK_REALTIME);
        quoteEvent.setBidRealtime(DEFAULT_BID_REALTIME);
        quoteEvent.setBookValue(DEFAULT_BOOK_VALUE);
        quoteEvent.setChange_PercentChange(DEFAULT_CHANGE_PERCENT_CHANGE);
        quoteEvent.setChange(DEFAULT_CHANGE);
        quoteEvent.setCommission(DEFAULT_COMMISSION);
        quoteEvent.setCurrency(DEFAULT_CURRENCY);
        quoteEvent.setChangeRealtime(DEFAULT_CHANGE_REALTIME);
        quoteEvent.setAfterHoursChangeRealtime(DEFAULT_AFTER_HOURS_CHANGE_REALTIME);
        quoteEvent.setDividendShare(DEFAULT_DIVIDEND_SHARE);
        quoteEvent.setLastTradeDate(DEFAULT_LAST_TRADE_DATE);
        quoteEvent.setTradeDate(DEFAULT_TRADE_DATE);
        quoteEvent.setEarningsShare(DEFAULT_EARNINGS_SHARE);
        quoteEvent.setErrorIndicationreturnedforsymbolchangedinvalid(DEFAULT_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID);
        quoteEvent.setEPSEstimateCurrentYear(DEFAULT_E_P_S_ESTIMATE_CURRENT_YEAR);
        quoteEvent.setEPSEstimateNextYear(DEFAULT_E_P_S_ESTIMATE_NEXT_YEAR);
        quoteEvent.setEPSEstimateNextQuarter(DEFAULT_E_P_S_ESTIMATE_NEXT_QUARTER);
        quoteEvent.setDaysLow(DEFAULT_DAYS_LOW);
        quoteEvent.setDaysHigh(DEFAULT_DAYS_HIGH);
        quoteEvent.setYearLow(DEFAULT_YEAR_LOW);
        quoteEvent.setYearHigh(DEFAULT_YEAR_HIGH);
        quoteEvent.setHoldingsGainPercent(DEFAULT_HOLDINGS_GAIN_PERCENT);
        quoteEvent.setAnnualizedGain(DEFAULT_ANNUALIZED_GAIN);
        quoteEvent.setHoldingsGain(DEFAULT_HOLDINGS_GAIN);
        quoteEvent.setHoldingsGainPercentRealtime(DEFAULT_HOLDINGS_GAIN_PERCENT_REALTIME);
        quoteEvent.setHoldingsGainRealtime(DEFAULT_HOLDINGS_GAIN_REALTIME);
        quoteEvent.setMoreInfo(DEFAULT_MORE_INFO);
        quoteEvent.setOrderBookRealtime(DEFAULT_ORDER_BOOK_REALTIME);
        quoteEvent.setMarketCapitalization(DEFAULT_MARKET_CAPITALIZATION);
        quoteEvent.setMarketCapRealtime(DEFAULT_MARKET_CAP_REALTIME);
        quoteEvent.setEBITDA(DEFAULT_EBITDA);
        quoteEvent.setChangeFromYearLow(DEFAULT_CHANGE_FROM_YEAR_LOW);
        quoteEvent.setPercentChangeFromYearLow(DEFAULT_PERCENT_CHANGE_FROM_YEAR_LOW);
        quoteEvent.setLastTradeRealtimeWithTime(DEFAULT_LAST_TRADE_REALTIME_WITH_TIME);
        quoteEvent.setChangePercentRealtime(DEFAULT_CHANGE_PERCENT_REALTIME);
        quoteEvent.setChangeFromYearHigh(DEFAULT_CHANGE_FROM_YEAR_HIGH);
        quoteEvent.setPercebtChangeFromYearHigh(DEFAULT_PERCEBT_CHANGE_FROM_YEAR_HIGH);
        quoteEvent.setLastTradeWithTime(DEFAULT_LAST_TRADE_WITH_TIME);
        quoteEvent.setLastTradePriceOnly(DEFAULT_LAST_TRADE_PRICE_ONLY);
        quoteEvent.setHighLimit(DEFAULT_HIGH_LIMIT);
        quoteEvent.setLowLimit(DEFAULT_LOW_LIMIT);
        quoteEvent.setDaysRange(DEFAULT_DAYS_RANGE);
        quoteEvent.setDaysRangeRealtime(DEFAULT_DAYS_RANGE_REALTIME);
        quoteEvent.setFiftydayMovingAverage(DEFAULT_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setTwoHundreddayMovingAverage(DEFAULT_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setChangeFromTwoHundreddayMovingAverage(DEFAULT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setPercentChangeFromTwoHundreddayMovingAverage(DEFAULT_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setChangeFromFiftydayMovingAverage(DEFAULT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setPercentChangeFromFiftydayMovingAverage(DEFAULT_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setName(DEFAULT_NAME);
        quoteEvent.setNotes(DEFAULT_NOTES);
        quoteEvent.setOpen(DEFAULT_OPEN);
        quoteEvent.setPreviousClose(DEFAULT_PREVIOUS_CLOSE);
        quoteEvent.setPricePaid(DEFAULT_PRICE_PAID);
        quoteEvent.setChangeinPercent(DEFAULT_CHANGEIN_PERCENT);
        quoteEvent.setPriceSales(DEFAULT_PRICE_SALES);
        quoteEvent.setPriceBook(DEFAULT_PRICE_BOOK);
        quoteEvent.setExDividendDate(DEFAULT_EX_DIVIDEND_DATE);
        quoteEvent.setPERatio(DEFAULT_P_E_RATIO);
        quoteEvent.setDividendPayDate(DEFAULT_DIVIDEND_PAY_DATE);
        quoteEvent.setPERatioRealtime(DEFAULT_P_E_RATIO_REALTIME);
        quoteEvent.setPEGRatio(DEFAULT_P_E_G_RATIO);
        quoteEvent.setPriceEPSEstimateCurrentYear(DEFAULT_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR);
        quoteEvent.setPriceEPSEstimateNextYear(DEFAULT_PRICE_E_P_S_ESTIMATE_NEXT_YEAR);
        quoteEvent.setSymbol(DEFAULT_SYMBOL);
        quoteEvent.setSharesOwned(DEFAULT_SHARES_OWNED);
        quoteEvent.setShortRatio(DEFAULT_SHORT_RATIO);
        quoteEvent.setLastTradeTime(DEFAULT_LAST_TRADE_TIME);
        quoteEvent.setTickerTrend(DEFAULT_TICKER_TREND);
        quoteEvent.setOneyrTargetPrice(DEFAULT_ONEYR_TARGET_PRICE);
        quoteEvent.setVolume(DEFAULT_VOLUME);
        quoteEvent.setHoldingsValue(DEFAULT_HOLDINGS_VALUE);
        quoteEvent.setHoldingsValueRealtime(DEFAULT_HOLDINGS_VALUE_REALTIME);
        quoteEvent.setYearRange(DEFAULT_YEAR_RANGE);
        quoteEvent.setDaysValueChange(DEFAULT_DAYS_VALUE_CHANGE);
        quoteEvent.setDaysValueChangeRealtime(DEFAULT_DAYS_VALUE_CHANGE_REALTIME);
        quoteEvent.setStockExchange(DEFAULT_STOCK_EXCHANGE);
        quoteEvent.setDividendYield(DEFAULT_DIVIDEND_YIELD);
        quoteEvent.setPercentChange(DEFAULT_PERCENT_CHANGE);
    }

    @Test
    @Transactional
    public void createQuoteEvent() throws Exception {
        int databaseSizeBeforeCreate = quoteEventRepository.findAll().size();

        // Create the QuoteEvent
        restQuoteEventMockMvc.perform(post("/api/quoteEvents")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(quoteEvent)))
                .andExpect(status().isCreated());

        // Validate the QuoteEvent in the database
        List<QuoteEvent> quoteEvents = quoteEventRepository.findAll();
        assertThat(quoteEvents).hasSize(databaseSizeBeforeCreate + 1);
        QuoteEvent testQuoteEvent = quoteEvents.get(quoteEvents.size() - 1);
        assertThat(testQuoteEvent.getAsk()).isEqualTo(DEFAULT_ASK);
        assertThat(testQuoteEvent.getAverageDailyVolume()).isEqualTo(DEFAULT_AVERAGE_DAILY_VOLUME);
        assertThat(testQuoteEvent.getBid()).isEqualTo(DEFAULT_BID);
        assertThat(testQuoteEvent.getAskRealtime()).isEqualTo(DEFAULT_ASK_REALTIME);
        assertThat(testQuoteEvent.getBidRealtime()).isEqualTo(DEFAULT_BID_REALTIME);
        assertThat(testQuoteEvent.getBookValue()).isEqualTo(DEFAULT_BOOK_VALUE);
        assertThat(testQuoteEvent.getChange_PercentChange()).isEqualTo(DEFAULT_CHANGE_PERCENT_CHANGE);
        assertThat(testQuoteEvent.getChange()).isEqualTo(DEFAULT_CHANGE);
        assertThat(testQuoteEvent.getCommission()).isEqualTo(DEFAULT_COMMISSION);
        assertThat(testQuoteEvent.getCurrency()).isEqualTo(DEFAULT_CURRENCY);
        assertThat(testQuoteEvent.getChangeRealtime()).isEqualTo(DEFAULT_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getAfterHoursChangeRealtime()).isEqualTo(DEFAULT_AFTER_HOURS_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getDividendShare()).isEqualTo(DEFAULT_DIVIDEND_SHARE);
        assertThat(testQuoteEvent.getLastTradeDate()).isEqualTo(DEFAULT_LAST_TRADE_DATE);
        assertThat(testQuoteEvent.getTradeDate()).isEqualTo(DEFAULT_TRADE_DATE);
        assertThat(testQuoteEvent.getEarningsShare()).isEqualTo(DEFAULT_EARNINGS_SHARE);
        assertThat(testQuoteEvent.getErrorIndicationreturnedforsymbolchangedinvalid()).isEqualTo(DEFAULT_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID);
        assertThat(testQuoteEvent.getEPSEstimateCurrentYear()).isEqualTo(DEFAULT_E_P_S_ESTIMATE_CURRENT_YEAR);
        assertThat(testQuoteEvent.getEPSEstimateNextYear()).isEqualTo(DEFAULT_E_P_S_ESTIMATE_NEXT_YEAR);
        assertThat(testQuoteEvent.getEPSEstimateNextQuarter()).isEqualTo(DEFAULT_E_P_S_ESTIMATE_NEXT_QUARTER);
        assertThat(testQuoteEvent.getDaysLow()).isEqualTo(DEFAULT_DAYS_LOW);
        assertThat(testQuoteEvent.getDaysHigh()).isEqualTo(DEFAULT_DAYS_HIGH);
        assertThat(testQuoteEvent.getYearLow()).isEqualTo(DEFAULT_YEAR_LOW);
        assertThat(testQuoteEvent.getYearHigh()).isEqualTo(DEFAULT_YEAR_HIGH);
        assertThat(testQuoteEvent.getHoldingsGainPercent()).isEqualTo(DEFAULT_HOLDINGS_GAIN_PERCENT);
        assertThat(testQuoteEvent.getAnnualizedGain()).isEqualTo(DEFAULT_ANNUALIZED_GAIN);
        assertThat(testQuoteEvent.getHoldingsGain()).isEqualTo(DEFAULT_HOLDINGS_GAIN);
        assertThat(testQuoteEvent.getHoldingsGainPercentRealtime()).isEqualTo(DEFAULT_HOLDINGS_GAIN_PERCENT_REALTIME);
        assertThat(testQuoteEvent.getHoldingsGainRealtime()).isEqualTo(DEFAULT_HOLDINGS_GAIN_REALTIME);
        assertThat(testQuoteEvent.getMoreInfo()).isEqualTo(DEFAULT_MORE_INFO);
        assertThat(testQuoteEvent.getOrderBookRealtime()).isEqualTo(DEFAULT_ORDER_BOOK_REALTIME);
        assertThat(testQuoteEvent.getMarketCapitalization()).isEqualTo(DEFAULT_MARKET_CAPITALIZATION);
        assertThat(testQuoteEvent.getMarketCapRealtime()).isEqualTo(DEFAULT_MARKET_CAP_REALTIME);
        assertThat(testQuoteEvent.getEBITDA()).isEqualTo(DEFAULT_EBITDA);
        assertThat(testQuoteEvent.getChangeFromYearLow()).isEqualTo(DEFAULT_CHANGE_FROM_YEAR_LOW);
        assertThat(testQuoteEvent.getPercentChangeFromYearLow()).isEqualTo(DEFAULT_PERCENT_CHANGE_FROM_YEAR_LOW);
        assertThat(testQuoteEvent.getLastTradeRealtimeWithTime()).isEqualTo(DEFAULT_LAST_TRADE_REALTIME_WITH_TIME);
        assertThat(testQuoteEvent.getChangePercentRealtime()).isEqualTo(DEFAULT_CHANGE_PERCENT_REALTIME);
        assertThat(testQuoteEvent.getChangeFromYearHigh()).isEqualTo(DEFAULT_CHANGE_FROM_YEAR_HIGH);
        assertThat(testQuoteEvent.getPercebtChangeFromYearHigh()).isEqualTo(DEFAULT_PERCEBT_CHANGE_FROM_YEAR_HIGH);
        assertThat(testQuoteEvent.getLastTradeWithTime()).isEqualTo(DEFAULT_LAST_TRADE_WITH_TIME);
        assertThat(testQuoteEvent.getLastTradePriceOnly()).isEqualTo(DEFAULT_LAST_TRADE_PRICE_ONLY);
        assertThat(testQuoteEvent.getHighLimit()).isEqualTo(DEFAULT_HIGH_LIMIT);
        assertThat(testQuoteEvent.getLowLimit()).isEqualTo(DEFAULT_LOW_LIMIT);
        assertThat(testQuoteEvent.getDaysRange()).isEqualTo(DEFAULT_DAYS_RANGE);
        assertThat(testQuoteEvent.getDaysRangeRealtime()).isEqualTo(DEFAULT_DAYS_RANGE_REALTIME);
        assertThat(testQuoteEvent.getFiftydayMovingAverage()).isEqualTo(DEFAULT_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getTwoHundreddayMovingAverage()).isEqualTo(DEFAULT_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getChangeFromTwoHundreddayMovingAverage()).isEqualTo(DEFAULT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getPercentChangeFromTwoHundreddayMovingAverage()).isEqualTo(DEFAULT_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getChangeFromFiftydayMovingAverage()).isEqualTo(DEFAULT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getPercentChangeFromFiftydayMovingAverage()).isEqualTo(DEFAULT_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testQuoteEvent.getNotes()).isEqualTo(DEFAULT_NOTES);
        assertThat(testQuoteEvent.getOpen()).isEqualTo(DEFAULT_OPEN);
        assertThat(testQuoteEvent.getPreviousClose()).isEqualTo(DEFAULT_PREVIOUS_CLOSE);
        assertThat(testQuoteEvent.getPricePaid()).isEqualTo(DEFAULT_PRICE_PAID);
        assertThat(testQuoteEvent.getChangeinPercent()).isEqualTo(DEFAULT_CHANGEIN_PERCENT);
        assertThat(testQuoteEvent.getPriceSales()).isEqualTo(DEFAULT_PRICE_SALES);
        assertThat(testQuoteEvent.getPriceBook()).isEqualTo(DEFAULT_PRICE_BOOK);
        assertThat(testQuoteEvent.getExDividendDate()).isEqualTo(DEFAULT_EX_DIVIDEND_DATE);
        assertThat(testQuoteEvent.getPERatio()).isEqualTo(DEFAULT_P_E_RATIO);
        assertThat(testQuoteEvent.getDividendPayDate()).isEqualTo(DEFAULT_DIVIDEND_PAY_DATE);
        assertThat(testQuoteEvent.getPERatioRealtime()).isEqualTo(DEFAULT_P_E_RATIO_REALTIME);
        assertThat(testQuoteEvent.getPEGRatio()).isEqualTo(DEFAULT_P_E_G_RATIO);
        assertThat(testQuoteEvent.getPriceEPSEstimateCurrentYear()).isEqualTo(DEFAULT_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR);
        assertThat(testQuoteEvent.getPriceEPSEstimateNextYear()).isEqualTo(DEFAULT_PRICE_E_P_S_ESTIMATE_NEXT_YEAR);
        assertThat(testQuoteEvent.getSymbol()).isEqualTo(DEFAULT_SYMBOL);
        assertThat(testQuoteEvent.getSharesOwned()).isEqualTo(DEFAULT_SHARES_OWNED);
        assertThat(testQuoteEvent.getShortRatio()).isEqualTo(DEFAULT_SHORT_RATIO);
        assertThat(testQuoteEvent.getLastTradeTime()).isEqualTo(DEFAULT_LAST_TRADE_TIME);
        assertThat(testQuoteEvent.getTickerTrend()).isEqualTo(DEFAULT_TICKER_TREND);
        assertThat(testQuoteEvent.getOneyrTargetPrice()).isEqualTo(DEFAULT_ONEYR_TARGET_PRICE);
        assertThat(testQuoteEvent.getVolume()).isEqualTo(DEFAULT_VOLUME);
        assertThat(testQuoteEvent.getHoldingsValue()).isEqualTo(DEFAULT_HOLDINGS_VALUE);
        assertThat(testQuoteEvent.getHoldingsValueRealtime()).isEqualTo(DEFAULT_HOLDINGS_VALUE_REALTIME);
        assertThat(testQuoteEvent.getYearRange()).isEqualTo(DEFAULT_YEAR_RANGE);
        assertThat(testQuoteEvent.getDaysValueChange()).isEqualTo(DEFAULT_DAYS_VALUE_CHANGE);
        assertThat(testQuoteEvent.getDaysValueChangeRealtime()).isEqualTo(DEFAULT_DAYS_VALUE_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getStockExchange()).isEqualTo(DEFAULT_STOCK_EXCHANGE);
        assertThat(testQuoteEvent.getDividendYield()).isEqualTo(DEFAULT_DIVIDEND_YIELD);
        assertThat(testQuoteEvent.getPercentChange()).isEqualTo(DEFAULT_PERCENT_CHANGE);
    }

    @Test
    @Transactional
    public void checkSymbolIsRequired() throws Exception {
        // Validate the database is empty
        assertThat(quoteEventRepository.findAll()).hasSize(0);
        // set the field null
        quoteEvent.setSymbol(null);

        // Create the QuoteEvent, which fails.
        restQuoteEventMockMvc.perform(post("/api/quoteEvents")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(quoteEvent)))
                .andExpect(status().isBadRequest());

        // Validate the database is still empty
        List<QuoteEvent> quoteEvents = quoteEventRepository.findAll();
        assertThat(quoteEvents).hasSize(0);
    }

    @Test
    @Transactional
    public void getAllQuoteEvents() throws Exception {
        // Initialize the database
        quoteEventRepository.saveAndFlush(quoteEvent);

        // Get all the quoteEvents
        restQuoteEventMockMvc.perform(get("/api/quoteEvents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(quoteEvent.getId().intValue())))
                .andExpect(jsonPath("$.[*].ask").value(hasItem(DEFAULT_ASK.intValue())))
                .andExpect(jsonPath("$.[*].averageDailyVolume").value(hasItem(DEFAULT_AVERAGE_DAILY_VOLUME.toString())))
                .andExpect(jsonPath("$.[*].bid").value(hasItem(DEFAULT_BID.toString())))
                .andExpect(jsonPath("$.[*].askRealtime").value(hasItem(DEFAULT_ASK_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].bidRealtime").value(hasItem(DEFAULT_BID_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].bookValue").value(hasItem(DEFAULT_BOOK_VALUE.toString())))
                .andExpect(jsonPath("$.[*].change_PercentChange").value(hasItem(DEFAULT_CHANGE_PERCENT_CHANGE.toString())))
                .andExpect(jsonPath("$.[*].change").value(hasItem(DEFAULT_CHANGE.intValue())))
                .andExpect(jsonPath("$.[*].commission").value(hasItem(DEFAULT_COMMISSION.toString())))
                .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY.toString())))
                .andExpect(jsonPath("$.[*].changeRealtime").value(hasItem(DEFAULT_CHANGE_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].afterHoursChangeRealtime").value(hasItem(DEFAULT_AFTER_HOURS_CHANGE_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].dividendShare").value(hasItem(DEFAULT_DIVIDEND_SHARE.toString())))
                .andExpect(jsonPath("$.[*].lastTradeDate").value(hasItem(DEFAULT_LAST_TRADE_DATE.toString())))
                .andExpect(jsonPath("$.[*].tradeDate").value(hasItem(DEFAULT_TRADE_DATE.toString())))
                .andExpect(jsonPath("$.[*].earningsShare").value(hasItem(DEFAULT_EARNINGS_SHARE.toString())))
                .andExpect(jsonPath("$.[*].errorIndicationreturnedforsymbolchangedinvalid").value(hasItem(DEFAULT_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID.toString())))
                .andExpect(jsonPath("$.[*].ePSEstimateCurrentYear").value(hasItem(DEFAULT_E_P_S_ESTIMATE_CURRENT_YEAR.toString())))
                .andExpect(jsonPath("$.[*].ePSEstimateNextYear").value(hasItem(DEFAULT_E_P_S_ESTIMATE_NEXT_YEAR.toString())))
                .andExpect(jsonPath("$.[*].ePSEstimateNextQuarter").value(hasItem(DEFAULT_E_P_S_ESTIMATE_NEXT_QUARTER.toString())))
                .andExpect(jsonPath("$.[*].daysLow").value(hasItem(DEFAULT_DAYS_LOW.toString())))
                .andExpect(jsonPath("$.[*].daysHigh").value(hasItem(DEFAULT_DAYS_HIGH.toString())))
                .andExpect(jsonPath("$.[*].yearLow").value(hasItem(DEFAULT_YEAR_LOW.toString())))
                .andExpect(jsonPath("$.[*].yearHigh").value(hasItem(DEFAULT_YEAR_HIGH.toString())))
                .andExpect(jsonPath("$.[*].holdingsGainPercent").value(hasItem(DEFAULT_HOLDINGS_GAIN_PERCENT.toString())))
                .andExpect(jsonPath("$.[*].annualizedGain").value(hasItem(DEFAULT_ANNUALIZED_GAIN.toString())))
                .andExpect(jsonPath("$.[*].holdingsGain").value(hasItem(DEFAULT_HOLDINGS_GAIN.toString())))
                .andExpect(jsonPath("$.[*].holdingsGainPercentRealtime").value(hasItem(DEFAULT_HOLDINGS_GAIN_PERCENT_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].holdingsGainRealtime").value(hasItem(DEFAULT_HOLDINGS_GAIN_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].moreInfo").value(hasItem(DEFAULT_MORE_INFO.toString())))
                .andExpect(jsonPath("$.[*].orderBookRealtime").value(hasItem(DEFAULT_ORDER_BOOK_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].marketCapitalization").value(hasItem(DEFAULT_MARKET_CAPITALIZATION.toString())))
                .andExpect(jsonPath("$.[*].marketCapRealtime").value(hasItem(DEFAULT_MARKET_CAP_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].eBITDA").value(hasItem(DEFAULT_EBITDA.toString())))
                .andExpect(jsonPath("$.[*].changeFromYearLow").value(hasItem(DEFAULT_CHANGE_FROM_YEAR_LOW.toString())))
                .andExpect(jsonPath("$.[*].percentChangeFromYearLow").value(hasItem(DEFAULT_PERCENT_CHANGE_FROM_YEAR_LOW.toString())))
                .andExpect(jsonPath("$.[*].lastTradeRealtimeWithTime").value(hasItem(DEFAULT_LAST_TRADE_REALTIME_WITH_TIME.toString())))
                .andExpect(jsonPath("$.[*].changePercentRealtime").value(hasItem(DEFAULT_CHANGE_PERCENT_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].changeFromYearHigh").value(hasItem(DEFAULT_CHANGE_FROM_YEAR_HIGH.toString())))
                .andExpect(jsonPath("$.[*].percebtChangeFromYearHigh").value(hasItem(DEFAULT_PERCEBT_CHANGE_FROM_YEAR_HIGH.toString())))
                .andExpect(jsonPath("$.[*].lastTradeWithTime").value(hasItem(DEFAULT_LAST_TRADE_WITH_TIME.toString())))
                .andExpect(jsonPath("$.[*].lastTradePriceOnly").value(hasItem(DEFAULT_LAST_TRADE_PRICE_ONLY.toString())))
                .andExpect(jsonPath("$.[*].highLimit").value(hasItem(DEFAULT_HIGH_LIMIT.toString())))
                .andExpect(jsonPath("$.[*].lowLimit").value(hasItem(DEFAULT_LOW_LIMIT.toString())))
                .andExpect(jsonPath("$.[*].daysRange").value(hasItem(DEFAULT_DAYS_RANGE.toString())))
                .andExpect(jsonPath("$.[*].daysRangeRealtime").value(hasItem(DEFAULT_DAYS_RANGE_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].fiftydayMovingAverage").value(hasItem(DEFAULT_FIFTYDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].twoHundreddayMovingAverage").value(hasItem(DEFAULT_TWO_HUNDREDDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].changeFromTwoHundreddayMovingAverage").value(hasItem(DEFAULT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].percentChangeFromTwoHundreddayMovingAverage").value(hasItem(DEFAULT_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].changeFromFiftydayMovingAverage").value(hasItem(DEFAULT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].percentChangeFromFiftydayMovingAverage").value(hasItem(DEFAULT_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE.toString())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
                .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES.toString())))
                .andExpect(jsonPath("$.[*].open").value(hasItem(DEFAULT_OPEN.toString())))
                .andExpect(jsonPath("$.[*].previousClose").value(hasItem(DEFAULT_PREVIOUS_CLOSE.toString())))
                .andExpect(jsonPath("$.[*].pricePaid").value(hasItem(DEFAULT_PRICE_PAID.toString())))
                .andExpect(jsonPath("$.[*].changeinPercent").value(hasItem(DEFAULT_CHANGEIN_PERCENT.toString())))
                .andExpect(jsonPath("$.[*].priceSales").value(hasItem(DEFAULT_PRICE_SALES.toString())))
                .andExpect(jsonPath("$.[*].priceBook").value(hasItem(DEFAULT_PRICE_BOOK.toString())))
                .andExpect(jsonPath("$.[*].exDividendDate").value(hasItem(DEFAULT_EX_DIVIDEND_DATE.toString())))
                .andExpect(jsonPath("$.[*].pERatio").value(hasItem(DEFAULT_P_E_RATIO.toString())))
                .andExpect(jsonPath("$.[*].dividendPayDate").value(hasItem(DEFAULT_DIVIDEND_PAY_DATE.toString())))
                .andExpect(jsonPath("$.[*].pERatioRealtime").value(hasItem(DEFAULT_P_E_RATIO_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].pEGRatio").value(hasItem(DEFAULT_P_E_G_RATIO.toString())))
                .andExpect(jsonPath("$.[*].priceEPSEstimateCurrentYear").value(hasItem(DEFAULT_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR.toString())))
                .andExpect(jsonPath("$.[*].priceEPSEstimateNextYear").value(hasItem(DEFAULT_PRICE_E_P_S_ESTIMATE_NEXT_YEAR.toString())))
                .andExpect(jsonPath("$.[*].symbol").value(hasItem(DEFAULT_SYMBOL.toString())))
                .andExpect(jsonPath("$.[*].sharesOwned").value(hasItem(DEFAULT_SHARES_OWNED.toString())))
                .andExpect(jsonPath("$.[*].shortRatio").value(hasItem(DEFAULT_SHORT_RATIO.toString())))
                .andExpect(jsonPath("$.[*].lastTradeTime").value(hasItem(DEFAULT_LAST_TRADE_TIME.toString())))
                .andExpect(jsonPath("$.[*].tickerTrend").value(hasItem(DEFAULT_TICKER_TREND.toString())))
                .andExpect(jsonPath("$.[*].oneyrTargetPrice").value(hasItem(DEFAULT_ONEYR_TARGET_PRICE.toString())))
                .andExpect(jsonPath("$.[*].volume").value(hasItem(DEFAULT_VOLUME.toString())))
                .andExpect(jsonPath("$.[*].holdingsValue").value(hasItem(DEFAULT_HOLDINGS_VALUE.toString())))
                .andExpect(jsonPath("$.[*].holdingsValueRealtime").value(hasItem(DEFAULT_HOLDINGS_VALUE_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].yearRange").value(hasItem(DEFAULT_YEAR_RANGE.toString())))
                .andExpect(jsonPath("$.[*].daysValueChange").value(hasItem(DEFAULT_DAYS_VALUE_CHANGE.toString())))
                .andExpect(jsonPath("$.[*].daysValueChangeRealtime").value(hasItem(DEFAULT_DAYS_VALUE_CHANGE_REALTIME.toString())))
                .andExpect(jsonPath("$.[*].stockExchange").value(hasItem(DEFAULT_STOCK_EXCHANGE.toString())))
                .andExpect(jsonPath("$.[*].dividendYield").value(hasItem(DEFAULT_DIVIDEND_YIELD.toString())))
                .andExpect(jsonPath("$.[*].percentChange").value(hasItem(DEFAULT_PERCENT_CHANGE.toString())));
    }

    @Test
    @Transactional
    public void getQuoteEvent() throws Exception {
        // Initialize the database
        quoteEventRepository.saveAndFlush(quoteEvent);

        // Get the quoteEvent
        restQuoteEventMockMvc.perform(get("/api/quoteEvents/{id}", quoteEvent.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(quoteEvent.getId().intValue()))
            .andExpect(jsonPath("$.ask").value(DEFAULT_ASK.intValue()))
            .andExpect(jsonPath("$.averageDailyVolume").value(DEFAULT_AVERAGE_DAILY_VOLUME.toString()))
            .andExpect(jsonPath("$.bid").value(DEFAULT_BID.toString()))
            .andExpect(jsonPath("$.askRealtime").value(DEFAULT_ASK_REALTIME.toString()))
            .andExpect(jsonPath("$.bidRealtime").value(DEFAULT_BID_REALTIME.toString()))
            .andExpect(jsonPath("$.bookValue").value(DEFAULT_BOOK_VALUE.toString()))
            .andExpect(jsonPath("$.change_PercentChange").value(DEFAULT_CHANGE_PERCENT_CHANGE.toString()))
            .andExpect(jsonPath("$.change").value(DEFAULT_CHANGE.intValue()))
            .andExpect(jsonPath("$.commission").value(DEFAULT_COMMISSION.toString()))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY.toString()))
            .andExpect(jsonPath("$.changeRealtime").value(DEFAULT_CHANGE_REALTIME.toString()))
            .andExpect(jsonPath("$.afterHoursChangeRealtime").value(DEFAULT_AFTER_HOURS_CHANGE_REALTIME.toString()))
            .andExpect(jsonPath("$.dividendShare").value(DEFAULT_DIVIDEND_SHARE.toString()))
            .andExpect(jsonPath("$.lastTradeDate").value(DEFAULT_LAST_TRADE_DATE.toString()))
            .andExpect(jsonPath("$.tradeDate").value(DEFAULT_TRADE_DATE.toString()))
            .andExpect(jsonPath("$.earningsShare").value(DEFAULT_EARNINGS_SHARE.toString()))
            .andExpect(jsonPath("$.errorIndicationreturnedforsymbolchangedinvalid").value(DEFAULT_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID.toString()))
            .andExpect(jsonPath("$.ePSEstimateCurrentYear").value(DEFAULT_E_P_S_ESTIMATE_CURRENT_YEAR.toString()))
            .andExpect(jsonPath("$.ePSEstimateNextYear").value(DEFAULT_E_P_S_ESTIMATE_NEXT_YEAR.toString()))
            .andExpect(jsonPath("$.ePSEstimateNextQuarter").value(DEFAULT_E_P_S_ESTIMATE_NEXT_QUARTER.toString()))
            .andExpect(jsonPath("$.daysLow").value(DEFAULT_DAYS_LOW.toString()))
            .andExpect(jsonPath("$.daysHigh").value(DEFAULT_DAYS_HIGH.toString()))
            .andExpect(jsonPath("$.yearLow").value(DEFAULT_YEAR_LOW.toString()))
            .andExpect(jsonPath("$.yearHigh").value(DEFAULT_YEAR_HIGH.toString()))
            .andExpect(jsonPath("$.holdingsGainPercent").value(DEFAULT_HOLDINGS_GAIN_PERCENT.toString()))
            .andExpect(jsonPath("$.annualizedGain").value(DEFAULT_ANNUALIZED_GAIN.toString()))
            .andExpect(jsonPath("$.holdingsGain").value(DEFAULT_HOLDINGS_GAIN.toString()))
            .andExpect(jsonPath("$.holdingsGainPercentRealtime").value(DEFAULT_HOLDINGS_GAIN_PERCENT_REALTIME.toString()))
            .andExpect(jsonPath("$.holdingsGainRealtime").value(DEFAULT_HOLDINGS_GAIN_REALTIME.toString()))
            .andExpect(jsonPath("$.moreInfo").value(DEFAULT_MORE_INFO.toString()))
            .andExpect(jsonPath("$.orderBookRealtime").value(DEFAULT_ORDER_BOOK_REALTIME.toString()))
            .andExpect(jsonPath("$.marketCapitalization").value(DEFAULT_MARKET_CAPITALIZATION.toString()))
            .andExpect(jsonPath("$.marketCapRealtime").value(DEFAULT_MARKET_CAP_REALTIME.toString()))
            .andExpect(jsonPath("$.eBITDA").value(DEFAULT_EBITDA.toString()))
            .andExpect(jsonPath("$.changeFromYearLow").value(DEFAULT_CHANGE_FROM_YEAR_LOW.toString()))
            .andExpect(jsonPath("$.percentChangeFromYearLow").value(DEFAULT_PERCENT_CHANGE_FROM_YEAR_LOW.toString()))
            .andExpect(jsonPath("$.lastTradeRealtimeWithTime").value(DEFAULT_LAST_TRADE_REALTIME_WITH_TIME.toString()))
            .andExpect(jsonPath("$.changePercentRealtime").value(DEFAULT_CHANGE_PERCENT_REALTIME.toString()))
            .andExpect(jsonPath("$.changeFromYearHigh").value(DEFAULT_CHANGE_FROM_YEAR_HIGH.toString()))
            .andExpect(jsonPath("$.percebtChangeFromYearHigh").value(DEFAULT_PERCEBT_CHANGE_FROM_YEAR_HIGH.toString()))
            .andExpect(jsonPath("$.lastTradeWithTime").value(DEFAULT_LAST_TRADE_WITH_TIME.toString()))
            .andExpect(jsonPath("$.lastTradePriceOnly").value(DEFAULT_LAST_TRADE_PRICE_ONLY.toString()))
            .andExpect(jsonPath("$.highLimit").value(DEFAULT_HIGH_LIMIT.toString()))
            .andExpect(jsonPath("$.lowLimit").value(DEFAULT_LOW_LIMIT.toString()))
            .andExpect(jsonPath("$.daysRange").value(DEFAULT_DAYS_RANGE.toString()))
            .andExpect(jsonPath("$.daysRangeRealtime").value(DEFAULT_DAYS_RANGE_REALTIME.toString()))
            .andExpect(jsonPath("$.fiftydayMovingAverage").value(DEFAULT_FIFTYDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.twoHundreddayMovingAverage").value(DEFAULT_TWO_HUNDREDDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.changeFromTwoHundreddayMovingAverage").value(DEFAULT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.percentChangeFromTwoHundreddayMovingAverage").value(DEFAULT_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.changeFromFiftydayMovingAverage").value(DEFAULT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.percentChangeFromFiftydayMovingAverage").value(DEFAULT_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES.toString()))
            .andExpect(jsonPath("$.open").value(DEFAULT_OPEN.toString()))
            .andExpect(jsonPath("$.previousClose").value(DEFAULT_PREVIOUS_CLOSE.toString()))
            .andExpect(jsonPath("$.pricePaid").value(DEFAULT_PRICE_PAID.toString()))
            .andExpect(jsonPath("$.changeinPercent").value(DEFAULT_CHANGEIN_PERCENT.toString()))
            .andExpect(jsonPath("$.priceSales").value(DEFAULT_PRICE_SALES.toString()))
            .andExpect(jsonPath("$.priceBook").value(DEFAULT_PRICE_BOOK.toString()))
            .andExpect(jsonPath("$.exDividendDate").value(DEFAULT_EX_DIVIDEND_DATE.toString()))
            .andExpect(jsonPath("$.pERatio").value(DEFAULT_P_E_RATIO.toString()))
            .andExpect(jsonPath("$.dividendPayDate").value(DEFAULT_DIVIDEND_PAY_DATE.toString()))
            .andExpect(jsonPath("$.pERatioRealtime").value(DEFAULT_P_E_RATIO_REALTIME.toString()))
            .andExpect(jsonPath("$.pEGRatio").value(DEFAULT_P_E_G_RATIO.toString()))
            .andExpect(jsonPath("$.priceEPSEstimateCurrentYear").value(DEFAULT_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR.toString()))
            .andExpect(jsonPath("$.priceEPSEstimateNextYear").value(DEFAULT_PRICE_E_P_S_ESTIMATE_NEXT_YEAR.toString()))
            .andExpect(jsonPath("$.symbol").value(DEFAULT_SYMBOL.toString()))
            .andExpect(jsonPath("$.sharesOwned").value(DEFAULT_SHARES_OWNED.toString()))
            .andExpect(jsonPath("$.shortRatio").value(DEFAULT_SHORT_RATIO.toString()))
            .andExpect(jsonPath("$.lastTradeTime").value(DEFAULT_LAST_TRADE_TIME.toString()))
            .andExpect(jsonPath("$.tickerTrend").value(DEFAULT_TICKER_TREND.toString()))
            .andExpect(jsonPath("$.oneyrTargetPrice").value(DEFAULT_ONEYR_TARGET_PRICE.toString()))
            .andExpect(jsonPath("$.volume").value(DEFAULT_VOLUME.toString()))
            .andExpect(jsonPath("$.holdingsValue").value(DEFAULT_HOLDINGS_VALUE.toString()))
            .andExpect(jsonPath("$.holdingsValueRealtime").value(DEFAULT_HOLDINGS_VALUE_REALTIME.toString()))
            .andExpect(jsonPath("$.yearRange").value(DEFAULT_YEAR_RANGE.toString()))
            .andExpect(jsonPath("$.daysValueChange").value(DEFAULT_DAYS_VALUE_CHANGE.toString()))
            .andExpect(jsonPath("$.daysValueChangeRealtime").value(DEFAULT_DAYS_VALUE_CHANGE_REALTIME.toString()))
            .andExpect(jsonPath("$.stockExchange").value(DEFAULT_STOCK_EXCHANGE.toString()))
            .andExpect(jsonPath("$.dividendYield").value(DEFAULT_DIVIDEND_YIELD.toString()))
            .andExpect(jsonPath("$.percentChange").value(DEFAULT_PERCENT_CHANGE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingQuoteEvent() throws Exception {
        // Get the quoteEvent
        restQuoteEventMockMvc.perform(get("/api/quoteEvents/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateQuoteEvent() throws Exception {
        // Initialize the database
        quoteEventRepository.saveAndFlush(quoteEvent);

		int databaseSizeBeforeUpdate = quoteEventRepository.findAll().size();

        // Update the quoteEvent
        quoteEvent.setAsk(UPDATED_ASK);
        quoteEvent.setAverageDailyVolume(UPDATED_AVERAGE_DAILY_VOLUME);
        quoteEvent.setBid(UPDATED_BID);
        quoteEvent.setAskRealtime(UPDATED_ASK_REALTIME);
        quoteEvent.setBidRealtime(UPDATED_BID_REALTIME);
        quoteEvent.setBookValue(UPDATED_BOOK_VALUE);
        quoteEvent.setChange_PercentChange(UPDATED_CHANGE_PERCENT_CHANGE);
        quoteEvent.setChange(UPDATED_CHANGE);
        quoteEvent.setCommission(UPDATED_COMMISSION);
        quoteEvent.setCurrency(UPDATED_CURRENCY);
        quoteEvent.setChangeRealtime(UPDATED_CHANGE_REALTIME);
        quoteEvent.setAfterHoursChangeRealtime(UPDATED_AFTER_HOURS_CHANGE_REALTIME);
        quoteEvent.setDividendShare(UPDATED_DIVIDEND_SHARE);
        quoteEvent.setLastTradeDate(UPDATED_LAST_TRADE_DATE);
        quoteEvent.setTradeDate(UPDATED_TRADE_DATE);
        quoteEvent.setEarningsShare(UPDATED_EARNINGS_SHARE);
        quoteEvent.setErrorIndicationreturnedforsymbolchangedinvalid(UPDATED_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID);
        quoteEvent.setEPSEstimateCurrentYear(UPDATED_E_P_S_ESTIMATE_CURRENT_YEAR);
        quoteEvent.setEPSEstimateNextYear(UPDATED_E_P_S_ESTIMATE_NEXT_YEAR);
        quoteEvent.setEPSEstimateNextQuarter(UPDATED_E_P_S_ESTIMATE_NEXT_QUARTER);
        quoteEvent.setDaysLow(UPDATED_DAYS_LOW);
        quoteEvent.setDaysHigh(UPDATED_DAYS_HIGH);
        quoteEvent.setYearLow(UPDATED_YEAR_LOW);
        quoteEvent.setYearHigh(UPDATED_YEAR_HIGH);
        quoteEvent.setHoldingsGainPercent(UPDATED_HOLDINGS_GAIN_PERCENT);
        quoteEvent.setAnnualizedGain(UPDATED_ANNUALIZED_GAIN);
        quoteEvent.setHoldingsGain(UPDATED_HOLDINGS_GAIN);
        quoteEvent.setHoldingsGainPercentRealtime(UPDATED_HOLDINGS_GAIN_PERCENT_REALTIME);
        quoteEvent.setHoldingsGainRealtime(UPDATED_HOLDINGS_GAIN_REALTIME);
        quoteEvent.setMoreInfo(UPDATED_MORE_INFO);
        quoteEvent.setOrderBookRealtime(UPDATED_ORDER_BOOK_REALTIME);
        quoteEvent.setMarketCapitalization(UPDATED_MARKET_CAPITALIZATION);
        quoteEvent.setMarketCapRealtime(UPDATED_MARKET_CAP_REALTIME);
        quoteEvent.setEBITDA(UPDATED_EBITDA);
        quoteEvent.setChangeFromYearLow(UPDATED_CHANGE_FROM_YEAR_LOW);
        quoteEvent.setPercentChangeFromYearLow(UPDATED_PERCENT_CHANGE_FROM_YEAR_LOW);
        quoteEvent.setLastTradeRealtimeWithTime(UPDATED_LAST_TRADE_REALTIME_WITH_TIME);
        quoteEvent.setChangePercentRealtime(UPDATED_CHANGE_PERCENT_REALTIME);
        quoteEvent.setChangeFromYearHigh(UPDATED_CHANGE_FROM_YEAR_HIGH);
        quoteEvent.setPercebtChangeFromYearHigh(UPDATED_PERCEBT_CHANGE_FROM_YEAR_HIGH);
        quoteEvent.setLastTradeWithTime(UPDATED_LAST_TRADE_WITH_TIME);
        quoteEvent.setLastTradePriceOnly(UPDATED_LAST_TRADE_PRICE_ONLY);
        quoteEvent.setHighLimit(UPDATED_HIGH_LIMIT);
        quoteEvent.setLowLimit(UPDATED_LOW_LIMIT);
        quoteEvent.setDaysRange(UPDATED_DAYS_RANGE);
        quoteEvent.setDaysRangeRealtime(UPDATED_DAYS_RANGE_REALTIME);
        quoteEvent.setFiftydayMovingAverage(UPDATED_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setTwoHundreddayMovingAverage(UPDATED_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setChangeFromTwoHundreddayMovingAverage(UPDATED_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setPercentChangeFromTwoHundreddayMovingAverage(UPDATED_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        quoteEvent.setChangeFromFiftydayMovingAverage(UPDATED_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setPercentChangeFromFiftydayMovingAverage(UPDATED_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        quoteEvent.setName(UPDATED_NAME);
        quoteEvent.setNotes(UPDATED_NOTES);
        quoteEvent.setOpen(UPDATED_OPEN);
        quoteEvent.setPreviousClose(UPDATED_PREVIOUS_CLOSE);
        quoteEvent.setPricePaid(UPDATED_PRICE_PAID);
        quoteEvent.setChangeinPercent(UPDATED_CHANGEIN_PERCENT);
        quoteEvent.setPriceSales(UPDATED_PRICE_SALES);
        quoteEvent.setPriceBook(UPDATED_PRICE_BOOK);
        quoteEvent.setExDividendDate(UPDATED_EX_DIVIDEND_DATE);
        quoteEvent.setPERatio(UPDATED_P_E_RATIO);
        quoteEvent.setDividendPayDate(UPDATED_DIVIDEND_PAY_DATE);
        quoteEvent.setPERatioRealtime(UPDATED_P_E_RATIO_REALTIME);
        quoteEvent.setPEGRatio(UPDATED_P_E_G_RATIO);
        quoteEvent.setPriceEPSEstimateCurrentYear(UPDATED_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR);
        quoteEvent.setPriceEPSEstimateNextYear(UPDATED_PRICE_E_P_S_ESTIMATE_NEXT_YEAR);
        quoteEvent.setSymbol(UPDATED_SYMBOL);
        quoteEvent.setSharesOwned(UPDATED_SHARES_OWNED);
        quoteEvent.setShortRatio(UPDATED_SHORT_RATIO);
        quoteEvent.setLastTradeTime(UPDATED_LAST_TRADE_TIME);
        quoteEvent.setTickerTrend(UPDATED_TICKER_TREND);
        quoteEvent.setOneyrTargetPrice(UPDATED_ONEYR_TARGET_PRICE);
        quoteEvent.setVolume(UPDATED_VOLUME);
        quoteEvent.setHoldingsValue(UPDATED_HOLDINGS_VALUE);
        quoteEvent.setHoldingsValueRealtime(UPDATED_HOLDINGS_VALUE_REALTIME);
        quoteEvent.setYearRange(UPDATED_YEAR_RANGE);
        quoteEvent.setDaysValueChange(UPDATED_DAYS_VALUE_CHANGE);
        quoteEvent.setDaysValueChangeRealtime(UPDATED_DAYS_VALUE_CHANGE_REALTIME);
        quoteEvent.setStockExchange(UPDATED_STOCK_EXCHANGE);
        quoteEvent.setDividendYield(UPDATED_DIVIDEND_YIELD);
        quoteEvent.setPercentChange(UPDATED_PERCENT_CHANGE);
        restQuoteEventMockMvc.perform(put("/api/quoteEvents")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(quoteEvent)))
                .andExpect(status().isOk());

        // Validate the QuoteEvent in the database
        List<QuoteEvent> quoteEvents = quoteEventRepository.findAll();
        assertThat(quoteEvents).hasSize(databaseSizeBeforeUpdate);
        QuoteEvent testQuoteEvent = quoteEvents.get(quoteEvents.size() - 1);
        assertThat(testQuoteEvent.getAsk()).isEqualTo(UPDATED_ASK);
        assertThat(testQuoteEvent.getAverageDailyVolume()).isEqualTo(UPDATED_AVERAGE_DAILY_VOLUME);
        assertThat(testQuoteEvent.getBid()).isEqualTo(UPDATED_BID);
        assertThat(testQuoteEvent.getAskRealtime()).isEqualTo(UPDATED_ASK_REALTIME);
        assertThat(testQuoteEvent.getBidRealtime()).isEqualTo(UPDATED_BID_REALTIME);
        assertThat(testQuoteEvent.getBookValue()).isEqualTo(UPDATED_BOOK_VALUE);
        assertThat(testQuoteEvent.getChange_PercentChange()).isEqualTo(UPDATED_CHANGE_PERCENT_CHANGE);
        assertThat(testQuoteEvent.getChange()).isEqualTo(UPDATED_CHANGE);
        assertThat(testQuoteEvent.getCommission()).isEqualTo(UPDATED_COMMISSION);
        assertThat(testQuoteEvent.getCurrency()).isEqualTo(UPDATED_CURRENCY);
        assertThat(testQuoteEvent.getChangeRealtime()).isEqualTo(UPDATED_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getAfterHoursChangeRealtime()).isEqualTo(UPDATED_AFTER_HOURS_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getDividendShare()).isEqualTo(UPDATED_DIVIDEND_SHARE);
        assertThat(testQuoteEvent.getLastTradeDate()).isEqualTo(UPDATED_LAST_TRADE_DATE);
        assertThat(testQuoteEvent.getTradeDate()).isEqualTo(UPDATED_TRADE_DATE);
        assertThat(testQuoteEvent.getEarningsShare()).isEqualTo(UPDATED_EARNINGS_SHARE);
        assertThat(testQuoteEvent.getErrorIndicationreturnedforsymbolchangedinvalid()).isEqualTo(UPDATED_ERROR_INDICATIONRETURNEDFORSYMBOLCHANGEDINVALID);
        assertThat(testQuoteEvent.getEPSEstimateCurrentYear()).isEqualTo(UPDATED_E_P_S_ESTIMATE_CURRENT_YEAR);
        assertThat(testQuoteEvent.getEPSEstimateNextYear()).isEqualTo(UPDATED_E_P_S_ESTIMATE_NEXT_YEAR);
        assertThat(testQuoteEvent.getEPSEstimateNextQuarter()).isEqualTo(UPDATED_E_P_S_ESTIMATE_NEXT_QUARTER);
        assertThat(testQuoteEvent.getDaysLow()).isEqualTo(UPDATED_DAYS_LOW);
        assertThat(testQuoteEvent.getDaysHigh()).isEqualTo(UPDATED_DAYS_HIGH);
        assertThat(testQuoteEvent.getYearLow()).isEqualTo(UPDATED_YEAR_LOW);
        assertThat(testQuoteEvent.getYearHigh()).isEqualTo(UPDATED_YEAR_HIGH);
        assertThat(testQuoteEvent.getHoldingsGainPercent()).isEqualTo(UPDATED_HOLDINGS_GAIN_PERCENT);
        assertThat(testQuoteEvent.getAnnualizedGain()).isEqualTo(UPDATED_ANNUALIZED_GAIN);
        assertThat(testQuoteEvent.getHoldingsGain()).isEqualTo(UPDATED_HOLDINGS_GAIN);
        assertThat(testQuoteEvent.getHoldingsGainPercentRealtime()).isEqualTo(UPDATED_HOLDINGS_GAIN_PERCENT_REALTIME);
        assertThat(testQuoteEvent.getHoldingsGainRealtime()).isEqualTo(UPDATED_HOLDINGS_GAIN_REALTIME);
        assertThat(testQuoteEvent.getMoreInfo()).isEqualTo(UPDATED_MORE_INFO);
        assertThat(testQuoteEvent.getOrderBookRealtime()).isEqualTo(UPDATED_ORDER_BOOK_REALTIME);
        assertThat(testQuoteEvent.getMarketCapitalization()).isEqualTo(UPDATED_MARKET_CAPITALIZATION);
        assertThat(testQuoteEvent.getMarketCapRealtime()).isEqualTo(UPDATED_MARKET_CAP_REALTIME);
        assertThat(testQuoteEvent.getEBITDA()).isEqualTo(UPDATED_EBITDA);
        assertThat(testQuoteEvent.getChangeFromYearLow()).isEqualTo(UPDATED_CHANGE_FROM_YEAR_LOW);
        assertThat(testQuoteEvent.getPercentChangeFromYearLow()).isEqualTo(UPDATED_PERCENT_CHANGE_FROM_YEAR_LOW);
        assertThat(testQuoteEvent.getLastTradeRealtimeWithTime()).isEqualTo(UPDATED_LAST_TRADE_REALTIME_WITH_TIME);
        assertThat(testQuoteEvent.getChangePercentRealtime()).isEqualTo(UPDATED_CHANGE_PERCENT_REALTIME);
        assertThat(testQuoteEvent.getChangeFromYearHigh()).isEqualTo(UPDATED_CHANGE_FROM_YEAR_HIGH);
        assertThat(testQuoteEvent.getPercebtChangeFromYearHigh()).isEqualTo(UPDATED_PERCEBT_CHANGE_FROM_YEAR_HIGH);
        assertThat(testQuoteEvent.getLastTradeWithTime()).isEqualTo(UPDATED_LAST_TRADE_WITH_TIME);
        assertThat(testQuoteEvent.getLastTradePriceOnly()).isEqualTo(UPDATED_LAST_TRADE_PRICE_ONLY);
        assertThat(testQuoteEvent.getHighLimit()).isEqualTo(UPDATED_HIGH_LIMIT);
        assertThat(testQuoteEvent.getLowLimit()).isEqualTo(UPDATED_LOW_LIMIT);
        assertThat(testQuoteEvent.getDaysRange()).isEqualTo(UPDATED_DAYS_RANGE);
        assertThat(testQuoteEvent.getDaysRangeRealtime()).isEqualTo(UPDATED_DAYS_RANGE_REALTIME);
        assertThat(testQuoteEvent.getFiftydayMovingAverage()).isEqualTo(UPDATED_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getTwoHundreddayMovingAverage()).isEqualTo(UPDATED_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getChangeFromTwoHundreddayMovingAverage()).isEqualTo(UPDATED_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getPercentChangeFromTwoHundreddayMovingAverage()).isEqualTo(UPDATED_PERCENT_CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getChangeFromFiftydayMovingAverage()).isEqualTo(UPDATED_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getPercentChangeFromFiftydayMovingAverage()).isEqualTo(UPDATED_PERCENT_CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE);
        assertThat(testQuoteEvent.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testQuoteEvent.getNotes()).isEqualTo(UPDATED_NOTES);
        assertThat(testQuoteEvent.getOpen()).isEqualTo(UPDATED_OPEN);
        assertThat(testQuoteEvent.getPreviousClose()).isEqualTo(UPDATED_PREVIOUS_CLOSE);
        assertThat(testQuoteEvent.getPricePaid()).isEqualTo(UPDATED_PRICE_PAID);
        assertThat(testQuoteEvent.getChangeinPercent()).isEqualTo(UPDATED_CHANGEIN_PERCENT);
        assertThat(testQuoteEvent.getPriceSales()).isEqualTo(UPDATED_PRICE_SALES);
        assertThat(testQuoteEvent.getPriceBook()).isEqualTo(UPDATED_PRICE_BOOK);
        assertThat(testQuoteEvent.getExDividendDate()).isEqualTo(UPDATED_EX_DIVIDEND_DATE);
        assertThat(testQuoteEvent.getPERatio()).isEqualTo(UPDATED_P_E_RATIO);
        assertThat(testQuoteEvent.getDividendPayDate()).isEqualTo(UPDATED_DIVIDEND_PAY_DATE);
        assertThat(testQuoteEvent.getPERatioRealtime()).isEqualTo(UPDATED_P_E_RATIO_REALTIME);
        assertThat(testQuoteEvent.getPEGRatio()).isEqualTo(UPDATED_P_E_G_RATIO);
        assertThat(testQuoteEvent.getPriceEPSEstimateCurrentYear()).isEqualTo(UPDATED_PRICE_E_P_S_ESTIMATE_CURRENT_YEAR);
        assertThat(testQuoteEvent.getPriceEPSEstimateNextYear()).isEqualTo(UPDATED_PRICE_E_P_S_ESTIMATE_NEXT_YEAR);
        assertThat(testQuoteEvent.getSymbol()).isEqualTo(UPDATED_SYMBOL);
        assertThat(testQuoteEvent.getSharesOwned()).isEqualTo(UPDATED_SHARES_OWNED);
        assertThat(testQuoteEvent.getShortRatio()).isEqualTo(UPDATED_SHORT_RATIO);
        assertThat(testQuoteEvent.getLastTradeTime()).isEqualTo(UPDATED_LAST_TRADE_TIME);
        assertThat(testQuoteEvent.getTickerTrend()).isEqualTo(UPDATED_TICKER_TREND);
        assertThat(testQuoteEvent.getOneyrTargetPrice()).isEqualTo(UPDATED_ONEYR_TARGET_PRICE);
        assertThat(testQuoteEvent.getVolume()).isEqualTo(UPDATED_VOLUME);
        assertThat(testQuoteEvent.getHoldingsValue()).isEqualTo(UPDATED_HOLDINGS_VALUE);
        assertThat(testQuoteEvent.getHoldingsValueRealtime()).isEqualTo(UPDATED_HOLDINGS_VALUE_REALTIME);
        assertThat(testQuoteEvent.getYearRange()).isEqualTo(UPDATED_YEAR_RANGE);
        assertThat(testQuoteEvent.getDaysValueChange()).isEqualTo(UPDATED_DAYS_VALUE_CHANGE);
        assertThat(testQuoteEvent.getDaysValueChangeRealtime()).isEqualTo(UPDATED_DAYS_VALUE_CHANGE_REALTIME);
        assertThat(testQuoteEvent.getStockExchange()).isEqualTo(UPDATED_STOCK_EXCHANGE);
        assertThat(testQuoteEvent.getDividendYield()).isEqualTo(UPDATED_DIVIDEND_YIELD);
        assertThat(testQuoteEvent.getPercentChange()).isEqualTo(UPDATED_PERCENT_CHANGE);
    }

    @Test
    @Transactional
    public void deleteQuoteEvent() throws Exception {
        // Initialize the database
        quoteEventRepository.saveAndFlush(quoteEvent);

		int databaseSizeBeforeDelete = quoteEventRepository.findAll().size();

        // Get the quoteEvent
        restQuoteEventMockMvc.perform(delete("/api/quoteEvents/{id}", quoteEvent.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<QuoteEvent> quoteEvents = quoteEventRepository.findAll();
        assertThat(quoteEvents).hasSize(databaseSizeBeforeDelete - 1);
    }
}
