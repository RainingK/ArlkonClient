
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

    private final static QName _GetProfitValueResponse_QNAME = new QName("http://webservices/", "getProfitValueResponse");
    private final static QName _InsertInDbResponse_QNAME = new QName("http://webservices/", "insertInDbResponse");
    private final static QName _GetTransactionAmountResponse_QNAME = new QName("http://webservices/", "getTransactionAmountResponse");
    private final static QName _GetLossValue_QNAME = new QName("http://webservices/", "getLossValue");
    private final static QName _CheckTransactionExistsResponse_QNAME = new QName("http://webservices/", "checkTransactionExistsResponse");
    private final static QName _GetLossValueResponse_QNAME = new QName("http://webservices/", "getLossValueResponse");
    private final static QName _InsertIntoDetails_QNAME = new QName("http://webservices/", "insertIntoDetails");
    private final static QName _GetTransactionAmount_QNAME = new QName("http://webservices/", "getTransactionAmount");
    private final static QName _GetTransactionResultResponse_QNAME = new QName("http://webservices/", "getTransactionResultResponse");
    private final static QName _CheckTransactionExists_QNAME = new QName("http://webservices/", "checkTransactionExists");
    private final static QName _GetProfitValue_QNAME = new QName("http://webservices/", "getProfitValue");
    private final static QName _GetEndMethod_QNAME = new QName("http://webservices/", "getEndMethod");
    private final static QName _InsertIntoDetailsResponse_QNAME = new QName("http://webservices/", "insertIntoDetailsResponse");
    private final static QName _InsertInDb_QNAME = new QName("http://webservices/", "insertInDb");
    private final static QName _GetTransactionResult_QNAME = new QName("http://webservices/", "getTransactionResult");
    private final static QName _GetEndMethodResponse_QNAME = new QName("http://webservices/", "getEndMethodResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEndMethodResponse }
     * 
     */
    public GetEndMethodResponse createGetEndMethodResponse() {
        return new GetEndMethodResponse();
    }

    /**
     * Create an instance of {@link GetTransactionResult }
     * 
     */
    public GetTransactionResult createGetTransactionResult() {
        return new GetTransactionResult();
    }

    /**
     * Create an instance of {@link InsertInDb }
     * 
     */
    public InsertInDb createInsertInDb() {
        return new InsertInDb();
    }

    /**
     * Create an instance of {@link GetEndMethod }
     * 
     */
    public GetEndMethod createGetEndMethod() {
        return new GetEndMethod();
    }

    /**
     * Create an instance of {@link InsertIntoDetailsResponse }
     * 
     */
    public InsertIntoDetailsResponse createInsertIntoDetailsResponse() {
        return new InsertIntoDetailsResponse();
    }

    /**
     * Create an instance of {@link CheckTransactionExists }
     * 
     */
    public CheckTransactionExists createCheckTransactionExists() {
        return new CheckTransactionExists();
    }

    /**
     * Create an instance of {@link GetProfitValue }
     * 
     */
    public GetProfitValue createGetProfitValue() {
        return new GetProfitValue();
    }

    /**
     * Create an instance of {@link GetTransactionResultResponse }
     * 
     */
    public GetTransactionResultResponse createGetTransactionResultResponse() {
        return new GetTransactionResultResponse();
    }

    /**
     * Create an instance of {@link GetTransactionAmount }
     * 
     */
    public GetTransactionAmount createGetTransactionAmount() {
        return new GetTransactionAmount();
    }

    /**
     * Create an instance of {@link InsertIntoDetails }
     * 
     */
    public InsertIntoDetails createInsertIntoDetails() {
        return new InsertIntoDetails();
    }

    /**
     * Create an instance of {@link CheckTransactionExistsResponse }
     * 
     */
    public CheckTransactionExistsResponse createCheckTransactionExistsResponse() {
        return new CheckTransactionExistsResponse();
    }

    /**
     * Create an instance of {@link GetLossValueResponse }
     * 
     */
    public GetLossValueResponse createGetLossValueResponse() {
        return new GetLossValueResponse();
    }

    /**
     * Create an instance of {@link GetLossValue }
     * 
     */
    public GetLossValue createGetLossValue() {
        return new GetLossValue();
    }

    /**
     * Create an instance of {@link GetTransactionAmountResponse }
     * 
     */
    public GetTransactionAmountResponse createGetTransactionAmountResponse() {
        return new GetTransactionAmountResponse();
    }

    /**
     * Create an instance of {@link InsertInDbResponse }
     * 
     */
    public InsertInDbResponse createInsertInDbResponse() {
        return new InsertInDbResponse();
    }

    /**
     * Create an instance of {@link GetProfitValueResponse }
     * 
     */
    public GetProfitValueResponse createGetProfitValueResponse() {
        return new GetProfitValueResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfitValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getProfitValueResponse")
    public JAXBElement<GetProfitValueResponse> createGetProfitValueResponse(GetProfitValueResponse value) {
        return new JAXBElement<GetProfitValueResponse>(_GetProfitValueResponse_QNAME, GetProfitValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInDbResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertInDbResponse")
    public JAXBElement<InsertInDbResponse> createInsertInDbResponse(InsertInDbResponse value) {
        return new JAXBElement<InsertInDbResponse>(_InsertInDbResponse_QNAME, InsertInDbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTransactionAmountResponse")
    public JAXBElement<GetTransactionAmountResponse> createGetTransactionAmountResponse(GetTransactionAmountResponse value) {
        return new JAXBElement<GetTransactionAmountResponse>(_GetTransactionAmountResponse_QNAME, GetTransactionAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLossValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLossValue")
    public JAXBElement<GetLossValue> createGetLossValue(GetLossValue value) {
        return new JAXBElement<GetLossValue>(_GetLossValue_QNAME, GetLossValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransactionExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkTransactionExistsResponse")
    public JAXBElement<CheckTransactionExistsResponse> createCheckTransactionExistsResponse(CheckTransactionExistsResponse value) {
        return new JAXBElement<CheckTransactionExistsResponse>(_CheckTransactionExistsResponse_QNAME, CheckTransactionExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLossValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getLossValueResponse")
    public JAXBElement<GetLossValueResponse> createGetLossValueResponse(GetLossValueResponse value) {
        return new JAXBElement<GetLossValueResponse>(_GetLossValueResponse_QNAME, GetLossValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIntoDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertIntoDetails")
    public JAXBElement<InsertIntoDetails> createInsertIntoDetails(InsertIntoDetails value) {
        return new JAXBElement<InsertIntoDetails>(_InsertIntoDetails_QNAME, InsertIntoDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTransactionAmount")
    public JAXBElement<GetTransactionAmount> createGetTransactionAmount(GetTransactionAmount value) {
        return new JAXBElement<GetTransactionAmount>(_GetTransactionAmount_QNAME, GetTransactionAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTransactionResultResponse")
    public JAXBElement<GetTransactionResultResponse> createGetTransactionResultResponse(GetTransactionResultResponse value) {
        return new JAXBElement<GetTransactionResultResponse>(_GetTransactionResultResponse_QNAME, GetTransactionResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTransactionExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "checkTransactionExists")
    public JAXBElement<CheckTransactionExists> createCheckTransactionExists(CheckTransactionExists value) {
        return new JAXBElement<CheckTransactionExists>(_CheckTransactionExists_QNAME, CheckTransactionExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfitValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getProfitValue")
    public JAXBElement<GetProfitValue> createGetProfitValue(GetProfitValue value) {
        return new JAXBElement<GetProfitValue>(_GetProfitValue_QNAME, GetProfitValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEndMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getEndMethod")
    public JAXBElement<GetEndMethod> createGetEndMethod(GetEndMethod value) {
        return new JAXBElement<GetEndMethod>(_GetEndMethod_QNAME, GetEndMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIntoDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertIntoDetailsResponse")
    public JAXBElement<InsertIntoDetailsResponse> createInsertIntoDetailsResponse(InsertIntoDetailsResponse value) {
        return new JAXBElement<InsertIntoDetailsResponse>(_InsertIntoDetailsResponse_QNAME, InsertIntoDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInDb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertInDb")
    public JAXBElement<InsertInDb> createInsertInDb(InsertInDb value) {
        return new JAXBElement<InsertInDb>(_InsertInDb_QNAME, InsertInDb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTransactionResult")
    public JAXBElement<GetTransactionResult> createGetTransactionResult(GetTransactionResult value) {
        return new JAXBElement<GetTransactionResult>(_GetTransactionResult_QNAME, GetTransactionResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEndMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getEndMethodResponse")
    public JAXBElement<GetEndMethodResponse> createGetEndMethodResponse(GetEndMethodResponse value) {
        return new JAXBElement<GetEndMethodResponse>(_GetEndMethodResponse_QNAME, GetEndMethodResponse.class, null, value);
    }

}
