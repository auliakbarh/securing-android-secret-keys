package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010!\u001a\u008d\u0001\u0010\"\u001a\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0#¢\u0006\u0002\b\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    public static final /* synthetic */ void access$ScrollPositionUpdater(Function0 function0, LazyListState lazyListState, Composer composer, int i) {
        ScrollPositionUpdater(function0, lazyListState, composer, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:351:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LazyList(final androidx.compose.ui.Modifier r31, final androidx.compose.foundation.lazy.LazyListState r32, final androidx.compose.foundation.layout.PaddingValues r33, final boolean r34, final boolean r35, final androidx.compose.foundation.gestures.FlingBehavior r36, final boolean r37, int r38, androidx.compose.ui.Alignment.Horizontal r39, androidx.compose.foundation.layout.Arrangement.Vertical r40, androidx.compose.ui.Alignment.Vertical r41, androidx.compose.foundation.layout.Arrangement.Horizontal r42, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, final int r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, int, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void ScrollPositionUpdater(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-331135862);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331135862, i, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)");
            }
            LazyListItemProvider invoke = function0.invoke();
            if (invoke.getItemCount() > 0) {
                LazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyListState, invoke, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                LazyListKt.access$ScrollPositionUpdater(function0, lazyListState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(183156450);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(5,7,1,6,4!2,8)173@7248L7052:LazyList.kt#428nma");
        final Alignment.Horizontal horizontal3 = (i3 & 64) != 0 ? null : horizontal;
        final Alignment.Vertical vertical3 = (i3 & 128) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i3 & 256) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i3 & 512) == 0 ? vertical2 : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        }
        Object[] objArr = {lazyListState, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i4 = 0; i4 < 8; i4++) {
            z3 |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            final Arrangement.Vertical vertical5 = vertical4;
            final Arrangement.Horizontal horizontal5 = horizontal4;
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m583invoke0kLqBqw(lazyLayoutMeasureScope, constraints.m4834unboximpl());
                }

                /* renamed from: invoke-0kLqBqw  reason: not valid java name */
                public final LazyListMeasureResult m583invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    float mo396getSpacingD9Ej5fM;
                    int m4828getMaxWidthimpl;
                    long IntOffset;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m186checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(paddingValues.mo430calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i6 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(paddingValues.mo431calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(paddingValues.mo432calculateTopPaddingD9Ej5fM());
                    int i8 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(paddingValues.mo429calculateBottomPaddingD9Ej5fM());
                    final int i9 = i7 + i8;
                    final int i10 = i5 + i6;
                    boolean z4 = z2;
                    int i11 = z4 ? i9 : i10;
                    int i12 = (!z4 || z) ? (z4 && z) ? i8 : (z4 || z) ? i6 : i5 : i7;
                    int i13 = i11 - i12;
                    long m4844offsetNN6EwU = ConstraintsKt.m4844offsetNN6EwU(j, -i10, -i9);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyListState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    LazyListItemProvider invoke = function0.invoke();
                    invoke.getItemScope().setMaxSize(Constraints.m4828getMaxWidthimpl(m4844offsetNN6EwU), Constraints.m4827getMaxHeightimpl(m4844offsetNN6EwU));
                    if (z2) {
                        Arrangement.Vertical vertical6 = vertical5;
                        if (vertical6 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        mo396getSpacingD9Ej5fM = vertical6.mo396getSpacingD9Ej5fM();
                    } else {
                        Arrangement.Horizontal horizontal6 = horizontal5;
                        if (horizontal6 != null) {
                            mo396getSpacingD9Ej5fM = horizontal6.mo396getSpacingD9Ej5fM();
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    int i14 = lazyLayoutMeasureScope.mo318roundToPx0680j_4(mo396getSpacingD9Ej5fM);
                    int itemCount = invoke.getItemCount();
                    if (z2) {
                        m4828getMaxWidthimpl = Constraints.m4827getMaxHeightimpl(j) - i9;
                    } else {
                        m4828getMaxWidthimpl = Constraints.m4828getMaxWidthimpl(j) - i10;
                    }
                    int i15 = m4828getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        IntOffset = IntOffsetKt.IntOffset(i5, i7);
                    } else {
                        boolean z5 = z2;
                        if (!z5) {
                            i5 += i15;
                        }
                        if (z5) {
                            i7 += i15;
                        }
                        IntOffset = IntOffsetKt.IntOffset(i5, i7);
                    }
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m4844offsetNN6EwU, z2, invoke, lazyLayoutMeasureScope, itemCount, i14, horizontal3, vertical3, z, i12, i13, IntOffset) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$isVertical = r3;
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$itemsCount = itemCount;
                            this.$spaceBetweenItems = i14;
                            this.$horizontalAlignment = r8;
                            this.$verticalAlignment = r9;
                            this.$reverseLayout = r10;
                            this.$beforeContentPadding = i12;
                            this.$afterContentPadding = i13;
                            this.$visualItemOffset = IntOffset;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        public LazyListMeasuredItem createItem(int i16, Object key, Object obj, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyListMeasuredItem(i16, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i16 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, obj, null);
                        }
                    };
                    lazyListState.m592setPremeasureConstraintsBRTryo0$foundation_release(lazyListMeasuredItemProvider.m590getChildConstraintsmsEJaDk());
                    Snapshot.Companion companion = Snapshot.Companion;
                    LazyListState lazyListState2 = lazyListState;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState2.getFirstVisibleItemIndex());
                        int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                        LazyListMeasureResult m586measureLazyListCD5nmq0 = LazyListMeasureKt.m586measureLazyListCD5nmq0(itemCount, lazyListMeasuredItemProvider, i15, i12, i13, i14, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, lazyListState.getScrollToBeConsumed$foundation_release(), m4844offsetNN6EwU, z2, invoke.getHeaderIndexes(), vertical5, horizontal5, z, lazyLayoutMeasureScope2, lazyListState.getPlacementAnimator$foundation_release(), i, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, lazyListState.getPinnedItems$foundation_release(), lazyListState.getBeyondBoundsInfo$foundation_release()), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                Intrinsics.checkNotNullParameter(placement, "placement");
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m4842constrainWidthK40F9xA(j, i16 + i10), ConstraintsKt.m4841constrainHeightK40F9xA(j, i17 + i9), MapsKt.emptyMap(), placement);
                            }
                        });
                        lazyListState.applyMeasureResult$foundation_release(m586measureLazyListCD5nmq0);
                        return m586measureLazyListCD5nmq0;
                    } catch (Throwable th) {
                        createNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }
}