package ch.globaz.smworkflow.application;

import ch.globaz.smworkflow.application.rest.dto.DemandeDTO;
import ch.globaz.smworkflow.application.rest.dto.WorkFlowDTO;
import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.demande.service.DemandeService;
import ch.globaz.smworkflow.domain.workflow.service.WorkFlowService;
import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;

import ch.globaz.smworkflow.sminfra.repository.entity.DemandeAffiliation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 11.07.2017.
 */
@RestController
public class Controller {



    @Autowired
    WorkFlowService workFlowService;
    @Autowired
    DemandeService demandeService;

    @RequestMapping(value = {"/process/init"}, method = RequestMethod.POST)
    public ResponseEntity<WorkFlowDTO> initProcess(@RequestBody final WorkFlowDTO dto){
        //StateMachineWorkFlow<States,Events> workFlow = StateMachineWorkFlow.with(factory.getStateMachine());

        WorkFlow<States,Events> workFlow = workFlowService.initilialiseWorkFlow();
        workFlowService.sauveWorkFlow(workFlow);
        dto.setUuid(workFlow.getUuid());
        dto.setTaches(workFlow.getListTaches());
        dto.setEtatInitial(workFlow.getInitialState());
        dto.setEtatCourant(workFlow.getState());
        dto.setEtatSuivant(workFlow.getEtatSuivant());

        return new ResponseEntity<WorkFlowDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/process"}, method = RequestMethod.GET)
    public ResponseEntity<List<WorkFlowDTO>> listeProcess(){

        List<WorkFlowDTO> workflows = new ArrayList<>();


        System.out.println("ok");

        workFlowService.listeWorkFlow().forEach(w->{
            workflows.add(WorkFlowDTO.from(w));
        });

        return new ResponseEntity<List<WorkFlowDTO>>(workflows,HttpStatus.OK);

    }

    @RequestMapping(value = {"/process/saisirDemande"}, method = RequestMethod.POST)
    public void saisirDemande(@RequestBody final DemandeDTO dto){

        Demande demande1 = DemandeDTO.toDemande(dto);
        //FAKE for persist test !!!
        Demande demande = new DemandeAffiliation();
        //demande.setId("dasdasdasdas");
        demande.setAccepte(Boolean.TRUE);
        //END FAKE
        demande = demandeService.sauveDemande(demande);


        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());
        workFlow.setUser(dto.getAssignedUser());

        if(null != workFlow){

            workFlowService.saisirDemande(workFlow,demande);

        }

    }

    @RequestMapping(value = {"/process/verifierProspect"}, method = RequestMethod.POST)
    public void verifierProspect(@RequestBody final DemandeDTO dto){

        System.out.println(dto.getProcessId());

        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());

        if(null != workFlow){
            //workFlow.
            boolean trans = workFlow.sendEvent(Events.VERIFICATION_EFFECTUEE);
            System.out.println("WorkFlow transition["+trans+"]: " + workFlow.getUuid() +", initialState: " + workFlow.getInitialState() +", currentState:"  + workFlow.getState());

        }

    }



    @RequestMapping(value = {"/process/deciderDemande"}, method = RequestMethod.POST)
    public void deciderDemande(@RequestBody final DemandeDTO dto){

        System.out.println(dto.getProcessId());

        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());

        if(null != workFlow){
            //workFlow.
            boolean trans = workFlow.sendEvent(Events.DEMANDE_DECIDE);
            System.out.println("WorkFlow transition["+trans+"]: " + workFlow.getUuid() +", initialState: " + workFlow.getInitialState() +", currentState:"  + workFlow.getState());

        }

    }

    @RequestMapping(value = {"/process/creerAffiliation"}, method = RequestMethod.POST)
    public void creerAffiliation(@RequestBody final DemandeDTO dto){

        System.out.println(dto.getProcessId());

        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());

        if(null != workFlow){
            //workFlow.
            boolean trans = workFlow.sendEvent(Events.AFFILIATION_CREE);
            System.out.println("WorkFlow transition["+trans+"]: " + workFlow.getUuid() +", initialState: " + workFlow.getInitialState() +", currentState:"  + workFlow.getState());

        }

    }

    @RequestMapping(value = {"/process/validerAffiliation"}, method = RequestMethod.POST)
    public void validerAffiliation(@RequestBody final DemandeDTO dto){

        System.out.println(dto.getProcessId());

        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());

        if(null != workFlow){
            //workFlow.
            boolean trans = workFlow.sendEvent(Events.AFFILIATION_VALIDEE);
            System.out.println("WorkFlow transition["+trans+"]: " + workFlow.getUuid() +", initialState: " + workFlow.getInitialState() +", currentState:"  + workFlow.getState());

        }

    }

    @RequestMapping(value = {"/process/annoncerAffiliation"}, method = RequestMethod.POST)
    public void annoncerAffiliation(@RequestBody final DemandeDTO dto){

        System.out.println(dto.getProcessId());

        WorkFlow<States,Events> workFlow = workFlowService.chargeParIdentifiant(dto.getProcessId());

        if(null != workFlow){
            //workFlow.
            boolean trans = workFlow.sendEvent(Events.AFFILIATION_ANNONCEE);
            System.out.println("WorkFlow transition["+trans+"]: " + workFlow.getUuid() +", initialState: " + workFlow.getInitialState() +", currentState:"  + workFlow.getState());

        }

    }


}
