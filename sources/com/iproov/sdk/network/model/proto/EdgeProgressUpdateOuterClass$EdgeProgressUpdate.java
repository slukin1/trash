package com.iproov.sdk.network.model.proto;

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

public final class EdgeProgressUpdateOuterClass$EdgeProgressUpdate extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final EdgeProgressUpdateOuterClass$EdgeProgressUpdate DEFAULT_INSTANCE;
    private static volatile Parser<EdgeProgressUpdateOuterClass$EdgeProgressUpdate> PARSER = null;
    public static final int PROGRESS_PERCENT_FIELD_NUMBER = 1;
    private int progressPercent_;

    /* renamed from: com.iproov.sdk.network.model.proto.EdgeProgressUpdateOuterClass$EdgeProgressUpdate$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cconst constR) {
            this();
        }

        private Cdo() {
            super(EdgeProgressUpdateOuterClass$EdgeProgressUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        EdgeProgressUpdateOuterClass$EdgeProgressUpdate edgeProgressUpdateOuterClass$EdgeProgressUpdate = new EdgeProgressUpdateOuterClass$EdgeProgressUpdate();
        DEFAULT_INSTANCE = edgeProgressUpdateOuterClass$EdgeProgressUpdate;
        GeneratedMessageLite.registerDefaultInstance(EdgeProgressUpdateOuterClass$EdgeProgressUpdate.class, edgeProgressUpdateOuterClass$EdgeProgressUpdate);
    }

    private EdgeProgressUpdateOuterClass$EdgeProgressUpdate() {
    }

    /* access modifiers changed from: private */
    public void clearProgressPercent() {
        this.progressPercent_ = 0;
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EdgeProgressUpdateOuterClass$EdgeProgressUpdate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setProgressPercent(int i11) {
        this.progressPercent_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cconst.f1019do[methodToInvoke.ordinal()]) {
            case 1:
                return new EdgeProgressUpdateOuterClass$EdgeProgressUpdate();
            case 2:
                return new Cdo((Cconst) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"progressPercent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EdgeProgressUpdateOuterClass$EdgeProgressUpdate> parser = PARSER;
                if (parser == null) {
                    synchronized (EdgeProgressUpdateOuterClass$EdgeProgressUpdate.class) {
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

    public int getProgressPercent() {
        return this.progressPercent_;
    }

    public static Cdo newBuilder(EdgeProgressUpdateOuterClass$EdgeProgressUpdate edgeProgressUpdateOuterClass$EdgeProgressUpdate) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(edgeProgressUpdateOuterClass$EdgeProgressUpdate);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(InputStream inputStream) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EdgeProgressUpdateOuterClass$EdgeProgressUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeProgressUpdateOuterClass$EdgeProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
