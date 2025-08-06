package com.google.protobuf;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int i11, StringBuilder sb2) {
        while (i11 > 0) {
            char[] cArr = INDENT_BUFFER;
            int length = i11 > cArr.length ? cArr.length : i11;
            sb2.append(cArr, 0, length);
            i11 -= length;
        }
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (Float.floatToRawIntBits(((Float) obj).floatValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum)) {
                return false;
            } else {
                if (((Enum) obj).ordinal() == 0) {
                    return true;
                }
                return false;
            }
        }
    }

    private static String pascalCaseToSnakeCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Character.toLowerCase(str.charAt(0)));
        for (int i11 = 1; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    public static void printField(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object printField : (List) obj) {
                printField(sb2, i11, str, printField);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry printField2 : ((Map) obj).entrySet()) {
                printField(sb2, i11, str, printField2);
            }
        } else {
            sb2.append(10);
            indent(i11, sb2);
            sb2.append(pascalCaseToSnakeCase(str));
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(TextFormatEscaper.escapeText((String) obj));
                sb2.append('\"');
            } else if (obj instanceof ByteString) {
                sb2.append(": \"");
                sb2.append(TextFormatEscaper.escapeBytes((ByteString) obj));
                sb2.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb2.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb2, i11 + 2);
                sb2.append("\n");
                indent(i11, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i12 = i11 + 2;
                printField(sb2, i12, "key", entry.getKey());
                printField(sb2, i12, "value", entry.getValue());
                sb2.append("\n");
                indent(i11, sb2);
                sb2.append("}");
            } else {
                sb2.append(l.f34627b);
                sb2.append(obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016f, code lost:
        if (r5.containsKey("get" + r9.substring(0, r9.length() - 5)) != false) goto L_0x0147;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void reflectivePrintWithIndent(com.google.protobuf.MessageLite r16, java.lang.StringBuilder r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.lang.Class r6 = r16.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            java.lang.String r11 = "has"
            java.lang.String r12 = "set"
            r13 = 3
            if (r9 >= r7) goto L_0x008c
            r14 = r6[r9]
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 == 0) goto L_0x0036
            goto L_0x0089
        L_0x0036:
            java.lang.String r15 = r14.getName()
            int r15 = r15.length()
            if (r15 >= r13) goto L_0x0041
            goto L_0x0089
        L_0x0041:
            java.lang.String r13 = r14.getName()
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x0053
            java.lang.String r10 = r14.getName()
            r3.add(r10)
            goto L_0x0089
        L_0x0053:
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 != 0) goto L_0x005e
            goto L_0x0089
        L_0x005e:
            java.lang.Class[] r12 = r14.getParameterTypes()
            int r12 = r12.length
            if (r12 == 0) goto L_0x0066
            goto L_0x0089
        L_0x0066:
            java.lang.String r12 = r14.getName()
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto L_0x0078
            java.lang.String r10 = r14.getName()
            r4.put(r10, r14)
            goto L_0x0089
        L_0x0078:
            java.lang.String r11 = r14.getName()
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x0089
            java.lang.String r10 = r14.getName()
            r5.put(r10, r14)
        L_0x0089:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x008c:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0094:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01b3
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.substring(r13)
            java.lang.String r14 = "List"
            boolean r15 = r9.endsWith(r14)
            if (r15 == 0) goto L_0x00e9
            java.lang.String r15 = "OrBuilderList"
            boolean r15 = r9.endsWith(r15)
            if (r15 != 0) goto L_0x00e9
            boolean r14 = r9.equals(r14)
            if (r14 != 0) goto L_0x00e9
            java.lang.Object r14 = r7.getValue()
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14
            if (r14 == 0) goto L_0x00e9
            java.lang.Class r15 = r14.getReturnType()
            java.lang.Class<java.util.List> r13 = java.util.List.class
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x00e9
            int r7 = r9.length()
            int r7 = r7 + -4
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.protobuf.GeneratedMessageLite.invokeOrDie(r14, r0, r9)
            printField(r1, r2, r7, r9)
            r13 = 3
            goto L_0x0094
        L_0x00e9:
            java.lang.String r13 = "Map"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x0131
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x0131
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x0131
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0131
            java.lang.Class<java.lang.Deprecated> r14 = java.lang.Deprecated.class
            boolean r14 = r13.isAnnotationPresent(r14)
            if (r14 != 0) goto L_0x0131
            int r14 = r13.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isPublic(r14)
            if (r14 == 0) goto L_0x0131
            int r7 = r9.length()
            r14 = 3
            int r7 = r7 - r14
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.protobuf.GeneratedMessageLite.invokeOrDie(r13, r0, r9)
            printField(r1, r2, r7, r9)
            goto L_0x0147
        L_0x0131:
            r14 = 3
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 != 0) goto L_0x014a
        L_0x0147:
            r13 = r14
            goto L_0x0094
        L_0x014a:
            java.lang.String r13 = "Bytes"
            boolean r13 = r9.endsWith(r13)
            if (r13 == 0) goto L_0x0172
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            int r15 = r9.length()
            int r15 = r15 + -5
            java.lang.String r15 = r9.substring(r8, r15)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            boolean r13 = r5.containsKey(r13)
            if (r13 == 0) goto L_0x0172
            goto L_0x0147
        L_0x0172:
            java.lang.Object r7 = r7.getValue()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r11)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.Object r13 = r4.get(r13)
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r7 == 0) goto L_0x0147
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.protobuf.GeneratedMessageLite.invokeOrDie(r7, r0, r15)
            if (r13 != 0) goto L_0x01a1
            boolean r13 = isDefaultValue(r7)
            if (r13 != 0) goto L_0x019f
            r13 = 1
            goto L_0x01ad
        L_0x019f:
            r13 = r8
            goto L_0x01ad
        L_0x01a1:
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Object r13 = com.google.protobuf.GeneratedMessageLite.invokeOrDie(r13, r0, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
        L_0x01ad:
            if (r13 == 0) goto L_0x0147
            printField(r1, r2, r9, r7)
            goto L_0x0147
        L_0x01b3:
            boolean r3 = r0 instanceof com.google.protobuf.GeneratedMessageLite.ExtendableMessage
            if (r3 == 0) goto L_0x01f4
            r3 = r0
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r3 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r3
            com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r3 = r3.extensions
            java.util.Iterator r3 = r3.iterator()
        L_0x01c0:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01f4
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "["
            r5.append(r6)
            java.lang.Object r6 = r4.getKey()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = (com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor) r6
            int r6 = r6.getNumber()
            r5.append(r6)
            java.lang.String r6 = "]"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object r4 = r4.getValue()
            printField(r1, r2, r5, r4)
            goto L_0x01c0
        L_0x01f4:
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.UnknownFieldSetLite r0 = r0.unknownFields
            if (r0 == 0) goto L_0x01fd
            r0.printWithIndent(r1, r2)
        L_0x01fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageLiteToString.reflectivePrintWithIndent(com.google.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }

    public static String toString(MessageLite messageLite, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        reflectivePrintWithIndent(messageLite, sb2, 0);
        return sb2.toString();
    }
}
