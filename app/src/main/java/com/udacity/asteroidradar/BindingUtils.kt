package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("maginituide")
fun TextView.setMaginituideText(item: StartDate?) {
    item.let {
       text= item?.absolute_magnitude_h?.toString()

    }
}

@BindingAdapter("name")
fun TextView.setNameText(item: StartDate?) {
    item.let {
        text= item?.name

    }
}
@BindingAdapter("image")
fun ImageView.setAsteroidImage(item: StartDate?) {
    item.let {
        if (item != null) {
            if (item.is_potentially_hazardous_asteroid)
            {
                setImageResource(R.drawable.ic_status_potentially_hazardous)
            }
            else
            {
                setImageResource(R.drawable.ic_status_normal)

            }
        }
    }

}

