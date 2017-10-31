package com.lush.views

import com.lush.view.LushEditText

/**
 * Custom extensions
 *
 * @author Jamie Cruwys
 */

fun LushEditText.validateEmptiness(errorMessage: String = "This field is required") : Boolean {
    val passed = !text.isNullOrBlank()

    if (!passed)
    {
        setError(errorMessage)
    }

    return passed
}

fun LushEditText.clearText() {
    setText(null)
}