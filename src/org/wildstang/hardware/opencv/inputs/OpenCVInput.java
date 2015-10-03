package org.wildstang.hardware.opencv.inputs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.wildstang.framework.io.inputs.ImageInput;


public class OpenCVInput extends ImageInput
{

   private static Logger s_log = Logger.getLogger(OpenCVInput.class.getName());
   private static final String s_className = "OpenCVInput";

   private VideoCapture camera;
   private double width = 320;
   private double height = 240;

   public OpenCVInput(String p_name)
   {
      super(p_name);
      
      camera = new VideoCapture(0);
      camera.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, width);
      camera.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, height);

      width = camera.get(Highgui.CV_CAP_PROP_FRAME_WIDTH);
      height = camera.get(Highgui.CV_CAP_PROP_FRAME_HEIGHT);
   }
   
   @Override
   protected Object readRawValue()
   {
      // TODO Auto-generated method stub
      if (s_log.isLoggable(Level.FINER)) s_log.entering(s_className, "readRawValue");
      if (s_log.isLoggable(Level.FINER)) s_log.exiting(s_className, "readRawValue");

      Mat imgInput = new Mat();
      
      camera.read(imgInput);

      return imgInput;
   }

}