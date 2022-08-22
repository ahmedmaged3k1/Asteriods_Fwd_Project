package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.udacity.asteroidradar.main.MainViewModel
import com.udacity.asteroidradar.test.AsteroidPracable

@BindingAdapter("imageDay")
fun ImageView.setImage(item: MainViewModel?) {
    item?.let {
        Glide.with(context)
            .load(item.image)
            .into(this)
    }
}

@BindingAdapter("maginituide")
fun TextView.setMaginituideText(item: StartDate?) {
    item.let {
       text= item?.absolute_magnitude_h?.toString()

    }
}
@BindingAdapter("maginituideDetail")
fun TextView.setMaginituideDetailText(item: AsteroidPracable?) {
    item.let {
        text= item?.magnituide

    }
}
@BindingAdapter("diamter")
fun TextView.setDiamterText(item: AsteroidPracable?) {
    item.let {
        text= item?.diamter

    }
}
@BindingAdapter("velocity")
fun TextView.setVelocityText(item: AsteroidPracable?) {
    item.let {
        text= item?.velocity

    }
}
@BindingAdapter("distance")
fun TextView.setDistanceText(item: AsteroidPracable?) {
    item.let {
        text= item?.distance

    }
}
@BindingAdapter("date")
fun TextView.setDateText(item: AsteroidPracable?) {
    item.let {
        text= item?.date

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
@BindingAdapter("detailImage")
fun ImageView.setDetailAsteroidImage(item: AsteroidPracable?) {
    item.let {
        if (item != null) {
            if (item.imageFlag)
            {
                setImageResource(R.drawable.asteroid_hazardous)
            }
            else
            {
                setImageResource(R.drawable.asteroid_safe)

            }
        }
    }

}

