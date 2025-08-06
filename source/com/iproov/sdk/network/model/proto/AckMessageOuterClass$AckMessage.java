package com.iproov.sdk.network.model.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AckMessageOuterClass$AckMessage extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final AckMessageOuterClass$AckMessage DEFAULT_INSTANCE;
    private static volatile Parser<AckMessageOuterClass$AckMessage> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    public static final int SEQUENCE_RESPONSE_FIELD_NUMBER = 1;
    private Value payload_;
    private int sequenceResponse_;

    /* renamed from: com.iproov.sdk.network.model.proto.AckMessageOuterClass$AckMessage$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cdo doVar) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1160do(int i11) {
            copyOnWrite();
            ((AckMessageOuterClass$AckMessage) this.instance).setSequenceResponse(i11);
            return this;
        }

        private Cdo() {
            super(AckMessageOuterClass$AckMessage.DEFAULT_INSTANCE);
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1161do(Value value) {
            copyOnWrite();
            ((AckMessageOuterClass$AckMessage) this.instance).setPayload(value);
            return this;
        }
    }

    static {
        AckMessageOuterClass$AckMessage ackMessageOuterClass$AckMessage = new AckMessageOuterClass$AckMessage();
        DEFAULT_INSTANCE = ackMessageOuterClass$AckMessage;
        GeneratedMessageLite.registerDefaultInstance(AckMessageOuterClass$AckMessage.class, ackMessageOuterClass$AckMessage);
    }

    private AckMessageOuterClass$AckMessage() {
    }

    /* access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = null;
    }

    /* access modifiers changed from: private */
    public void clearSequenceResponse() {
        this.sequenceResponse_ = 0;
    }

    public static AckMessageOuterClass$AckMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergePayload(Value value) {
        value.getClass();
        Value value2 = this.payload_;
        if (value2 == null || value2 == Value.getDefaultInstance()) {
            this.payload_ = value;
        } else {
            this.payload_ = (Value) ((Value.Builder) Value.newBuilder(this.payload_).mergeFrom(value)).buildPartial();
        }
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static AckMessageOuterClass$AckMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AckMessageOuterClass$AckMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setPayload(Value value) {
        value.getClass();
        this.payload_ = value;
    }

    /* access modifiers changed from: private */
    public void setSequenceResponse(int i11) {
        this.sequenceResponse_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cdo.f1020do[methodToInvoke.ordinal()]) {
            case 1:
                return new AckMessageOuterClass$AckMessage();
            case 2:
                return new Cdo((Cdo) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"sequenceResponse_", "payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AckMessageOuterClass$AckMessage> parser = PARSER;
                if (parser == null) {
                    synchronized (AckMessageOuterClass$AckMessage.class) {
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

    public Value getPayload() {
        Value value = this.payload_;
        return value == null ? Value.getDefaultInstance() : value;
    }

    public int getSequenceResponse() {
        return this.sequenceResponse_;
    }

    public boolean hasPayload() {
        return this.payload_ != null;
    }

    public static Cdo newBuilder(AckMessageOuterClass$AckMessage ackMessageOuterClass$AckMessage) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(ackMessageOuterClass$AckMessage);
    }

    public static AckMessageOuterClass$AckMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(InputStream inputStream) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AckMessageOuterClass$AckMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AckMessageOuterClass$AckMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
