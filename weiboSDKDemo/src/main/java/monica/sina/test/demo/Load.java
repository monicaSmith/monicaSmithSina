package monica.sina.test.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by monica on 7/25/16.
 */
public class Load extends Activity{
    public void onCreate(Bundle savedInstantState){
        super.onCreate(savedInstantState);
        setContentView(R.layout.load_main);
        ImageView image=(ImageView)findViewById(R.id.load_image);
        AlphaAnimation animation=new AlphaAnimation(1.0f,0.1f);
        animation.setDuration(5000);
        image.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ConnectivityManager connectivityManager=(ConnectivityManager)Load.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager==null){
                    Toast.makeText(Load.this,"no internet",Toast.LENGTH_SHORT).show();
                }
                else{
                    NetworkInfo[] networkInfo=connectivityManager.getAllNetworkInfo();
                    if(networkInfo!=null){
                        for(NetworkInfo info:networkInfo){
                            if(info.getState()==NetworkInfo.State.CONNECTED){
                                Toast.makeText(Load.this,"conncted",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                }

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(Load.this,"end",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Load.this,WBDemoMainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

}
