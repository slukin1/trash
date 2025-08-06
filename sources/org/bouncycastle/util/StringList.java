package org.bouncycastle.util;

public interface StringList extends Iterable<String> {
    boolean add(String str);

    String get(int i11);

    int size();

    String[] toStringArray();

    String[] toStringArray(int i11, int i12);
}
