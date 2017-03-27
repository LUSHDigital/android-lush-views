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

## Bottom Bar
For apps that use that the bottom bar, it should look the same across apps. To use the bottom bar, put this in the layout:
```
<com.aurelhubert.ahbottomnavigation.AHBottomNavigation
		android:id="@+id/bottom_bar"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:layout_alignParentBottom="true"/>
```
Reference this in the Java from it's ID and add items to it using the following methods.
```
AHBottomNavigationItem[] items = new AHBottomNavigationItem[4];
		items[0] = new AHBottomNavigationItem(R.string.products, R.drawable.ic_products, android.R.color.black);
		items[1] = new AHBottomNavigationItem(R.string.discover, R.drawable.ic_discover, android.R.color.black);
		items[2] = new AHBottomNavigationItem(R.string.shops, R.drawable.ic_shops, android.R.color.black);
		items[3] = new AHBottomNavigationItem(R.string.basket, R.drawable.ic_basket, android.R.color.black);
		for (AHBottomNavigationItem item : items)
		{
			mBottomBar.addItem(item);
		}
		mBottomBar.setOnTabSelectedListener(this);
		mBottomBar.setInactiveColor(Color.BLACK);
		mBottomBar.setAccentColor(getResources().getColor(R.color.dark_grey));
```