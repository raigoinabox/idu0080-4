package localhost.raigo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-03-06T11:24:21.711+02:00
 * Generated source version: 2.7.18
 * 
 */
@WebServiceClient(name = "Services", 
                  wsdlLocation = "http://localhost:8080/BPTeenused/services/ServicesPort?wsdl",
                  targetNamespace = "http://raigo.localhost/") 
public class Services extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://raigo.localhost/", "Services");
    public final static QName ServicesPort = new QName("http://raigo.localhost/", "ServicesPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/BPTeenused/services/ServicesPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Services.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/BPTeenused/services/ServicesPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Services(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Services(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Services() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Services(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Services(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public Services(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ServicesPortType
     */
    @WebEndpoint(name = "ServicesPort")
    public ServicesPortType getServicesPort() {
        return super.getPort(ServicesPort, ServicesPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicesPortType
     */
    @WebEndpoint(name = "ServicesPort")
    public ServicesPortType getServicesPort(WebServiceFeature... features) {
        return super.getPort(ServicesPort, ServicesPortType.class, features);
    }

}