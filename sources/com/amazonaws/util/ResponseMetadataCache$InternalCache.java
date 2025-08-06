package com.amazonaws.util;

import com.amazonaws.ResponseMetadata;
import java.util.LinkedHashMap;
import java.util.Map;

final class ResponseMetadataCache$InternalCache extends LinkedHashMap<Integer, ResponseMetadata> {
    private int maxSize;

    public ResponseMetadataCache$InternalCache(int i11) {
        super(i11);
        this.maxSize = i11;
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.maxSize;
    }
}
