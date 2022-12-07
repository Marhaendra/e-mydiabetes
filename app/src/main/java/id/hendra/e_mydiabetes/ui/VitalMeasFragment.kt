package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentVitalMeasBinding
import kotlinx.android.synthetic.main.layout_navbar.*
import kotlinx.android.synthetic.main.layout_navbar.view.*


class VitalMeasFragment : Fragment() {

    private var _binding : FragmentVitalMeasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVitalMeasBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation()
        subMenuNav()
    }

    private fun navigation(){
        binding.footer.footer_body?.setOnClickListener{
            findNavController().navigate(R.id.action_vitalMeasFragment_to_bodyMeasFragment)
        }
        binding.footer.footer_medicine?.setOnClickListener{
            findNavController().navigate(R.id.action_vitalMeasFragment_to_medFragment)
        }
    }

    private fun subMenuNav(){
        binding.apply {
            bloodSugarLinear.setOnClickListener {
                findNavController().navigate(R.id.action_vitalMeasFragment_to_bloodSugarFragment)
            }
            bloodPressureLinear.setOnClickListener {
                findNavController().navigate(R.id.action_vitalMeasFragment_to_bloodPressureFragment)
            }
            foodLinear.setOnClickListener {
                findNavController().navigate(R.id.action_vitalMeasFragment_to_foodFragment)
            }
            activityLinear.setOnClickListener {
                findNavController().navigate(R.id.action_vitalMeasFragment_to_activityFragment)
            }
            hba1cLinear.setOnClickListener {
                findNavController().navigate(R.id.action_vitalMeasFragment_to_hbA1cFragment)
            }
        }
    }
}