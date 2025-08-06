package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    public final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public void addInEdge(E e11, N n11, boolean z11) {
        if (!z11) {
            addOutEdge(e11, n11);
        }
    }

    public void addOutEdge(E e11, N n11) {
        Preconditions.checkState(this.incidentEdgeMap.put(e11, n11) == null);
    }

    public N adjacentNode(E e11) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.get(e11));
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public N removeInEdge(E e11, boolean z11) {
        if (!z11) {
            return removeOutEdge(e11);
        }
        return null;
    }

    public N removeOutEdge(E e11) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.remove(e11));
    }

    public Set<N> successors() {
        return adjacentNodes();
    }
}
