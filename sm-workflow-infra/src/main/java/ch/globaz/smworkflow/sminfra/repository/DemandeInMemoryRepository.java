package ch.globaz.smworkflow.sminfra.repository;

import ch.globaz.smworkflow.domain.model.Demande;
import ch.globaz.smworkflow.domain.model.Events;
import ch.globaz.smworkflow.domain.model.States;
import ch.globaz.smworkflow.domain.model.Workflow;
import ch.globaz.smworkflow.domain.repository.DemandeRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sce on 12.07.2017.
 */
public class DemandeInMemoryRepository implements DemandeRepository {

    final Map<String,Demande> datasource = new HashMap<String,Demande>();

    @Override
    public Demande getById(String id) {
        if(datasource.containsKey(id)){
            return datasource.get(id);
        }

        return null;
    }

    @Override
    public Demande create(Demande demande) {
        datasource.putIfAbsent(demande.getId(),demande);

        return demande;
    }
}
