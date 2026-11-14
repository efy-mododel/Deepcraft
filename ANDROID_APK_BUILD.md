# Deepcraft Minecraft APK Build Instructions

This repository now includes an Android APK build system that bundles the web-based Minecraft clone into a self-contained Android application.

## What Changed

1. **Android Project Structure** (`android/` directory)
   - Added Android Gradle configuration files
   - Added `MainActivity.java` (WebView wrapper)
   - Added AndroidManifest.xml with required permissions
   - Added app icons and theme resources
   - Added build instructions

2. **Web Build Integration**
   - The web build (`dist/` folder) is automatically copied to `android/app/src/main/assets/`
   - The Android WebView loads `file:///android_asset/index.html`
   - IndexedDB persistence works locally on Android devices

3. **Self-contained APK**
   - No external dependencies after installation
   - Offline-capable (all assets bundled)
   - Landscape orientation optimized for gameplay
   - Hardware acceleration enabled

## Build Instructions

### Prerequisites
- Android Studio
- Android SDK (API 21+)
- Gradle (8.4+)

### Step 1: Build the Web Assets
```bash
npm install
npx rsbuild build
```

### Step 2: Import into Android Studio
1. Open Android Studio
2. Import project: `/home/user/Deepcraft/android`
3. Sync Gradle files

### Step 3: Generate APK
1. Go to `Build` -> `Generate Signed Bundle / APK...`
2. Select `APK`
3. Choose `release` build type
4. Follow signing wizard (or use debug APK for testing)

### Step 4: Manual Build (Command Line)
```bash
cd /home/user/Deepcraft/android
./gradlew assembleRelease
```

## Technical Details

### WebView Configuration
- JavaScript enabled
- IndexedDB/LocalStorage enabled (for game saves)
- DOM Storage enabled
- Hardware acceleration enabled
- Landscape orientation
- No action bar

### Game Persistence
- Game saves are stored in Android's local storage via IndexedDB
- Saves persist between app launches
- Manual save (Ctrl+S) and autosave (30s) work as in web version

### Controls
- The web game uses mouse/keyboard controls
- For touch devices, consider adding touch mappings in `GameCanvas.tsx`
- Currently uses web-based controls (WASD, Mouse, etc.)

### Permissions
- INTERNET (for potential future updates)
- ACCESS_NETWORK_STATE

## Files Added

- `android/build.gradle` - Root build configuration
- `android/settings.gradle` - Project settings
- `android/app/build.gradle` - App module configuration
- `android/app/src/main/AndroidManifest.xml` - App manifest
- `android/app/src/main/java/com/deepcraft/minecraft/MainActivity.java` - WebView activity
- `android/app/src/main/assets/` - Web build assets (copied from dist/)
- `android/app/src/main/res/` - Resources (icons, themes, strings)
- `android/gradle.properties` - Gradle properties
- `android/gradle/wrapper/gradle-wrapper.properties` - Gradle wrapper
- `android/README.md` - Build instructions

## Future Improvements

1. **Touch Controls**
   - Add touch event handlers in `GameCanvas.tsx`
   - Map touch gestures to game actions (move, look, mine, place)

2. **Performance Optimization**
   - WebAssembly compilation for Three.js
   - Texture compression for mobile devices

3. **Android-specific Features**
   - Vibration feedback for mining/placing blocks
   - Native Android notifications for game events
   - In-app purchases for premium features

4. **Multi-platform Support**
   - iOS build using WKWebView
   - Desktop apps (Electron, Tauri)

## License

MIT License (same as the original project)

## Contact

For questions or contributions, please open issues or pull requests in the repository.
