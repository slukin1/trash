package org.hamcrest;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.EventObject;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.hamcrest.collection.IsArray;
import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.hamcrest.collection.IsArrayWithSize;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsEmptyIterable;
import org.hamcrest.collection.IsIn;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.collection.IsIterableWithSize;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.CombinableMatcher;
import org.hamcrest.core.DescribedAs;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.StringContains;
import org.hamcrest.core.StringEndsWith;
import org.hamcrest.core.StringStartsWith;
import org.hamcrest.number.BigDecimalCloseTo;
import org.hamcrest.number.IsCloseTo;
import org.hamcrest.number.OrderingComparison;
import org.hamcrest.object.HasToString;
import org.hamcrest.object.IsCompatibleType;
import org.hamcrest.object.IsEventFrom;
import org.hamcrest.text.IsEmptyString;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.hamcrest.text.StringContainsInOrder;
import org.hamcrest.xml.HasXPath;
import org.w3c.dom.Node;

public class Matchers {
    public static <T> Matcher<T> allOf(Iterable<Matcher<? super T>> iterable) {
        return AllOf.allOf(iterable);
    }

    public static <T> Matcher<T> any(Class<T> cls) {
        return IsInstanceOf.any(cls);
    }

    public static <T> AnyOf<T> anyOf(Iterable<Matcher<? super T>> iterable) {
        return AnyOf.anyOf(iterable);
    }

    public static Matcher<Object> anything() {
        return IsAnything.anything();
    }

    public static <T> IsArray<T> array(Matcher<? super T>... matcherArr) {
        return IsArray.array(matcherArr);
    }

    public static <E> Matcher<E[]> arrayContaining(List<Matcher<? super E>> list) {
        return IsArrayContainingInOrder.arrayContaining(list);
    }

    public static <E> Matcher<E[]> arrayContainingInAnyOrder(E... eArr) {
        return IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(eArr);
    }

    public static <E> Matcher<E[]> arrayWithSize(Matcher<? super Integer> matcher) {
        return IsArrayWithSize.arrayWithSize(matcher);
    }

    public static <LHS> CombinableMatcher.CombinableBothMatcher<LHS> both(Matcher<? super LHS> matcher) {
        return CombinableMatcher.both(matcher);
    }

    public static Matcher<Double> closeTo(double d11, double d12) {
        return IsCloseTo.closeTo(d11, d12);
    }

