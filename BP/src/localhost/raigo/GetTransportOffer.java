
package localhost.raigo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ttu.idu0080.order.server.Order;


/**
 * <p>Java class for getTransportOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTransportOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courierId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="order" type="{http://server.order.idu0080.ttu/}order"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransportOffer", propOrder = {
    "courierId",
    "order"
})
public class GetTransportOffer {

    protected int courierId;
    @XmlElement(required = true)
    protected Order order;

    /**
     * Gets the value of the courierId property.
     * 
     */
    public int getCourierId() {
        return courierId;
    }

    /**
     * Sets the value of the courierId property.
     * 
     */
    public void setCourierId(int value) {
        this.courierId = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
    }

}
