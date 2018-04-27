
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckUsernameExists_QNAME = new QName("http://webservices/", "checkUsernameExists");
    private final static QName _CheckEmailExistsResponse_QNAME = new QName("http://webservices/", "checkEmailExistsResponse");
    private final static QName _SignUp_QNAME = new QName("http://webservices/", "signUp");
    private final static QName _Login_QNAME = new QName("http://webservices/", "login");
    private final static QName _SignUpResponse_QNAME = new QName("http://webservices/", "signUpResponse");
    private final static QName _CheckEmailExists_QNAME = new QName("http://webservices/", "checkEmailExists");
    private final static QName _CheckUsernameExistsResponse_QNAME = new QName("http://webservices/", "checkUsernameExistsResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://webservices/", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckUsernameExistsResponse }
     * 
     */
    public CheckUsernameExistsResponse createCheckUsernameExistsResponse() {
        return new CheckUsernameExistsResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link CheckEmailExists }
     * 
     */
    public CheckEmailExists createCheckEmailExists() {
        return new CheckEmailExists();
    }

    /**
     * Create an instance of {@link SignUpResponse }
     * 
     */
    public SignUpResponse createSignUpResponse() {
        return new SignUpResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link CheckEmailExistsResponse }
     * 
     */
    public CheckEmailExistsResponse createCheckEmailExistsResponse() {
        return new CheckEmailExistsResponse();
    }

    /**
     * Create an instance of {@link SignUp }
     * 
     */
    public SignUp createSignUp() {
        return new SignUp();
    }

    /**
     * Create an instance of {@link CheckUsernameExists }
     * 
     */
    public CheckUsernameExists createCheckUsernameExists() {
        return new CheckUsernameExists();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckUsernameExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkUsernameExists")
    public JAXBElement<CheckUsernameExists> createCheckUsernameExists(CheckUsernameExists value) {
        return new JAXBElement<CheckUsernameExists>(_CheckUsernameExists_QNAME, CheckUsernameExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmailExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkEmailExistsResponse")
    public JAXBElement<CheckEmailExistsResponse> createCheckEmailExistsResponse(CheckEmailExistsResponse value) {
        return new JAXBElement<CheckEmailExistsResponse>(_CheckEmailExistsResponse_QNAME, CheckEmailExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "signUp")
    public JAXBElement<SignUp> createSignUp(SignUp value) {
        return new JAXBElement<SignUp>(_SignUp_QNAME, SignUp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "signUpResponse")
    public JAXBElement<SignUpResponse> createSignUpResponse(SignUpResponse value) {
        return new JAXBElement<SignUpResponse>(_SignUpResponse_QNAME, SignUpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmailExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkEmailExists")
    public JAXBElement<CheckEmailExists> createCheckEmailExists(CheckEmailExists value) {
        return new JAXBElement<CheckEmailExists>(_CheckEmailExists_QNAME, CheckEmailExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckUsernameExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkUsernameExistsResponse")
    public JAXBElement<CheckUsernameExistsResponse> createCheckUsernameExistsResponse(CheckUsernameExistsResponse value) {
        return new JAXBElement<CheckUsernameExistsResponse>(_CheckUsernameExistsResponse_QNAME, CheckUsernameExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

}
