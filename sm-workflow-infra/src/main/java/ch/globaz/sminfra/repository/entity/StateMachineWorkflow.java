package ch.globaz.sminfra.repository.entity;

import ch.globaz.smworkflow.domain.model.Workflow;
import org.springframework.statemachine.StateMachine;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class StateMachineWorkflow implements Workflow {

    private StateMachine stateMachine;

    private StateMachineWorkflow(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public static StateMachineWorkflow with(StateMachine stateMachine){
        return new StateMachineWorkflow(stateMachine);
    }

    @Override
    public String getUserName() {
        return null;
    }

    public StateMachine getStateMachine(){
        return stateMachine;
    }
}
