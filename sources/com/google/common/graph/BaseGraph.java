package com.google.common.graph;

import java.util.Set;

interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n11);

    boolean allowsSelfLoops();

    int degree(N n11);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n11, N n12);

    int inDegree(N n11);

    Set<EndpointPair<N>> incidentEdges(N n11);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n11);

    Set<N> predecessors(N n11);

    Set<N> successors(N n11);
}
