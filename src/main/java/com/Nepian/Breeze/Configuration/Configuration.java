package com.Nepian.Breeze.Configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.Nepian.Breeze.Configuration.Annotation.PrecededBySpace;

public class Configuration {
	public static void pairFileAndClass(File file, Class<?> clazz) {
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			if (!endWithSpace(file)) {
				writer.newLine();
			}

			for (Field field : clazz.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())
						|| Modifier.isTransient(field.getModifiers())
						|| !Modifier.isPublic(field.getModifiers())) {
					continue;
				}

				String path = field.getName();

				try {
					if (config.isSet(path)) {
						field.set(null, ValueParser.parseToJava(config.get(path)));
					} else {
						if (field.isAnnotationPresent(PrecededBySpace.class)) {
							writer.newLine();
						}
						writer.write(FieldParser.parse(field));
						writer.newLine();
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean endWithSpace(File file) {
		try {
			Scanner scanner = new Scanner(file);
			String lastLine = "";

			while (scanner.hasNextLine()) {
				lastLine = scanner.nextLine();
			}

			if (scanner != null) {
				scanner.close();
			}

			return lastLine.isEmpty();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String getColoured(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
}
