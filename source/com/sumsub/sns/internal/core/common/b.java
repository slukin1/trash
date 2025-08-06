package com.sumsub.sns.internal.core.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class b extends HashMap<Character, Integer> {
    public /* bridge */ boolean a(Character ch2) {
        return super.containsKey(ch2);
    }

    public /* bridge */ Set<Character> b() {
        return super.keySet();
    }

    public /* bridge */ int c() {
        return super.size();
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof Character)) {
            return false;
        }
        return a((Character) obj);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        return a((Integer) obj);
    }

    public /* bridge */ Collection<Integer> d() {
        return super.values();
    }

    public final /* bridge */ Set<Map.Entry<Character, Integer>> entrySet() {
        return a();
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof Character)) {
            return null;
        }
        return a(((Character) obj).charValue());
    }

    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof Character) ? obj2 : a((Character) obj, (Integer) obj2);
    }

    public final /* bridge */ Set<Character> keySet() {
        return b();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (!(obj instanceof Character)) {
            return null;
        }
        return b((Character) obj);
    }

    public final /* bridge */ int size() {
        return c();
    }

    public final /* bridge */ Collection<Integer> values() {
        return d();
    }

    public /* bridge */ boolean a(Integer num) {
        return super.containsValue(num);
    }

    public /* bridge */ Integer b(Character ch2) {
        return (Integer) super.remove(ch2);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof Character) && (obj2 instanceof Integer)) {
            return b((Character) obj, (Integer) obj2);
        }
        return false;
    }

    public final /* bridge */ Integer a(Object obj) {
        if (!(obj instanceof Character)) {
            return null;
        }
        return a(((Character) obj).charValue());
    }

    public final /* bridge */ Integer b(Object obj) {
        if (!(obj instanceof Character)) {
            return null;
        }
        return b((Character) obj);
    }

    public /* bridge */ Set<Map.Entry<Character, Integer>> a() {
        return super.entrySet();
    }

    public /* bridge */ boolean b(Character ch2, Integer num) {
        return super.remove(ch2, num);
    }

    public /* bridge */ Integer a(Character ch2, Integer num) {
        return (Integer) super.getOrDefault(ch2, num);
    }

    public final /* bridge */ Integer a(Object obj, Integer num) {
        return !(obj instanceof Character) ? num : a((Character) obj, num);
    }

    public Integer a(char c11) {
        Integer num = (Integer) super.get(Character.valueOf(c11));
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }
}
