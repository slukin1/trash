package com.squareup.wire;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire.Message;
import com.squareup.wire.Message.a;
import java.io.IOException;
import java.lang.reflect.Array;
import okio.ByteString;

public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.a<M, B>> extends Message<M, B> implements Parcelable {

    public static final class a<M> implements Parcelable.Creator<M> {

        /* renamed from: a  reason: collision with root package name */
        public final ProtoAdapter<M> f30167a;

        public a(ProtoAdapter<M> protoAdapter) {
            this.f30167a = protoAdapter;
        }

        public M createFromParcel(Parcel parcel) {
            try {
                return this.f30167a.f(parcel.createByteArray());
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public M[] newArray(int i11) {
            return (Object[]) Array.newInstance(this.f30167a.f30188b, i11);
        }
    }

    public AndroidMessage(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        super(protoAdapter, byteString);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return new a(protoAdapter);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByteArray(encode());
    }
}
