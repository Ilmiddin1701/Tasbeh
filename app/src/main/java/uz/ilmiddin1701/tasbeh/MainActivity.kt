package uz.ilmiddin1701.tasbeh

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import uz.ilmiddin1701.tasbeh.Adapters.VpAdapter
import uz.ilmiddin1701.tasbeh.Utils.MyData
import uz.ilmiddin1701.tasbeh.Utils.MySharedPreferences
import uz.ilmiddin1701.tasbeh.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var vpAdapter: VpAdapter
    @SuppressLint("DefaultLocale", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        vpAdapter = VpAdapter(supportFragmentManager)
        binding.myViewPager.adapter = vpAdapter

        MySharedPreferences.init(this)
        binding.apply {
            time.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://namozvaqti.uz/shahar/toshkent")
                startActivity(intent)
            }
            reset.setOnClickListener {
                reset.animate().rotationBy(360f).setDuration(500).start()
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("Tasbehni tozalash")
                dialog.setMessage("Ushbu amalni bajarishingiz ilovada hisoblangan zikrlar sonini dastlabgi holatiga qaytaradi!")
                dialog.setPositiveButton("Ha") { _, _ ->
                    vibrate(this@MainActivity)
                    MySharedPreferences.tv1Counter = 0
                    MySharedPreferences.tv11Counter = 0
                    MySharedPreferences.tv2Counter = 0
                    MySharedPreferences.tv22Counter = 0
                    MySharedPreferences.tv3Counter = 0
                    MySharedPreferences.tv33Counter = 0
                    countDisplay.text = ""
                    MySharedPreferences.page2Tv1Counter = 0
                    MySharedPreferences.page2Tv11Counter = 0
                    MySharedPreferences.page3Tv1Counter = 0
                    MySharedPreferences.page3Tv11Counter = 0
                    MySharedPreferences.page3Tv2Counter = 0
                    MySharedPreferences.page3Tv22Counter = 0
                    MyData.clearData.postValue(true)
                }
                dialog.setNegativeButton("Yo'q") { _, _ ->
                    vibrate(this@MainActivity)
                }
                dialog.show()
            }
            var positionPage = 0
            myViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    // Bu yerda sahifa qisman surilganda ishla ydi
                }

                override fun onPageSelected(position: Int) {
                    // Bu yerda sahifa to'liq o'zgartirilgan paytda ishlaydi
                    positionPage = position
                    countDisplay.text = ""
                    MyData.page1Data.postValue(4)
                    MyData.page3Scroll.postValue(true)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    // Bu yerda sahifa surilish holati o'zgarganda ishlaydi
                }
            })
            var selectedTv = -1
            MyData.page1Data.observe(this@MainActivity) { tvSelected ->
                when (tvSelected) {
                    0 -> {
                        val strCount = String.format("%02d", MySharedPreferences.tv1Counter)
                        countDisplay.text = strCount
                        selectedTv = 0
                    }
                    1 -> {
                        val strCount = String.format("%02d", MySharedPreferences.tv2Counter)
                        countDisplay.text = strCount
                        selectedTv = 1
                    }
                    2 -> {
                        val strCount = String.format("%02d", MySharedPreferences.tv3Counter)
                        countDisplay.text = strCount
                        selectedTv = 2
                    }
                }
            }
            var selectedTv2 = -1
            MyData.page3Data.observe(this@MainActivity) {
                when (it) {
                    0 -> {
                        val strCount = String.format("%02d", MySharedPreferences.page3Tv1Counter)
                        countDisplay.text = strCount
                        selectedTv2 = 0
                    }
                    1 -> {
                        val strCount = String.format("%02d", MySharedPreferences.page3Tv2Counter)
                        countDisplay.text = strCount
                        selectedTv2 = 1
                    }
                }
            }
            btnAdd.setOnClickListener {
                when (positionPage) {
                    0 -> {
                        var count1 = MySharedPreferences.tv1Counter
                        var count11 = MySharedPreferences.tv11Counter
                        var count2 = MySharedPreferences.tv2Counter
                        var count22 = MySharedPreferences.tv22Counter
                        var count3 = MySharedPreferences.tv3Counter
                        var count33 = MySharedPreferences.tv33Counter
                        when (selectedTv) {
                            0 -> {
                                vibrate(this@MainActivity)
                                btnAdd.animate().rotationBy(20f).setDuration(300).start()
                                count1++
                                if (count1 == 33) {
                                    vibrate2(this@MainActivity)
                                    count1 = 0
                                    countDisplay.text = ""
                                    count11++
                                    MyData.tv11Counter.postValue(count11)
                                    MySharedPreferences.tv11Counter = count11
                                }
                                val strCount = String.format("%02d", count1)
                                countDisplay.text = strCount
                                MySharedPreferences.tv1Counter = count1
                            }
                            1 -> {
                                vibrate(this@MainActivity)
                                btnAdd.animate().rotationBy(20f).setDuration(300).start()
                                count2++
                                if (count2 == 33) {
                                    vibrate2(this@MainActivity)
                                    count2 = 0
                                    countDisplay.text = ""
                                    count22++
                                    MyData.tv22Counter.postValue(count22)
                                    MySharedPreferences.tv22Counter = count22
                                }
                                val strCount = String.format("%02d", count2)
                                countDisplay.text = strCount
                                MySharedPreferences.tv2Counter = count2
                            }
                            2 -> {
                                vibrate(this@MainActivity)
                                btnAdd.animate().rotationBy(20f).setDuration(300).start()
                                count3++
                                if (count3 == 33) {
                                    vibrate2(this@MainActivity)
                                    count3 = 0
                                    countDisplay.text = ""
                                    count33++
                                    MyData.tv33Counter.postValue(count33)
                                    MySharedPreferences.tv33Counter = count33
                                }
                                val strCount = String.format("%02d", count3)
                                countDisplay.text = strCount
                                MySharedPreferences.tv3Counter = count3
                            }
                            else -> {
                                MyData.page1Data.postValue(3)
                            }
                        }
                    }
                    1 -> {
                        vibrate(this@MainActivity)
                        btnAdd.animate().rotationBy(20f).setDuration(300).start()
                        var count1 = MySharedPreferences.page2Tv1Counter
                        var count11 = MySharedPreferences.page2Tv11Counter
                        count1++
                        if (count1 == 33) {
                            vibrate2(this@MainActivity)
                            count1 = 0
                            countDisplay.text = ""
                            count11++
                            MyData.page2Data.postValue(count11)
                            MySharedPreferences.page2Tv11Counter = count11
                        }
                        val strCount = String.format("%02d", count1)
                        countDisplay.text = strCount
                        MySharedPreferences.page2Tv1Counter = count1
                    }
                    2 -> {
                        var count1 = MySharedPreferences.page3Tv1Counter
                        var count11 = MySharedPreferences.page3Tv11Counter
                        var count2 = MySharedPreferences.page3Tv2Counter
                        var count22 = MySharedPreferences.page3Tv22Counter
                        when (selectedTv2) {
                            0 -> {
                                vibrate(this@MainActivity)
                                btnAdd.animate().rotationBy(20f).setDuration(300).start()
                                count1++
                                if (count1 == 33) {
                                    vibrate2(this@MainActivity)
                                    count1 = 0
                                    countDisplay.text = ""
                                    count11++
                                    MyData.page3Tv11Counter.postValue(count11)
                                    MySharedPreferences.page3Tv11Counter = count11
                                }
                                val strCount = String.format("%02d", count1)
                                countDisplay.text = strCount
                                MySharedPreferences.page3Tv1Counter = count1
                            }
                            1 -> {
                                vibrate(this@MainActivity)
                                btnAdd.animate().rotationBy(20f).setDuration(300).start()
                                count2++
                                if (count2 == 33) {
                                    vibrate2(this@MainActivity)
                                    count2 = 0
                                    countDisplay.text = ""
                                    count22++
                                    MyData.page3Tv22Counter.postValue(count22)
                                    MySharedPreferences.page3Tv22Counter = count22
                                }
                                val strCount = String.format("%02d", count2)
                                countDisplay.text = strCount
                                MySharedPreferences.page3Tv2Counter = count2
                            }
                        }
                    }
                }
            }

        }
    }

    private fun vibrate(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(50) // Old versions
        }
    }

    private fun vibrate2(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200) // Old versions
        }
    }
}