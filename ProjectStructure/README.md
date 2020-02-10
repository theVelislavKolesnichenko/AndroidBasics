# Структура на проект
с
Проектите в Android Studio използва Gradle за изграждане на приложенията. В Gradle скрипта се оказват минималната и целевата версия на Android за които се разработва програмата. Зависимите библиотеки към приложението.

![Android_Gradel_Scrip](https://user-images.githubusercontent.com/10382663/74097495-54f59b00-4b15-11ea-9632-f29bd66724ef.PNG)

Във файла AndroidManifest.xml се задава конфигурацията на приложението. Името на приложението, главното активити, иконата и темата на дизайна, разрешения за функциите на телефона до които ще има достъп приложението.

```xml
 <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.github.thevelislavkolesnichenko.picassoexample">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:usesCleartextTraffic="true">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
```

В папката java са клас файловете на приложението.

![Android_Res](https://user-images.githubusercontent.com/10382663/74097499-5626c800-4b15-11ea-9b55-46a8d3241957.PNG)

Основната папка е res. Тя съдържа ресурсите на приложението:

- drawable - съдържа изображенията за различните разделителни способности на екрана
- layout - съдържа оформлението на потребителския интерфейс
- menu - съдържа XML на менюто
- values - различни стойности като текстове, масиви и други
