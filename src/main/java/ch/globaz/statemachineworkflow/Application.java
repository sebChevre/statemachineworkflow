package ch.globaz.statemachineworkflow;

import ch.globaz.statemachineworkflow.statemachine.Events;
import ch.globaz.statemachineworkflow.statemachine.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;

/**
 * Created by sce on 11.07.2017.
 */
@SpringBootApplication
public class Application {




    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }




}
