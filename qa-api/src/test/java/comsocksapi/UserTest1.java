package comsocksapi;

import comsocksapim.models.UserModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class UserTest1 {

    public static final String BASE_URI = "http://192.168.1.104";

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setRelaxedHTTPSValidation()
                .build();
    }

    @Test
    public void testCanRegisterNewUser() {


        UserModel user = new UserModel()
                .username(RandomStringUtils.randomAlphabetic(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given(getRequestSpecification()).contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));


    }

    @Test
    public void testCanNotRegisterSameUserTwice() {

        UserModel user = new UserModel()
                .username(RandomStringUtils.randomAlphabetic(6))
                .email("test@mail.com")
                .password("test123");

        RestAssured
                .given(getRequestSpecification()).contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", not(emptyString()));


    }
}
