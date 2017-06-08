package drd.flhspatriotbattalion;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class Broadcast extends BroadcastReceiver {

    public Broadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

            context.startService(new Intent(context, Notification.class));

        System.out.println("Hippo Broadcast started");
         /*   Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.MINUTE, 2);
            if (calendar == Calendar.getInstance()){

                context.stopService(new Intent(context, Notification.class));

            }
*/


        }


}
