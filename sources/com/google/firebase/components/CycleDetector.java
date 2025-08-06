package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class CycleDetector {

    public static class ComponentNode {
        private final Component<?> component;
        private final Set<ComponentNode> dependencies = new HashSet();
        private final Set<ComponentNode> dependents = new HashSet();

        public ComponentNode(Component<?> component2) {
            this.component = component2;
        }

        public void addDependency(ComponentNode componentNode) {
            this.dependencies.add(componentNode);
        }

        public void addDependent(ComponentNode componentNode) {
            this.dependents.add(componentNode);
        }

        public Component<?> getComponent() {
            return this.component;
        }

        public Set<ComponentNode> getDependencies() {
            return this.dependencies;
        }

        public boolean isLeaf() {
            return this.dependencies.isEmpty();
        }

        public boolean isRoot() {
            return this.dependents.isEmpty();
        }

        public void removeDependent(ComponentNode componentNode) {
            this.dependents.remove(componentNode);
        }
    }

    public static class Dep {
        private final Qualified<?> anInterface;
        /* access modifiers changed from: private */
        public final boolean set;

        public boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            if (!dep.anInterface.equals(this.anInterface) || dep.set != this.set) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
        }

        private Dep(Qualified<?> qualified, boolean z11) {
            this.anInterface = qualified;
            this.set = z11;
        }
    }

    public static void detect(List<Component<?>> list) {
        Set<ComponentNode> graph = toGraph(list);
        Set<ComponentNode> roots = getRoots(graph);
        int i11 = 0;
        while (!roots.isEmpty()) {
            ComponentNode next = roots.iterator().next();
            roots.remove(next);
            i11++;
            for (ComponentNode next2 : next.getDependencies()) {
                next2.removeDependent(next);
                if (next2.isRoot()) {
                    roots.add(next2);
                }
            }
        }
        if (i11 != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (ComponentNode next3 : graph) {
                if (!next3.isRoot() && !next3.isLeaf()) {
                    arrayList.add(next3.getComponent());
                }
            }
            throw new DependencyCycleException(arrayList);
        }
    }

    private static Set<ComponentNode> getRoots(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode next : set) {
            if (next.isRoot()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    private static Set<ComponentNode> toGraph(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        for (Component next : list) {
            ComponentNode componentNode = new ComponentNode(next);
            Iterator it2 = next.getProvidedInterfaces().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Qualified qualified = (Qualified) it2.next();
                    Dep dep = new Dep(qualified, !next.isValue());
                    if (!hashMap.containsKey(dep)) {
                        hashMap.put(dep, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(dep);
                    if (set2.isEmpty() || dep.set) {
                        set2.add(componentNode);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{qualified}));
                    }
                }
            }
        }
        for (Set<ComponentNode> it3 : hashMap.values()) {
            for (ComponentNode componentNode2 : it3) {
                for (Dependency next2 : componentNode2.getComponent().getDependencies()) {
                    if (next2.isDirectInjection() && (set = (Set) hashMap.get(new Dep(next2.getInterface(), next2.isSet()))) != null) {
                        for (ComponentNode componentNode3 : set) {
                            componentNode2.addDependency(componentNode3);
                            componentNode3.addDependent(componentNode2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }
}
