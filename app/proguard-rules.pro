# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\users\administrator\AppData\Local\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-optimizationpasses 5
# 是否使用大小写混合
-dontusemixedcaseclassnames
# 是否混淆第三方jar
-dontskipnonpubliclibraryclasses
# 混淆时是否做预校验
-dontpreverify
# 混淆时是否记录日志
-verbose
# 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-libraryjars libs/android-support-v4.jar
-libraryjars libs/commons-codec.jar
-libraryjars libs/commons-httpclient-3.1.jar
-libraryjars libs/httpmime-4.2.jar
-libraryjars libs/locSDK_3.1.jar
-libraryjars   libs/zxing.jar
-libraryjars libs/android-support-v7.jar

-dontwarn android.support.v4.**     #缺省proguard 会检查每一个引用是否正确，但是第三方库里面往往有些不会用到的类，没有正确引用。如果不配置的话，系统就会报错。
-dontwarn android.os.**