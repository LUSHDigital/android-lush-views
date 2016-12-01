# LUSH Style Library for Android
Apply the LUSH look and feel to any application by applying styles to the views in layout files.

## Using the theme
Use the theme `@style/LushTheme` by applying it to the Activity in the AndroidManifest.xml to give the correct colours.

## Text Styles
Text styles are applied using the `android:textAppearance` attribute on TextView and it's subclasses.
The text styles are based on `@style/Text`. Check out the `styles_text.xml` class for the complete list.

All fonts will use either Helvetica, Helvetica Bold, or the LUSH Handwritten typeface. To allow these to work,
you will need to add the following code to any Activity:

```
@Override
	protected void attachBaseContext(Context newBase)
	{
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
	}
```

and then have the Application singleton extend `LushApplication` (Or just copy the Calligraphy code out of it).

## Buttons
Buttons come in 4 styles:

### Black Button
Black button with white text, used on light backgrounds. Accessed by applying `@style/LushButton.Black`
to any button. Used as a primary action button

### Black Button Inverse
Transparent button with black border and black text. Accessed by applying `@style/LushButton.BlackSecondary`
and is a secondary action to a black button primary action.

### White Button
White button with Black text, used on dark backgrounds. Accessed by applying `@style/LushButton.White`
to any button. Used as a primary action button

### White Button Inverse
Transparent button with white border and white text. Accessed by applying `@style/LushButton.WhiteSecondary`
and is a secondary action to a white button primary action.