package com.naxtre.layoutconversionproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class VoiceCommandsFragment: Fragment() {
    var positionFromViewPager: Int = 0

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.edit_name_fragment_layout, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*when(positionFromViewPager){
            0 -> {
                how_to_link_title_text.setText(resources.getString(R.string.how_to_link_title_text))
                how_to_link_sub_title_text.setText(resources.getString(R.string.how_to_link_sub_title_text))
                smart_home_image_view.setImageResource(R.drawable.google_home_voice)
                smart_home_image_text_title.setText(resources.getString(R.string.smart_home_image_text_title))
                smart_home_image_text_sub_title.setText(resources.getString(R.string.smart_home_image_text_sub_title))
                where_to_add_text.setText(Html.fromHtml(resources.getString(R.string.where_to_add_text).replace("xyz","Skills and Games").replace("abc", "Alexa App")))
                oakter_smart_home_image_view.setImageResource(R.drawable.oakter_smart_home_google)
                credentials_for_text_title.setText(resources.getString(R.string.credentials_for_text_title))
                user_email_id_login.setText("asdsad")
                user_password_login.setText("asdsad")
            }
            1 -> {
                how_to_link_title_text.setText(resources.getString(R.string.how_to_link_title_text).replace("Google Assistant","Amazon Alexa"))
                how_to_link_sub_title_text.setText(resources.getString(R.string.how_to_link_sub_title_text).replace("Google Home App","Amazon Alexa App"))
                smart_home_image_view.setImageResource(R.drawable.alexa_voice_image)
                smart_home_image_text_title.setText(resources.getString(R.string.smart_home_image_text_title_alexa))
                smart_home_image_text_sub_title.setText(resources.getString(R.string.smart_home_image_text_sub_title_alexa))
                where_to_add_text.setText(Html.fromHtml(resources.getString(R.string.where_to_add_text).replace("xyz","Skills and Games").replace("abc", "Alexa App")))
                oakter_smart_home_image_view.setImageResource(R.drawable.oakter_smart_home_alexa)
                credentials_for_text_title.setText(resources.getString(R.string.credentials_for_text_title).replace("Google Assistant", "Amazon Alexa"))
                user_email_id_login.setText("asdfsdf")
                user_password_login.setText("sdfsdfsdf")
            }
            2 -> {
                how_to_link_title_text.setText(resources.getString(R.string.how_to_link_title_text).replace("Google Assistant","Amazon Alexa"))
                how_to_link_sub_title_text.setText(resources.getString(R.string.how_to_link_sub_title_text).replace("Google Home App","Amazon Alexa App"))
                smart_home_image_view.setImageResource(R.drawable.alexa_voice_image)
                smart_home_image_text_title.setText(resources.getString(R.string.smart_home_image_text_title_alexa))
                smart_home_image_text_sub_title.setText(resources.getString(R.string.smart_home_image_text_sub_title_alexa))
                where_to_add_text.setText(Html.fromHtml(resources.getString(R.string.where_to_add_text).replace("xyz","Skills and Games").replace("abc", "Alexa App")))
                oakter_smart_home_image_view.setImageResource(R.drawable.oakter_smart_home_alexa)
                credentials_for_text_title.setText(resources.getString(R.string.credentials_for_text_title).replace("Google Assistant", "Amazon Alexa"))
                user_email_id_login.setText("asdfsdf")
                user_password_login.setText("sdfsdfsdf")
            }

            3 -> {
                how_to_link_title_text.setText(resources.getString(R.string.how_to_link_title_text))
                how_to_link_sub_title_text.setText(resources.getString(R.string.how_to_link_sub_title_text))
                smart_home_image_view.setImageResource(R.drawable.google_home_voice)
                smart_home_image_text_title.setText(resources.getString(R.string.smart_home_image_text_title))
                smart_home_image_text_sub_title.setText(resources.getString(R.string.smart_home_image_text_sub_title))
                where_to_add_text.setText(Html.fromHtml(resources.getString(R.string.where_to_add_text).replace("xyz","Skills and Games").replace("abc", "Alexa App")))
                oakter_smart_home_image_view.setImageResource(R.drawable.oakter_smart_home_google)
                credentials_for_text_title.setText(resources.getString(R.string.credentials_for_text_title))
                user_email_id_login.setText("asdsad")
                user_password_login.setText("asdsad")
            }
        }

        copy_password_icon.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val clipboard = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("password", user_password_login.text)
                clipboard!!.setPrimaryClip(clip)
            }
        })*/
    }

}