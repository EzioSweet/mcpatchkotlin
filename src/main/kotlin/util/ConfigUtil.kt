package cn.eziosweet.util

import cn.eziosweet.model.ConfigModel
import cn.hutool.http.HttpUtil
import cn.hutool.log.Log
import kotlinx.serialization.json.Json


object ConfigUtil {
    fun getRemoteConfig(url:String,logger:Log): ConfigModel {
        val result =  HttpUtil.get(url);
        val bean = Json.decodeFromString<ConfigModel>(result)
        return bean
    }
}