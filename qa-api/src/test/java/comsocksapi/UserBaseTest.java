package comsocksapi;

import com.github.javafaker.Faker;
import comsocksapim.config.ProjectConfigImpl;
import comsocksapim.services.UserApiService;

import java.util.Locale;

public class UserBaseTest implements ProjectConfigImpl {
    protected final UserApiService service = new UserApiService();

    protected final Faker faker = new Faker(new Locale(config.locale()));

}
