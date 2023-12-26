package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidClipboardManager.android.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EncodeHelper {
    private Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final String encodedString() {
        String encodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    public final void encode(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        if (!Color.m2629equalsimpl0(spanStyle.m4362getColor0d7_KjU(), Color.Companion.m2664getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m4191encode8_81llA(spanStyle.m4362getColor0d7_KjU());
        }
        if (!TextUnit.m5050equalsimpl0(spanStyle.m4363getFontSizeXSAIIZE(), TextUnit.Companion.m5064getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m4188encodeR2X_6o(spanStyle.m4363getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle m4364getFontStyle4Lr2A7w = spanStyle.m4364getFontStyle4Lr2A7w();
        if (m4364getFontStyle4Lr2A7w != null) {
            int m4502unboximpl = m4364getFontStyle4Lr2A7w.m4502unboximpl();
            encode((byte) 4);
            m4193encodenzbMABs(m4502unboximpl);
        }
        FontSynthesis m4365getFontSynthesisZQGJjVo = spanStyle.m4365getFontSynthesisZQGJjVo();
        if (m4365getFontSynthesisZQGJjVo != null) {
            int m4513unboximpl = m4365getFontSynthesisZQGJjVo.m4513unboximpl();
            encode((byte) 5);
            m4190encode6p3vJLY(m4513unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m5050equalsimpl0(spanStyle.m4366getLetterSpacingXSAIIZE(), TextUnit.Companion.m5064getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m4188encodeR2X_6o(spanStyle.m4366getLetterSpacingXSAIIZE());
        }
        BaselineShift m4361getBaselineShift5SSeXJ0 = spanStyle.m4361getBaselineShift5SSeXJ0();
        if (m4361getBaselineShift5SSeXJ0 != null) {
            float m4665unboximpl = m4361getBaselineShift5SSeXJ0.m4665unboximpl();
            encode((byte) 8);
            m4189encode4Dl_Bck(m4665unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m2629equalsimpl0(spanStyle.m4360getBackground0d7_KjU(), Color.Companion.m2664getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m4191encode8_81llA(spanStyle.m4360getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m4191encode8_81llA(long j) {
        m4192encodeVKZWuLQ(j);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m4188encodeR2X_6o(long j) {
        long m5052getTypeUIouoOA = TextUnit.m5052getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m5081equalsimpl0(m5052getTypeUIouoOA, TextUnitType.Companion.m5087getUnspecifiedUIouoOA())) {
            if (TextUnitType.m5081equalsimpl0(m5052getTypeUIouoOA, TextUnitType.Companion.m5086getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m5081equalsimpl0(m5052getTypeUIouoOA, TextUnitType.Companion.m5085getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m5081equalsimpl0(TextUnit.m5052getTypeUIouoOA(j), TextUnitType.Companion.m5087getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m5053getValueimpl(j));
    }

    public final void encode(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m4193encodenzbMABs(int i) {
        byte b = 0;
        if (!FontStyle.m4499equalsimpl0(i, FontStyle.Companion.m4504getNormal_LCdwA()) && FontStyle.m4499equalsimpl0(i, FontStyle.Companion.m4503getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m4190encode6p3vJLY(int i) {
        byte b = 0;
        if (!FontSynthesis.m4508equalsimpl0(i, FontSynthesis.Companion.m4515getNoneGVVA2EU())) {
            if (FontSynthesis.m4508equalsimpl0(i, FontSynthesis.Companion.m4514getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m4508equalsimpl0(i, FontSynthesis.Companion.m4517getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m4508equalsimpl0(i, FontSynthesis.Companion.m4516getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m4189encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m4191encode8_81llA(shadow.m2946getColor0d7_KjU());
        encode(Offset.m2389getXimpl(shadow.m2947getOffsetF1C5BW0()));
        encode(Offset.m2390getYimpl(shadow.m2947getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m4192encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.parcel.writeString(string);
    }
}