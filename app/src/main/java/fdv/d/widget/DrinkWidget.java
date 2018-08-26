package fdv.d.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.widget.RemoteViews;

import fdv.d.R;
import fdv.d.ui.MainActivity;
/**
 * Implementation of App Widget functionality.
 */
public class DrinkWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                String name, String text, int appWidgetId) {
        Intent intent = new Intent(context, MainActivity.class);
        /* PendingIntent - a wrap around an intent which allows other applications
         * (in which it was transmitted) to have access and run that intent in your application
         * stored inside it, on behalf of the application (and the same with the credentials)
         * that transmitted this PendingIntent. RemoteViews should be associated
         * with PendingIntent to run MainActivity when this view is clicked on.
         */
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.drink_widget);
        // Update widget text
        views.setTextViewText(R.id.wtv_name, name);
        views.setTextViewText(R.id.widget_text, text);
        // Widgets allow click handlers to only launch pending intents
        views.setOnClickPendingIntent(R.id.widget, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void updateWidgets(Context context, AppWidgetManager appWidgetManager,
                                          String name, String text, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, name, text, appWidgetId);
            Log.d("TAG", "updateW " + String.valueOf(appWidgetId));
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Resources resources = context.getResources();
        String name = resources.getString(R.string.widget_text);
        String text = "";
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, name, text, appWidgetId);
        }
    }
    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }
    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}