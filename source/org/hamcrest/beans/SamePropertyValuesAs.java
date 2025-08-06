package org.hamcrest.beans;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsEqual;

public class SamePropertyValuesAs<T> extends TypeSafeDiagnosingMatcher<T> {
    private final T expectedBean;
    private final List<PropertyMatcher> propertyMatchers;
    private final Set<String> propertyNames;

    public static class PropertyMatcher extends DiagnosingMatcher<Object> {
        private final Matcher<Object> matcher;
        private final String propertyName;
        private final Method readMethod;

        public PropertyMatcher(PropertyDescriptor propertyDescriptor, Object obj) {
            this.propertyName = propertyDescriptor.getDisplayName();
            Method readMethod2 = propertyDescriptor.getReadMethod();
            this.readMethod = readMethod2;
            this.matcher = IsEqual.equalTo(SamePropertyValuesAs.readProperty(readMethod2, obj));
        }

        public void describeTo(Description description) {
            description.appendText(this.propertyName + l.f34627b).appendDescriptionOf(this.matcher);
        }

        public boolean matches(Object obj, Description description) {
            Object access$000 = SamePropertyValuesAs.readProperty(this.readMethod, obj);
            if (this.matcher.matches(access$000)) {
                return true;
            }
            description.appendText(this.propertyName + " ");
            this.matcher.describeMismatch(access$000, description);
            return false;
        }
    }

    public SamePropertyValuesAs(T t11) {
        PropertyDescriptor[] propertyDescriptorsFor = PropertyUtil.propertyDescriptorsFor(t11, Object.class);
        this.expectedBean = t11;
        this.propertyNames = propertyNamesFrom(propertyDescriptorsFor);
        this.propertyMatchers = propertyMatchersFor(t11, propertyDescriptorsFor);
    }

    private boolean hasMatchingValues(T t11, Description description) {
        for (PropertyMatcher next : this.propertyMatchers) {
            if (!next.matches(t11)) {
                next.describeMismatch(t11, description);
                return false;
            }
        }
        return true;
    }

    private boolean hasNoExtraProperties(T t11, Description description) {
        Set<String> propertyNamesFrom = propertyNamesFrom(PropertyUtil.propertyDescriptorsFor(t11, Object.class));
        propertyNamesFrom.removeAll(this.propertyNames);
        if (propertyNamesFrom.isEmpty()) {
            return true;
        }
        description.appendText("has extra properties called " + propertyNamesFrom);
        return false;
    }

    private boolean isCompatibleType(T t11, Description description) {
        if (this.expectedBean.getClass().isAssignableFrom(t11.getClass())) {
            return true;
        }
        description.appendText("is incompatible type: " + t11.getClass().getSimpleName());
        return false;
    }

    private static <T> List<PropertyMatcher> propertyMatchersFor(T t11, PropertyDescriptor[] propertyDescriptorArr) {
        ArrayList arrayList = new ArrayList(propertyDescriptorArr.length);
        for (PropertyDescriptor propertyMatcher : propertyDescriptorArr) {
            arrayList.add(new PropertyMatcher(propertyMatcher, t11));
        }
        return arrayList;
    }

    private static Set<String> propertyNamesFrom(PropertyDescriptor[] propertyDescriptorArr) {
        HashSet hashSet = new HashSet();
        for (PropertyDescriptor displayName : propertyDescriptorArr) {
            hashSet.add(displayName.getDisplayName());
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public static Object readProperty(Method method, Object obj) {
        try {
            return method.invoke(obj, PropertyUtil.NO_ARGUMENTS);
        } catch (Exception e11) {
            throw new IllegalArgumentException("Could not invoke " + method + " on " + obj, e11);
        }
    }

    @Factory
    public static <T> Matcher<T> samePropertyValuesAs(T t11) {
        return new SamePropertyValuesAs(t11);
    }

    public void describeTo(Description description) {
        description.appendText("same property values as " + this.expectedBean.getClass().getSimpleName()).appendList(" [", ", ", "]", this.propertyMatchers);
    }

    public boolean matchesSafely(T t11, Description description) {
        return isCompatibleType(t11, description) && hasNoExtraProperties(t11, description) && hasMatchingValues(t11, description);
    }
}
