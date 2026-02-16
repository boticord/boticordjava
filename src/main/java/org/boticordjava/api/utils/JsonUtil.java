package org.boticordjava.api.utils;

import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class JsonUtil {

	private static final Gson GSON;

	static {
		GSON = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
			private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

			@Override
			public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
				String replace = json.getAsJsonPrimitive().getAsString().replaceAll(".[0-9]+Z", "");
				TemporalAccessor parse = formatter.parse(replace);
				return LocalDateTime.from(parse);
			}
		}).setPrettyPrinting().create();
	}

	public static String toJson(@NotNull Object object) {
		return GSON.toJson(object);
	}

	/**
	 * JSON back to java Object
	 *
	 * @param json  - JSON
	 * @param clazz - object class
	 */
	public static <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz) {
		return GSON.fromJson(json, clazz);
	}
}
