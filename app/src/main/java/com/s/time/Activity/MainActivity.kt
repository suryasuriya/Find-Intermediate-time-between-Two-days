package com.s.time.Activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.widget.*
import com.s.time.Models.TimeUser
import com.s.time.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var mYear: Int? = null
    private var mMonth: Int? = null
    private var mDate: Int? = null
    private var iYear: Int? = null
    private var iMonth: Int? = null
    private var iDate: Int? = null
    private var mHour: Int? = null
    private var mMin: Int? = null
    private var inDate: String? = null
    private var outdate: String? = null
    private var inTime: String? = null
    private var outTime: String? = null
    private var checkTime: String? = null
    private var timeUser: MutableList<TimeUser>? = null
    private var ndate : Int?=0
    private var nYear: Int? = 0
    private var nMonth: Int? = 0
    private var c1: Calendar?=null
    private var c: Calendar?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeUser = ArrayList()
        c1 = Calendar.getInstance()
        iYear = c1?.get(Calendar.YEAR)
        iMonth = c1?.get(Calendar.MONTH)
        iDate = c1?.get(Calendar.DAY_OF_MONTH)
         c = Calendar.getInstance()
        mYear = c?.get(Calendar.YEAR)
        mMonth = c?.get(Calendar.MONTH)
        mDate = c?.get(Calendar.DAY_OF_MONTH)
        tvInDate.setOnClickListener {

            tvOutDate.isClickable=true
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                val Year = year.toString()
                val Month = (monthOfYear.plus(1)).toString()
                val Date = dayOfMonth.toString()
                iYear=year
                iMonth=monthOfYear
                iDate=dayOfMonth
                mYear=year
                mMonth=monthOfYear
                mDate=dayOfMonth
                inDate = Date + "/" + Month + "/" + Year
                if(iDate!!>ndate!! && iMonth==nMonth!! && iYear==nYear){
                    tvOutDate.setText(" ")
                }else if(iDate!!>ndate!! || iMonth!!>nMonth!! && iYear==nYear){
                    tvOutDate.setText(" ")
                }else if(iDate!!>ndate!! || iMonth!!>nMonth!! || iYear!!>nYear!!){
                    tvOutDate.setText(" ")
                }
                tvInDate.setText(inDate)
            }, mYear!!, mMonth!!, mDate!!)

            dpd.datePicker.minDate=System.currentTimeMillis()-1000
            dpd.show()




        }


        tvInTime.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c.get(Calendar.HOUR_OF_DAY)
            mMin = c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                if (hourOfDay < 12) {
                    if (hourOfDay < 10 && minute < 10 ) {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        inTime = "0" + hour + ":" + "0" + min + " " + "AM"
                        tvInTime.setText( inTime)
                    }else if(hourOfDay<10 && minute>10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        inTime = "0" + hour + ":" +  min + " " + "AM"
                        tvInTime.setText( inTime)
                    }else if(hourOfDay>10 && minute<10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        inTime = hour + ":" + "0" + min + " " + "AM"
                        tvInTime.setText( inTime)
                    }

                    else {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        inTime = hour + ":" + min + " " + "AM"
                        tvInTime.setText( inTime)
                        val i = hourOfDay

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }


                } else {
                    if (hourOfDay < 22 && minute < 10) {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        inTime = "0" + hour + ":" + "0" + min + " " + "PM"
                        tvInTime.setText( inTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }else if(hourOfDay<22 && minute>10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        inTime = "0" + hour + ":" +  min + " " + "PM"
                        tvInTime.setText( inTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else if(hourOfDay>22 && minute<10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        inTime =  hour + ":" + "0" + min + " " + "PM"
                        tvInTime.setText( inTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        inTime = hour + ":" + min + " " + "PM"
                        tvInTime.setText( inTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                }


            }, mHour!!, mMin!!, false)

            dpd.show()
        }

        tvOutDate.setOnClickListener {
            val c=Calendar.getInstance()
            c.set(iYear!!,iMonth!!,iDate!!)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val Year = year.toString()
                val Month = (monthOfYear.plus(1)).toString()
                val Date = dayOfMonth.toString()
                nYear=year
                nMonth=monthOfYear
                ndate=dayOfMonth
                outdate = Date + "/" + Month + "/" + Year
                tvOutDate.setText(outdate)

                Toast.makeText(this@MainActivity, dayOfMonth.toString(), Toast.LENGTH_SHORT).show()
            }, iYear!!, iMonth!!, iDate!!)

            dpd.datePicker.minDate=c.timeInMillis
            dpd.show()

        }

        tvOutTime.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c.get(Calendar.HOUR_OF_DAY)
            mMin = c.get(Calendar.MINUTE)
            val dpd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                if (hourOfDay < 12) {
                    if (hourOfDay < 10 && minute < 10 ) {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        outTime = "0" + hour + ":" + "0" + min + " " + "AM"
                        tvOutTime.setText(outTime)
                    }else if(hourOfDay<10 && minute>10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        outTime = "0" + hour + ":" +  min + " " + "AM"
                        tvOutTime.setText(outTime)
                    }else if(hourOfDay>10 && minute<10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        outTime = hour + ":" + "0" + min + " " + "AM"
                        tvOutTime.setText(outTime)
                    }

                    else {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        outTime = hour + ":" + min + " " + "AM"
                        tvOutTime.setText(outTime)
                        val i = hourOfDay

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }


                } else {
                    if (hourOfDay < 22 && minute < 10) {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        outTime = "0" + hour + ":" + "0" + min + " " + "PM"
                        tvOutTime.setText(outTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }else if(hourOfDay<22 && minute>10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        outTime = "0" + hour + ":" +  min + " " + "PM"
                        tvOutTime.setText(outTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else if(hourOfDay>22 && minute<10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        outTime =  hour + ":" + "0" + min + " " + "PM"
                        tvOutTime.setText(outTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        outTime = hour + ":" + min + " " + "PM"
                        tvOutTime.setText(outTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }, mHour!!, mMin!!, false)

            dpd.show()

        }


        tvTime.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c.get(Calendar.HOUR_OF_DAY)
            mMin = c.get(Calendar.MINUTE)
            val dpd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                if (hourOfDay < 12) {
                    if (hourOfDay < 10 && minute < 10 ) {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        checkTime = "0" + hour + ":" + "0" + min + " " + "AM"
                        tvTime.setText(checkTime)
                    }else if(hourOfDay<10 && minute>10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        checkTime = "0" + hour + ":" +  min + " " + "AM"
                        tvTime.setText(checkTime)
                    }else if(hourOfDay>10 && minute<10){
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        checkTime = hour + ":" + "0" + min + " " + "AM"
                        tvTime.setText(checkTime)
                    }

                    else {
                        val hour = hourOfDay.toString()
                        val min = minute.toString()
                        checkTime = hour + ":" + min + " " + "AM"
                        tvTime.setText(checkTime)
                        val i = hourOfDay

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }


                } else {
                    if (hourOfDay < 22 && minute < 10) {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        checkTime = "0" + hour + ":" + "0" + min + " " + "PM"
                        tvTime.setText(checkTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }else if(hourOfDay<22 && minute>10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        checkTime = "0" + hour + ":" +  min + " " + "PM"
                        tvTime.setText(checkTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else if(hourOfDay>22 && minute<10){
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        checkTime =  hour + ":" + "0" + min + " " + "PM"
                        tvTime.setText(checkTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                    else {
                        var j = hourOfDay.rem(12)
                        if (hourOfDay == 0) {
                            j = 12

                        }
                        val hour = j.toString()
                        val min = minute.toString()
                        checkTime = hour + ":" + min + " " + "PM"
                        tvTime.setText(checkTime)
                        val i = j

                        Toast.makeText(this@MainActivity, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }, mHour!!, mMin!!, false)

            dpd.show()
        }



        btnCheck.setOnClickListener {


            if (!tvInDate.text.isNullOrBlank() && !tvOutDate.text.isNullOrBlank() && !tvInTime.text.isNullOrBlank() && !tvOutTime.text.isNullOrBlank() && !tvTime.text.isNullOrBlank()) {
                var s1 = tvInDate.toString()
                var s2 = tvOutDate.toString()
                var s3 = tvInTime.toString()
                var s4 = tvOutDate.toString()
                var s5 = tvTime.toString()

                if (s1.trim().isEmpty()) {
                    tvInDate.error = "Date Required"

                } else if (s2.trim().isEmpty()) {
                    tvOutDate.error = "Date Required"

                } else if (s3.trim().isEmpty()) {
                    tvInTime.error = "Time Required"
                } else if (s4.trim().isEmpty()) {
                    tvOutTime.error = "Time Required"
                } else if (s5.trim().isEmpty()) {
                    tvTime.error = "Time Required"
                } else {
                    duration(inDate!!, outdate!!, inTime!!, outTime!!, checkTime!!)
                }

            }

        }


    }


    fun duration(indate: String, outDate: String?, intime: String,outtime:String, checktime: String) {

        val date1 = indate
        val time1 = intime
        val date2 = outDate
        val time2 = outtime
        val time3=checktime
        val sdff  = SimpleDateFormat("dd/MM/yyyy")
        val d1=sdff.parse(date1)
        val d2=sdff.parse(date2)
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a")
        val dateObj1 = sdf.parse(date1 + " " + time1)
        val dateObj2 = sdf.parse(date2 + " " + time2)
        val dateObj3 =sdf.parse(date1 + " " + time3)
        val dateObj4 =sdf.parse(date2 + " " + time3)




if(d1<=d2) {


    if (d1.equals(d2)) {
        if (dateObj3 >= dateObj1 && dateObj4 < dateObj2) {
            btnColor.setBackgroundColor(getColor(R.color.colorPrimary))
        } else {
            btnColor.setBackgroundColor(getColor(R.color.Red))
        }
    } else if (d1.before(d2)) {

        if (dateObj1.before(dateObj3) || (dateObj2.after(dateObj4))) {
            btnColor.setBackgroundColor(getColor(R.color.colorPrimary))

        } else {
            btnColor.setBackgroundColor(getColor(R.color.Red))
        }

    } else {
        btnColor.setBackgroundColor(getColor(R.color.Red))
    }
    if (d1.after(d2)) {
        btnColor.setBackgroundColor(getColor(R.color.colorPrimary))
    }
}
        else {
    btnColor.setBackgroundColor(getColor(R.color.Red))
        }
    }
}

