
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
@WebService(name = "SessionWS", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SessionWS {


    /**
     * 
     * @param password
     * @param email
     * @param cpassword
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "signUp", targetNamespace = "http://webservices/", className = "webservices.SignUp")
    @ResponseWrapper(localName = "signUpResponse", targetNamespace = "http://webservices/", className = "webservices.SignUpResponse")
    @Action(input = "http://webservices/SessionWS/signUpRequest", output = "http://webservices/SessionWS/signUpResponse")
    public Boolean signUp(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "Cpassword", targetNamespace = "")
        String cpassword);

    /**
     * 
     * @param email
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkEmailExists", targetNamespace = "http://webservices/", className = "webservices.CheckEmailExists")
    @ResponseWrapper(localName = "checkEmailExistsResponse", targetNamespace = "http://webservices/", className = "webservices.CheckEmailExistsResponse")
    @Action(input = "http://webservices/SessionWS/checkEmailExistsRequest", output = "http://webservices/SessionWS/checkEmailExistsResponse")
    public Boolean checkEmailExists(
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param password
     * @param userId
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkOldPassword", targetNamespace = "http://webservices/", className = "webservices.CheckOldPassword")
    @ResponseWrapper(localName = "checkOldPasswordResponse", targetNamespace = "http://webservices/", className = "webservices.CheckOldPasswordResponse")
    @Action(input = "http://webservices/SessionWS/checkOldPasswordRequest", output = "http://webservices/SessionWS/checkOldPasswordResponse")
    public Boolean checkOldPassword(
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkServer", targetNamespace = "http://webservices/", className = "webservices.CheckServer")
    @ResponseWrapper(localName = "checkServerResponse", targetNamespace = "http://webservices/", className = "webservices.CheckServerResponse")
    @Action(input = "http://webservices/SessionWS/checkServerRequest", output = "http://webservices/SessionWS/checkServerResponse")
    public String checkServer();

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkUsernameExists", targetNamespace = "http://webservices/", className = "webservices.CheckUsernameExists")
    @ResponseWrapper(localName = "checkUsernameExistsResponse", targetNamespace = "http://webservices/", className = "webservices.CheckUsernameExistsResponse")
    @Action(input = "http://webservices/SessionWS/checkUsernameExistsRequest", output = "http://webservices/SessionWS/checkUsernameExistsResponse")
    public Boolean checkUsernameExists(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://webservices/", className = "webservices.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://webservices/", className = "webservices.LoginResponse")
    @Action(input = "http://webservices/SessionWS/loginRequest", output = "http://webservices/SessionWS/loginResponse")
    public Boolean login(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

}
