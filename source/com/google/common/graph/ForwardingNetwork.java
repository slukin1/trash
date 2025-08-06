package com.google.common.graph;

import java.util.Set;

abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    public Set<E> adjacentEdges(E e11) {
        return delegate().adjacentEdges(e11);
    }

    public Set<N> adjacentNodes(N n11) {
        return delegate().adjacentNodes(n11);
    }

    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n11) {
        return delegate().degree(n11);
    }

    public abstract Network<N, E> delegate();

    public E edgeConnectingOrNull(N n11, N n12) {
        return delegate().edgeConnectingOrNull(n11, n12);
    }

    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    public Set<E> edges() {
        return delegate().edges();
    }

    public Set<E> edgesConnecting(N n11, N n12) {
        return delegate().edgesConnecting(n11, n12);
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return delegate().hasEdgeConnecting(n11, n12);
    }

    public int inDegree(N n11) {
        return delegate().inDegree(n11);
    }

    public Set<E> inEdges(N n11) {
        return delegate().inEdges(n11);
    }

    public Set<E> incidentEdges(N n11) {
        return delegate().incidentEdges(n11);
    }

    public EndpointPair<N> incidentNodes(E e11) {
        return delegate().incidentNodes(e11);
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

    public Set<E> outEdges(N n11) {
        return delegate().outEdges(n11);
    }

    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return delegate().edgeConnectingOrNull(endpointPair);
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return delegate().edgesConnecting(endpointPair);
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
