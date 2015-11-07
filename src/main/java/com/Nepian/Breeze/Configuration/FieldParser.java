package com.Nepian.Breeze.Configuration;

import java.lang.reflect.Field;

import com.Nepian.Breeze.Configuration.Annotation.ConfigurationComment;

public class FieldParser {

	public static String parse(Field field) {
		StringBuilder builder = new StringBuilder(50);

		if (field.isAnnotationPresent(ConfigurationComment.class)) {
			builder.append('#').append(field.getAnnotation(ConfigurationComment.class).value()).append('\n');
		}

		try {
			builder.append(field.getName()).append(": ").append(ValueParser.ParseToYAML(field.get(null)));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return "";
		}

		return builder.toString();
	}
}
