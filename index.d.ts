declare module 'screenshot-detect' {
  type ScreenshotCallback = () => void;

  function addScreenshotListener(callback: ScreenshotCallback): any;
  function removeScreenshotListener(subscription: any): void;
}
