package co.huru.utils;

import co.huru.dataObjects.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataObjectMapper {

    public static TestData getTestDataObject(String dataFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(dataFile), TestData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
