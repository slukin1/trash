package androidx.databinding;

import java.util.List;

public interface ObservableList<T> extends List<T> {

    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void d(T t11);

        public abstract void e(T t11, int i11, int i12);

        public abstract void f(T t11, int i11, int i12);

        public abstract void g(T t11, int i11, int i12, int i13);

        public abstract void h(T t11, int i11, int i12);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);
}
