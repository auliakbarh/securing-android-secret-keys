package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aG\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a;\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aO\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a3\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a=\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a;\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001aE\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a9\u0010I\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010E\u001aA\u0010K\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001aA\u0010N\u001a\u00020#*\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a1\u0010S\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010U\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", NotificationCompat.CATEGORY_PROGRESS, "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorWidth = Dp.m4872constructorimpl(240);
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m1944getTrackHeightD9Ej5fM();
    private static final float CircularIndicatorDiameter = Dp.m4872constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m1716getSizeD9Ej5fM() - Dp.m4872constructorimpl(CircularProgressIndicatorTokens.INSTANCE.m1715getActiveIndicatorWidthD9Ej5fM() * 2));
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: access$drawCircularIndicatorTrack-bw27NRU */
    public static final /* synthetic */ void m1339access$drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m1345drawCircularIndicatorTrackbw27NRU(drawScope, j, stroke);
    }

    /* renamed from: access$drawDeterminateCircularIndicator-42QJj7c */
    public static final /* synthetic */ void m1340access$drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1346drawDeterminateCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* renamed from: access$drawIndeterminateCircularIndicator-hrjfTZI */
    public static final /* synthetic */ void m1341access$drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1347drawIndeterminateCircularIndicatorhrjfTZI(drawScope, f, f2, f3, j, stroke);
    }

    /* renamed from: access$drawLinearIndicator-qYKTg0g */
    public static final /* synthetic */ void m1342access$drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        m1348drawLinearIndicatorqYKTg0g(drawScope, f, f2, j, f3, i);
    }

    /* renamed from: access$drawLinearIndicatorTrack-AZGd3zU */
    public static final /* synthetic */ void m1343access$drawLinearIndicatorTrackAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m1349drawLinearIndicatorTrackAZGd3zU(drawScope, j, f, i);
    }

    public static final /* synthetic */ CubicBezierEasing access$getCircularEasing$p() {
        return CircularEasing;
    }

    public static final /* synthetic */ CubicBezierEasing access$getFirstLineHeadEasing$p() {
        return FirstLineHeadEasing;
    }

    public static final /* synthetic */ CubicBezierEasing access$getFirstLineTailEasing$p() {
        return FirstLineTailEasing;
    }

    public static final /* synthetic */ CubicBezierEasing access$getSecondLineHeadEasing$p() {
        return SecondLineHeadEasing;
    }

    public static final /* synthetic */ CubicBezierEasing access$getSecondLineTailEasing$p() {
        return SecondLineTailEasing;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0139 A[LOOP:0: B:181:0x0137->B:182:0x0139, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* renamed from: LinearProgressIndicator-_5eSR-E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1337LinearProgressIndicator_5eSRE(final float r16, androidx.compose.ui.Modifier r17, long r18, long r20, int r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1337LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e8 A[LOOP:0: B:169:0x01e5->B:171:0x01e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* renamed from: LinearProgressIndicator-2cYBFYY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1335LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier r21, long r22, long r24, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1335LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m1338LinearProgressIndicatoreaDK9VM(final float r20, androidx.compose.ui.Modifier r21, long r22, long r24, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1338LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk */
    public static final /* synthetic */ void m1336LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        long j3;
        long j4;
        Modifier.Companion companion;
        long j5;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)208@8403L11,209@8466L16,210@8488L126:ProgressIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 14) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            j3 = j;
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            companion = obj;
            j5 = j3;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                companion = obj;
            }
            int i5 = i3;
            j5 = j3;
            long j6 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i5, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:206)");
            }
            m1335LinearProgressIndicator2cYBFYY(companion, j5, j6, ProgressIndicatorDefaults.INSTANCE.m1330getLinearStrokeCapKaPHkGw(), startRestartGroup, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = companion;
        final long j7 = j5;
        final long j8 = j4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                ProgressIndicatorKt.m1336LinearProgressIndicatorRIQooxk(Modifier.this, j7, j8, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* renamed from: drawLinearIndicator-qYKTg0g */
    public static final void m1348drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float m2458getWidthimpl = Size.m2458getWidthimpl(drawScope.mo3171getSizeNHjbRc());
        float m2455getHeightimpl = Size.m2455getHeightimpl(drawScope.mo3171getSizeNHjbRc());
        float f4 = 2;
        float f5 = m2455getHeightimpl / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * m2458getWidthimpl;
        float f7 = (z ? f2 : 1.0f - f) * m2458getWidthimpl;
        if (StrokeCap.m2970equalsimpl0(i, StrokeCap.Companion.m2974getButtKaPHkGw()) || m2455getHeightimpl > m2458getWidthimpl) {
            DrawScope.m3158drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(f8, m2458getWidthimpl - f8);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m3158drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    /* renamed from: drawLinearIndicatorTrack-AZGd3zU */
    public static final void m1349drawLinearIndicatorTrackAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m1348drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* renamed from: CircularProgressIndicator-DUhRLBM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1331CircularProgressIndicatorDUhRLBM(final float r18, androidx.compose.ui.Modifier r19, long r20, float r22, long r23, int r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1331CircularProgressIndicatorDUhRLBM(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* renamed from: CircularProgressIndicator-LxG7B9w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1332CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1332CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m1333CircularProgressIndicatorMBs18nI(final float r20, androidx.compose.ui.Modifier r21, long r22, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1333CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m1334CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r19, long r20, float r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1334CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: drawCircularIndicator-42QJj7c */
    private static final void m1344drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float m2458getWidthimpl = Size.m2458getWidthimpl(drawScope.mo3171getSizeNHjbRc()) - (f3 * width);
        DrawScope.m3151drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), SizeKt.Size(m2458getWidthimpl, m2458getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* renamed from: drawCircularIndicatorTrack-bw27NRU */
    public static final void m1345drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m1344drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* renamed from: drawDeterminateCircularIndicator-42QJj7c */
    public static final void m1346drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1344drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI */
    public static final void m1347drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1344drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m2970equalsimpl0(stroke.m3234getCapKaPHkGw(), StrokeCap.Companion.m2974getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m4872constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }
}