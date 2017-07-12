package ch.globaz.smworkflow.sminfra.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

/**
 * Created by sce on 11.07.2017.
 */
@Configuration
public class SMListener extends StateMachineListenerAdapter {

    @Override
    public void stateChanged(State from, State to) {
        System.out.println("*********************************************************************");
        System.out.printf("Transition depuis %s a %s%n", from == null ?
                "sans état" : from.getId(), to.getId());

        System.out.println("*********************************************************************");
    }
}
