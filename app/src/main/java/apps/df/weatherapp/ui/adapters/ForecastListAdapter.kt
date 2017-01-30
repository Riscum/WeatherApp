package apps.df.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import apps.df.weatherapp.domain.model.ForecastList

/**
 * Created by domingos.ferreira on 27/01/2017.
 */


class ForecastListAdapter(val weekForecast: ForecastList ): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        return ViewHolder(TextView(parent.getContext()))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}