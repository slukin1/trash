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

public final class ClientMetadataOuterClass$ClientMetadata extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientMetadataOuterClass$ClientMetadata DEFAULT_INSTANCE;
    private static volatile Parser<ClientMetadataOuterClass$ClientMetadata> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 1;
    private Struct payload_;

    /* renamed from: com.iproov.sdk.network.model.proto.ClientMetadataOuterClass$ClientMetadata$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Ccase caseR) {
            this();
        }

        private Cdo() {
            super(ClientMetadataOuterClass$ClientMetadata.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientMetadataOuterClass$ClientMetadata clientMetadataOuterClass$ClientMetadata = new ClientMetadataOuterClass$ClientMetadata();
        DEFAULT_INSTANCE = clientMetadataOuterClass$ClientMetadata;
        GeneratedMessageLite.registerDefaultInstance(ClientMetadataOuterClass$ClientMetadata.class, clientMetadataOuterClass$ClientMetadata);
    }

    private ClientMetadataOuterClass$ClientMetadata() {
    }

    /* access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = null;
    }

    public static ClientMetadataOuterClass$ClientMetadata getDefaultInstance() {
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

    public static ClientMetadataOuterClass$ClientMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientMetadataOuterClass$ClientMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setPayload(Struct struct) {
        struct.getClass();
        this.payload_ = struct;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Ccase.f1016do[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientMetadataOuterClass$ClientMetadata();
            case 2:
                return new Cdo((Ccase) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientMetadataOuterClass$ClientMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (ClientMetadataOuterClass$ClientMetadata.class) {
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

    public static Cdo newBuilder(ClientMetadataOuterClass$ClientMetadata clientMetadataOuterClass$ClientMetadata) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(clientMetadataOuterClass$ClientMetadata);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(InputStream inputStream) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientMetadataOuterClass$ClientMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientMetadataOuterClass$ClientMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
