package com.viiam.mvvp.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import com.facebook.accountkit.Account
import com.facebook.accountkit.AccountKit
import com.facebook.accountkit.AccountKitCallback
import com.facebook.accountkit.AccountKitError
import kotlinx.android.synthetic.main.layout_info_account.*
import android.graphics.BitmapFactory
import android.R.attr.data
import android.R.attr.name
import android.provider.MediaStore
import android.graphics.Bitmap
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import java.util.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.viiam.mvvp.R


class InformationAccountActivity : BaseActivity(), View.OnFocusChangeListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {

    val GET_IMAGE_FROM_GALLERY = 111  //gallery
    val NEW_IMAGE = 112
    var CHECK_FIRSTNAME = false
    var CHECK_LASTNAME = false
    var CHECK_NAMSINH = false
    var CHECK_DIACHI = false
    var CHECK_EMAIL = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.viiam.mvvp.R.layout.layout_info_account)

        checkInput();

        imgEdit.setOnClickListener(this)
        btnTiepTuc.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        var id = v!!.id
        when (id) {
            R.id.imgEdit -> {
                val listItem = arrayOf("Chụp ảnh mới", "Chọn ảnh có sẵn")
                val iBuilder = AlertDialog.Builder(this)
                iBuilder.setTitle("Ảnh đại diện")
                iBuilder.setItems(listItem, { _, which ->
                    if (which == 0) {
                        newImage()
                    } else {
                        getImageFromGallary()
                    }
                })

                // Create a new AlertDialog using builder object
                val dialog = iBuilder.create()

                // Finally, display the alert dialog
                dialog.show()

            }
            R.id.btnTiepTuc -> {
                if (CHECK_FIRSTNAME && CHECK_LASTNAME && CHECK_DIACHI && CHECK_EMAIL && CHECK_NAMSINH) {
                    if (rdbNam.isChecked || rdbNu.isChecked) {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, resources.getString(R.string.bankhongduocdetrong), Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(this, resources.getString(R.string.bankhongduocdetrong), Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GET_IMAGE_FROM_GALLERY) {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.getData())
                imgDaidien.setImageBitmap(bitmap)

            } else if (requestCode == NEW_IMAGE) {
                val bitmap = data!!.getExtras().get("data") as Bitmap
                imgDaidien.setImageBitmap(bitmap)
            }
        }
    }

    private fun getImageFromGallary() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GET_IMAGE_FROM_GALLERY);

    }

    private fun newImage() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, NEW_IMAGE);
    }

    private fun checkInput() {
        edtFirstName.setOnFocusChangeListener(this)
        edtLastName.setOnFocusChangeListener(this)
        edtNamSinh.setOnFocusChangeListener(this)
        edtDiaChi.setOnFocusChangeListener(this)
        edtEmail.setOnFocusChangeListener(this)
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        var id = v!!.id
        when (id) {
            R.id.edtFirstName -> {
                if (!hasFocus) {
                    if (edtFirstName.text.trim().toString().isEmpty()) {
//                        input_FirstName.isErrorEnabled = true
//                        input_FirstName.error = resources.getString(R.string.banchuanhapmucnay)
                        CHECK_FIRSTNAME = false
                    } else {
//                        input_FirstName.isErrorEnabled = false
//                        input_FirstName.error = ""
                        CHECK_FIRSTNAME = true
                    }
                }
            }
            R.id.edtLastName -> {
                if (!hasFocus) {
                    if (edtLastName.text.trim().toString().isEmpty()) {
//                        input_LastName.isErrorEnabled = true
//                        input_LastName.error = resources.getString(R.string.banchuanhapmucnay)
                        CHECK_LASTNAME = false
                    } else {
//                        input_LastName.isErrorEnabled = false
//                        input_LastName.error = ""
                        CHECK_LASTNAME = true
                    }
                }
            }
            R.id.edtDiaChi -> {
                if (!hasFocus) {
                    if (edtDiaChi.text.trim().toString().isEmpty()) {
//                        input_DiaChi.isErrorEnabled = true
//                        input_DiaChi.error = resources.getString(R.string.banchuanhapmucnay)
                        CHECK_DIACHI = false
                    } else {
//                        input_DiaChi.isErrorEnabled = false
//                        input_DiaChi.error = ""
                        CHECK_DIACHI = true
                    }
                }
            }
            R.id.edtNamSinh -> {
                if (!hasFocus) {
                    if (edtNamSinh.text.trim().toString().isEmpty()) {
//                        input_NamSinh.isErrorEnabled = true
//                        input_NamSinh.error = resources.getString(R.string.banchuanhapmucnay)
                        CHECK_NAMSINH = false
                    } else {
//                        input_NamSinh.isErrorEnabled = false
//                        input_NamSinh.error = ""
                        CHECK_NAMSINH = true
                    }
                } else {
                    val now = Calendar.getInstance()
                    val dpd = DatePickerDialog.newInstance(
                            this,
                            now.get(Calendar.YEAR), // Initial year selection
                            now.get(Calendar.MONTH), // Initial month selection
                            now.get(Calendar.DAY_OF_MONTH) // Inital day selection
                    )

                    dpd.showsDialog
//                    dpd.show(this.fragmentManager, "")
                }
            }
            R.id.edtEmail -> {
                if (!hasFocus) {
                    if (edtEmail.text.trim().toString() == "" || edtEmail.text.toString() == null) {
//                        input_Email.isErrorEnabled = true
//                        input_Email.error = resources.getString(R.string.banchuanhapmucnay)
                        CHECK_EMAIL = false
                    } else {
                        var boolean = Patterns.EMAIL_ADDRESS.matcher(edtEmail.text.toString()).matches()
                        if (!boolean) {
//                            input_Email.isErrorEnabled = true
//                            input_Email.error = resources.getString(R.string.banchuanhapmucnay)
                            CHECK_EMAIL = false
                        } else {
//                            input_Email.isErrorEnabled = false
//                            input_Email.error = ""
                            CHECK_EMAIL = true
                        }
                    }
                }
            }

        }
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val date = "" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year
        val nametxt = findViewById(com.viiam.mvvp.R.id.edtNamSinh) as EditText
        nametxt.setText(date)
    }


    override fun onResume() {
        super.onResume()
        AccountKit.getCurrentAccount(object : AccountKitCallback<Account> {
            override fun onSuccess(account: Account?) {
                var accountKitId = account!!.getId()
                var phone = account.phoneNumber
                var id = account.id
            }

            override fun onError(p0: AccountKitError?) {
                if (p0 != null) {
                    Log.d("kiemtra", "Email: " + p0.detailErrorCode)
                }
            }

        })
    }

}


