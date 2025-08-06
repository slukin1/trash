package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N", "V"})
@Beta
public final class ImmutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> {

    public static class Builder<N, V> {
        private final MutableValueGraph<N, V> mutableValueGraph;

        public Builder(ValueGraphBuilder<N, V> valueGraphBuilder) {
            this.mutableValueGraph = valueGraphBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, V> addNode(N n11) {
            this.mutableValueGraph.addNode(n11);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.mutableValueGraph);
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(N n11, N n12, V v11) {
            this.mutableValueGraph.putEdgeValue(n11, n12, v11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(EndpointPair<N> endpointPair, V v11) {
            this.mutableValueGraph.putEdgeValue(endpointPair, v11);
            return this;
        }
    }

    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.from(valueGraph), getNodeConnections(valueGraph), (long) valueGraph.edges().size());
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> valueGraph, final N n11) {
        AnonymousClass1 r02 = new Function<N, V>() {
            public V apply(N n11) {
                return valueGraph.edgeValueOrDefault(n11, n11, null);
            }
        };
        if (valueGraph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(valueGraph.predecessors(n11), Maps.asMap(valueGraph.successors(n11), r02));
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(valueGraph.adjacentNodes(n11), r02));
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : valueGraph.nodes()) {
            builder.put(next, connectionsOf(valueGraph, next));
        }
        return builder.build();
    }

    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
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

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
