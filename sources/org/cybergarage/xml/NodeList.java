package org.cybergarage.xml;

import java.util.Vector;

public class NodeList extends Vector {
    public Node getEndsWith(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Node node = getNode(i11);
            String l11 = node.l();
            if (l11 != null && l11.endsWith(str)) {
                return node;
            }
        }
        return null;
    }

    public Node getNode(int i11) {
        return (Node) get(i11);
    }

    public Node getNode(String str) {
        if (str == null) {
            return null;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            Node node = getNode(i11);
            if (str.compareTo(node.l()) == 0) {
                return node;
            }
        }
        return null;
    }
}
