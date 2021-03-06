
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
@WebServiceClient(name = "SessionWS", targetNamespace = "http://webservices/", wsdlLocation = "http://localhost:8080/ArlkonServer/SessionWS?wsdl")
public class SessionWS_Service
    extends Service
{

    private final static URL SESSIONWS_WSDL_LOCATION;
    private final static WebServiceException SESSIONWS_EXCEPTION;
    private final static QName SESSIONWS_QNAME = new QName("http://webservices/", "SessionWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ArlkonServer/SessionWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SESSIONWS_WSDL_LOCATION = url;
        SESSIONWS_EXCEPTION = e;
    }

    public SessionWS_Service() {
        super(__getWsdlLocation(), SESSIONWS_QNAME);
    }

    public SessionWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SESSIONWS_QNAME, features);
    }

    public SessionWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SESSIONWS_QNAME);
    }

    public SessionWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SESSIONWS_QNAME, features);
    }

    public SessionWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SessionWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SessionWS
     */
    @WebEndpoint(name = "SessionWSPort")
    public SessionWS getSessionWSPort() {
        return super.getPort(new QName("http://webservices/", "SessionWSPort"), SessionWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SessionWS
     */
    @WebEndpoint(name = "SessionWSPort")
    public SessionWS getSessionWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "SessionWSPort"), SessionWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SESSIONWS_EXCEPTION!= null) {
            throw SESSIONWS_EXCEPTION;
        }
        return SESSIONWS_WSDL_LOCATION;
    }

}
