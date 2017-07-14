package ch.globaz.smworkflow.sminfra.repository;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.repository.DemandeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sce on 12.07.2017.
 */
//@Repository
public class DemandeInMemoryRepository implements DemandeRepository {

    final Map<Long,Demande> datasource = new HashMap<Long,Demande>();

    @Override
    public Demande getById(String id) {
        if(datasource.containsKey(id)){
            return datasource.get(id);
        }

        return null;
    }

    @Override
    public Demande create(Demande demande) {

        demande.setId(new Random().nextLong());

        datasource.putIfAbsent(demande.getId(),demande);

        return demande;
    }
}
