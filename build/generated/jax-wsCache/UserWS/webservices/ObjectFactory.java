
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

    private final static QName _SetBalance_QNAME = new QName("http://webservices/", "setBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://webservices/", "getBalanceResponse");
    private final static QName _GetUserIdFromEmail_QNAME = new QName("http://webservices/", "getUserIdFromEmail");
    private final static QName _GetUserIdFromUsernameResponse_QNAME = new QName("http://webservices/", "getUserIdFromUsernameResponse");
    private final static QName _GetBalance_QNAME = new QName("http://webservices/", "getBalance");
    private final static QName _GetUsername_QNAME = new QName("http://webservices/", "getUsername");
    private final static QName _GetUsernameResponse_QNAME = new QName("http://webservices/", "getUsernameResponse");
    private final static QName _GetUserIdFromUsername_QNAME = new QName("http://webservices/", "getUserIdFromUsername");
    private final static QName _GetRecentActivities_QNAME = new QName("http://webservices/", "getRecentActivities");
    private final static QName _GetUserIdFromEmailResponse_QNAME = new QName("http://webservices/", "getUserIdFromEmailResponse");
    private final static QName _SetBalanceResponse_QNAME = new QName("http://webservices/", "setBalanceResponse");
    private final static QName _ProcessforgotPasswordResponse_QNAME = new QName("http://webservices/", "processforgotPasswordResponse");
    private final static QName _UpdatePassword_QNAME = new QName("http://webservices/", "updatePassword");
    private final static QName _ProcessforgotPassword_QNAME = new QName("http://webservices/", "processforgotPassword");
    private final static QName _GetRecentActivitiesResponse_QNAME = new QName("http://webservices/", "getRecentActivitiesResponse");
    private final static QName _UpdatePasswordResponse_QNAME = new QName("http://webservices/", "updatePasswordResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecentActivitiesResponse }
     * 
     */
    public GetRecentActivitiesResponse createGetRecentActivitiesResponse() {
        return new GetRecentActivitiesResponse();
    }

    /**
     * Create an instance of {@link UpdatePasswordResponse }
     * 
     */
    public UpdatePasswordResponse createUpdatePasswordResponse() {
        return new UpdatePasswordResponse();
    }

    /**
     * Create an instance of {@link ProcessforgotPassword }
     * 
     */
    public ProcessforgotPassword createProcessforgotPassword() {
        return new ProcessforgotPassword();
    }

    /**
     * Create an instance of {@link UpdatePassword }
     * 
     */
    public UpdatePassword createUpdatePassword() {
        return new UpdatePassword();
    }

    /**
     * Create an instance of {@link ProcessforgotPasswordResponse }
     * 
     */
    public ProcessforgotPasswordResponse createProcessforgotPasswordResponse() {
        return new ProcessforgotPasswordResponse();
    }

    /**
     * Create an instance of {@link GetUserIdFromEmailResponse }
     * 
     */
    public GetUserIdFromEmailResponse createGetUserIdFromEmailResponse() {
        return new GetUserIdFromEmailResponse();
    }

    /**
     * Create an instance of {@link SetBalanceResponse }
     * 
     */
    public SetBalanceResponse createSetBalanceResponse() {
        return new SetBalanceResponse();
    }

    /**
     * Create an instance of {@link GetRecentActivities }
     * 
     */
    public GetRecentActivities createGetRecentActivities() {
        return new GetRecentActivities();
    }

    /**
     * Create an instance of {@link GetUserIdFromUsername }
     * 
     */
    public GetUserIdFromUsername createGetUserIdFromUsername() {
        return new GetUserIdFromUsername();
    }

    /**
     * Create an instance of {@link GetUsernameResponse }
     * 
     */
    public GetUsernameResponse createGetUsernameResponse() {
        return new GetUsernameResponse();
    }

    /**
     * Create an instance of {@link GetUsername }
     * 
     */
    public GetUsername createGetUsername() {
        return new GetUsername();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link GetUserIdFromUsernameResponse }
     * 
     */
    public GetUserIdFromUsernameResponse createGetUserIdFromUsernameResponse() {
        return new GetUserIdFromUsernameResponse();
    }

    /**
     * Create an instance of {@link GetUserIdFromEmail }
     * 
     */
    public GetUserIdFromEmail createGetUserIdFromEmail() {
        return new GetUserIdFromEmail();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link SetBalance }
     * 
     */
    public SetBalance createSetBalance() {
        return new SetBalance();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setBalance")
    public JAXBElement<SetBalance> createSetBalance(SetBalance value) {
        return new JAXBElement<SetBalance>(_SetBalance_QNAME, SetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getBalanceResponse")
    public JAXBElement<GetBalanceResponse> createGetBalanceResponse(GetBalanceResponse value) {
        return new JAXBElement<GetBalanceResponse>(_GetBalanceResponse_QNAME, GetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromEmail")
    public JAXBElement<GetUserIdFromEmail> createGetUserIdFromEmail(GetUserIdFromEmail value) {
        return new JAXBElement<GetUserIdFromEmail>(_GetUserIdFromEmail_QNAME, GetUserIdFromEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromUsernameResponse")
    public JAXBElement<GetUserIdFromUsernameResponse> createGetUserIdFromUsernameResponse(GetUserIdFromUsernameResponse value) {
        return new JAXBElement<GetUserIdFromUsernameResponse>(_GetUserIdFromUsernameResponse_QNAME, GetUserIdFromUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getBalance")
    public JAXBElement<GetBalance> createGetBalance(GetBalance value) {
        return new JAXBElement<GetBalance>(_GetBalance_QNAME, GetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUsername")
    public JAXBElement<GetUsername> createGetUsername(GetUsername value) {
        return new JAXBElement<GetUsername>(_GetUsername_QNAME, GetUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUsernameResponse")
    public JAXBElement<GetUsernameResponse> createGetUsernameResponse(GetUsernameResponse value) {
        return new JAXBElement<GetUsernameResponse>(_GetUsernameResponse_QNAME, GetUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromUsername")
    public JAXBElement<GetUserIdFromUsername> createGetUserIdFromUsername(GetUserIdFromUsername value) {
        return new JAXBElement<GetUserIdFromUsername>(_GetUserIdFromUsername_QNAME, GetUserIdFromUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentActivities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRecentActivities")
    public JAXBElement<GetRecentActivities> createGetRecentActivities(GetRecentActivities value) {
        return new JAXBElement<GetRecentActivities>(_GetRecentActivities_QNAME, GetRecentActivities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdFromEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getUserIdFromEmailResponse")
    public JAXBElement<GetUserIdFromEmailResponse> createGetUserIdFromEmailResponse(GetUserIdFromEmailResponse value) {
        return new JAXBElement<GetUserIdFromEmailResponse>(_GetUserIdFromEmailResponse_QNAME, GetUserIdFromEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setBalanceResponse")
    public JAXBElement<SetBalanceResponse> createSetBalanceResponse(SetBalanceResponse value) {
        return new JAXBElement<SetBalanceResponse>(_SetBalanceResponse_QNAME, SetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessforgotPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "processforgotPasswordResponse")
    public JAXBElement<ProcessforgotPasswordResponse> createProcessforgotPasswordResponse(ProcessforgotPasswordResponse value) {
        return new JAXBElement<ProcessforgotPasswordResponse>(_ProcessforgotPasswordResponse_QNAME, ProcessforgotPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "updatePassword")
    public JAXBElement<UpdatePassword> createUpdatePassword(UpdatePassword value) {
        return new JAXBElement<UpdatePassword>(_UpdatePassword_QNAME, UpdatePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessforgotPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "processforgotPassword")
    public JAXBElement<ProcessforgotPassword> createProcessforgotPassword(ProcessforgotPassword value) {
        return new JAXBElement<ProcessforgotPassword>(_ProcessforgotPassword_QNAME, ProcessforgotPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentActivitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRecentActivitiesResponse")
    public JAXBElement<GetRecentActivitiesResponse> createGetRecentActivitiesResponse(GetRecentActivitiesResponse value) {
        return new JAXBElement<GetRecentActivitiesResponse>(_GetRecentActivitiesResponse_QNAME, GetRecentActivitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "updatePasswordResponse")
    public JAXBElement<UpdatePasswordResponse> createUpdatePasswordResponse(UpdatePasswordResponse value) {
        return new JAXBElement<UpdatePasswordResponse>(_UpdatePasswordResponse_QNAME, UpdatePasswordResponse.class, null, value);
    }

}
