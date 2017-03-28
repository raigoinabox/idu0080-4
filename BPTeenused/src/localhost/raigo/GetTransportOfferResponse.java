
package localhost.raigo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTransportOfferResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransportOfferResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transportOffer" type="{http://raigo.localhost/}transportOffer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransportOfferResponse", propOrder = {
    "transportOffer"
})
public class GetTransportOfferResponse {

    @XmlElement(required = true)
    protected TransportOffer transportOffer;

    /**
     * Gets the value of the transportOffer property.
     * 
     * @return
     *     possible object is
     *     {@link TransportOffer }
     *     
     */
    public TransportOffer getTransportOffer() {
        return transportOffer;
    }

    /**
     * Sets the value of the transportOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportOffer }
     *     
     */
    public void setTransportOffer(TransportOffer value) {
        this.transportOffer = value;
    }

}
