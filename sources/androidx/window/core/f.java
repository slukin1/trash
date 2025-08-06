package androidx.window.core;

import androidx.window.core.SpecificationComputer;
import d10.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B'\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b \u0010!J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000f\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Landroidx/window/core/f;", "", "T", "Landroidx/window/core/SpecificationComputer;", "", "message", "Lkotlin/Function1;", "", "condition", "c", "a", "()Ljava/lang/Object;", "b", "Ljava/lang/Object;", "getValue", "value", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "d", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "getVerificationMode", "()Landroidx/window/core/SpecificationComputer$VerificationMode;", "verificationMode", "Landroidx/window/core/e;", "e", "Landroidx/window/core/e;", "getLogger", "()Landroidx/window/core/e;", "logger", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/e;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class f<T> extends SpecificationComputer<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f12067b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12068c;

    /* renamed from: d  reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f12069d;

    /* renamed from: e  reason: collision with root package name */
    public final e f12070e;

    public f(T t11, String str, SpecificationComputer.VerificationMode verificationMode, e eVar) {
        this.f12067b = t11;
        this.f12068c = str;
        this.f12069d = verificationMode;
        this.f12070e = eVar;
    }

    public T a() {
        return this.f12067b;
    }

    public SpecificationComputer<T> c(String str, l<? super T, Boolean> lVar) {
        if (lVar.invoke(this.f12067b).booleanValue()) {
            return this;
        }
        return new d(this.f12067b, this.f12068c, str, this.f12070e, this.f12069d);
    }
}
