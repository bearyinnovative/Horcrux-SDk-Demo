# Anndroid-SDK
这个是接入Bearychat SDK的示例项目。

# Download
为了方便的使用我们的sdk，您首先需要在项目的根目录下的`build.gradle`中maven仓库的地址。
``` gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "http://mvn.leancloud.cn/nexus/content/repositories/releases" }
        maven { url "http://120.25.239.87:8081/artifactory/gradle-release-local" }
        maven { url "http://dl.bintray.com/piasy/maven" }
        maven { url "https://jitpack.io" }
        maven { url 'http://developer.huawei.com/repo/' }
    }
}
```
接下来，您需要在app目录下的`build.gradle`中开启databinding以及依赖库
``` gradle
android {
    dataBinding {
        enabled true
    }
}

dependencies {
    annotationProcessor "com.android.databinding:compiler:$gradle_version"
    implementation 'com.bearyinnovative:bearychat-sdk:***'
}
```
如果您使用的是kotlin，请使用`kapt`替代`annotationProcessor`,接下来sync整个工程成功则代表接入sdk完成.

# How do I use SDK?
在项目的application(application需要开启multidex功能或者集成我们的BaseApplication)中初始化sdk.
```kotlin
    override fun onCreate() {
        super.onCreate()
        if (isMainProcess) {
            AppConfig.init(this)
            val initParams = AppInitializationManager.AppInitializationParams(false, false,
                    "", false, false,
                    BuildConfig.DEBUG, false)
            AppInitializationManager.init(this, initParams)
        }
    }

    private val isMainProcess: Boolean
        get() {
            val pid = android.os.Process.myPid()
            val activityManager = this.getSystemService(android.content.Context.ACTIVITY_SERVICE) as ActivityManager
            val processName = activityManager.runningAppProcesses.find { it.pid == pid }?.processName
            return BuildConfig.APPLICATION_ID == processName
        }
```

接下来，使用我们定制的`BearyConversationView`

```xml
    <com.bearyinnovative.horcrux.ui.chat.conversation.BearyConversationView
        android:id="@+id/conversation_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
并且在代码中初始化该view
```java
        BearyConversationView bearyConversationView = findViewById(R.id.conversation_list);
        bearyConversationView.initConversationByParams("beary", "Beary Innovative", "****", "***");
```

即可正常使用.

注意，如果编译失败，可在`gradle.properties`中加入`android.enableD8=true`再次重试，如果还有问题可直接提issue.





