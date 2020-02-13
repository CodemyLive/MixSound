package live.codemy.mixsound

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import live.codemy.mixsoundlib.MixSound
import live.codemy.mixsoundlib.SoundType

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
            R.id.image_button_record -> MixSound.getInstance(this).recordSound() //"" extToast this
            R.id.image_button_slow -> MixSound.getInstance(this).changeSound(SoundType.Slow)
            R.id.image_button_darth -> MixSound.getInstance(this).changeSound(SoundType.DarthVader)
            R.id.image_button_reverb -> MixSound.getInstance(this).changeSound(SoundType.Reverb)
            R.id.image_button_fast -> MixSound.getInstance(this).changeSound(SoundType.Fast)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            MixSound.CODE_SPEECH_RECOGNIZER -> {
                data?.let {
                    val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    // MixSound.recordSound = result.first()
                    MixSound.recordSound = """
                        
                        Koyduğum nokta belki son
                        Ben bunu bilemem aynı bomb
                        Gibi gelir sana belki de aynı ton
                        Dibi delik gelebilir ama aynı fon
                        Kendini bilemez montofon
                        Ve monoton yaşar hep alt aynı don
                        Anlatırım ben derdimi yalnız
                        Ey, bi' mini microphone
                        
                        Şimdi bana bi' bakınız hadi
                        Muamelesi kesebilir hasi
                        Ve de Muhammed Ali gibi gelir asi
                        Bana bak, beni gör ve de öl vasi
                        Sesim hep duyulur tepeden bariton
                        Mekanım olabilir her an ozon
                        Yanıma gelenin canına girecektir
                        Ey, bi' mini microphone

                    """.trimIndent()
                }
            }
        }
    }

    override fun onStop() {
        MixSound.getInstance(this).textToSpeech.stop()
        MixSound.getInstance(this).textToSpeech.shutdown()
        super.onStop()
    }

    infix fun String.extToast(context: Context){
        Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }
}
