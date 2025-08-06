package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.d;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import d10.l;
import h1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.properties.c;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BI\b\u0000\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017\u0012\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\u001a0\u0019\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/datastore/preferences/PreferenceDataStoreSingletonDelegate;", "Lkotlin/properties/c;", "Landroid/content/Context;", "Landroidx/datastore/core/d;", "Landroidx/datastore/preferences/core/Preferences;", "thisRef", "Lkotlin/reflect/l;", "property", "d", "", "a", "Ljava/lang/String;", "name", "Lkotlinx/coroutines/h0;", "Lkotlinx/coroutines/h0;", "scope", "", "e", "Ljava/lang/Object;", "lock", "f", "Landroidx/datastore/core/d;", "INSTANCE", "Lh1/a;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/c;", "produceMigrations", "<init>", "(Ljava/lang/String;Lh1/a;Ld10/l;Lkotlinx/coroutines/h0;)V", "datastore-preferences_release"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreSingletonDelegate implements c<Context, d<Preferences>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f8954a;

    /* renamed from: b  reason: collision with root package name */
    public final a<Preferences> f8955b;

    /* renamed from: c  reason: collision with root package name */
    public final l<Context, List<androidx.datastore.core.c<Preferences>>> f8956c;

    /* renamed from: d  reason: collision with root package name */
    public final h0 f8957d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f8958e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public volatile d<Preferences> f8959f;

    public PreferenceDataStoreSingletonDelegate(String str, a<Preferences> aVar, l<? super Context, ? extends List<? extends androidx.datastore.core.c<Preferences>>> lVar, h0 h0Var) {
        this.f8954a = str;
        this.f8956c = lVar;
        this.f8957d = h0Var;
    }

    /* renamed from: d */
    public d<Preferences> a(Context context, kotlin.reflect.l<?> lVar) {
        d<Preferences> dVar;
        d<Preferences> dVar2 = this.f8959f;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.f8958e) {
            if (this.f8959f == null) {
                Context applicationContext = context.getApplicationContext();
                this.f8959f = PreferenceDataStoreFactory.f8966a.a(this.f8955b, this.f8956c.invoke(applicationContext), this.f8957d, new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
            }
            dVar = this.f8959f;
        }
        return dVar;
    }
}
