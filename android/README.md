# Android APK Build Instructions for Deepcraft

This project is a self-contained Minecraft clone. The web build is bundled into an Android WebView APK.

## Requirements
- Android Studio
- Android SDK (API 21+)
- Gradle (8.4+)

## Build Steps

1. Open Android Studio
2. Import the project: `/home/user/Deepcraft/android`
3. Sync Gradle files
4. Build APK:
   - Go to `Build` -> `Generate Signed Bundle / APK...`
   - Select `APK`
   - Choose `release` build type
   - Follow the signing wizard (or use debug APK for testing)

## Manual Build (Command Line)
```bash
cd /home/user/Deepcraft/android
./gradlew assembleRelease
```

## Features
- Self-contained WebView loading the built web assets from `assets/`
- Full IndexedDB support (game saves persist locally)
- Landscape orientation
- Hardware acceleration enabled
- No external dependencies (offline after install)

## Known Limitations
- IndexedDB in Android WebView works on API 21+
- Game controls are mouse/keyboard based in web, so touch controls are not mapped yet (requires JS modification)
- Audio may need permission handling in newer Android versions

## Web Assets Included
- dist/index.html
- dist/static/css/
- dist/static/js/
- assets/ (from web build)
