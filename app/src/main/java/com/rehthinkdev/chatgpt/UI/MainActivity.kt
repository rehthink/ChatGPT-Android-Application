package com.rehthinkdev.chatgpt.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rehthinkdev.chatgpt.Utils.MyViewModel
import com.rehthinkdev.chatgpt.Model.RequestBody
import com.rehthinkdev.chatgpt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MyViewModel by viewModels()


    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idEdtQuery.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                binding.idTVResponse.text = "Please wait.."
                if (binding.idEdtQuery.text.toString().isNotEmpty()) {
                    val requestBody = RequestBody("text-davinci-003",binding.idEdtQuery.text.toString(),100,
                        0f, 1f,0, 0, "\n")

                        viewModel.sendMessage(requestBody)

                } else {
                    Toast.makeText(this, "Please enter your query..", Toast.LENGTH_SHORT).show()
                }
                return@OnEditorActionListener true
            }
            false
        })

        viewModel.response.observe(this, Observer {

            if (it !== null) {
                binding.idTVResponse.text = binding.idEdtQuery.text.toString() + it
            }else{
                Toast.makeText(this, "Please Retry...", Toast.LENGTH_SHORT).show()
            }

        })
    }
}