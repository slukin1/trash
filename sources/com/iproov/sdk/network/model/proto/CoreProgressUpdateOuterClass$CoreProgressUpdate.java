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

public final class CoreProgressUpdateOuterClass$CoreProgressUpdate extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final CoreProgressUpdateOuterClass$CoreProgressUpdate DEFAULT_INSTANCE;
    private static volatile Parser<CoreProgressUpdateOuterClass$CoreProgressUpdate> PARSER = null;
    public static final int PROGRESS_PERCENT_FIELD_NUMBER = 1;
    private int progressPercent_;

    /* renamed from: com.iproov.sdk.network.model.proto.CoreProgressUpdateOuterClass$CoreProgressUpdate$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cbreak breakR) {
            this();
        }

        private Cdo() {
            super(CoreProgressUpdateOuterClass$CoreProgressUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        CoreProgressUpdateOuterClass$CoreProgressUpdate coreProgressUpdateOuterClass$CoreProgressUpdate = new CoreProgressUpdateOuterClass$CoreProgressUpdate();
        DEFAULT_INSTANCE = coreProgressUpdateOuterClass$CoreProgressUpdate;
        GeneratedMessageLite.registerDefaultInstance(CoreProgressUpdateOuterClass$CoreProgressUpdate.class, coreProgressUpdateOuterClass$CoreProgressUpdate);
    }

    private CoreProgressUpdateOuterClass$CoreProgressUpdate() {
    }

    /* access modifiers changed from: private */
    public void clearProgressPercent() {
        this.progressPercent_ = 0;
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CoreProgressUpdateOuterClass$CoreProgressUpdate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setProgressPercent(int i11) {
        this.progressPercent_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cbreak.f1015do[methodToInvoke.ordinal()]) {
            case 1:
                return new CoreProgressUpdateOuterClass$CoreProgressUpdate();
            case 2:
                return new Cdo((Cbreak) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"progressPercent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CoreProgressUpdateOuterClass$CoreProgressUpdate> parser = PARSER;
                if (parser == null) {
                    synchronized (CoreProgressUpdateOuterClass$CoreProgressUpdate.class) {
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

    public static Cdo newBuilder(CoreProgressUpdateOuterClass$CoreProgressUpdate coreProgressUpdateOuterClass$CoreProgressUpdate) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(coreProgressUpdateOuterClass$CoreProgressUpdate);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(InputStream inputStream) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CoreProgressUpdateOuterClass$CoreProgressUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreProgressUpdateOuterClass$CoreProgressUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
