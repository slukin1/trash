package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CheckReturnValue
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int i11 = 0;
        for (Schema schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                i11 += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return i11;
    }

    public <T> boolean isInitialized(T t11) {
        return schemaFor(t11).isInitialized(t11);
    }

    public <T> void makeImmutable(T t11) {
        schemaFor(t11).makeImmutable(t11);
    }

    public <T> void mergeFrom(T t11, Reader reader) throws IOException {
        mergeFrom(t11, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return (Schema) this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = (Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> createSchema = this.schemaFactory.createSchema(cls);
        Schema<?> registerSchema = registerSchema(cls, createSchema);
        return registerSchema != null ? registerSchema : createSchema;
    }

    public <T> void writeTo(T t11, Writer writer) throws IOException {
        schemaFor(t11).writeTo(t11, writer);
    }

    public <T> void mergeFrom(T t11, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        schemaFor(t11).mergeFrom(t11, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t11) {
        return schemaFor(t11.getClass());
    }
}
