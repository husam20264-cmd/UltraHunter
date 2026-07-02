# UltraHunter

AI-powered product hunting Android application built with Kotlin and Python (via Chaquopy).

## Features

- AI-powered product discovery
- Android-native UI with Kotlin
- Python ML backend via Chaquopy integration
- Gradle build system with modern tooling

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | Kotlin / Android SDK |
| Backend | Python (Chaquopy) |
| Build | Gradle 8.2 |
| Min SDK | Android API 24+ |

## Project Structure

```
UltraHunter/
├── app/                    # Android app module
│   ├── src/               # Source code
│   └── build.gradle       # App-level build config
├── build.gradle           # Project-level build config
├── settings.gradle        # Project settings
├── gradle.properties      # Gradle properties
└── gradlew                # Gradle wrapper
```

## Building

```bash
./gradlew assembleDebug
```

## Requirements

- Android Studio Hedgehog or later
- JDK 17
- Android SDK API 24+

---

Part of the UltraHunter AI product discovery platform.