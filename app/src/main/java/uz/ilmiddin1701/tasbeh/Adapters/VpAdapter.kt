package uz.ilmiddin1701.tasbeh.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.ilmiddin1701.tasbeh.Fragments.Zikr1Fragment
import uz.ilmiddin1701.tasbeh.Fragments.Zikr2Fragment
import uz.ilmiddin1701.tasbeh.Fragments.Zikr3Fragment

class VpAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Zikr1Fragment()
            1 -> Zikr2Fragment()
            else -> Zikr3Fragment()
        }
    }

}