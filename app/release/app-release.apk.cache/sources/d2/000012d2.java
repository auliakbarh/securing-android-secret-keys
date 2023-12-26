package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0019\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J)\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo3240getIntrinsicSizeNHjbRc() != Size.Companion.m2466getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo236measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo3865measureBRTryo0 = measurable.mo3865measureBRTryo0(m2299modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measure, mo3865measureBRTryo0.getWidth(), mo3865measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2299modifyConstraintsZezNO4M = m2299modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m4830getMinWidthimpl(m2299modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2299modifyConstraintsZezNO4M = m2299modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m4830getMinWidthimpl(m2299modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2299modifyConstraintsZezNO4M = m2299modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m4829getMinHeightimpl(m2299modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m2299modifyConstraintsZezNO4M = m2299modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m4829getMinHeightimpl(m2299modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m2296calculateScaledSizeE7KxVPU(long j) {
        float m2458getWidthimpl;
        float m2455getHeightimpl;
        if (getUseIntrinsicSize()) {
            if (!m2298hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo3240getIntrinsicSizeNHjbRc())) {
                m2458getWidthimpl = Size.m2458getWidthimpl(j);
            } else {
                m2458getWidthimpl = Size.m2458getWidthimpl(this.painter.mo3240getIntrinsicSizeNHjbRc());
            }
            if (!m2297hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo3240getIntrinsicSizeNHjbRc())) {
                m2455getHeightimpl = Size.m2455getHeightimpl(j);
            } else {
                m2455getHeightimpl = Size.m2455getHeightimpl(this.painter.mo3240getIntrinsicSizeNHjbRc());
            }
            long Size = SizeKt.Size(m2458getWidthimpl, m2455getHeightimpl);
            if (Size.m2458getWidthimpl(j) != 0.0f && Size.m2455getHeightimpl(j) != 0.0f) {
                return ScaleFactorKt.m3956timesUQTWf7w(Size, this.contentScale.mo3856computeScaleFactorH7hwNQA(Size, j));
            }
            return Size.Companion.m2467getZeroNHjbRc();
        }
        return j;
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m2299modifyConstraintsZezNO4M(long j) {
        int m4830getMinWidthimpl;
        int m4829getMinHeightimpl;
        boolean z = true;
        boolean z2 = Constraints.m4824getHasBoundedWidthimpl(j) && Constraints.m4823getHasBoundedHeightimpl(j);
        if (!Constraints.m4826getHasFixedWidthimpl(j) || !Constraints.m4825getHasFixedHeightimpl(j)) {
            z = false;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m4819copyZbe2FdA$default(j, Constraints.m4828getMaxWidthimpl(j), 0, Constraints.m4827getMaxHeightimpl(j), 0, 10, null);
        }
        long mo3240getIntrinsicSizeNHjbRc = this.painter.mo3240getIntrinsicSizeNHjbRc();
        if (m2298hasSpecifiedAndFiniteWidthuvyYCjk(mo3240getIntrinsicSizeNHjbRc)) {
            m4830getMinWidthimpl = MathKt.roundToInt(Size.m2458getWidthimpl(mo3240getIntrinsicSizeNHjbRc));
        } else {
            m4830getMinWidthimpl = Constraints.m4830getMinWidthimpl(j);
        }
        if (m2297hasSpecifiedAndFiniteHeightuvyYCjk(mo3240getIntrinsicSizeNHjbRc)) {
            m4829getMinHeightimpl = MathKt.roundToInt(Size.m2455getHeightimpl(mo3240getIntrinsicSizeNHjbRc));
        } else {
            m4829getMinHeightimpl = Constraints.m4829getMinHeightimpl(j);
        }
        long m2296calculateScaledSizeE7KxVPU = m2296calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m4842constrainWidthK40F9xA(j, m4830getMinWidthimpl), ConstraintsKt.m4841constrainHeightK40F9xA(j, m4829getMinHeightimpl)));
        return Constraints.m4819copyZbe2FdA$default(j, ConstraintsKt.m4842constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m2458getWidthimpl(m2296calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m4841constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m2455getHeightimpl(m2296calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float m2458getWidthimpl;
        float m2455getHeightimpl;
        long m2467getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo3240getIntrinsicSizeNHjbRc = this.painter.mo3240getIntrinsicSizeNHjbRc();
        if (m2298hasSpecifiedAndFiniteWidthuvyYCjk(mo3240getIntrinsicSizeNHjbRc)) {
            m2458getWidthimpl = Size.m2458getWidthimpl(mo3240getIntrinsicSizeNHjbRc);
        } else {
            m2458getWidthimpl = Size.m2458getWidthimpl(contentDrawScope.mo3171getSizeNHjbRc());
        }
        if (m2297hasSpecifiedAndFiniteHeightuvyYCjk(mo3240getIntrinsicSizeNHjbRc)) {
            m2455getHeightimpl = Size.m2455getHeightimpl(mo3240getIntrinsicSizeNHjbRc);
        } else {
            m2455getHeightimpl = Size.m2455getHeightimpl(contentDrawScope.mo3171getSizeNHjbRc());
        }
        long Size = SizeKt.Size(m2458getWidthimpl, m2455getHeightimpl);
        if (Size.m2458getWidthimpl(contentDrawScope.mo3171getSizeNHjbRc()) != 0.0f && Size.m2455getHeightimpl(contentDrawScope.mo3171getSizeNHjbRc()) != 0.0f) {
            m2467getZeroNHjbRc = ScaleFactorKt.m3956timesUQTWf7w(Size, this.contentScale.mo3856computeScaleFactorH7hwNQA(Size, contentDrawScope.mo3171getSizeNHjbRc()));
        } else {
            m2467getZeroNHjbRc = Size.Companion.m2467getZeroNHjbRc();
        }
        long j = m2467getZeroNHjbRc;
        long mo2279alignKFBX0sM = this.alignment.mo2279alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2458getWidthimpl(j)), MathKt.roundToInt(Size.m2455getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2458getWidthimpl(contentDrawScope.mo3171getSizeNHjbRc())), MathKt.roundToInt(Size.m2455getHeightimpl(contentDrawScope.mo3171getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m4990getXimpl = IntOffset.m4990getXimpl(mo2279alignKFBX0sM);
        float m4991getYimpl = IntOffset.m4991getYimpl(mo2279alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(m4990getXimpl, m4991getYimpl);
        this.painter.m3246drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-m4990getXimpl, -m4991getYimpl);
        contentDrawScope.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m2298hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m2454equalsimpl0(j, Size.Companion.m2466getUnspecifiedNHjbRc())) {
            float m2458getWidthimpl = Size.m2458getWidthimpl(j);
            if (!Float.isInfinite(m2458getWidthimpl) && !Float.isNaN(m2458getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m2297hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m2454equalsimpl0(j, Size.Companion.m2466getUnspecifiedNHjbRc())) {
            float m2455getHeightimpl = Size.m2455getHeightimpl(j);
            if (!Float.isInfinite(m2455getHeightimpl) && !Float.isNaN(m2455getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}