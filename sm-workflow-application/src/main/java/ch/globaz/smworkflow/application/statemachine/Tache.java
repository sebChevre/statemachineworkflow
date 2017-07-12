package ch.globaz.smworkflow.application.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by sce on 11.07.2017.
 */

public class Tache {

    @OnTransition(target = "DEMANDE_EN_ENTREE")
    public void toDemandeEnEntree() {

        System.out.println();

    }




    @OnTransition(target = "DEMANDE_SAISIE")
    void toDemandeSaisie() {
       // System.out.println("DEMANDE_SAISIE");
    }
}
