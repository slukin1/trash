package org.bouncycastle.oer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;

public class OERDefinition {
    public static final BigInteger[][] sIntRange = {new BigInteger[]{new BigInteger("-128"), new BigInteger("127")}, new BigInteger[]{new BigInteger("-32768"), new BigInteger("32767")}, new BigInteger[]{new BigInteger("-2147483648"), new BigInteger("2147483647")}, new BigInteger[]{new BigInteger("-9223372036854775808"), new BigInteger("9223372036854775807")}};
    public static final BigInteger[] uIntMax = {new BigInteger("256"), new BigInteger("65536"), new BigInteger("4294967296"), new BigInteger("18446744073709551616")};

    public enum BaseType {
        SEQ,
        SEQ_OF,
        CHOICE,
        ENUM,
        INT,
        OCTET_STRING,
        OPAQUE,
        UTF8_STRING,
        BIT_STRING,
        NULL,
        EXTENSION,
        ENUM_ITEM,
        BOOLEAN,
        IS0646String,
        PrintableString,
        NumericString,
        BMPString,
        UniversalString,
        IA5String,
        VisibleString,
        Switch,
        Supplier
    }

    public static class Builder {
        public Switch aSwitch;
        public final BaseType baseType;
        public int block;
        public ArrayList<Builder> children = new ArrayList<>();
        /* access modifiers changed from: private */
        public final ItemProvider defaultItemProvider = new ItemProvider() {
            public Builder existingChild(int i11, Builder builder) {
                return builder.copy(Builder.this.defaultItemProvider);
            }
        };
        public ASN1Encodable defaultValue;
        public ElementSupplier elementSupplier;
        public BigInteger enumValue;
        public boolean explicit = true;
        public Boolean inScope;
        public String label;
        public BigInteger lowerBound;
        public boolean mayRecurse;
        public Builder placeholderValue;
        public Map<String, ElementSupplier> supplierMap = new HashMap();
        public String typeName;
        public BigInteger upperBound;
        public ArrayList<ASN1Encodable> validSwitchValues = new ArrayList<>();

        public Builder(BaseType baseType2) {
            this.baseType = baseType2;
        }

        /* access modifiers changed from: private */
        public Builder copy(ItemProvider itemProvider) {
            Builder builder = new Builder(this.baseType);
            Iterator<Builder> it2 = this.children.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                builder.children.add(itemProvider.existingChild(i11, it2.next()));
                i11++;
            }
            builder.explicit = this.explicit;
            builder.label = this.label;
            builder.upperBound = this.upperBound;
            builder.lowerBound = this.lowerBound;
            builder.defaultValue = this.defaultValue;
            builder.enumValue = this.enumValue;
            builder.inScope = this.inScope;
            builder.aSwitch = this.aSwitch;
            builder.validSwitchValues = new ArrayList<>(this.validSwitchValues);
            builder.elementSupplier = this.elementSupplier;
            builder.mayRecurse = this.mayRecurse;
            builder.typeName = this.typeName;
            builder.supplierMap = new HashMap(this.supplierMap);
            builder.block = this.block;
            return builder;
        }

        public void addExtensions(Builder builder, ExtensionList extensionList) {
            if (extensionList.isEmpty()) {
                Builder builder2 = new Builder(BaseType.EXTENSION);
                builder2.block = extensionList.block;
                builder.children.add(builder2);
                return;
            }
            for (Object next : extensionList) {
                if (next instanceof OptionalList) {
                    addOptionals(builder, extensionList.block, (OptionalList) next);
                } else {
                    Builder wrap = wrap(true, next);
                    wrap.block = extensionList.block;
                    builder.children.add(wrap);
                }
            }
        }

        public void addOptionals(Builder builder, int i11, OptionalList optionalList) {
            for (Object next : optionalList) {
                if (next instanceof ExtensionList) {
                    addExtensions(builder, (ExtensionList) next);
                } else {
                    Builder wrap = wrap(false, next);
                    wrap.block = i11;
                    builder.children.add(wrap);
                }
            }
        }

