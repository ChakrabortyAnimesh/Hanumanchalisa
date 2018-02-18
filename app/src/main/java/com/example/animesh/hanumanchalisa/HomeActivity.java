package com.example.animesh.hanumanchalisa;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.IOException;


public class HomeActivity extends AppCompatActivity {

  //  boolean  pressed;
  public ImageView imageViewshankh;
  //  private int duration;
    boolean  pressed;

    private int duration;
    boolean isbuttonon =false;
    SeekBar seekBar;
    public MediaPlayer mediaPlayer;
    Handler handler;
    public Button play;
public ViewPager viewPager;

    private View mPendulum,mPendulum2,ghanta,imageanimation;

    private Animation mAnimation;
    private Animation gAnimation;

    Button but;

    private ImageView nextButton;
    private int counter=0;
    private int[] songarry;
    private int[] imagearray;
    private ViewFlipper viewFlipper;
    private Toolbar toolbar;


    private ImageView btnPrev,btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.add);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setLogo(R.drawable.omlogo);

       // toolbar.setVisibility(View.GONE);
       // toolbar.setBackgroundResource(R.drawable.hanuman);
        //toolbar.setTitle(R.string.app_name);
        songarry = new int[]{R.raw.aaa,R.raw.mannmeraandir,R.raw.chaloshivala,R.raw.shivshankarkojisne};
        mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[0]);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more_vert_black_24dp));
        ImageView imagehanuman = (ImageView)findViewById(R.id.hanuman);

       /* ImageView imagefirst = (ImageView) findViewById(R.id.image1);
        ImageView imagesecond = (ImageView) findViewById(R.id.image2);*/
       // final SeekBar seekBar = (SeekBar)  findViewById(R.id.seekbar);










        /* ********************************   Bell ringing  ***************************** */
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(HomeActivity.this,R.raw.templebell1);
        final MediaPlayer mediaPlayer12 = MediaPlayer.create(HomeActivity.this,R.raw.templebell2);
        final MediaPlayer mediaPlayerghanta = MediaPlayer.create(HomeActivity.this, R.raw.handbellsound);
        mPendulum2 = findViewById(R.id.bell12);
        mPendulum=findViewById(R.id.bell1);
        ghanta = findViewById(R.id.ghanta);



        mAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        gAnimation = AnimationUtils.loadAnimation(this, R.anim.animationa);


       ImageView imageanimation = (ImageView) findViewById(R.id.bell1);
        ImageView imageanim = (ImageView) findViewById(R.id.bell12);
       final   ImageView ghanta = (ImageView) findViewById(R.id.ghanta);


        imageanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mediaPlayer1.start();
                    mPendulum.startAnimation(mAnimation);


            }
        });

        imageanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer12.start();
                mPendulum2.startAnimation(mAnimation);

            }

        });
        ghanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayerghanta.start();
                ghanta.startAnimation(gAnimation);
            }
        });
       /* mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

            }
        });*/

        //*********************************   Seekbar ***************************** *//*

       handler = new Handler();
        //seekBar = (SeekBar) findViewById(R.id.seekBar2);

       // Button stop = (Button) findViewById(R.id.stop);

       play = (Button) findViewById(R.id.play123);











/*

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.pause();
                counter--;
                mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                mediaPlayer.start();
            }
        });

*/









     /*   nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;

                if(counter==songarry.length){
                    counter=0;
                }


                if (mediaPlayer.isPlaying()) {
                    playSong(counter);

                }

            }
        });*/
        /*********************************   Main media player ***************************** */

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();

                    play.setBackgroundResource(R.drawable.bestplay);
                }
                else {
                   // counter = 0;
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                    play.setBackgroundResource(R.drawable.bestpause);
                }
            }
        });

     /*   stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mediaPlayer.stop();
               // Toast.makeText(HomeActivity.this, "You clicked on 'EXIT' button", Toast.LENGTH_SHORT).show();
               // HomeActivity.this.onDestroy();

                mediaPlayer.release();
                 HomeActivity.this.finish();
            }

        });
*/




        /*********************************   Next button ***************************** */
        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnPrev = (ImageView) findViewById(R.id.btnPrev);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    counter++;
                    if (counter > songarry.length-1) {
                        counter = 0;
                    }
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                }
            }
        });

        /********************************* Prev button *********************************/
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    counter--;
                    if (counter <0) {
                        counter=songarry.length-1;
                    }
                    mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[counter]);
                    mediaPlayer.start();
                }

            }
        });

        /********************************************************************************/















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
      /*  HomeActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                handler.postDelayed(this, 1000);
            }
        });*/







        /*********************************   Text of Hanumanchalisa  ***************************** */

      Button  button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(HomeActivity.this, "You clicked on 'TEXT' button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });







        pressed=false;
      final MediaPlayer mp = MediaPlayer.create(HomeActivity.this,R.raw.shankh_sound);

        imageViewshankh= (ImageView) findViewById(R.id.shankh);

        final Animation zoom = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.zoom);
        final Animation shrink = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shrink);


        imageViewshankh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                imageViewshankh.startAnimation(zoom);
                duration =mp.getDuration();
                mp.start();
                zoom.setDuration(duration/2);
                zoom.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        shrink.setDuration(duration/2);
                        imageViewshankh.startAnimation(shrink);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hanuman:
                Toast.makeText(this, " Wallpaper set successfully", Toast.LENGTH_LONG).show();

              //  WallpaperManager myWallpaperManager
                //        = WallpaperManager.getInstance(getApplicationContext());
              /* try {
                    myWallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.hanuman));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/

                // TODO Auto-generated method stub
                WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {


                    myWallpaperManager.setResource(R.id.hanuman);
                    /*if(viewFlipper.equals(R.id.imagefirst)) {
                        myWallpaperManager.setResource(R.drawable.hanuman);
                    }
                    if(viewFlipper.equals(R.id.imagesecond)){
                        myWallpaperManager.setResource(R.drawable.h23);
                    }*/
                   //
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

                /*
                **       set as wallpaper
                 */
            case R.id.menu_item_share:
                shareIt();
                break;

            case R.id.hanumanwiki:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Hanuman"));
                startActivity(intent);
                break;
            case R.id.about:
                new AlertDialog.Builder(this).setMessage("Hanuman Chalisa 5.5 By Animemsh Chakraborty").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show().setCancelable(false);


            default:
                break;
        }
        return true;
    }

    private void playSong(int index) {
        try {
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(HomeActivity.this, songarry[index]);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                       // Toast.makeText(HomeActivity.this, "You clicked on 'YES' button", Toast.LENGTH_SHORT).show();
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        finish();
                        //close();
                    }





                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                })
                .show();
    }




















    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hanuman Chalisa (HD Audio)-");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Check out this app Hanuman Chalisa app! https://www.blogger.com/blogger.g?blogID=4986461104042452215#allposts/ ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}



