
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

    private final static QName _GetEndPrice_QNAME = new QName("http://webservices/", "getEndPrice");
    private final static QName _GetPendingTransactionTypeResponse_QNAME = new QName("http://webservices/", "getPendingTransactionTypeResponse");
    private final static QName _GetFinishedTransactionPriceResponse_QNAME = new QName("http://webservices/", "getFinishedTransactionPriceResponse");
    private final static QName _GetAmountResponse_QNAME = new QName("http://webservices/", "getAmountResponse");
    private final static QName _GetStartPriceResponse_QNAME = new QName("http://webservices/", "getStartPriceResponse");
    private final static QName _GetRisingType_QNAME = new QName("http://webservices/", "getRisingType");
    private final static QName _CheckTransactionExists_QNAME = new QName("http://webservices/", "checkTransactionExists");
    private final static QName _GetExpiryDateTimeResponse_QNAME = new QName("http://webservices/", "getExpiryDateTimeResponse");
    private final static QName _GetExpiryDateTime_QNAME = new QName("http://webservices/", "getExpiryDateTime");
    private final static QName _GetRisingTypeResponse_QNAME = new QName("http://webservices/", "getRisingTypeResponse");
    private final static QName _SetEndPrice_QNAME = new QName("http://webservices/", "setEndPrice");
    private final static QName _GetDateTimeResponse_QNAME = new QName("http://webservices/", "getDateTimeResponse");
    private final static QName _GetEndPriceResponse_QNAME = new QName("http://webservices/", "getEndPriceResponse");
    private final static QName _SetResultResponse_QNAME = new QName("http://webservices/", "setResultResponse");
    private final static QName _GetDateTime_QNAME = new QName("http://webservices/", "getDateTime");
    private final static QName _GetAmount_QNAME = new QName("http://webservices/", "getAmount");
    private final static QName _CheckTransactionExistsResponse_QNAME = new QName("http://webservices/", "checkTransactionExistsResponse");
    private final static QName _InsertIntoDb_QNAME = new QName("http://webservices/", "insertIntoDb");
    private final static QName _GetCurrency1_QNAME = new QName("http://webservices/", "getCurrency1");
    private final static QName _GetStartPrice_QNAME = new QName("http://webservices/", "getStartPrice");
    private final static QName _GetCurrency2_QNAME = new QName("http://webservices/", "getCurrency2");
    private final static QName _GetTimeFrame_QNAME = new QName("http://webservices/", "getTimeFrame");
    private final static QName _GetTimeFrameResponse_QNAME = new QName("http://webservices/", "getTimeFrameResponse");
    private final static QName _SetEndPriceResponse_QNAME = new QName("http://webservices/", "setEndPriceResponse");
    private final static QName _GetCurrency1Response_QNAME = new QName("http://webservices/", "getCurrency1Response");
    private final static QName _GetCurrency2Response_QNAME = new QName("http://webservices/", "getCurrency2Response");
    private final static QName _GetPendingTransactionType_QNAME = new QName("http://webservices/", "getPendingTransactionType");
    private final static QName _InsertIntoDbResponse_QNAME = new QName("http://webservices/", "insertIntoDbResponse");
    private final static QName _SetResult_QNAME = new QName("http://webservices/", "setResult");
    private final static QName _GetFinishedTransactionPrice_QNAME = new QName("http://webservices/", "getFinishedTransactionPrice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFinishedTransactionPrice }
     * 
     */
    public GetFinishedTransactionPrice createGetFinishedTransactionPrice() {
        return new GetFinishedTransactionPrice();
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
     * Create an instance of {@link GetPendingTransactionType }
     * 
     */
    public GetPendingTransactionType createGetPendingTransactionType() {
        return new GetPendingTransactionType();
    }

    /**
     * Create an instance of {@link GetCurrency1Response }
     * 
     */
    public GetCurrency1Response createGetCurrency1Response() {
        return new GetCurrency1Response();
    }

    /**
     * Create an instance of {@link GetCurrency2Response }
     * 
     */
    public GetCurrency2Response createGetCurrency2Response() {
        return new GetCurrency2Response();
    }

    /**
     * Create an instance of {@link SetEndPriceResponse }
     * 
     */
    public SetEndPriceResponse createSetEndPriceResponse() {
        return new SetEndPriceResponse();
    }

    /**
     * Create an instance of {@link GetTimeFrameResponse }
     * 
     */
    public GetTimeFrameResponse createGetTimeFrameResponse() {
        return new GetTimeFrameResponse();
    }

    /**
     * Create an instance of {@link GetTimeFrame }
     * 
     */
    public GetTimeFrame createGetTimeFrame() {
        return new GetTimeFrame();
    }

    /**
     * Create an instance of {@link GetCurrency2 }
     * 
     */
    public GetCurrency2 createGetCurrency2() {
        return new GetCurrency2();
    }

    /**
     * Create an instance of {@link GetCurrency1 }
     * 
     */
    public GetCurrency1 createGetCurrency1() {
        return new GetCurrency1();
    }

    /**
     * Create an instance of {@link GetStartPrice }
     * 
     */
    public GetStartPrice createGetStartPrice() {
        return new GetStartPrice();
    }

    /**
     * Create an instance of {@link CheckTransactionExistsResponse }
     * 
     */
    public CheckTransactionExistsResponse createCheckTransactionExistsResponse() {
        return new CheckTransactionExistsResponse();
    }

    /**
     * Create an instance of {@link InsertIntoDb }
     * 
     */
    public InsertIntoDb createInsertIntoDb() {
        return new InsertIntoDb();
    }

    /**
     * Create an instance of {@link GetAmount }
     * 
     */
    public GetAmount createGetAmount() {
        return new GetAmount();
    }

    /**
     * Create an instance of {@link GetDateTime }
     * 
     */
    public GetDateTime createGetDateTime() {
        return new GetDateTime();
    }

    /**
     * Create an instance of {@link SetResultResponse }
     * 
     */
    public SetResultResponse createSetResultResponse() {
        return new SetResultResponse();
    }

    /**
     * Create an instance of {@link GetDateTimeResponse }
     * 
     */
    public GetDateTimeResponse createGetDateTimeResponse() {
        return new GetDateTimeResponse();
    }

    /**
     * Create an instance of {@link GetEndPriceResponse }
     * 
     */
    public GetEndPriceResponse createGetEndPriceResponse() {
        return new GetEndPriceResponse();
    }

    /**
     * Create an instance of {@link SetEndPrice }
     * 
     */
    public SetEndPrice createSetEndPrice() {
        return new SetEndPrice();
    }

    /**
     * Create an instance of {@link GetRisingTypeResponse }
     * 
     */
    public GetRisingTypeResponse createGetRisingTypeResponse() {
        return new GetRisingTypeResponse();
    }

    /**
     * Create an instance of {@link GetExpiryDateTime }
     * 
     */
    public GetExpiryDateTime createGetExpiryDateTime() {
        return new GetExpiryDateTime();
    }

    /**
     * Create an instance of {@link GetExpiryDateTimeResponse }
     * 
     */
    public GetExpiryDateTimeResponse createGetExpiryDateTimeResponse() {
        return new GetExpiryDateTimeResponse();
    }

    /**
     * Create an instance of {@link CheckTransactionExists }
     * 
     */
    public CheckTransactionExists createCheckTransactionExists() {
        return new CheckTransactionExists();
    }

    /**
     * Create an instance of {@link GetRisingType }
     * 
     */
    public GetRisingType createGetRisingType() {
        return new GetRisingType();
    }

    /**
     * Create an instance of {@link GetStartPriceResponse }
     * 
     */
    public GetStartPriceResponse createGetStartPriceResponse() {
        return new GetStartPriceResponse();
    }

    /**
     * Create an instance of {@link GetAmountResponse }
     * 
     */
    public GetAmountResponse createGetAmountResponse() {
        return new GetAmountResponse();
    }

    /**
     * Create an instance of {@link GetFinishedTransactionPriceResponse }
     * 
     */
    public GetFinishedTransactionPriceResponse createGetFinishedTransactionPriceResponse() {
        return new GetFinishedTransactionPriceResponse();
    }

    /**
     * Create an instance of {@link GetEndPrice }
     * 
     */
    public GetEndPrice createGetEndPrice() {
        return new GetEndPrice();
    }

    /**
     * Create an instance of {@link GetPendingTransactionTypeResponse }
     * 
     */
    public GetPendingTransactionTypeResponse createGetPendingTransactionTypeResponse() {
        return new GetPendingTransactionTypeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEndPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getEndPrice")
    public JAXBElement<GetEndPrice> createGetEndPrice(GetEndPrice value) {
        return new JAXBElement<GetEndPrice>(_GetEndPrice_QNAME, GetEndPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPendingTransactionTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getPendingTransactionTypeResponse")
    public JAXBElement<GetPendingTransactionTypeResponse> createGetPendingTransactionTypeResponse(GetPendingTransactionTypeResponse value) {
        return new JAXBElement<GetPendingTransactionTypeResponse>(_GetPendingTransactionTypeResponse_QNAME, GetPendingTransactionTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinishedTransactionPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getFinishedTransactionPriceResponse")
    public JAXBElement<GetFinishedTransactionPriceResponse> createGetFinishedTransactionPriceResponse(GetFinishedTransactionPriceResponse value) {
        return new JAXBElement<GetFinishedTransactionPriceResponse>(_GetFinishedTransactionPriceResponse_QNAME, GetFinishedTransactionPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getAmountResponse")
    public JAXBElement<GetAmountResponse> createGetAmountResponse(GetAmountResponse value) {
        return new JAXBElement<GetAmountResponse>(_GetAmountResponse_QNAME, GetAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStartPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getStartPriceResponse")
    public JAXBElement<GetStartPriceResponse> createGetStartPriceResponse(GetStartPriceResponse value) {
        return new JAXBElement<GetStartPriceResponse>(_GetStartPriceResponse_QNAME, GetStartPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRisingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRisingType")
    public JAXBElement<GetRisingType> createGetRisingType(GetRisingType value) {
        return new JAXBElement<GetRisingType>(_GetRisingType_QNAME, GetRisingType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExpiryDateTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getExpiryDateTimeResponse")
    public JAXBElement<GetExpiryDateTimeResponse> createGetExpiryDateTimeResponse(GetExpiryDateTimeResponse value) {
        return new JAXBElement<GetExpiryDateTimeResponse>(_GetExpiryDateTimeResponse_QNAME, GetExpiryDateTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExpiryDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getExpiryDateTime")
    public JAXBElement<GetExpiryDateTime> createGetExpiryDateTime(GetExpiryDateTime value) {
        return new JAXBElement<GetExpiryDateTime>(_GetExpiryDateTime_QNAME, GetExpiryDateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRisingTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRisingTypeResponse")
    public JAXBElement<GetRisingTypeResponse> createGetRisingTypeResponse(GetRisingTypeResponse value) {
        return new JAXBElement<GetRisingTypeResponse>(_GetRisingTypeResponse_QNAME, GetRisingTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEndPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setEndPrice")
    public JAXBElement<SetEndPrice> createSetEndPrice(SetEndPrice value) {
        return new JAXBElement<SetEndPrice>(_SetEndPrice_QNAME, SetEndPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getDateTimeResponse")
    public JAXBElement<GetDateTimeResponse> createGetDateTimeResponse(GetDateTimeResponse value) {
        return new JAXBElement<GetDateTimeResponse>(_GetDateTimeResponse_QNAME, GetDateTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEndPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getEndPriceResponse")
    public JAXBElement<GetEndPriceResponse> createGetEndPriceResponse(GetEndPriceResponse value) {
        return new JAXBElement<GetEndPriceResponse>(_GetEndPriceResponse_QNAME, GetEndPriceResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getDateTime")
    public JAXBElement<GetDateTime> createGetDateTime(GetDateTime value) {
        return new JAXBElement<GetDateTime>(_GetDateTime_QNAME, GetDateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getAmount")
    public JAXBElement<GetAmount> createGetAmount(GetAmount value) {
        return new JAXBElement<GetAmount>(_GetAmount_QNAME, GetAmount.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIntoDb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "insertIntoDb")
    public JAXBElement<InsertIntoDb> createInsertIntoDb(InsertIntoDb value) {
        return new JAXBElement<InsertIntoDb>(_InsertIntoDb_QNAME, InsertIntoDb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrency1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrency1")
    public JAXBElement<GetCurrency1> createGetCurrency1(GetCurrency1 value) {
        return new JAXBElement<GetCurrency1>(_GetCurrency1_QNAME, GetCurrency1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStartPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getStartPrice")
    public JAXBElement<GetStartPrice> createGetStartPrice(GetStartPrice value) {
        return new JAXBElement<GetStartPrice>(_GetStartPrice_QNAME, GetStartPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrency2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrency2")
    public JAXBElement<GetCurrency2> createGetCurrency2(GetCurrency2 value) {
        return new JAXBElement<GetCurrency2>(_GetCurrency2_QNAME, GetCurrency2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeFrame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTimeFrame")
    public JAXBElement<GetTimeFrame> createGetTimeFrame(GetTimeFrame value) {
        return new JAXBElement<GetTimeFrame>(_GetTimeFrame_QNAME, GetTimeFrame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeFrameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getTimeFrameResponse")
    public JAXBElement<GetTimeFrameResponse> createGetTimeFrameResponse(GetTimeFrameResponse value) {
        return new JAXBElement<GetTimeFrameResponse>(_GetTimeFrameResponse_QNAME, GetTimeFrameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEndPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setEndPriceResponse")
    public JAXBElement<SetEndPriceResponse> createSetEndPriceResponse(SetEndPriceResponse value) {
        return new JAXBElement<SetEndPriceResponse>(_SetEndPriceResponse_QNAME, SetEndPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrency1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrency1Response")
    public JAXBElement<GetCurrency1Response> createGetCurrency1Response(GetCurrency1Response value) {
        return new JAXBElement<GetCurrency1Response>(_GetCurrency1Response_QNAME, GetCurrency1Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrency2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrency2Response")
    public JAXBElement<GetCurrency2Response> createGetCurrency2Response(GetCurrency2Response value) {
        return new JAXBElement<GetCurrency2Response>(_GetCurrency2Response_QNAME, GetCurrency2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPendingTransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getPendingTransactionType")
    public JAXBElement<GetPendingTransactionType> createGetPendingTransactionType(GetPendingTransactionType value) {
        return new JAXBElement<GetPendingTransactionType>(_GetPendingTransactionType_QNAME, GetPendingTransactionType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "setResult")
    public JAXBElement<SetResult> createSetResult(SetResult value) {
        return new JAXBElement<SetResult>(_SetResult_QNAME, SetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinishedTransactionPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getFinishedTransactionPrice")
    public JAXBElement<GetFinishedTransactionPrice> createGetFinishedTransactionPrice(GetFinishedTransactionPrice value) {
        return new JAXBElement<GetFinishedTransactionPrice>(_GetFinishedTransactionPrice_QNAME, GetFinishedTransactionPrice.class, null, value);
    }

}
