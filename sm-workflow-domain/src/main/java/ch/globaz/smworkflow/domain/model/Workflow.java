package ch.globaz.smworkflow.domain.model;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface Workflow<S,E> {

    public String getUserName();

    public void setUserName(String userName);

    //public StateMachine get

    public void start();

    public String getUuid();

    public S getInitialState();

    public S getState();

    boolean sendEvent(E demandeInitie);
}
