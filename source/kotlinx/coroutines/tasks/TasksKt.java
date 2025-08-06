package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l;

public final class TasksKt {

    public static final class a<TResult> implements OnCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k<T> f57566a;

        public a(k<? super T> kVar) {
            this.f57566a = kVar;
        }

        public final void onComplete(Task<T> task) {
            Exception exception = task.getException();
            if (exception != null) {
                k<T> kVar = this.f57566a;
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(exception)));
            } else if (task.isCanceled()) {
                k.a.a(this.f57566a, (Throwable) null, 1, (Object) null);
            } else {
                k<T> kVar2 = this.f57566a;
                Result.a aVar2 = Result.Companion;
                kVar2.resumeWith(Result.m3072constructorimpl(task.getResult()));
            }
        }
    }

    public static final <T> Object a(Task<T> task, c<? super T> cVar) {
        return b(task, (CancellationTokenSource) null, cVar);
    }

    public static final <T> Object b(Task<T> task, CancellationTokenSource cancellationTokenSource, c<? super T> cVar) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception != null) {
                throw exception;
            } else if (!task.isCanceled()) {
                return task.getResult();
            } else {
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
        } else {
            l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
            lVar.A();
            task.addOnCompleteListener((Executor) a.f57567b, (OnCompleteListener<T>) new a(lVar));
            if (cancellationTokenSource != null) {
                lVar.x(new TasksKt$awaitImpl$2$2(cancellationTokenSource));
            }
            Object v11 = lVar.v();
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            return v11;
        }
    }
}
