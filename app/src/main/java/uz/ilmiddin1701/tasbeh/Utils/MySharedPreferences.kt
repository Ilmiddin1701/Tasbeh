package uz.ilmiddin1701.tasbeh.Utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

//    var name:String
//        get() = preferences.getString("name", "null")!!
//        set(value) = preferences.edit {
//            if (value!=null){
//                it.putString("name", value)
//            }
//        }

    var tv1Counter:Int
        get() = preferences.getInt("keyTv1Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv1Counter", value)
        }
    var tv11Counter:Int
        get() = preferences.getInt("keyTv11Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv11Counter", value)
        }

    var tv2Counter:Int
        get() = preferences.getInt("keyTv2Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv2Counter", value)
        }
    var tv22Counter:Int
        get() = preferences.getInt("keyTv22Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv22Counter", value)
        }

    var tv3Counter:Int
        get() = preferences.getInt("keyTv3Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv3Counter", value)
        }
    var tv33Counter:Int
        get() = preferences.getInt("keyTv33Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyTv33Counter", value)
        }

    var page2Tv1Counter:Int
        get() = preferences.getInt("keyPage2Tv1Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage2Tv1Counter", value)
        }
    var page2Tv11Counter:Int
        get() = preferences.getInt("keyPage2Tv2Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage2Tv2Counter", value)
        }

    var page3Tv1Counter:Int
        get() = preferences.getInt("keyPage3Tv1Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage3Tv1Counter", value)
        }
    var page3Tv11Counter:Int
        get() = preferences.getInt("keyPage3Tv11Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage3Tv11Counter", value)
        }

    var page3Tv2Counter:Int
        get() = preferences.getInt("keyPage3Tv2Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage3Tv2Counter", value)
        }
    var page3Tv22Counter:Int
        get() = preferences.getInt("keyPage3Tv22Counter", 0)
        set(value) = preferences.edit{
            it.putInt("keyPage3Tv22Counter", value)
        }
}