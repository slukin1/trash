package com.huobi.dynamiclangs;

import com.huobi.dynamiclangs.transformer.SpinnerTransformer;
import com.huobi.dynamiclangs.transformer.SupportToolbarTransformer;
import com.huobi.dynamiclangs.transformer.TextViewTransformer;
import com.huobi.dynamiclangs.transformer.ToolbarTransformer;
import com.huobi.dynamiclangs.transformer.ViewTransformerManager;

public class Crowdin {

    /* renamed from: a  reason: collision with root package name */
    public static ViewTransformerManager f43857a;

    public static void a() {
        b();
    }

    public static void b() {
        ViewTransformerManager viewTransformerManager = new ViewTransformerManager();
        f43857a = viewTransformerManager;
        viewTransformerManager.a(new TextViewTransformer());
        f43857a.a(new ToolbarTransformer());
        f43857a.a(new SupportToolbarTransformer());
        f43857a.a(new SpinnerTransformer());
    }
}
