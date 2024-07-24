package cn.eziosweet.model

import kotlinx.serialization.Serializable


@Serializable
data class ConfigModel(
    var version:String,
    var mcVersion: String,
    var modrinth:List<Modrinth>,
    var local:List<Local>,
    var remove:List<String>
){
    @Serializable
    data class Modrinth(
        var name: String,
        var version: String,
        var path:String
    )
    @Serializable
    data class Local(
        var url:String,
        var path:String
    )
}
