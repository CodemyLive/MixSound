package live.codemy.mixsound

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initViewAndListeners()
    }

    private fun initViewAndListeners(){

        //init views
        val buttonRecord : ImageButton = findViewById(R.id.image_button_record)
        val buttonSlow : ImageButton = findViewById(R.id.image_button_slow)
        val buttonDarthVader : ImageButton = findViewById(R.id.image_button_darth)
        val buttonReverb : ImageButton = findViewById(R.id.image_button_reverb)
        val buttonFast : ImageButton = findViewById(R.id.image_button_fast)

        //init listeners
        buttonRecord.setOnClickListener{onClick(buttonRecord)}
        buttonSlow.setOnClickListener{onClick(buttonSlow)}
        buttonDarthVader.setOnClickListener{onClick(buttonDarthVader)}
        buttonReverb.setOnClickListener{onClick(buttonReverb)}
        buttonFast.setOnClickListener{onClick(buttonFast)}

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.image_button_record -> TODO()
            R.id.image_button_slow -> TODO()
            R.id.image_button_darth -> TODO()
            R.id.image_button_reverb ->  TODO()
            R.id.image_button_fast -> TODO()
        }
    }


}