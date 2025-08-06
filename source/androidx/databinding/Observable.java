package androidx.databinding;

public interface Observable {

    public static abstract class OnPropertyChangedCallback {
        public abstract void d(Observable observable, int i11);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
