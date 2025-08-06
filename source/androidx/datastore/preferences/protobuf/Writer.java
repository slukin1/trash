package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.z;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    void a(int i11, ByteString byteString) throws IOException;

    void b(int i11, Object obj, t0 t0Var) throws IOException;

    <K, V> void c(int i11, z.a<K, V> aVar, Map<K, V> map) throws IOException;

    @Deprecated
    void d(int i11, List<?> list, t0 t0Var) throws IOException;

    @Deprecated
    void e(int i11, Object obj, t0 t0Var) throws IOException;

    void f(int i11, List<?> list, t0 t0Var) throws IOException;

    FieldOrder fieldOrder();

    void writeBool(int i11, boolean z11) throws IOException;

    void writeBoolList(int i11, List<Boolean> list, boolean z11) throws IOException;

    void writeBytesList(int i11, List<ByteString> list) throws IOException;

    void writeDouble(int i11, double d11) throws IOException;

    void writeDoubleList(int i11, List<Double> list, boolean z11) throws IOException;

    @Deprecated
    void writeEndGroup(int i11) throws IOException;

    void writeEnum(int i11, int i12) throws IOException;

    void writeEnumList(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeFixed32(int i11, int i12) throws IOException;

    void writeFixed32List(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeFixed64(int i11, long j11) throws IOException;

    void writeFixed64List(int i11, List<Long> list, boolean z11) throws IOException;

    void writeFloat(int i11, float f11) throws IOException;

    void writeFloatList(int i11, List<Float> list, boolean z11) throws IOException;

    void writeInt32(int i11, int i12) throws IOException;

    void writeInt32List(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeInt64(int i11, long j11) throws IOException;

    void writeInt64List(int i11, List<Long> list, boolean z11) throws IOException;

    void writeMessageSetItem(int i11, Object obj) throws IOException;

    void writeSFixed32(int i11, int i12) throws IOException;

    void writeSFixed32List(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeSFixed64(int i11, long j11) throws IOException;

    void writeSFixed64List(int i11, List<Long> list, boolean z11) throws IOException;

    void writeSInt32(int i11, int i12) throws IOException;

    void writeSInt32List(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeSInt64(int i11, long j11) throws IOException;

    void writeSInt64List(int i11, List<Long> list, boolean z11) throws IOException;

    @Deprecated
    void writeStartGroup(int i11) throws IOException;

    void writeString(int i11, String str) throws IOException;

    void writeStringList(int i11, List<String> list) throws IOException;

    void writeUInt32(int i11, int i12) throws IOException;

    void writeUInt32List(int i11, List<Integer> list, boolean z11) throws IOException;

    void writeUInt64(int i11, long j11) throws IOException;

    void writeUInt64List(int i11, List<Long> list, boolean z11) throws IOException;
}
