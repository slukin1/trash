package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    public SupportedOutputSizesSorter(CameraInfoInternal cameraInfoInternal, Size size) {
        Rational rational;
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        if (size != null) {
            rational = calculateFullFovRatioFromActiveArraySize(size);
        } else {
            rational = calculateFullFovRatioFromSupportedOutputSizes(cameraInfoInternal);
        }
        this.mFullFovRatio = rational;
        boolean z11 = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z11 = false;
        }
        this.mIsSensorLandscapeResolution = z11;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(cameraInfoInternal, rational);
    }

    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(List<Size> list, AspectRatioStrategy aspectRatioStrategy) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(list), aspectRatioStrategy);
    }

    private LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(Map<Rational, List<Size>> map, AspectRatioStrategy aspectRatioStrategy) {
        Rational targetAspectRatioRationalValue = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
        if (aspectRatioStrategy.getFallbackRule() == 0) {
            Rational targetAspectRatioRationalValue2 = getTargetAspectRatioRationalValue(aspectRatioStrategy.getPreferredAspectRatio(), this.mIsSensorLandscapeResolution);
            Iterator it2 = new ArrayList(map.keySet()).iterator();
            while (it2.hasNext()) {
                Rational rational = (Rational) it2.next();
                if (!rational.equals(targetAspectRatioRationalValue2)) {
                    map.remove(rational);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioRationalValue, this.mFullFovRatio));
        LinkedHashMap<Rational, List<Size>> linkedHashMap = new LinkedHashMap<>();
        for (Rational rational2 : arrayList) {
            linkedHashMap.put(rational2, map.get(rational2));
        }
        return linkedHashMap;
    }

    private List<Size> applyHighResolutionSettings(List<Size> list, ResolutionSelector resolutionSelector, int i11) {
        if (resolutionSelector.getAllowedResolutionMode() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(i11));
        Collections.sort(arrayList, new CompareSizesByArea(true));
        return arrayList;
    }

    private static void applyMaxResolutionRestriction(LinkedHashMap<Rational, List<Size>> linkedHashMap, Size size) {
        int area = SizeUtil.getArea(size);
        for (Rational rational : linkedHashMap.keySet()) {
            List<Size> list = linkedHashMap.get(rational);
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (SizeUtil.getArea(size2) <= area) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    private List<Size> applyResolutionFilter(List<Size> list, ResolutionFilter resolutionFilter, int i11) {
        if (resolutionFilter == null) {
            return list;
        }
        int surfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i11);
        int i12 = this.mSensorOrientation;
        boolean z11 = true;
        if (this.mLensFacing != 1) {
            z11 = false;
        }
        List<Size> filter = resolutionFilter.filter(new ArrayList(list), CameraOrientationUtil.getRelativeImageRotation(surfaceRotationToDegrees, i12, z11));
        if (list.containsAll(filter)) {
            return filter;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void applyResolutionStrategy(LinkedHashMap<Rational, List<Size>> linkedHashMap, ResolutionStrategy resolutionStrategy) {
        if (resolutionStrategy != null) {
            for (Rational rational : linkedHashMap.keySet()) {
                applyResolutionStrategyFallbackRule(linkedHashMap.get(rational), resolutionStrategy);
            }
        }
    }

    private static void applyResolutionStrategyFallbackRule(List<Size> list, ResolutionStrategy resolutionStrategy) {
        if (!list.isEmpty()) {
            Integer valueOf = Integer.valueOf(resolutionStrategy.getFallbackRule());
            if (!resolutionStrategy.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY)) {
                Size boundSize = resolutionStrategy.getBoundSize();
                int intValue = valueOf.intValue();
                if (intValue == 0) {
                    sortSupportedSizesByFallbackRuleNone(list, boundSize);
                } else if (intValue == 1) {
                    sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, true);
                } else if (intValue == 2) {
                    sortSupportedSizesByFallbackRuleClosestHigherThenLower(list, boundSize, false);
                } else if (intValue == 3) {
                    sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, true);
                } else if (intValue == 4) {
                    sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list, boundSize, false);
                }
            }
        }
    }

    private Rational calculateFullFovRatioFromActiveArraySize(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational calculateFullFovRatioFromSupportedOutputSizes(CameraInfoInternal cameraInfoInternal) {
        List<Size> supportedResolutions = cameraInfoInternal.getSupportedResolutions(256);
        if (supportedResolutions.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(supportedResolutions, new CompareSizesByArea());
        return new Rational(size.getWidth(), size.getHeight());
    }

    private List<Size> getCustomizedSupportedResolutionsFromConfig(int i11, ImageOutputConfig imageOutputConfig) {
        Size[] sizeArr;
        List<Pair<Integer, Size[]>> supportedResolutions = imageOutputConfig.getSupportedResolutions((List<Pair<Integer, Size[]>>) null);
        if (supportedResolutions != null) {
            Iterator<Pair<Integer, Size[]>> it2 = supportedResolutions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Pair next = it2.next();
                if (((Integer) next.first).intValue() == i11) {
                    sizeArr = (Size[]) next.second;
                    break;
                }
            }
        }
        sizeArr = null;
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    private List<Size> getResolutionCandidateList(UseCaseConfig<?> useCaseConfig) {
        int inputFormat = useCaseConfig.getInputFormat();
        List<Size> customizedSupportedResolutionsFromConfig = getCustomizedSupportedResolutionsFromConfig(inputFormat, (ImageOutputConfig) useCaseConfig);
        if (customizedSupportedResolutionsFromConfig == null) {
            customizedSupportedResolutionsFromConfig = this.mCameraInfoInternal.getSupportedResolutions(inputFormat);
        }
        ArrayList arrayList = new ArrayList(customizedSupportedResolutionsFromConfig);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + inputFormat + InstructionFileId.DOT);
        }
        return arrayList;
    }

    public static List<Rational> getResolutionListGroupingAspectRatioKeys(List<Size> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        for (Size next : list) {
            Rational rational = new Rational(next.getWidth(), next.getHeight());
            if (!arrayList.contains(rational)) {
                boolean z11 = false;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (AspectRatioUtil.hasMatchingAspectRatio(next, (Rational) it2.next())) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z11) {
                    arrayList.add(rational);
                }
            }
        }
        return arrayList;
    }

    public static Rational getTargetAspectRatioRationalValue(int i11, boolean z11) {
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 != 1) {
                    Logger.e(TAG, "Undefined target aspect ratio: " + i11);
                } else if (z11) {
                    return AspectRatioUtil.ASPECT_RATIO_16_9;
                } else {
                    return AspectRatioUtil.ASPECT_RATIO_9_16;
                }
            } else if (z11) {
                return AspectRatioUtil.ASPECT_RATIO_4_3;
            } else {
                return AspectRatioUtil.ASPECT_RATIO_3_4;
            }
        }
        return null;
    }

    public static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> list) {
        HashMap hashMap = new HashMap();
        for (Rational put : getResolutionListGroupingAspectRatioKeys(list)) {
            hashMap.put(put, new ArrayList());
        }
        for (Size next : list) {
            for (Rational rational : hashMap.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(next, rational)) {
                    ((List) hashMap.get(rational)).add(next);
                }
            }
        }
        return hashMap;
    }

    private List<Size> sortSupportedOutputSizesByResolutionSelector(UseCaseConfig<?> useCaseConfig) {
        ResolutionSelector resolutionSelector = ((ImageOutputConfig) useCaseConfig).getResolutionSelector();
        List<Size> resolutionCandidateList = getResolutionCandidateList(useCaseConfig);
        if (!useCaseConfig.isHigResolutionDisabled(false)) {
            resolutionCandidateList = applyHighResolutionSettings(resolutionCandidateList, resolutionSelector, useCaseConfig.getInputFormat());
        }
        LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy = applyAspectRatioStrategy(resolutionCandidateList, resolutionSelector.getAspectRatioStrategy());
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        Size maxResolution = imageOutputConfig.getMaxResolution((Size) null);
        if (maxResolution != null) {
            applyMaxResolutionRestriction(applyAspectRatioStrategy, maxResolution);
        }
        applyResolutionStrategy(applyAspectRatioStrategy, resolutionSelector.getResolutionStrategy());
        ArrayList arrayList = new ArrayList();
        for (List<Size> it2 : applyAspectRatioStrategy.values()) {
            for (Size size : it2) {
                if (!arrayList.contains(size)) {
                    arrayList.add(size);
                }
            }
        }
        return applyResolutionFilter(arrayList, resolutionSelector.getResolutionFilter(), imageOutputConfig.getTargetRotation(0));
    }

    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List<Size> list, Size size, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z11) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List<Size> list, Size size, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Size size2 = list.get(i11);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z11) {
            list.addAll(arrayList);
        }
    }

    private static void sortSupportedSizesByFallbackRuleNone(List<Size> list, Size size) {
        boolean contains = list.contains(size);
        list.clear();
        if (contains) {
            list.add(size);
        }
    }

    public List<Size> getSortedSupportedOutputSizes(UseCaseConfig<?> useCaseConfig) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        List<Size> customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions((List<Size>) null);
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        if (imageOutputConfig.getResolutionSelector((ResolutionSelector) null) == null) {
            return this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(getResolutionCandidateList(useCaseConfig), useCaseConfig);
        }
        return sortSupportedOutputSizesByResolutionSelector(useCaseConfig);
    }
}
