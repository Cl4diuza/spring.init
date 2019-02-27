package th.co.aware.etda.ws.dopa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaRepositories(basePackages = "th.co.aware.etda.ws.dopa.repository")
@EntityScan(basePackages="th.co.aware.etda.ws.dopa.entity")
@EnableTransactionManagement
@ComponentScan({"th.co.aware.etda.ws.dopa.*"})
public class DatasourceConfig {

}
