package ch.globaz.smworkflow.domain.spi;

import ch.globaz.smworkflow.domain.model.Workflow;

/**
 * Created by sce on 11.07.2017.
 */

public interface WorkflowService {

    public Workflow getNewInstance();
}
