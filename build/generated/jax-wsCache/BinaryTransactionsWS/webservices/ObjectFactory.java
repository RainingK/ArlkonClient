
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

    private final static QName _InsertIntoDb_QNAME = new QName("http://webservices/", "insertIntoDb");
    private final static QName _InsertIntoDbResponse_QNAME = new QName("http://webservices/", "insertIntoDbResponse");
    private final static QName _SetResultResponse_QNAME = new QName("http://webservices/", "setResultResponse");
    private final static QName _GetCallEndPrice_QNAME = new QName("http://webservices/", "getCallEndPrice");
    private final static QName _SetResult_QNAME = new QName("http://webservices/", "setResult");
    private final static QName _GetCallEndPriceResponse_QNAME = new QName("http://webservices/", "getCallEndPriceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCallEndPriceResponse }
     * 
     */
    public GetCallEndPriceResponse createGetCallEndPriceResponse() {
        return new GetCallEndPriceResponse();
    }

    /**
     * Create an instance of {@link GetCallEndPrice }
     * 
     */
    public GetCallEndPrice createGetCallEndPrice() {
        return new GetCallEndPrice();
    }

    /**
     * Create an instance of {@link SetResult }
     * 
     */
    public SetResult createSetResult() {
        return new SetResult();
    }

    /**
     * Create an instance of {@link InsertIntoDbResponse }
     * 
     */
    public InsertIntoDbResponse createInsertIntoDbResponse() {
        return new InsertIntoDbResponse();
    }

    /**
     * Create an instance of {@link SetResultResponse }
     * 
     */
    public SetResultResponse createSetResultResponse() {
        return new SetResultResponse();
    }

    /**
     * Create an instance of {@link InsertIntoDb }
     * 
     */
    public InsertIntoDb createInsertIntoDb() {
        return new InsertIntoDb();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIntoDb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertIntoDb")
    public JAXBElement<InsertIntoDb> createInsertIntoDb(InsertIntoDb value) {
        return new JAXBElement<InsertIntoDb>(_InsertIntoDb_QNAME, InsertIntoDb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIntoDbResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertIntoDbResponse")
    public JAXBElement<InsertIntoDbResponse> createInsertIntoDbResponse(InsertIntoDbResponse value) {
        return new JAXBElement<InsertIntoDbResponse>(_InsertIntoDbResponse_QNAME, InsertIntoDbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setResultResponse")
    public JAXBElement<SetResultResponse> createSetResultResponse(SetResultResponse value) {
        return new JAXBElement<SetResultResponse>(_SetResultResponse_QNAME, SetResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCallEndPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCallEndPrice")
    public JAXBElement<GetCallEndPrice> createGetCallEndPrice(GetCallEndPrice value) {
        return new JAXBElement<GetCallEndPrice>(_GetCallEndPrice_QNAME, GetCallEndPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setResult")
    public JAXBElement<SetResult> createSetResult(SetResult value) {
        return new JAXBElement<SetResult>(_SetResult_QNAME, SetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCallEndPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCallEndPriceResponse")
    public JAXBElement<GetCallEndPriceResponse> createGetCallEndPriceResponse(GetCallEndPriceResponse value) {
        return new JAXBElement<GetCallEndPriceResponse>(_GetCallEndPriceResponse_QNAME, GetCallEndPriceResponse.class, null, value);
    }

}
