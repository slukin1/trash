package kotlinx.coroutines.reactive;

enum Mode {
    FIRST("awaitFirst"),
    FIRST_OR_DEFAULT("awaitFirstOrDefault"),
    LAST("awaitLast"),
    SINGLE("awaitSingle"),
    SINGLE_OR_DEFAULT("awaitSingleOrDefault");
    

    /* renamed from: s  reason: collision with root package name */
    private final String f57407s;

    private Mode(String str) {
        this.f57407s = str;
    }

    public final String getS() {
        return this.f57407s;
    }

    public String toString() {
        return this.f57407s;
    }
}
