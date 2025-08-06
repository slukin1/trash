package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

interface GraphConnections<N, V> {
    void addPredecessor(N n11, V v11);

    @CanIgnoreReturnValue
    V addSuccessor(N n11, V v11);

    Set<N> adjacentNodes();

    Set<N> predecessors();

    void removePredecessor(N n11);

    @CanIgnoreReturnValue
    V removeSuccessor(N n11);

    Set<N> successors();

    V value(N n11);
}
