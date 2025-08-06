package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import h1.a;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012Jb\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/e;", "", "T", "Landroidx/datastore/core/i;", "serializer", "Lh1/a;", "corruptionHandler", "", "Landroidx/datastore/core/c;", "migrations", "Lkotlinx/coroutines/h0;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/d;", "a", "<init>", "()V", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f8948a = new e();

    public final <T> d<T> a(i<T> iVar, a<T> aVar, List<? extends c<T>> list, h0 h0Var, d10.a<? extends File> aVar2) {
        return new SingleProcessDataStore(aVar2, iVar, CollectionsKt__CollectionsJVMKt.e(DataMigrationInitializer.f8916a.b(list)), new NoOpCorruptionHandler(), h0Var);
    }
}
