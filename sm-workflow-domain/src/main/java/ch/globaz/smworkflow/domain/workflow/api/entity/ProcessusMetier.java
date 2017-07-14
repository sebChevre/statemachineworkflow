package ch.globaz.smworkflow.domain.workflow.api.entity;

/**
 * Created by sce on 13.07.2017.
 */
public enum ProcessusMetier {

    PROCESSUS_CREATION_AFFILIATION("creationAffiliation");

    public String name;

    ProcessusMetier(String name){
        this.name = name;
    }

}
