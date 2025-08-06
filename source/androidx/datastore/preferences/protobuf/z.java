package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;

public class z<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f9253a;

    /* renamed from: b  reason: collision with root package name */
    public final K f9254b;

    /* renamed from: c  reason: collision with root package name */
    public final V f9255c;

    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f9256a;

        /* renamed from: b  reason: collision with root package name */
        public final K f9257b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f9258c;

        /* renamed from: d  reason: collision with root package name */
        public final V f9259d;

        public a(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
            this.f9256a = fieldType;
            this.f9257b = k11;
            this.f9258c = fieldType2;
            this.f9259d = v11;
        }
    }

    public z(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        this.f9253a = new a<>(fieldType, k11, fieldType2, v11);
        this.f9254b = k11;
        this.f9255c = v11;
    }

    public static <K, V> int b(a<K, V> aVar, K k11, V v11) {
        return q.d(aVar.f9256a, 1, k11) + q.d(aVar.f9258c, 2, v11);
    }

    public static <K, V> z<K, V> d(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        return new z<>(fieldType, k11, fieldType2, v11);
    }

    public static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k11, V v11) throws IOException {
        q.z(codedOutputStream, aVar.f9256a, 1, k11);
        q.z(codedOutputStream, aVar.f9258c, 2, v11);
    }

    public int a(int i11, K k11, V v11) {
        return CodedOutputStream.W(i11) + CodedOutputStream.D(b(this.f9253a, k11, v11));
    }

    public a<K, V> c() {
        return this.f9253a;
    }
}
