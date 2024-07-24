package cn.eziosweet

import cn.eziosweet.util.ConfigUtil
import java.util.logging.Logger

fun main(args:Array<String>) {
    val logger = Logger.getGlobal()
    if (args.isEmpty()){
        logger.severe("请提供远程配置文件信息或者本地配置文件信息")
        return
    }
    val url = args[0]
    if (url.substring(0,4).equals("http")){
        logger.info{"使用远程配置文件"}
        var cfg = ConfigUtil.getRemoteConfig(args[0],logger)
        logger.info{cfg.toString()}
    }else{
        logger.info{"使用本地配置文件"}
        //TODO
    }
}