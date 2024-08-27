package uz.ilmiddin1701.tasbeh.Fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.ilmiddin1701.tasbeh.Utils.MyData
import uz.ilmiddin1701.tasbeh.Utils.MySharedPreferences
import uz.ilmiddin1701.tasbeh.databinding.FragmentZikr3Binding

class Zikr3Fragment : Fragment() {
    private val binding by lazy { FragmentZikr3Binding.inflate(layoutInflater) }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            tv1Counter.text = MySharedPreferences.page3Tv11Counter.toString() + " marta    barchasi: ${MySharedPreferences.page3Tv11Counter*33} ta"
            tv2Counter.text = MySharedPreferences.page3Tv22Counter.toString() + " marta    barchasi: ${MySharedPreferences.page3Tv22Counter*33} ta"
            MyData.page3Tv11Counter.observe(viewLifecycleOwner) {
                tv1Counter.text = "$it marta    barchasi: ${it*33} ta"
            }
            MyData.page3Tv22Counter.observe(viewLifecycleOwner) {
                tv2Counter.text = "$it marta    barchasi: ${it*33} ta"
            }
            MyData.clearData.observe(viewLifecycleOwner) {
                if (it) {
                    tv1Counter.text = "0 marta    barchasi: 0 ta"
                    tv2Counter.text = "0 marta    barchasi: 0 ta"
                }
            }
            tv1.setOnClickListener {
                tv1.setTextColor(Color.parseColor("#FFB874"))
                tv2.setTextColor(Color.parseColor("#FFFFFF"))
                MyData.page3Data.postValue(0)
            }
            tv2.setOnClickListener {
                tv2.setTextColor(Color.parseColor("#FFB874"))
                tv1.setTextColor(Color.parseColor("#FFFFFF"))
                MyData.page3Data.postValue(1)
            }
        }
        return binding.root
    }
}