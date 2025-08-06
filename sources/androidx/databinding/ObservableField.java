package androidx.databinding;

import java.io.Serializable;

public class ObservableField<T> extends BaseObservableField implements Serializable {
    public static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t11) {
        this.mValue = t11;
    }

    public T get() {
        return this.mValue;
    }

    public void set(T t11) {
        if (t11 != this.mValue) {
            this.mValue = t11;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
