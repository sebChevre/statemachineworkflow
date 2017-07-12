package ch.globaz.smworkflow.domain.repository;


import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import org.springframework.statemachine.StateMachine;

import java.util.Map;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkFlowRepository {

    public void create(Workflow stateMachine);

    public Map<String, StateMachine<States, Events>> getWorflows();

    public StateMachine<States,Events> getByUUID(String uuid);

}
