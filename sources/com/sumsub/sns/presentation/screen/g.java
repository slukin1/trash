package com.sumsub.sns.presentation.screen;

import com.sumsub.log.logger.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.log.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g {
    public static final List<Document> a(List<Document> list, com.sumsub.sns.internal.core.data.model.g gVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            boolean z11 = false;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            Document document = (Document) next;
            if (gVar.I().k()) {
                List<String> j11 = gVar.I().j();
                if (!(j11 != null && j11.contains(document.getType().c()))) {
                    z11 = true;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : arrayList) {
            Document document2 = (Document) next2;
            if (!document2.isSubmitted() || document2.isRejected()) {
                arrayList2.add(next2);
            }
        }
        a.d(com.sumsub.sns.internal.log.a.f34862a, c.a(d.L), "moveToNextStep: total docs " + list.size() + ", videoIdent docs left " + arrayList2.size(), (Throwable) null, 4, (Object) null);
        if (!arrayList2.isEmpty()) {
            return arrayList2;
        }
        return null;
    }

    public static final Document b(List<Document> list, com.sumsub.sns.internal.core.data.model.g gVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            boolean z11 = true;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            Document document = (Document) next;
            if (gVar.I().k()) {
                List<String> j11 = gVar.I().j();
                if (!(j11 != null ? j11.contains(document.getType().c()) : false)) {
                    z11 = false;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : arrayList) {
            Document document2 = (Document) next2;
            if (!document2.isSubmitted() || document2.isRejected()) {
                arrayList2.add(next2);
            }
        }
        a.d(com.sumsub.sns.internal.log.a.f34862a, c.a(d.L), "moveToNextStep: total docs " + list.size() + ", docs left " + arrayList2.size(), (Throwable) null, 4, (Object) null);
        return (Document) CollectionsKt___CollectionsKt.c0(arrayList2);
    }
}
