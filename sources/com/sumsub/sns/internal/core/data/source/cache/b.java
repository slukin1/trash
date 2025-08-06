package com.sumsub.sns.internal.core.data.source.cache;

import android.content.Context;
import d10.p;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f33247a;

    @d(c = "com.sumsub.sns.internal.core.data.source.cache.CacheRepositoryImpl$addFileToCache$2", f = "CacheRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super File>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33248a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f33249b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f33250c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ byte[] f33251d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, String str, byte[] bArr, c<? super a> cVar) {
            super(2, cVar);
            this.f33249b = bVar;
            this.f33250c = str;
            this.f33251d = bArr;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super File> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f33249b, this.f33250c, this.f33251d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33248a == 0) {
                k.b(obj);
                File file = new File(this.f33249b.f33247a.getCacheDir(), this.f33250c);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(this.f33251d);
                    return file;
                } finally {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @d(c = "com.sumsub.sns.internal.core.data.source.cache.CacheRepositoryImpl$createNewFile$2", f = "CacheRepositoryImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.core.data.source.cache.b$b  reason: collision with other inner class name */
    public static final class C0362b extends SuspendLambda implements p<h0, c<? super File>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33252a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33253b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f33254c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f33255d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0362b(b bVar, String str, c<? super C0362b> cVar) {
            super(2, cVar);
            this.f33254c = bVar;
            this.f33255d = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super File> cVar) {
            return ((C0362b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            C0362b bVar = new C0362b(this.f33254c, this.f33255d, cVar);
            bVar.f33253b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f33252a == 0) {
                k.b(obj);
                h0 h0Var = (h0) this.f33253b;
                File file = new File(this.f33254c.f33247a.getCacheDir(), this.f33255d);
                try {
                    file.createNewFile();
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    String a11 = com.sumsub.sns.internal.log.c.a(h0Var);
                    String message = e11.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    aVar.e(a11, message, e11);
                }
                return file;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public b(Context context) {
        this.f33247a = context;
    }

    public Object a(String str, byte[] bArr, c<? super File> cVar) {
        return g.g(v0.b(), new a(this, str, bArr, (c<? super a>) null), cVar);
    }

    public Object a(String str, c<? super File> cVar) {
        return g.g(v0.b(), new C0362b(this, str, (c<? super C0362b>) null), cVar);
    }
}
