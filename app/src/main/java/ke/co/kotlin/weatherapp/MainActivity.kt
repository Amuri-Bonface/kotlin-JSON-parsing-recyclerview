package ke.co.kotlin.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items= listOf(
            "Mon 6/23 - Sunny-31/17","Tue 6/24 - Foggy - 21/8","Wed 6/25 - cloudy - 22/17"
            ,"Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Thur 6/ 26 - Foggy - 21/10","Fri 6/27 - Rainy - 18/11","Sat 6/28 - Trapped - 23/17",
            "Sun 6/29 - Sunny - 20/7"
    )


    //lets get real data from URL
    val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
            "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //using find from anko library
        val forecastList:RecyclerView=find(R.id.forecast_list)
        forecastList.layoutManager=LinearLayoutManager(this)
        //display our static data in the recyclerView
        forecastList.adapter=ForecastListAdapter(items)

        //Asynchronously retrieve data in the background
        doAsync() {
            //call 'Request class' and pass to the constructor the URL  string
           Request(url).run()
            uiThread { longToast("Request performed") }
        }

    }

}
