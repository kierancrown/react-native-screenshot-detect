
# react-native-screenshot-detect

## Getting started

`$ npm install react-native-screenshot-detect --save`

### Mostly automatic installation

`$ react-native link react-native-screenshot-detect`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-screenshot-detect` and add `RNScreenshotDetect.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNScreenshotDetect.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.kierancrown.RNScreenshotDetectPackage;` to the imports at the top of the file
  - Add `new RNScreenshotDetectPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-screenshot-detect'
  	project(':react-native-screenshot-detect').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-screenshot-detect/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-screenshot-detect')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNScreenshotDetect.sln` in `node_modules/react-native-screenshot-detect/windows/RNScreenshotDetect.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Screenshot.Detect.RNScreenshotDetect;` to the usings at the top of the file
  - Add `new RNScreenshotDetectPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNScreenshotDetect from 'react-native-screenshot-detect';

// TODO: What to do with the module?
RNScreenshotDetect;
```
  