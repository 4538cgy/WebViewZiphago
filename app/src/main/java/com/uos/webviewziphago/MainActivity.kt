package com.uos.webviewziphago

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var backKeyPressedTime = 0


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



    override fun onBackPressed() {





        var curTime = System.currentTimeMillis()
        var gapTime = curTime - backKeyPressedTime

        if(webview.canGoBack()){
            webview.goBack()
        }else if(0<=gapTime && 2000 >= gapTime){
            super.onBackPressed()

        }else{
            backKeyPressedTime = curTime.toInt()
            showSettingPopup()

        }




    }

    fun showSettingPopup(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_popup,null)
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("앱을 종료하시겠습니까?")
            .setNeutralButton("아니오",null)
            .setPositiveButton("네") {
                dialog , which ->
                finishAffinity()
            }

            .create()


        alertDialog.setView(view)
        alertDialog.show()
    }


}