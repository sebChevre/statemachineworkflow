package ch.globaz.smworkflow.sminfra.repository;


import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import ch.globaz.smworkflow.domain.workflow.spi.WorkFlowRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by sce on 11.07.2017.
 */
@Repository
public class WorkFlowInMemoryRepository implements WorkFlowRepository {

    final Map<String,WorkFlow<States,Events>> datasource = new HashMap<String,WorkFlow<States, Events>>();


    @Override
    public WorkFlow<States,Events> create(WorkFlow stateMachine) {

        datasource.putIfAbsent(stateMachine.getUuid(),stateMachine);

        return stateMachine;
    }



    @Override
    public List<WorkFlow<States, Events>> getWorflows() {

        return this.datasource.values().stream().collect(Collectors.toList());
    }

    @Override
    public WorkFlow<States, Events> getByUUID(String uuid) {

        if(datasource.containsKey(uuid)){
            return datasource.get(uuid);
        }

        return null;
    }

    @Override
    public WorkFlow update(WorkFlow workFlow) {

       datasource.put(workFlow.getUuid(),workFlow);

       return workFlow;
    }


}
