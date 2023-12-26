package com.example.secureapp;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.example.secureapp.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: MainActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f44lambda1 = ComposableLambdaKt.composableLambdaInstance(483288278, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.secureapp.ComposableSingletons$MainActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(483288278, i, -1, "com.example.secureapp.ComposableSingletons$MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:21)");
            }
            MainActivityKt.Greeting("Android", null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda2 = ComposableLambdaKt.composableLambdaInstance(-2101863407, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.secureapp.ComposableSingletons$MainActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2101863407, i, -1, "com.example.secureapp.ComposableSingletons$MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:20)");
                }
                SurfaceKt.m1473SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1033getBackground0d7_KjU(), 0L, 0.0f, 0.0f, null, ComposableSingletons$MainActivityKt.INSTANCE.m5150getLambda1$app_release(), composer, 12582918, 122);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f46lambda3 = ComposableLambdaKt.composableLambdaInstance(-63856097, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.secureapp.ComposableSingletons$MainActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-63856097, i, -1, "com.example.secureapp.ComposableSingletons$MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:18)");
                }
                ThemeKt.SecureAppTheme(false, false, ComposableSingletons$MainActivityKt.INSTANCE.m5151getLambda2$app_release(), composer, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-4  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f47lambda4 = ComposableLambdaKt.composableLambdaInstance(1828850032, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.secureapp.ComposableSingletons$MainActivityKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1828850032, i, -1, "com.example.secureapp.ComposableSingletons$MainActivityKt.lambda-4.<anonymous> (MainActivity.kt:40)");
            }
            MainActivityKt.Greeting("Android", null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5150getLambda1$app_release() {
        return f44lambda1;
    }

    /* renamed from: getLambda-2$app_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5151getLambda2$app_release() {
        return f45lambda2;
    }

    /* renamed from: getLambda-3$app_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5152getLambda3$app_release() {
        return f46lambda3;
    }

    /* renamed from: getLambda-4$app_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5153getLambda4$app_release() {
        return f47lambda4;
    }
}