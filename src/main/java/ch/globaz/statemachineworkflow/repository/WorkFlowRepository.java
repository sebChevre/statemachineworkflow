package ch.globaz.statemachineworkflow.repository;

import ch.globaz.statemachineworkflow.statemachine.Events;
import ch.globaz.statemachineworkflow.statemachine.States;
import org.springframework.statemachine.StateMachine;

import java.util.Map;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkFlowRepository {

    public void create(StateMachine<States,Events> stateMachine);

    public Map<String, StateMachine<States, Events>> getWorflows();

    public StateMachine<States,Events> getByUUID(String uuid);

}
