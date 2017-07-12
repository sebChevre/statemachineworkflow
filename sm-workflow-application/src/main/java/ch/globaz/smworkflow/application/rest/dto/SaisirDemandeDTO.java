package ch.globaz.smworkflow.application.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sce on 12.07.2017.
 */
public class SaisirDemandeDTO {

    @JsonProperty String processId;
    @JsonProperty String demandeId;
    @JsonProperty Boolean acceptePath;

    public Boolean getAcceptePath() {
        return acceptePath;
    }

    public void setAcceptePath(Boolean acceptePath) {
        this.acceptePath = acceptePath;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getDemandeId() {
        return demandeId;
    }

    public void setDemandeId(String demandeId) {
        this.demandeId = demandeId;
    }
}
