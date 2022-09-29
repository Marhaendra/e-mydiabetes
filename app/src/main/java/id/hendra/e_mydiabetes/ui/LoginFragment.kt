package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.data.viewmodel.FirebaseViewModel
import id.hendra.e_mydiabetes.databinding.FragmentLoginBinding
import id.hendra.e_mydiabetes.helper.Resource
import id.hendra.e_mydiabetes.viewmodel.DatastoreViewModel

class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FirebaseViewModel

    private val dataStore : DatastoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        togglePassword()
        button()
    }

    private fun togglePassword(){
        binding.apply {
            btnPassword.setOnClickListener{
                if(btnPassword.text.toString() == "Show"){
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                    btnPassword.setBackgroundResource(R.drawable.ic_eye)
                    btnPassword.text = "Hide"
                } else{
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                    btnPassword.setBackgroundResource(R.drawable.ic_eyeslash)
                    btnPassword.text = "Show"
                }
            }
        }
    }

    private fun button(){
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_landingFragment)
            }

            btnLogin.setOnClickListener {
                login()
                findNavController().navigate(R.id.action_loginFragment_to_bodyMeasFragment)
            }
        }
    }

    private fun login(){
        viewModel = ViewModelProvider(this)[FirebaseViewModel::class.java]

            viewModel.login(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )

        viewModel.userLoginStatus.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Toast.makeText(context, "Berhasil Masuk", Toast.LENGTH_SHORT)
                        .show()
                    dataStore.saveLoginState(true)
                }
                is Resource.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //validation
//    private fun validation(){
//        binding.apply {
//            btnLogin.setOnClickListener {
//
//                val email = etEmail.text.toString()
//                val password = etPassword.text.toString()
//
//                if (email.isEmpty()){
//                    binding.etEmail.error = "Email Harus Diisi"
//                    binding.etEmail.requestFocus()
//                    return@setOnClickListener
//                }
//
//                if (!Patterns.PHONE.matcher(email).matches()){
//                    binding.etEmail.error = "Email Tidak Valid"
//                    binding.etEmail.requestFocus()
//                    return@setOnClickListener
//                }
//
//                if (password.isEmpty()){
//                    binding.etPassword.error = "Password Harus Diisi"
//                    binding.etPassword.requestFocus()
//                    return@setOnClickListener
//                }
//
//                if (password.length < 6){
//                    binding.etPassword.error = "Password Minimal 6 Karakter"
//                    binding.etPassword.requestFocus()
//                    return@setOnClickListener
//                }
//            }
//        }
//    }

    //Login
//    private fun login(){
//        val email = binding.etEmail.text.toString()
//        val password = binding.etPassword.text.toString()
//
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
//            if (it.isSuccessful){
//                Toast.makeText(this.requireContext(), "Berhasil", Toast.LENGTH_SHORT).show()
//                dataStore.saveLoginState(true)
//                findNavController().navigate(R.id.action_loginFragment_to_bodyMeasFragment)
//            }else{
//                Toast.makeText(this.requireContext(), "Password atau Email Salah", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}