package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
    public ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n11) {
        GraphConnections<N, V> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n11, newConnections) == null);
        return newConnections;
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of();
        }
        return UndirectedGraphConnections.of();
    }

    @CanIgnoreReturnValue
    public boolean addNode(N n11) {
        Preconditions.checkNotNull(n11, "node");
        if (containsNode(n11)) {
            return false;
        }
        addNodeInternal(n11);
        return true;
    }

    @CanIgnoreReturnValue
    public V putEdgeValue(N n11, N n12, V v11) {
        Preconditions.checkNotNull(n11, "nodeU");
        Preconditions.checkNotNull(n12, "nodeV");
        Preconditions.checkNotNull(v11, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n11.equals(n12), GraphConstants.SELF_LOOPS_NOT_ALLOWED, (Object) n11);
        }
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n11);
        }
        V addSuccessor = graphConnections.addSuccessor(n12, v11);
        GraphConnections graphConnections2 = this.nodeConnections.get(n12);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n12);
        }
        graphConnections2.addPredecessor(n11, v11);
        if (addSuccessor == null) {
            long j11 = this.edgeCount + 1;
            this.edgeCount = j11;
            Graphs.checkPositive(j11);
        }
        return addSuccessor;
    }

    @CanIgnoreReturnValue
    public V removeEdge(N n11, N n12) {
        Preconditions.checkNotNull(n11, "nodeU");
        Preconditions.checkNotNull(n12, "nodeV");
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        GraphConnections graphConnections2 = this.nodeConnections.get(n12);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n12);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n11);
            long j11 = this.edgeCount - 1;
            this.edgeCount = j11;
            Graphs.checkNonNegative(j11);
        }
        return removeSuccessor;
    }

    @CanIgnoreReturnValue
    public boolean removeNode(N n11) {
        Preconditions.checkNotNull(n11, "node");
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n11) != null) {
            graphConnections.removePredecessor(n11);
            this.edgeCount--;
        }
        for (Object withoutCaching : graphConnections.successors()) {
            this.nodeConnections.getWithoutCaching(withoutCaching).removePredecessor(n11);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (Object withoutCaching2 : graphConnections.predecessors()) {
                Preconditions.checkState(this.nodeConnections.getWithoutCaching(withoutCaching2).removeSuccessor(n11) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n11);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v11) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v11);
    }
}
