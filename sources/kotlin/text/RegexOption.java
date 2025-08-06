package kotlin.text;

public enum RegexOption implements d {
    IGNORE_CASE(2, 0, 2, (int) null),
    MULTILINE(8, 0, 2, (int) null),
    LITERAL(16, 0, 2, (int) null),
    UNIX_LINES(1, 0, 2, (int) null),
    COMMENTS(4, 0, 2, (int) null),
    DOT_MATCHES_ALL(32, 0, 2, (int) null),
    CANON_EQ(128, 0, 2, (int) null);
    
    private final int mask;
    private final int value;

    private RegexOption(int i11, int i12) {
        this.value = i11;
        this.mask = i12;
    }

    public int getMask() {
        return this.mask;
    }

    public int getValue() {
        return this.value;
    }
}
