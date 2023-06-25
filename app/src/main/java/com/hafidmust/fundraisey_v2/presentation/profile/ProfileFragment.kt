package com.hafidmust.fundraisey_v2.presentation.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hafidmust.fundraisey_v2.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var _binding: FragmentProfileBinding
    private val binding get() = _binding

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvPersonalData.setOnClickListener {
            val toPersonalDataFragment =
                ProfileFragmentDirections.actionProfileFragmentToPersonalDataFragment()
            view.findNavController().navigate(toPersonalDataFragment)
        }

        binding.changePassword.setOnClickListener {
            val toChangePasswordFragment =
                ProfileFragmentDirections.actionProfileFragmentToChangePasswordFragment()
            view.findNavController().navigate(toChangePasswordFragment)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}