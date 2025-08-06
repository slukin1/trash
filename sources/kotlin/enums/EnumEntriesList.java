package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.a;

final class EnumEntriesList<T extends Enum<T>> extends a<T> implements a<T>, Serializable {
    private volatile T[] _entries;
    private final d10.a<T[]> entriesProvider;

    public EnumEntriesList(d10.a<T[]> aVar) {
        this.entriesProvider = aVar;
    }

    private final T[] getEntries() {
        T[] tArr = this._entries;
        if (tArr != null) {
            return tArr;
        }
        T[] tArr2 = (Enum[]) this.entriesProvider.invoke();
        this._entries = tArr2;
        return tArr2;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(getEntries());
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return contains((Enum) obj);
    }

    public int getSize() {
        return getEntries().length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return indexOf((Enum) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return lastIndexOf((Enum) obj);
    }

    public boolean contains(T t11) {
        return ((Enum) ArraysKt___ArraysKt.M(getEntries(), t11.ordinal())) == t11;
    }

    public T get(int i11) {
        T[] entries = getEntries();
        a.Companion.b(i11, entries.length);
        return entries[i11];
    }

    public int indexOf(T t11) {
        int ordinal = t11.ordinal();
        if (((Enum) ArraysKt___ArraysKt.M(getEntries(), ordinal)) == t11) {
            return ordinal;
        }
        return -1;
    }

    public int lastIndexOf(T t11) {
        return indexOf((Object) t11);
    }
}
