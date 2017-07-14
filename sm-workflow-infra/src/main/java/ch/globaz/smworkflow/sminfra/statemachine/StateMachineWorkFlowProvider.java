package ch.globaz.smworkflow.sminfra.statemachine;

import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.ProcessusMetier;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;

import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import ch.globaz.smworkflow.domain.workflow.spi.WorkFlowProvider;
import ch.globaz.smworkflow.sminfra.repository.entity.StateMachineWorkFlow;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * Created by sce on 11.07.2017.
 */
@Component
public class StateMachineWorkFlowProvider implements WorkFlowProvider{

    static org.springframework.statemachine.config.StateMachineBuilder.Builder<States,Events> builder = org.springframework.statemachine.config.StateMachineBuilder.builder();


    static {
        try {
            builder.configureConfiguration()
                    .withConfiguration()
                    .machineId(ProcessusMetier.PROCESSUS_CREATION_AFFILIATION.name)
                    .beanFactory(new StaticListableBeanFactory())
                    .listener(new StateMachineListener());

            builder.configureStates()
                    .withStates()
                    .initial(States.SAISIR_DEMANDE)
                    .choice(States.PSEUDO_DECIDER_DEMANDE)
                    .states(EnumSet.allOf(States.class))
                    .end(States.TERMINER_PROCESS);

            builder.configureTransitions()

                    .withExternal()
                    .source(States.SAISIR_DEMANDE).target(States.VERIFIER_PROSPECT).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.DEMANDE_SAISIE)
                    .and()

                    .withExternal()
                    .source(States.VERIFIER_PROSPECT).target(States.DECIDER_DEMANDE).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.VERIFICATION_EFFECTUEE)
                    .and()

                    .withExternal()
                    .source(States.DECIDER_DEMANDE).target(States.PSEUDO_DECIDER_DEMANDE).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.DEMANDE_DECIDE)
                    .and()

                    .withExternal()
                    .source(States.CREER_AFFILIATION).target(States.VALIDER_AFFILIATION).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.AFFILIATION_CREE)
                    .and()

                    .withExternal()
                    .source(States.VALIDER_AFFILIATION).target(States.ANNONCER_AFFILIATION).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.AFFILIATION_VALIDEE)
                    .and()

                    .withExternal()
                    .source(States.ANNONCER_AFFILIATION).target(States.TERMINER_PROCESS).action((context)-> {
                        System.out.println("jdlasdkhlas");
                        System.out.print(context.getEvent());
                    })
                    .event(Events.AFFILIATION_ANNONCEE)
                    .and()

                    .withChoice()
                    .source(States.PSEUDO_DECIDER_DEMANDE)
                    .first(States.CREER_AFFILIATION, (context)-> {

                        return false;
                    })
                    .last(States.TERMINER_PROCESS);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static StateMachine<States,Events> getStateMachine () {
        return builder.build();
    }

    @Override
    public WorkFlow newInstance() {
        StateMachine<States,Events> stateMachine = getStateMachine();
        stateMachine.start();
        return StateMachineWorkFlow.with(stateMachine);
    }
}
