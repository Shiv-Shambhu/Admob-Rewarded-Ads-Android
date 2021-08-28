# Admob-Rewarded-Ads-Android
Rewarded ads are a popular ad format that gives users an opportunity to watch a video or engage with a playable ad in exchange for a reward within the app.

## 1) 

## 2) Adding the Mobile Ads SDK
#### To show the ads in our app we have to first implement the Admob sdk in our app, to do so.

Go to Gradle Scripts->build.gradle (Module: app) section and import below dependencies and click the "sync Now" show at the top:

```gradle
dependencies {
     // adding Admob SDK
     implementation 'com.google.android.gms:play-services-ads:19.4.0'
}
```
