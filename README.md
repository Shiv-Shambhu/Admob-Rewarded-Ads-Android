# Admob-Rewarded-Ads-Android
Rewarded ads are a popular ad format that gives users an opportunity to watch a video or engage with a playable ad in exchange for a reward within the app.

## 1) Import the Firebase Ads SDK
import the Firebase Ads SDK by adding the following rules to your project-level build.gradle file to include the google-services plugin:

```gradle
buildscript {
    ...
    dependencies {
        ...
        classpath 'com.google.gms:google-services:4.3.10'
    }
}
```
#### Full Code [project-level build.gradle](https://github.com/Shiv-Shambhu/Admob-Rewarded-Ads-Android/blob/main/build.gradle)

#### To show the ads in our app we have to first implement the Admob sdk in our app, to do so.

Go to Gradle Scripts->build.gradle (Module: app) section and import below dependencies and click the "sync Now" show at the top:

```gradle
dependencies {
     // adding Admob SDK
     implementation 'com.google.firebase:firebase-ads:20.3.0'
}

apply plugin: 'com.google.gms.google-services'
```

## 2) Add google-services.json File to *Module: app* section
