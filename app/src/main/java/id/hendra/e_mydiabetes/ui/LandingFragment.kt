package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentLandingBinding
import id.hendra.e_mydiabetes.helper.DatastoreManager
import id.hendra.e_mydiabetes.helper.viewModelsFactory
import id.hendra.e_mydiabetes.viewmodel.DatastoreViewModel



class LandingFragment : Fragment() {

    private var _binding : FragmentLandingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button()
    }



    //Register & Login Navigation
    private fun button() {
        binding.apply {
            btnLogin.setOnClickListener{
                findNavController().navigate(R.id.action_landingFragment_to_loginFragment)
            }
            btnRegister.setOnClickListener{
                findNavController().navigate(R.id.action_landingFragment_to_RegisterFragment)
            }
        }
    }

}