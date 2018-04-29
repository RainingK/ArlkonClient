
package webservices;

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
@WebService(name = "BinaryTransactionsWS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BinaryTransactionsWS {


    /**
     * 
     * @param result
     * @param userId
     */
    @WebMethod
    @RequestWrapper(localName = "setResult", targetNamespace = "http://webservices/", className = "webservices.SetResult")
    @ResponseWrapper(localName = "setResultResponse", targetNamespace = "http://webservices/", className = "webservices.SetResultResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/setResultRequest", output = "http://webservices/BinaryTransactionsWS/setResultResponse")
    public void setResult(
        @WebParam(name = "result", targetNamespace = "")
        double result,
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkTransactionExists", targetNamespace = "http://webservices/", className = "webservices.CheckTransactionExists")
    @ResponseWrapper(localName = "checkTransactionExistsResponse", targetNamespace = "http://webservices/", className = "webservices.CheckTransactionExistsResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/checkTransactionExistsRequest", output = "http://webservices/BinaryTransactionsWS/checkTransactionExistsResponse")
    public boolean checkTransactionExists(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPendingTransactionType", targetNamespace = "http://webservices/", className = "webservices.GetPendingTransactionType")
    @ResponseWrapper(localName = "getPendingTransactionTypeResponse", targetNamespace = "http://webservices/", className = "webservices.GetPendingTransactionTypeResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getPendingTransactionTypeRequest", output = "http://webservices/BinaryTransactionsWS/getPendingTransactionTypeResponse")
    public String getPendingTransactionType(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getExpiryDateTime", targetNamespace = "http://webservices/", className = "webservices.GetExpiryDateTime")
    @ResponseWrapper(localName = "getExpiryDateTimeResponse", targetNamespace = "http://webservices/", className = "webservices.GetExpiryDateTimeResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getExpiryDateTimeRequest", output = "http://webservices/BinaryTransactionsWS/getExpiryDateTimeResponse")
    public String getExpiryDateTime(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTimeFrame", targetNamespace = "http://webservices/", className = "webservices.GetTimeFrame")
    @ResponseWrapper(localName = "getTimeFrameResponse", targetNamespace = "http://webservices/", className = "webservices.GetTimeFrameResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getTimeFrameRequest", output = "http://webservices/BinaryTransactionsWS/getTimeFrameResponse")
    public int getTimeFrame(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrency2", targetNamespace = "http://webservices/", className = "webservices.GetCurrency2")
    @ResponseWrapper(localName = "getCurrency2Response", targetNamespace = "http://webservices/", className = "webservices.GetCurrency2Response")
    @Action(input = "http://webservices/BinaryTransactionsWS/getCurrency2Request", output = "http://webservices/BinaryTransactionsWS/getCurrency2Response")
    public String getCurrency2(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStartPrice", targetNamespace = "http://webservices/", className = "webservices.GetStartPrice")
    @ResponseWrapper(localName = "getStartPriceResponse", targetNamespace = "http://webservices/", className = "webservices.GetStartPriceResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getStartPriceRequest", output = "http://webservices/BinaryTransactionsWS/getStartPriceResponse")
    public double getStartPrice(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param price
     * @param userId
     */
    @WebMethod
    @RequestWrapper(localName = "setEndPrice", targetNamespace = "http://webservices/", className = "webservices.SetEndPrice")
    @ResponseWrapper(localName = "setEndPriceResponse", targetNamespace = "http://webservices/", className = "webservices.SetEndPriceResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/setEndPriceRequest", output = "http://webservices/BinaryTransactionsWS/setEndPriceResponse")
    public void setEndPrice(
        @WebParam(name = "price", targetNamespace = "")
        double price,
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param currency1
     * @param amount
     * @param seconds
     * @param currency2
     * @param type
     * @param priceLevel
     * @param userId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertIntoDb", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDb")
    @ResponseWrapper(localName = "insertIntoDbResponse", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDbResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/insertIntoDbRequest", output = "http://webservices/BinaryTransactionsWS/insertIntoDbResponse")
    public boolean insertIntoDb(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId,
        @WebParam(name = "type", targetNamespace = "")
        String type,
        @WebParam(name = "currency1", targetNamespace = "")
        String currency1,
        @WebParam(name = "currency2", targetNamespace = "")
        String currency2,
        @WebParam(name = "amount", targetNamespace = "")
        double amount,
        @WebParam(name = "price_level", targetNamespace = "")
        double priceLevel,
        @WebParam(name = "seconds", targetNamespace = "")
        int seconds);

    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAmount", targetNamespace = "http://webservices/", className = "webservices.GetAmount")
    @ResponseWrapper(localName = "getAmountResponse", targetNamespace = "http://webservices/", className = "webservices.GetAmountResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getAmountRequest", output = "http://webservices/BinaryTransactionsWS/getAmountResponse")
    public double getAmount(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEndPrice", targetNamespace = "http://webservices/", className = "webservices.GetEndPrice")
    @ResponseWrapper(localName = "getEndPriceResponse", targetNamespace = "http://webservices/", className = "webservices.GetEndPriceResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getEndPriceRequest", output = "http://webservices/BinaryTransactionsWS/getEndPriceResponse")
    public double getEndPrice(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrency1", targetNamespace = "http://webservices/", className = "webservices.GetCurrency1")
    @ResponseWrapper(localName = "getCurrency1Response", targetNamespace = "http://webservices/", className = "webservices.GetCurrency1Response")
    @Action(input = "http://webservices/BinaryTransactionsWS/getCurrency1Request", output = "http://webservices/BinaryTransactionsWS/getCurrency1Response")
    public String getCurrency1(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param userId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDateTime", targetNamespace = "http://webservices/", className = "webservices.GetDateTime")
    @ResponseWrapper(localName = "getDateTimeResponse", targetNamespace = "http://webservices/", className = "webservices.GetDateTimeResponse")
    @Action(input = "http://webservices/BinaryTransactionsWS/getDateTimeRequest", output = "http://webservices/BinaryTransactionsWS/getDateTimeResponse")
    public String getDateTime(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

}
