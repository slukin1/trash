package io.noties.markwon;

import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.ImageSizeResolver;
import io.noties.markwon.image.ImageSizeResolverDef;
import io.noties.markwon.image.destination.ImageDestinationProcessor;
import io.noties.markwon.syntax.SyntaxHighlightNoOp;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final sz.a f55270a;

    /* renamed from: b  reason: collision with root package name */
    public final AsyncDrawableLoader f55271b;

    /* renamed from: c  reason: collision with root package name */
    public final c00.a f55272c;

    /* renamed from: d  reason: collision with root package name */
    public final rz.a f55273d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageDestinationProcessor f55274e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageSizeResolver f55275f;

    /* renamed from: g  reason: collision with root package name */
    public final e f55276g;

    /* renamed from: io.noties.markwon.b$b  reason: collision with other inner class name */
    public static class C0649b {

        /* renamed from: a  reason: collision with root package name */
        public sz.a f55277a;

        /* renamed from: b  reason: collision with root package name */
        public AsyncDrawableLoader f55278b;

        /* renamed from: c  reason: collision with root package name */
        public c00.a f55279c;

        /* renamed from: d  reason: collision with root package name */
        public rz.a f55280d;

        /* renamed from: e  reason: collision with root package name */
        public ImageDestinationProcessor f55281e;

        /* renamed from: f  reason: collision with root package name */
        public ImageSizeResolver f55282f;

        /* renamed from: g  reason: collision with root package name */
        public e f55283g;

        public b h(sz.a aVar, e eVar) {
            this.f55277a = aVar;
            this.f55283g = eVar;
            if (this.f55278b == null) {
                this.f55278b = AsyncDrawableLoader.a();
            }
            if (this.f55279c == null) {
                this.f55279c = new SyntaxHighlightNoOp();
            }
            if (this.f55280d == null) {
                this.f55280d = new LinkResolverDef();
            }
            if (this.f55281e == null) {
                this.f55281e = ImageDestinationProcessor.a();
            }
            if (this.f55282f == null) {
                this.f55282f = new ImageSizeResolverDef();
            }
            return new b(this);
        }

        public C0649b i(rz.a aVar) {
            this.f55280d = aVar;
            return this;
        }
    }

    public AsyncDrawableLoader a() {
        return this.f55271b;
    }

    public ImageDestinationProcessor b() {
        return this.f55274e;
    }

    public ImageSizeResolver c() {
        return this.f55275f;
    }

    public rz.a d() {
        return this.f55273d;
    }

    public e e() {
        return this.f55276g;
    }

    public c00.a f() {
        return this.f55272c;
    }

    public sz.a g() {
        return this.f55270a;
    }

    public b(C0649b bVar) {
        this.f55270a = bVar.f55277a;
        this.f55271b = bVar.f55278b;
        this.f55272c = bVar.f55279c;
        this.f55273d = bVar.f55280d;
        this.f55274e = bVar.f55281e;
        this.f55275f = bVar.f55282f;
        this.f55276g = bVar.f55283g;
    }
}
