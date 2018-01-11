package text.bwei.com.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private ArrayList<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //得到SharedPreferences
        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        //设置初始值
        boolean boo = preferences.getBoolean("boo", false);
        if(boo){
            Intent it=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(it);
            finish();
        }else {


            //获取ID
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            //获取图片页面
            View view1 = View.inflate(this, R.layout.pager1, null);
            View view2 = View.inflate(this, R.layout.pager2, null);
            //按钮监听
            view2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent it=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(it);
                }
            });
            //将三个页面放入集合中
            list = new ArrayList<>();
            list.add(view1);
            list.add(view2);

            //将值传给适配器
            ViewPagerAdapter adapter=new ViewPagerAdapter(list);
            viewPager.setAdapter(adapter);

            editor.putBoolean("boo", true);
            editor.commit();

        }
    }
}
