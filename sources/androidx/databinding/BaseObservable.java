package androidx.databinding;

import androidx.databinding.Observable;

public class BaseObservable implements Observable {
    private transient PropertyChangeRegistry mCallbacks;

    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
        }
        this.mCallbacks.b(onPropertyChangedCallback);
    }

    public void notifyChange() {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.e(this, 0, null);
            }
        }
    }

    public void notifyPropertyChanged(int i11) {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.e(this, i11, null);
            }
        }
    }

    public void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry != null) {
                propertyChangeRegistry.j(onPropertyChangedCallback);
            }
        }
    }
}
