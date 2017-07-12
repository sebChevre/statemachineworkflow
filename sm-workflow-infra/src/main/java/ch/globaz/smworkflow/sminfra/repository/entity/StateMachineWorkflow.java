package ch.globaz.smworkflow.sminfra.repository.entity;

import ch.globaz.smworkflow.domain.model.Workflow;
import org.springframework.statemachine.StateMachine;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class StateMachineWorkflow<S,E> implements Workflow<S,E> {

    private StateMachine<S,E> stateMachine;
    private String userName;

    private StateMachineWorkflow(StateMachine<S,E> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public static StateMachineWorkflow with(StateMachine stateMachine){
        return new StateMachineWorkflow(stateMachine);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void start() {
        stateMachine.start();
       // stateMachine.getState().
    }

    public StateMachine getStateMachine(){
        return stateMachine;
    }

    public String getUuid() {
        return stateMachine.getUuid().toString();
    }

    @Override
    public S getInitialState() {
        return stateMachine.getInitialState().getId();
    }

    @Override
    public S getState() {
        return stateMachine.getState().getId();
    }

    @Override
    public boolean sendEvent(E demandeInitie) {
        return stateMachine.sendEvent(demandeInitie);
    }
}
