package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

public final class z2 {
    public static List<SurfaceCombination> a(int i11, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f());
        if (i11 == 0 || i11 == 1 || i11 == 3) {
            arrayList.addAll(h());
        }
        if (i11 == 1 || i11 == 3) {
            arrayList.addAll(e());
        }
        if (z11) {
            arrayList.addAll(i());
        }
        if (z12 && i11 == 0) {
            arrayList.addAll(c());
        }
        if (i11 == 3) {
            arrayList.addAll(g());
        }
        return arrayList;
    }

    public static List<SurfaceCombination> b() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize3));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize3));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize3));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    public static List<SurfaceCombination> c() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    public static List<SurfaceCombination> d() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.s720p;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination9);
        return arrayList;
    }

    public static List<SurfaceCombination> e() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    public static List<SurfaceCombination> f() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    public static List<SurfaceCombination> g() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, configSize3));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    public static List<SurfaceCombination> h() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    public static List<SurfaceCombination> i() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    public static List<SurfaceCombination> j() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize, 4));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize, 4));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3, 2));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3, 2));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        arrayList.add(surfaceCombination9);
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        arrayList.add(surfaceCombination10);
        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType2, configSize4, 1));
        arrayList.add(surfaceCombination11);
        SurfaceCombination surfaceCombination12 = new SurfaceCombination();
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2, 2));
        arrayList.add(surfaceCombination12);
        SurfaceCombination surfaceCombination13 = new SurfaceCombination();
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2, 2));
        arrayList.add(surfaceCombination13);
        SurfaceCombination surfaceCombination14 = new SurfaceCombination();
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType2, configSize4, 1));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination14);
        return arrayList;
    }

    public static List<SurfaceCombination> k() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.RAW;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType3, configSize4));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize4));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType3, configSize4));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize4));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize4));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType, configSize4));
        arrayList.add(surfaceCombination9);
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType4, configSize4));
        arrayList.add(surfaceCombination10);
        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType3, configSize));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType4, configSize4));
        arrayList.add(surfaceCombination11);
        SurfaceCombination surfaceCombination12 = new SurfaceCombination();
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType4, configSize));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType4, configSize4));
        arrayList.add(surfaceCombination12);
        return arrayList;
    }
}
