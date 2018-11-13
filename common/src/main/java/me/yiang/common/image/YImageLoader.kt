package me.yiang.common.image

import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import me.yiang.common.ContextManager

/**
 *创建：yiang
 * <p>
 *描述：YImageLoader.load(*).ops.into()
 */
class YImageLoader {
    private var requestBuilder: RequestBuilder<Drawable>?
    private var options: RequestOptions


    constructor(any: Any?) {
        requestBuilder = Glide.with(ContextManager.getContext()).load(any)
        options = RequestOptions()

    }

    companion object {
        fun load(any: Any?): YImageLoader = YImageLoader(any)
    }

    fun placeholder(@DrawableRes resId: Int): YImageLoader {
        options.placeholder(resId)
        return this
    }

    fun isCircle(): YImageLoader {
        options = options.circleCrop()
        return this
    }

    fun isRound(radius: Int): YImageLoader {
        options = options.transform(GlideRoundTransform(radius))
        return this
    }

    fun isRound(): YImageLoader {
        options = options.transform(GlideRoundTransform())
        return this
    }

    fun withoutCache(): YImageLoader {
        options = options.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)
        return this
    }

    fun resize(width: Int, hight: Int): YImageLoader {
        options = options.override(width, hight)
        return this
    }

    fun into(imageView: ImageView) {
        requestBuilder!!.apply(options).transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

}
