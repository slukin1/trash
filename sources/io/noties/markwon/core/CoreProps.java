package io.noties.markwon.core;

import rz.b;

public abstract class CoreProps {

    /* renamed from: a  reason: collision with root package name */
    public static final b<ListItemType> f55291a = b.c("list-item-type");

    /* renamed from: b  reason: collision with root package name */
    public static final b<Integer> f55292b = b.c("bullet-list-item-level");

    /* renamed from: c  reason: collision with root package name */
    public static final b<Integer> f55293c = b.c("ordered-list-item-number");

    /* renamed from: d  reason: collision with root package name */
    public static final b<Integer> f55294d = b.c("heading-level");

    /* renamed from: e  reason: collision with root package name */
    public static final b<String> f55295e = b.c("link-destination");

    /* renamed from: f  reason: collision with root package name */
    public static final b<Boolean> f55296f = b.c("paragraph-is-in-tight-list");

    /* renamed from: g  reason: collision with root package name */
    public static final b<String> f55297g = b.c("code-block-info");

    public enum ListItemType {
        BULLET,
        ORDERED
    }
}
