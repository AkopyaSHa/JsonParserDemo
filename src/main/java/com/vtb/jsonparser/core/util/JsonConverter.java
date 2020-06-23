package com.vtb.jsonparser.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonConverter {

    private static final Logger logger = LogManager.getLogger(JsonConverter.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void toJSON(String fileName, T teams) {
        try {
            logger.info("Сериализация в файл " + fileName);
            objectMapper.writeValue(new File(fileName), teams);
        } catch (IOException ignored){
            logger.warn("Ошибка сериализации файла " + fileName);
        }

    }

    public static <T> T toJavaObject(String fileName, Class<T> c) throws IOException {
        logger.info("Десериализация файла " + fileName);
        return (T) objectMapper.readValue(new File(fileName), c);
    }
}
