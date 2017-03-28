package ttu.idu0080.order.server.model;

import java.util.Iterator;

public class SqlUtils {

	public static String joinFields(String table, String[] fields) {
		String fieldsString = "";
		if (fields.length > 0) {
			fieldsString = constructField(table, fields[0]);
		}
		for (int i = 1; i < fields.length; i++) {
			fieldsString += ", " + constructField(table, fields[i]);
		}
		return fieldsString;
	}

	public static String joinFields(String table, Iterable<String> fields) {
		String fieldsString = "";
		Iterator<String> iterator = fields.iterator();
		if (iterator.hasNext()) {
			fieldsString = constructField(table, iterator.next());
		}
		while (iterator.hasNext()) {
			fieldsString += ", " + constructField(table, iterator.next());
		}
		return fieldsString;
	}

	public static String constructField(String table, String field) {
		if (table != null && !table.isEmpty()) {
			field = table + "." + field;
		}

		return field;
	}

	public static String constructField(String table, String field, String alias) {
		if (table != null && !table.isEmpty()) {
			field = table + "." + field;
		}

		if (alias != null && !alias.isEmpty()) {
			field += " AS " + alias;
		}

		return field;
	}
}
