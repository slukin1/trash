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

public final class EdgeResultOuterClass$EdgeResult extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final EdgeResultOuterClass$EdgeResult DEFAULT_INSTANCE;
    private static volatile Parser<EdgeResultOuterClass$EdgeResult> PARSER = null;
    public static final int PASSED_FIELD_NUMBER = 1;
    public static final int USER_FEEDBACK_CODE_FIELD_NUMBER = 2;
    private boolean passed_;
    private String userFeedbackCode_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.EdgeResultOuterClass$EdgeResult$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cfinal finalR) {
            this();
        }

        private Cdo() {
            super(EdgeResultOuterClass$EdgeResult.DEFAULT_INSTANCE);
        }
    }

    static {
        EdgeResultOuterClass$EdgeResult edgeResultOuterClass$EdgeResult = new EdgeResultOuterClass$EdgeResult();
        DEFAULT_INSTANCE = edgeResultOuterClass$EdgeResult;
        GeneratedMessageLite.registerDefaultInstance(EdgeResultOuterClass$EdgeResult.class, edgeResultOuterClass$EdgeResult);
    }

    private EdgeResultOuterClass$EdgeResult() {
    }

    /* access modifiers changed from: private */
    public void clearPassed() {
        this.passed_ = false;
    }

    /* access modifiers changed from: private */
    public void clearUserFeedbackCode() {
        this.userFeedbackCode_ = getDefaultInstance().getUserFeedbackCode();
    }

    public static EdgeResultOuterClass$EdgeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static EdgeResultOuterClass$EdgeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EdgeResultOuterClass$EdgeResult> parser() {
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
        switch (Cfinal.f1022do[methodToInvoke.ordinal()]) {
            case 1:
                return new EdgeResultOuterClass$EdgeResult();
            case 2:
                return new Cdo((Cfinal) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"passed_", "userFeedbackCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EdgeResultOuterClass$EdgeResult> parser = PARSER;
                if (parser == null) {
                    synchronized (EdgeResultOuterClass$EdgeResult.class) {
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

    public static Cdo newBuilder(EdgeResultOuterClass$EdgeResult edgeResultOuterClass$EdgeResult) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(edgeResultOuterClass$EdgeResult);
    }

    public static EdgeResultOuterClass$EdgeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(InputStream inputStream) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EdgeResultOuterClass$EdgeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeResultOuterClass$EdgeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
