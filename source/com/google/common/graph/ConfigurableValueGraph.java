package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    public long edgeCount;
    private final boolean isDirected;
    public final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0);
    }

    public Set<N> adjacentNodes(N n11) {
        return checkedConnections(n11).adjacentNodes();
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final GraphConnections<N, V> checkedConnections(N n11) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n11);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n11);
        throw new IllegalArgumentException("Node " + n11 + " is not an element of this graph.");
    }

    public final boolean containsNode(N n11) {
        return this.nodeConnections.containsKey(n11);
    }

    public long edgeCount() {
        return this.edgeCount;
    }

    public V edgeValueOrDefault(N n11, N n12, V v11) {
        return edgeValueOrDefault_internal(Preconditions.checkNotNull(n11), Preconditions.checkNotNull(n12), v11);
    }

    public final V edgeValueOrDefault_internal(N n11, N n12, V v11) {
        V v12;
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            v12 = null;
        } else {
            v12 = graphConnections.value(n12);
        }
        return v12 == null ? v11 : v12;
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(n11), Preconditions.checkNotNull(n12));
    }

    public final boolean hasEdgeConnecting_internal(N n11, N n12) {
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        return graphConnections != null && graphConnections.successors().contains(n12);
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public V edgeValueOrDefault(EndpointPair<N> endpointPair, V v11) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v11);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<N> predecessors(N n11) {
        return checkedConnections(n11).predecessors();
    }

    public Set<N> successors(N n11) {
        return checkedConnections(n11).successors();
    }

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j11) {
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeCount = Graphs.checkNonNegative(j11);
    }
}
