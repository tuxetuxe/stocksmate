import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the QuoteEvent entity.
 */
class QuoteEventGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://127.0.0.1:8080"""

    val httpConf = http
        .baseURL(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connection("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "X-CSRF-TOKEN" -> "${csrf_token}"
    )

    val scn = scenario("Test the QuoteEvent entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        .check(headerRegex("Set-Cookie", "CSRF-TOKEN=(.*); [P,p]ath=/").saveAs("csrf_token")))
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authentication")
        .headers(headers_http_authenticated)
        .formParam("j_username", "admin")
        .formParam("j_password", "admin")
        .formParam("remember-me", "true")
        .formParam("submit", "Login"))
        .pause(1)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200))
        .check(headerRegex("Set-Cookie", "CSRF-TOKEN=(.*); [P,p]ath=/").saveAs("csrf_token")))
        .pause(10)
        .repeat(2) {
            exec(http("Get all quoteEvents")
            .get("/api/quoteEvents")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new quoteEvent")
            .put("/api/quoteEvents")
            .headers(headers_http_authenticated)
            .body(StringBody("""{"id":null, "ask":null, "averageDailyVolume":"SAMPLE_TEXT", "bid":"SAMPLE_TEXT", "askRealtime":"SAMPLE_TEXT", "bidRealtime":"SAMPLE_TEXT", "bookValue":"SAMPLE_TEXT", "change_PercentChange":"SAMPLE_TEXT", "change":null, "commission":"SAMPLE_TEXT", "currency":"SAMPLE_TEXT", "changeRealtime":"SAMPLE_TEXT", "afterHoursChangeRealtime":"SAMPLE_TEXT", "dividendShare":"SAMPLE_TEXT", "lastTradeDate":"SAMPLE_TEXT", "tradeDate":"SAMPLE_TEXT", "earningsShare":"SAMPLE_TEXT", "errorIndicationreturnedforsymbolchangedinvalid":"SAMPLE_TEXT", "ePSEstimateCurrentYear":"SAMPLE_TEXT", "ePSEstimateNextYear":"SAMPLE_TEXT", "ePSEstimateNextQuarter":"SAMPLE_TEXT", "daysLow":"SAMPLE_TEXT", "daysHigh":"SAMPLE_TEXT", "yearLow":"SAMPLE_TEXT", "yearHigh":"SAMPLE_TEXT", "holdingsGainPercent":"SAMPLE_TEXT", "annualizedGain":"SAMPLE_TEXT", "holdingsGain":"SAMPLE_TEXT", "holdingsGainPercentRealtime":"SAMPLE_TEXT", "holdingsGainRealtime":"SAMPLE_TEXT", "moreInfo":"SAMPLE_TEXT", "orderBookRealtime":"SAMPLE_TEXT", "marketCapitalization":"SAMPLE_TEXT", "marketCapRealtime":"SAMPLE_TEXT", "eBITDA":"SAMPLE_TEXT", "changeFromYearLow":"SAMPLE_TEXT", "percentChangeFromYearLow":"SAMPLE_TEXT", "lastTradeRealtimeWithTime":"SAMPLE_TEXT", "changePercentRealtime":"SAMPLE_TEXT", "changeFromYearHigh":"SAMPLE_TEXT", "percebtChangeFromYearHigh":"SAMPLE_TEXT", "lastTradeWithTime":"SAMPLE_TEXT", "lastTradePriceOnly":"SAMPLE_TEXT", "highLimit":"SAMPLE_TEXT", "lowLimit":"SAMPLE_TEXT", "daysRange":"SAMPLE_TEXT", "daysRangeRealtime":"SAMPLE_TEXT", "fiftydayMovingAverage":"SAMPLE_TEXT", "twoHundreddayMovingAverage":"SAMPLE_TEXT", "changeFromTwoHundreddayMovingAverage":"SAMPLE_TEXT", "percentChangeFromTwoHundreddayMovingAverage":"SAMPLE_TEXT", "changeFromFiftydayMovingAverage":"SAMPLE_TEXT", "percentChangeFromFiftydayMovingAverage":"SAMPLE_TEXT", "name":"SAMPLE_TEXT", "notes":"SAMPLE_TEXT", "open":"SAMPLE_TEXT", "previousClose":"SAMPLE_TEXT", "pricePaid":"SAMPLE_TEXT", "changeinPercent":"SAMPLE_TEXT", "priceSales":"SAMPLE_TEXT", "priceBook":"SAMPLE_TEXT", "exDividendDate":"SAMPLE_TEXT", "pERatio":"SAMPLE_TEXT", "dividendPayDate":"SAMPLE_TEXT", "pERatioRealtime":"SAMPLE_TEXT", "pEGRatio":"SAMPLE_TEXT", "priceEPSEstimateCurrentYear":"SAMPLE_TEXT", "priceEPSEstimateNextYear":"SAMPLE_TEXT", "symbol":"SAMPLE_TEXT", "sharesOwned":"SAMPLE_TEXT", "shortRatio":"SAMPLE_TEXT", "lastTradeTime":"SAMPLE_TEXT", "tickerTrend":"SAMPLE_TEXT", "oneyrTargetPrice":"SAMPLE_TEXT", "volume":"SAMPLE_TEXT", "holdingsValue":"SAMPLE_TEXT", "holdingsValueRealtime":"SAMPLE_TEXT", "yearRange":"SAMPLE_TEXT", "daysValueChange":"SAMPLE_TEXT", "daysValueChangeRealtime":"SAMPLE_TEXT", "stockExchange":"SAMPLE_TEXT", "dividendYield":"SAMPLE_TEXT", "percentChange":"SAMPLE_TEXT"}""")).asJSON
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_quoteEvent_url")))
            .pause(10)
            .repeat(5) {
                exec(http("Get created quoteEvent")
                .get("${new_quoteEvent_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created quoteEvent")
            .delete("${new_quoteEvent_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(100) over (1 minutes))
    ).protocols(httpConf)
}
