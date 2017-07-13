package ch.globaz.smworkflowtest;

import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Main {


    //pas possible de bypasser un etat

    public static void main(String[] args) throws Exception {


        Main main = new Main();
        main.test3();

    }


    public void test3() throws Exception {
        StateMachine<States, Events> machine1 = machine2();
        StateMachine<States, Events> machine2 = machine2();

        machine1.start();
        machine2.start();

        machine1.getExtendedState().getVariables().put("tos3",Boolean.TRUE);

        machine1.sendEvent(Events.TOS2);
        machine1.sendEvent(Events.TOS3);

    }


    public void test2() throws Exception {
        StateMachine<States, Events> machine1 = machine1();
        StateMachine<States, Events> machine2 = machine1();
        StateMachine<States, Events> machine3 = machine1();

        machine1.start();machine2.start();machine3.start();

        System.out.println("Machine1, uuid: " + machine1.getUuid() + ", id:" + machine1.getId());
        System.out.println("Machine1, currentState: " + machine1.getState().getId() + ", id:" + machine1.getId());
        System.out.println("Machine2, uuid: " + machine2.getUuid() + ", id:" + machine2.getId());
        System.out.println("Machine2, currentState: " + machine2.getState().getId() + ", id:" + machine2.getId());
        System.out.println("Machine3, uuid: " + machine3.getUuid() + ", id:" + machine3.getId());
        System.out.println("Machine3, currentState: " + machine3.getState().getId() + ", id:" + machine3.getId());

        machine1.sendEvent(Events.TOS2);
        machine1.sendEvent(Events.TOS3);

        machine2.sendEvent(Events.TOS2);

        System.out.println("Machine1, uuid: " + machine1.getUuid() + ", id:" + machine1.getId());
        System.out.println("Machine1, currentState: " + machine1.getState().getId() + ", id:" + machine1.getId());
        System.out.println("Machine2, uuid: " + machine2.getUuid() + ", id:" + machine2.getId());
        System.out.println("Machine2, currentState: " + machine2.getState().getId() + ", id:" + machine2.getId());
        System.out.println("Machine3, uuid: " + machine3.getUuid() + ", id:" + machine3.getId());
        System.out.println("Machine3, currentState: " + machine3.getState().getId() + ", id:" + machine3.getId());


        machine1.sendEvent(Events.TOS4);
        machine1.sendEvent(Events.TOS5);

        System.out.println("Machine1, uuid: " + machine1.getUuid() + ", id:" + machine1.getId());
        System.out.println("Machine1, currentState: " + machine1.getState().getId() + ", id:" + machine1.getId());
        System.out.println("Machine2, uuid: " + machine2.getUuid() + ", id:" + machine2.getId());
        System.out.println("Machine2, currentState: " + machine2.getState().getId() + ", id:" + machine2.getId());
        System.out.println("Machine3, uuid: " + machine3.getUuid() + ", id:" + machine3.getId());
        System.out.println("Machine3, currentState: " + machine3.getState().getId() + ", id:" + machine3.getId());


        System.out.println(machine1.isComplete());


    }


    public void test1() throws Exception {
        StateMachine<States, Events> machine1 = machine1();
        machine1.start();

        machine1.sendEvent(Events.TOS2);

        machine1.sendEvent(Events.TOS3);


    }

    public StateMachine<States, Events> machine1 () throws Exception {
        StateMachineBuilder.Builder<States,Events> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .machineId("Process un")
                .beanFactory(new StaticListableBeanFactory())
                .listener(new Listener());

        builder.configureStates()
                .withStates()
                .initial(States.S1)
                .states(EnumSet.allOf(States.class))
                .end(States.S5);

        builder.configureTransitions()
                .withExternal()
                .source(States.S1).target(States.S2).action((context)-> {
                    System.out.println("To State2 Action");
                    System.out.println(context.getSource().getId().test());
                    System.out.println("target:" + context.getTarget().getId());
                    System.out.println("target:" + context.getSources());

                    //context.getTargets().forEach(t->{
                    //    System.out.println(t.getId());
                    //});
                })
                .event(Events.TOS2)
                .and()

                .withExternal()
                .source(States.S2).target(States.S3).action((context)-> {
                    System.out.println("To State3 Action");
                    System.out.println(context.getSource().getId().test());
                    System.out.println("target:" + context.getTarget().getId());
                    System.out.println("target:" + context.getSources());

                    //context.getTargets().forEach(t->{
                    //    System.out.println(t.getId());
                    //});
                })
                .event(Events.TOS3)
                .and()

                .withExternal()
                .source(States.S3).target(States.S4).action((context)-> {
                    System.out.println("jdlasdkhlas");
                    System.out.print(context.getEvent());
                })
                .event(Events.TOS4)
                .and()

                .withExternal()
                .source(States.S4).target(States.S5).action((context)-> {
                    System.out.println("jdlasdkhlas");
                    System.out.print(context.getEvent());
                })
                .event(Events.TOS5);

        return builder.build();
    }


    public StateMachine<States, Events> machine2 () throws Exception {
        try {

            StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

            builder.configureConfiguration()
                    .withConfiguration()
                    .machineId("Process un")
                    .beanFactory(new StaticListableBeanFactory())
                    .listener(new Listener());

            builder.configureStates()
                    .withStates()
                    .initial(States.S1)
                    .states(EnumSet.allOf(States.class))
                    .choice(States.P_S3)
                    .end(States.S5);

            builder.configureTransitions()
                    .withExternal()
                    .source(States.S1).target(States.S2).action((context) -> {
                System.out.println("To State2 Action");
                System.out.println(context.getSource().getId().test());
                System.out.println("target:" + context.getTarget().getId());
                System.out.println("target:" + context.getSources());

                //context.getTargets().forEach(t->{
                //    System.out.println(t.getId());
                //});
            })
                    .event(Events.TOS2)
                    .and()

                    .withExternal()
                    .source(States.S2).target(States.P_S3).action((context) -> {
                System.out.println("To State3 Action");
                System.out.println(context.getSource().getId().test());
                System.out.println("target:" + context.getTarget().getId());
                System.out.println("target:" + context.getSources());

                //context.getTargets().forEach(t->{
                //    System.out.println(t.getId());
                //});
            })
                    .event(Events.TOS3)
                    .and()

                    .withExternal()
                    .source(States.S3).target(States.S4).action((context) -> {
                System.out.println("jdlasdkhlas");
                System.out.print(context.getEvent());
            })
                    .event(Events.TOS4)
                    .and()

                    .withExternal()
                    .source(States.S4).target(States.S5).action((context) -> {
                System.out.println("jdlasdkhlas");
                System.out.print(context.getEvent());
            })
                    .event(Events.TOS5)
                    .and()

                    .withChoice()
                    .source(States.P_S3)
                    .first(States.S3, (context) -> {
                        return context.getExtendedState().get("tos3", Boolean.class);
                    })
                    .last(States.S5);

            return builder.build();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
