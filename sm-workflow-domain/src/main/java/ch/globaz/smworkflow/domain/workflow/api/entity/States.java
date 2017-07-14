package ch.globaz.smworkflow.domain.workflow.api.entity;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by sce on 11.07.2017.
 */
public enum States {

    SAISIR_DEMANDE(1),
    VERIFIER_PROSPECT(2),
    DECIDER_DEMANDE(3),
    PSEUDO_DECIDER_DEMANDE(4),
    CREER_AFFILIATION(5),
    VALIDER_AFFILIATION(6),
    ANNONCER_AFFILIATION(7),
    TERMINER_PROCESS(8);

    public Integer order;

    States(Integer order){
        this.order = order;
    }

    public  States getNext() {

        int current = this.order;

        Optional<States> next = Stream.of(States.values()).filter(state -> {
            return state.order == current+1;
        }).findFirst();

        return next.isPresent()?next.get():null;
    }
}
