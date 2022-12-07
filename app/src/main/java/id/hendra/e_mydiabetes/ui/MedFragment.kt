package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentHbA1cBinding
import id.hendra.e_mydiabetes.databinding.FragmentMedBinding
import kotlinx.android.synthetic.main.layout_navbar.view.*


class MedFragment : Fragment() {

    private var _binding : FragmentMedBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation()
    }

    private fun navigation(){
        binding.footer.footer_vital?.setOnClickListener{
            findNavController().navigate(R.id.action_medFragment_to_vitalMeasFragment)
        }
        binding.footer.footer_body?.setOnClickListener{
            findNavController().navigate(R.id.action_medFragment_to_bodyMeasFragment)
        }
    }

}