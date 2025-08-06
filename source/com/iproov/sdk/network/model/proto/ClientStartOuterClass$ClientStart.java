package com.iproov.sdk.network.model.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ClientStartOuterClass$ClientStart extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientStartOuterClass$ClientStart DEFAULT_INSTANCE;
    private static volatile Parser<ClientStartOuterClass$ClientStart> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 1;
    private Struct payload_;

    /* renamed from: com.iproov.sdk.network.model.proto.ClientStartOuterClass$ClientStart$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Celse elseR) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1164do(Struct struct) {
            copyOnWrite();
            ((ClientStartOuterClass$ClientStart) this.instance).setPayload(struct);
            return this;
        }

        private Cdo() {
            super(ClientStartOuterClass$ClientStart.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientStartOuterClass$ClientStart clientStartOuterClass$ClientStart = new ClientStartOuterClass$ClientStart();
        DEFAULT_INSTANCE = clientStartOuterClass$ClientStart;
        GeneratedMessageLite.registerDefaultInstance(ClientStartOuterClass$ClientStart.class, clientStartOuterClass$ClientStart);
    }

    private ClientStartOuterClass$ClientStart() {
    }

    /* access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = null;
    }

    public static ClientStartOuterClass$ClientStart getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergePayload(Struct struct) {
        struct.getClass();
        Struct struct2 = this.payload_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.payload_ = struct;
        } else {
            this.payload_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.payload_).mergeFrom(struct)).buildPartial();
        }
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClientStartOuterClass$ClientStart parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientStartOuterClass$ClientStart> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setPayload(Struct struct) {
        struct.getClass();
        this.payload_ = struct;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Celse.f1021do[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientStartOuterClass$ClientStart();
            case 2:
                return new Cdo((Celse) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientStartOuterClass$ClientStart> parser = PARSER;
                if (parser == null) {
                    synchronized (ClientStartOuterClass$ClientStart.class) {
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

    public Struct getPayload() {
        Struct struct = this.payload_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    public boolean hasPayload() {
        return this.payload_ != null;
    }

    public static Cdo newBuilder(ClientStartOuterClass$ClientStart clientStartOuterClass$ClientStart) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(clientStartOuterClass$ClientStart);
    }

    public static ClientStartOuterClass$ClientStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(InputStream inputStream) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientStartOuterClass$ClientStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientStartOuterClass$ClientStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