    public static <T extends Comparable<T>> Matcher<T> comparesEqualTo(T t11) {
        return OrderingComparison.comparesEqualTo(t11);
    }

    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E>... matcherArr) {
        return IsIterableContainingInOrder.contains(matcherArr);
    }

    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(T... tArr) {
        return IsIterableContainingInAnyOrder.containsInAnyOrder(tArr);
    }

    public static Matcher<String> containsString(String str) {
        return StringContains.containsString(str);
    }

    public static <T> Matcher<T> describedAs(String str, Matcher<T> matcher, Object... objArr) {
        return DescribedAs.describedAs(str, matcher, objArr);
    }

    public static <LHS> CombinableMatcher.CombinableEitherMatcher<LHS> either(Matcher<? super LHS> matcher) {
        return CombinableMatcher.either(matcher);
    }

    public static <E> Matcher<Collection<? extends E>> empty() {
        return IsEmptyCollection.empty();
    }

    public static <E> Matcher<E[]> emptyArray() {
        return IsArrayWithSize.emptyArray();
    }

    public static <E> Matcher<Collection<E>> emptyCollectionOf(Class<E> cls) {
        return IsEmptyCollection.emptyCollectionOf(cls);
    }

    public static <E> Matcher<Iterable<? extends E>> emptyIterable() {
        return IsEmptyIterable.emptyIterable();
    }

    public static <E> Matcher<Iterable<E>> emptyIterableOf(Class<E> cls) {
        return IsEmptyIterable.emptyIterableOf(cls);
    }

    public static Matcher<String> endsWith(String str) {
        return StringEndsWith.endsWith(str);
    }

    public static <T> Matcher<T> equalTo(T t11) {
        return IsEqual.equalTo(t11);
    }

    public static Matcher<String> equalToIgnoringCase(String str) {
        return IsEqualIgnoringCase.equalToIgnoringCase(str);
    }

    public static Matcher<String> equalToIgnoringWhiteSpace(String str) {
        return IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace(str);
    }

    public static Matcher<EventObject> eventFrom(Class<? extends EventObject> cls, Object obj) {
        return IsEventFrom.eventFrom(cls, obj);
    }

    public static <U> Matcher<Iterable<U>> everyItem(Matcher<U> matcher) {
        return Every.everyItem(matcher);
    }

    public static <T extends Comparable<T>> Matcher<T> greaterThan(T t11) {
        return OrderingComparison.greaterThan(t11);
    }

    public static <T extends Comparable<T>> Matcher<T> greaterThanOrEqualTo(T t11) {
        return OrderingComparison.greaterThanOrEqualTo(t11);
    }

    public static <K, V> Matcher<Map<? extends K, ? extends V>> hasEntry(K k11, V v11) {
        return IsMapContaining.hasEntry(k11, v11);
    }

    public static <T> Matcher<Iterable<? super T>> hasItem(T t11) {
        return IsCollectionContaining.hasItem(t11);
    }

    public static <T> Matcher<T[]> hasItemInArray(T t11) {
        return IsArrayContaining.hasItemInArray(t11);
    }

    public static <T> Matcher<Iterable<T>> hasItems(T... tArr) {
        return IsCollectionContaining.hasItems(tArr);
    }

    public static <K> Matcher<Map<? extends K, ?>> hasKey(Matcher<? super K> matcher) {
        return IsMapContaining.hasKey(matcher);
    }

    public static <T> Matcher<T> hasProperty(String str) {
        return HasProperty.hasProperty(str);
    }

    public static <E> Matcher<Collection<? extends E>> hasSize(Matcher<? super Integer> matcher) {
        return IsCollectionWithSize.hasSize(matcher);
    }

    public static <T> Matcher<T> hasToString(Matcher<? super String> matcher) {
        return HasToString.hasToString(matcher);
    }

    public static <V> Matcher<Map<?, ? extends V>> hasValue(V v11) {
        return IsMapContaining.hasValue(v11);
    }

    public static Matcher<Node> hasXPath(String str, NamespaceContext namespaceContext) {
        return HasXPath.hasXPath(str, namespaceContext);
    }

    public static <T> Matcher<T> instanceOf(Class<?> cls) {
        return IsInstanceOf.instanceOf(cls);
    }

    public static <T> Matcher<T> is(T t11) {
        return Is.is(t11);
    }

    public static <T> Matcher<T> isA(Class<T> cls) {
        return Is.isA(cls);
    }

    public static Matcher<String> isEmptyOrNullString() {
        return IsEmptyString.isEmptyOrNullString();
    }

    public static Matcher<String> isEmptyString() {
        return IsEmptyString.isEmptyString();
    }

    public static <T> Matcher<T> isIn(Collection<T> collection) {
        return IsIn.isIn(collection);
    }

    public static <T> Matcher<T> isOneOf(T... tArr) {
        return IsIn.isOneOf(tArr);
    }

    public static <E> Matcher<Iterable<E>> iterableWithSize(Matcher<? super Integer> matcher) {
        return IsIterableWithSize.iterableWithSize(matcher);
    }

    public static <T extends Comparable<T>> Matcher<T> lessThan(T t11) {
        return OrderingComparison.lessThan(t11);
    }

    public static <T extends Comparable<T>> Matcher<T> lessThanOrEqualTo(T t11) {
        return OrderingComparison.lessThanOrEqualTo(t11);
    }

    public static <T> Matcher<T> not(Matcher<T> matcher) {
        return IsNot.not(matcher);
    }

    public static Matcher<Object> notNullValue() {
        return IsNull.notNullValue();
    }

    public static Matcher<Object> nullValue() {
        return IsNull.nullValue();
    }

    public static <T> Matcher<T> sameInstance(T t11) {
        return IsSame.sameInstance(t11);
    }

    public static <T> Matcher<T> samePropertyValuesAs(T t11) {
        return SamePropertyValuesAs.samePropertyValuesAs(t11);
    }

    public static Matcher<String> startsWith(String str) {
        return StringStartsWith.startsWith(str);
    }

    public static Matcher<String> stringContainsInOrder(Iterable<String> iterable) {
        return StringContainsInOrder.stringContainsInOrder(iterable);
    }

    public static <T> Matcher<T> theInstance(T t11) {
        return IsSame.theInstance(t11);
    }

    public static <T> Matcher<Class<?>> typeCompatibleWith(Class<T> cls) {
        return IsCompatibleType.typeCompatibleWith(cls);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T>... matcherArr) {
        return AllOf.allOf(matcherArr);
    }

    public static <T> AnyOf<T> anyOf(Matcher<T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3) {
        return AnyOf.anyOf(matcher, matcher2, matcher3);
    }

    public static Matcher<Object> anything(String str) {
        return IsAnything.anything(str);
    }

    public static <E> Matcher<E[]> arrayContaining(E... eArr) {
        return IsArrayContainingInOrder.arrayContaining(eArr);
    }

    public static <E> Matcher<E[]> arrayContainingInAnyOrder(Matcher<? super E>... matcherArr) {
        return IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(matcherArr);
    }

    public static <E> Matcher<E[]> arrayWithSize(int i11) {
        return IsArrayWithSize.arrayWithSize(i11);
    }

    public static Matcher<BigDecimal> closeTo(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return BigDecimalCloseTo.closeTo(bigDecimal, bigDecimal2);
    }

    public static <E> Matcher<Iterable<? extends E>> contains(E... eArr) {
        return IsIterableContainingInOrder.contains(eArr);
    }

    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Collection<Matcher<? super T>> collection) {
        return IsIterableContainingInAnyOrder.containsInAnyOrder(collection);
    }

    public static Matcher<EventObject> eventFrom(Object obj) {
        return IsEventFrom.eventFrom(obj);
    }

    public static <K, V> Matcher<Map<? extends K, ? extends V>> hasEntry(Matcher<? super K> matcher, Matcher<? super V> matcher2) {
        return IsMapContaining.hasEntry(matcher, matcher2);
    }

    public static <T> Matcher<Iterable<? super T>> hasItem(Matcher<? super T> matcher) {
        return IsCollectionContaining.hasItem(matcher);
    }

    public static <T> Matcher<T[]> hasItemInArray(Matcher<? super T> matcher) {
        return IsArrayContaining.hasItemInArray(matcher);
    }

    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? super T>... matcherArr) {
        return IsCollectionContaining.hasItems(matcherArr);
    }

    public static <K> Matcher<Map<? extends K, ?>> hasKey(K k11) {
        return IsMapContaining.hasKey(k11);
    }

    public static <T> Matcher<T> hasProperty(String str, Matcher<?> matcher) {
        return HasPropertyWithValue.hasProperty(str, matcher);
    }

    public static <E> Matcher<Collection<? extends E>> hasSize(int i11) {
        return IsCollectionWithSize.hasSize(i11);
    }

    public static <T> Matcher<T> hasToString(String str) {
        return HasToString.hasToString(str);
    }

    public static <V> Matcher<Map<?, ? extends V>> hasValue(Matcher<? super V> matcher) {
        return IsMapContaining.hasValue(matcher);
    }

    public static Matcher<Node> hasXPath(String str) {
        return HasXPath.hasXPath(str);
    }

    public static <T> Matcher<T> is(Matcher<T> matcher) {
        return Is.is(matcher);
    }

    public static <T> Matcher<T> isIn(T[] tArr) {
        return IsIn.isIn(tArr);
    }

    public static <E> Matcher<Iterable<E>> iterableWithSize(int i11) {
        return IsIterableWithSize.iterableWithSize(i11);
    }

    public static <T> Matcher<T> not(T t11) {
        return IsNot.not(t11);
    }

    public static <T> Matcher<T> notNullValue(Class<T> cls) {
        return IsNull.notNullValue(cls);
    }

    public static <T> Matcher<T> nullValue(Class<T> cls) {
        return IsNull.nullValue(cls);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T> matcher, Matcher<? super T> matcher2) {
        return AllOf.allOf(matcher, matcher2);
    }

    public static <T> AnyOf<T> anyOf(Matcher<T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4) {
        return AnyOf.anyOf(matcher, matcher2, matcher3, matcher4);
    }

    public static <E> Matcher<E[]> arrayContaining(Matcher<? super E>... matcherArr) {
        return IsArrayContainingInOrder.arrayContaining(matcherArr);
    }

    public static <E> Matcher<E[]> arrayContainingInAnyOrder(Collection<Matcher<? super E>> collection) {
        return IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(collection);
    }

    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E> matcher) {
        return IsIterableContainingInOrder.contains(matcher);
    }

    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Matcher<? super T>... matcherArr) {
        return IsIterableContainingInAnyOrder.containsInAnyOrder(matcherArr);
    }

    public static Matcher<Node> hasXPath(String str, NamespaceContext namespaceContext, Matcher<String> matcher) {
        return HasXPath.hasXPath(str, namespaceContext, matcher);
    }

    public static <T> Matcher<T> is(Class<T> cls) {
        return Is.is(cls);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3) {
        return AllOf.allOf(matcher, matcher2, matcher3);
    }

    public static <T> AnyOf<T> anyOf(Matcher<T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4, Matcher<? super T> matcher5) {
        return AnyOf.anyOf(matcher, matcher2, matcher3, matcher4, matcher5);
    }

    public static <E> Matcher<Iterable<? extends E>> contains(List<Matcher<? super E>> list) {
        return IsIterableContainingInOrder.contains(list);
    }

    public static <E> Matcher<Iterable<? extends E>> containsInAnyOrder(Matcher<? super E> matcher) {
        return IsIterableContainingInAnyOrder.containsInAnyOrder(matcher);
    }

    public static Matcher<Node> hasXPath(String str, Matcher<String> matcher) {
        return HasXPath.hasXPath(str, matcher);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4) {
        return AllOf.allOf(matcher, matcher2, matcher3, matcher4);
    }

    public static <T> AnyOf<T> anyOf(Matcher<T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4, Matcher<? super T> matcher5, Matcher<? super T> matcher6) {
        return AnyOf.anyOf(matcher, matcher2, matcher3, matcher4, matcher5, matcher6);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4, Matcher<? super T> matcher5) {
        return AllOf.allOf(matcher, matcher2, matcher3, matcher4, matcher5);
    }

    public static <T> AnyOf<T> anyOf(Matcher<T> matcher, Matcher<? super T> matcher2) {
        return AnyOf.anyOf(matcher, matcher2);
    }

    public static <T> Matcher<T> allOf(Matcher<? super T> matcher, Matcher<? super T> matcher2, Matcher<? super T> matcher3, Matcher<? super T> matcher4, Matcher<? super T> matcher5, Matcher<? super T> matcher6) {
        return AllOf.allOf(matcher, matcher2, matcher3, matcher4, matcher5, matcher6);
    }

    public static <T> AnyOf<T> anyOf(Matcher<? super T>... matcherArr) {
        return AnyOf.anyOf(matcherArr);
    }
}
