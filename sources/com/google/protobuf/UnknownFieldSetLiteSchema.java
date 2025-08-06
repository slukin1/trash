package com.google.protobuf;

import java.io.IOException;

@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    public void makeImmutable(Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    public boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    public void addFixed32(UnknownFieldSetLite unknownFieldSetLite, int i11, int i12) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i11, 5), Integer.valueOf(i12));
    }

    public void addFixed64(UnknownFieldSetLite unknownFieldSetLite, int i11, long j11) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i11, 1), Long.valueOf(j11));
    }

    public void addGroup(UnknownFieldSetLite unknownFieldSetLite, int i11, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i11, 3), unknownFieldSetLite2);
    }

    public void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int i11, ByteString byteString) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i11, 2), byteString);
    }

    public void addVarint(UnknownFieldSetLite unknownFieldSetLite, int i11, long j11) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i11, 0), Long.valueOf(j11));
    }

    public UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        UnknownFieldSetLite fromMessage = getFromMessage(obj);
        if (fromMessage != UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        setToMessage(obj, newInstance);
        return newInstance;
    }

    public UnknownFieldSetLite getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    public int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    public UnknownFieldSetLite merge(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite2)) {
            return unknownFieldSetLite;
        }
        if (UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite)) {
            return UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2);
        }
        return unknownFieldSetLite.mergeFrom(unknownFieldSetLite2);
    }

    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    public void setBuilderToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        setToMessage(obj, unknownFieldSetLite);
    }

    public void setToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    public void writeAsMessageSetTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeAsMessageSetTo(writer);
    }

    public void writeTo(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeTo(writer);
    }
}