        public Builder block(int i11) {
            Builder copy = copy();
            copy.block = i11;
            return copy;
        }

        public Element build() {
            ArrayList arrayList = new ArrayList();
            boolean z11 = false;
            if (this.baseType == BaseType.ENUM) {
                HashSet hashSet = new HashSet();
                int i11 = 0;
                int i12 = 0;
                while (i11 < this.children.size()) {
                    Builder builder = this.children.get(i11);
                    if (builder.enumValue == null) {
                        builder.enumValue = BigInteger.valueOf((long) i12);
                        i12++;
                    }
                    if (!hashSet.contains(builder.enumValue)) {
                        hashSet.add(builder.enumValue);
                        i11++;
                    } else {
                        throw new IllegalStateException("duplicate enum value at index " + i11);
                    }
                }
            }
            Iterator<Builder> it2 = this.children.iterator();
            boolean z12 = false;
            int i13 = 0;
            boolean z13 = false;
            while (it2.hasNext()) {
                Builder next = it2.next();
                if (!z12 && next.block > 0) {
                    z12 = true;
                }
                if (!next.explicit) {
                    i13++;
                }
                if (!z13 && next.defaultValue != null) {
                    z13 = true;
                }
                arrayList.add(next.build());
            }
            BaseType baseType2 = this.baseType;
            ASN1Encodable aSN1Encodable = this.defaultValue;
            if (aSN1Encodable == null && this.explicit) {
                z11 = true;
            }
            return new Element(baseType2, arrayList, z11, this.label, this.lowerBound, this.upperBound, z12, this.enumValue, aSN1Encodable, this.aSwitch, this.validSwitchValues.isEmpty() ? null : this.validSwitchValues, this.elementSupplier, this.mayRecurse, this.typeName, this.supplierMap.isEmpty() ? null : this.supplierMap, this.block, i13, z13);
        }

        public Builder copy() {
            return copy(this.defaultItemProvider);
        }

        public Builder decodeSwitch(Switch switchR) {
            Builder copy = copy();
            copy.aSwitch = switchR;
            return copy;
        }

        public Builder defaultValue(ASN1Encodable aSN1Encodable) {
            Builder copy = copy();
            copy.defaultValue = aSN1Encodable;
            return copy;
        }

        public Builder elementSupplier(ElementSupplier elementSupplier2) {
            Builder copy = copy();
            copy.elementSupplier = elementSupplier2;
            return copy;
        }

        public Builder enumValue(BigInteger bigInteger) {
            Builder copy = copy();
            this.enumValue = bigInteger;
            return copy;
        }

        public Builder explicit(boolean z11) {
            Builder copy = copy();
            copy.explicit = z11;
            return copy;
        }

        public Builder fixedSize(long j11) {
            Builder copy = copy();
            copy.upperBound = BigInteger.valueOf(j11);
            copy.lowerBound = BigInteger.valueOf(j11);
            return copy;
        }

        public Builder inScope(boolean z11) {
            Builder copy = copy();
            copy.inScope = Boolean.valueOf(z11);
            return copy;
        }

        public Builder items(Object... objArr) {
            Builder copy = copy();
            for (int i11 = 0; i11 != objArr.length; i11++) {
                ExtensionList extensionList = objArr[i11];
                if (extensionList instanceof ExtensionList) {
                    addExtensions(copy, extensionList);
                } else if (extensionList instanceof OptionalList) {
                    addOptionals(copy, copy.block, (OptionalList) extensionList);
                } else if (extensionList.getClass().isArray()) {
                    int i12 = 0;
                    while (true) {
                        Object[] objArr2 = (Object[]) extensionList;
                        if (i12 >= objArr2.length) {
                            break;
                        }
                        copy.children.add(wrap(true, objArr2[i12]));
                        i12++;
                    }
                } else {
                    copy.children.add(wrap(true, extensionList));
                }
            }
            return copy;
        }

