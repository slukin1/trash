package com.fluttercandies.photo_manager.core.entity;

import com.fluttercandies.photo_manager.constant.AssetType;
import com.fluttercandies.photo_manager.core.utils.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;

public final class FilterOption {

    /* renamed from: a  reason: collision with root package name */
    public final FilterCond f65064a;

    /* renamed from: b  reason: collision with root package name */
    public final FilterCond f65065b;

    /* renamed from: c  reason: collision with root package name */
    public final FilterCond f65066c;

    /* renamed from: d  reason: collision with root package name */
    public final c f65067d;

    /* renamed from: e  reason: collision with root package name */
    public final c f65068e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65069f;

    /* renamed from: g  reason: collision with root package name */
    public final List<e> f65070g;

    public FilterOption(Map<?, ?> map) {
        b bVar = b.f65118a;
        this.f65064a = bVar.h(map, AssetType.Video);
        this.f65065b = bVar.h(map, AssetType.Image);
        this.f65066c = bVar.h(map, AssetType.Audio);
        this.f65067d = bVar.e((Map) map.get("createDate"));
        this.f65068e = bVar.e((Map) map.get("updateDate"));
        this.f65069f = ((Boolean) map.get("containsPathModified")).booleanValue();
        this.f65070g = bVar.b((List) map.get("orders"));
    }

    public final FilterCond a() {
        return this.f65066c;
    }

    public final boolean b() {
        return this.f65069f;
    }

    public final c c() {
        return this.f65067d;
    }

    public final FilterCond d() {
        return this.f65065b;
    }

    public final c e() {
        return this.f65068e;
    }

    public final FilterCond f() {
        return this.f65064a;
    }

    public final String g() {
        if (this.f65070g.isEmpty()) {
            return null;
        }
        return CollectionsKt___CollectionsKt.k0(this.f65070g, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, FilterOption$orderByCondString$1.INSTANCE, 30, (Object) null);
    }
}
