package ch.globaz.smworkflow.application.statemachine;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

/**
 * Created by sce on 11.07.2017.
 */
public class WorkFlowBuilder {

    static StateMachineBuilder.Builder<States,Events> builder = StateMachineBuilder.builder();


    static {
        try {
            builder.configureConfiguration().withConfiguration().listener(new StateMachineListener());

            builder.configureStates()
                    .withStates()
                    .initial(States.DEMANDE_EN_ENTREE)
                    .states(EnumSet.allOf(States.class));

            builder.configureTransitions().withExternal()
                    .source(States.DEMANDE_EN_ENTREE).target(States.SAISIR_DEMANDE)
                    .event(Events.DEMANDE_INITIE)
                    .and()
                    .withExternal()
                    .source(States.SAISIR_DEMANDE).target(States.DEMANDE_A_VERIFIER)
                    .event(Events.DEMANDE_SAISIE);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static StateMachine<States,Events> getWorkflow () {
        return builder.build();
    }

}
