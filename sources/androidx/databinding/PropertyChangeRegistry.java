package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

public class PropertyChangeRegistry extends CallbackRegistry<Observable.OnPropertyChangedCallback, Observable, Void> {

    /* renamed from: g  reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void> f8865g = new a();

    public class a extends CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void> {
        /* renamed from: b */
        public void a(Observable.OnPropertyChangedCallback onPropertyChangedCallback, Observable observable, int i11, Void voidR) {
            onPropertyChangedCallback.d(observable, i11);
        }
    }

    public PropertyChangeRegistry() {
        super(f8865g);
    }
}
