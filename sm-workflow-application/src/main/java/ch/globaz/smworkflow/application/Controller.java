package ch.globaz.smworkflow.application;

import ch.globaz.smworkflow.application.rest.dto.SaisirDemandeDTO;
import ch.globaz.smworkflow.application.rest.dto.WorkFlowDTO;
import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;

import ch.globaz.smworkflow.domain.spi.WorkFlowService;
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

    @RequestMapping(value = {"/process/init"}, method = RequestMethod.POST)
    public ResponseEntity<WorkFlowDTO> initProcess(@RequestBody final WorkFlowDTO dto){
        //StateMachineWorkflow<States,Events> workflow = StateMachineWorkflow.with(factory.getStateMachine());

        Workflow<States,Events> workflow = workFlowService.getNewInstance(dto.getUserName());
        workflow.start();
        workFlowService.create(workflow);
        dto.setUuid(workflow.getUuid());
        return new ResponseEntity<WorkFlowDTO>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/process"}, method = RequestMethod.GET)
    public ResponseEntity<List<WorkFlowDTO>> saisirDemande(){

        List<WorkFlowDTO> workflows = new ArrayList<>();


        workFlowService.getWorkFlows().forEach(w->{
            workflows.add(WorkFlowDTO.from(w));
        });

        return new ResponseEntity<List<WorkFlowDTO>>(workflows,HttpStatus.OK);

    }


    @RequestMapping(value = {"/process/saisirDemande"}, method = RequestMethod.POST)
    public void saisirDemande(@RequestBody final SaisirDemandeDTO dto){

        System.out.println(dto.getProcessId());

        Workflow<States,Events> workflow = workFlowService.getByUUID(dto.getProcessId());

        if(null != workflow){
            //workflow.
            boolean trans = workflow.sendEvent(Events.DEMANDE_SAISIE);
            System.out.println("Workflow transition["+trans+"]: " + workflow.getUuid() +", initialState: " + workflow.getInitialState() +", currentState:"  + workflow.getState());

        }

    }
/*
    @RequestMapping(value = {"/process/{processId}/initierDemande"}, method = RequestMethod.GET)
    public void initierDemande(@PathVariable("processId") String processId){



        Workflow<States,Events> workflow = repo.getByUUID(processId);

        if(null != workflow){
            boolean trans = workflow.sendEvent(Events.DEMANDE_INITIE);
            System.out.println("Workflow transition["+trans+"]: " + workflow.getUuid() +", initialState: " + workflow.getInitialState() +", currentState:"  + workflow.getState());

        }

    }
*/



}
