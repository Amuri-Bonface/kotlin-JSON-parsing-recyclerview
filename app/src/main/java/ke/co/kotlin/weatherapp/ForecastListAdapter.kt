package ke.co.kotlin.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Amuri Bonface on 3/26/2018.
 */
class ForecastListAdapter(val items:List<String>):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent?.context))

    }

    override fun getItemCount(): Int = items.size
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}