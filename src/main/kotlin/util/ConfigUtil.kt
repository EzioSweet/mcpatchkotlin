package cn.eziosweet.util

import cn.eziosweet.model.ConfigModel
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import okhttp3.OkHttpClient
import okhttp3.Request

import java.util.logging.Logger


object ConfigUtil {
    fun getRemoteConfig(url:String,logger:Logger,client: OkHttpClient): ConfigModel? {
        val request = Request.Builder().url(url).get().build()
        val call =client.newCall(request)
        val response = call.execute()
        logger.info(response.body.toString())
        return response.body?.string()?.let { Yaml.default.decodeFromString<ConfigModel>(it) }
    }
}