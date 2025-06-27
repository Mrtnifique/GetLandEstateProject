package getlandestate.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseUrl {
    public static RequestSpecification spec;

    public static void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("http://64.227.123.49:8092")
                .setContentType(ContentType.JSON)
                .addHeader("authorization", "Bearer ")
                .build();
    }
}
