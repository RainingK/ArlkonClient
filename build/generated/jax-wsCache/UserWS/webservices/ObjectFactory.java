
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

    private final static QName _GetUserIdFromUsername_QNAME = new QName("http://webservices/", "getUserIdFromUsername");
    private final static QName _SetBalance_QNAME = new QName("http://webservices/", "setBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://webservices/", "getBalanceResponse");
    private final static QName _GetRecentActivities_QNAME = new QName("http://webservices/", "getRecentActivities");
    private final static QName _SetBalanceResponse_QNAME = new QName("http://webservices/", "setBalanceResponse");
    private final static QName _GetUserIdFromUsernameResponse_QNAME = new QName("http://webservices/", "getUserIdFromUsernameResponse");
    private final static QName _GetBalance_QNAME = new QName("http://webservices/", "getBalance");
    private final static QName _GetRecentActivitiesResponse_QNAME = new QName("http://webservices/", "getRecentActivitiesResponse");

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
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link GetUserIdFromUsername }
     * 
     */
    public GetUserIdFromUsername createGetUserIdFromUsername() {
        return new GetUserIdFromUsername();
    }

    /**
     * Create an instance of {@link SetBalance }
     * 
     */
    public SetBalance createSetBalance() {
        return new SetBalance();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentActivities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRecentActivities")
    public JAXBElement<GetRecentActivities> createGetRecentActivities(GetRecentActivities value) {
        return new JAXBElement<GetRecentActivities>(_GetRecentActivities_QNAME, GetRecentActivities.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentActivitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRecentActivitiesResponse")
    public JAXBElement<GetRecentActivitiesResponse> createGetRecentActivitiesResponse(GetRecentActivitiesResponse value) {
        return new JAXBElement<GetRecentActivitiesResponse>(_GetRecentActivitiesResponse_QNAME, GetRecentActivitiesResponse.class, null, value);
    }

}
