package cn.eziosweet.util

import cn.eziosweet.model.ConfigModel
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.util.logging.Logger


object ConfigUtil {
    fun getRemoteConfig(url:String,logger:Logger): ConfigModel {
        return runBlocking {
            val result =  Fuel.get(url).body.string()
            val bean = Json.decodeFromString<ConfigModel>(result)
            return@runBlocking bean
        }
    }
}