package kotlin.text;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f56928a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final Regex f56929b;

    static {
        String str = "[eE][+-]?" + "(\\p{Digit}+)";
        f56929b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ('(' + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str + ")?)|((" + ("(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')') + ")[pP][+-]?" + "(\\p{Digit}+)" + ')') + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
