package kotlinx.coroutines.internal;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final LockFreeLinkedListNode f57350a;

    public w(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f57350a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.f57350a + ']';
    }
}
