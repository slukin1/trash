package com.mob.tools.gui;

import com.mob.tools.MobLog;
import java.util.Iterator;
import java.util.LinkedList;

public class CachePoolInner<K, V> {
    private int capacity;
    private OnRemoveListener<K, V> listener;
    private LinkedList<CachePoolInner<K, V>.Node<K, V>> pool = new LinkedList<>();
    private int poolSize;

    public class Node<K, V> {
        /* access modifiers changed from: private */
        public long cacheTime;
        public K key;
        /* access modifiers changed from: private */
        public int size;
        public V value;

        private Node() {
        }
    }

    public interface OnRemoveListener<K, V> {
        void onRemove(K k11, V v11);
    }

    public CachePoolInner(int i11) {
        this.capacity = i11;
    }

    public synchronized void clear() {
        LinkedList<CachePoolInner<K, V>.Node<K, V>> linkedList = this.pool;
        if (linkedList != null && this.capacity > 0) {
            if (this.listener == null) {
                linkedList.clear();
            } else {
                while (this.pool.size() > 0) {
                    Node removeLast = this.pool.removeLast();
                    if (removeLast != null) {
                        this.poolSize -= removeLast.size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(removeLast.key, removeLast.value);
                        }
                    }
                }
            }
            this.poolSize = 0;
        }
    }

    public synchronized V get(K k11) {
        Node node;
        if (this.pool != null && this.capacity > 0) {
            while (this.poolSize > this.capacity) {
                try {
                    Node removeLast = this.pool.removeLast();
                    if (removeLast != null) {
                        this.poolSize -= removeLast.size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(removeLast.key, removeLast.value);
                        }
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                }
            }
            Iterator it2 = this.pool.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    node = null;
                    break;
                }
                node = (Node) it2.next();
                if (node != null) {
                    if (k11 != null || node.key != null) {
                        if (k11 != null && k11.equals(node.key)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (node != null) {
                this.pool.set(0, node);
                long unused = node.cacheTime = System.currentTimeMillis();
                return node.value;
            }
        }
        return null;
    }

    public synchronized boolean put(K k11, V v11, int i11) {
        if (this.pool != null && this.capacity > 0) {
            try {
                Node node = new Node();
                node.key = k11;
                node.value = v11;
                long unused = node.cacheTime = System.currentTimeMillis();
                int unused2 = node.size = i11;
                this.pool.add(0, node);
                this.poolSize += i11;
                while (this.poolSize > this.capacity) {
                    Node removeLast = this.pool.removeLast();
                    if (removeLast != null) {
                        this.poolSize -= removeLast.size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(removeLast.key, removeLast.value);
                        }
                    }
                }
                return true;
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return false;
            }
        }
    }

    public void setOnRemoveListener(OnRemoveListener<K, V> onRemoveListener) {
        this.listener = onRemoveListener;
    }

    public synchronized int size() {
        return this.poolSize;
    }

    public synchronized void trimBeforeTime(long j11) {
        LinkedList<CachePoolInner<K, V>.Node<K, V>> linkedList = this.pool;
        if (linkedList != null && this.capacity > 0) {
            int size = linkedList.size() - 1;
            while (size >= 0) {
                if (this.pool.get(size).cacheTime < j11) {
                    Node remove = this.pool.remove(size);
                    if (remove != null) {
                        this.poolSize -= remove.size;
                        OnRemoveListener<K, V> onRemoveListener = this.listener;
                        if (onRemoveListener != null) {
                            onRemoveListener.onRemove(remove.key, remove.value);
                        }
                    }
                } else {
                    size--;
                }
            }
            while (this.poolSize > this.capacity) {
                Node removeLast = this.pool.removeLast();
                if (removeLast != null) {
                    this.poolSize -= removeLast.size;
                    OnRemoveListener<K, V> onRemoveListener2 = this.listener;
                    if (onRemoveListener2 != null) {
                        onRemoveListener2.onRemove(removeLast.key, removeLast.value);
                    }
                }
            }
        }
    }

    public synchronized boolean put(K k11, V v11) {
        return put(k11, v11, 1);
    }
}
