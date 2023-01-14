package com.example.recyclerviewexinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexinclass.data.model.Company
import com.example.recyclerviewexinclass.databinding.ActivityCompanyDetailBinding
import kotlinx.android.synthetic.main.activity_company_detail.*

class CompanyDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_detail)
        val binding : ActivityCompanyDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_company_detail)
        val selectedCompany = intent.getSerializableExtra("COMPANY") as Company
        binding.company = selectedCompany

        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
        lateinit var company: Company



    }


}