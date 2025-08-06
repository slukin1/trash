package com.iproov.sdk.network.model.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ClientAbortOuterClass$ClientAbort extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientAbortOuterClass$ClientAbort DEFAULT_INSTANCE;
    public static final int INTERNAL_CODE_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAbortOuterClass$ClientAbort> PARSER;
    private String internalCode_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.ClientAbortOuterClass$ClientAbort$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cif ifVar) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1162do(String str) {
            copyOnWrite();
            ((ClientAbortOuterClass$ClientAbort) this.instance).setInternalCode(str);
            return this;
        }

        private Cdo() {
            super(ClientAbortOuterClass$ClientAbort.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientAbortOuterClass$ClientAbort clientAbortOuterClass$ClientAbort = new ClientAbortOuterClass$ClientAbort();
        DEFAULT_INSTANCE = clientAbortOuterClass$ClientAbort;
        GeneratedMessageLite.registerDefaultInstance(ClientAbortOuterClass$ClientAbort.class, clientAbortOuterClass$ClientAbort);
    }

    private ClientAbortOuterClass$ClientAbort() {
    }

    /* access modifiers changed from: private */
    public void clearInternalCode() {
        this.internalCode_ = getDefaultInstance().getInternalCode();
    }

    public static ClientAbortOuterClass$ClientAbort getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClientAbortOuterClass$ClientAbort parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientAbortOuterClass$ClientAbort> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setInternalCode(String str) {
        str.getClass();
        this.internalCode_ = str;
    }

    /* access modifiers changed from: private */
    public void setInternalCodeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.internalCode_ = byteString.toStringUtf8();
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cif.f1025do[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientAbortOuterClass$ClientAbort();
            case 2:
                return new Cdo((Cif) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"internalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientAbortOuterClass$ClientAbort> parser = PARSER;
                if (parser == null) {
                    synchronized (ClientAbortOuterClass$ClientAbort.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getInternalCode() {
        return this.internalCode_;
    }

    public ByteString getInternalCodeBytes() {
        return ByteString.copyFromUtf8(this.internalCode_);
    }

    public static Cdo newBuilder(ClientAbortOuterClass$ClientAbort clientAbortOuterClass$ClientAbort) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(clientAbortOuterClass$ClientAbort);
    }

    public static ClientAbortOuterClass$ClientAbort parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(InputStream inputStream) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientAbortOuterClass$ClientAbort parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAbortOuterClass$ClientAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
