# WebView
WebView Example using Back/Next buttons in Android

## Setup:

-  Add this permission to the `AndroidManifest.xml`:
 
```
   <uses-permission android:name="android.permission.INTERNET"/>
```

- Include this line in application tag into the `AndroidManifest.xml`:
 
```
<application
   ...
   android:usesCleartextTraffic="true"
   ...
</application>
```


## Create a Layout file (activity_main.xml): 

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@id/tvBase"/>
     
    ...
    ...
    ...
</androidx.constraintlayout.widget.ConstraintLayout>
```

## MainActivity.java

Define views and listeners (checking code for details), and override `onBackPressed` method.

```
    // Views
    private TextView next;
    private TextView back;
    private WebView web;
    
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       setupViews();       // Init views
       setupWebView();     // Init WebView
       setupListeners();   // Implement listeners
   }
   
   ...
   
   @Override
    public void onBackPressed() {
        if (web.canGoBack()){
            web.goBack();
            return;
        }else{
            AwesomeToast.errorGradientPeak(getApplicationContext(), "Web cannot go Back");
        }

        super.onBackPressed();
    }
```

## Final result:
<p align = "center">
<img src="/images/01.gif" width="300">
</p>
