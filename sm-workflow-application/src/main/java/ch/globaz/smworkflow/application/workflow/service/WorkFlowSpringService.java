package ch.globaz.smworkflow.application.workflow.service;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.demande.service.DemandeService;
import ch.globaz.smworkflow.domain.workflow.service.WorkFlowService;
import ch.globaz.smworkflow.domain.workflow.spi.WorkFlowRepository;
import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import ch.globaz.smworkflow.domain.workflow.spi.WorkFlowProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sce on 13.07.2017.
 */
@Service
public class WorkFlowSpringService implements WorkFlowService {

    @Autowired
    WorkFlowRepository workFlowRepository;
    @Autowired
    WorkFlowProvider workFlowProvider;
    @Autowired
    DemandeService demandeService;

    @Override
    public WorkFlow initilialiseWorkFlow() {
        WorkFlow<States,Events> workFlow = workFlowProvider.newInstance();
        return workFlowRepository.create(workFlow);
    }

    @Override
    public WorkFlow sauveWorkFlow(WorkFlow workFlow) {
        return workFlowRepository.create(workFlow);
    }

    @Override
    public List<WorkFlow<States, Events>> listeWorkFlow() {
        return workFlowRepository.getWorflows();
    }

    @Override
    public WorkFlow chargeParIdentifiant(String uuid) {
        return workFlowRepository.getByUUID(uuid);
    }

    @Override
    public WorkFlow saisirDemande(WorkFlow workFlow, Demande demande){

        workFlow.getTacheCourante().setCompleted();
        workFlow.getTacheCourante().setCompleteDate(new Date());
        updateWorkFlow(workFlow);
        workFlow.sendEvent(Events.DEMANDE_SAISIE);
        return workFlow;
    }

    private WorkFlow updateWorkFlow(WorkFlow workFlow) {

        return workFlowRepository.update(workFlow);
    }
}
