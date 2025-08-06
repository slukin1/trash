package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    public static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static class ExtensionClassHolder {
        public static final Class<?> INSTANCE = resolveExtensionClass();

        private ExtensionClassHolder() {
        }

        public static Class<?> resolveExtensionClass() {
            try {
                return Class.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public ObjectIntPair(Object obj, int i11) {
            this.object = obj;
            this.number = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.object == objectIntPair.object && this.number == objectIntPair.number) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    if (doFullRuntimeInheritanceCheck) {
                        extensionRegistryLite = ExtensionRegistryFactory.createEmpty();
                    } else {
                        extensionRegistryLite = EMPTY_REGISTRY_LITE;
                    }
                    emptyRegistry = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static ExtensionRegistryLite newInstance() {
        if (doFullRuntimeInheritanceCheck) {
            return ExtensionRegistryFactory.create();
        }
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z11) {
        eagerlyParseMessageSets = z11;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i11) {
        return this.extensionsByNumber.get(new ObjectIntPair(containingtype, i11));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY_REGISTRY_LITE) {
            this.extensionsByNumber = Collections.emptyMap();
        } else {
            this.extensionsByNumber = Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension<?, ?>) (GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (doFullRuntimeInheritanceCheck && ExtensionRegistryFactory.isFullRegistry(this)) {
            try {
                getClass().getMethod("add", new Class[]{ExtensionClassHolder.INSTANCE}).invoke(this, new Object[]{extensionLite});
            } catch (Exception e11) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{extensionLite}), e11);
            }
        }
    }

    public ExtensionRegistryLite(boolean z11) {
        this.extensionsByNumber = Collections.emptyMap();
    }
}
