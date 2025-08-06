package androidx.databinding;

import androidx.databinding.ObservableList;
import java.util.ArrayList;
import java.util.Collection;

public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {
    private transient ListChangeRegistry mListeners = new ListChangeRegistry();

    private void notifyAdd(int i11, int i12) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.p(this, i11, i12);
        }
    }

    private void notifyRemove(int i11, int i12) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.q(this, i11, i12);
        }
    }

    public boolean add(T t11) {
        super.add(t11);
        notifyAdd(size() - 1, 1);
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean addAll = super.addAll(collection);
        if (addAll) {
            notifyAdd(size, size() - size);
        }
        return addAll;
    }

    public void addOnListChangedCallback(ObservableList.OnListChangedCallback onListChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new ListChangeRegistry();
        }
        this.mListeners.b(onListChangedCallback);
    }

    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            notifyRemove(0, size);
        }
    }

    public T remove(int i11) {
        T remove = super.remove(i11);
        notifyRemove(i11, 1);
        return remove;
    }

    public void removeOnListChangedCallback(ObservableList.OnListChangedCallback onListChangedCallback) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.j(onListChangedCallback);
        }
    }

    public void removeRange(int i11, int i12) {
        super.removeRange(i11, i12);
        notifyRemove(i11, i12 - i11);
    }

    public T set(int i11, T t11) {
        T t12 = super.set(i11, t11);
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.o(this, i11, 1);
        }
        return t12;
    }

    public void add(int i11, T t11) {
        super.add(i11, t11);
        notifyAdd(i11, 1);
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean addAll(int i11, Collection<? extends T> collection) {
        boolean addAll = super.addAll(i11, collection);
        if (addAll) {
            notifyAdd(i11, collection.size());
        }
        return addAll;
    }
}
