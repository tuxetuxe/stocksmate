package com.twimba.fin.model;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class YahooQuoteEvent {

	@XStreamAsAttribute
	private String symbol;

	@XStreamAlias("Ask")
	private BigDecimal ask;

	@XStreamAlias("AverageDailyVolume")
	private String averageDailyVolume;

	@XStreamAlias("Bid")
	private BigDecimal bid;

	@XStreamAlias("AskRealtime")
	private BigDecimal askRealtime;

	@XStreamAlias("BidRealtime")
	private BigDecimal bidRealtime;

	@XStreamAlias("BookValue")
	private String bookValue;

	@XStreamAlias("Change_PercentChange")
	private String change_PercentChange;

	@XStreamAlias("Change")
	private BigDecimal change;

	@XStreamAlias("Commission")
	private String commission;

	@XStreamAlias("Currency")
	private String currency;

	@XStreamAlias("ChangeRealtime")
	private String changeRealtime;

	@XStreamAlias("AfterHoursChangeRealtime")
	private String afterHoursChangeRealtime;

	@XStreamAlias("DividendShare")
	private String dividendShare;

	@XStreamAlias("LastTradeDate")
	private String lastTradeDate;

	@XStreamAlias("TradeDate")
	private String tradeDate;

	@XStreamAlias("EarningsShare")
	private BigDecimal earningsShare;

	@XStreamAlias("ErrorIndicationreturnedforsymbolchangedinvalid")
	private String errorIndicationreturnedforsymbolchangedinvalid;

	@XStreamAlias("EPSEstimateCurrentYear")
	private BigDecimal epsEstimateCurrentYear;

	@XStreamAlias("EPSEstimateNextYear")
	private BigDecimal epsEstimateNextYear;

	@XStreamAlias("EPSEstimateNextQuarter")
	private BigDecimal epsEstimateNextQuarter;

	@XStreamAlias("DaysLow")
	private BigDecimal daysLow;

	@XStreamAlias("DaysHigh")
	private BigDecimal daysHigh;

	@XStreamAlias("YearLow")
	private BigDecimal yearLow;

	@XStreamAlias("YearHigh")
	private BigDecimal yearHigh;

	@XStreamAlias("HoldingsGainPercent")
	private String holdingsGainPercent;

	@XStreamAlias("AnnualizedGain")
	private String annualizedGain;

	@XStreamAlias("HoldingsGain")
	private String holdingsGain;

	@XStreamAlias("HoldingsGainPercentRealtime")
	private String holdingsGainPercentRealtime;

	@XStreamAlias("HoldingsGainRealtime")
	private String holdingsGainRealtime;

	@XStreamAlias("MoreInfo")
	private String moreInfo;

	@XStreamAlias("OrderBookRealtime")
	private String orderBookRealtime;

	@XStreamAlias("MarketCapitalization")
	private String marketCapitalization;

	@XStreamAlias("MarketCapRealtime")
	private String marketCapRealtime;

	@XStreamAlias("EBITDA")
	private String EBITDA;

	@XStreamAlias("ChangeFromYearLow")
	private BigDecimal changeFromYearLow;

	@XStreamAlias("PercentChangeFromYearLow")
	private String percentChangeFromYearLow;

	@XStreamAlias("LastTradeRealtimeWithTime")
	private String lastTradeRealtimeWithTime;

	@XStreamAlias("ChangePercentRealtime")
	private String changePercentRealtime;

	@XStreamAlias("ChangeFromYearHigh")
	private BigDecimal changeFromYearHigh;

	@XStreamAlias("PercebtChangeFromYearHigh")
	private String percebtChangeFromYearHigh;

	@XStreamAlias("LastTradeWithTime")
	private String lastTradeWithTime;

	@XStreamAlias("LastTradePriceOnly")
	private BigDecimal lastTradePriceOnly;

	@XStreamAlias("HighLimit")
	private String highLimit;

	@XStreamAlias("LowLimit")
	private String lowLimit;

	@XStreamAlias("DaysRange")
	private String daysRange;

	@XStreamAlias("DaysRangeRealtime")
	private String daysRangeRealtime;

	@XStreamAlias("FiftydayMovingAverage")
	private BigDecimal fiftydayMovingAverage;

	@XStreamAlias("TwoHundreddayMovingAverage")
	private BigDecimal twoHundreddayMovingAverage;

	@XStreamAlias("ChangeFromTwoHundreddayMovingAverage")
	private BigDecimal changeFromTwoHundreddayMovingAverage;

	@XStreamAlias("PercentChangeFromTwoHundreddayMovingAverage")
	private String percentChangeFromTwoHundreddayMovingAverage;

	@XStreamAlias("ChangeFromFiftydayMovingAverage")
	private BigDecimal changeFromFiftydayMovingAverage;

	@XStreamAlias("PercentChangeFromFiftydayMovingAverage")
	private String percentChangeFromFiftydayMovingAverage;

	@XStreamAlias("Name")
	private String name;

	@XStreamAlias("Notes")
	private String notes;

	@XStreamAlias("Open")
	private BigDecimal open;

	@XStreamAlias("PreviousClose")
	private BigDecimal previousClose;

	@XStreamAlias("PricePaid")
	private BigDecimal pricePaid;

	@XStreamAlias("ChangeinPercent")
	private String changeinPercent;

	@XStreamAlias("PriceSales")
	private BigDecimal priceSales;

	@XStreamAlias("PriceBook")
	private BigDecimal priceBook;

	@XStreamAlias("ExDividendDate")
	private String exDividendDate;

	@XStreamAlias("PERatio")
	private BigDecimal peRatio;

	@XStreamAlias("DividendPayDate")
	private String dividendPayDate;

	@XStreamAlias("PERatioRealtime")
	private String peRatioRealtime;

	@XStreamAlias("PEGRatio")
	private BigDecimal pegRatio;

	@XStreamAlias("PriceEPSEstimateCurrentYear")
	private BigDecimal priceEPSEstimateCurrentYear;

	@XStreamAlias("PriceEPSEstimateNextYear")
	private BigDecimal priceEPSEstimateNextYear;

	@XStreamAlias("SharesOwned")
	private String sharesOwned;

	@XStreamAlias("ShortRatio")
	private BigDecimal shortRatio;

	@XStreamAlias("LastTradeTime")
	private String lastTradeTime;

	@XStreamAlias("TickerTrend")
	private String tickerTrend;

	@XStreamAlias("OneyrTargetPrice")
	private BigDecimal oneyrTargetPrice;

	@XStreamAlias("Volume")
	private BigDecimal volume;

	@XStreamAlias("HoldingsValue")
	private String holdingsValue;

	@XStreamAlias("HoldingsValueRealtime")
	private String holdingsValueRealtime;

	@XStreamAlias("YearRange")
	private String yearRange;

	@XStreamAlias("DaysValueChange")
	private String daysValueChange;

	@XStreamAlias("DaysValueChangeRealtime")
	private String daysValueChangeRealtime;

	@XStreamAlias("StockExchange")
	private String stockExchange;

	@XStreamAlias("DividendYield")
	private String dividendYield;

	@XStreamAlias("PercentChange")
	private String percentChange;

	@Override
	public String toString() {
		return "YahooQuoteEvent [symbol=" + symbol + ", ask=" + ask + ", bid="
				+ bid + ", askRealtime=" + askRealtime + ", bidRealtime="
				+ bidRealtime + ", change=" + change + ", name=" + name + "]";
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAskRealtime() {
		return askRealtime;
	}

	public void setAskRealtime(BigDecimal askRealtime) {
		this.askRealtime = askRealtime;
	}

	public BigDecimal getBidRealtime() {
		return bidRealtime;
	}

	public void setBidRealtime(BigDecimal bidRealtime) {
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

	public BigDecimal getEarningsShare() {
		return earningsShare;
	}

	public void setEarningsShare(BigDecimal earningsShare) {
		this.earningsShare = earningsShare;
	}

	public String getErrorIndicationreturnedforsymbolchangedinvalid() {
		return errorIndicationreturnedforsymbolchangedinvalid;
	}

	public void setErrorIndicationreturnedforsymbolchangedinvalid(
			String errorIndicationreturnedforsymbolchangedinvalid) {
		this.errorIndicationreturnedforsymbolchangedinvalid = errorIndicationreturnedforsymbolchangedinvalid;
	}

	public BigDecimal getEpsEstimateCurrentYear() {
		return epsEstimateCurrentYear;
	}

	public void setEpsEstimateCurrentYear(BigDecimal epsEstimateCurrentYear) {
		this.epsEstimateCurrentYear = epsEstimateCurrentYear;
	}

	public BigDecimal getEpsEstimateNextYear() {
		return epsEstimateNextYear;
	}

	public void setEpsEstimateNextYear(BigDecimal epsEstimateNextYear) {
		this.epsEstimateNextYear = epsEstimateNextYear;
	}

	public BigDecimal getEpsEstimateNextQuarter() {
		return epsEstimateNextQuarter;
	}

	public void setEpsEstimateNextQuarter(BigDecimal epsEstimateNextQuarter) {
		this.epsEstimateNextQuarter = epsEstimateNextQuarter;
	}

	public BigDecimal getDaysLow() {
		return daysLow;
	}

	public void setDaysLow(BigDecimal daysLow) {
		this.daysLow = daysLow;
	}

	public BigDecimal getDaysHigh() {
		return daysHigh;
	}

	public void setDaysHigh(BigDecimal daysHigh) {
		this.daysHigh = daysHigh;
	}

	public BigDecimal getYearLow() {
		return yearLow;
	}

	public void setYearLow(BigDecimal yearLow) {
		this.yearLow = yearLow;
	}

	public BigDecimal getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(BigDecimal yearHigh) {
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
		return EBITDA;
	}

	public void setEBITDA(String eBITDA) {
		EBITDA = eBITDA;
	}

	public BigDecimal getChangeFromYearLow() {
		return changeFromYearLow;
	}

	public void setChangeFromYearLow(BigDecimal changeFromYearLow) {
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

	public BigDecimal getChangeFromYearHigh() {
		return changeFromYearHigh;
	}

	public void setChangeFromYearHigh(BigDecimal changeFromYearHigh) {
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

	public BigDecimal getLastTradePriceOnly() {
		return lastTradePriceOnly;
	}

	public void setLastTradePriceOnly(BigDecimal lastTradePriceOnly) {
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

	public BigDecimal getFiftydayMovingAverage() {
		return fiftydayMovingAverage;
	}

	public void setFiftydayMovingAverage(BigDecimal fiftydayMovingAverage) {
		this.fiftydayMovingAverage = fiftydayMovingAverage;
	}

	public BigDecimal getTwoHundreddayMovingAverage() {
		return twoHundreddayMovingAverage;
	}

	public void setTwoHundreddayMovingAverage(BigDecimal twoHundreddayMovingAverage) {
		this.twoHundreddayMovingAverage = twoHundreddayMovingAverage;
	}

	public BigDecimal getChangeFromTwoHundreddayMovingAverage() {
		return changeFromTwoHundreddayMovingAverage;
	}

	public void setChangeFromTwoHundreddayMovingAverage(
			BigDecimal changeFromTwoHundreddayMovingAverage) {
		this.changeFromTwoHundreddayMovingAverage = changeFromTwoHundreddayMovingAverage;
	}

	public String getPercentChangeFromTwoHundreddayMovingAverage() {
		return percentChangeFromTwoHundreddayMovingAverage;
	}

	public void setPercentChangeFromTwoHundreddayMovingAverage(
			String percentChangeFromTwoHundreddayMovingAverage) {
		this.percentChangeFromTwoHundreddayMovingAverage = percentChangeFromTwoHundreddayMovingAverage;
	}

	public BigDecimal getChangeFromFiftydayMovingAverage() {
		return changeFromFiftydayMovingAverage;
	}

	public void setChangeFromFiftydayMovingAverage(
			BigDecimal changeFromFiftydayMovingAverage) {
		this.changeFromFiftydayMovingAverage = changeFromFiftydayMovingAverage;
	}

	public String getPercentChangeFromFiftydayMovingAverage() {
		return percentChangeFromFiftydayMovingAverage;
	}

	public void setPercentChangeFromFiftydayMovingAverage(
			String percentChangeFromFiftydayMovingAverage) {
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

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(BigDecimal previousClose) {
		this.previousClose = previousClose;
	}

	public BigDecimal getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(BigDecimal pricePaid) {
		this.pricePaid = pricePaid;
	}

	public String getChangeinPercent() {
		return changeinPercent;
	}

	public void setChangeinPercent(String changeinPercent) {
		this.changeinPercent = changeinPercent;
	}

	public BigDecimal getPriceSales() {
		return priceSales;
	}

	public void setPriceSales(BigDecimal priceSales) {
		this.priceSales = priceSales;
	}

	public BigDecimal getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(BigDecimal priceBook) {
		this.priceBook = priceBook;
	}

	public String getExDividendDate() {
		return exDividendDate;
	}

	public void setExDividendDate(String exDividendDate) {
		this.exDividendDate = exDividendDate;
	}

	public BigDecimal getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(BigDecimal peRatio) {
		this.peRatio = peRatio;
	}

	public String getDividendPayDate() {
		return dividendPayDate;
	}

	public void setDividendPayDate(String dividendPayDate) {
		this.dividendPayDate = dividendPayDate;
	}

	public String getPeRatioRealtime() {
		return peRatioRealtime;
	}

	public void setPeRatioRealtime(String peRatioRealtime) {
		this.peRatioRealtime = peRatioRealtime;
	}

	public BigDecimal getPegRatio() {
		return pegRatio;
	}

	public void setPegRatio(BigDecimal pegRatio) {
		this.pegRatio = pegRatio;
	}

	public BigDecimal getPriceEPSEstimateCurrentYear() {
		return priceEPSEstimateCurrentYear;
	}

	public void setPriceEPSEstimateCurrentYear(
			BigDecimal priceEPSEstimateCurrentYear) {
		this.priceEPSEstimateCurrentYear = priceEPSEstimateCurrentYear;
	}

	public BigDecimal getPriceEPSEstimateNextYear() {
		return priceEPSEstimateNextYear;
	}

	public void setPriceEPSEstimateNextYear(BigDecimal priceEPSEstimateNextYear) {
		this.priceEPSEstimateNextYear = priceEPSEstimateNextYear;
	}

	public String getSharesOwned() {
		return sharesOwned;
	}

	public void setSharesOwned(String sharesOwned) {
		this.sharesOwned = sharesOwned;
	}

	public BigDecimal getShortRatio() {
		return shortRatio;
	}

	public void setShortRatio(BigDecimal shortRatio) {
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

	public BigDecimal getOneyrTargetPrice() {
		return oneyrTargetPrice;
	}

	public void setOneyrTargetPrice(BigDecimal oneyrTargetPrice) {
		this.oneyrTargetPrice = oneyrTargetPrice;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
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

}
