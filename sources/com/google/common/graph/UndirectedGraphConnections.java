package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    private UndirectedGraphConnections(Map<N, V> map) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
    }

    public static <N, V> UndirectedGraphConnections<N, V> of() {
        return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
    }

    public static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> map) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf(map));
    }

    public void addPredecessor(N n11, V v11) {
        addSuccessor(n11, v11);
    }

    public V addSuccessor(N n11, V v11) {
        return this.adjacentNodeValues.put(n11, v11);
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public void removePredecessor(N n11) {
        removeSuccessor(n11);
    }

    public V removeSuccessor(N n11) {
        return this.adjacentNodeValues.remove(n11);
    }

    public Set<N> successors() {
        return adjacentNodes();
    }

    public V value(N n11) {
        return this.adjacentNodeValues.get(n11);
    }
}
