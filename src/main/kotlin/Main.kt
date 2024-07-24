package cn.eziosweet

import cn.eziosweet.util.ConfigUtil
import cn.eziosweet.util.ModrinthUtil
import okhttp3.OkHttpClient
import java.util.logging.Logger

fun main(args:Array<String>) {
    val client = OkHttpClient()
    val logger = Logger.getGlobal()
    val url = if(args.isEmpty()) "http://core.eziosweet.cn:8080/test/config.yml" else args[0]
    if (url.substring(0,4).equals("http")){
        logger.info{"使用远程配置文件"}
        val cfg = ConfigUtil.getRemoteConfig(url,logger,client)
        logger.info{cfg.toString()}
        if (cfg != null) {
            ModrinthUtil.getModrinthMods(cfg,logger, client)
        }
    }else{
        logger.info{"使用本地配置文件"}
        //TODO
    }
}