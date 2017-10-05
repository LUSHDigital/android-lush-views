package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_spinner.*
import java.util.*

/**
 * Demonstrates what Lush views looks like for generic spinners/pickers
 *
 * @author Jamie Cruwys
 */
class SpinnerSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        integer_spinner.setZeroText("YYYY")
        integer_spinner.setRange(currentYear, currentYear + 20)

        val languageCodes : List<Locale> = listOf(Locale("en"), Locale("de"), Locale("pt"), Locale("es"), Locale("sv"))
        language_spinner.items = languageCodes

        val countries = listOf("United Kingdom", "Brazil", "Hong Kong", "Japan", "Mena", "Australia", "New Zealand", "Austria", "Czech Republic", "France", "Germany", "Holland", "Hungary", "Italy", "Portugal", "Spain", "Sweden")
        string_spinner.items = countries
    }
}