package gmessage.rvg.com.gmessage.Tutoriralview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.rvg.tutorialview.object.TutorialBuilder;
import com.rvg.tutorialview.object.TutorialIntentBuilder;
import com.rvg.tutorialview.view.TutorialView;

import java.util.Random;

import gmessage.rvg.com.gmessage.R;


public class MainActivity extends Activity {

    private TutorialView tutorialView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // For testing with no status bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // For testing with no action bar
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_maint);
        tutorialView = (TutorialView) findViewById(R.id.tutorial_view);

        findViewById(R.id.btn_test_button).setOnClickListener(tutorialClickListener);
        findViewById(R.id.btn_test_button2).setOnClickListener(tutorialClickListener);
        findViewById(R.id.view_to_surround).setOnClickListener(tutorialClickListener);
        findViewById(R.id.view_to_surround2).setOnClickListener(tutorialClickListener);
        findViewById(R.id.linear_test).setOnClickListener(tutorialClickListener);

        if (getActionBar() != null)
            getActionBar().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));

        //Using the tutorial view
        // This is used for the tutorial view that should be in your root view.
        // This may lead to problems when used inside LinearLayout and maybe other view.
        // The best thing to do is to use the TutorialActivity.
        tutorialView.setActionBarRestoreColor(Color.DKGRAY);
        tutorialView.changeActionBarColor(true);
        tutorialView.setActionBar(getActionBar());
        tutorialView.setHasActionBar(true);
        tutorialView.setTutorialTextTypeFace("fonts/roboto_light.ttf");
        tutorialView.setHasStatusBar(true);
        tutorialView.setTutorialText("This is some general text that is not that long but also not so short.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {

        }
    }


    private View.OnClickListener tutorialClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // This is used for the tutorial view that should be in your root view.
            // This may lead to problems when used inside LinearLayout and maybe other view.
            // The best thing to do is to use the TutorialActivity.

            // Set the background color.
//            tutorialView.setTutorialBackgroundColor(randomColor());

            // Setting the view that should be surrounded.
//            tutorialView.setViewToSurround(v, v instanceof TextView ? ((TextView) v).getText().toString() : "Fixed Title");

            // Using the tutorial Activity for simple tutorial.
            int color =  randomColor();
            
            TutorialIntentBuilder builder = new TutorialIntentBuilder(MainActivity.this);
            
            TutorialBuilder tBuilder = new TutorialBuilder();
            
            tBuilder.setTitle("The Title")
                    .setViewToSurround(v)
                    .setInfoText("This is the explanation about the view.")
                    .setBackgroundColor(randomColor())
                    .setTutorialTextColor(Color.WHITE)
                    .setTutorialTextTypeFaceName("fonts/olivier.ttf")
                    .setTutorialTextSize(25)
                    .setAnimationDuration(500);

            builder.setTutorial(tBuilder.build());

            startActivity(builder.getIntent());

            // Using the tutorial activity as a walk through
//            startActivity(walkThroughIntent());
            
            
            // Override the default animation of the entering activity.
            // This will allow the nice wrapping of the view by the tutorial activity.
            overridePendingTransition(R.anim.dummy, R.anim.dummy);
        }
    };

    private int randomColor(){
        Random rnd = new Random();
        return  Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public void onBackPressed() {
        if (tutorialView.isShowing())
            tutorialView.closeTutorial();
        else
            super.onBackPressed();
    }

    /*private Intent walkThroughIntent(){

        TutorialIntentBuilder builder = new TutorialIntentBuilder(this);

        Tutorial tutorial = new Tutorial(findViewById(R.id.view_to_surround2), "Top Left");
        tutorial.setInfoText("This view is on the top left");
        tutorial.setBackgroundColor(Color.BLACK);

        Tutorial tutorial2 = new Tutorial(findViewById(R.id.btn_test_button), "Bottom Left");
        tutorial2 .setInfoText("This view is on the bottom left");
        tutorial2.setBackgroundColor(Color.BLUE);

        Tutorial tutorial3 = new Tutorial(findViewById(R.id.btn_test_button2), "Right");
        tutorial3.setInfoText("this view is on the right");
        tutorial3.setBackgroundColor(Color.RED);

        Tutorial tutorial4 = new Tutorial(findViewById(R.id.linear_test));
        tutorial4.setInfoText("This is a centered view");
        tutorial4.setBackgroundColor(Color.GREEN);

        ArrayList<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(tutorial);
        tutorials.add(tutorial2);
        tutorials.add(tutorial3);
        tutorials.add(tutorial4);

        builder.skipTutorialOnBackPressed(true);

        builder.setWalkThroughList(tutorials);

        return builder.getIntent();
    }*/
}
