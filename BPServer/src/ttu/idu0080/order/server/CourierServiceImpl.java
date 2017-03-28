
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package ttu.idu0080.order.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ttu.idu0080.order.server.model.EnterpriseDao;
import ttu.idu0080.order.server.model.EnterpriseDto;

/**
 * This class was generated by Apache CXF 2.7.18 2017-02-27T17:43:16.285+02:00
 * Generated source version: 2.7.18
 * 
 */

@javax.jws.WebService(serviceName = "CourierServiceService", portName = "CourierServicePort", targetNamespace = "http://server.order.idu0080.ttu/", wsdlLocation = "file:/home/raigo/Dokumendid/veebiteenused/src/BPServer/WebContent/couriers_1.wsdl", endpointInterface = "ttu.idu0080.order.server.CourierService")

public class CourierServiceImpl implements CourierService {

	private static final Logger LOG = Logger.getLogger(CourierServiceImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ttu.idu0080.order.server.CourierService#getCouriersByAddress(java.lang.
	 * String country ,)java.lang.String county )*
	 */
	@Override
	public java.util.List<ttu.idu0080.order.server.Courier> getCouriersByAddress(java.lang.String country,
			java.lang.String county) {
		LOG.info("Executing operation getCouriersByAddress");
		try {
			java.util.List<ttu.idu0080.order.server.Courier> _return = new java.util.ArrayList<ttu.idu0080.order.server.Courier>();
			ttu.idu0080.order.server.Courier _returnVal1 = new ttu.idu0080.order.server.Courier();
			java.util.List<ttu.idu0080.order.server.EntAddress> _returnVal1Addresses = new java.util.ArrayList<ttu.idu0080.order.server.EntAddress>();
			ttu.idu0080.order.server.EntAddress _returnVal1AddressesVal1 = new ttu.idu0080.order.server.EntAddress();
			_returnVal1AddressesVal1.setAddress(-1098284788);
			_returnVal1AddressesVal1.setCountry("Country-125727426");
			_returnVal1AddressesVal1.setCounty("County902049497");
			_returnVal1AddressesVal1.setStreetAddress("StreetAddress-922653098");
			_returnVal1AddressesVal1.setTownVillage("TownVillage-1143823629");
			_returnVal1AddressesVal1.setZipcode("Zipcode-836455884");
			_returnVal1Addresses.add(_returnVal1AddressesVal1);
			_returnVal1.getAddresses().addAll(_returnVal1Addresses);
			_returnVal1.setEnterprise(-116355237);
			_returnVal1.setName("Name-1963424602");
			_returnVal1.setPercentFromOrder(890427519);
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
	 * @see ttu.idu0080.order.server.CourierService#getCourierById(int courierId
	 * )*
	 */
	@Override
	public ttu.idu0080.order.server.Courier getCourierById(int courierId) {
		LOG.info("Executing operation getCourierById");
		try {
			EnterpriseDao dao = EnterpriseDao.getInstance();
			EnterpriseDto enterprise = dao.getEnterpriseById(courierId);
			Courier courier = new Courier();
			courier.setEnterprise(enterprise.getId());
			courier.setName(enterprise.getName());
			courier.setPercentFromOrder(enterprise.getPercentFromOrder());

			List<EntAddress> addresses = courier.getAddresses();
			for (EntAddress address : enterprise.getAddresses()) {
				addresses.add(address);
			}

			return courier;
		} catch (RuntimeException ex) {
			LOG.log(Level.SEVERE, "", ex);
			throw ex;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ttu.idu0080.order.server.CourierService#getAllCouriers(*
	 */
	@Override
	public java.util.List<ttu.idu0080.order.server.Courier> getAllCouriers() {
		LOG.info("Executing operation getAllCouriers");
		try {
			EnterpriseDao dao = EnterpriseDao.getInstance();
			Collection<EnterpriseDto> enterprises = dao.getEnterprises();

			List<Courier> couriers = new ArrayList<Courier>();
			for (EnterpriseDto enterprise : enterprises) {
				Courier courier = new Courier();
				courier.setEnterprise(enterprise.getId());
				courier.setName(enterprise.getName());
				courier.setPercentFromOrder(enterprise.getPercentFromOrder());

				List<EntAddress> addresses = courier.getAddresses();
				for (EntAddress address : enterprise.getAddresses()) {
					addresses.add(address);
				}

				couriers.add(courier);
			}

			return couriers;
		} catch (RuntimeException ex) {
			LOG.log(Level.SEVERE, "", ex);
			ex.printStackTrace();
			throw ex;
		}
	}

}
