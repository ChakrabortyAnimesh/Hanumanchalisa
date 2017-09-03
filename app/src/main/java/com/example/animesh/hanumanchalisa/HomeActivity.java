package com.example.animesh.hanumanchalisa;
//1111111111111111115555555555555555555555444444444444444446666666666666666666666664444444444444jj
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {


    boolean isbuttonon =false;
    SeekBar seekBar;
    public MediaPlayer mediaPlayer;
    Handler handler;
    Runnable runnable;
    public Button play;
    public   Button pause;

   public Button stop;
    private View mPendulum,mPendulum2;

    private Animation mAnimation;
    ImageView img1,img2,img3,img4,img5,img6;
    Button but;
    ObjectAnimator objectanimator1, objectanimator2, objectanimator3, objectanimator4, objectanimator5, objectanimator6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        /*********************************    Flower falling  ***************************** */
         img1 = (ImageView)findViewById(R.id.imageView1);
         img2 = (ImageView)findViewById(R.id.imageView2);
         img3 = (ImageView)findViewById(R.id.imageView3);
         img4 = (ImageView)findViewById(R.id.imageView4);
         img5 = (ImageView)findViewById(R.id.imageView5);
         img6 = (ImageView)findViewById(R.id.imageView6);

        but = (Button)findViewById(R.id.button1);

         objectanimator1 = ObjectAnimator.ofFloat(img1,"y",3000);
        objectanimator2 = ObjectAnimator.ofFloat(img2,"y",3500);
         objectanimator3 = ObjectAnimator.ofFloat(img3,"y",4000);
         objectanimator4 = ObjectAnimator.ofFloat(img4,"y",4500);
           objectanimator5 = ObjectAnimator.ofFloat(img5,"y",4000);
         objectanimator6 = ObjectAnimator.ofFloat(img6,"y",3000);


        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                     objectanimator1.setDuration(8000);
                   objectanimator2.setDuration(9000);
                   objectanimator3.setDuration(8000);
                 objectanimator4.setDuration(7000);
                objectanimator5.setDuration(9000);
                   objectanimator6.setDuration(8000);

                objectanimator1.start();
                objectanimator2.start();
                objectanimator3.start();
                objectanimator4.start();
                objectanimator5.start();
                objectanimator6.start();


            }
        });


        /* ********************************   Bell ringing  ***************************** */
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(HomeActivity.this,R.raw.templebell);
        final MediaPlayer mediaPlayer12 = MediaPlayer.create(HomeActivity.this,R.raw.templebell2);



        mPendulum = findViewById(R.id.bell1);
        mPendulum2 = findViewById(R.id.bell12);




        mAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);


        ImageView imageanimation = (ImageView) findViewById(R.id.bell1);
        ImageView imageanim = (ImageView) findViewById(R.id.bell12);

        imageanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mPendulum.startAnimation(mAnimation);

                    mediaPlayer1.start();

            }
        });


        imageanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPendulum2.startAnimation(mAnimation);


                mediaPlayer12.start();

            }
        });

        //*********************************   Seekbar ***************************** *//*

       handler = new Handler();
        seekBar = (SeekBar) findViewById(R.id.seekBar2);

        Button stop = (Button) findViewById(R.id.stop);

       play = (Button) findViewById(R.id.play123);
        mediaPlayer = MediaPlayer.create(HomeActivity.this, R.raw.aaa);
        /*********************************   Main media player ***************************** */
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setBackgroundResource(R.drawable.bestplay);
                }


                else {

                    mediaPlayer.start();

                    play.setBackgroundResource(R.drawable.bestpause);

                }
                //playcycle();
                //Toast.makeText(HomeActivity.this, "You clicked on 'PLAY' button", Toast.LENGTH_SHORT).show();

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //Toast.makeText(HomeActivity.this, "You clicked on 'EXIT' button", Toast.LENGTH_SHORT).show();
                HomeActivity.this.onDestroy();

                mediaPlayer.release();
                // HomeActivity.this.finish();
            }

        });



        final ImageView imageView = (ImageView) findViewById(R.id.image);


        /*********************************   Repeat button ***************************** */

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbuttonon){
                    imageView.setImageResource(R.drawable.repeatbuttonoff);
                    isbuttonon=false;

                    Toast.makeText(HomeActivity.this, "Repeat off", Toast.LENGTH_SHORT).show();
                }
                else {
                    imageView.setImageResource(R.drawable.repeatbutton);

                    isbuttonon=true;
                    Toast.makeText(HomeActivity.this, "Repeat on", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*********************************  Seekbar   ********************************* */

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(final MediaPlayer mediaPlayer) {
                if(isbuttonon){
                   // mediaPlayer.reset();


                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            seekBar.setMax(mediaPlayer.getDuration());
                            mediaPlayer.start();

                        }
                    });

                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress,boolean input) {

                            //if(input)
                                //mediaPlayer.seekTo(progress);
                            if(mediaPlayer != null){
                                mediaPlayer.seekTo(progress * 1000);
                            }

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {


                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                           /* int totalDuration = mediaPlayer.getDuration();
                            int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);

                            // forward or backward to certain seconds
                            mediaPlayer.seekTo(currentPosition);

                            // update timer progress again
                            updateProgressBar();
*/
                        }
                    });
                    mediaPlayer.start();

                }

            }
        });



        //private Handler mHandler = new Handler();
//Make sure you update Seekbar on UI thread
        HomeActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                handler.postDelayed(this, 1000);
            }
        });







        /*********************************   Text of Hanumanchalisa  ***************************** */

      Button  button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "You clicked on 'TEXT' button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }





    /*********************************    Back space alert dialog  ***************************** */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)

                .setCancelable(false)
                .setIcon(R.drawable.hanumanbest)
                .setTitle("Exit?")
                .setMessage("Do you really want to exit this application?")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Toast.makeText(HomeActivity.this, "You clicked on 'YES' button", Toast.LENGTH_SHORT).show();
                        stop.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //mediaPlayer.stop();
                                //Toast.makeText(HomeActivity.this, "You clicked on 'EXIT' button", Toast.LENGTH_SHORT).show();
                                HomeActivity.this.onDestroy();

                                mediaPlayer.release();
                                // HomeActivity.this.finish();
                            }

                        });


                        finish();
                        //close();




                    }





                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(HomeActivity.this, "You clicked on 'NO' button", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();








              /*Hi chachu*/



    }


}



