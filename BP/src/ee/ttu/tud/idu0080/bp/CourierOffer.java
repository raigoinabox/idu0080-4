package ee.ttu.tud.idu0080.bp;

import localhost.raigo.Courier;
import localhost.raigo.TransportOffer;

public class CourierOffer {

	private Courier courier;
	private TransportOffer offer;

	public CourierOffer(Courier courier, TransportOffer offer) {
		this.courier = courier;
		this.offer = offer;
	}

	Courier getCourier() {
		return courier;
	}

	TransportOffer getOffer() {
		return offer;
	}
}
