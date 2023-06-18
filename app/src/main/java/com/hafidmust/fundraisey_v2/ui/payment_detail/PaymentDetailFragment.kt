package com.hafidmust.fundraisey_v2.ui.payment_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hafidmust.fundraisey_v2.R
import com.hafidmust.fundraisey_v2.databinding.FragmentPaymentBinding
import com.hafidmust.fundraisey_v2.databinding.FragmentPaymentDetailBinding
import com.hafidmust.fundraisey_v2.ui.widget.CustomDialog

class PaymentDetailFragment : Fragment() {

    private var _binding: FragmentPaymentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PaymentDetailFragment()
    }

    private lateinit var viewModel: PaymentDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loanId = PaymentDetailFragmentArgs.fromBundle(arguments as Bundle).loanId
        val paymentId = PaymentDetailFragmentArgs.fromBundle(arguments as Bundle).paymentAgentId
        val amount = PaymentDetailFragmentArgs.fromBundle(arguments as Bundle).amount

        Log.d("DATA", "$loanId $paymentId $amount")

        binding.btnOtherInvesment.setOnClickListener {
//            CustomDialog().show(fragmentManager,"SuccessDialog")
            CustomDialog().show(parentFragmentManager,"SuccessDialog")
        }
    }

}