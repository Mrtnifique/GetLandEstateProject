package getlandestate.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(String email, String password) {
        String url = "http://64.227.123.49:8092/users/login";
        String body = "{\"email\": \""+email+"\",\"password\": \""+password+"\"}";

        return given()
                .when()
                .body(body)
                .contentType(ContentType.JSON)
                .post(url)
                .jsonPath()
                .getString("token");


    }
}
