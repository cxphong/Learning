package android.fiot.databinding;

import android.databinding.DataBindingUtil;
import android.fiot.databinding.databinding.Layout01Binding;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * B1: Tạo file layout
 * B2: Tạo databinding và set data, Layout01Binding suy ra từ tên file layout
 * layout_01.xml hay layout01.xml đều như nhau
 */
public class Activity01 extends AppCompatActivity {
    private static final String TAG = "Activity01";

    public class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Layout01Binding binding = DataBindingUtil.setContentView(this, R.layout.layout_01);

        // Custom data type
        final User u = new User("Phong", 26);
        binding.setUser(u);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                u.setName("ACB");

                // Bắt buộc set binding lại lần nữa
                binding.setUser(u);
            }
        }, 2000);


        // Primitive data type
        final StringBuilder stringBuilder = new StringBuilder();
        binding.setLog(stringBuilder);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                stringBuilder.append("Hello\n");
                //binding.setLog(stringBuilder);
            }
        }, 1000, 1000);

    }
}
