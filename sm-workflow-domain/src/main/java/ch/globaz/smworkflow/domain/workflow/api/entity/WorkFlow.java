package ch.globaz.smworkflow.domain.workflow.api.entity;

import ch.globaz.smworkflow.domain.core.User;

import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface WorkFlow<S,E> {

    public Tache getTacheCourante();

    public States getEtatSuivant();

    public List<Tache> getListTaches();

    public User getUser();

    public void setUser(User user);

    public void start();

    public String getUuid();

    public S getInitialState();

    public S getState();

    boolean sendEvent(E demandeInitie);
}
