package kaplun.musicbot.command;

import java.lang.reflect.Method;

public final class SimpleCommand {

    private final String name, description;
    private final Command.ExecutorType executorType;
    private final Object object;
    private final Method method;
    private final int power;

    public SimpleCommand(String name, String description, Command.ExecutorType executorType, Object object, Method method, int power){
        super();
        this.name = name;
        this.description = description;
        this.executorType = executorType;
        this.object = object;
        this.method = method;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Command.ExecutorType getExecutorType() {
        return executorType;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }

    public int getPower() {
        return power;
    }
}
