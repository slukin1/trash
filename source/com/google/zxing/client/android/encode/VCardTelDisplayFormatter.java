package com.google.zxing.client.android.encode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class VCardTelDisplayFormatter implements Formatter {
    private final List<Map<String, Set<String>>> metadataForIndex;

    public VCardTelDisplayFormatter() {
        this((List<Map<String, Set<String>>>) null);
    }

    private static CharSequence formatMetadata(CharSequence charSequence, Map<String, Set<String>> map) {
        if (map == null || map.isEmpty()) {
            return charSequence;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, Set<String>> value : map.entrySet()) {
            Set set = (Set) value.getValue();
            if (set != null && !set.isEmpty()) {
                Iterator it2 = set.iterator();
                sb2.append((String) it2.next());
                while (it2.hasNext()) {
                    sb2.append(',');
                    sb2.append((String) it2.next());
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append(' ');
        }
        sb2.append(charSequence);
        return sb2;
    }

    public CharSequence format(CharSequence charSequence, int i11) {
        String formatPhone = ContactEncoder.formatPhone(charSequence.toString());
        List<Map<String, Set<String>>> list = this.metadataForIndex;
        return formatMetadata(formatPhone, (list == null || list.size() <= i11) ? null : this.metadataForIndex.get(i11));
    }

    public VCardTelDisplayFormatter(List<Map<String, Set<String>>> list) {
        this.metadataForIndex = list;
    }
}
