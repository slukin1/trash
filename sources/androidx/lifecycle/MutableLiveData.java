package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t11) {
        super(t11);
    }

    public void postValue(T t11) {
        super.postValue(t11);
    }

    public void setValue(T t11) {
        super.setValue(t11);
    }

    public MutableLiveData() {
    }
}
