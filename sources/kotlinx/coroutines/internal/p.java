package kotlinx.coroutines.internal;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f57333a = new c0("CONDITION_FALSE");

    public static final Object a() {
        return f57333a;
    }

    public static final LockFreeLinkedListNode b(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        w wVar = obj instanceof w ? (w) obj : null;
        return (wVar == null || (lockFreeLinkedListNode = wVar.f57350a) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
