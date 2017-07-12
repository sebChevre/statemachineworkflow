package ch.globaz.smworkflow.domain.repository;

import ch.globaz.smworkflow.domain.model.Demande;

/**
 * Created by sce on 12.07.2017.
 */
public interface DemandeRepository {

    public Demande getById(String id);

    public Demande create(Demande demande);
}
