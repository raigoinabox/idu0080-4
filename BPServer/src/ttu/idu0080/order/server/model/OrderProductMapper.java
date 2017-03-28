package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ttu.idu0080.order.server.OrderProduct;

public class OrderProductMapper extends Mapper {

	private Map<Integer, OrderProduct> orderProducts = new HashMap<>();

	public OrderProductMapper() {
		super("order_product", "product_name", "product_count", "price", "price_total");
	}

	OrderProduct fromResultSet(ResultSet resultSet, OrderDto order) throws SQLException {
		OrderProduct orderProduct;
		int orderProductId = getInt(resultSet, "order_product");
		if (resultSet.wasNull()) {
			orderProduct = null;
		} else if (orderProducts.containsKey(orderProductId)) {
			orderProduct = orderProducts.get(orderProductId);
		} else {
			orderProduct = new OrderProduct();
			orderProduct.setOrderProduct(orderProductId);
			orderProduct.setProductName(getString(resultSet, "product_name"));
			orderProduct.setProductCount(getInt(resultSet, "product_count"));
			orderProduct.setPrice(getFloat(resultSet, "price"));
			orderProduct.setPriceTotal(getFloat(resultSet, "price_total"));

			orderProducts.put(orderProductId, orderProduct);
			order.getOrderProducts().add(orderProduct);
		}

		return orderProduct;
	}
}
