package com.rehthinkdev.chatgpt.Utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehthinkdev.chatgpt.Model.RequestBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    fun sendMessage(requestBody: RequestBody) {
        viewModelScope.launch {
            val response = repository.getPrompt(requestBody)

            _response.value = response.choices[0].text

            Log.e("TAG", response.choices[0].text)
            Log.e("TAG", response.choices[0].text)
            Log.e("TAG", response.choices[0].index.toString())
            Log.e("TAG", response.choices[0].finish_reason)
            Log.e("TAG", response.model)
            Log.e("TAG", response.usage.total_tokens.toString())
        }
    }

}