package zendesk.support.suas;

public class Action<E> {
    private final String actionType;
    private final E data;

    public Action(String str, E e11) {
        this.actionType = str;
        this.data = e11;
    }

    public String getActionType() {
        return this.actionType;
    }

    public <F> F getData(Class<F> cls) {
        if (cls.isInstance(this.data)) {
            return cls.cast(this.data);
        }
        return null;
    }

    public E getRawData() {
        return this.data;
    }

    public String toString() {
        return "Action{actionType='" + this.actionType + '\'' + ", data=" + this.data + '}';
    }

    public <F> F getData() {
        return this.data;
    }

    public Action(String str) {
        this.actionType = str;
        this.data = null;
    }
}
