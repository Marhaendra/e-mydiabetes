package id.hendra.e_mydiabetes.ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import id.hendra.e_mydiabetes.data.viewmodel.FirebaseViewModel
import id.hendra.e_mydiabetes.databinding.FragmentRegisterBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.hendra.e_mydiabetes.R
import id.hendra.e_mydiabetes.helper.Resource

class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FirebaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        togglePassword()
//        validation()
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
            btnConfirmPassword.setOnClickListener{
                if(btnConfirmPassword.text.toString() == "Show"){
                    etConfirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    etConfirmPassword.setSelection(etConfirmPassword.length())
                    btnConfirmPassword.setBackgroundResource(R.drawable.ic_eye)
                    btnConfirmPassword.text = "Hide"
                } else{
                    etConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    etConfirmPassword.setSelection(etConfirmPassword.length())
                    btnConfirmPassword.setBackgroundResource(R.drawable.ic_eyeslash)
                    btnConfirmPassword.text = "Show"
                }
            }
        }
    }

    //Back & Register Navigation
    private fun button() {
        binding.apply {
            btnBack.setOnClickListener{
                findNavController().navigate(R.id.action_RegisterFragment_to_landingFragment)
            }
            btnRegister.setOnClickListener {
                register()
                findNavController().navigate(R.id.action_RegisterFragment_to_loginFragment)
            }
        }
    }

    private fun register(){

        viewModel = ViewModelProvider(this)[FirebaseViewModel::class.java]

        viewModel.register(
            binding.etName.text.toString(),
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        )

        viewModel.userRegistrationStatus.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Toast.makeText(context, "Berhasil Daftar", Toast.LENGTH_SHORT)
                        .show()
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
//            btnRegister.setOnClickListener {
//
//                val name = etName.text.toString()
//                val email = etEmail.text.toString()
//                val password = etPassword.text.toString()
//                val passwordConfirm = etConfirmPassword.text.toString()
//
//                if (name.isEmpty()){
//                    binding.etName.error = "Nama Harus Diisi"
//                    binding.etName.requestFocus()
//                    return@setOnClickListener
//                }
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
//                if (passwordConfirm != password){
//                    binding.etConfirmPassword.error = "Password Tidak Sama"
//                    binding.etConfirmPassword.requestFocus()
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

    //firebase register
//    private fun registerFirebase(){
//        val name = binding.etName.text.toString()
//        val email = binding.etEmail.text.toString()
//        val password = binding.etPassword.text.toString()
//
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        firebaseAuth.createUserWithEmailAndPassword(email , password)
//            .addOnCompleteListener{
//                if (it.isSuccessful){
//                    Toast.makeText(this.requireContext(), "Berhasil", Toast.LENGTH_SHORT).show()
//                    dataStore.saveName(name)
//                    findNavController().navigate(R.id.action_RegisterFragment_to_loginFragment)
//                }else{
//                    Toast.makeText(this.requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()
//                }
//            }
//    }

}