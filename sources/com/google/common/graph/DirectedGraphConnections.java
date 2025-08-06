package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    /* access modifiers changed from: private */
    public final Map<N, Object> adjacentNodeValues;
    /* access modifiers changed from: private */
    public int predecessorCount;
    /* access modifiers changed from: private */
    public int successorCount;

    public static final class PredAndSucc {
        /* access modifiers changed from: private */
        public final Object successorValue;

        public PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, int i11, int i12) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.predecessorCount = Graphs.checkNonNegative(i11);
        this.successorCount = Graphs.checkNonNegative(i12);
        Preconditions.checkState(i11 <= map.size() && i12 <= map.size());
    }

    /* access modifiers changed from: private */
    public static boolean isPredecessor(Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* access modifiers changed from: private */
    public static boolean isSuccessor(Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }

    public static <N, V> DirectedGraphConnections<N, V> of() {
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), 0, 0);
    }

    public static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> set, Map<N, V> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        for (N next : set) {
            Object put = hashMap.put(next, PRED);
            if (put != null) {
                hashMap.put(next, new PredAndSucc(put));
            }
        }
        return new DirectedGraphConnections<>(ImmutableMap.copyOf(hashMap), set.size(), map.size());
    }

    public void addPredecessor(N n11, V v11) {
        Map<N, Object> map = this.adjacentNodeValues;
        Object obj = PRED;
        Object put = map.put(n11, obj);
        if (put == null) {
            int i11 = this.predecessorCount + 1;
            this.predecessorCount = i11;
            Graphs.checkPositive(i11);
        } else if (put instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n11, put);
        } else if (put != obj) {
            this.adjacentNodeValues.put(n11, new PredAndSucc(put));
            int i12 = this.predecessorCount + 1;
            this.predecessorCount = i12;
            Graphs.checkPositive(i12);
        }
    }

    public V addSuccessor(N n11, V v11) {
        V put = this.adjacentNodeValues.put(n11, v11);
        if (put == null) {
            int i11 = this.successorCount + 1;
            this.successorCount = i11;
            Graphs.checkPositive(i11);
            return null;
        } else if (put instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n11, new PredAndSucc(v11));
            return ((PredAndSucc) put).successorValue;
        } else if (put != PRED) {
            return put;
        } else {
            this.adjacentNodeValues.put(n11, new PredAndSucc(v11));
            int i12 = this.successorCount + 1;
            this.successorCount = i12;
            Graphs.checkPositive(i12);
            return null;
        }
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Set<N> predecessors() {
        return new AbstractSet<N>() {
            public boolean contains(Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }

            public UnmodifiableIterator<N> iterator() {
                final Iterator it2 = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() {
                    public N computeNext() {
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                return entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public void removePredecessor(N n11) {
        Object obj = this.adjacentNodeValues.get(n11);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(n11);
            int i11 = this.predecessorCount - 1;
            this.predecessorCount = i11;
            Graphs.checkNonNegative(i11);
        } else if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n11, ((PredAndSucc) obj).successorValue);
            int i12 = this.predecessorCount - 1;
            this.predecessorCount = i12;
            Graphs.checkNonNegative(i12);
        }
    }

    public V removeSuccessor(Object obj) {
        V v11;
        V v12 = this.adjacentNodeValues.get(obj);
        if (v12 == null || v12 == (v11 = PRED)) {
            return null;
        }
        if (v12 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, v11);
            int i11 = this.successorCount - 1;
            this.successorCount = i11;
            Graphs.checkNonNegative(i11);
            return ((PredAndSucc) v12).successorValue;
        }
        this.adjacentNodeValues.remove(obj);
        int i12 = this.successorCount - 1;
        this.successorCount = i12;
        Graphs.checkNonNegative(i12);
        return v12;
    }

    public Set<N> successors() {
        return new AbstractSet<N>() {
            public boolean contains(Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }

            public UnmodifiableIterator<N> iterator() {
                final Iterator it2 = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() {
                    public N computeNext() {
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                return entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public V value(N n11) {
        V v11 = this.adjacentNodeValues.get(n11);
        if (v11 == PRED) {
            return null;
        }
        return v11 instanceof PredAndSucc ? ((PredAndSucc) v11).successorValue : v11;
    }
}
