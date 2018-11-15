
# react-native-blue-print

## Getting started

`$ npm install react-native-blue-print --save`

### Mostly automatic installation

`$ react-native link react-native-blue-print`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import io.bhanu.reactnative.RNBluePrintPackage;` to the imports at the top of the file
  - Add `new RNBluePrintPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-blue-print'
  	project(':react-native-blue-print').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-blue-print/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-blue-print')
  	```


## Usage
```javascript
import RNBluePrint from 'react-native-blue-print';

//inside async fn-
await RNBluePrint.print("hello world");

```
  