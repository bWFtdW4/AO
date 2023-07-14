package edu.wonderland.one.webapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

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

        String htmlSite =
                "<html>" +
                        "<head>" +
                        "<style>body{background-color: red;}</style>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Hello World!</h1>" +
                        "</body>" +
                        "<script>" +
                        "</script>" +
                        "</html>";

        // Load html
        //browser.loadData(htmlSite, "text/html", "UTF-8");


        browser.loadUrl("file:///android_asset/index.html");
    }
}