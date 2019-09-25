package singleton;

public enum SingletonEnum {
    INSTANCE;
    private Resource instance;
    SingletonEnum() {
        instance = new Resource();
    }
    public Resource getInstance() {
        return instance;
    }
}

class Resource{
}