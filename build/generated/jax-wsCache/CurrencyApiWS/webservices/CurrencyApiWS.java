
package webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CurrencyApiWS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CurrencyApiWS {


    /**
     * 
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "returnCurrency", targetNamespace = "http://webservices/", className = "webservices.ReturnCurrency")
    @ResponseWrapper(localName = "returnCurrencyResponse", targetNamespace = "http://webservices/", className = "webservices.ReturnCurrencyResponse")
    @Action(input = "http://webservices/CurrencyApiWS/returnCurrencyRequest", output = "http://webservices/CurrencyApiWS/returnCurrencyResponse")
    public double returnCurrency();

    /**
     * 
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRandomNumbers", targetNamespace = "http://webservices/", className = "webservices.GetRandomNumbers")
    @ResponseWrapper(localName = "getRandomNumbersResponse", targetNamespace = "http://webservices/", className = "webservices.GetRandomNumbersResponse")
    @Action(input = "http://webservices/CurrencyApiWS/getRandomNumbersRequest", output = "http://webservices/CurrencyApiWS/getRandomNumbersResponse")
    public double getRandomNumbers();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAverage", targetNamespace = "http://webservices/", className = "webservices.GetAverage")
    @ResponseWrapper(localName = "getAverageResponse", targetNamespace = "http://webservices/", className = "webservices.GetAverageResponse")
    @Action(input = "http://webservices/CurrencyApiWS/getAverageRequest", output = "http://webservices/CurrencyApiWS/getAverageResponse")
    public String getAverage();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrencyList", targetNamespace = "http://webservices/", className = "webservices.GetCurrencyList")
    @ResponseWrapper(localName = "getCurrencyListResponse", targetNamespace = "http://webservices/", className = "webservices.GetCurrencyListResponse")
    @Action(input = "http://webservices/CurrencyApiWS/getCurrencyListRequest", output = "http://webservices/CurrencyApiWS/getCurrencyListResponse")
    public List<String> getCurrencyList();

    /**
     * 
     * @param currency1
     * @param currency2
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrentPrice", targetNamespace = "http://webservices/", className = "webservices.GetCurrentPrice")
    @ResponseWrapper(localName = "getCurrentPriceResponse", targetNamespace = "http://webservices/", className = "webservices.GetCurrentPriceResponse")
    @Action(input = "http://webservices/CurrencyApiWS/getCurrentPriceRequest", output = "http://webservices/CurrencyApiWS/getCurrentPriceResponse")
    public double getCurrentPrice(
        @WebParam(name = "currency1", targetNamespace = "")
        String currency1,
        @WebParam(name = "currency2", targetNamespace = "")
        String currency2);

    /**
     * 
     * @param currency1
     * @param currency2
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistoricalData", targetNamespace = "http://webservices/", className = "webservices.GetHistoricalData")
    @ResponseWrapper(localName = "getHistoricalDataResponse", targetNamespace = "http://webservices/", className = "webservices.GetHistoricalDataResponse")
    @Action(input = "http://webservices/CurrencyApiWS/getHistoricalDataRequest", output = "http://webservices/CurrencyApiWS/getHistoricalDataResponse")
    public double getHistoricalData(
        @WebParam(name = "currency1", targetNamespace = "")
        String currency1,
        @WebParam(name = "currency2", targetNamespace = "")
        String currency2);

}
