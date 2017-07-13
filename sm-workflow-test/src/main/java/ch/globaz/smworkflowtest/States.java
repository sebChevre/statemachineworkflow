package ch.globaz.smworkflowtest;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public enum States {
    S5("5"), S1("1"), S2("2"), S3("3"), S4("4"), P_S3("pseudo");

    private String test;

    States(String test){
        this.test = test;
    }


    public String test(){
        return test;
    }
}
