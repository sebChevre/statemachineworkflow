package ch.globaz.smworkflow.sminfra.repository.entity;

import ch.globaz.smworkflow.domain.core.User;
import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.Tache;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import org.springframework.statemachine.StateMachine;

import java.util.*;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class StateMachineWorkFlow implements WorkFlow<States,Events> {

    private StateMachine<States,Events> stateMachine;
    private User user;
    private List<Tache> tasksList;

    private StateMachineWorkFlow(StateMachine<States,Events> stateMachine) {

        this.stateMachine = stateMachine;
        initTasksList();
    }

    public static StateMachineWorkFlow with(StateMachine stateMachine){

       return new StateMachineWorkFlow(stateMachine);
    }


    private void initTasksList(){
        tasksList = new ArrayList<Tache>();
        tasksList.add(WorkFlowTache.with(States.SAISIR_DEMANDE));
        tasksList.add(WorkFlowTache.with(States.VERIFIER_PROSPECT));
        tasksList.add(WorkFlowTache.with(States.DECIDER_DEMANDE));
        tasksList.add(WorkFlowTache.with(States.CREER_AFFILIATION));
        tasksList.add(WorkFlowTache.with(States.VALIDER_AFFILIATION));
        tasksList.add(WorkFlowTache.with(States.ANNONCER_AFFILIATION));

        tasksList.sort(Comparator.comparing(Tache::getOrderPosition));


    }

    @Override
    public Tache getTacheCourante() {
        States current = getState();

        Optional<Tache> tacheCourante = tasksList.stream().filter(t->{
            return t.workFlowState().equals(current);
        }).findFirst();

        return tacheCourante.isPresent()?tacheCourante.get():null;
    }

    @Override
    public States getEtatSuivant() {
        States courant = getState();

        return courant.getNext();

    }

    @Override
    public List<Tache> getListTaches() {
        return tasksList;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        stateMachine.start();
       // stateMachine.getState().
    }

    public StateMachine getStateMachine(){
        return stateMachine;
    }

    public String getUuid() {
        return stateMachine.getUuid().toString();
    }

    @Override
    public States getInitialState() {
        return stateMachine.getInitialState().getId();
    }

    @Override
    public States getState() {
        return stateMachine.getState().getId();
    }

    @Override
    public boolean sendEvent(Events demandeInitie) {
        return stateMachine.sendEvent(demandeInitie);
    }
}
