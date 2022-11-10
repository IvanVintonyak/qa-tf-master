package comsocksapi;

import comsocksapim.conditions.Conditions;
import comsocksapim.models.UserModel;
import comsocksapim.response.UserRegistrationResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class UserTest2 extends UserBaseTest {


    @Test
    public void testCanRegisterNewUser() {

        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyField("id", not(emptyString())));
    }

    @Test
    public void testCanNotRegisterSameUserTwice() {

        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .shouldHave(Conditions.bodyField("id", not(emptyString())));

        service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR));


    }

    @Test
    public void testCanRegisterNewUserPojo() {

        UserModel user = new UserModel()
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password());

        UserRegistrationResponse responseUser = service.registerUser(user)
                .shouldHave(Conditions.statusCode(HttpStatus.SC_OK))
                .asPojo(UserRegistrationResponse.class);


        responseUser.getId();
    }

}
