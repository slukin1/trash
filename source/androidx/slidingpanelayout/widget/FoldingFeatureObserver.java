package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.e;
import androidx.window.layout.j;
import androidx.window.layout.p;
import androidx.window.layout.s;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver;", "", "Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$a;", "onFoldingFeatureChangeListener", "", "f", "Landroid/app/Activity;", "activity", "e", "g", "Landroidx/window/layout/s;", "windowLayoutInfo", "Landroidx/window/layout/j;", "d", "Landroidx/window/layout/p;", "a", "Landroidx/window/layout/p;", "windowInfoTracker", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "executor", "Lkotlinx/coroutines/n1;", "c", "Lkotlinx/coroutines/n1;", "job", "Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$a;", "<init>", "(Landroidx/window/layout/p;Ljava/util/concurrent/Executor;)V", "slidingpanelayout_release"}, k = 1, mv = {1, 6, 0})
public final class FoldingFeatureObserver {

    /* renamed from: a  reason: collision with root package name */
    public final p f10947a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f10948b;

    /* renamed from: c  reason: collision with root package name */
    public n1 f10949c;

    /* renamed from: d  reason: collision with root package name */
    public a f10950d;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$a;", "", "Landroidx/window/layout/j;", "foldingFeature", "", "a", "slidingpanelayout_release"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a(j jVar);
    }

    public FoldingFeatureObserver(p pVar, Executor executor) {
        this.f10947a = pVar;
        this.f10948b = executor;
    }

    public final j d(s sVar) {
        T t11;
        Iterator<T> it2 = sVar.a().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((e) t11) instanceof j) {
                break;
            }
        }
        if (t11 instanceof j) {
            return (j) t11;
        }
        return null;
    }

    public final void e(Activity activity) {
        n1 n1Var = this.f10949c;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f10949c = i.d(i0.a(f1.a(this.f10948b)), (CoroutineContext) null, (CoroutineStart) null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, (c<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1>) null), 3, (Object) null);
    }

    public final void f(a aVar) {
        this.f10950d = aVar;
    }

    public final void g() {
        n1 n1Var = this.f10949c;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
    }
}
