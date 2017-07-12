package ch.globaz.smworkflow.domain.repository;


import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkFlowRepository {

    public Workflow<States,Events> create(Workflow stateMachine);

    public Map<String, Workflow<States, Events>> getWorflows();

    public Workflow<States,Events> getByUUID(String uuid);

}
