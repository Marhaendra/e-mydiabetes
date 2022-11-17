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

    }
}