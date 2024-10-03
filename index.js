
import { NativeModules } from 'react-native';

const { RNScreenshotDetect } = NativeModules;
const screenshotEventEmitter = new NativeEventEmitter(ScreenshotDetector);

const addScreenshotListener = (callback) => {
  return screenshotEventEmitter.addListener('screenshotTaken', callback);
};

const removeScreenshotListener = (subscription) => {
  subscription.remove();
};

export default {
  addScreenshotListener,
  removeScreenshotListener,
};