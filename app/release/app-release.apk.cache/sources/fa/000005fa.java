package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyListItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J<\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u001bJ\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002JE\u0010(\u001a\u00020\u001b*\u00020\u000e26\u0010)\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001b0*H\u0082\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "()V", "activeKeys", "", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "placeableIndex", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Set<Object> activeKeys = new LinkedHashSet();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    public static final /* synthetic */ LazyLayoutKeyIndexMap access$getKeyIndexMap$p(LazyListItemPlacementAnimator lazyListItemPlacementAnimator) {
        return lazyListItemPlacementAnimator.keyIndexMap;
    }

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyListMeasuredItem lazyListMeasuredItem, int i) {
        long m4986copyiSbpLlY$default;
        long m589getOffsetBjo55l4 = lazyListMeasuredItem.m589getOffsetBjo55l4(0);
        if (lazyListMeasuredItem.isVertical()) {
            m4986copyiSbpLlY$default = IntOffset.m4986copyiSbpLlY$default(m589getOffsetBjo55l4, 0, i, 1, null);
        } else {
            m4986copyiSbpLlY$default = IntOffset.m4986copyiSbpLlY$default(m589getOffsetBjo55l4, i, 0, 2, null);
        }
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i2));
            if (node != null) {
                long m589getOffsetBjo55l42 = lazyListMeasuredItem.m589getOffsetBjo55l4(i2);
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m589getOffsetBjo55l42) - IntOffset.m4990getXimpl(m589getOffsetBjo55l4), IntOffset.m4991getYimpl(m589getOffsetBjo55l42) - IntOffset.m4991getYimpl(m589getOffsetBjo55l4));
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

    private final void forEachNode(LazyListMeasuredItem lazyListMeasuredItem, Function2<? super Integer, ? super LazyLayoutAnimateItemModifierNode, Unit> function2) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                function2.invoke(Integer.valueOf(i), node);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x003a, code lost:
        r6 = r18.firstVisibleIndex;
        r8 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List<? extends java.lang.Object>) r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0042, code lost:
        if (r8 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0044, code lost:
        r8 = r8.getIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0049, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x004a, code lost:
        r18.firstVisibleIndex = r8;
        r8 = r18.keyIndexMap;
        r18.keyIndexMap = r23.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0054, code lost:
        if (r24 == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0056, code lost:
        r9 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0058, code lost:
        r9 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0059, code lost:
        if (r24 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x005b, code lost:
        r10 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0060, code lost:
        r10 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r19, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0064, code lost:
        r18.movingAwayKeys.addAll(r18.activeKeys);
        r1 = r22.size();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0073, code lost:
        if (r12 >= r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0075, code lost:
        r14 = r4.get(r12);
        r18.movingAwayKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0088, code lost:
        if (getHasAnimations(r14) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0094, code lost:
        if (r18.activeKeys.contains(r14.getKey()) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0096, code lost:
        r18.activeKeys.add(r14.getKey());
        r7 = r8.getIndex(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x00a9, code lost:
        if (r7 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00af, code lost:
        if (r14.getIndex() == r7) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00b1, code lost:
        if (r7 >= r6) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00b3, code lost:
        r18.movingInFromStartBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00b9, code lost:
        r18.movingInFromEndBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00bf, code lost:
        r15 = r14.m589getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00c8, code lost:
        if (r14.isVertical() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x00ca, code lost:
        r13 = androidx.compose.ui.unit.IntOffset.m4991getYimpl(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x00cf, code lost:
        r13 = androidx.compose.ui.unit.IntOffset.m4990getXimpl(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x00d3, code lost:
        initializeNode(r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x00d6, code lost:
        r19 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x00d9, code lost:
        r13 = r14.getPlaceablesCount();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x00df, code lost:
        if (r15 >= r13) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x00e1, code lost:
        r7 = getNode(r14.getParentData(r15));
        r19 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x00eb, code lost:
        if (r7 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x00fb, code lost:
        if (androidx.compose.ui.unit.IntOffset.m4989equalsimpl0(r7.m625getRawOffsetnOccac(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.Companion.m627getNotInitializednOccac()) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00fd, code lost:
        r1 = r7.m625getRawOffsetnOccac();
        r7.m626setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m4990getXimpl(r1) + androidx.compose.ui.unit.IntOffset.m4990getXimpl(r10), androidx.compose.ui.unit.IntOffset.m4991getYimpl(r1) + androidx.compose.ui.unit.IntOffset.m4991getYimpl(r10)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x011a, code lost:
        r15 = r15 + 1;
        r1 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0126, code lost:
        r19 = r1;
        startAnimationsIfNeeded(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x012c, code lost:
        r19 = r1;
        r18.activeKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0137, code lost:
        r12 = r12 + 1;
        r1 = r19;
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0144, code lost:
        r1 = r18.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x014b, code lost:
        if (r1.size() <= 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x014d, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0157, code lost:
        r1 = r18.movingInFromStartBound;
        r2 = r1.size();
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x015f, code lost:
        if (r4 >= r2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0161, code lost:
        r7 = r1.get(r4);
        r6 = r6 + r7.getSize();
        initializeNode(r7, 0 - r6);
        startAnimationsIfNeeded(r7);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0177, code lost:
        r1 = r18.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x017d, code lost:
        if (r1.size() <= 1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x017f, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0189, code lost:
        r1 = r18.movingInFromEndBound;
        r2 = r1.size();
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0191, code lost:
        if (r4 >= r2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0193, code lost:
        r7 = r1.get(r4);
        r10 = r9 + r6;
        r6 = r6 + r7.getSize();
        initializeNode(r7, r10);
        startAnimationsIfNeeded(r7);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x01a9, code lost:
        r1 = r18.movingAwayKeys.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x01b5, code lost:
        if (r1.hasNext() == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x01b7, code lost:
        r2 = r1.next();
        r4 = r18.keyIndexMap.getIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x01c1, code lost:
        if (r4 != (-1)) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x01c3, code lost:
        r18.activeKeys.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x01c9, code lost:
        r6 = r23.getAndMeasure(r4);
        r7 = r6.getPlaceablesCount();
        r10 = 0;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x01d3, code lost:
        if (r10 >= r7) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x01d5, code lost:
        r12 = getNode(r6.getParentData(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x01dd, code lost:
        if (r12 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x01e3, code lost:
        if (r12.isAnimationInProgress() != true) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x01e5, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x01e6, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x01e9, code lost:
        if (r11 != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x01ef, code lost:
        if (r4 != r8.getIndex(r2)) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x01f1, code lost:
        r18.activeKeys.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x01f9, code lost:
        if (r4 >= r18.firstVisibleIndex) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x01fb, code lost:
        r18.movingAwayToStartBound.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0201, code lost:
        r18.movingAwayToEndBound.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0207, code lost:
        r1 = r18.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x020d, code lost:
        if (r1.size() <= 1) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x020f, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0219, code lost:
        r1 = r18.movingAwayToStartBound;
        r2 = r1.size();
        r4 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0221, code lost:
        if (r4 >= r2) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0223, code lost:
        r6 = r1.get(r4);
        r5 = r5 + r6.getSize();
        r6.position(0 - r5, r20, r21);
        r22.add(r6);
        startAnimationsIfNeeded(r6);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0242, code lost:
        r1 = r18.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x024e, code lost:
        if (r1.size() <= 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0250, code lost:
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x025a, code lost:
        r1 = r18.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0263, code lost:
        if (r3 >= r2) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0265, code lost:
        r4 = r1.get(r3);
        r5 = r9 + r16;
        r16 = r16 + r4.getSize();
        r4.position(r5, r20, r21);
        r22.add(r4);
        startAnimationsIfNeeded(r4);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x027f, code lost:
        r18.movingInFromStartBound.clear();
        r18.movingInFromEndBound.clear();
        r18.movingAwayToStartBound.clear();
        r18.movingAwayToEndBound.clear();
        r18.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0298, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasured(int r19, int r20, int r21, java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r22, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean):void");
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                long m589getOffsetBjo55l4 = lazyListMeasuredItem.m589getOffsetBjo55l4(i);
                long m625getRawOffsetnOccac = node.m625getRawOffsetnOccac();
                if (!IntOffset.m4989equalsimpl0(m625getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m627getNotInitializednOccac()) && !IntOffset.m4989equalsimpl0(m625getRawOffsetnOccac, m589getOffsetBjo55l4)) {
                    node.m623animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m589getOffsetBjo55l4) - IntOffset.m4990getXimpl(m625getRawOffsetnOccac), IntOffset.m4991getYimpl(m589getOffsetBjo55l4) - IntOffset.m4991getYimpl(m625getRawOffsetnOccac)));
                }
                node.m626setRawOffsetgyyYBs(m589getOffsetBjo55l4);
            }
        }
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyListMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }
}