package comsocksapim.services;

import comsocksapim.assertions.AssertableResponse;
import comsocksapim.models.UserModel;
import io.qameta.allure.Step;

public class UserApiService extends ApiService {
    @Step
    public AssertableResponse registerUser(UserModel user) {

        return new AssertableResponse(request()
                .body(user)
                .when()
                .post("register"));


    }
}
