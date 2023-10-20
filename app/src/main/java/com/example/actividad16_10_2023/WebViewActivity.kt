package com.example.actividad16_10_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.actividad16_10_2023.R.id.wvNavegador

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        //Asociar con componentes grafico
        webView = findViewById(R.id.wvNavegador)
        //Estalecer pagina de inicio
        webView.loadUrl("https://www.youtube.com/")
        //Configuracuin del navegador en caso de que la app
        //var webSettings: WebSettings = webView.settings
        //webSettings.javaScriptEnable=true
        //WebView.webViewClient = WebViewClient()

    }
}