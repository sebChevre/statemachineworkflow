package ch.globaz.smworkflow.application.rest.dto;

import ch.globaz.smworkflow.domain.core.User;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.Tache;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by sce on 13.07.2017.
 */
public class TacheDTO {
    @JsonProperty private User assigneUser;
    @JsonProperty private Date startDate;
    @JsonProperty private Date stopDate;
    @JsonProperty private Boolean isComplete = Boolean.FALSE;
    @JsonProperty private Boolean isStarted;
    @JsonProperty private States workFlowState;

    public static TacheDTO from(Tache tache){
        TacheDTO dto = new TacheDTO();
        dto.setAssigneUser(tache.assignedTo());
        dto.setComplete(tache.isCompleted());
        dto.setStartDate(tache.startDate());
        dto.setWorkFlowState(tache.workFlowState());
        return dto;
    }

    public User getAssigneUser() {
        return assigneUser;
    }

    public void setAssigneUser(User assigneUser) {
        this.assigneUser = assigneUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Boolean getIsStarted() {
        return isStarted;
    }

    public void setStarted(Boolean started) {
        isStarted = started;
    }

    public States getWorkFlowState() {
        return workFlowState;
    }

    public void setWorkFlowState(States workFlowState) {
        this.workFlowState = workFlowState;
    }
}
