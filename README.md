# POC for mobile automation using:

* Serenity BDD Framework 3.1.16
* Java 11
* Appium 1.22.2
* Gradle 7.1


## Set up a device to run the tests:
(Install appium)[https://appium.io/docs/en/about-appium/getting-started/?lang=en]
Run your appium server: appium --base-path /wd/hub

### Real devices

1. Plug the device
2. Use the serenity.properties.ios.example or serenity.properties.android.example depending on which platform do you use for the testing execution and adapt it to your device specifications.
3. (Android only) make sure your device has developer mode on and  allows depuration via USB.
4. Accept the authorization for USB debugging on your device.


### Emulated devices

1. Run the emulator (AVD Manager or XCode Simulator)
2. Use the serenity.properties.ios.example or serenity.properties.android.example depending on which platform do you use for the testing execution and adapt it to your device specifications.
3. Add the appium.udid to the serenity.properties file and assign the value to it.

You can obtain the udid for android using the command adb devices

You can obtain the udid for iOS on XCode Simulator devices management



### Run the test

For mac users
```
./gradlew clean
./gradlew build -x test
./gradlew test
```

For Windows users
```
gradlew clean
gradlew build -x test
gradlew test
```
After an execution you should see the evidence in the following route: target/site/serenity/index.html
If this folder is empty you could run the gradlew aggregate to build the report