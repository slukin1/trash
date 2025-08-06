package androidx.window.core;

import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b \u0018\u0000 \t*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\t\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0011\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¨\u0006\u0010"}, d2 = {"Landroidx/window/core/SpecificationComputer;", "", "T", "", "message", "Lkotlin/Function1;", "", "condition", "c", "a", "()Ljava/lang/Object;", "value", "b", "<init>", "()V", "VerificationMode", "window_release"}, k = 1, mv = {1, 6, 0})
public abstract class SpecificationComputer<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12042a = new a((r) null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ=\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/window/core/SpecificationComputer$a;", "", "T", "", "tag", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "verificationMode", "Landroidx/window/core/e;", "logger", "Landroidx/window/core/SpecificationComputer;", "a", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/e;)Landroidx/window/core/SpecificationComputer;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer b(a aVar, Object obj, String str, VerificationMode verificationMode, e eVar, int i11, Object obj2) {
            if ((i11 & 2) != 0) {
                verificationMode = c.f12058a.a();
            }
            if ((i11 & 4) != 0) {
                eVar = a.f12053a;
            }
            return aVar.a(obj, str, verificationMode, eVar);
        }

        public final <T> SpecificationComputer<T> a(T t11, String str, VerificationMode verificationMode, e eVar) {
            return new f(t11, str, verificationMode, eVar);
        }
    }

    public abstract T a();

    public final String b(Object obj, String str) {
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> c(String str, l<? super T, Boolean> lVar);
}
