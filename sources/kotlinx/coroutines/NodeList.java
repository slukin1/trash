package kotlinx.coroutines;

import kotlin.jvm.internal.x;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public final class NodeList extends LockFreeLinkedListHead implements i1 {
    public NodeList a() {
        return this;
    }

    public boolean isActive() {
        return true;
    }

    public final String q(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("List{");
        sb2.append(str);
        sb2.append("}[");
        boolean z11 = true;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) i(); !x.b(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.j()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(jobNode);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public String toString() {
        return j0.c() ? q("Active") : super.toString();
    }
}
