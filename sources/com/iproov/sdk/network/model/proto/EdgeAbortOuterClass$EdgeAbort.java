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

public final class EdgeAbortOuterClass$EdgeAbort extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final EdgeAbortOuterClass$EdgeAbort DEFAULT_INSTANCE;
    public static final int INTERNAL_CODE_FIELD_NUMBER = 1;
    private static volatile Parser<EdgeAbortOuterClass$EdgeAbort> PARSER;
    private String internalCode_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.EdgeAbortOuterClass$EdgeAbort$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cclass classR) {
            this();
        }

        private Cdo() {
            super(EdgeAbortOuterClass$EdgeAbort.DEFAULT_INSTANCE);
        }
    }

    static {
        EdgeAbortOuterClass$EdgeAbort edgeAbortOuterClass$EdgeAbort = new EdgeAbortOuterClass$EdgeAbort();
        DEFAULT_INSTANCE = edgeAbortOuterClass$EdgeAbort;
        GeneratedMessageLite.registerDefaultInstance(EdgeAbortOuterClass$EdgeAbort.class, edgeAbortOuterClass$EdgeAbort);
    }

    private EdgeAbortOuterClass$EdgeAbort() {
    }

    /* access modifiers changed from: private */
    public void clearInternalCode() {
        this.internalCode_ = getDefaultInstance().getInternalCode();
    }

    public static EdgeAbortOuterClass$EdgeAbort getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static EdgeAbortOuterClass$EdgeAbort parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EdgeAbortOuterClass$EdgeAbort> parser() {
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
        switch (Cclass.f1018do[methodToInvoke.ordinal()]) {
            case 1:
                return new EdgeAbortOuterClass$EdgeAbort();
            case 2:
                return new Cdo((Cclass) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"internalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EdgeAbortOuterClass$EdgeAbort> parser = PARSER;
                if (parser == null) {
                    synchronized (EdgeAbortOuterClass$EdgeAbort.class) {
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

    public static Cdo newBuilder(EdgeAbortOuterClass$EdgeAbort edgeAbortOuterClass$EdgeAbort) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(edgeAbortOuterClass$EdgeAbort);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(InputStream inputStream) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EdgeAbortOuterClass$EdgeAbort parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeAbortOuterClass$EdgeAbort) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
