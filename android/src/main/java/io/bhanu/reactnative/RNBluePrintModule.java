
package io.bhanu.reactnative;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothAdapter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

public class RNBluePrintModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNBluePrintModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBluePrint";
  }

  /**
   * PUBLIC REACT API
   *
   * printText() Returns true if the print is successful
   */
  @ReactMethod
  public void printText(String message, final Promise promise) {
    try {
      BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
      BluetoothDevice mBtDevice = btAdapter.getBondedDevices().iterator().next(); // Get first paired device

      final BluetoothPrinter mPrinter = new BluetoothPrinter(mBtDevice);
      mPrinter.connectPrinter(new BluetoothPrinter.PrinterConnectListener() {

        @Override
        public void onConnected() {
          mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
          mPrinter.printText(message);
          mPrinter.addNewLine();
          mPrinter.finish();
          promise.resolve(true);
        }

        @Override
        public void onFailed() {
          promise.reject("BluetoothPrinter Conection failed");
        }

      });
    } catch (Exception ex) {
      promise.reject("ERR_UNEXPECTED_EXCEPTION", ex);
    }
  }

}