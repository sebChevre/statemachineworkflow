package ch.globaz.smworkflow.domain.spi;

import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;

import java.util.List;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkFlowService {

    public Workflow getNewInstance(String username);

    public Workflow create(Workflow workFlow);

    public List<Workflow<States,Events>> getWorkFlows();

    public Workflow getByUUID(String uuid);

}
