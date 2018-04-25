
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
@WebService(name = "UserWS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserWS {


    /**
     * 
     * @param username
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserIdFromUsername", targetNamespace = "http://webservices/", className = "webservices.GetUserIdFromUsername")
    @ResponseWrapper(localName = "getUserIdFromUsernameResponse", targetNamespace = "http://webservices/", className = "webservices.GetUserIdFromUsernameResponse")
    @Action(input = "http://webservices/UserWS/getUserIdFromUsernameRequest", output = "http://webservices/UserWS/getUserIdFromUsernameResponse")
    public int getUserIdFromUsername(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param userId
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBalance", targetNamespace = "http://webservices/", className = "webservices.GetBalance")
    @ResponseWrapper(localName = "getBalanceResponse", targetNamespace = "http://webservices/", className = "webservices.GetBalanceResponse")
    @Action(input = "http://webservices/UserWS/getBalanceRequest", output = "http://webservices/UserWS/getBalanceResponse")
    public double getBalance(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param balance
     * @param userId
     */
    @WebMethod
    @RequestWrapper(localName = "setBalance", targetNamespace = "http://webservices/", className = "webservices.SetBalance")
    @ResponseWrapper(localName = "setBalanceResponse", targetNamespace = "http://webservices/", className = "webservices.SetBalanceResponse")
    @Action(input = "http://webservices/UserWS/setBalanceRequest", output = "http://webservices/UserWS/setBalanceResponse")
    public void setBalance(
        @WebParam(name = "balance", targetNamespace = "")
        double balance,
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

}