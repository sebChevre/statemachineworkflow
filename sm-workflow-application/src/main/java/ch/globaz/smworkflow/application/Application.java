package ch.globaz.smworkflow.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sce on 11.07.2017.
 */
@SpringBootApplication(scanBasePackages = "ch.globaz.smworkflow")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }

}
