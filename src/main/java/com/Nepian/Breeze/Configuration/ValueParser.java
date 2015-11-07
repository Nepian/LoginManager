package com.Nepian.Breeze.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;

public class ValueParser {

	public static Object parseToJava(Object object) {
		if (object instanceof ConfigurationSection) {
			Map<String, List<String>> map = new HashMap<String, List<String>>();

			for (String message : ((ConfigurationSection) object).getKeys(false)) {
				map.put(message, ((ConfigurationSection) object).getStringList(message));
			}

			return map;
		} else if (object instanceof String) {
			return Configuration.getColoured((String) object);
		} else {
			return object;
		}
	}

	public static String ParseToYAML(Object object) {
		if (object instanceof Number || object instanceof Boolean) {
			return String.valueOf(object);
		} else {
			return '\"' + String.valueOf(object) + '\"';
		}
	}
}
