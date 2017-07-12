package ch.globaz.sminfra.repository;


import ch.globaz.sminfra.repository.entity.StateMachineWorkflow;
import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import ch.globaz.smworkflow.domain.repository.WorkFlowRepository;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sce on 11.07.2017.
 */
@Component
public class WorfFlowInMemoryRepository implements WorkFlowRepository {

    Map<String,StateMachine<States,Events>> datasource = new HashMap<String,StateMachine<States, Events>>();


    @Override
    public void create(Workflow stateMachine) {

        ((StateMachineWorkflow)stateMachine).getStateMachine();
    }



    @Override
    public Map<String, StateMachine<States, Events>> getWorflows() {

        return this.datasource;
    }

    @Override
    public StateMachine<States, Events> getByUUID(String uuid) {

        if(datasource.containsKey(uuid)){
            return datasource.get(uuid);
        }

        return null;
    }


}
