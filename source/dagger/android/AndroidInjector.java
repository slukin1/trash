package dagger.android;

public interface AndroidInjector<T> {

    @Deprecated
    public static abstract class Builder<T> {
    }

    void inject(T t11);
}
