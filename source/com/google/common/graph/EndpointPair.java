package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;

@Immutable(containerOf = {"N"})
@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    public static final class Ordered<N> extends EndpointPair<N> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (!source().equals(endpointPair.source()) || !target().equals(endpointPair.target())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public boolean isOrdered() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        public N source() {
            return nodeU();
        }

        public N target() {
            return nodeV();
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }

        private Ordered(N n11, N n12) {
            super(n11, n12);
        }
    }

    public static final class Unordered<N> extends EndpointPair<N> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            if (!nodeU().equals(endpointPair.nodeV()) || !nodeV().equals(endpointPair.nodeU())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public boolean isOrdered() {
            return false;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        public N source() {
            throw new UnsupportedOperationException(GraphConstants.NOT_AVAILABLE_ON_UNDIRECTED);
        }

        public N target() {
            throw new UnsupportedOperationException(GraphConstants.NOT_AVAILABLE_ON_UNDIRECTED);
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }

        private Unordered(N n11, N n12) {
            super(n11, n12);
        }
    }

    public static <N> EndpointPair<N> of(Graph<?> graph, N n11, N n12) {
        return graph.isDirected() ? ordered(n11, n12) : unordered(n11, n12);
    }

    public static <N> EndpointPair<N> ordered(N n11, N n12) {
        return new Ordered(n11, n12);
    }

    public static <N> EndpointPair<N> unordered(N n11, N n12) {
        return new Unordered(n12, n11);
    }

    public final N adjacentNode(Object obj) {
        if (obj.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (obj.equals(this.nodeV)) {
            return this.nodeU;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n11, N n12) {
        this.nodeU = Preconditions.checkNotNull(n11);
        this.nodeV = Preconditions.checkNotNull(n12);
    }

    public static <N> EndpointPair<N> of(Network<?, ?> network, N n11, N n12) {
        return network.isDirected() ? ordered(n11, n12) : unordered(n11, n12);
    }

    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }
}
