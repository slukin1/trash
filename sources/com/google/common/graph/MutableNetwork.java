package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(EndpointPair<N> endpointPair, E e11);

    @CanIgnoreReturnValue
    boolean addEdge(N n11, N n12, E e11);

    @CanIgnoreReturnValue
    boolean addNode(N n11);

    @CanIgnoreReturnValue
    boolean removeEdge(E e11);

    @CanIgnoreReturnValue
    boolean removeNode(N n11);
}
