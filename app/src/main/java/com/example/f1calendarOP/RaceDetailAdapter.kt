package com.example.f1calendarOP

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class RaceDetailAdapter : RecyclerView.Adapter<RaceDetailAdapter.RaceDetailAdapterViewHolder>() {

    private val raceDetail = mutableListOf<RaceDetailModel>()

    fun updateList(raceDetail: List<RaceDetailModel>){
        this.raceDetail.clear()
        this.raceDetail.addAll(raceDetail)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceDetailAdapterViewHolder {
        val layout = when(viewType){
            TYPE_HEADER -> R.layout.item_detail_header
            TYPE_SESSION1 -> R.layout.item_detail_session1
            TYPE_SESSION2 -> R.layout.item_detail_session2
            TYPE_SESSION3 -> R.layout.item_detail_session3
            TYPE_SESSION4 -> R.layout.item_detail_session4
            TYPE_SESSION5 -> R.layout.item_detail_session5
            else -> throw IllegalArgumentException("Invalid view type")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return RaceDetailAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceDetailAdapterViewHolder, position: Int) {
        holder.bind(raceDetail[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when(raceDetail[position]) {
            is RaceDetailModel.Header -> TYPE_HEADER
            is RaceDetailModel.Session1 -> TYPE_SESSION1
            is RaceDetailModel.Session2 -> TYPE_SESSION2
            is RaceDetailModel.Session3 -> TYPE_SESSION3
            is RaceDetailModel.Session4 -> TYPE_SESSION4
            is RaceDetailModel.Session5 -> TYPE_SESSION5
        }
    }

    override fun getItemCount(): Int = raceDetail.size

    companion object {
        const val TYPE_SESSION1 = 0
        const val TYPE_SESSION2 = 1
        const val TYPE_SESSION3 = 2
        const val TYPE_SESSION4 = 3
        const val TYPE_SESSION5 = 4
        const val TYPE_HEADER = 5
    }

    class RaceDetailAdapterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private fun bindHeader(item: RaceDetailModel.Header){
            itemView.findViewById<TextView>(R.id.tvTrackDetailF1).text = item.track
            itemView.findViewById<TextView>(R.id.tvDateF1_2).text = item.date
            itemView.findViewById<ImageView>(R.id.flagDetailF1)?.setImageResource(item.flag)
        }
        private fun bindSession1(item: RaceDetailModel.Session1){
            itemView.findViewById<TextView>(R.id.tvSessionDate1).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName1).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime1).text = item.sessionTime
        }
        private fun bindSession2(item: RaceDetailModel.Session2){
            itemView.findViewById<TextView>(R.id.tvSessionDate2).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName2).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime2).text = item.sessionTime
        }
        private fun bindSession3(item: RaceDetailModel.Session3){
            itemView.findViewById<TextView>(R.id.tvSessionDate3).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName3).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime3).text = item.sessionTime
        }
        private fun bindSession4(item: RaceDetailModel.Session4){
            itemView.findViewById<TextView>(R.id.tvSessionDate4).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName4).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime4).text = item.sessionTime
        }
        private fun bindSession5(item: RaceDetailModel.Session5){
            itemView.findViewById<TextView>(R.id.tvSessionDate5).text = item.sessionDate
            itemView.findViewById<TextView>(R.id.tvSessionName5).text = item.sessionName
            itemView.findViewById<TextView>(R.id.tvSessionTime5).text = item.sessionTime
        }

        fun bind(raceDetailModel: RaceDetailModel){
            when(raceDetailModel){
                is RaceDetailModel.Header -> bindHeader(raceDetailModel)
                is RaceDetailModel.Session1 -> bindSession1(raceDetailModel)
                is RaceDetailModel.Session2 -> bindSession2(raceDetailModel)
                is RaceDetailModel.Session3 -> bindSession3(raceDetailModel)
                is RaceDetailModel.Session4 -> bindSession4(raceDetailModel)
                is RaceDetailModel.Session5 -> bindSession5(raceDetailModel)
            }
        }
    }
}