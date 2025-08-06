package com.huobi.pandoraBox.crashKiller.core.cleaner;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import d10.l;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001J\u0013\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001J\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001J\u0013\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001J\u001c\u0010\f\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tJ\b\u0010\r\u001a\u00020\u0004H\u0002¨\u0006\u0011"}, d2 = {"Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner;", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/b;", "Landroid/os/Message;", "message", "", "a", "d", "b", "c", "Lkotlin/Function1;", "", "onException", "j", "h", "cleaner", "<init>", "(Lcom/huobi/pandoraBox/crashKiller/core/cleaner/b;)V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class PageCleaner implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f80302c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final i<PageCleaner> f80303d = LazyKt__LazyJVMKt.a(PageCleaner$Companion$sPageCleaner$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f80304a;

    /* renamed from: b  reason: collision with root package name */
    public l<? super Throwable, Unit> f80305b;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u001b\u0010\n\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner$a;", "", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner;", "b", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/b;", "c", "sPageCleaner$delegate", "Lkotlin/i;", "d", "()Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner;", "sPageCleaner", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final synchronized PageCleaner b() {
            return d();
        }

        public final b c() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                return new PageCleaner28();
            }
            if (i11 >= 26) {
                return new PageCleaner26();
            }
            if (i11 == 25 || i11 == 24) {
                return new PageCleaner24To25();
            }
            return new PageCleaner21To23();
        }

        public final PageCleaner d() {
            return (PageCleaner) PageCleaner.f80303d.getValue();
        }
    }

    public PageCleaner(b bVar) {
        this.f80304a = bVar;
    }

    public /* synthetic */ PageCleaner(b bVar, r rVar) {
        this(bVar);
    }

    public static final boolean i(Handler handler, PageCleaner pageCleaner, int i11, int i12, int i13, int i14, int i15, int i16, Message message) {
        if (Build.VERSION.SDK_INT < 28) {
            int i17 = message.what;
            if (i17 == i11) {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th2) {
                    pageCleaner.a(message);
                    l<? super Throwable, Unit> lVar = pageCleaner.f80305b;
                    if (lVar != null) {
                        lVar.invoke(th2);
                    }
                }
                return true;
            } else if (i17 == i12) {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th3) {
                    pageCleaner.b(message);
                    l<? super Throwable, Unit> lVar2 = pageCleaner.f80305b;
                    if (lVar2 != null) {
                        lVar2.invoke(th3);
                    }
                }
                return true;
            } else if (i17 == i13) {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th4) {
                    pageCleaner.d(message);
                    l<? super Throwable, Unit> lVar3 = pageCleaner.f80305b;
                    if (lVar3 != null) {
                        lVar3.invoke(th4);
                    }
                }
                return true;
            } else if (i17 == i14) {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th5) {
                    pageCleaner.d(message);
                    l<? super Throwable, Unit> lVar4 = pageCleaner.f80305b;
                    if (lVar4 != null) {
                        lVar4.invoke(th5);
                    }
                }
                return true;
            } else if (i17 == i15) {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th6) {
                    pageCleaner.c(message);
                    l<? super Throwable, Unit> lVar5 = pageCleaner.f80305b;
                    if (lVar5 != null) {
                        lVar5.invoke(th6);
                    }
                }
                return true;
            } else if (i17 != i16) {
                return false;
            } else {
                try {
                    handler.handleMessage(message);
                } catch (Throwable th7) {
                    l<? super Throwable, Unit> lVar6 = pageCleaner.f80305b;
                    if (lVar6 != null) {
                        lVar6.invoke(th7);
                    }
                }
                return true;
            }
        } else if (message.what != 159) {
            return false;
        } else {
            try {
                handler.handleMessage(message);
            } catch (Throwable th8) {
                pageCleaner.a(message);
                l<? super Throwable, Unit> lVar7 = pageCleaner.f80305b;
                if (lVar7 != null) {
                    lVar7.invoke(th8);
                }
            }
            return true;
        }
    }

    public void a(Message message) {
        this.f80304a.a(message);
    }

    public void b(Message message) {
        this.f80304a.b(message);
    }

    public void c(Message message) {
        this.f80304a.c(message);
    }

    public void d(Message message) {
        this.f80304a.d(message);
    }

    public final void h() throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Object invoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mH");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(invoke);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type android.os.Handler");
        Handler handler = (Handler) obj;
        Field declaredField2 = Handler.class.getDeclaredField("mCallback");
        declaredField2.setAccessible(true);
        declaredField2.set(handler, new c(handler, this, 100, 107, 102, 101, 104, 109));
    }

    public final void j(l<? super Throwable, Unit> lVar) {
        this.f80305b = lVar;
    }
}
