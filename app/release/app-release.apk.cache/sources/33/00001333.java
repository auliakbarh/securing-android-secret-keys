package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0011J\u0019\u0010#\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011J\u0019\u0010'\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0011J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.Jf\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundRect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final RoundRect Zero = RoundRectKt.m2443RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m2374getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs  reason: not valid java name */
    public final long m2431component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs  reason: not valid java name */
    public final long m2432component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs  reason: not valid java name */
    public final long m2433component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs  reason: not valid java name */
    public final long m2434component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: copy-MDFrsts  reason: not valid java name */
    public final RoundRect m2436copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundRect) {
            RoundRect roundRect = (RoundRect) obj;
            return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m2363equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m2363equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m2363equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m2363equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
        }
        return false;
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2437getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2438getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2439getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2440getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + CornerRadius.m2366hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m2366hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m2366hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m2366hashCodeimpl(this.bottomLeftCornerRadius);
    }

    private RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, (i & 16) != 0 ? CornerRadius.Companion.m2374getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.Companion.m2374getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.Companion.m2374getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.Companion.m2374getZerokKHJgLs() : j4, null);
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect == null) {
            float minRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m2365getYimpl(this.bottomLeftCornerRadius), CornerRadius.m2365getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m2364getXimpl(this.topLeftCornerRadius), CornerRadius.m2364getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m2365getYimpl(this.topRightCornerRadius), CornerRadius.m2365getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m2364getXimpl(this.bottomRightCornerRadius), CornerRadius.m2364getXimpl(this.bottomLeftCornerRadius), getWidth());
            RoundRect roundRect2 = new RoundRect(this.left * minRadius, this.top * minRadius, this.right * minRadius, this.bottom * minRadius, CornerRadiusKt.CornerRadius(CornerRadius.m2364getXimpl(this.topLeftCornerRadius) * minRadius, CornerRadius.m2365getYimpl(this.topLeftCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2364getXimpl(this.topRightCornerRadius) * minRadius, CornerRadius.m2365getYimpl(this.topRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2364getXimpl(this.bottomRightCornerRadius) * minRadius, CornerRadius.m2365getYimpl(this.bottomRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2364getXimpl(this.bottomLeftCornerRadius) * minRadius, CornerRadius.m2365getYimpl(this.bottomLeftCornerRadius) * minRadius), null);
            this._scaledRadiiRect = roundRect2;
            return roundRect2;
        }
        return roundRect;
    }

    private final float minRadius(float f, float f2, float f3, float f4) {
        float f5 = f2 + f3;
        return (f5 <= f4 || f5 == 0.0f) ? f : Math.min(f, f4 / f5);
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m2435containsk4lQ0M(long j) {
        float m2389getXimpl;
        float m2390getYimpl;
        float m2364getXimpl;
        float m2365getYimpl;
        if (Offset.m2389getXimpl(j) < this.left || Offset.m2389getXimpl(j) >= this.right || Offset.m2390getYimpl(j) < this.top || Offset.m2390getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect scaledRadiiRect = scaledRadiiRect();
        if (Offset.m2389getXimpl(j) < this.left + CornerRadius.m2364getXimpl(scaledRadiiRect.topLeftCornerRadius) && Offset.m2390getYimpl(j) < this.top + CornerRadius.m2365getYimpl(scaledRadiiRect.topLeftCornerRadius)) {
            m2389getXimpl = (Offset.m2389getXimpl(j) - this.left) - CornerRadius.m2364getXimpl(scaledRadiiRect.topLeftCornerRadius);
            m2390getYimpl = (Offset.m2390getYimpl(j) - this.top) - CornerRadius.m2365getYimpl(scaledRadiiRect.topLeftCornerRadius);
            m2364getXimpl = CornerRadius.m2364getXimpl(scaledRadiiRect.topLeftCornerRadius);
            m2365getYimpl = CornerRadius.m2365getYimpl(scaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m2389getXimpl(j) > this.right - CornerRadius.m2364getXimpl(scaledRadiiRect.topRightCornerRadius) && Offset.m2390getYimpl(j) < this.top + CornerRadius.m2365getYimpl(scaledRadiiRect.topRightCornerRadius)) {
            m2389getXimpl = (Offset.m2389getXimpl(j) - this.right) + CornerRadius.m2364getXimpl(scaledRadiiRect.topRightCornerRadius);
            m2390getYimpl = (Offset.m2390getYimpl(j) - this.top) - CornerRadius.m2365getYimpl(scaledRadiiRect.topRightCornerRadius);
            m2364getXimpl = CornerRadius.m2364getXimpl(scaledRadiiRect.topRightCornerRadius);
            m2365getYimpl = CornerRadius.m2365getYimpl(scaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m2389getXimpl(j) > this.right - CornerRadius.m2364getXimpl(scaledRadiiRect.bottomRightCornerRadius) && Offset.m2390getYimpl(j) > this.bottom - CornerRadius.m2365getYimpl(scaledRadiiRect.bottomRightCornerRadius)) {
            m2389getXimpl = (Offset.m2389getXimpl(j) - this.right) + CornerRadius.m2364getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2390getYimpl = (Offset.m2390getYimpl(j) - this.bottom) + CornerRadius.m2365getYimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2364getXimpl = CornerRadius.m2364getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2365getYimpl = CornerRadius.m2365getYimpl(scaledRadiiRect.bottomRightCornerRadius);
        } else if (Offset.m2389getXimpl(j) >= this.left + CornerRadius.m2364getXimpl(scaledRadiiRect.bottomLeftCornerRadius) || Offset.m2390getYimpl(j) <= this.bottom - CornerRadius.m2365getYimpl(scaledRadiiRect.bottomLeftCornerRadius)) {
            return true;
        } else {
            m2389getXimpl = (Offset.m2389getXimpl(j) - this.left) - CornerRadius.m2364getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2390getYimpl = (Offset.m2390getYimpl(j) - this.bottom) + CornerRadius.m2365getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2364getXimpl = CornerRadius.m2364getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2365getYimpl = CornerRadius.m2365getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
        }
        float f = m2389getXimpl / m2364getXimpl;
        float f2 = m2390getYimpl / m2365getYimpl;
        return (f * f) + (f2 * f2) <= 1.0f;
    }

    public String toString() {
        long j;
        long j2 = this.topLeftCornerRadius;
        long j3 = this.topRightCornerRadius;
        long j4 = this.bottomRightCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        return (CornerRadius.m2363equalsimpl0(j2, j3) && CornerRadius.m2363equalsimpl0(j3, j4) && CornerRadius.m2363equalsimpl0(j4, this.bottomLeftCornerRadius)) ? CornerRadius.m2364getXimpl(j2) == CornerRadius.m2365getYimpl(j2) ? "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2364getXimpl(j2), 1) + ')' : "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2364getXimpl(j2), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2365getYimpl(j2), 1) + ')' : "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m2370toStringimpl(j2)) + ", topRight=" + ((Object) CornerRadius.m2370toStringimpl(j3)) + ", bottomRight=" + ((Object) CornerRadius.m2370toStringimpl(j4)) + ", bottomLeft=" + ((Object) CornerRadius.m2370toStringimpl(j)) + ')';
    }

    /* compiled from: RoundRect.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }
}