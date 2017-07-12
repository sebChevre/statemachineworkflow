package ch.globaz.smworkflow.application.statemachine;

import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * Created by sce on 11.07.2017.
 */
@Configuration
@EnableStateMachineFactory
public class WorkFlowFactory extends EnumStateMachineConfigurerAdapter<States,Events>{

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .listener(new StateMachineListener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.DEMANDE_EN_ENTREE)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.DEMANDE_EN_ENTREE).target(States.SAISIR_DEMANDE)
                .event(Events.DEMANDE_INITIE)
                .and()
                .withExternal()
                .source(States.SAISIR_DEMANDE).target(States.DEMANDE_A_VERIFIER)
                .event(Events.DEMANDE_SAISIE);
    }
}