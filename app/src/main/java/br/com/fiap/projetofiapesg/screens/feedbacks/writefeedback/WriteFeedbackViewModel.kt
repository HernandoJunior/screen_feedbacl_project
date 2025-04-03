package br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WriteFeedbackViewModel: ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _checked = MutableLiveData<Boolean>()
    val checked : LiveData<Boolean> = _checked

    private val _expandedList = MutableLiveData<Boolean>()
    val expanded : LiveData<Boolean> = _expandedList

    private val _contractList = MutableLiveData<Boolean>()
    val contractList : LiveData<Boolean> = _contractList

    fun onFeedBackChange(textFeedback: String){
        _text.value = textFeedback
    }

    fun onCheckedBox(checkedBox: Boolean){
        _checked.value = checkedBox
    }

    fun onExpandedList(expanded: Boolean){
        _expandedList.value = expanded
    }
}