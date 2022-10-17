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

        moveToBody()
    }

    private fun moveToBody(){
        binding.footer?.footer_body?.setOnClickListener{
            findNavController().navigate(R.id.action_vitalMeasFragment_to_bodyMeasFragment)
            heart_icon.setImageResource(R.drawable.ic_heart_c)
            ruler_icon.setImageResource(R.drawable.ic_ruler)
        }
    }
//    text color
//    TextView textview p new TextView(this);
//    textview.setMovementMethod(new ScrollingMethod());
//    textview.setText(Html.fromHtml("Today: <font color=green>2</font>\nTomorrow: <font color=green>8</font>\nNext two weeks: <font color=green>45</font>");
//    textview.setTextSize(16);
//    textview.setTypeFace(null, TypeFace.BOLD);
//    setContentView(textview);

}