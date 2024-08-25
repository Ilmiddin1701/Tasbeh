package uz.ilmiddin1701.tasbeh.Utils

import androidx.lifecycle.MutableLiveData

object MyData {
    val tv11Counter = MutableLiveData<Int>()
    val tv22Counter = MutableLiveData<Int>()
    val tv33Counter = MutableLiveData<Int>()
    val page1Data = MutableLiveData<Int>()

    val page2Data = MutableLiveData<Int>()

    val page3Tv11Counter = MutableLiveData<Int>()
    val page3Tv22Counter = MutableLiveData<Int>()
    val page3Data = MutableLiveData<Int>()
    val page3Scroll = MutableLiveData<Boolean>()

    val clearData = MutableLiveData<Boolean>()
}