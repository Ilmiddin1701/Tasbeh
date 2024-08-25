package uz.ilmiddin1701.tasbeh.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.ilmiddin1701.tasbeh.R
import uz.ilmiddin1701.tasbeh.Utils.MyData
import uz.ilmiddin1701.tasbeh.Utils.MySharedPreferences
import uz.ilmiddin1701.tasbeh.databinding.FragmentZikr2Binding

class Zikr2Fragment : Fragment() {
    private val binding by lazy { FragmentZikr2Binding.inflate(layoutInflater) }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            tv1Counter.text = MySharedPreferences.page2Tv11Counter.toString() + " marta    barchasi: ${MySharedPreferences.page2Tv11Counter*33} ta"
            MyData.page2Data.observe(viewLifecycleOwner) {
                tv1Counter.text = "$it marta    barchasi: ${it*33} ta"
            }
            MyData.clearData.observe(viewLifecycleOwner) {
                if (it) {
                    tv1Counter.text = "0 marta"
                }
            }
        }
        return binding.root
    }
}