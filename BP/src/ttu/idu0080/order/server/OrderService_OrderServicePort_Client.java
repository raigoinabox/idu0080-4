
package ttu.idu0080.order.server;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.5.1 2017-02-23T13:30:51.956+02:00
 * Generated source version: 2.5.1
 * 
 */
public final class OrderService_OrderServicePort_Client {

	private static final QName SERVICE_NAME = new QName("http://server.order.idu0080.ttu/", "OrderServiceService");

	private OrderService_OrderServicePort_Client() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = OrderServiceService.WSDL_LOCATION;
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		OrderServiceService ss = new OrderServiceService(wsdlURL, SERVICE_NAME);
		OrderService port = ss.getOrderServicePort();

		{
			System.out.println("Invoking getOrdersByCustomerId...");
			int _getOrdersByCustomerId_customerId = -242784820;
			java.util.List<ttu.idu0080.order.server.Order> _getOrdersByCustomerId__return = port
					.getOrdersByCustomerId(_getOrdersByCustomerId_customerId);
			System.out.println("getOrdersByCustomerId.result=" + _getOrdersByCustomerId__return);

		}
		{
			System.out.println("Invoking getAllOrders...");
			java.util.List<ttu.idu0080.order.server.Order> _getAllOrders__return = port.getAllOrders();
			System.out.println("getAllOrders.result=" + _getAllOrders__return);

		}
		{
			System.out.println("Invoking getOrdersByOrderId...");
			int _getOrdersByOrderId_orderId = -1929312113;
			ttu.idu0080.order.server.Order _getOrdersByOrderId__return = port
					.getOrdersByOrderId(_getOrdersByOrderId_orderId);
			System.out.println("getOrdersByOrderId.result=" + _getOrdersByOrderId__return);

		}
		{
			System.out.println("Invoking getOrdersByShippingAddress...");
			java.lang.String _getOrdersByShippingAddress_country = "_getOrdersByShippingAddress_country-1743408442";
			java.lang.String _getOrdersByShippingAddress_county = "_getOrdersByShippingAddress_county1268177310";
			java.util.List<ttu.idu0080.order.server.Order> _getOrdersByShippingAddress__return = port
					.getOrdersByShippingAddress(_getOrdersByShippingAddress_country,
							_getOrdersByShippingAddress_county);
			System.out.println("getOrdersByShippingAddress.result=" + _getOrdersByShippingAddress__return);

		}
		{
			System.out.println("Invoking getOrdersByCustomerLastName...");
			java.lang.String _getOrdersByCustomerLastName_lastName = "_getOrdersByCustomerLastName_lastName-717689996";
			java.util.List<ttu.idu0080.order.server.Order> _getOrdersByCustomerLastName__return = port
					.getOrdersByCustomerLastName(_getOrdersByCustomerLastName_lastName);
			System.out.println("getOrdersByCustomerLastName.result=" + _getOrdersByCustomerLastName__return);

		}

		System.exit(0);
	}

}
