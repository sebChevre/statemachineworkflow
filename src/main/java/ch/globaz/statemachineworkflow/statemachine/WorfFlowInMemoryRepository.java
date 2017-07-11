package ch.globaz.statemachineworkflow.statemachine;

import ch.globaz.statemachineworkflow.repository.WorkFlowRepository;
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
    public void create(StateMachine workflow) {
        this.datasource.put(workflow.getUuid().toString(),workflow);
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
