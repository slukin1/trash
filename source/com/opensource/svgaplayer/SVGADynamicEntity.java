package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import d10.p;
import d10.r;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R>\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR>\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR>\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0016`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR>\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR>\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b \u0010\u000bRb\u0010&\u001aB\u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040\"0\u0002j \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040\"`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b%\u0010\u000bR>\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR>\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u001b\u0010\t\"\u0004\b,\u0010\u000bRz\u00100\u001aZ\u0012\u0004\u0012\u00020\u0003\u0012\"\u0012 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.0\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012\"\u0012 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.`\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b/\u0010\u000bR\"\u00106\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/opensource/svgaplayer/SVGADynamicEntity;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "d", "()Ljava/util/HashMap;", "setDynamicHidden$com_opensource_svgaplayer", "(Ljava/util/HashMap;)V", "dynamicHidden", "Landroid/graphics/Bitmap;", "b", "f", "setDynamicImage$com_opensource_svgaplayer", "dynamicImage", "c", "h", "setDynamicText$com_opensource_svgaplayer", "dynamicText", "Landroid/text/TextPaint;", "i", "setDynamicTextPaint$com_opensource_svgaplayer", "dynamicTextPaint", "Landroid/text/StaticLayout;", "e", "g", "setDynamicStaticLayoutText$com_opensource_svgaplayer", "dynamicStaticLayoutText", "Landroid/text/BoringLayout;", "setDynamicBoringLayoutText$com_opensource_svgaplayer", "dynamicBoringLayoutText", "Lkotlin/Function2;", "Landroid/graphics/Canvas;", "", "setDynamicDrawer$com_opensource_svgaplayer", "dynamicDrawer", "", "j", "setMClickMap$com_opensource_svgaplayer", "mClickMap", "Lcom/opensource/svgaplayer/a;", "setDynamicIClickArea$com_opensource_svgaplayer", "dynamicIClickArea", "Lkotlin/Function4;", "setDynamicDrawerSized$com_opensource_svgaplayer", "dynamicDrawerSized", "k", "Z", "()Z", "l", "(Z)V", "isTextDirty", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGADynamicEntity {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f28469a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Bitmap> f28470b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f28471c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, TextPaint> f28472d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, StaticLayout> f28473e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, BoringLayout> f28474f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, p<Canvas, Integer, Boolean>> f28475g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, int[]> f28476h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, a> f28477i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> f28478j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public boolean f28479k;

    public final HashMap<String, BoringLayout> a() {
        return this.f28474f;
    }

    public final HashMap<String, p<Canvas, Integer, Boolean>> b() {
        return this.f28475g;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> c() {
        return this.f28478j;
    }

    public final HashMap<String, Boolean> d() {
        return this.f28469a;
    }

    public final HashMap<String, a> e() {
        return this.f28477i;
    }

    public final HashMap<String, Bitmap> f() {
        return this.f28470b;
    }

    public final HashMap<String, StaticLayout> g() {
        return this.f28473e;
    }

    public final HashMap<String, String> h() {
        return this.f28471c;
    }

    public final HashMap<String, TextPaint> i() {
        return this.f28472d;
    }

    public final HashMap<String, int[]> j() {
        return this.f28476h;
    }

    public final boolean k() {
        return this.f28479k;
    }

    public final void l(boolean z11) {
        this.f28479k = z11;
    }
}
