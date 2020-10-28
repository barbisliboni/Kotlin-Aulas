package br.com.barbaraliboni.celleptechcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        // Referenciar o id do componente
        val wbvWeb : WebView = findViewById(R.id.wbvWeb);

        // Pedindo para o programa "ler" os códigos em JS
        wbvWeb.settings.javaScriptEnabled = true;

        // Carregando uma página web
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack");

        // Definindo o WebView como Cliente Web padrão
        wbvWeb.webViewClient = WebViewClient()

    }
}