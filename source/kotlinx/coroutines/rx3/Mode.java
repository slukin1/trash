package kotlinx.coroutines.rx3;

enum Mode {
    FIRST("awaitFirst"),
    FIRST_OR_DEFAULT("awaitFirstOrDefault"),
    LAST("awaitLast"),
    SINGLE("awaitSingle");
    

    /* renamed from: s  reason: collision with root package name */
    public final String f57431s;

    private Mode(String str) {
        this.f57431s = str;
    }

    public String toString() {
        return this.f57431s;
    }
}
