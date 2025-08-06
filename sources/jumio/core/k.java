package jumio.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f56229a = StringDeobfuscator.deobfuscate(new byte[]{ISO7816.INS_PUT_DATA, -22, -25, -126, -69, 10, 65, 23, ISO7816.INS_DELETE_FILE, -59, -20, -57, Framer.STDIN_FRAME_PREFIX, 85, -81, 79, 32, ISO7816.INS_PSO, -106, -35, Ascii.ESC, ISOFileInfo.LCS_BYTE, ISOFileInfo.AB, -69, ISOFileInfo.A1, -37, -83, 79}, 3102386395588422242L);

    /* renamed from: b  reason: collision with root package name */
    public static final String f56230b = StringDeobfuscator.deobfuscate(new byte[]{84, ISO7816.INS_UNBLOCK_CHV, -61, -52, -17, -21, -52, -94, -124, ISOFileInfo.PROP_INFO, ISO7816.INS_ENVELOPE, 28, -27, 46, SignedBytes.MAX_POWER_OF_TWO, 109, -8, -103, 58, 104, -12, 69, -16, 96, -113, 84, 124, -71}, -2860111990246517939L);

    /* renamed from: c  reason: collision with root package name */
    public static final String f56231c = StringDeobfuscator.deobfuscate(new byte[]{76, -51, -1, ISOFileInfo.LCS_BYTE, 106, -19, 70, 23, ISO7816.INS_DELETE_FILE, 88, 53, 95, 60, 56, 79, -35, -16, ISOFileInfo.SECURITY_ATTR_EXP, 97, 54, 15, ISOFileInfo.SECURITY_ATTR_EXP, -47, ISO7816.INS_CREATE_FILE, -101, 11, ISO7816.INS_READ_BINARY_STAMPED, ISOFileInfo.AB}, -412348624451039355L);
}
