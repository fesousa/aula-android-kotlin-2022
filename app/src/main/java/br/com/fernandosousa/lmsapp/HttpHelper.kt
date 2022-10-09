package br.com.fernandosousa.lmsapp

import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

object HttpHelper {

    private val TAG = "HTTP_LMSApp"
    val JSON = "application/json; charset=utf-8".toMediaType()

    var client = OkHttpClient()

    // GET
    fun get(url: String): String {
        Log.d(TAG, "HttpHelper.get: $url")
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    // POST JSON
    fun post(url: String, json: String): String {
        Log.d(TAG, "HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    // DELETE
    fun delete(url: String): String {
        Log.d(TAG, "HttpHelper.delete: $url")
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }

    // Lê resposta em formato JSON
    private fun getJson(request: Request): String {
        val response = client.newCall(request).execute()
        val body = response.body;
        if (body != null) {
            val json = body.string()
            Log.d(TAG, "  << : $json")
            return json
        }
        throw IOException("Erro na requisição")
    }
}