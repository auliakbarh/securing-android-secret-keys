package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PlatformMagnifier.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "style", "Landroidx/compose/foundation/MagnifierStyle;", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public PlatformMagnifierImpl create(MagnifierStyle style, View view, Density density, float f) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Intrinsics.areEqual(style, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long mo325toSizeXkaWNTQ = density.mo325toSizeXkaWNTQ(style.m219getSizeMYxV2XQ$foundation_release());
        float mo324toPx0680j_4 = density.mo324toPx0680j_4(style.m217getCornerRadiusD9Ej5fM$foundation_release());
        float mo324toPx0680j_42 = density.mo324toPx0680j_4(style.m218getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (mo325toSizeXkaWNTQ != Size.Companion.m2466getUnspecifiedNHjbRc()) {
            builder.setSize(MathKt.roundToInt(Size.m2458getWidthimpl(mo325toSizeXkaWNTQ)), MathKt.roundToInt(Size.m2455getHeightimpl(mo325toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(mo324toPx0680j_4)) {
            builder.setCornerRadius(mo324toPx0680j_4);
        }
        if (!Float.isNaN(mo324toPx0680j_42)) {
            builder.setElevation(mo324toPx0680j_42);
        }
        if (!Float.isNaN(f)) {
            builder.setInitialZoom(f);
        }
        builder.setClippingEnabled(style.getClippingEnabled$foundation_release());
        Magnifier build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(build);
    }

    /* compiled from: PlatformMagnifier.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* renamed from: update-Wko1d7g */
        public void mo241updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m2408isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.m2389getXimpl(j), Offset.m2390getYimpl(j), Offset.m2389getXimpl(j2), Offset.m2390getYimpl(j2));
            } else {
                getMagnifier().show(Offset.m2389getXimpl(j), Offset.m2390getYimpl(j));
            }
        }
    }
}