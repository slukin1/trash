package kotlinx.serialization.json.internal;

public enum WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    
    public final char begin;
    public final char end;

    private WriteMode(char c11, char c12) {
        this.begin = c11;
        this.end = c12;
    }
}
