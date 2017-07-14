package ch.globaz.smworkflow.domain.demande.api.entity;

/**
 * Created by sce on 12.07.2017.
 */
public interface Demande {

    public Long getId();

    public void setId(Long id);

    public boolean isAccepte();

    public void setAccepte(Boolean accepte);

}
