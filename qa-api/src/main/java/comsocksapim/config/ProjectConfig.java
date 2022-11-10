package comsocksapim.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config.properties", "classpath:user/user.properties"})

public interface ProjectConfig extends Config {

    String env();
@Key("${env}.base.url")
    String baseUrl();
    String locale();
    boolean logging();
}
