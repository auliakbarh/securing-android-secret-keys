package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010+\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0-H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public static final /* synthetic */ LazyLayoutKeyIndexMap access$getKeyIndexMap$p(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        return lazyGridItemPlacementAnimator.keyIndexMap;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyGridMeasuredItem lazyGridMeasuredItem, int i) {
        long m4986copyiSbpLlY$default;
        long mo611getOffsetnOccac = lazyGridMeasuredItem.mo611getOffsetnOccac();
        if (lazyGridMeasuredItem.isVertical()) {
            m4986copyiSbpLlY$default = IntOffset.m4986copyiSbpLlY$default(mo611getOffsetnOccac, 0, i, 1, null);
        } else {
            m4986copyiSbpLlY$default = IntOffset.m4986copyiSbpLlY$default(mo611getOffsetnOccac, i, 0, 2, null);
        }
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i2));
            if (node != null) {
                long mo611getOffsetnOccac2 = lazyGridMeasuredItem.mo611getOffsetnOccac();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(mo611getOffsetnOccac2) - IntOffset.m4990getXimpl(mo611getOffsetnOccac), IntOffset.m4991getYimpl(mo611getOffsetnOccac2) - IntOffset.m4991getYimpl(mo611getOffsetnOccac));
                node.m626setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m4986copyiSbpLlY$default) + IntOffset.m4990getXimpl(IntOffset), IntOffset.m4991getYimpl(m4986copyiSbpLlY$default) + IntOffset.m4991getYimpl(IntOffset)));
            }
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object obj) {
        if (obj instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) obj;
        }
        return null;
    }

    private final void forEachNode(LazyGridMeasuredItem lazyGridMeasuredItem, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> function1) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i));
            if (node != null) {
                function1.invoke(node);
            }
        }
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyGridMeasuredItem> list, LazyGridMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, boolean z) {
        long IntOffset;
        int i4;
        long m4837fixedHeightOenEA2s;
        int i5;
        int i6;
        List<LazyGridMeasuredItem> positionedItems = list;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        int size = list.size();
        int i7 = 0;
        while (true) {
            if (i7 < size) {
                if (getHasAnimations(positionedItems.get(i7))) {
                    break;
                }
                i7++;
            } else if (this.keyToItemInfoMap.isEmpty()) {
                reset();
                return;
            }
        }
        int i8 = this.firstVisibleIndex;
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.firstOrNull((List<? extends Object>) list);
        this.firstVisibleIndex = lazyGridMeasuredItem != null ? lazyGridMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = itemProvider.getKeyIndexMap();
        int i9 = z ? i3 : i2;
        if (z) {
            IntOffset = IntOffsetKt.IntOffset(0, i);
        } else {
            IntOffset = IntOffsetKt.IntOffset(i, 0);
        }
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = list.size();
        int i10 = 0;
        while (i10 < size2) {
            LazyGridMeasuredItem lazyGridMeasuredItem2 = positionedItems.get(i10);
            this.movingAwayKeys.remove(lazyGridMeasuredItem2.getKey());
            if (getHasAnimations(lazyGridMeasuredItem2)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridMeasuredItem2.getKey());
                if (itemInfo == null) {
                    i5 = size2;
                    this.keyToItemInfoMap.put(lazyGridMeasuredItem2.getKey(), new ItemInfo(lazyGridMeasuredItem2.getCrossAxisSize(), lazyGridMeasuredItem2.getCrossAxisOffset()));
                    int index = lazyLayoutKeyIndexMap.getIndex(lazyGridMeasuredItem2.getKey());
                    if (index == -1 || lazyGridMeasuredItem2.getIndex() == index) {
                        long mo611getOffsetnOccac = lazyGridMeasuredItem2.mo611getOffsetnOccac();
                        initializeNode(lazyGridMeasuredItem2, lazyGridMeasuredItem2.isVertical() ? IntOffset.m4991getYimpl(mo611getOffsetnOccac) : IntOffset.m4990getXimpl(mo611getOffsetnOccac));
                    } else if (index < i8) {
                        this.movingInFromStartBound.add(lazyGridMeasuredItem2);
                    } else {
                        this.movingInFromEndBound.add(lazyGridMeasuredItem2);
                    }
                } else {
                    i5 = size2;
                    int placeablesCount = lazyGridMeasuredItem2.getPlaceablesCount();
                    int i11 = 0;
                    while (i11 < placeablesCount) {
                        LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem2.getParentData(i11));
                        if (node != null) {
                            i6 = placeablesCount;
                            if (!IntOffset.m4989equalsimpl0(node.m625getRawOffsetnOccac(), LazyLayoutAnimateItemModifierNode.Companion.m627getNotInitializednOccac())) {
                                long m625getRawOffsetnOccac = node.m625getRawOffsetnOccac();
                                node.m626setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m625getRawOffsetnOccac) + IntOffset.m4990getXimpl(IntOffset), IntOffset.m4991getYimpl(m625getRawOffsetnOccac) + IntOffset.m4991getYimpl(IntOffset)));
                            }
                        } else {
                            i6 = placeablesCount;
                        }
                        i11++;
                        placeablesCount = i6;
                    }
                    itemInfo.setCrossAxisSize(lazyGridMeasuredItem2.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(lazyGridMeasuredItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyGridMeasuredItem2);
                }
            } else {
                i5 = size2;
                this.keyToItemInfoMap.remove(lazyGridMeasuredItem2.getKey());
            }
            i10++;
            positionedItems = list;
            size2 = i5;
        }
        List<LazyGridMeasuredItem> list2 = this.movingInFromStartBound;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(((LazyGridMeasuredItem) t2).getKey())), Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(((LazyGridMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list3 = this.movingInFromStartBound;
        int size3 = list3.size();
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < size3; i15++) {
            LazyGridMeasuredItem lazyGridMeasuredItem3 = list3.get(i15);
            int row = z ? lazyGridMeasuredItem3.getRow() : lazyGridMeasuredItem3.getColumn();
            if (row != -1 && row == i12) {
                i14 = Math.max(i14, lazyGridMeasuredItem3.getMainAxisSize());
            } else {
                i13 += i14;
                i14 = lazyGridMeasuredItem3.getMainAxisSize();
                i12 = row;
            }
            initializeNode(lazyGridMeasuredItem3, (0 - i13) - lazyGridMeasuredItem3.getMainAxisSize());
            startAnimationsIfNeeded(lazyGridMeasuredItem3);
        }
        List<LazyGridMeasuredItem> list4 = this.movingInFromEndBound;
        if (list4.size() > 1) {
            CollectionsKt.sortWith(list4, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(((LazyGridMeasuredItem) t).getKey())), Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(((LazyGridMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list5 = this.movingInFromEndBound;
        int size4 = list5.size();
        int i16 = 0;
        int i17 = 0;
        int i18 = -1;
        for (int i19 = 0; i19 < size4; i19++) {
            LazyGridMeasuredItem lazyGridMeasuredItem4 = list5.get(i19);
            int row2 = z ? lazyGridMeasuredItem4.getRow() : lazyGridMeasuredItem4.getColumn();
            if (row2 != -1 && row2 == i18) {
                i17 = Math.max(i17, lazyGridMeasuredItem4.getMainAxisSize());
            } else {
                i16 += i17;
                i17 = lazyGridMeasuredItem4.getMainAxisSize();
                i18 = row2;
            }
            initializeNode(lazyGridMeasuredItem4, i9 + i16);
            startAnimationsIfNeeded(lazyGridMeasuredItem4);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                if (z) {
                    m4837fixedHeightOenEA2s = Constraints.Companion.m4838fixedWidthOenEA2s(itemInfo2.getCrossAxisSize());
                } else {
                    m4837fixedHeightOenEA2s = Constraints.Companion.m4837fixedHeightOenEA2s(itemInfo2.getCrossAxisSize());
                }
                LazyGridMeasuredItem m617getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m617getAndMeasure3p2s80s$default(itemProvider, index2, 0, m4837fixedHeightOenEA2s, 2, null);
                int placeablesCount2 = m617getAndMeasure3p2s80s$default.getPlaceablesCount();
                boolean z2 = false;
                for (int i20 = 0; i20 < placeablesCount2; i20++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(m617getAndMeasure3p2s80s$default.getParentData(i20));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z2 = true;
                    }
                }
                if (!z2 && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.keyToItemInfoMap.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m617getAndMeasure3p2s80s$default);
                } else {
                    this.movingAwayToEndBound.add(m617getAndMeasure3p2s80s$default);
                }
            }
        }
        List<LazyGridMeasuredItem> list6 = this.movingAwayToStartBound;
        if (list6.size() > 1) {
            CollectionsKt.sortWith(list6, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyGridItemPlacementAnimator.access$getKeyIndexMap$p(LazyGridItemPlacementAnimator.this).getIndex(((LazyGridMeasuredItem) t2).getKey())), Integer.valueOf(LazyGridItemPlacementAnimator.access$getKeyIndexMap$p(LazyGridItemPlacementAnimator.this).getIndex(((LazyGridMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list7 = this.movingAwayToStartBound;
        int size5 = list7.size();
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        for (int i24 = 0; i24 < size5; i24++) {
            LazyGridMeasuredItem lazyGridMeasuredItem5 = list7.get(i24);
            int lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(lazyGridMeasuredItem5.getIndex());
            if (lineIndexOfItem != -1 && lineIndexOfItem == i23) {
                i22 = Math.max(i22, lazyGridMeasuredItem5.getMainAxisSize());
            } else {
                i21 += i22;
                i22 = lazyGridMeasuredItem5.getMainAxisSize();
                i23 = lineIndexOfItem;
            }
            lazyGridMeasuredItem5.position((0 - i21) - lazyGridMeasuredItem5.getMainAxisSize(), ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyGridMeasuredItem5.getKey())).getCrossAxisOffset(), i2, i3, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
            list.add(lazyGridMeasuredItem5);
            startAnimationsIfNeeded(lazyGridMeasuredItem5);
        }
        List<LazyGridMeasuredItem> list8 = this.movingAwayToEndBound;
        if (list8.size() > 1) {
            CollectionsKt.sortWith(list8, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyGridItemPlacementAnimator.access$getKeyIndexMap$p(LazyGridItemPlacementAnimator.this).getIndex(((LazyGridMeasuredItem) t).getKey())), Integer.valueOf(LazyGridItemPlacementAnimator.access$getKeyIndexMap$p(LazyGridItemPlacementAnimator.this).getIndex(((LazyGridMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list9 = this.movingAwayToEndBound;
        int size6 = list9.size();
        int i25 = -1;
        int i26 = 0;
        i4 = 0;
        for (int i27 = 0; i27 < size6; i27++) {
            LazyGridMeasuredItem lazyGridMeasuredItem6 = list9.get(i27);
            int lineIndexOfItem2 = spanLayoutProvider.getLineIndexOfItem(lazyGridMeasuredItem6.getIndex());
            if (lineIndexOfItem2 != -1 && lineIndexOfItem2 == i25) {
                i26 = Math.max(i26, lazyGridMeasuredItem6.getMainAxisSize());
            } else {
                i4 += i26;
                i26 = lazyGridMeasuredItem6.getMainAxisSize();
                i25 = lineIndexOfItem2;
            }
            lazyGridMeasuredItem6.position(i9 + i4, ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyGridMeasuredItem6.getKey())).getCrossAxisOffset(), i2, i3, (r16 & 16) != 0 ? -1 : 0, (r16 & 32) != 0 ? -1 : 0);
            list.add(lazyGridMeasuredItem6);
            startAnimationsIfNeeded(lazyGridMeasuredItem6);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem lazyGridMeasuredItem) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i));
            if (node != null) {
                long mo611getOffsetnOccac = lazyGridMeasuredItem.mo611getOffsetnOccac();
                long m625getRawOffsetnOccac = node.m625getRawOffsetnOccac();
                if (!IntOffset.m4989equalsimpl0(m625getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m627getNotInitializednOccac()) && !IntOffset.m4989equalsimpl0(m625getRawOffsetnOccac, mo611getOffsetnOccac)) {
                    node.m623animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(mo611getOffsetnOccac) - IntOffset.m4990getXimpl(m625getRawOffsetnOccac), IntOffset.m4991getYimpl(mo611getOffsetnOccac) - IntOffset.m4991getYimpl(m625getRawOffsetnOccac)));
                }
                node.m626setRawOffsetgyyYBs(mo611getOffsetnOccac);
            }
        }
    }

    private final boolean getHasAnimations(LazyGridMeasuredItem lazyGridMeasuredItem) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }
}