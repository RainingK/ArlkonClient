
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
@WebServiceClient(name = "CurrencyApiWS", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8080/ArlkonServer/CurrencyApiWS?wsdl")
public class CurrencyApiWS_Service
    extends Service
{

    private final static URL CURRENCYAPIWS_WSDL_LOCATION;
    private final static WebServiceException CURRENCYAPIWS_EXCEPTION;
    private final static QName CURRENCYAPIWS_QNAME = new QName("http://webservices/", "CurrencyApiWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ArlkonServer/CurrencyApiWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURRENCYAPIWS_WSDL_LOCATION = url;
        CURRENCYAPIWS_EXCEPTION = e;
    }

    public CurrencyApiWS_Service() {
        super(__getWsdlLocation(), CURRENCYAPIWS_QNAME);
    }

    public CurrencyApiWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURRENCYAPIWS_QNAME, features);
    }

    public CurrencyApiWS_Service(URL wsdlLocation) {
        super(wsdlLocation, CURRENCYAPIWS_QNAME);
    }

    public CurrencyApiWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURRENCYAPIWS_QNAME, features);
    }

    public CurrencyApiWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CurrencyApiWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CurrencyApiWS
     */
    @WebEndpoint(name = "CurrencyApiWSPort")
    public CurrencyApiWS getCurrencyApiWSPort() {
        return super.getPort(new QName("http://webservices/", "CurrencyApiWSPort"), CurrencyApiWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CurrencyApiWS
     */
    @WebEndpoint(name = "CurrencyApiWSPort")
    public CurrencyApiWS getCurrencyApiWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "CurrencyApiWSPort"), CurrencyApiWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURRENCYAPIWS_EXCEPTION!= null) {
            throw CURRENCYAPIWS_EXCEPTION;
        }
        return CURRENCYAPIWS_WSDL_LOCATION;
    }

}