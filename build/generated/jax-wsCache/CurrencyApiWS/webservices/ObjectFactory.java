
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
    private final static QName _ReturnCurrency_QNAME = new QName("http://webservices/", "returnCurrency");
    private final static QName _GetAverageResponse_QNAME = new QName("http://webservices/", "getAverageResponse");
    private final static QName _GetCurrencyListResponse_QNAME = new QName("http://webservices/", "getCurrencyListResponse");
    private final static QName _GetCryptoCurrencyList_QNAME = new QName("http://webservices/", "getCryptoCurrencyList");
    private final static QName _GetRandomNumbers_QNAME = new QName("http://webservices/", "getRandomNumbers");
    private final static QName _GetAverage_QNAME = new QName("http://webservices/", "getAverage");
    private final static QName _GetCurrentPrice_QNAME = new QName("http://webservices/", "getCurrentPrice");
    private final static QName _GetCryptoCurrencyListResponse_QNAME = new QName("http://webservices/", "getCryptoCurrencyListResponse");
    private final static QName _ReturnCurrencyResponse_QNAME = new QName("http://webservices/", "returnCurrencyResponse");
    private final static QName _GetCurrentPriceResponse_QNAME = new QName("http://webservices/", "getCurrentPriceResponse");
    private final static QName _GetRandomNumbersResponse_QNAME = new QName("http://webservices/", "getRandomNumbersResponse");
    private final static QName _GetHistoricalDataResponse_QNAME = new QName("http://webservices/", "getHistoricalDataResponse");
    private final static QName _GetHistoricalData_QNAME = new QName("http://webservices/", "getHistoricalData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHistoricalData }
     * 
     */
    public GetHistoricalData createGetHistoricalData() {
        return new GetHistoricalData();
    }

    /**
     * Create an instance of {@link GetHistoricalDataResponse }
     * 
     */
    public GetHistoricalDataResponse createGetHistoricalDataResponse() {
        return new GetHistoricalDataResponse();
    }

    /**
     * Create an instance of {@link GetRandomNumbersResponse }
     * 
     */
    public GetRandomNumbersResponse createGetRandomNumbersResponse() {
        return new GetRandomNumbersResponse();
    }

    /**
     * Create an instance of {@link GetCurrentPriceResponse }
     * 
     */
    public GetCurrentPriceResponse createGetCurrentPriceResponse() {
        return new GetCurrentPriceResponse();
    }

    /**
     * Create an instance of {@link ReturnCurrencyResponse }
     * 
     */
    public ReturnCurrencyResponse createReturnCurrencyResponse() {
        return new ReturnCurrencyResponse();
    }

    /**
     * Create an instance of {@link GetCryptoCurrencyListResponse }
     * 
     */
    public GetCryptoCurrencyListResponse createGetCryptoCurrencyListResponse() {
        return new GetCryptoCurrencyListResponse();
    }

    /**
     * Create an instance of {@link GetCurrentPrice }
     * 
     */
    public GetCurrentPrice createGetCurrentPrice() {
        return new GetCurrentPrice();
    }

    /**
     * Create an instance of {@link GetAverage }
     * 
     */
    public GetAverage createGetAverage() {
        return new GetAverage();
    }

    /**
     * Create an instance of {@link GetRandomNumbers }
     * 
     */
    public GetRandomNumbers createGetRandomNumbers() {
        return new GetRandomNumbers();
    }

    /**
     * Create an instance of {@link GetCryptoCurrencyList }
     * 
     */
    public GetCryptoCurrencyList createGetCryptoCurrencyList() {
        return new GetCryptoCurrencyList();
    }

    /**
     * Create an instance of {@link GetCurrencyListResponse }
     * 
     */
    public GetCurrencyListResponse createGetCurrencyListResponse() {
        return new GetCurrencyListResponse();
    }

    /**
     * Create an instance of {@link GetAverageResponse }
     * 
     */
    public GetAverageResponse createGetAverageResponse() {
        return new GetAverageResponse();
    }

    /**
     * Create an instance of {@link ReturnCurrency }
     * 
     */
    public ReturnCurrency createReturnCurrency() {
        return new ReturnCurrency();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnCurrency }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "returnCurrency")
    public JAXBElement<ReturnCurrency> createReturnCurrency(ReturnCurrency value) {
        return new JAXBElement<ReturnCurrency>(_ReturnCurrency_QNAME, ReturnCurrency.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getAverageResponse")
    public JAXBElement<GetAverageResponse> createGetAverageResponse(GetAverageResponse value) {
        return new JAXBElement<GetAverageResponse>(_GetAverageResponse_QNAME, GetAverageResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCryptoCurrencyList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCryptoCurrencyList")
    public JAXBElement<GetCryptoCurrencyList> createGetCryptoCurrencyList(GetCryptoCurrencyList value) {
        return new JAXBElement<GetCryptoCurrencyList>(_GetCryptoCurrencyList_QNAME, GetCryptoCurrencyList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRandomNumbers")
    public JAXBElement<GetRandomNumbers> createGetRandomNumbers(GetRandomNumbers value) {
        return new JAXBElement<GetRandomNumbers>(_GetRandomNumbers_QNAME, GetRandomNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAverage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getAverage")
    public JAXBElement<GetAverage> createGetAverage(GetAverage value) {
        return new JAXBElement<GetAverage>(_GetAverage_QNAME, GetAverage.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCryptoCurrencyListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCryptoCurrencyListResponse")
    public JAXBElement<GetCryptoCurrencyListResponse> createGetCryptoCurrencyListResponse(GetCryptoCurrencyListResponse value) {
        return new JAXBElement<GetCryptoCurrencyListResponse>(_GetCryptoCurrencyListResponse_QNAME, GetCryptoCurrencyListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnCurrencyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "returnCurrencyResponse")
    public JAXBElement<ReturnCurrencyResponse> createReturnCurrencyResponse(ReturnCurrencyResponse value) {
        return new JAXBElement<ReturnCurrencyResponse>(_ReturnCurrencyResponse_QNAME, ReturnCurrencyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getCurrentPriceResponse")
    public JAXBElement<GetCurrentPriceResponse> createGetCurrentPriceResponse(GetCurrentPriceResponse value) {
        return new JAXBElement<GetCurrentPriceResponse>(_GetCurrentPriceResponse_QNAME, GetCurrentPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getRandomNumbersResponse")
    public JAXBElement<GetRandomNumbersResponse> createGetRandomNumbersResponse(GetRandomNumbersResponse value) {
        return new JAXBElement<GetRandomNumbersResponse>(_GetRandomNumbersResponse_QNAME, GetRandomNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoricalDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getHistoricalDataResponse")
    public JAXBElement<GetHistoricalDataResponse> createGetHistoricalDataResponse(GetHistoricalDataResponse value) {
        return new JAXBElement<GetHistoricalDataResponse>(_GetHistoricalDataResponse_QNAME, GetHistoricalDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoricalData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "getHistoricalData")
    public JAXBElement<GetHistoricalData> createGetHistoricalData(GetHistoricalData value) {
        return new JAXBElement<GetHistoricalData>(_GetHistoricalData_QNAME, GetHistoricalData.class, null, value);
    }

}
