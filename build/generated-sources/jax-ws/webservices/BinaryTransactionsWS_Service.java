
package webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BinaryTransactionsWS", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8080/ArlkonServer/BinaryTransactionsWS?wsdl")
public class BinaryTransactionsWS_Service
    extends Service
{

    private final static URL BINARYTRANSACTIONSWS_WSDL_LOCATION;
    private final static WebServiceException BINARYTRANSACTIONSWS_EXCEPTION;
    private final static QName BINARYTRANSACTIONSWS_QNAME = new QName("http://webservices/", "BinaryTransactionsWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ArlkonServer/BinaryTransactionsWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BINARYTRANSACTIONSWS_WSDL_LOCATION = url;
        BINARYTRANSACTIONSWS_EXCEPTION = e;
    }

    public BinaryTransactionsWS_Service() {
        super(__getWsdlLocation(), BINARYTRANSACTIONSWS_QNAME);
    }

    public BinaryTransactionsWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BINARYTRANSACTIONSWS_QNAME, features);
    }

    public BinaryTransactionsWS_Service(URL wsdlLocation) {
        super(wsdlLocation, BINARYTRANSACTIONSWS_QNAME);
    }

    public BinaryTransactionsWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BINARYTRANSACTIONSWS_QNAME, features);
    }

    public BinaryTransactionsWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BinaryTransactionsWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BinaryTransactionsWS
     */
    @WebEndpoint(name = "BinaryTransactionsWSPort")
    public BinaryTransactionsWS getBinaryTransactionsWSPort() {
        return super.getPort(new QName("http://webservices/", "BinaryTransactionsWSPort"), BinaryTransactionsWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BinaryTransactionsWS
     */
    @WebEndpoint(name = "BinaryTransactionsWSPort")
    public BinaryTransactionsWS getBinaryTransactionsWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "BinaryTransactionsWSPort"), BinaryTransactionsWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BINARYTRANSACTIONSWS_EXCEPTION!= null) {
            throw BINARYTRANSACTIONSWS_EXCEPTION;
        }
        return BINARYTRANSACTIONSWS_WSDL_LOCATION;
    }

}
