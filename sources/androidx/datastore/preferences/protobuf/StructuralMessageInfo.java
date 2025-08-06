package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.List;

public final class StructuralMessageInfo implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final ProtoSyntax f9042a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9043b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f9044c;

    /* renamed from: d  reason: collision with root package name */
    public final p[] f9045d;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f9046e;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final List<p> f9047a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public int[] f9048b = null;
    }

    public int[] a() {
        return this.f9044c;
    }

    public p[] b() {
        return this.f9045d;
    }

    public f0 getDefaultInstance() {
        return this.f9046e;
    }

    public ProtoSyntax getSyntax() {
        return this.f9042a;
    }

    public boolean isMessageSetWireFormat() {
        return this.f9043b;
    }
}
