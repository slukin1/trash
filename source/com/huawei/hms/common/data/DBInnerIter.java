package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

public class DBInnerIter<O> implements Iterator<O> {
    public final DataBuffer<O> dataBuffer;
    public int index = -1;

    public DBInnerIter(DataBuffer<O> dataBuffer2) {
        Preconditions.checkNotNull(dataBuffer2, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer2;
    }

    public boolean hasNext() {
        return this.index + 1 < this.dataBuffer.getCount();
    }

    public O next() {
        if (!hasNext()) {
            return null;
        }
        DataBuffer<O> dataBuffer2 = this.dataBuffer;
        int i11 = this.index + 1;
        this.index = i11;
        return dataBuffer2.get(i11);
    }
}
