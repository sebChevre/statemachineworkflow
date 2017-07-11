package ch.globaz.statemachineworkflow;

import ch.globaz.statemachineworkflow.repository.WorkFlowRepository;
import ch.globaz.statemachineworkflow.statemachine.Events;
import ch.globaz.statemachineworkflow.statemachine.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sce on 11.07.2017.
 */
@RestController
public class Controller {

    @Autowired
    StateMachineFactory<States, Events> factory;

    @Autowired
    WorkFlowRepository repo;

    @RequestMapping(value = {"/process/init"}, method = RequestMethod.GET)
    public void initProcess(){
        StateMachine<States,Events> workflow = factory.getStateMachine();
        workflow.start();
        repo.create(workflow);
        System.out.println("Workflow created: " + workflow.getUuid() +", initialState: " + workflow.getInitialState().getId() +", currentState:"  + workflow.getState());
    }

    @RequestMapping(value = {"/process"}, method = RequestMethod.GET)
    public void saisirDemande(){

        repo.getWorflows().forEach((e,a)->{
            System.out.println(e +","+a);
        });

    }

    @RequestMapping(value = {"/process/{processId}/saisirDemande"}, method = RequestMethod.GET)
    public void saisirDemande(@PathVariable("processId") String processId){



        StateMachine<States,Events> workflow = repo.getByUUID(processId);

        if(null != workflow){
            boolean trans = workflow.sendEvent(Events.DEMANDE_INITIE);
            System.out.println("Workflow transition["+trans+"]: " + workflow.getUuid() +", initialState: " + workflow.getInitialState().getId() +", currentState:"  + workflow.getState());

        }

    }

    @RequestMapping(value = {"/process/{processId}/initierDemande"}, method = RequestMethod.GET)
    public void initierDemande(@PathVariable("processId") String processId){



        StateMachine<States,Events> workflow = repo.getByUUID(processId);

        if(null != workflow){
            boolean trans = workflow.sendEvent(Events.DEMANDE_INITIE);
            System.out.println("Workflow transition["+trans+"]: " + workflow.getUuid() +", initialState: " + workflow.getInitialState().getId() +", currentState:"  + workflow.getState());

        }

    }




}
