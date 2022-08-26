package com.example.f1calendarOP.presentation.racedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1calendarOP.R
import com.example.f1calendarOP.domain.usecases.GetRaceDetailByIdUseCase
import com.example.f1calendarOP.presentation.MainActivity
import javax.inject.Inject

class RaceDetailFragment : Fragment(R.layout.fragment_race_detail) {

    private val raceDetailAdapter : RaceDetailAdapter by lazy { RaceDetailAdapter() }

    private val args by navArgs<RaceDetailFragmentArgs>()
    private val raceInfo by lazy { args.raceInfo }
    private lateinit var raceDetailViewModel: RaceDetailViewModel

    @Inject
    lateinit var getRaceDetailByIdUseCase: GetRaceDetailByIdUseCase

    override fun onCreate(savedInstanceState: Bundle?) {

        (activity as MainActivity).appComponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listItems : View = inflater.inflate(R.layout.fragment_race_detail, container, false)
        val recyclerView = listItems.findViewById<View>(R.id.recyclerViewDetail) as RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            adapter = raceDetailAdapter
        }
        return listItems
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        raceDetailViewModel = ViewModelProvider(
            this, RaceDetailViewModelFactory(raceModel = raceInfo, getRaceDetailByIdUseCase)
        )[RaceDetailViewModel::class.java]

        raceDetailViewModel.getLiveData().observe(viewLifecycleOwner) {
            raceDetailAdapter.setRaceDetailList(it)
        }
        raceDetailViewModel.getDetailInfo()
    }
}