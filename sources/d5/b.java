package d5;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f66217a;

    /* renamed from: b  reason: collision with root package name */
    public int f66218b;

    public b(int i11) {
        a(i11);
    }

    public void a(int i11) {
        this.f66218b = i11;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0) {
                stringBuffer.append(InstructionFileId.DOT);
            }
            stringBuffer.append("0");
        }
        this.f66217a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String b(float f11, Entry entry, int i11, ViewPortHandler viewPortHandler) {
        return this.f66217a.format((double) f11);
    }
}
