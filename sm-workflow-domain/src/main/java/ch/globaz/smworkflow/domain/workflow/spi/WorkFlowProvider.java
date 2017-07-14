package ch.globaz.smworkflow.domain.workflow.spi;

import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;

/**
 * Created by sce on 13.07.2017.
 */
public interface WorkFlowProvider {

    public WorkFlow newInstance();
}
