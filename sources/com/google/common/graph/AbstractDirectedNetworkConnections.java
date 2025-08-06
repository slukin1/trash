package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    public final Map<E, N> inEdgeMap;
    public final Map<E, N> outEdgeMap;
    /* access modifiers changed from: private */
    public int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i11) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i11);
        Preconditions.checkState(i11 <= map.size() && i11 <= map2.size());
    }

    public void addInEdge(E e11, N n11, boolean z11) {
        boolean z12 = true;
        if (z11) {
            int i11 = this.selfLoopCount + 1;
            this.selfLoopCount = i11;
            Graphs.checkPositive(i11);
        }
        if (this.inEdgeMap.put(e11, n11) != null) {
            z12 = false;
        }
        Preconditions.checkState(z12);
    }

    public void addOutEdge(E e11, N n11) {
        Preconditions.checkState(this.outEdgeMap.put(e11, n11) == null);
    }

    public N adjacentNode(E e11) {
        return Preconditions.checkNotNull(this.outEdgeMap.get(e11));
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public boolean contains(Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public UnmodifiableIterator<E> iterator() {
                Iterable<T> iterable;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterable = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterable.iterator());
            }
        };
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N removeInEdge(E e11, boolean z11) {
        if (z11) {
            int i11 = this.selfLoopCount - 1;
            this.selfLoopCount = i11;
            Graphs.checkNonNegative(i11);
        }
        return Preconditions.checkNotNull(this.inEdgeMap.remove(e11));
    }

    public N removeOutEdge(E e11) {
        return Preconditions.checkNotNull(this.outEdgeMap.remove(e11));
    }
}
