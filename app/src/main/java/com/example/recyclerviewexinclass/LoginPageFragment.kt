package com.example.recyclerviewexinclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.recyclerviewexinclass.databinding.FragmentLoginpageBinding


class LoginPageFragment: Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginpageBinding>(inflater, R.layout.fragment_loginpage, container, false)



        binding.btnLogin.setOnClickListener { view: View ->

            val userName = binding.textInputLayout.editText?.text.toString()
            val password = binding.textInputLayout2.editText?.text.toString()

            //view.findNavController().navigate(R.id.navigation)

            //view.findNavController().navigate(LoginPageFragmentDirections.actionLoginPageFragmentToItemLayoutFragment())
            view.findNavController().navigate(LoginPageFragmentDirections.actionLoginPageFragmentToLoginActivity())
            //action_loginPageFragment_to_loginActivity
            //action_loginPageFragment_to_itemLayoutFragment
        }

        binding.signup.setOnClickListener { view: View ->

            view.findNavController().navigate(LoginPageFragmentDirections.actionLoginPageFragmentToRegisterActivity())
        //action_loginPageFragment_to_signUpActivity
            //action_loginPageFragment_to_registerActivity
        }

        return binding.root
    }

}


