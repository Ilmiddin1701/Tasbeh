package uz.ilmiddin1701.tasbeh.Fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.PopupMenu
import uz.ilmiddin1701.tasbeh.R
import uz.ilmiddin1701.tasbeh.Utils.MyData
import uz.ilmiddin1701.tasbeh.Utils.MySharedPreferences
import uz.ilmiddin1701.tasbeh.databinding.FragmentZikr1Binding

class Zikr1Fragment : Fragment() {
    private val binding by lazy { FragmentZikr1Binding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            tv1Counter.text =
                MySharedPreferences.tv11Counter.toString() + " marta    barchasi: ${MySharedPreferences.tv11Counter * 33} ta"
            tv2Counter.text =
                MySharedPreferences.tv22Counter.toString() + " marta    barchasi: ${MySharedPreferences.tv22Counter * 33} ta"
            tv3Counter.text =
                MySharedPreferences.tv33Counter.toString() + " marta    barchasi: ${MySharedPreferences.tv33Counter * 33} ta"
            MyData.tv11Counter.observe(viewLifecycleOwner) {
                tv1Counter.text = "$it marta    barchasi: ${it * 33} ta"
            }
            MyData.tv22Counter.observe(viewLifecycleOwner) {
                tv2Counter.text = "$it marta    barchasi: ${it * 33} ta"
            }
            MyData.tv33Counter.observe(viewLifecycleOwner) {
                tv3Counter.text = "$it marta    barchasi: ${it * 33} ta"
            }
            MyData.clearData.observe(viewLifecycleOwner) {
                if (it) {
                    tv1Counter.text = "0 marta barchasi: 0 ta"
                    tv2Counter.text = "0 marta barchasi: 0 ta"
                    tv3Counter.text = "0 marta barchasi: 0 ta"
                }
            }
            MyData.page1Data.observe(viewLifecycleOwner) {
                if (it == 3) {
                    card.strokeColor = Color.parseColor("#FF0000")
                } else {
                    card.strokeColor = Color.parseColor("#FFB874")
                }
            }
            card.setOnClickListener {
                val popupMenu = PopupMenu(requireContext(), card)
                popupMenu.inflate(R.menu.popup_menu)
                popupMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.menu_1 -> {
                            selected.text = "Subhan Alloh"
                            MyData.page1Data.postValue(0)
                        }

                        R.id.menu_2 -> {
                            selected.text = "Alhamdulillah"
                            MyData.page1Data.postValue(1)
                        }

                        R.id.menu_3 -> {
                            selected.text = "Allohu Akbar"
                            MyData.page1Data.postValue(2)
                        }
                    }
                    true
                }
                popupMenu.show()
            }
        }
        return binding.root
    }
}