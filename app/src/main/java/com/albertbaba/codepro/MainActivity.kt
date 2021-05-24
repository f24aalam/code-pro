package com.albertbaba.codepro

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mainWebView: WebView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainWebView = findViewById(R.id.mainWebView)
        progressBar = findViewById(R.id.progressBar)

        mainWebView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                if (mainWebView.visibility != View.GONE) {
                    mainWebView.visibility = View.GONE
                }

                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
                mainWebView.visibility = View.VISIBLE
            }
        }

        mainWebView.loadUrl("https://www.w3schools.com")
        mainWebView.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (mainWebView.canGoBack())
            mainWebView.goBack()
        else
            super.onBackPressed()
    }
}