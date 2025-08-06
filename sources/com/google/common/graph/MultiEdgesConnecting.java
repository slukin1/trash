package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
    private final Map<E, ?> outEdgeToNode;
    /* access modifiers changed from: private */
    public final Object targetNode;

    public MultiEdgesConnecting(Map<E, ?> map, Object obj) {
        this.outEdgeToNode = (Map) Preconditions.checkNotNull(map);
        this.targetNode = Preconditions.checkNotNull(obj);
    }

    public boolean contains(Object obj) {
        return this.targetNode.equals(this.outEdgeToNode.get(obj));
    }

    public UnmodifiableIterator<E> iterator() {
        final Iterator<Map.Entry<E, ?>> it2 = this.outEdgeToNode.entrySet().iterator();
        return new AbstractIterator<E>() {
            public E computeNext() {
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (MultiEdgesConnecting.this.targetNode.equals(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return endOfData();
            }
        };
    }
}
