package ch.globaz.smworkflow.sminfra.repository;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import ch.globaz.smworkflow.domain.repository.DemandeRepository;
import ch.globaz.smworkflow.sminfra.repository.entity.DemandeAffiliation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by sce on 14.07.2017.
 */
@Repository
@Transactional
public class DemandeJpaRepository implements DemandeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Demande getById(String id) {
        return null;
    }

    @Override
    public Demande create(Demande demande) {

        em.persist(demande);
        return demande;
    }


}
