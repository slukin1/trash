package com.google.common.graph;

import com.google.common.graph.GraphConstants;

final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    public ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    public boolean addNode(N n11) {
        return this.backingValueGraph.addNode(n11);
    }

    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    public boolean putEdge(N n11, N n12) {
        return this.backingValueGraph.putEdgeValue(n11, n12, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public boolean removeEdge(N n11, N n12) {
        return this.backingValueGraph.removeEdge(n11, n12) != null;
    }

    public boolean removeNode(N n11) {
        return this.backingValueGraph.removeNode(n11);
    }

    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
