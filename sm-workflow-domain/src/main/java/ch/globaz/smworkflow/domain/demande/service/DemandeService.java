package ch.globaz.smworkflow.domain.demande.service;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.workflow.api.entity.Tache;

/**
 * Created by sce on 13.07.2017.
 */
public interface DemandeService {
    Demande sauveDemande(Demande demande);


}
