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

public final class CoreResultOuterClass$CoreResult extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final CoreResultOuterClass$CoreResult DEFAULT_INSTANCE;
    private static volatile Parser<CoreResultOuterClass$CoreResult> PARSER = null;
    public static final int PASSED_FIELD_NUMBER = 1;
    public static final int USER_FEEDBACK_CODE_FIELD_NUMBER = 2;
    private boolean passed_;
    private String userFeedbackCode_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.CoreResultOuterClass$CoreResult$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Ccatch catchR) {
            this();
        }

        private Cdo() {
            super(CoreResultOuterClass$CoreResult.DEFAULT_INSTANCE);
        }
    }

    static {
        CoreResultOuterClass$CoreResult coreResultOuterClass$CoreResult = new CoreResultOuterClass$CoreResult();
        DEFAULT_INSTANCE = coreResultOuterClass$CoreResult;
        GeneratedMessageLite.registerDefaultInstance(CoreResultOuterClass$CoreResult.class, coreResultOuterClass$CoreResult);
    }

    private CoreResultOuterClass$CoreResult() {
    }

    /* access modifiers changed from: private */
    public void clearPassed() {
        this.passed_ = false;
    }

    /* access modifiers changed from: private */
    public void clearUserFeedbackCode() {
        this.userFeedbackCode_ = getDefaultInstance().getUserFeedbackCode();
    }

    public static CoreResultOuterClass$CoreResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static CoreResultOuterClass$CoreResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CoreResultOuterClass$CoreResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setPassed(boolean z11) {
        this.passed_ = z11;
    }

    /* access modifiers changed from: private */
    public void setUserFeedbackCode(String str) {
        str.getClass();
        this.userFeedbackCode_ = str;
    }

    /* access modifiers changed from: private */
    public void setUserFeedbackCodeBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.userFeedbackCode_ = byteString.toStringUtf8();
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Ccatch.f1017do[methodToInvoke.ordinal()]) {
            case 1:
                return new CoreResultOuterClass$CoreResult();
            case 2:
                return new Cdo((Ccatch) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"passed_", "userFeedbackCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CoreResultOuterClass$CoreResult> parser = PARSER;
                if (parser == null) {
                    synchronized (CoreResultOuterClass$CoreResult.class) {
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

    public boolean getPassed() {
        return this.passed_;
    }

    public String getUserFeedbackCode() {
        return this.userFeedbackCode_;
    }

    public ByteString getUserFeedbackCodeBytes() {
        return ByteString.copyFromUtf8(this.userFeedbackCode_);
    }

    public static Cdo newBuilder(CoreResultOuterClass$CoreResult coreResultOuterClass$CoreResult) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(coreResultOuterClass$CoreResult);
    }

    public static CoreResultOuterClass$CoreResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(InputStream inputStream) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CoreResultOuterClass$CoreResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CoreResultOuterClass$CoreResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
