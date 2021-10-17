package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {

		Class<?> clazz = RichSoilLand.class;

		Field[] declaredFields = clazz.getDeclaredFields();
		Map<String, List<Field>> fieldMap = new HashMap<>(){{
			put("protected",new ArrayList<>());
			put("private", new ArrayList<>());
			put("public", new ArrayList<>());
			put("all", new ArrayList<>());
		}};

		fillingUpTheMap(fieldMap,declaredFields);

		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String modifierName = buff.readLine();
		StringBuilder output = new StringBuilder();

		while (!modifierName.equals("HARVEST")) {
			output.append(getResultFromMap(fieldMap,modifierName));
			modifierName = buff.readLine();
		}
		System.out.print(output.toString());
	}

	private static void fillingUpTheMap(Map<String, List<Field>> fieldMap, Field[] declaredFields) {
		for (Field field : declaredFields) {
			String mod = Modifier.toString(field.getModifiers());
			fieldMap.get(mod).add(field);
			fieldMap.get("all").add(field);
		}
	}

	private static StringBuilder getResultFromMap(Map<String, List<Field>> fieldMap, String modifierName) {
		List<Field> fields = fieldMap.get(modifierName);
		StringBuilder sb = new StringBuilder();
		return sb.append(fields.stream()
				.map(f -> String.format("%s %s %s%n",
						Modifier.toString(f.getModifiers()),
						f.getType().getSimpleName(),
						f.getName()))
				.collect(Collectors.joining()));
	}
}
