package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.i;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.c;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u001a\u0010\u0019\u001a\u00020\u00118\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/datastore/preferences/core/c;", "Landroidx/datastore/core/i;", "Landroidx/datastore/preferences/core/Preferences;", "Ljava/io/InputStream;", "input", "b", "(Ljava/io/InputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "", "g", "(Landroidx/datastore/preferences/core/Preferences;Ljava/io/OutputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "f", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "fileExtension", "d", "()Landroidx/datastore/preferences/core/Preferences;", "defaultValue", "<init>", "()V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class c implements i<Preferences> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f8970a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final String f8971b = "preferences_pb";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8972a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            iArr[PreferencesProto$Value.ValueCase.BOOLEAN.ordinal()] = 1;
            iArr[PreferencesProto$Value.ValueCase.FLOAT.ordinal()] = 2;
            iArr[PreferencesProto$Value.ValueCase.DOUBLE.ordinal()] = 3;
            iArr[PreferencesProto$Value.ValueCase.INTEGER.ordinal()] = 4;
            iArr[PreferencesProto$Value.ValueCase.LONG.ordinal()] = 5;
            iArr[PreferencesProto$Value.ValueCase.STRING.ordinal()] = 6;
            iArr[PreferencesProto$Value.ValueCase.STRING_SET.ordinal()] = 7;
            iArr[PreferencesProto$Value.ValueCase.VALUE_NOT_SET.ordinal()] = 8;
            f8972a = iArr;
        }
    }

    public Object b(InputStream inputStream, kotlin.coroutines.c<? super Preferences> cVar) throws IOException, CorruptionException {
        androidx.datastore.preferences.c a11 = PreferencesMapCompat.f8960a.a(inputStream);
        MutablePreferences b11 = a.b(new Preferences.b[0]);
        for (Map.Entry next : a11.F().entrySet()) {
            f8970a.c((String) next.getKey(), (PreferencesProto$Value) next.getValue(), b11);
        }
        return b11.d();
    }

    public final void c(String str, PreferencesProto$Value preferencesProto$Value, MutablePreferences mutablePreferences) {
        PreferencesProto$Value.ValueCase S = preferencesProto$Value.S();
        switch (S == null ? -1 : a.f8972a[S.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", (Throwable) null, 2, (r) null);
            case 1:
                mutablePreferences.j(b.a(str), Boolean.valueOf(preferencesProto$Value.K()));
                return;
            case 2:
                mutablePreferences.j(b.c(str), Float.valueOf(preferencesProto$Value.N()));
                return;
            case 3:
                mutablePreferences.j(b.b(str), Double.valueOf(preferencesProto$Value.M()));
                return;
            case 4:
                mutablePreferences.j(b.d(str), Integer.valueOf(preferencesProto$Value.O()));
                return;
            case 5:
                mutablePreferences.j(b.e(str), Long.valueOf(preferencesProto$Value.P()));
                return;
            case 6:
                mutablePreferences.j(b.f(str), preferencesProto$Value.Q());
                return;
            case 7:
                mutablePreferences.j(b.g(str), CollectionsKt___CollectionsKt.N0(preferencesProto$Value.R().H()));
                return;
            case 8:
                throw new CorruptionException("Value not set.", (Throwable) null, 2, (r) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: d */
    public Preferences getDefaultValue() {
        return a.a();
    }

    public final String e() {
        return f8971b;
    }

    public final PreferencesProto$Value f(Object obj) {
        if (obj instanceof Boolean) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().y(((Boolean) obj).booleanValue()).build();
        }
        if (obj instanceof Float) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().A(((Number) obj).floatValue()).build();
        }
        if (obj instanceof Double) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().z(((Number) obj).doubleValue()).build();
        }
        if (obj instanceof Integer) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().B(((Number) obj).intValue()).build();
        }
        if (obj instanceof Long) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().C(((Number) obj).longValue()).build();
        }
        if (obj instanceof String) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().D((String) obj).build();
        }
        if (obj instanceof Set) {
            return (PreferencesProto$Value) PreferencesProto$Value.T().E(d.I().y((Set) obj)).build();
        }
        throw new IllegalStateException(x.i("PreferencesSerializer does not support type: ", obj.getClass().getName()));
    }

    /* renamed from: g */
    public Object a(Preferences preferences, OutputStream outputStream, kotlin.coroutines.c<? super Unit> cVar) throws IOException, CorruptionException {
        Map<Preferences.a<?>, Object> a11 = preferences.a();
        c.a I = androidx.datastore.preferences.c.I();
        for (Map.Entry next : a11.entrySet()) {
            I.y(((Preferences.a) next.getKey()).a(), f(next.getValue()));
        }
        ((androidx.datastore.preferences.c) I.build()).i(outputStream);
        return Unit.f56620a;
    }
}
