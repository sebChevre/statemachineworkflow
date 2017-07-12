package ch.globaz.smworkflow.application.rest.dto;

import ch.globaz.smworkflow.domain.model.Workflow;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sce on 12.07.2017.
 */
public class WorkFlowDTO {


    @JsonProperty private String userName;
    @JsonProperty private String uuid;

    public static WorkFlowDTO from(Workflow workflow){
        WorkFlowDTO dto = new WorkFlowDTO();
        dto.setUsername(workflow.getUserName());
        dto.setUuid(workflow.getUuid());
        return dto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
