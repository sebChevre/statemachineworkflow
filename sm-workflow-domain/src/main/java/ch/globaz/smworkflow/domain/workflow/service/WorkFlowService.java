package ch.globaz.smworkflow.domain.workflow.service;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sce on 13.07.2017.
 */

public interface WorkFlowService {

    public WorkFlow initilialiseWorkFlow();

    public WorkFlow sauveWorkFlow(WorkFlow workFlow);

    public List<WorkFlow<States, Events>> listeWorkFlow();

    public WorkFlow chargeParIdentifiant(String uuid);

    WorkFlow saisirDemande(WorkFlow workFlow, Demande demande);
}
