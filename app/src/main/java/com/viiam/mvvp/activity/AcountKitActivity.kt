package com.viiam.mvvp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.facebook.accountkit.AccountKitLoginResult
import com.facebook.accountkit.ui.AccountKitActivity
import com.facebook.accountkit.ui.AccountKitConfiguration
import com.facebook.accountkit.ui.LoginType
import com.facebook.accountkit.ui.UIManager
import com.viiam.mvvp.R

class AcountKitActivity : BaseActivity() {


    val APP_REQUEST_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startLogin(LoginType.PHONE)

    }

    private fun startLogin(email: LoginType) {

        if(email == LoginType.EMAIL) {
            val intent = Intent(this, AccountKitActivity::class.java)
            val configurationBuilder = AccountKitConfiguration.AccountKitConfigurationBuilder(
                    LoginType.EMAIL,
                    AccountKitActivity.ResponseType.TOKEN)
            intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                    configurationBuilder.build())
            startActivityForResult(intent, APP_REQUEST_CODE)
        }
        else if(email == LoginType.PHONE)
        {
            val intent = Intent(this, AccountKitActivity::class.java)

            val configurationBuilder = AccountKitConfiguration.AccountKitConfigurationBuilder(
                    LoginType.PHONE,
                    AccountKitActivity.ResponseType.TOKEN)
            val uiManager: UIManager

            intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                    configurationBuilder.build())
            startActivityForResult(intent, APP_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == APP_REQUEST_CODE) { // confirm that this response matches your request AccountKitLoginResult loginResult = data . getParcelableExtra (

            var  loginResult: AccountKitLoginResult = data!!.getParcelableExtra(AccountKitLoginResult.RESULT_KEY)
            var toastMessage: String
            if(loginResult.getError() != null)
            {
                toastMessage = loginResult.getError()!!.getErrorType().getMessage()
                Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();


            }
            else if ( loginResult.wasCancelled())
            {
                toastMessage = "Login Canceled"
                Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

            }
            else{
                if ( loginResult.getAccessToken() != null )
                {
                    toastMessage = "Success:" + loginResult.getAccessToken()!!.getAccountId()
                }
                else
                {
                    toastMessage = String.format( "Success :" + loginResult.getAuthorizationCode()!!.substring(0,10))
                    Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

                }
                val intent = Intent(this,InformationAccountActivity::class.java)
                startActivity(intent)
            }
        }
    }
}