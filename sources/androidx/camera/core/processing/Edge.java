package androidx.camera.core.processing;

import androidx.core.util.Consumer;

public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    public void accept(T t11) {
        this.mListener.accept(t11);
    }

    public void setListener(Consumer<T> consumer) {
        this.mListener = consumer;
    }
}
