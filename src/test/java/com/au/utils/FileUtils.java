package com.au.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;

public class FileUtils {

    public static <T> T loadFileAsJsonObject(String filePath, Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(loadFileAsString(filePath), clazz);
    }

    public static String loadFileAsString(String filePath) throws IOException {
        return IOUtils.toString(FileUtils.class.getClassLoader().getResourceAsStream(filePath), defaultCharset());
    }
}
