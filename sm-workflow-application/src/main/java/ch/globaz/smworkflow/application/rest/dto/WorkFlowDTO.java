package ch.globaz.smworkflow.application.rest.dto;

import ch.globaz.smworkflow.domain.core.User;
import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.States;
import ch.globaz.smworkflow.domain.workflow.api.entity.Tache;
import ch.globaz.smworkflow.domain.workflow.api.entity.WorkFlow;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sce on 12.07.2017.
 */
public class WorkFlowDTO {


    @JsonProperty private User user;
    @JsonProperty private String uuid;
    @JsonProperty private List<TacheDTO> taches;
    @JsonProperty private States etatCourant;
    @JsonProperty private States etatInitial;
    @JsonProperty private States etatSuivant;


    public static WorkFlowDTO from(WorkFlow<States,Events> workFlow){
        WorkFlowDTO dto = new WorkFlowDTO();
        dto.setUser(workFlow.getUser());
        dto.setUuid(workFlow.getUuid());
        dto.setEtatCourant(workFlow.getState());
        dto.setEtatInitial(workFlow.getInitialState());
        dto.setEtatSuivant(workFlow.getEtatSuivant());
        dto.setTaches(workFlow.getListTaches());

        return dto;
    }

    public User getUser() {
        return user;
    }



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setTaches(List<Tache> taches) {

        this.taches = taches.stream().map(tache->{
            return TacheDTO.from(tache);
        }).collect(Collectors.toList());
    }

    public List<TacheDTO> getTaches(){
        return taches;
    }

    public void setEtatInitial(States etatInitial) {
        this.etatInitial = etatInitial;
    }

    public void setEtatCourant(States etatCourant) {
        this.etatCourant = etatCourant;
    }



    public States getEtatCourant() {
        return etatCourant;
    }

    public States getEtatInitial() {
        return etatInitial;
    }

    public States getEtatSuivant() {
        return etatSuivant;
    }

    public void setEtatSuivant(States etatSuivant) {
        this.etatSuivant = etatSuivant;

    }

    public void setUser(User user) {
        this.user = user;
    }
}
