package ch.globaz.smworkflow.application.rest.dto;

import ch.globaz.smworkflow.domain.core.User;
import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.sminfra.repository.entity.DemandeAffiliation;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sce on 12.07.2017.
 */
public class DemandeDTO {

    @JsonProperty String processId;
    @JsonProperty String demandeId;
    @JsonProperty Boolean isAccepte;
    @JsonProperty User assignedUser;


    public static Demande toDemande(DemandeDTO dto){
        DemandeAffiliation d = new DemandeAffiliation();
        d.setAccepte(dto.getIsAccepte());
        return d;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }



    public Boolean getIsAccepte() {
        return isAccepte;
    }

    public void setIsAccepte(Boolean isAccepte) {
        this.isAccepte = isAccepte;
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
