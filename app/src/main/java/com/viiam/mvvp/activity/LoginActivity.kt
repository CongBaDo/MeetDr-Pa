package com.viiam.mvvp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import android.view.View
import com.viiam.mvvp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var transformationMethod:TransformationMethod
    override fun onClick(v: View?) {
        when(v){
            buttonDeleteText -> editTextPhoneNumber.setText("")
            buttonShowPass -> editTextPassword.transformationMethod = if(editTextPassword.transformationMethod == null) PasswordTransformationMethod() else null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonDeleteText.setOnClickListener(this)
        buttonShowPass.setOnClickListener(this)

        transformationMethod = editTextPassword.transformationMethod
    }
}
