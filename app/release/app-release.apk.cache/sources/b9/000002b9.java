package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Border.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JI\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-D9Ej5fM */
    public final float m176getWidthD9Ej5fM() {
        return this.width;
    }

    public static final /* synthetic */ DrawResult access$drawGenericBorder(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope, Brush brush, Outline.Generic generic, boolean z, float f) {
        return borderModifierNode.drawGenericBorder(cacheDrawScope, brush, generic, z, f);
    }

    /* renamed from: access$drawRoundRectBorder-JqoCqck */
    public static final /* synthetic */ DrawResult m174access$drawRoundRectBorderJqoCqck(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope, Brush brush, Outline.Rounded rounded, long j, long j2, boolean z, float f) {
        return borderModifierNode.m175drawRoundRectBorderJqoCqck(cacheDrawScope, brush, rounded, j, j2, z, f);
    }

    private BorderModifierNode(float f, Brush brushParameter, Shape shapeParameter) {
        Intrinsics.checkNotNullParameter(brushParameter, "brushParameter");
        Intrinsics.checkNotNullParameter(shapeParameter, "shapeParameter");
        this.width = f;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope CacheDrawModifierNode) {
                DrawResult drawContentWithoutBorder;
                DrawResult m172drawRectBorderNsqcLGU;
                Intrinsics.checkNotNullParameter(CacheDrawModifierNode, "$this$CacheDrawModifierNode");
                if (CacheDrawModifierNode.mo324toPx0680j_4(BorderModifierNode.this.m176getWidthD9Ej5fM()) < 0.0f || Size.m2457getMinDimensionimpl(CacheDrawModifierNode.m2295getSizeNHjbRc()) <= 0.0f) {
                    drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(CacheDrawModifierNode);
                    return drawContentWithoutBorder;
                }
                float f2 = 2;
                float min = Math.min(Dp.m4877equalsimpl0(BorderModifierNode.this.m176getWidthD9Ej5fM(), Dp.Companion.m4890getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(CacheDrawModifierNode.mo324toPx0680j_4(BorderModifierNode.this.m176getWidthD9Ej5fM())), (float) Math.ceil(Size.m2457getMinDimensionimpl(CacheDrawModifierNode.m2295getSizeNHjbRc()) / f2));
                float f3 = min / f2;
                long Offset = OffsetKt.Offset(f3, f3);
                long Size = SizeKt.Size(Size.m2458getWidthimpl(CacheDrawModifierNode.m2295getSizeNHjbRc()) - min, Size.m2455getHeightimpl(CacheDrawModifierNode.m2295getSizeNHjbRc()) - min);
                boolean z = f2 * min > Size.m2457getMinDimensionimpl(CacheDrawModifierNode.m2295getSizeNHjbRc());
                Outline mo207createOutlinePq9zytI = BorderModifierNode.this.getShape().mo207createOutlinePq9zytI(CacheDrawModifierNode.m2295getSizeNHjbRc(), CacheDrawModifierNode.getLayoutDirection(), CacheDrawModifierNode);
                if (mo207createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = BorderModifierNode.this;
                    return BorderModifierNode.access$drawGenericBorder(borderModifierNode, CacheDrawModifierNode, borderModifierNode.getBrush(), (Outline.Generic) mo207createOutlinePq9zytI, z, min);
                } else if (mo207createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                    return BorderModifierNode.m174access$drawRoundRectBorderJqoCqck(borderModifierNode2, CacheDrawModifierNode, borderModifierNode2.getBrush(), (Outline.Rounded) mo207createOutlinePq9zytI, Offset, Size, z, min);
                } else if (mo207createOutlinePq9zytI instanceof Outline.Rectangle) {
                    m172drawRectBorderNsqcLGU = BorderKt.m172drawRectBorderNsqcLGU(CacheDrawModifierNode, BorderModifierNode.this.getBrush(), Offset, Size, z, min);
                    return m172drawRectBorderNsqcLGU;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
    }

    /* renamed from: setWidth-0680j_4 */
    public final void m177setWidth0680j_4(float f) {
        if (Dp.m4877equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setBrush(Brush value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.brush, value)) {
            return;
        }
        this.brush = value;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(Shape value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.shape, value)) {
            return;
        }
        this.shape = value;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0132  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r46, final androidx.compose.ui.graphics.Brush r47, final androidx.compose.ui.graphics.Outline.Generic r48, boolean r49, float r50) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* renamed from: drawRoundRectBorder-JqoCqck */
    public final DrawResult m175drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m2439getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m2439getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope onDrawWithContent) {
                    long m173shrinkKibmq7A;
                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    if (z) {
                        DrawScope.m3167drawRoundRectZuiqVtQ$default(onDrawWithContent, brush, 0L, 0L, m2439getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float m2364getXimpl = CornerRadius.m2364getXimpl(m2439getTopLeftCornerRadiuskKHJgLs);
                    float f3 = f2;
                    if (m2364getXimpl >= f3) {
                        Brush brush2 = brush;
                        long j3 = j;
                        long j4 = j2;
                        m173shrinkKibmq7A = BorderKt.m173shrinkKibmq7A(m2439getTopLeftCornerRadiuskKHJgLs, f3);
                        DrawScope.m3167drawRoundRectZuiqVtQ$default(onDrawWithContent, brush2, j3, j4, m173shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
                        return;
                    }
                    ContentDrawScope contentDrawScope = onDrawWithContent;
                    float f4 = f;
                    float m2458getWidthimpl = Size.m2458getWidthimpl(onDrawWithContent.mo3171getSizeNHjbRc()) - f;
                    float m2455getHeightimpl = Size.m2455getHeightimpl(onDrawWithContent.mo3171getSizeNHjbRc()) - f;
                    int m2616getDifferencertfAjoo = ClipOp.Companion.m2616getDifferencertfAjoo();
                    Brush brush3 = brush;
                    long j5 = m2439getTopLeftCornerRadiuskKHJgLs;
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long mo3096getSizeNHjbRc = drawContext.mo3096getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo3099clipRectN_I0leg(f4, f4, m2458getWidthimpl, m2455getHeightimpl, m2616getDifferencertfAjoo);
                    DrawScope.m3167drawRoundRectZuiqVtQ$default(contentDrawScope, brush3, 0L, 0L, j5, 0.0f, null, null, 0, 246, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo3097setSizeuvyYCjk(mo3096getSizeNHjbRc);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                DrawScope.m3161drawPathGBMwjPU$default(onDrawWithContent, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}