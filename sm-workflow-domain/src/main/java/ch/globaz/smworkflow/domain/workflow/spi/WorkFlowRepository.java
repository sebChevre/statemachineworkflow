package ch.globaz.smworkflow.domain.workflow.spi;


import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;

import java.util.List;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkFlowRepository {

    public WorkFlow<States,Events> create(WorkFlow stateMachine);

    public List<WorkFlow<States, Events>> getWorflows();

    public WorkFlow<States,Events> getByUUID(String uuid);

    WorkFlow update(WorkFlow workFlow);
}
