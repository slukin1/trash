package com.huobi.dynamiclangs.transformer;

import android.widget.TextView;
import com.huobi.dynamiclangs.data.model.TextMetaData;
import com.huobi.dynamiclangs.transformer.ViewTransformerManager;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseTransformer implements ViewTransformerManager.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f43872a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final String f43873b = "string";

    /* renamed from: c  reason: collision with root package name */
    public final String f43874c = "array";

    /* renamed from: d  reason: collision with root package name */
    public final String f43875d = "plurals";

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<TextView, TextMetaData> f43876e = new ConcurrentHashMap<>();
}
