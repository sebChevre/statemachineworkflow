package ch.globaz.smworkflow.sminfra.repository;


import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import ch.globaz.smworkflow.domain.repository.WorkFlowRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sce on 11.07.2017.
 */
@Component
public class WorfFlowInMemoryRepository implements WorkFlowRepository {

    final Map<String,Workflow<States,Events>> datasource = new HashMap<String,Workflow<States, Events>>();


    @Override
    public Workflow<States,Events> create(Workflow stateMachine) {

        datasource.putIfAbsent(stateMachine.getUuid(),stateMachine);

        return stateMachine;
    }



    @Override
    public Map<String, Workflow<States, Events>> getWorflows() {

        return this.datasource;
    }

    @Override
    public Workflow<States, Events> getByUUID(String uuid) {

        if(datasource.containsKey(uuid)){
            return datasource.get(uuid);
        }

        return null;
    }


}
