package comsocksapim.services;

import comsocksapim.assertions.AssertableResponse;
import comsocksapim.models.UserModel;

public class UserApiService extends ApiService {
    public AssertableResponse registerUser(UserModel user) {

        return new AssertableResponse(request()
                .body(user)
                .when()
                .post("register"));


    }
}
