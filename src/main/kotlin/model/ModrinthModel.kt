package cn.eziosweet.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class ModrinthModel(
    @JsonNames("version_number")
    var versionNumber:String,
    var files:List<File>
){
    @Serializable
    data class File(
        var url:String,
        var filename:String
    )
}