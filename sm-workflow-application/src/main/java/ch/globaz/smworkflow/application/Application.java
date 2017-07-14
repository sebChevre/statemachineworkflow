package ch.globaz.smworkflow.application;


import ch.globaz.smworkflow.sminfra.repository.entity.DemandeAffiliation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.action.Action;

/**
 * Created by sce on 11.07.2017.
 */
@SpringBootApplication(scanBasePackages = "ch.globaz.smworkflow")
@EntityScan(basePackageClasses=DemandeAffiliation.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }

    @Bean
    public Action action1 () {
        return null;
    }

}
