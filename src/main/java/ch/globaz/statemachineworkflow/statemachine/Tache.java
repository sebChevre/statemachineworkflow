package ch.globaz.statemachineworkflow.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.annotation.OnStateMachineError;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by sce on 11.07.2017.
 */
@WithStateMachine
public class Tache {

    @OnTransition(target = "DEMANDE_EN_ENTREE")
    public void toDemandeEnEntree() {

       // System.out.println("DEMANDE_EN_ENTREE");
    }

    @OnStateMachineError


    @OnTransition(target = "DEMANDE_SAISIE")
    void toDemandeSaisie() {
       // System.out.println("DEMANDE_SAISIE");
    }
}
