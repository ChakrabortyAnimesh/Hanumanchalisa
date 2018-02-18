package com.example.animesh.hanumanchalisa;





import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
        //SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);

       // imageView.setImage(ImageSource.resource(R.drawable.hh));

       // TextView textView = (TextView) findViewById(R.id.textView);

        WebView webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("file:///android_asset/hi.html");
       //webView.getSettings().setJavaScriptEnabled(true);





    }
}