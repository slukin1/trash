package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
public interface ValueGraph<N, V> extends BaseGraph<N> {
    Set<N> adjacentNodes(N n11);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n11);

    V edgeValueOrDefault(EndpointPair<N> endpointPair, V v11);

    V edgeValueOrDefault(N n11, N n12, V v11);

    Set<EndpointPair<N>> edges();

    boolean equals(Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n11, N n12);

    int hashCode();

    int inDegree(N n11);

    Set<EndpointPair<N>> incidentEdges(N n11);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n11);

    Set<N> predecessors(N n11);

    Set<N> successors(N n11);
}
