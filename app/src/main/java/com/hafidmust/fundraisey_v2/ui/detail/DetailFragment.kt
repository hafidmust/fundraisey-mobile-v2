package com.hafidmust.fundraisey_v2.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hafidmust.fundraisey_v2.data.response.DataDetail
import com.hafidmust.fundraisey_v2.databinding.FragmentDetailBinding
import com.hafidmust.fundraisey_v2.ui.payment.PaymentFragmentArgs

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get id
        id = DetailFragmentArgs.fromBundle(arguments as Bundle).id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel = ViewModelProvider(this)[DetailViewModel::class.java]
        id?.let { viewmodel.getDetailById(it) }
        viewmodel.dataDetail.observe(viewLifecycleOwner){
            setupView(it)
        }

        binding.btnFundNow.setOnClickListener {
            val toPaymentFragmentDirections = DetailFragmentDirections.actionDetailFragmentToPaymentFragment()
            toPaymentFragmentDirections.loanId = 4
            it.findNavController().navigate(toPaymentFragmentDirections)
        }

    }

    private fun setupView(dataDetail: DataDetail) {
        binding.tvProject.text = dataDetail.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}