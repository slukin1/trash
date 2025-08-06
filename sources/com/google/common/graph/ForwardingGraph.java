package com.google.common.graph;

import java.util.Set;

abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    public Set<N> adjacentNodes(N n11) {
        return delegate().adjacentNodes(n11);
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n11) {
        return delegate().degree(n11);
    }

    public abstract BaseGraph<N> delegate();

    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return delegate().hasEdgeConnecting(n11, n12);
    }

    public int inDegree(N n11) {
        return delegate().inDegree(n11);
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public int outDegree(N n11) {
        return delegate().outDegree(n11);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    public Set<N> predecessors(N n11) {
        return delegate().predecessors(n11);
    }

    public Set<N> successors(N n11) {
        return delegate().successors(n11);
    }
}
