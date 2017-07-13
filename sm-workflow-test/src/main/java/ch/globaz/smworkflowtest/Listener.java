package ch.globaz.smworkflowtest;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Listener extends StateMachineListenerAdapter {
    @Override
    public void stateChanged(State from, State to) {
        System.out.println("*********************************************************************");
        System.out.printf("Transition depuis %s a %s%n", from == null ?
                "sans état" : from.getId(), to.getId());

        System.out.println("*********************************************************************");
    }

}
