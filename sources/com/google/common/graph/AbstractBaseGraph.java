package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;

abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    public static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        public final BaseGraph<N> graph;
        public final N node;

        public static final class Directed<N> extends IncidentEdgeSet<N> {
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                if ((!this.node.equals(source) || !this.graph.successors(this.node).contains(target)) && (!this.node.equals(target) || !this.graph.predecessors(this.node).contains(source))) {
                    return false;
                }
                return true;
            }

            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
            }

            private Directed(BaseGraph<N> baseGraph, N n11) {
                super(baseGraph, n11);
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                    public EndpointPair<N> apply(N n11) {
                        return EndpointPair.ordered(n11, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.of(this.node)).iterator(), new Function<N, EndpointPair<N>>() {
                    public EndpointPair<N> apply(N n11) {
                        return EndpointPair.ordered(Directed.this.node, n11);
                    }
                })));
            }
        }

        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> adjacentNodes = this.graph.adjacentNodes(this.node);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                if ((!this.node.equals(nodeV) || !adjacentNodes.contains(nodeU)) && (!this.node.equals(nodeU) || !adjacentNodes.contains(nodeV))) {
                    return false;
                }
                return true;
            }

            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            private Undirected(BaseGraph<N> baseGraph, N n11) {
                super(baseGraph, n11);
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                    public EndpointPair<N> apply(N n11) {
                        return EndpointPair.unordered(Undirected.this.node, n11);
                    }
                }));
            }
        }

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> baseGraph, N n11) {
            return baseGraph.isDirected() ? new Directed(baseGraph, n11) : new Undirected(baseGraph, n11);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n11) {
            this.graph = baseGraph;
            this.node = n11;
        }
    }

    public int degree(N n11) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors(n11).size(), successors(n11).size());
        }
        Set adjacentNodes = adjacentNodes(n11);
        return IntMath.saturatedAdd(adjacentNodes.size(), (!allowsSelfLoops() || !adjacentNodes.contains(n11)) ? 0 : 1);
    }

    public long edgeCount() {
        long j11 = 0;
        for (Object degree : nodes()) {
            j11 += (long) degree(degree);
        }
        Preconditions.checkState((1 & j11) == 0);
        return j11 >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }
        };
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        Preconditions.checkNotNull(n11);
        Preconditions.checkNotNull(n12);
        return nodes().contains(n11) && successors(n11).contains(n12);
    }

    public int inDegree(N n11) {
        return isDirected() ? predecessors(n11).size() : degree(n11);
    }

    public Set<EndpointPair<N>> incidentEdges(N n11) {
        Preconditions.checkNotNull(n11);
        Preconditions.checkArgument(nodes().contains(n11), GraphConstants.NODE_NOT_IN_GRAPH, (Object) n11);
        return IncidentEdgeSet.of(this, n11);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    public int outDegree(N n11) {
        return isDirected() ? successors(n11).size() : degree(n11);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), GraphConstants.ENDPOINTS_MISMATCH);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors(nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }
}
