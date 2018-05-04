
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
@WebService(name = "IWWS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IWWS {


    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProfitValue", targetNamespace = "http://webservices/", className = "webservices.GetProfitValue")
    @ResponseWrapper(localName = "getProfitValueResponse", targetNamespace = "http://webservices/", className = "webservices.GetProfitValueResponse")
    @Action(input = "http://webservices/IWWS/getProfitValueRequest", output = "http://webservices/IWWS/getProfitValueResponse")
    public double getProfitValue(
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
    @RequestWrapper(localName = "getLossValue", targetNamespace = "http://webservices/", className = "webservices.GetLossValue")
    @ResponseWrapper(localName = "getLossValueResponse", targetNamespace = "http://webservices/", className = "webservices.GetLossValueResponse")
    @Action(input = "http://webservices/IWWS/getLossValueRequest", output = "http://webservices/IWWS/getLossValueResponse")
    public double getLossValue(
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
    @RequestWrapper(localName = "getEndMethod", targetNamespace = "http://webservices/", className = "webservices.GetEndMethod")
    @ResponseWrapper(localName = "getEndMethodResponse", targetNamespace = "http://webservices/", className = "webservices.GetEndMethodResponse")
    @Action(input = "http://webservices/IWWS/getEndMethodRequest", output = "http://webservices/IWWS/getEndMethodResponse")
    public String getEndMethod(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param transactionAmount
     * @param currency
     * @param lossValue
     * @param userId
     * @param profitValue
     */
    @WebMethod
    @RequestWrapper(localName = "insertIntoDB", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDB")
    @ResponseWrapper(localName = "insertIntoDBResponse", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDBResponse")
    @Action(input = "http://webservices/IWWS/insertIntoDBRequest", output = "http://webservices/IWWS/insertIntoDBResponse")
    public void insertIntoDB(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId,
        @WebParam(name = "transaction_amount", targetNamespace = "")
        double transactionAmount,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "profit_value", targetNamespace = "")
        double profitValue,
        @WebParam(name = "loss_value", targetNamespace = "")
        double lossValue);

    /**
     * 
     * @param endMethod
     * @param userId
     * @param transactionResult
     */
    @WebMethod
    @RequestWrapper(localName = "insertIntoDetails", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDetails")
    @ResponseWrapper(localName = "insertIntoDetailsResponse", targetNamespace = "http://webservices/", className = "webservices.InsertIntoDetailsResponse")
    @Action(input = "http://webservices/IWWS/insertIntoDetailsRequest", output = "http://webservices/IWWS/insertIntoDetailsResponse")
    public void insertIntoDetails(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId,
        @WebParam(name = "transaction_result", targetNamespace = "")
        double transactionResult,
        @WebParam(name = "end_method", targetNamespace = "")
        String endMethod);

    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTransactionResult", targetNamespace = "http://webservices/", className = "webservices.GetTransactionResult")
    @ResponseWrapper(localName = "getTransactionResultResponse", targetNamespace = "http://webservices/", className = "webservices.GetTransactionResultResponse")
    @Action(input = "http://webservices/IWWS/getTransactionResultRequest", output = "http://webservices/IWWS/getTransactionResultResponse")
    public double getTransactionResult(
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
    @RequestWrapper(localName = "getTransactionAmount", targetNamespace = "http://webservices/", className = "webservices.GetTransactionAmount")
    @ResponseWrapper(localName = "getTransactionAmountResponse", targetNamespace = "http://webservices/", className = "webservices.GetTransactionAmountResponse")
    @Action(input = "http://webservices/IWWS/getTransactionAmountRequest", output = "http://webservices/IWWS/getTransactionAmountResponse")
    public double getTransactionAmount(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

}
