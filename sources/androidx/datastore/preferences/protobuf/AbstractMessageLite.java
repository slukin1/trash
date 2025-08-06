package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.f0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements f0 {
    public int memoizedHashCode = 0;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements f0.a {
        public static <T> void c(Iterable<T> iterable, List<? super T> list) {
            u.a(iterable);
            if (iterable instanceof w) {
                List<?> underlyingElements = ((w) iterable).getUnderlyingElements();
                w wVar = (w) list;
                int size = list.size();
                for (Object next : underlyingElements) {
                    if (next == null) {
                        String str = "Element at index " + (wVar.size() - size) + " is null.";
                        for (int size2 = wVar.size() - 1; size2 >= size; size2--) {
                            wVar.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        wVar.f((ByteString) next);
                    } else {
                        wVar.add((String) next);
                    }
                }
            } else if (iterable instanceof o0) {
                list.addAll((Collection) iterable);
            } else {
                d(iterable, list);
            }
        }

        public static <T> void d(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        public static UninitializedMessageException m(f0 f0Var) {
            return new UninitializedMessageException(f0Var);
        }

        /* renamed from: e */
        public abstract BuilderType clone();

        public final String f(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public abstract BuilderType g(MessageType messagetype);

        public BuilderType h(g gVar) throws IOException {
            return i(gVar, l.b());
        }

        public abstract BuilderType i(g gVar, l lVar) throws IOException;

        /* renamed from: j */
        public BuilderType a(f0 f0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(f0Var)) {
                return g((AbstractMessageLite) f0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        /* renamed from: k */
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return l(bArr, 0, bArr.length);
        }

        public BuilderType l(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            try {
                g j11 = g.j(bArr, i11, i12);
                h(j11);
                j11.a(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(f("byte array"), e12);
            }
        }
    }

    public static <T> void c(Iterable<T> iterable, List<? super T> list) {
        Builder.c(iterable, list);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    public int e(t0 t0Var) {
        int d11 = d();
        if (d11 != -1) {
            return d11;
        }
        int serializedSize = t0Var.getSerializedSize(this);
        h(serializedSize);
        return serializedSize;
    }

    public final String f(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException g() {
        return new UninitializedMessageException((f0) this);
    }

    /* access modifiers changed from: package-private */
    public void h(int i11) {
        throw new UnsupportedOperationException();
    }

    public void i(OutputStream outputStream) throws IOException {
        CodedOutputStream g02 = CodedOutputStream.g0(outputStream, CodedOutputStream.J(getSerializedSize()));
        b(g02);
        g02.d0();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream h02 = CodedOutputStream.h0(bArr);
            b(h02);
            h02.d();
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException(f("byte array"), e11);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.g newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            b(newCodedBuilder.b());
            return newCodedBuilder.a();
        } catch (IOException e11) {
            throw new RuntimeException(f("ByteString"), e11);
        }
    }
}
