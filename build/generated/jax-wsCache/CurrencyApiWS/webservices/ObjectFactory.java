
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

    private final static QName _GetCurrencyList_QNAME = new QName("http://webservices/", "getCurrencyList");
    private final static QName _GetCurrentPrice_QNAME = new QName("http://webservices/", "getCurrentPrice");
    private final static QName _GetCurrencyListResponse_QNAME = new QName("http://webservices/", "getCurrencyListResponse");
    private final static QName _GetCurrentPriceResponse_QNAME = new QName("http://webservices/", "getCurrentPriceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrentPriceResponse }
     * 
     */
    public GetCurrentPriceResponse createGetCurrentPriceResponse() {
        return new GetCurrentPriceResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyListResponse }
     * 
     */
    public GetCurrencyListResponse createGetCurrencyListResponse() {
        return new GetCurrencyListResponse();
    }

    /**
     * Create an instance of {@link GetCurrentPrice }
     * 
     */
    public GetCurrentPrice createGetCurrentPrice() {
        return new GetCurrentPrice();
    }

    /**
     * Create an instance of {@link GetCurrencyList }
     * 
     */
    public GetCurrencyList createGetCurrencyList() {
        return new GetCurrencyList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrencyList")
    public JAXBElement<GetCurrencyList> createGetCurrencyList(GetCurrencyList value) {
        return new JAXBElement<GetCurrencyList>(_GetCurrencyList_QNAME, GetCurrencyList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrentPrice")
    public JAXBElement<GetCurrentPrice> createGetCurrentPrice(GetCurrentPrice value) {
        return new JAXBElement<GetCurrentPrice>(_GetCurrentPrice_QNAME, GetCurrentPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrencyListResponse")
    public JAXBElement<GetCurrencyListResponse> createGetCurrencyListResponse(GetCurrencyListResponse value) {
        return new JAXBElement<GetCurrencyListResponse>(_GetCurrencyListResponse_QNAME, GetCurrencyListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrentPriceResponse")
    public JAXBElement<GetCurrentPriceResponse> createGetCurrentPriceResponse(GetCurrentPriceResponse value) {
        return new JAXBElement<GetCurrentPriceResponse>(_GetCurrentPriceResponse_QNAME, GetCurrentPriceResponse.class, null, value);
    }

}
