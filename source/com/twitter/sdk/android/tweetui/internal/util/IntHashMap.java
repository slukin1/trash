package com.twitter.sdk.android.tweetui.internal.util;

import java.util.Objects;

public class IntHashMap {
    private int count;
    private float loadFactor;
    private Entry[] table;
    private int threshold;

    public static class Entry {
        public final int hash;
        public int key;
        public Entry next;
        public Object value;

        public Entry(int i11, int i12, Object obj, Entry entry) {
            this.hash = i11;
            this.key = i12;
            this.value = obj;
            this.next = entry;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public synchronized void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                entryArr[length] = null;
            } else {
                this.count = 0;
            }
        }
    }

    public boolean contains(Object obj) {
        Objects.requireNonNull(obj);
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i11 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i11]; entry != null; entry = entry.next) {
                if (entry.value.equals(obj)) {
                    return true;
                }
            }
            length = i11;
        }
    }

    public boolean containsKey(int i11) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i11) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i11) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i11) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i11) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object put(int i11, Object obj) {
        Entry[] entryArr = this.table;
        int i12 = Integer.MAX_VALUE & i11;
        int length = i12 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i11) {
                Object obj2 = entry.value;
                entry.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i12 % entryArr.length;
        }
        entryArr[length] = new Entry(i11, i11, obj, entryArr[length]);
        this.count++;
        return null;
    }

    public void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i11 = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i11];
        this.threshold = (int) (((float) i11) * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i12 = length - 1;
            if (length > 0) {
                Entry entry = entryArr[i12];
                while (entry != null) {
                    Entry entry2 = entry.next;
                    int i13 = (entry.hash & Integer.MAX_VALUE) % i11;
                    entry.next = entryArr2[i13];
                    entryArr2[i13] = entry;
                    entry = entry2;
                }
                length = i12;
            } else {
                return;
            }
        }
    }

    public Object remove(int i11) {
        Entry[] entryArr = this.table;
        int length = (Integer.MAX_VALUE & i11) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i11) {
                if (entry != null) {
                    entry.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                Object obj = entry2.value;
                entry2.value = null;
                return obj;
            }
            entry = entry2;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i11) {
        this(i11, 0.75f);
    }

    public IntHashMap(int i11, float f11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i11);
        } else if (f11 > 0.0f) {
            i11 = i11 == 0 ? 1 : i11;
            this.loadFactor = f11;
            this.table = new Entry[i11];
            this.threshold = (int) (((float) i11) * f11);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f11);
        }
    }
}
