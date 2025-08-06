package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public abstract class Message<M extends Message<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    public transient int cachedSerializedSize = 0;
    public transient int hashCode = 0;
    private final transient ByteString unknownFields;

    public static abstract class a<M extends Message<M, B>, B extends a<M, B>> {

        /* renamed from: a  reason: collision with root package name */
        public transient ByteString f30169a = ByteString.EMPTY;

        /* renamed from: b  reason: collision with root package name */
        public transient Buffer f30170b;

        /* renamed from: c  reason: collision with root package name */
        public transient d f30171c;

        public final a<M, B> a(int i11, FieldEncoding fieldEncoding, Object obj) {
            f();
            try {
                fieldEncoding.rawProtoAdapter().k(this.f30171c, i11, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final a<M, B> b(ByteString byteString) {
            if (byteString.size() > 0) {
                f();
                try {
                    this.f30171c.k(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public abstract M c();

        public final ByteString d() {
            Buffer buffer = this.f30170b;
            if (buffer != null) {
                this.f30169a = buffer.readByteString();
                this.f30170b = null;
                this.f30171c = null;
            }
            return this.f30169a;
        }

        public final a<M, B> e() {
            this.f30169a = ByteString.EMPTY;
            Buffer buffer = this.f30170b;
            if (buffer != null) {
                buffer.clear();
                this.f30170b = null;
            }
            this.f30171c = null;
            return this;
        }

        public final void f() {
            if (this.f30170b == null) {
                Buffer buffer = new Buffer();
                this.f30170b = buffer;
                d dVar = new d(buffer);
                this.f30171c = dVar;
                try {
                    dVar.k(this.f30169a);
                    this.f30169a = ByteString.EMPTY;
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
        }
    }

    public Message(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        Objects.requireNonNull(protoAdapter, "adapter == null");
        Objects.requireNonNull(byteString, "unknownFields == null");
        this.adapter = protoAdapter;
        this.unknownFields = byteString;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(BufferedSink bufferedSink) throws IOException {
        this.adapter.i(bufferedSink, this);
    }

    public abstract a<M, B> newBuilder();

    public String toString() {
        return this.adapter.q(this);
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final M withoutUnknownFields() {
        return newBuilder().e().c();
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final byte[] encode() {
        return this.adapter.j(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        this.adapter.h(outputStream, this);
    }
}
