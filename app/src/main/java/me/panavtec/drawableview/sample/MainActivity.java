package me.panavtec.drawableview.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends Activity {

  private DrawableView drawableView;
  private DrawableViewConfig config = new DrawableViewConfig();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initUi();
  }

  private void initUi() {
    drawableView = (DrawableView) findViewById(R.id.paintView);
    Button strokeWidthMinusButton = (Button) findViewById(R.id.strokeWidthMinusButton);
    Button strokeWidthPlusButton = (Button) findViewById(R.id.strokeWidthPlusButton);
    final Button changeColorButton = (Button) findViewById(R.id.changeColorButton);
    Button undoButton = (Button) findViewById(R.id.undoButton);
    Button clearButton = (Button) findViewById(R.id.clearButton);


    config.setStrokeColor(getResources().getColor(android.R.color.black));
    config.setShowCanvasBounds(true);
    config.setStrokeWidth(20.0f);
    config.setMinZoom(1.0f);
    config.setMaxZoom(3.0f);
    config.setCanvasHeight(1080);
    config.setCanvasWidth(1920);
    drawableView.setConfig(config);

    strokeWidthPlusButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        config.setStrokeWidth(config.getStrokeWidth() + 10);
      }
    });
    strokeWidthMinusButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        config.setStrokeWidth(config.getStrokeWidth() - 10);
      }
    });
    changeColorButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        Random random = new Random();
        int argb = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        config.setStrokeColor(argb);
        changeColorButton.setTextColor(argb);
      }
    });
    undoButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        drawableView.undo();
      }
    });

    clearButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawableView.clear();
      }
    });
  }
}
