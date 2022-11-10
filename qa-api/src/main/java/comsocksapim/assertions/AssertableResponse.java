package comsocksapim.assertions;

import comsocksapim.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {
    public final Response response;
@Step

    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

     public Headers headers(){
        return response.getHeaders();
     }
}
