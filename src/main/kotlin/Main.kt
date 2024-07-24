package cn.eziosweet

import cn.eziosweet.model.ConfigModel
import cn.eziosweet.util.ConfigUtil
import cn.hutool.http.HttpUtil
import cn.hutool.log.LogFactory


fun main(args:Array<String>) {
    val logger = LogFactory.get()
    if (args.isEmpty()){
        logger.error("请提供远程配置文件信息或者本地配置文件信息")
        return
    }
    val url = args[0]
    if (url.substring(0,4).equals("http")){
        logger.info("使用远程配置文件")
    }else{
        logger.info("使用本地配置文件")
        var cfg = ConfigUtil.getRemoteConfig("https://staging-api.modrinth.com/",logger)
        logger.info(cfg.toString())
    }
}