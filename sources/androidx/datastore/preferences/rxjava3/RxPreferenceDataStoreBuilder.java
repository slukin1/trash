package androidx.datastore.preferences.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.core.c;
import androidx.datastore.core.d;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.rxjava3.RxDataStore;
import io.reactivex.rxjava3.core.Scheduler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.rx3.RxSchedulerKt;
import p00.a;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "", "Landroidx/datastore/rxjava3/RxDataStore;", "Landroidx/datastore/preferences/core/Preferences;", "a", "Ljava/util/concurrent/Callable;", "Ljava/io/File;", "Ljava/util/concurrent/Callable;", "produceFile", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "", "c", "Ljava/lang/String;", "name", "Lio/reactivex/rxjava3/core/Scheduler;", "d", "Lio/reactivex/rxjava3/core/Scheduler;", "ioScheduler", "", "Landroidx/datastore/core/c;", "f", "Ljava/util/List;", "dataMigrations", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "datastore-preferences-rxjava3_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"TopLevelBuilder"})
public final class RxPreferenceDataStoreBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Callable<File> f9266a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9267b;

    /* renamed from: c  reason: collision with root package name */
    public String f9268c;

    /* renamed from: d  reason: collision with root package name */
    public Scheduler f9269d = a.a();

    /* renamed from: e  reason: collision with root package name */
    public h1.a<Preferences> f9270e;

    /* renamed from: f  reason: collision with root package name */
    public final List<c<Preferences>> f9271f = new ArrayList();

    public RxPreferenceDataStoreBuilder(Context context, String str) {
        this.f9267b = context;
        this.f9268c = str;
    }

    public final RxDataStore<Preferences> a() {
        d<Preferences> dVar;
        h0 a11 = i0.a(RxSchedulerKt.d(this.f9269d).plus(r1.b((n1) null, 1, (Object) null)));
        Callable<File> callable = this.f9266a;
        Context context = this.f9267b;
        String str = this.f9268c;
        if (callable != null) {
            dVar = PreferenceDataStoreFactory.f8966a.a(this.f9270e, this.f9271f, a11, new RxPreferenceDataStoreBuilder$build$delegate$1(callable));
        } else if (context == null || str == null) {
            throw new IllegalStateException("Either produceFile or context and name must be set. This should never happen.".toString());
        } else {
            dVar = PreferenceDataStoreFactory.f8966a.a(this.f9270e, this.f9271f, a11, new RxPreferenceDataStoreBuilder$build$delegate$2(context, str));
        }
        return RxDataStore.f9272d.a(dVar, a11);
    }
}
