package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanStyle.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a-\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001aÃ\u0001\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010;\u001a\u0004\u0018\u00010\u0013*\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpanStyleKt {
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.Companion.m2663getTransparent0d7_KjU();
    private static final long DefaultColor = Color.Companion.m2654getBlack0d7_KjU();

    public static final /* synthetic */ long access$getDefaultColor$p() {
        return DefaultColor;
    }

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY */
    public static final long m4368lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m5071isUnspecifiedR2X_6o(j) || TextUnitKt.m5071isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m5043boximpl(j), TextUnit.m5043boximpl(j2), f)).m5062unboximpl();
        }
        return TextUnitKt.m5073lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle start, SpanStyle stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(start.getTextForegroundStyle$ui_text_release(), stop.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(start.getFontFamily(), stop.getFontFamily(), f);
        long m4368lerpTextUnitInheritableC3pnCVY = m4368lerpTextUnitInheritableC3pnCVY(start.m4363getFontSizeXSAIIZE(), stop.m4363getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = start.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = stop.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(start.m4364getFontStyle4Lr2A7w(), stop.m4364getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(start.m4365getFontSynthesisZQGJjVo(), stop.m4365getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(start.getFontFeatureSettings(), stop.getFontFeatureSettings(), f);
        long m4368lerpTextUnitInheritableC3pnCVY2 = m4368lerpTextUnitInheritableC3pnCVY(start.m4366getLetterSpacingXSAIIZE(), stop.m4366getLetterSpacingXSAIIZE(), f);
        BaselineShift m4361getBaselineShift5SSeXJ0 = start.m4361getBaselineShift5SSeXJ0();
        float m4665unboximpl = m4361getBaselineShift5SSeXJ0 != null ? m4361getBaselineShift5SSeXJ0.m4665unboximpl() : BaselineShift.m4660constructorimpl(0.0f);
        BaselineShift m4361getBaselineShift5SSeXJ02 = stop.m4361getBaselineShift5SSeXJ0();
        float m4672lerpjWV1Mfo = BaselineShiftKt.m4672lerpjWV1Mfo(m4665unboximpl, m4361getBaselineShift5SSeXJ02 != null ? m4361getBaselineShift5SSeXJ02.m4665unboximpl() : BaselineShift.m4660constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = start.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = stop.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(start.getLocaleList(), stop.getLocaleList(), f);
        long m2679lerpjxsXWHM = ColorKt.m2679lerpjxsXWHM(start.m4360getBackground0d7_KjU(), stop.m4360getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(start.getTextDecoration(), stop.getTextDecoration(), f);
        Shadow shadow = start.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = stop.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(lerp, m4368lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m4368lerpTextUnitInheritableC3pnCVY2, BaselineShift.m4659boximpl(m4672lerpjWV1Mfo), lerp3, localeList, m2679lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(start.getDrawStyle(), stop.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        TextForegroundStyle takeOrElse = style.getTextForegroundStyle$ui_text_release().takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                return TextForegroundStyle.Companion.m4785from8_81llA(SpanStyleKt.access$getDefaultColor$p());
            }
        });
        long m4363getFontSizeXSAIIZE = TextUnitKt.m5071isUnspecifiedR2X_6o(style.m4363getFontSizeXSAIIZE()) ? DefaultFontSize : style.m4363getFontSizeXSAIIZE();
        FontWeight fontWeight = style.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle m4364getFontStyle4Lr2A7w = style.m4364getFontStyle4Lr2A7w();
        FontStyle m4496boximpl = FontStyle.m4496boximpl(m4364getFontStyle4Lr2A7w != null ? m4364getFontStyle4Lr2A7w.m4502unboximpl() : FontStyle.Companion.m4504getNormal_LCdwA());
        FontSynthesis m4365getFontSynthesisZQGJjVo = style.m4365getFontSynthesisZQGJjVo();
        FontSynthesis m4505boximpl = FontSynthesis.m4505boximpl(m4365getFontSynthesisZQGJjVo != null ? m4365getFontSynthesisZQGJjVo.m4513unboximpl() : FontSynthesis.Companion.m4514getAllGVVA2EU());
        SystemFontFamily fontFamily = style.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = style.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long m4366getLetterSpacingXSAIIZE = TextUnitKt.m5071isUnspecifiedR2X_6o(style.m4366getLetterSpacingXSAIIZE()) ? DefaultLetterSpacing : style.m4366getLetterSpacingXSAIIZE();
        BaselineShift m4361getBaselineShift5SSeXJ0 = style.m4361getBaselineShift5SSeXJ0();
        BaselineShift m4659boximpl = BaselineShift.m4659boximpl(m4361getBaselineShift5SSeXJ0 != null ? m4361getBaselineShift5SSeXJ0.m4665unboximpl() : BaselineShift.Companion.m4669getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = style.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = style.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long m4360getBackground0d7_KjU = style.m4360getBackground0d7_KjU();
        if (m4360getBackground0d7_KjU == Color.Companion.m2664getUnspecified0d7_KjU()) {
            m4360getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j = m4360getBackground0d7_KjU;
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = style.getPlatformStyle();
        Fill drawStyle = style.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, m4363getFontSizeXSAIIZE, fontWeight2, m4496boximpl, m4505boximpl, fontFamily2, str, m4366getLetterSpacingXSAIIZE, m4659boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0033, code lost:
        if (androidx.compose.ui.unit.TextUnit.m5050equalsimpl0(r26, r21.m4363getFontSizeXSAIIZE()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x005a, code lost:
        if (androidx.compose.ui.graphics.Color.m2629equalsimpl0(r22, r21.getTextForegroundStyle$ui_text_release().mo4673getColor0d7_KjU()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0066, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r21.m4364getFontStyle4Lr2A7w()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0072, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r21.getFontWeight()) == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x007a, code lost:
        if (r31 != r21.getFontFamily()) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x008e, code lost:
        if (androidx.compose.ui.unit.TextUnit.m5050equalsimpl0(r33, r21.m4366getLetterSpacingXSAIIZE()) == false) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:195:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x01cc  */
    /* renamed from: fastMerge-dSHsh3o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.text.SpanStyle m4367fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r21, long r22, androidx.compose.ui.graphics.Brush r24, float r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, androidx.compose.ui.graphics.drawscope.DrawStyle r43) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m4367fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }
}