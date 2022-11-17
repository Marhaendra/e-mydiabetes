package id.hendra.e_mydiabetes.ui.vital

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentBloodPressureBinding

class BloodPressureFragment : Fragment() {

    private var _binding : FragmentBloodPressureBinding?= null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBloodPressureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button()
    }

    //Back & Save Navigation
    private fun button() {
        binding.apply {
            btnBack.setOnClickListener{
                findNavController().navigate(R.id.action_bloodPressureFragment_to_vitalMeasFragment)
            }
            btnSave.setOnClickListener {
            }
        }
    }
}