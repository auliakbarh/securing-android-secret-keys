package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ak\u0010#\u001a\u00020\u00132\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0003¢\u0006\u0002\u0010-\u001a\u0083\u0001\u0010.\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020*2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001a;\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aS\u0010B\u001a\u000208*\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarItemVerticalPadding", "getNavigationBarItemVerticalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemBaselineLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, "Lkotlin/Function0;", NavigationBarKt.IndicatorLayoutIdTag, NavigationBarKt.IconLayoutIdTag, NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m1965getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m4872constructorimpl(8);
    private static final float NavigationBarItemVerticalPadding = Dp.m4872constructorimpl(16);
    private static final float IndicatorVerticalOffset = Dp.m4872constructorimpl(12);

    public static final /* synthetic */ void access$NavigationBarItem$lambda$4(MutableState mutableState, int i) {
        NavigationBarItem$lambda$4(mutableState, i);
    }

    public static final /* synthetic */ float access$NavigationBarItem$lambda$9$lambda$6(State state) {
        return NavigationBarItem$lambda$9$lambda$6(state);
    }

    public static final /* synthetic */ void access$NavigationBarItemBaselineLayout(Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z, float f, Composer composer, int i) {
        NavigationBarItemBaselineLayout(function2, function22, function23, function24, z, f, composer, i);
    }

    public static final /* synthetic */ float access$getIndicatorHorizontalPadding$p() {
        return IndicatorHorizontalPadding;
    }

    public static final /* synthetic */ float access$getIndicatorVerticalPadding$p() {
        return IndicatorVerticalPadding;
    }

    public static final /* synthetic */ float access$getNavigationBarHeight$p() {
        return NavigationBarHeight;
    }

    /* renamed from: access$placeIcon-X9ElhV4 */
    public static final /* synthetic */ MeasureResult m1291access$placeIconX9ElhV4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, long j) {
        return m1293placeIconX9ElhV4(measureScope, placeable, placeable2, placeable3, j);
    }

    /* renamed from: access$placeLabelAndIcon-zUg2_y0 */
    public static final /* synthetic */ MeasureResult m1292access$placeLabelAndIconzUg2_y0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, long j, boolean z, float f) {
        return m1294placeLabelAndIconzUg2_y0(measureScope, placeable, placeable2, placeable3, placeable4, j, z, f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* renamed from: NavigationBar-HsRjFd4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1290NavigationBarHsRjFd4(androidx.compose.ui.Modifier r25, long r26, long r28, float r30, androidx.compose.foundation.layout.WindowInsets r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m1290NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:369:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NavigationBarItem(final androidx.compose.foundation.layout.RowScope r36, final boolean r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, boolean r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, boolean r43, androidx.compose.material3.NavigationBarItemColors r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationBarItem$lambda$3(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    public static final void NavigationBarItem$lambda$4(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    public static final void NavigationBarItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(591111291);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItemBaselineLayout)P(4,3,2,5)434@18867L2465:NavigationBar.kt#uh7d8r");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591111291, i2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:426)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemBaselineLayout$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo10measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                    Object obj;
                    Placeable placeable;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    for (Measurable measurable : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                            Placeable mo3865measureBRTryo0 = measurable.mo3865measureBRTryo0(j);
                            float f2 = 2;
                            int width = mo3865measureBRTryo0.getWidth() + Layout.mo318roundToPx0680j_4(Dp.m4872constructorimpl(NavigationBarKt.access$getIndicatorHorizontalPadding$p() * f2));
                            int roundToInt = MathKt.roundToInt(width * f);
                            int height = mo3865measureBRTryo0.getHeight() + Layout.mo318roundToPx0680j_4(Dp.m4872constructorimpl(NavigationBarKt.access$getIndicatorVerticalPadding$p() * f2));
                            for (Measurable measurable2 : list) {
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "indicatorRipple")) {
                                    Placeable mo3865measureBRTryo02 = measurable2.mo3865measureBRTryo0(Constraints.Companion.m4836fixedJhjzzOo(width, height));
                                    Iterator<T> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it.next();
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "indicator")) {
                                            break;
                                        }
                                    }
                                    Measurable measurable3 = (Measurable) obj;
                                    Placeable mo3865measureBRTryo03 = measurable3 != null ? measurable3.mo3865measureBRTryo0(Constraints.Companion.m4836fixedJhjzzOo(roundToInt, height)) : null;
                                    if (function24 != null) {
                                        for (Measurable measurable4 : list) {
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "label")) {
                                                placeable = measurable4.mo3865measureBRTryo0(Constraints.m4819copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    placeable = null;
                                    if (function24 == null) {
                                        return NavigationBarKt.m1291access$placeIconX9ElhV4(Layout, mo3865measureBRTryo0, mo3865measureBRTryo02, mo3865measureBRTryo03, j);
                                    }
                                    Intrinsics.checkNotNull(placeable);
                                    return NavigationBarKt.m1292access$placeLabelAndIconzUg2_y0(Layout, placeable, mo3865measureBRTryo0, mo3865measureBRTryo02, mo3865measureBRTryo03, j, z, f);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2262constructorimpl = Updater.m2262constructorimpl(startRestartGroup);
            Updater.m2269setimpl(m2262constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2269setimpl(m2262constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2269setimpl(m2262constructorimpl, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2269setimpl(m2262constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -311734425, "C435@18884L17,440@18982L50:NavigationBar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.startReplaceableGroup(-311734399);
            ComposerKt.sourceInformation(startRestartGroup, "437@18951L11");
            if (f > 0.0f) {
                function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, IconLayoutIdTag);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(layoutId);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2262constructorimpl2 = Updater.m2262constructorimpl(startRestartGroup);
            Updater.m2269setimpl(m2262constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2269setimpl(m2262constructorimpl2, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2269setimpl(m2262constructorimpl2, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2269setimpl(m2262constructorimpl2, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248851348, "C440@19024L6:NavigationBar.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1204551908);
            ComposerKt.sourceInformation(startRestartGroup, "443@19075L260");
            if (function24 != null) {
                Modifier m481paddingVpY3zN4$default = PaddingKt.m481paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, LabelLayoutIdTag), z ? 1.0f : f), Dp.m4872constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(m481paddingVpY3zN4$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl3 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl3, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl3, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl3, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248851650, "C448@19326L7:NavigationBar.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemBaselineLayout$3
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
                NavigationBarKt.access$NavigationBarItemBaselineLayout(function2, function22, function23, function24, z, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* renamed from: placeIcon-X9ElhV4 */
    public static final MeasureResult m1293placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int m4828getMaxWidthimpl = Constraints.m4828getMaxWidthimpl(j);
        final int m4827getMaxHeightimpl = Constraints.m4827getMaxHeightimpl(j);
        final int width = (m4828getMaxWidthimpl - placeable.getWidth()) / 2;
        final int height = (m4827getMaxHeightimpl - placeable.getHeight()) / 2;
        final int width2 = (m4828getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int height2 = (m4827getMaxHeightimpl - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, m4828getMaxWidthimpl, m4827getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable4 = Placeable.this;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable4, (m4828getMaxWidthimpl - placeable4.getWidth()) / 2, (m4827getMaxHeightimpl - placeable4.getHeight()) / 2, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable, width, height, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* renamed from: placeLabelAndIcon-zUg2_y0 */
    public static final MeasureResult m1294placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        int m4827getMaxHeightimpl = Constraints.m4827getMaxHeightimpl(j);
        float f2 = NavigationBarItemVerticalPadding;
        final int height = (m4827getMaxHeightimpl - placeable.getHeight()) - measureScope.mo318roundToPx0680j_4(f2);
        final int i = measureScope.mo318roundToPx0680j_4(f2);
        final int roundToInt = MathKt.roundToInt(((z ? i : (m4827getMaxHeightimpl - placeable2.getHeight()) / 2) - i) * (1 - f));
        final int m4828getMaxWidthimpl = Constraints.m4828getMaxWidthimpl(j);
        final int width = (m4828getMaxWidthimpl - placeable.getWidth()) / 2;
        final int width2 = (m4828getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int width3 = (m4828getMaxWidthimpl - placeable3.getWidth()) / 2;
        final int i2 = i - measureScope.mo318roundToPx0680j_4(IndicatorVerticalPadding);
        return MeasureScope.layout$default(measureScope, m4828getMaxWidthimpl, m4827getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    int i3 = m4828getMaxWidthimpl;
                    int i4 = i;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(layout, placeable5, (i3 - placeable5.getWidth()) / 2, roundToInt + (i4 - measureScope2.mo318roundToPx0680j_4(NavigationBarKt.access$getIndicatorVerticalPadding$p())), 0.0f, 4, null);
                }
                if (z || f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, width, height + roundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, placeable2, width2, i + roundToInt, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, placeable3, width3, i2 + roundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 2;
        IndicatorHorizontalPadding = Dp.m4872constructorimpl(Dp.m4872constructorimpl(NavigationBarTokens.INSTANCE.m1963getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m1966getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m4872constructorimpl(Dp.m4872constructorimpl(NavigationBarTokens.INSTANCE.m1962getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m1966getIconSizeD9Ej5fM()) / f);
    }

    public static final float NavigationBarItem$lambda$9$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}