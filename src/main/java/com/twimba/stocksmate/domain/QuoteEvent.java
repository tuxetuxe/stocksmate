package com.twimba.stocksmate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A QuoteEvent.
 */
@Entity
@Table(name = "QUOTEEVENT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName="quoteevent")
public class QuoteEvent implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ask", precision=10, scale=2)
    private BigDecimal ask;

    @Column(name = "average_daily_volume")
    private String averageDailyVolume;

    @Column(name = "bid")
    private String bid;

    @Column(name = "ask_realtime")
    private String askRealtime;

    @Column(name = "bid_realtime")
    private String bidRealtime;

    @Column(name = "book_value")
    private String bookValue;

    @Column(name = "change_percent_change")
    private String change_PercentChange;

    @Column(name = "change", precision=10, scale=2)
    private BigDecimal change;

    @Column(name = "commission")
    private String commission;

    @Column(name = "currency")
    private String currency;

    @Column(name = "change_realtime")
    private String changeRealtime;

    @Column(name = "after_hours_change_realtime")
    private String afterHoursChangeRealtime;

    @Column(name = "dividend_share")
    private String dividendShare;

    @Column(name = "last_trade_date")
    private String lastTradeDate;

    @Column(name = "trade_date")
    private String tradeDate;

    @Column(name = "earnings_share")
    private String earningsShare;

    @Column(name = "error_indicationreturnedforsymbolchangedinvalid")
    private String errorIndicationreturnedforsymbolchangedinvalid;

    @Column(name = "e_p_s_estimate_current_year")
    private String ePSEstimateCurrentYear;

    @Column(name = "e_p_s_estimate_next_year")
    private String ePSEstimateNextYear;

    @Column(name = "e_p_s_estimate_next_quarter")
    private String ePSEstimateNextQuarter;

    @Column(name = "days_low")
    private String daysLow;

    @Column(name = "days_high")
    private String daysHigh;

    @Column(name = "year_low")
    private String yearLow;

    @Column(name = "year_high")
    private String yearHigh;

    @Column(name = "holdings_gain_percent")
    private String holdingsGainPercent;

    @Column(name = "annualized_gain")
    private String annualizedGain;

    @Column(name = "holdings_gain")
    private String holdingsGain;

    @Column(name = "holdings_gain_percent_realtime")
    private String holdingsGainPercentRealtime;

    @Column(name = "holdings_gain_realtime")
    private String holdingsGainRealtime;

    @Column(name = "more_info")
    private String moreInfo;

    @Column(name = "order_book_realtime")
    private String orderBookRealtime;

    @Column(name = "market_capitalization")
    private String marketCapitalization;

    @Column(name = "market_cap_realtime")
    private String marketCapRealtime;

    @Column(name = "ebitda")
    private String eBITDA;

    @Column(name = "change_from_year_low")
    private String changeFromYearLow;

    @Column(name = "percent_change_from_year_low")
    private String percentChangeFromYearLow;

    @Column(name = "last_trade_realtime_with_time")
    private String lastTradeRealtimeWithTime;

    @Column(name = "change_percent_realtime")
    private String changePercentRealtime;

    @Column(name = "change_from_year_high")
    private String changeFromYearHigh;

    @Column(name = "percebt_change_from_year_high")
    private String percebtChangeFromYearHigh;

    @Column(name = "last_trade_with_time")
    private String lastTradeWithTime;

    @Column(name = "last_trade_price_only")
    private String lastTradePriceOnly;

    @Column(name = "high_limit")
    private String highLimit;

    @Column(name = "low_limit")
    private String lowLimit;

    @Column(name = "days_range")
    private String daysRange;

    @Column(name = "days_range_realtime")
    private String daysRangeRealtime;

    @Column(name = "fiftyday_moving_average")
    private String fiftydayMovingAverage;

    @Column(name = "two_hundredday_moving_average")
    private String twoHundreddayMovingAverage;

    @Column(name = "change_from_two_hundredday_moving_average")
    private String changeFromTwoHundreddayMovingAverage;

    @Column(name = "percent_change_from_two_hundredday_moving_average")
    private String percentChangeFromTwoHundreddayMovingAverage;

    @Column(name = "change_from_fiftyday_moving_average")
    private String changeFromFiftydayMovingAverage;

    @Column(name = "percent_change_from_fiftyday_moving_average")
    private String percentChangeFromFiftydayMovingAverage;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @Column(name = "open")
    private String open;

    @Column(name = "previous_close")
    private String previousClose;

    @Column(name = "price_paid")
    private String pricePaid;

    @Column(name = "changein_percent")
    private String changeinPercent;

    @Column(name = "price_sales")
    private String priceSales;

    @Column(name = "price_book")
    private String priceBook;

    @Column(name = "ex_dividend_date")
    private String exDividendDate;

    @Column(name = "p_e_ratio")
    private String pERatio;

    @Column(name = "dividend_pay_date")
    private String dividendPayDate;

    @Column(name = "p_e_ratio_realtime")
    private String pERatioRealtime;

    @Column(name = "p_e_g_ratio")
    private String pEGRatio;

    @Column(name = "price_e_p_s_estimate_current_year")
    private String priceEPSEstimateCurrentYear;

    @Column(name = "price_e_p_s_estimate_next_year")
    private String priceEPSEstimateNextYear;

    @NotNull
    @Column(name = "symbol", nullable = false)
    @XStreamAsAttribute
    private String symbol;

    @Column(name = "shares_owned")
    private String sharesOwned;

    @Column(name = "short_ratio")
    private String shortRatio;

    @Column(name = "last_trade_time")
    private String lastTradeTime;

    @Column(name = "ticker_trend")
    private String tickerTrend;

    @Column(name = "oneyr_target_price")
    private String oneyrTargetPrice;

    @Column(name = "volume")
    private String volume;

    @Column(name = "holdings_value")
    private String holdingsValue;

    @Column(name = "holdings_value_realtime")
    private String holdingsValueRealtime;

    @Column(name = "year_range")
    private String yearRange;

    @Column(name = "days_value_change")
    private String daysValueChange;

    @Column(name = "days_value_change_realtime")
    private String daysValueChangeRealtime;

    @Column(name = "stock_exchange")
    private String stockExchange;

    @Column(name = "dividend_yield")
    private String dividendYield;

    @Column(name = "percent_change")
    private String percentChange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public String getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(String averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAskRealtime() {
        return askRealtime;
    }

    public void setAskRealtime(String askRealtime) {
        this.askRealtime = askRealtime;
    }

    public String getBidRealtime() {
        return bidRealtime;
    }

    public void setBidRealtime(String bidRealtime) {
        this.bidRealtime = bidRealtime;
    }

    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    public String getChange_PercentChange() {
        return change_PercentChange;
    }

    public void setChange_PercentChange(String change_PercentChange) {
        this.change_PercentChange = change_PercentChange;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getChangeRealtime() {
        return changeRealtime;
    }

    public void setChangeRealtime(String changeRealtime) {
        this.changeRealtime = changeRealtime;
    }

    public String getAfterHoursChangeRealtime() {
        return afterHoursChangeRealtime;
    }

    public void setAfterHoursChangeRealtime(String afterHoursChangeRealtime) {
        this.afterHoursChangeRealtime = afterHoursChangeRealtime;
    }

    public String getDividendShare() {
        return dividendShare;
    }

    public void setDividendShare(String dividendShare) {
        this.dividendShare = dividendShare;
    }

    public String getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(String lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getEarningsShare() {
        return earningsShare;
    }

    public void setEarningsShare(String earningsShare) {
        this.earningsShare = earningsShare;
    }

    public String getErrorIndicationreturnedforsymbolchangedinvalid() {
        return errorIndicationreturnedforsymbolchangedinvalid;
    }

    public void setErrorIndicationreturnedforsymbolchangedinvalid(String errorIndicationreturnedforsymbolchangedinvalid) {
        this.errorIndicationreturnedforsymbolchangedinvalid = errorIndicationreturnedforsymbolchangedinvalid;
    }

    public String getEPSEstimateCurrentYear() {
        return ePSEstimateCurrentYear;
    }

    public void setEPSEstimateCurrentYear(String ePSEstimateCurrentYear) {
        this.ePSEstimateCurrentYear = ePSEstimateCurrentYear;
    }

    public String getEPSEstimateNextYear() {
        return ePSEstimateNextYear;
    }

    public void setEPSEstimateNextYear(String ePSEstimateNextYear) {
        this.ePSEstimateNextYear = ePSEstimateNextYear;
    }

    public String getEPSEstimateNextQuarter() {
        return ePSEstimateNextQuarter;
    }

    public void setEPSEstimateNextQuarter(String ePSEstimateNextQuarter) {
        this.ePSEstimateNextQuarter = ePSEstimateNextQuarter;
    }

    public String getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(String daysLow) {
        this.daysLow = daysLow;
    }

    public String getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(String daysHigh) {
        this.daysHigh = daysHigh;
    }

    public String getYearLow() {
        return yearLow;
    }

    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }

    public String getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }

    public String getHoldingsGainPercent() {
        return holdingsGainPercent;
    }

    public void setHoldingsGainPercent(String holdingsGainPercent) {
        this.holdingsGainPercent = holdingsGainPercent;
    }

    public String getAnnualizedGain() {
        return annualizedGain;
    }

    public void setAnnualizedGain(String annualizedGain) {
        this.annualizedGain = annualizedGain;
    }

    public String getHoldingsGain() {
        return holdingsGain;
    }

    public void setHoldingsGain(String holdingsGain) {
        this.holdingsGain = holdingsGain;
    }

    public String getHoldingsGainPercentRealtime() {
        return holdingsGainPercentRealtime;
    }

    public void setHoldingsGainPercentRealtime(String holdingsGainPercentRealtime) {
        this.holdingsGainPercentRealtime = holdingsGainPercentRealtime;
    }

    public String getHoldingsGainRealtime() {
        return holdingsGainRealtime;
    }

    public void setHoldingsGainRealtime(String holdingsGainRealtime) {
        this.holdingsGainRealtime = holdingsGainRealtime;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getOrderBookRealtime() {
        return orderBookRealtime;
    }

    public void setOrderBookRealtime(String orderBookRealtime) {
        this.orderBookRealtime = orderBookRealtime;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public String getMarketCapRealtime() {
        return marketCapRealtime;
    }

    public void setMarketCapRealtime(String marketCapRealtime) {
        this.marketCapRealtime = marketCapRealtime;
    }

    public String getEBITDA() {
        return eBITDA;
    }

    public void setEBITDA(String eBITDA) {
        this.eBITDA = eBITDA;
    }

    public String getChangeFromYearLow() {
        return changeFromYearLow;
    }

    public void setChangeFromYearLow(String changeFromYearLow) {
        this.changeFromYearLow = changeFromYearLow;
    }

    public String getPercentChangeFromYearLow() {
        return percentChangeFromYearLow;
    }

    public void setPercentChangeFromYearLow(String percentChangeFromYearLow) {
        this.percentChangeFromYearLow = percentChangeFromYearLow;
    }

    public String getLastTradeRealtimeWithTime() {
        return lastTradeRealtimeWithTime;
    }

    public void setLastTradeRealtimeWithTime(String lastTradeRealtimeWithTime) {
        this.lastTradeRealtimeWithTime = lastTradeRealtimeWithTime;
    }

    public String getChangePercentRealtime() {
        return changePercentRealtime;
    }

    public void setChangePercentRealtime(String changePercentRealtime) {
        this.changePercentRealtime = changePercentRealtime;
    }

    public String getChangeFromYearHigh() {
        return changeFromYearHigh;
    }

    public void setChangeFromYearHigh(String changeFromYearHigh) {
        this.changeFromYearHigh = changeFromYearHigh;
    }

    public String getPercebtChangeFromYearHigh() {
        return percebtChangeFromYearHigh;
    }

    public void setPercebtChangeFromYearHigh(String percebtChangeFromYearHigh) {
        this.percebtChangeFromYearHigh = percebtChangeFromYearHigh;
    }

    public String getLastTradeWithTime() {
        return lastTradeWithTime;
    }

    public void setLastTradeWithTime(String lastTradeWithTime) {
        this.lastTradeWithTime = lastTradeWithTime;
    }

    public String getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public void setLastTradePriceOnly(String lastTradePriceOnly) {
        this.lastTradePriceOnly = lastTradePriceOnly;
    }

    public String getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(String highLimit) {
        this.highLimit = highLimit;
    }

    public String getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(String lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(String daysRange) {
        this.daysRange = daysRange;
    }

    public String getDaysRangeRealtime() {
        return daysRangeRealtime;
    }

    public void setDaysRangeRealtime(String daysRangeRealtime) {
        this.daysRangeRealtime = daysRangeRealtime;
    }

    public String getFiftydayMovingAverage() {
        return fiftydayMovingAverage;
    }

    public void setFiftydayMovingAverage(String fiftydayMovingAverage) {
        this.fiftydayMovingAverage = fiftydayMovingAverage;
    }

    public String getTwoHundreddayMovingAverage() {
        return twoHundreddayMovingAverage;
    }

    public void setTwoHundreddayMovingAverage(String twoHundreddayMovingAverage) {
        this.twoHundreddayMovingAverage = twoHundreddayMovingAverage;
    }

    public String getChangeFromTwoHundreddayMovingAverage() {
        return changeFromTwoHundreddayMovingAverage;
    }

    public void setChangeFromTwoHundreddayMovingAverage(String changeFromTwoHundreddayMovingAverage) {
        this.changeFromTwoHundreddayMovingAverage = changeFromTwoHundreddayMovingAverage;
    }

    public String getPercentChangeFromTwoHundreddayMovingAverage() {
        return percentChangeFromTwoHundreddayMovingAverage;
    }

    public void setPercentChangeFromTwoHundreddayMovingAverage(String percentChangeFromTwoHundreddayMovingAverage) {
        this.percentChangeFromTwoHundreddayMovingAverage = percentChangeFromTwoHundreddayMovingAverage;
    }

    public String getChangeFromFiftydayMovingAverage() {
        return changeFromFiftydayMovingAverage;
    }

    public void setChangeFromFiftydayMovingAverage(String changeFromFiftydayMovingAverage) {
        this.changeFromFiftydayMovingAverage = changeFromFiftydayMovingAverage;
    }

    public String getPercentChangeFromFiftydayMovingAverage() {
        return percentChangeFromFiftydayMovingAverage;
    }

    public void setPercentChangeFromFiftydayMovingAverage(String percentChangeFromFiftydayMovingAverage) {
        this.percentChangeFromFiftydayMovingAverage = percentChangeFromFiftydayMovingAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getChangeinPercent() {
        return changeinPercent;
    }

    public void setChangeinPercent(String changeinPercent) {
        this.changeinPercent = changeinPercent;
    }

    public String getPriceSales() {
        return priceSales;
    }

    public void setPriceSales(String priceSales) {
        this.priceSales = priceSales;
    }

    public String getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(String priceBook) {
        this.priceBook = priceBook;
    }

    public String getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(String exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public String getPERatio() {
        return pERatio;
    }

    public void setPERatio(String pERatio) {
        this.pERatio = pERatio;
    }

    public String getDividendPayDate() {
        return dividendPayDate;
    }

    public void setDividendPayDate(String dividendPayDate) {
        this.dividendPayDate = dividendPayDate;
    }

    public String getPERatioRealtime() {
        return pERatioRealtime;
    }

    public void setPERatioRealtime(String pERatioRealtime) {
        this.pERatioRealtime = pERatioRealtime;
    }

    public String getPEGRatio() {
        return pEGRatio;
    }

    public void setPEGRatio(String pEGRatio) {
        this.pEGRatio = pEGRatio;
    }

    public String getPriceEPSEstimateCurrentYear() {
        return priceEPSEstimateCurrentYear;
    }

    public void setPriceEPSEstimateCurrentYear(String priceEPSEstimateCurrentYear) {
        this.priceEPSEstimateCurrentYear = priceEPSEstimateCurrentYear;
    }

    public String getPriceEPSEstimateNextYear() {
        return priceEPSEstimateNextYear;
    }

    public void setPriceEPSEstimateNextYear(String priceEPSEstimateNextYear) {
        this.priceEPSEstimateNextYear = priceEPSEstimateNextYear;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSharesOwned() {
        return sharesOwned;
    }

    public void setSharesOwned(String sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    public String getShortRatio() {
        return shortRatio;
    }

    public void setShortRatio(String shortRatio) {
        this.shortRatio = shortRatio;
    }

    public String getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(String lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public String getTickerTrend() {
        return tickerTrend;
    }

    public void setTickerTrend(String tickerTrend) {
        this.tickerTrend = tickerTrend;
    }

    public String getOneyrTargetPrice() {
        return oneyrTargetPrice;
    }

    public void setOneyrTargetPrice(String oneyrTargetPrice) {
        this.oneyrTargetPrice = oneyrTargetPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getHoldingsValue() {
        return holdingsValue;
    }

    public void setHoldingsValue(String holdingsValue) {
        this.holdingsValue = holdingsValue;
    }

    public String getHoldingsValueRealtime() {
        return holdingsValueRealtime;
    }

    public void setHoldingsValueRealtime(String holdingsValueRealtime) {
        this.holdingsValueRealtime = holdingsValueRealtime;
    }

    public String getYearRange() {
        return yearRange;
    }

    public void setYearRange(String yearRange) {
        this.yearRange = yearRange;
    }

    public String getDaysValueChange() {
        return daysValueChange;
    }

    public void setDaysValueChange(String daysValueChange) {
        this.daysValueChange = daysValueChange;
    }

    public String getDaysValueChangeRealtime() {
        return daysValueChangeRealtime;
    }

    public void setDaysValueChangeRealtime(String daysValueChangeRealtime) {
        this.daysValueChangeRealtime = daysValueChangeRealtime;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QuoteEvent quoteEvent = (QuoteEvent) o;

        if ( ! Objects.equals(id, quoteEvent.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "QuoteEvent{" +
                "id=" + id +
                ", ask='" + ask + "'" +
                ", averageDailyVolume='" + averageDailyVolume + "'" +
                ", bid='" + bid + "'" +
                ", askRealtime='" + askRealtime + "'" +
                ", bidRealtime='" + bidRealtime + "'" +
                ", bookValue='" + bookValue + "'" +
                ", change_PercentChange='" + change_PercentChange + "'" +
                ", change='" + change + "'" +
                ", commission='" + commission + "'" +
                ", currency='" + currency + "'" +
                ", changeRealtime='" + changeRealtime + "'" +
                ", afterHoursChangeRealtime='" + afterHoursChangeRealtime + "'" +
                ", dividendShare='" + dividendShare + "'" +
                ", lastTradeDate='" + lastTradeDate + "'" +
                ", tradeDate='" + tradeDate + "'" +
                ", earningsShare='" + earningsShare + "'" +
                ", errorIndicationreturnedforsymbolchangedinvalid='" + errorIndicationreturnedforsymbolchangedinvalid + "'" +
                ", ePSEstimateCurrentYear='" + ePSEstimateCurrentYear + "'" +
                ", ePSEstimateNextYear='" + ePSEstimateNextYear + "'" +
                ", ePSEstimateNextQuarter='" + ePSEstimateNextQuarter + "'" +
                ", daysLow='" + daysLow + "'" +
                ", daysHigh='" + daysHigh + "'" +
                ", yearLow='" + yearLow + "'" +
                ", yearHigh='" + yearHigh + "'" +
                ", holdingsGainPercent='" + holdingsGainPercent + "'" +
                ", annualizedGain='" + annualizedGain + "'" +
                ", holdingsGain='" + holdingsGain + "'" +
                ", holdingsGainPercentRealtime='" + holdingsGainPercentRealtime + "'" +
                ", holdingsGainRealtime='" + holdingsGainRealtime + "'" +
                ", moreInfo='" + moreInfo + "'" +
                ", orderBookRealtime='" + orderBookRealtime + "'" +
                ", marketCapitalization='" + marketCapitalization + "'" +
                ", marketCapRealtime='" + marketCapRealtime + "'" +
                ", eBITDA='" + eBITDA + "'" +
                ", changeFromYearLow='" + changeFromYearLow + "'" +
                ", percentChangeFromYearLow='" + percentChangeFromYearLow + "'" +
                ", lastTradeRealtimeWithTime='" + lastTradeRealtimeWithTime + "'" +
                ", changePercentRealtime='" + changePercentRealtime + "'" +
                ", changeFromYearHigh='" + changeFromYearHigh + "'" +
                ", percebtChangeFromYearHigh='" + percebtChangeFromYearHigh + "'" +
                ", lastTradeWithTime='" + lastTradeWithTime + "'" +
                ", lastTradePriceOnly='" + lastTradePriceOnly + "'" +
                ", highLimit='" + highLimit + "'" +
                ", lowLimit='" + lowLimit + "'" +
                ", daysRange='" + daysRange + "'" +
                ", daysRangeRealtime='" + daysRangeRealtime + "'" +
                ", fiftydayMovingAverage='" + fiftydayMovingAverage + "'" +
                ", twoHundreddayMovingAverage='" + twoHundreddayMovingAverage + "'" +
                ", changeFromTwoHundreddayMovingAverage='" + changeFromTwoHundreddayMovingAverage + "'" +
                ", percentChangeFromTwoHundreddayMovingAverage='" + percentChangeFromTwoHundreddayMovingAverage + "'" +
                ", changeFromFiftydayMovingAverage='" + changeFromFiftydayMovingAverage + "'" +
                ", percentChangeFromFiftydayMovingAverage='" + percentChangeFromFiftydayMovingAverage + "'" +
                ", name='" + name + "'" +
                ", notes='" + notes + "'" +
                ", open='" + open + "'" +
                ", previousClose='" + previousClose + "'" +
                ", pricePaid='" + pricePaid + "'" +
                ", changeinPercent='" + changeinPercent + "'" +
                ", priceSales='" + priceSales + "'" +
                ", priceBook='" + priceBook + "'" +
                ", exDividendDate='" + exDividendDate + "'" +
                ", pERatio='" + pERatio + "'" +
                ", dividendPayDate='" + dividendPayDate + "'" +
                ", pERatioRealtime='" + pERatioRealtime + "'" +
                ", pEGRatio='" + pEGRatio + "'" +
                ", priceEPSEstimateCurrentYear='" + priceEPSEstimateCurrentYear + "'" +
                ", priceEPSEstimateNextYear='" + priceEPSEstimateNextYear + "'" +
                ", symbol='" + symbol + "'" +
                ", sharesOwned='" + sharesOwned + "'" +
                ", shortRatio='" + shortRatio + "'" +
                ", lastTradeTime='" + lastTradeTime + "'" +
                ", tickerTrend='" + tickerTrend + "'" +
                ", oneyrTargetPrice='" + oneyrTargetPrice + "'" +
                ", volume='" + volume + "'" +
                ", holdingsValue='" + holdingsValue + "'" +
                ", holdingsValueRealtime='" + holdingsValueRealtime + "'" +
                ", yearRange='" + yearRange + "'" +
                ", daysValueChange='" + daysValueChange + "'" +
                ", daysValueChangeRealtime='" + daysValueChangeRealtime + "'" +
                ", stockExchange='" + stockExchange + "'" +
                ", dividendYield='" + dividendYield + "'" +
                ", percentChange='" + percentChange + "'" +
                '}';
    }
}
