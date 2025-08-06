package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

interface NetworkConnections<N, E> {
    void addInEdge(E e11, N n11, boolean z11);

    void addOutEdge(E e11, N n11);

    N adjacentNode(E e11);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n11);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CanIgnoreReturnValue
    N removeInEdge(E e11, boolean z11);

    @CanIgnoreReturnValue
    N removeOutEdge(E e11);

    Set<N> successors();
}
