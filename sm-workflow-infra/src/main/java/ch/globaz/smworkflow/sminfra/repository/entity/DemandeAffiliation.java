package ch.globaz.smworkflow.sminfra.repository.entity;

import ch.globaz.smworkflow.domain.demande.api.entity.Demande;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
/**
 * Created by sce on 13.07.2017.
 */
@Entity
public class DemandeAffiliation implements Demande {

    @javax.persistence.Id
    @GeneratedValue
    private Long id;
    private Boolean isAccepte;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isAccepte() {
        return isAccepte;
    }

    @Override
    public void setAccepte(Boolean accepte) {
        this.isAccepte = accepte;
    }
}
