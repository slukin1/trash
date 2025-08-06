package g2;

import f2.a;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class p extends i {

    /* renamed from: c  reason: collision with root package name */
    public final int f15817c;

    /* renamed from: d  reason: collision with root package name */
    public final List f15818d;

    /* renamed from: e  reason: collision with root package name */
    public final a f15819e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f15820f;

    /* renamed from: g  reason: collision with root package name */
    public final Map f15821g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection f15822h;

    public p(a aVar, List list, int i11) {
        super((Class<?>) null, (i2.a) null);
        this.f15819e = aVar;
        this.f15817c = i11;
        this.f15818d = list;
        this.f15820f = null;
        this.f15821g = null;
        this.f15822h = null;
    }

    public void b(a aVar, Object obj, Type type, Map<String, Object> map) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r4 = (com.alibaba.fastjson.JSONArray) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.util.Map r4 = r3.f15821g
            if (r4 == 0) goto L_0x000a
            java.lang.Object r0 = r3.f15820f
            r4.put(r0, r5)
            return
        L_0x000a:
            java.util.Collection r4 = r3.f15822h
            if (r4 == 0) goto L_0x0012
            r4.add(r5)
            return
        L_0x0012:
            java.util.List r4 = r3.f15818d
            int r0 = r3.f15817c
            r4.set(r0, r5)
            java.util.List r4 = r3.f15818d
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONArray
            if (r0 == 0) goto L_0x0048
            com.alibaba.fastjson.JSONArray r4 = (com.alibaba.fastjson.JSONArray) r4
            java.lang.Object r0 = r4.getRelatedArray()
            if (r0 == 0) goto L_0x0048
            int r1 = java.lang.reflect.Array.getLength(r0)
            int r2 = r3.f15817c
            if (r1 <= r2) goto L_0x0048
            java.lang.reflect.Type r1 = r4.getComponentType()
            if (r1 == 0) goto L_0x0043
            java.lang.reflect.Type r4 = r4.getComponentType()
            f2.a r1 = r3.f15819e
            com.alibaba.fastjson.parser.ParserConfig r1 = r1.k()
            java.lang.Object r5 = com.alibaba.fastjson.util.TypeUtils.f(r5, r4, r1)
        L_0x0043:
            int r4 = r3.f15817c
            java.lang.reflect.Array.set(r0, r4, r5)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.p.e(java.lang.Object, java.lang.Object):void");
    }

    public p(Map map, Object obj) {
        super((Class<?>) null, (i2.a) null);
        this.f15819e = null;
        this.f15817c = -1;
        this.f15818d = null;
        this.f15820f = obj;
        this.f15821g = map;
        this.f15822h = null;
    }

    public p(Collection collection) {
        super((Class<?>) null, (i2.a) null);
        this.f15819e = null;
        this.f15817c = -1;
        this.f15818d = null;
        this.f15820f = null;
        this.f15821g = null;
        this.f15822h = collection;
    }
}
