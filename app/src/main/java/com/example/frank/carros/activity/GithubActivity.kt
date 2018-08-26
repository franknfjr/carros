package com.example.frank.carros.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.frank.carros.R
import com.example.frank.carros.extensions.setupToolbar

class GithubActivity : BaseActivity() {

    private val URL = "https://github.com/franknfjr/carros"
    var webview: WebView? = null
    var progress: ProgressBar? = null
    var swipeToRefresh: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        // Toolbar
        val actionBar = setupToolbar(R.id.toolbar)
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Views
        webview = findViewById<WebView>(R.id.webview)
        progress = findViewById<ProgressBar>(R.id.progress)

        // Carrega a página
        setWebViewClient(webview)
        webview?.loadUrl(URL)

        //Swipe to Refresh
        swipeToRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        swipeToRefresh?.setOnRefreshListener {
            webview?.reload()
        }

        // Cores da animação
        swipeToRefresh?.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        )
    }

    // Controla os eventos do webView
    private fun setWebViewClient(webview: WebView?) {
        webview?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // Liga o progress
                progress?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                // Desliga o progress
                progress?.visibility = View.INVISIBLE

                // Termina a animação do Swipe to Refresh
                swipeToRefresh?.isRefreshing = false
            }
        }
    }
}
