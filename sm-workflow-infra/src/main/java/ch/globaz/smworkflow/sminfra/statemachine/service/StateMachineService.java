package ch.globaz.smworkflow.sminfra.statemachine.service;


import ch.globaz.smworkflow.sminfra.statemachine.SMBuilder;
import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import ch.globaz.smworkflow.domain.repository.WorkFlowRepository;
import ch.globaz.smworkflow.domain.spi.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sce on 11.07.2017.
 */
@Component
public class StateMachineService implements WorkFlowService {

    @Autowired
    WorkFlowRepository workFlowRepository;

    @Override
    public Workflow getNewInstance(String userName) {
        Workflow<States,Events> workflow = SMBuilder.getWorkflow();
        workflow.setUserName(userName);
        return workFlowRepository.create(workflow);
    }

    @Override
    public Workflow create(Workflow workFlow){
        return workFlowRepository.create(workFlow);
    }

    @Override
    public List<Workflow<States, Events>> getWorkFlows() {

        return workFlowRepository.getWorflows().values().stream().collect(Collectors.toList());
    }

    @Override
    public Workflow getByUUID(String uuid) {
        return workFlowRepository.getByUUID(uuid);
    }
}

