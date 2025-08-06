package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient Node<K, V> head;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> keyToKeyList;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    public transient Node<K, V> tail;

    public class DistinctKeyIterator implements Iterator<K> {
        public Node<K, V> current;
        public int expectedModCount;
        public Node<K, V> next;
        public final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public K next() {
            Node<K, V> node;
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node2 = this.next;
            this.current = node2;
            this.seenKeys.add(node2.key);
            do {
                node = this.next.next;
                this.next = node;
                if (node == null || this.seenKeys.add(node.key)) {
                }
                node = this.next.next;
                this.next = node;
                break;
            } while (this.seenKeys.add(node.key));
            return this.current.key;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    public static class KeyList<K, V> {
        public int count = 1;
        public Node<K, V> head;
        public Node<K, V> tail;

        public KeyList(Node<K, V> node) {
            this.head = node;
            this.tail = node;
            node.previousSibling = null;
            node.nextSibling = null;
        }
    }

    public static final class Node<K, V> extends AbstractMapEntry<K, V> {
        public final K key;
        public Node<K, V> next;
        public Node<K, V> nextSibling;
        public Node<K, V> previous;
        public Node<K, V> previousSibling;
        public V value;

        public Node(K k11, V v11) {
            this.key = k11;
            this.value = v11;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v11) {
            V v12 = this.value;
            this.value = v11;
            return v12;
        }
    }

    public class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        public Node<K, V> current;
        public int expectedModCount;
        public Node<K, V> next;
        public int nextIndex;
        public Node<K, V> previous;

        public NodeIterator(int i11) {
            this.expectedModCount = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i11, size);
            if (i11 < size / 2) {
                this.next = LinkedListMultimap.this.head;
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i12;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (true) {
                    int i13 = i11 + 1;
                    if (i11 >= size) {
                        break;
                    }
                    previous();
                    i11 = i13;
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            return this.previous != null;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previous;
                this.nextIndex--;
            } else {
                this.next = node.next;
            }
            LinkedListMultimap.this.removeNode(node);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        public void setValue(V v11) {
            Preconditions.checkState(this.current != null);
            this.current.value = v11;
        }

        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public Node<K, V> next() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.next;
            this.nextIndex++;
            return node;
        }

        @CanIgnoreReturnValue
        public Node<K, V> previous() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previous;
            this.nextIndex--;
            return node;
        }

        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Node<K, V> addNode(K k11, V v11, Node<K, V> node) {
        Node<K, V> node2 = new Node<>(k11, v11);
        if (this.head == null) {
            this.tail = node2;
            this.head = node2;
            this.keyToKeyList.put(k11, new KeyList(node2));
            this.modCount++;
        } else if (node == null) {
            Node<K, V> node3 = this.tail;
            node3.next = node2;
            node2.previous = node3;
            this.tail = node2;
            KeyList keyList = this.keyToKeyList.get(k11);
            if (keyList == null) {
                this.keyToKeyList.put(k11, new KeyList(node2));
                this.modCount++;
            } else {
                keyList.count++;
                Node<K, V> node4 = keyList.tail;
                node4.nextSibling = node2;
                node2.previousSibling = node4;
                keyList.tail = node2;
            }
        } else {
            this.keyToKeyList.get(k11).count++;
            node2.previous = node.previous;
            node2.previousSibling = node.previousSibling;
            node2.next = node;
            node2.nextSibling = node;
            Node<K, V> node5 = node.previousSibling;
            if (node5 == null) {
                this.keyToKeyList.get(k11).head = node2;
            } else {
                node5.nextSibling = node2;
            }
            Node<K, V> node6 = node.previous;
            if (node6 == null) {
                this.head = node2;
            } else {
                node6.next = node2;
            }
            node.previous = node2;
            node.previousSibling = node2;
        }
        this.size++;
        return node2;
    }

    /* access modifiers changed from: private */
    public static void checkElement(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(Object obj) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(obj)));
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: private */
    public void removeAllNodes(Object obj) {
        Iterators.clear(new ValueForKeyIterator(obj));
    }

    /* access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        Node<K, V> node2 = node.previous;
        if (node2 != null) {
            node2.next = node.next;
        } else {
            this.head = node.next;
        }
        Node<K, V> node3 = node.next;
        if (node3 != null) {
            node3.previous = node2;
        } else {
            this.tail = node2;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            this.keyToKeyList.remove(node.key).count = 0;
            this.modCount++;
        } else {
            KeyList keyList = this.keyToKeyList.get(node.key);
            keyList.count--;
            Node<K, V> node4 = node.previousSibling;
            if (node4 == null) {
                keyList.head = node.nextSibling;
            } else {
                node4.nextSibling = node.nextSibling;
            }
            Node<K, V> node5 = node.nextSibling;
            if (node5 == null) {
                keyList.tail = node4;
            } else {
                node5.previousSibling = node4;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    public Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>() {
            public boolean contains(Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean remove(Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }

            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }
        };
    }

    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @CanIgnoreReturnValue
    public boolean put(K k11, V v11) {
        addNode(k11, v11, (Node) null);
        return true;
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    public int size() {
        return this.size;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i11) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(i11);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i11) {
        return new LinkedListMultimap<>(i11);
    }

    public List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public ListIterator<Map.Entry<K, V>> listIterator(int i11) {
                return new NodeIterator(i11);
            }

            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    public List<V> createValues() {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i11) {
                final NodeIterator nodeIterator = new NodeIterator(i11);
                return new TransformedListIterator<Map.Entry<K, V>, V>(nodeIterator) {
                    public void set(V v11) {
                        nodeIterator.setValue(v11);
                    }

                    public V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }
                };
            }

            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    public List<V> get(final K k11) {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i11) {
                return new ValueForKeyIterator(k11, i11);
            }

            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k11);
                if (keyList == null) {
                    return 0;
                }
                return keyList.count;
            }
        };
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @CanIgnoreReturnValue
    public List<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k11);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k11);
        Iterator<? extends V> it2 = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it2.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it2.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it2.hasNext()) {
            valueForKeyIterator.add(it2.next());
        }
        return copy;
    }

    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    public class ValueForKeyIterator implements ListIterator<V> {
        public Node<K, V> current;
        public final Object key;
        public Node<K, V> next;
        public int nextIndex;
        public Node<K, V> previous;

        public ValueForKeyIterator(Object obj) {
            Node<K, V> node;
            this.key = obj;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            if (keyList == null) {
                node = null;
            } else {
                node = keyList.head;
            }
            this.next = node;
        }

        public void add(V v11) {
            this.previous = LinkedListMultimap.this.addNode(this.key, v11, this.next);
            this.nextIndex++;
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.nextSibling;
            this.nextIndex++;
            return node.value;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previousSibling;
            this.nextIndex--;
            return node.value;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previousSibling;
                this.nextIndex--;
            } else {
                this.next = node.nextSibling;
            }
            LinkedListMultimap.this.removeNode(node);
            this.current = null;
        }

        public void set(V v11) {
            Preconditions.checkState(this.current != null);
            this.current.value = v11;
        }

        public ValueForKeyIterator(Object obj, int i11) {
            int i12;
            Node<K, V> node;
            Node<K, V> node2;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            if (keyList == null) {
                i12 = 0;
            } else {
                i12 = keyList.count;
            }
            Preconditions.checkPositionIndex(i11, i12);
            if (i11 < i12 / 2) {
                if (keyList == null) {
                    node = null;
                } else {
                    node = keyList.head;
                }
                this.next = node;
                while (true) {
                    int i13 = i11 - 1;
                    if (i11 <= 0) {
                        break;
                    }
                    next();
                    i11 = i13;
                }
            } else {
                if (keyList == null) {
                    node2 = null;
                } else {
                    node2 = keyList.tail;
                }
                this.previous = node2;
                this.nextIndex = i12;
                while (true) {
                    int i14 = i11 + 1;
                    if (i11 >= i12) {
                        break;
                    }
                    previous();
                    i11 = i14;
                }
            }
            this.key = obj;
            this.current = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
