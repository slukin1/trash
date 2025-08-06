package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.graph.GraphConstants;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N"})
@Beta
public class ImmutableGraph<N> extends ForwardingGraph<N> {
    private final BaseGraph<N> backingGraph;

    public static class Builder<N> {
        private final MutableGraph<N> mutableGraph;

        public Builder(GraphBuilder<N> graphBuilder) {
            this.mutableGraph = graphBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N> addNode(N n11) {
            this.mutableGraph.addNode(n11);
            return this;
        }

        public ImmutableGraph<N> build() {
            return ImmutableGraph.copyOf(this.mutableGraph);
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(N n11, N n12) {
            this.mutableGraph.putEdge(n11, n12);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(EndpointPair<N> endpointPair) {
            this.mutableGraph.putEdge(endpointPair);
            return this;
        }
    }

    public ImmutableGraph(BaseGraph<N> baseGraph) {
        this.backingGraph = baseGraph;
    }

    private static <N> GraphConnections<N, GraphConstants.Presence> connectionsOf(Graph<N> graph, N n11) {
        Function constant = Functions.constant(GraphConstants.Presence.EDGE_EXISTS);
        if (graph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(graph.predecessors(n11), Maps.asMap(graph.successors(n11), constant));
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(graph.adjacentNodes(n11), constant));
    }

    public static <N> ImmutableGraph<N> copyOf(Graph<N> graph) {
        if (graph instanceof ImmutableGraph) {
            return (ImmutableGraph) graph;
        }
        return new ImmutableGraph<>(new ConfigurableValueGraph(GraphBuilder.from(graph), getNodeConnections(graph), (long) graph.edges().size()));
    }

    private static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> getNodeConnections(Graph<N> graph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : graph.nodes()) {
            builder.put(next, connectionsOf(graph, next));
        }
        return builder.build();
    }

    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    public BaseGraph<N> delegate() {
        return this.backingGraph;
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Deprecated
    public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> immutableGraph) {
        return (ImmutableGraph) Preconditions.checkNotNull(immutableGraph);
    }
}
