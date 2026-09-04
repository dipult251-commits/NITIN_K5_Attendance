# NITIN K5 Self Attendance App

## Overview
A simple and efficient Android application for marking daily attendance with features like present, absent, and leave tracking.

## Features
- ✅ Mark attendance (Present, Absent, Leave)
- 📅 View attendance history
- 🗓️ Monthly calendar view
- 🌙 Dark/Light mode toggle
- 💾 Local SQLite database
- ⏰ Automatic date and time tracking
- 🗑️ Clear all data option
- 📊 Attendance statistics

## Project Structure
```
NITIN_K5_Attendance/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/nitink5/attendance/
│   │       │   ├── data/
│   │       │   │   ├── AttendanceDatabase.kt
│   │       │   │   ├── AttendanceEntity.kt
│   │       │   │   ├── AttendanceDao.kt
│   │       │   │   ├── AttendanceRepository.kt
│   │       │   │   └── PreferenceManager.kt
│   │       │   └── ui/
│   │       │       ├── MainActivity.kt
│   │       │       ├── SplashActivity.kt
│   │       │       ├── viewmodel/
│   │       │       │   └── AttendanceViewModel.kt
│   │       │       └── fragments/
│   │       │           ├── HomeFragment.kt
│   │       │           ├── HistoryFragment.kt
│   │       │           ├── CalendarFragment.kt
│   │       │           └── SettingsFragment.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_splash.xml
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── fragment_home.xml
│   │       │   │   ├── fragment_history.xml
│   │       │   │   ├── fragment_calendar.xml
│   │       │   │   └── fragment_settings.xml
│   │       │   ├── menu/
│   │       │   │   └── bottom_menu.xml
│   │       │   ├── values/
│   │       │   │   ├── strings.xml
│   │       │   │   ├── colors.xml
│   │       │   │   └── themes.xml
│   │       │   └── xml/
│   │       │       ├── data_extraction_rules.xml
│   │       │       └── backup_rules.xml
│   │       └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Requirements
- Android SDK 24 (API 24) or higher
- Android Studio Flamingo or newer
- Kotlin 1.9.0+
- Gradle 8.1.0+

## Dependencies
- AndroidX Core KTX
- AndroidX AppCompat
- Material Design Components
- AndroidX Room Database
- AndroidX Lifecycle
- AndroidX Preferences
- AndroidX WorkManager

## Installation
1. Clone the repository
2. Open in Android Studio
3. Build and run the project
4. Grant permissions when prompted

## Usage
1. **Home Screen**: Mark your daily attendance
   - 🟢 Present: Mark yourself present
   - 🔴 Absent: Mark yourself absent
   - 🟡 Leave: Mark yourself on leave

2. **History**: View all past attendance records

3. **Calendar**: View attendance by month

4. **Settings**:
   - Toggle Dark/Light mode
   - View app information
   - Clear all data

## Technical Details
- **Database**: SQLite with Room ORM
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI Framework**: AndroidX with Material Design
- **Data Storage**: SharedPreferences for settings, Room for attendance records
- **Threading**: Coroutines for async operations

## Version
v1.0.0

## Author
NITIN K5

## License
MIT License

## Support
For issues or suggestions, please contact the developer.

---
**Happy Tracking! 📊**
