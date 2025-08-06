package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    private Predicate<E> connectedPredicate(final N n11, final N n12) {
        return new Predicate<E>() {
            public boolean apply(E e11) {
                return AbstractNetwork.this.incidentNodes(e11).adjacentNode(n11).equals(n12);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> network) {
        return Maps.asMap(network.edges(), new Function<E, EndpointPair<N>>() {
            public EndpointPair<N> apply(E e11) {
                return network.incidentNodes(e11);
            }
        });
    }

    public Set<E> adjacentEdges(E e11) {
        EndpointPair incidentNodes = incidentNodes(e11);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of(e11));
    }

    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            public Set<N> adjacentNodes(N n11) {
                return AbstractNetwork.this.adjacentNodes(n11);
            }

            public boolean allowsSelfLoops() {
                return AbstractNetwork.this.allowsSelfLoops();
            }

            public Set<EndpointPair<N>> edges() {
                if (AbstractNetwork.this.allowsParallelEdges()) {
                    return super.edges();
                }
                return new AbstractSet<EndpointPair<N>>() {
                    public boolean contains(Object obj) {
                        if (!(obj instanceof EndpointPair)) {
                            return false;
                        }
                        EndpointPair endpointPair = (EndpointPair) obj;
                        if (!AnonymousClass1.this.isOrderingCompatible(endpointPair) || !AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) || !AnonymousClass1.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                            return false;
                        }
                        return true;
                    }

                    public Iterator<EndpointPair<N>> iterator() {
                        return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function<E, EndpointPair<N>>() {
                            public EndpointPair<N> apply(E e11) {
                                return AbstractNetwork.this.incidentNodes(e11);
                            }
                        });
                    }

                    public int size() {
                        return AbstractNetwork.this.edges().size();
                    }
                };
            }

            public boolean isDirected() {
                return AbstractNetwork.this.isDirected();
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractNetwork.this.nodeOrder();
            }

            public Set<N> nodes() {
                return AbstractNetwork.this.nodes();
            }

            public Set<N> predecessors(N n11) {
                return AbstractNetwork.this.predecessors(n11);
            }

            public Set<N> successors(N n11) {
                return AbstractNetwork.this.successors(n11);
            }
        };
    }

    public int degree(N n11) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n11).size(), outEdges(n11).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n11).size(), edgesConnecting(n11, n11).size());
    }

    public E edgeConnectingOrNull(N n11, N n12) {
        Set edgesConnecting = edgesConnecting(n11, n12);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format(GraphConstants.MULTIPLE_EDGES_CONNECTING, new Object[]{n11, n12}));
    }

    public Set<E> edgesConnecting(N n11, N n12) {
        Set outEdges = outEdges(n11);
        Set inEdges = inEdges(n12);
        if (outEdges.size() <= inEdges.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdges, connectedPredicate(n11, n12)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdges, connectedPredicate(n12, n11)));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        if (isDirected() != network.isDirected() || !nodes().equals(network.nodes()) || !edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network))) {
            return false;
        }
        return true;
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return !edgesConnecting(n11, n12).isEmpty();
    }

    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public int inDegree(N n11) {
        return isDirected() ? inEdges(n11).size() : degree(n11);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    public int outDegree(N n11) {
        return isDirected() ? outEdges(n11).size() : degree(n11);
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
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
        return !edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV()).isEmpty();
    }

    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
