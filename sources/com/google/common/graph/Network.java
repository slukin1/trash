package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e11);

    Set<N> adjacentNodes(N n11);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n11);

    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    E edgeConnectingOrNull(N n11, N n12);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Set<E> edgesConnecting(N n11, N n12);

    boolean equals(Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n11, N n12);

    int hashCode();

    int inDegree(N n11);

    Set<E> inEdges(N n11);

    Set<E> incidentEdges(N n11);

    EndpointPair<N> incidentNodes(E e11);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n11);

    Set<E> outEdges(N n11);

    Set<N> predecessors(N n11);

    Set<N> successors(N n11);
}
