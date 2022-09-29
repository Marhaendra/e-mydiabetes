package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentSplashBinding
import id.hendra.e_mydiabetes.helper.DatastoreManager
import id.hendra.e_mydiabetes.helper.viewModelsFactory
import id.hendra.e_mydiabetes.viewmodel.DatastoreViewModel
import kotlinx.coroutines.delay


class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val pref: DatastoreManager by lazy { DatastoreManager(requireContext()) }
    private val dataStore: DatastoreViewModel by viewModelsFactory { DatastoreViewModel(pref) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashTime: Long = 3000

        lifecycleScope.launchWhenCreated {
            splashToLogin(splashTime)
        }

    }

    private suspend fun splashToLogin(time: Long){
        delay(time)
        loginValidate()
    }


    private fun loginValidate(){
        dataStore.getLoginState().observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_splashFragment_to_bodyMeasFragment)
        }
    }


}