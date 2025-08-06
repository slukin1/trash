package zendesk.support.suas;

public interface StateSelector<E> {
    E selectData(State state);
}
