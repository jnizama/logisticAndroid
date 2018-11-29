package com.example.ronald.helper;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Jorge on 20/06/17.
 */

public class Utils {

    public static void ShowMessage(Context getContext, String Title, String Message)
    {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getContext);
        helpBuilder.setTitle(Title);
        helpBuilder.setMessage(Message);
        helpBuilder.setPositiveButton(" OK ",null);
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
