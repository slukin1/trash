package androidx.test.espresso.assertion;

enum PositionAssertions$Position {
    COMPLETELY_LEFT_OF("completely left of"),
    COMPLETELY_RIGHT_OF("completely right of"),
    COMPLETELY_ABOVE("completely above"),
    COMPLETELY_BELOW("completely below"),
    PARTIALLY_LEFT_OF("partially left of"),
    PARTIALLY_RIGHT_OF("partially right of"),
    PARTIALLY_ABOVE("partially above"),
    PARTIALLY_BELOW("partially below"),
    LEFT_ALIGNED("aligned left with"),
    RIGHT_ALIGNED("aligned right with"),
    TOP_ALIGNED("aligned top with"),
    BOTTOM_ALIGNED("aligned bottom with");
    
    private final String positionValue;

    private PositionAssertions$Position(String str) {
        this.positionValue = str;
    }

    public String toString() {
        return this.positionValue;
    }
}
