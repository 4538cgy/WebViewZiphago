package com.uos.webviewziphago

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val webView = findViewById<View>(R.id.webview) as WebView

        WebView.setWebContentsDebuggingEnabled(true)

        val webViewSettings = webView.settings

        webViewSettings.javaScriptEnabled = true
        webViewSettings.domStorageEnabled = true


        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://ccw0107.koreafree.co.kr/m")



    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()){
            webview.goBack()
        return true
    }

        return super.onKeyDown(keyCode, event)
    }
}