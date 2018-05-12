
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

    private final static QName _PrintData_QNAME = new QName("http://webservices/", "printData");
    private final static QName _PrintDataResponse_QNAME = new QName("http://webservices/", "printDataResponse");
    private final static QName _PrintInvestData_QNAME = new QName("http://webservices/", "printInvestData");
    private final static QName _PrintInvestDataResponse_QNAME = new QName("http://webservices/", "printInvestDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrintInvestData }
     * 
     */
    public PrintInvestData createPrintInvestData() {
        return new PrintInvestData();
    }

    /**
     * Create an instance of {@link PrintInvestDataResponse }
     * 
     */
    public PrintInvestDataResponse createPrintInvestDataResponse() {
        return new PrintInvestDataResponse();
    }

    /**
     * Create an instance of {@link PrintDataResponse }
     * 
     */
    public PrintDataResponse createPrintDataResponse() {
        return new PrintDataResponse();
    }

    /**
     * Create an instance of {@link PrintData }
     * 
     */
    public PrintData createPrintData() {
        return new PrintData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "printData")
    public JAXBElement<PrintData> createPrintData(PrintData value) {
        return new JAXBElement<PrintData>(_PrintData_QNAME, PrintData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "printDataResponse")
    public JAXBElement<PrintDataResponse> createPrintDataResponse(PrintDataResponse value) {
        return new JAXBElement<PrintDataResponse>(_PrintDataResponse_QNAME, PrintDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintInvestData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "printInvestData")
    public JAXBElement<PrintInvestData> createPrintInvestData(PrintInvestData value) {
        return new JAXBElement<PrintInvestData>(_PrintInvestData_QNAME, PrintInvestData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintInvestDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "printInvestDataResponse")
    public JAXBElement<PrintInvestDataResponse> createPrintInvestDataResponse(PrintInvestDataResponse value) {
        return new JAXBElement<PrintInvestDataResponse>(_PrintInvestDataResponse_QNAME, PrintInvestDataResponse.class, null, value);
    }

}
