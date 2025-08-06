package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.internal.core.data.model.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.x;

public final class m implements Comparator<Document> {

    /* renamed from: a  reason: collision with root package name */
    public final g f32642a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DocumentType> f32643b;

    public static final class a<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f32644a;

        public a(List list) {
            this.f32644a = list;
        }

        public final int compare(T t11, T t12) {
            return ComparisonsKt__ComparisonsKt.a(Integer.valueOf(this.f32644a.contains(((DocumentType) t11).c()) ^ true ? 1 : 0), Integer.valueOf(this.f32644a.contains(((DocumentType) t12).c()) ^ true ? 1 : 0));
        }
    }

    public m(g gVar) {
        this.f32642a = gVar;
        List<g.c.a> g11 = gVar.I().g();
        List arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
        for (g.c.a m11 : g11) {
            arrayList.add(m11.m().c());
        }
        List j11 = !this.f32642a.I().k() ? null : this.f32642a.I().j();
        arrayList = j11 != null ? j11 : arrayList;
        List<g.c.a> g12 = this.f32642a.I().g();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(g12, 10));
        for (g.c.a m12 : g12) {
            arrayList2.add(m12.m());
        }
        this.f32643b = CollectionsKt___CollectionsKt.z0(arrayList2, new a(arrayList));
    }

    /* renamed from: a */
    public int compare(Document document, Document document2) {
        int i11;
        int i12 = 0;
        int i13 = -1;
        if (document != null) {
            Iterator<DocumentType> it2 = this.f32643b.iterator();
            i11 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (x.b(it2.next(), document.getType())) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        i11 = -1;
        if (document2 != null) {
            Iterator<DocumentType> it3 = this.f32643b.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                } else if (x.b(it3.next(), document2.getType())) {
                    i13 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        return i11 - i13;
    }
}
