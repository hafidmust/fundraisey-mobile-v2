package com.hafidmust.fundraisey_v2.ui.payment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hafidmust.fundraisey_v2.R
import com.hafidmust.fundraisey_v2.databinding.FragmentPaymentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PaymentFragment()
    }

    private lateinit var viewModel: PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loanId = PaymentFragmentArgs.fromBundle(arguments as Bundle).loanId
        Log.d("loanId payment : ", "$loanId")

        binding.btnPay.setOnClickListener {
            val toDetailPayment = PaymentFragmentDirections.actionPaymentFragmentToPaymentDetailFragment()
            toDetailPayment.loanId = loanId
            toDetailPayment.paymentAgentId = 1
            toDetailPayment.amount = 1000000
            view.findNavController().navigate(toDetailPayment)

//                runBlocking {
//                    delay(1000L)
//                    showDialog()
//                }

        }
    }

    private suspend fun showDialog() {
        context?.let {
            MaterialAlertDialogBuilder(it)
                .setIcon(R.drawable.round_home_24)
                .setTitle("Thank you for participating to donate")
                .setOnDismissListener {
                    Toast.makeText(context, "WKwkwkwkw", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

}