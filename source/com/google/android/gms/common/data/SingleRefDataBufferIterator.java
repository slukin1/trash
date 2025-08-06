package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zac;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public final T next() {
        if (hasNext()) {
            int i11 = this.zab + 1;
            this.zab = i11;
            if (i11 == 0) {
                T checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
                this.zac = checkNotNull;
                if (!(checkNotNull instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(checkNotNull.getClass());
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 44);
                    sb2.append("DataBuffer reference of type ");
                    sb2.append(valueOf);
                    sb2.append(" is not movable");
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
            }
            return this.zac;
        }
        int i12 = this.zab;
        StringBuilder sb3 = new StringBuilder(46);
        sb3.append("Cannot advance the iterator beyond ");
        sb3.append(i12);
        throw new NoSuchElementException(sb3.toString());
    }
}
