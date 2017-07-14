package ch.globaz.smworkflow.domain.workflow.api.entity;

import ch.globaz.smworkflow.domain.core.User;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Date;

/**
 * Created by sce on 11.07.2017.
 */

public interface Tache {

    public Date startDate();

    public void setStartedDate(Date date);

    public User assignedTo();

    public Date completeDate();

    public void setCompleteDate(Date date);

    public boolean isCompleted();

    public void setCompleted();

    public States workFlowState();

    public Integer getOrderPosition();
}
