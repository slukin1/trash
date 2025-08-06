package com.zendesk.service;

import java.util.LinkedHashSet;
import java.util.Set;
import lz.a;
import lz.d;

public class CancellableCompositeZendeskCallback<T> extends ZendeskCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public Set<d<T>> f53458a = new LinkedHashSet();

    public void onError(a aVar) {
        for (d<T> onError : this.f53458a) {
            onError.onError(aVar);
        }
        this.f53458a.clear();
    }

    public void onSuccess(T t11) {
        for (d<T> onSuccess : this.f53458a) {
            onSuccess.onSuccess(t11);
        }
        this.f53458a.clear();
    }
}
