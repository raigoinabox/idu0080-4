
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package localhost.raigo;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.7.18 2017-03-06T11:24:21.690+02:00
 * Generated source version: 2.7.18
 * 
 */

@javax.jws.WebService(serviceName = "Services", portName = "ServicesPort", targetNamespace = "http://raigo.localhost/", wsdlLocation = "http://localhost:8080/BPTeenused/services/ServicesPort?wsdl", endpointInterface = "localhost.raigo.ServicesPortType")

public class ServicesPortTypeImpl implements ServicesPortType {

	private static final Logger LOG = Logger.getLogger(ServicesPortTypeImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see localhost.raigo.ServicesPortType#getCouriers(*
	 */
	public java.util.List<localhost.raigo.Courier> getCouriers() {
		LOG.info("Executing operation getCouriers");
		try {
			java.util.List<localhost.raigo.Courier> _return = new java.util.ArrayList<localhost.raigo.Courier>();
			localhost.raigo.Courier _returnVal1 = new localhost.raigo.Courier();
			_returnVal1.setId(-1776138333);
			_returnVal1.setName("Name-882574038");
			_return.add(_returnVal1);
			return _return;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see localhost.raigo.ServicesPortType#getTransportOffer(int courierId
	 * ,)ttu.idu0080.order.server.Order order )*
	 */
	public localhost.raigo.TransportOffer getTransportOffer(int courierId, ttu.idu0080.order.server.Order order) {
		LOG.info("Executing operation getTransportOffer");
		try {
			localhost.raigo.TransportOffer _return = new localhost.raigo.TransportOffer();
			_return.setOfferId("OfferId2026879247");
			_return.setTransportPrice(new java.math.BigDecimal("233644798322550656.2207461306062322532"));
			_return.setDeliveryTime(new java.math.BigInteger("-51100072585268205331158754993641226314"));
			return _return;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see localhost.raigo.ServicesPortType#orderTransport(java.lang.String
	 * offerId )*
	 */
	public java.lang.String orderTransport(java.lang.String offerId) {
		LOG.info("Executing operation orderTransport");
		try {
			java.lang.String _return = "_return-889771642";
			return _return;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}