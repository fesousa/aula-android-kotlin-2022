package br.com.fernandosousa.lmsapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object AndroidUtils {
    // verificar se existe algum tipo de conexão disponível
    fun isInternetDisponivel(): Boolean {
        val conexao =
            LMSApplication.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val capabilities =
            conexao.getNetworkCapabilities(conexao.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
        return false
    }
}