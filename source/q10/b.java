package q10;

import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public interface b {
    void onPageScrollStateChanged(int i11);

    void onPageScrolled(int i11, float f11, int i12);

    void onPageSelected(int i11);

    void onPositionDataProvide(List<PositionData> list);
}
