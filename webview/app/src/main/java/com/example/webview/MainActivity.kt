package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webViewContainer)
        progressBar = findViewById(R.id.progressBar)

        // Configurer la WebView
        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        // Charger une URL
        webView.loadUrl("https://www.google.com")
    }

    inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }
}
