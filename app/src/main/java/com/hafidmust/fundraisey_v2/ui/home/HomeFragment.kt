package com.hafidmust.fundraisey_v2.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hafidmust.fundraisey_v2.R
import com.hafidmust.fundraisey_v2.data.preferences.DatastorePreferences
import com.hafidmust.fundraisey_v2.data.preferences.dataStore
import com.hafidmust.fundraisey_v2.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var pref: DatastorePreferences
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMain = view.findViewById<RecyclerView>(R.id.rv_loan)
        pref = DatastorePreferences.getInstance(requireContext().dataStore)
        pref.getToken().asLiveData().observe(viewLifecycleOwner) {
            Log.d("token", it)
        }
        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.data.observe(viewLifecycleOwner) {
            val homeAdapter = HomeAdapter(it)
            rvMain.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = homeAdapter
            }
            homeAdapter.setOnItemClickCallback(object : HomeAdapter.OnItemClickCallback {
                override fun onItemClicked(id: Int) {
                    Log.d("data id = ", id.toString())
//                    Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_detailFragment)
                    val toDetailFragment =
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                    toDetailFragment.id = id
                    view.findNavController().navigate(toDetailFragment)
                }
            })
        }

        binding.appBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.toProfile -> {
                    val toProfile = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                    view.findNavController().navigate(toProfile)
                    true
                }

                else -> false
            }
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}