
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keep class com.simcardinfo.bankinfo.numberlocator.MyApplication
-keep class com.simcardinfo.bankinfo.numberlocator.Splash_Activity {*;}
-keep class com.anchorfree.** {*;}
-keep public class android.net.http.SslError
-keep public class android.webkit.WebViewClient

-dontwarn android.webkit.WebView
-dontwarn android.net.http.SslError
-dontwarn android.webkit.WebViewClient

  # rxjava
  -keep class rx.schedulers.Schedulers {
        public static <methods>;
    }
    -keep class rx.schedulers.ImmediateScheduler {
        public <methods>;
    }
    -keep class rx.schedulers.TestScheduler {
        public <methods>;
    }
    -keep class rx.schedulers.Schedulers {
        public static ** test();
    }
    -keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
        long producerIndex;
        long consumerIndex;
    }
    -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
        long producerNode;
        long consumerNode;
    }