        public Builder label(String str) {
            Builder copy = copy();
            copy.label = str;
            return copy;
        }

        public Builder labelPrefix(String str) {
            Builder copy = copy();
            copy.label = str + " " + this.label;
            return copy;
        }

        public Builder limitScopeTo(String... strArr) {
            Builder copy = copy();
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(strArr));
            ArrayList<Builder> arrayList = new ArrayList<>();
            Iterator<Builder> it2 = this.children.iterator();
            while (it2.hasNext()) {
                Builder next = it2.next();
                arrayList.add(next.copy().inScope(hashSet.contains(next.label)));
            }
            copy.children = arrayList;
            return copy;
        }

        public Builder mayRecurse(boolean z11) {
            Builder copy = copy();
            copy.mayRecurse = z11;
            return copy;
        }

        public Builder range(long j11, long j12, ASN1Encodable aSN1Encodable) {
            Builder copy = copy();
            copy.lowerBound = BigInteger.valueOf(j11);
            copy.upperBound = BigInteger.valueOf(j12);
            copy.defaultValue = aSN1Encodable;
            return copy;
        }

        public Builder range(BigInteger bigInteger, BigInteger bigInteger2) {
            Builder copy = copy();
            copy.lowerBound = bigInteger;
            copy.upperBound = bigInteger2;
            return copy;
        }

        public Builder rangeToMAXFrom(long j11) {
            Builder copy = copy();
            copy.lowerBound = BigInteger.valueOf(j11);
            copy.upperBound = null;
            return copy;
        }

        public Builder rangeZeroTo(long j11) {
            Builder copy = copy();
            copy.upperBound = BigInteger.valueOf(j11);
            copy.lowerBound = BigInteger.ZERO;
            return copy;
        }

        public Builder replaceChild(final int i11, final Builder builder) {
            return copy(new ItemProvider() {
                public Builder existingChild(int i11, Builder builder) {
                    return i11 == i11 ? builder : builder;
                }
            });
        }

        public Builder typeName(String str) {
            Builder copy = copy();
            copy.typeName = str;
            if (copy.label == null) {
                copy.label = str;
            }
            return copy;
        }

        public Builder unbounded() {
            Builder copy = copy();
            copy.lowerBound = null;
            copy.upperBound = null;
            return copy;
        }

        public Builder validSwitchValue(ASN1Encodable... aSN1EncodableArr) {
            Builder copy = copy();
            copy.validSwitchValues.addAll(Arrays.asList(aSN1EncodableArr));
            return copy;
        }

        public Builder wrap(boolean z11, Object obj) {
            if (obj instanceof Builder) {
                return ((Builder) obj).explicit(z11);
            }
            if (obj instanceof BaseType) {
                return new Builder((BaseType) obj).explicit(z11);
            }
            if (obj instanceof String) {
                return OERDefinition.enumItem((String) obj);
            }
            throw new IllegalStateException("Unable to wrap item in builder");
        }
    }

    public static class ExtensionList extends ArrayList<Object> {
        public final int block;

        public ExtensionList(int i11, List<Object> list) {
            this.block = i11;
            addAll(list);
        }
    }

    public interface ItemProvider {
        Builder existingChild(int i11, Builder builder);
    }

    public static class MutableBuilder extends Builder {
        private boolean frozen = false;

        public MutableBuilder(BaseType baseType) {
            super(baseType);
        }

        public MutableBuilder addItemsAndFreeze(Builder... builderArr) {
            if (!this.frozen) {
                for (int i11 = 0; i11 != builderArr.length; i11++) {
                    Builder builder = builderArr[i11];
                    if (builder instanceof OptionalList) {
                        for (Object wrap : (List) builder) {
                            this.children.add(wrap(false, wrap));
                        }
                    } else if (builder.getClass().isArray()) {
                        for (Object wrap2 : (Object[]) builder) {
                            this.children.add(wrap(true, wrap2));
                        }
                    } else {
                        this.children.add(wrap(true, builder));
                    }
                }
                this.frozen = true;
                return this;
            }
            throw new IllegalStateException("build cannot be modified and must be copied only");
        }

        public MutableBuilder label(String str) {
            this.label = str;
            return this;
        }
    }

    public static class OptionalList extends ArrayList<Object> {
        public OptionalList(List<Object> list) {
            addAll(list);
        }
    }

    public static Builder aSwitch(Switch switchR) {
        return new Builder(BaseType.Switch).decodeSwitch(switchR);
    }

    public static Builder bitString(long j11) {
        return new Builder(BaseType.BIT_STRING).fixedSize(j11);
    }

    public static Builder bool() {
        return new Builder(BaseType.BOOLEAN);
    }

    public static Builder choice(Object... objArr) {
        return new Builder(BaseType.CHOICE).items(objArr);
    }

    public static Builder deferred(ElementSupplier elementSupplier) {
        return new Builder(BaseType.Supplier).elementSupplier(elementSupplier);
    }

    public static Builder enumItem(String str) {
        return new Builder(BaseType.ENUM_ITEM).label(str);
    }

    public static Builder enumItem(String str, BigInteger bigInteger) {
        return new Builder(BaseType.ENUM_ITEM).enumValue(bigInteger).label(str);
    }

    public static Builder enumeration(Object... objArr) {
        return new Builder(BaseType.ENUM).items(objArr);
    }

    public static ExtensionList extension(int i11, Object... objArr) {
        return new ExtensionList(i11, Arrays.asList(objArr));
    }

    public static ExtensionList extension(Object... objArr) {
        return new ExtensionList(1, Arrays.asList(objArr));
    }

    public static Builder ia5String() {
        return new Builder(BaseType.IA5String);
    }

    public static Builder integer() {
        return new Builder(BaseType.INT);
    }

    public static Builder integer(long j11) {
        return new Builder(BaseType.INT).defaultValue(new ASN1Integer(j11));
    }

    public static Builder integer(long j11, long j12) {
        return new Builder(BaseType.INT).range(BigInteger.valueOf(j11), BigInteger.valueOf(j12));
    }

    public static Builder integer(long j11, long j12, ASN1Encodable aSN1Encodable) {
        return new Builder(BaseType.INT).range(j11, j12, aSN1Encodable);
    }

    public static Builder integer(BigInteger bigInteger, BigInteger bigInteger2) {
        return new Builder(BaseType.INT).range(bigInteger, bigInteger2);
    }

    public static Builder nullValue() {
        return new Builder(BaseType.NULL);
    }

    public static Builder octets() {
        return new Builder(BaseType.OCTET_STRING).unbounded();
    }

    public static Builder octets(int i11) {
        return new Builder(BaseType.OCTET_STRING).fixedSize((long) i11);
    }

    public static Builder octets(int i11, int i12) {
        return new Builder(BaseType.OCTET_STRING).range(BigInteger.valueOf((long) i11), BigInteger.valueOf((long) i12));
    }

    public static Builder opaque() {
        return new Builder(BaseType.OPAQUE);
    }

    public static List<Object> optional(Object... objArr) {
        return new OptionalList(Arrays.asList(objArr));
    }

    public static Builder placeholder() {
        return new Builder((BaseType) null);
    }

    public static Builder seq() {
        return new Builder(BaseType.SEQ);
    }

    public static Builder seq(Object... objArr) {
        return new Builder(BaseType.SEQ).items(objArr);
    }

    public static Builder seqof(Object... objArr) {
        return new Builder(BaseType.SEQ_OF).items(objArr);
    }

    public static Builder utf8String() {
        return new Builder(BaseType.UTF8_STRING);
    }

    public static Builder utf8String(int i11) {
        return new Builder(BaseType.UTF8_STRING).rangeToMAXFrom((long) i11);
    }

    public static Builder utf8String(int i11, int i12) {
        return new Builder(BaseType.UTF8_STRING).range(BigInteger.valueOf((long) i11), BigInteger.valueOf((long) i12));
    }
}
