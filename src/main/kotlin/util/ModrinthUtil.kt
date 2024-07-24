package cn.eziosweet.util

import cn.eziosweet.model.ConfigModel
import cn.eziosweet.model.ModrinthModel
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.util.logging.Logger

object ModrinthUtil {
    fun getModrinthMods(config:ConfigModel,logger: Logger,client: OkHttpClient) {
        val json =  Json { ignoreUnknownKeys = true }
        config.modrinth.forEach {
            if (it.version == null ||it.version==""){
                var request = Request
                    .Builder()
                    .url("https://api.modrinth.com/v2/project/"+it.name+"/version?game_versions=[\""+config.mcVersion+"\"]&loaders=[\"fabric\"]")
                    .get()
                    .build()
                var call = client.newCall(request)
                var response = call.execute()
                var modrinth = response.body?.string()?.let { it1 -> json.decodeFromString<List<ModrinthModel>>(it1) }
                logger.info(modrinth!![0].toString())
                
                
                request = Request
                    .Builder()
                    .url(modrinth!![0].files[0].url)
                    .get()
                    .build()
                call = client.newCall(request)
                response = call.execute()
                var bytes  = response.body?.byteStream()
                var total = response.body?.contentLength()
                var buffer = ByteArray(2048)
                var dir =File("./mods")
                var len = 0
                if (!dir.exists()){
                    dir.mkdirs()
                }
                var file = File(dir,modrinth!![0].files[0].filename)
                var outputStream  = FileOutputStream(file)
                if (bytes != null) {
                    len = bytes.read(buffer)
                    while (len != -1){
                        outputStream.write(buffer,0,len)
                        len = bytes.read(buffer)
                    }
                    bytes.close()
                    outputStream.close()
                }
                
            }else{
                val request = Request
                    .Builder()
                    .url("https://api.modrinth.com/v2/project/"+it.name+"/version?game_versions=[\""+config.mcVersion+"\"]")
                    .get()
                    .build()
                val call = client.newCall(request)
                var response = call.execute()
                var modrinth = response.body?.string()?.let { it1 -> json.decodeFromString<List<ModrinthModel>>(it1) }
                logger.info(modrinth!![0].toString())
            }
        }
    }
}