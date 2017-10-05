package com.lush.views.sample

import android.os.Bundle
import com.lush.view.LushEditText
import com.lush.views.clearText
import com.lush.views.sample.base.BaseSampleActivity
import com.lush.views.validateEmptiness
import kotlinx.android.synthetic.main.activity_form.*
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for forms
 *
 * @author Jamie Cruwys
 */
class FormSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        submit.setOnClickListener { validate() }
    }

    private fun validate()
    {
        val fields = arrayOf(address_field, locality_field, postcode_field)
        val passed = validateFieldsForEmptiness(fields)

        if (passed)
        {
            fields.forEach { it.clearText() }
            toast("Submitted!")
        }
    }

    private fun validateFieldsForEmptiness(fields : Array<LushEditText>) : Boolean {
        var passed = true
        fields.forEach { if (!it.validateEmptiness()) passed = false }
        return passed;
    }
}