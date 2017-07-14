package ch.globaz.smworkflow.sminfra.repository.entity;

import ch.globaz.smworkflow.domain.core.User;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.Tache;

import java.util.Date;

/**
 * Created by sce on 13.07.2017.
 */
public class WorkFlowTache implements Tache{

    private User assigneUser;
    private Date startDate;
    private Date stopDate;
    private Boolean isComplete = Boolean.FALSE;
    private Boolean isStarted;
    private States workFlowState;

    public static Tache with(States workFlowState){
        Tache t = new WorkFlowTache(workFlowState);
        return t;
    }

    private WorkFlowTache(States workFlowState){
        this.workFlowState = workFlowState;
    }

    @Override
    public Date startDate() {
        return startDate;
    }

    @Override
    public void setStartedDate(Date date) {
        this.startDate = date;
    }

    @Override
    public User assignedTo() {
        return assigneUser;
    }

    @Override
    public Date completeDate() {
        return completeDate();
    }

    @Override
    public void setCompleteDate(Date date) {
        this.stopDate = date;
    }

    @Override
    public boolean isCompleted() {
        return isComplete;
    }

    @Override
    public void setCompleted() {

    }

    @Override
    public States workFlowState() {
        return workFlowState;
    }

    @Override
    public Integer getOrderPosition() {
        return workFlowState.order;
    }
}
