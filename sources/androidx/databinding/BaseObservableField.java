package androidx.databinding;

import androidx.databinding.Observable;

abstract class BaseObservableField extends BaseObservable {

    public class a extends Observable.OnPropertyChangedCallback {
        public a() {
        }

        public void d(Observable observable, int i11) {
            BaseObservableField.this.notifyChange();
        }
    }

    public BaseObservableField() {
    }

    public BaseObservableField(Observable... observableArr) {
        if (observableArr != null && observableArr.length != 0) {
            a aVar = new a();
            for (Observable addOnPropertyChangedCallback : observableArr) {
                addOnPropertyChangedCallback.addOnPropertyChangedCallback(aVar);
            }
        }
    }
}
