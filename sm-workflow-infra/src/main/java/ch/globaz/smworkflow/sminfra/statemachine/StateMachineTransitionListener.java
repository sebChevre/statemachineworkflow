package ch.globaz.smworkflow.sminfra.statemachine;

import ch.globaz.smworkflow.domain.workflow.api.entity.Events;
import ch.globaz.smworkflow.domain.workflow.api.entity.ProcessusMetier;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by sce on 13.07.2017.
 */
@WithStateMachine
public class StateMachineTransitionListener {

    @OnTransition(target = "SAISIR_DEMANDE")
    public void toSaisirDemande() {

        System.out.println("SaisirDemande task createed");

    }


    @OnTransition(target = "VERIFIER_PROSPECT")
    void toDemandeSaisie() {
        System.out.println("Verification prospect");
    }
}
