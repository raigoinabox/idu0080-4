
package localhost.raigo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the localhost.raigo package. 
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

    private final static QName _OrderTransport_QNAME = new QName("http://raigo.localhost/", "orderTransport");
    private final static QName _GetTransportOfferResponse_QNAME = new QName("http://raigo.localhost/", "getTransportOfferResponse");
    private final static QName _OrderTransportResponse_QNAME = new QName("http://raigo.localhost/", "orderTransportResponse");
    private final static QName _GetCouriers_QNAME = new QName("http://raigo.localhost/", "getCouriers");
    private final static QName _GetCouriersResponse_QNAME = new QName("http://raigo.localhost/", "getCouriersResponse");
    private final static QName _GetTransportOffer_QNAME = new QName("http://raigo.localhost/", "getTransportOffer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: localhost.raigo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCouriersResponse }
     * 
     */
    public GetCouriersResponse createGetCouriersResponse() {
        return new GetCouriersResponse();
    }

    /**
     * Create an instance of {@link GetTransportOffer }
     * 
     */
    public GetTransportOffer createGetTransportOffer() {
        return new GetTransportOffer();
    }

    /**
     * Create an instance of {@link GetCouriers }
     * 
     */
    public GetCouriers createGetCouriers() {
        return new GetCouriers();
    }

    /**
     * Create an instance of {@link OrderTransportResponse }
     * 
     */
    public OrderTransportResponse createOrderTransportResponse() {
        return new OrderTransportResponse();
    }

    /**
     * Create an instance of {@link OrderTransport }
     * 
     */
    public OrderTransport createOrderTransport() {
        return new OrderTransport();
    }

    /**
     * Create an instance of {@link GetTransportOfferResponse }
     * 
     */
    public GetTransportOfferResponse createGetTransportOfferResponse() {
        return new GetTransportOfferResponse();
    }

    /**
     * Create an instance of {@link TransportOffer }
     * 
     */
    public TransportOffer createTransportOffer() {
        return new TransportOffer();
    }

    /**
     * Create an instance of {@link Courier }
     * 
     */
    public Courier createCourier() {
        return new Courier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTransport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "orderTransport")
    public JAXBElement<OrderTransport> createOrderTransport(OrderTransport value) {
        return new JAXBElement<OrderTransport>(_OrderTransport_QNAME, OrderTransport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransportOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "getTransportOfferResponse")
    public JAXBElement<GetTransportOfferResponse> createGetTransportOfferResponse(GetTransportOfferResponse value) {
        return new JAXBElement<GetTransportOfferResponse>(_GetTransportOfferResponse_QNAME, GetTransportOfferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTransportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "orderTransportResponse")
    public JAXBElement<OrderTransportResponse> createOrderTransportResponse(OrderTransportResponse value) {
        return new JAXBElement<OrderTransportResponse>(_OrderTransportResponse_QNAME, OrderTransportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCouriers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "getCouriers")
    public JAXBElement<GetCouriers> createGetCouriers(GetCouriers value) {
        return new JAXBElement<GetCouriers>(_GetCouriers_QNAME, GetCouriers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCouriersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "getCouriersResponse")
    public JAXBElement<GetCouriersResponse> createGetCouriersResponse(GetCouriersResponse value) {
        return new JAXBElement<GetCouriersResponse>(_GetCouriersResponse_QNAME, GetCouriersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransportOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://raigo.localhost/", name = "getTransportOffer")
    public JAXBElement<GetTransportOffer> createGetTransportOffer(GetTransportOffer value) {
        return new JAXBElement<GetTransportOffer>(_GetTransportOffer_QNAME, GetTransportOffer.class, null, value);
    }

}
