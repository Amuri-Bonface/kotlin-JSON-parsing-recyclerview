package ke.co.kotlin.weatherapp

import android.util.Log
import java.net.URL

/**
 * Created by Amuri Bonface on 3/26/2018.
 */

//Receive string URL from MainActivity use readText() and display the results in the Logcat
class Request(val url:String) {
    fun run(){
        val forecastJsonStr= URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}