package comsocksapim.config;

import org.aeonbits.owner.ConfigFactory;

public interface ProjectConfigImpl {
    ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
}
