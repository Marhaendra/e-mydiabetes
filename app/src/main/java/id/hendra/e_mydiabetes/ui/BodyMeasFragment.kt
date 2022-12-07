package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.databinding.FragmentBodyMeasBinding
import kotlinx.android.synthetic.main.layout_navbar.*
import kotlinx.android.synthetic.main.layout_navbar.view.*

class BodyMeasFragment : Fragment() {

    private var _binding : FragmentBodyMeasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBodyMeasBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation()
    }

    private fun navigation(){
        binding.footer.footer_vital?.setOnClickListener{
            findNavController().navigate(R.id.action_bodyMeasFragment_to_vitalMeasFragment)
        }
        binding.footer.footer_medicine?.setOnClickListener{
            findNavController().navigate(R.id.action_bodyMeasFragment_to_medFragment)
        }
    }

}