package com.huobi.dynamiclangs.transformer;

import android.view.View;
import java.util.ArrayList;

public final class ViewTransformerManager {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a> f43877a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Class<? extends View>> f43878b = new ArrayList<>();

    public interface a {
        Class<? extends View> getViewType();
    }

    public final void a(a aVar) {
        this.f43877a.add(aVar);
        this.f43878b.add(aVar.getViewType());
    }
}
