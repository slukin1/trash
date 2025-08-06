package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @LazyInit
    private transient Reference<Multiset<N>> predecessorsReference;
    @LazyInit
    private transient Reference<Multiset<N>> successorsReference;

    private DirectedMultiNetworkConnections(Map<E, N> map, Map<E, N> map2, int i11) {
        super(map, map2, i11);
    }

    private static <T> T getReference(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> of() {
        return new DirectedMultiNetworkConnections<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i11) {
        return new DirectedMultiNetworkConnections<>(ImmutableMap.copyOf(map), ImmutableMap.copyOf(map2), i11);
    }

    private Multiset<N> predecessorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> create = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(create);
        return create;
    }

    /* access modifiers changed from: private */
    public Multiset<N> successorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset<N> create = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(create);
        return create;
    }

    public void addInEdge(E e11, N n11, boolean z11) {
        super.addInEdge(e11, n11, z11);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n11));
        }
    }

    public void addOutEdge(E e11, N n11) {
        super.addOutEdge(e11, n11);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n11));
        }
    }

    public Set<E> edgesConnecting(final N n11) {
        return new MultiEdgesConnecting<E>(this.outEdgeMap, n11) {
            public int size() {
                return DirectedMultiNetworkConnections.this.successorsMultiset().count(n11);
            }
        };
    }

    public Set<N> predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    public N removeInEdge(E e11, boolean z11) {
        N removeInEdge = super.removeInEdge(e11, z11);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeInEdge));
        }
        return removeInEdge;
    }

    public N removeOutEdge(E e11) {
        N removeOutEdge = super.removeOutEdge(e11);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeOutEdge));
        }
        return removeOutEdge;
    }

    public Set<N> successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }
}
