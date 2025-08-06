package com.google.zxing.client.android.encode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

final class VCardFieldFormatter implements Formatter {
    private static final Pattern NEWLINE = Pattern.compile("\\n");
    private static final Pattern RESERVED_VCARD_CHARS = Pattern.compile("([\\\\,;])");
    private final List<Map<String, Set<String>>> metadataForIndex;

    public VCardFieldFormatter() {
        this((List<Map<String, Set<String>>>) null);
    }

    private static CharSequence formatMetadata(CharSequence charSequence, Map<String, Set<String>> map) {
        StringBuilder sb2 = new StringBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Set set = (Set) next.getValue();
                if (set != null && !set.isEmpty()) {
                    sb2.append(';');
                    sb2.append((String) next.getKey());
                    sb2.append('=');
                    if (set.size() > 1) {
                        sb2.append('\"');
                    }
                    Iterator it2 = set.iterator();
                    sb2.append((String) it2.next());
                    while (it2.hasNext()) {
                        sb2.append(',');
                        sb2.append((String) it2.next());
                    }
                    if (set.size() > 1) {
                        sb2.append('\"');
                    }
                }
            }
        }
        sb2.append(':');
        sb2.append(charSequence);
        return sb2;
    }

    public CharSequence format(CharSequence charSequence, int i11) {
        String replaceAll = NEWLINE.matcher(RESERVED_VCARD_CHARS.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        List<Map<String, Set<String>>> list = this.metadataForIndex;
        return formatMetadata(replaceAll, (list == null || list.size() <= i11) ? null : this.metadataForIndex.get(i11));
    }

    public VCardFieldFormatter(List<Map<String, Set<String>>> list) {
        this.metadataForIndex = list;
    }
}
