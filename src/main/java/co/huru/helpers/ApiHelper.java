package co.huru.helpers;

import co.huru.configs.EnvConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static Response updateBiometric(String userId) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri(EnvConfig.getProperty("identityServiceBaseUri"));

        Map<String, String> headers = new HashMap<>();
        headers.put("userId", userId);

        String reqBody = "{\n" +
                "\n" +
                "  \"accessToken\": \"" + userId + "\",\n" +
                "  \"biometricEnable\": true\n" +
                "\n" +
                "}";

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBasePath(EnvConfig.getProperty("updateBiometricEndPoint"))
                .setContentType(ContentType.JSON)
                .addHeaders(headers)
                .setBody(reqBody)
                .build();

        return given(requestSpecification).put().then().extract().response();
    }

}
