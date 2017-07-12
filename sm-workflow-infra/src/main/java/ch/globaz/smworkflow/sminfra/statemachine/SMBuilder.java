package ch.globaz.smworkflow.sminfra.statemachine;

import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import ch.globaz.smworkflow.sminfra.repository.entity.StateMachineWorkflow;

import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

/**
 * Created by sce on 11.07.2017.
 */
public class SMBuilder {

    static StateMachineBuilder.Builder<States,Events> builder = StateMachineBuilder.builder();


    static {
        try {
            builder.configureConfiguration()
                    .withConfiguration()
                    .beanFactory(new StaticListableBeanFactory())
                    .listener(new SMListener());

            builder.configureStates()
                    .withStates()
                    .initial(States.SAISIR_DEMANDE)
                    .choice(States.VERIFIER_PROSPECT)
                    .states(EnumSet.allOf(States.class))
                    .end(States.ANNONCER_AFFILIATION);

            builder.configureTransitions()

                    .withExternal()
                    .source(States.SAISIR_DEMANDE).target(States.VERIFIER_PROSPECT).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.DEMANDE_SAISIE)
                    .and()



                    .withChoice()
                    .source(States.VERIFIER_PROSPECT)
                    .first(States.ACCEPTER_DEMANDE, (context)-> {
                        return false;
                    })
                    .last(States.ANNONCER_AFFILIATION);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Workflow<States,Events> getWorkflow () {

        return StateMachineWorkflow.with(builder.build());
    }

}
