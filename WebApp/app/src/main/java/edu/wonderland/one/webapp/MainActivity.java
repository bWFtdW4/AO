package edu.wonderland.one.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;


/**
 *         //add internet permission to the manifest
 *         <uses-permission android:name="android.permission.INTERNET" />
 *         //add cleartext traffic to the manifest for http
 *         android:usesCleartextTraffic="true"
 *
 * */
public class MainActivity extends AppCompatActivity {

    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the browser
        browser = (WebView) findViewById(R.id.browser);
        // Get chrome client
        browser.setWebChromeClient(new WebChromeClient());
        // enable javascript
        browser.getSettings().setJavaScriptEnabled(true);

        /*
        //html site with javascript
        String htmlSite =
                "<html>" +
                    "<head>" +
                        "<style>body{background-color: grey;}</style>" +
                    "</head>" +
                    "<body>" +
                        "<h1>Hello World!</h1>" +
                        "<input type='button' value='los' onClick=\"showString('Hello')\"/>" +
                    "</body>" +
                        "<script>" +
                            "function showString(str){" +
                                "alert('Hello World!');" +
                            "}" +
                        "</script>" +
                "</html>";

        // Load html
        browser.loadData(htmlSite, "text/html", "UTF-8");

         */
        /*
        // Load html with deep javascript
        String htmlSite =
                "<html>" +
                        "<head>" +
                        "<style>body{background-color: grey;}</style>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Hello Toast!</h1>" +
                        "<input type='button' value='get a toast' onClick=\"showString('Hello')\"/>" +
                        "</body>" +
                        "<script>" +
                        "function showString(str){" +
                        "Android.showToastWithText(str);" +
                        "}" +
                        "</script>" +
                        "</html>";

        // add javascript interface to the browser - this is the bridge between javascript and java
        browser.addJavascriptInterface(new MyJavaScriptInterface(), "Android");
        // Load html
        browser.loadData(htmlSite, "text/html", "UTF-8");
        */

        browser.addJavascriptInterface(new MyJavaScriptInterface(), "Android");
        // Load html from assets
        //browser.loadUrl("file:///android_asset/start.html");

        // Load html from internet
        //browser.loadUrl("https://breaknewground.de");

        //10.0.2.2 is the localhost for the emulator
        browser.loadUrl("http://10.0.2.2/m/android/start.html");
    }


    class MyJavaScriptInterface {
        // This method will be called from the javascript - annotation is required !!!!!!!!!!!!
        @JavascriptInterface
        public void showToastWithText (String str) {
            // Show toast with the text from the javascript str variable
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(),"TTTTTTTT",Toast.LENGTH_SHORT).show();

        }
    }

}