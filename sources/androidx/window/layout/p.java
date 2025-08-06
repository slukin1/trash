package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.d;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/p;", "", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/d;", "Landroidx/window/layout/s;", "a", "window_release"}, k = 1, mv = {1, 6, 0})
public interface p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12151a = a.f12152a;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/p$a;", "", "Landroid/content/Context;", "context", "Landroidx/window/layout/p;", "a", "Landroidx/window/layout/n;", "b", "(Landroid/content/Context;)Landroidx/window/layout/n;", "", "Z", "DEBUG", "", "c", "Ljava/lang/String;", "TAG", "Landroidx/window/layout/q;", "d", "Landroidx/window/layout/q;", "decorator", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f12152a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f12153b = false;

        /* renamed from: c  reason: collision with root package name */
        public static final String f12154c = Reflection.b(p.class).f();

        /* renamed from: d  reason: collision with root package name */
        public static q f12155d = f.f12109a;

        public final p a(Context context) {
            return f12155d.a(new WindowInfoTrackerImpl(v.f12159a, b(context)));
        }

        public final n b(Context context) {
            h hVar = null;
            try {
                WindowLayoutComponent m11 = SafeWindowLayoutComponentProvider.f12078a.m();
                if (m11 != null) {
                    hVar = new h(m11);
                }
            } catch (Throwable unused) {
                if (f12153b) {
                    Log.d(f12154c, "Failed to load WindowExtensions");
                }
            }
            return hVar == null ? l.f12139c.a(context) : hVar;
        }
    }

    d<s> a(Activity activity);
}
