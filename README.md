# Media 365 Home — Android News App

A clean and simple News app built with **Kotlin** and **Jetpack Compose**, showcasing **MVVM**, **Kotlin Flow**, **Clean Architecture**, **Hilt (DI)**, **Retrofit**, and **type‑safe navigation**. Users can browse a list of news articles and view full article details. The UI is intentionally minimal; the code emphasizes maintainability, testability, and best practices.

<p align="left">
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.9.x-informational" />
  <img alt="Compose" src="https://img.shields.io/badge/Jetpack%20Compose-UI-informational" />
  <img alt="Architecture" src="https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean%20Architecture-success" />
  <img alt="Hilt" src="https://img.shields.io/badge/DI-Hilt-blue" />
  <img alt="Networking" src="https://img.shields.io/badge/Networking-Retrofit%20%2B%20OkHttp-lightgrey" />
  <img alt="License" src="https://img.shields.io/badge/License-MIT-yellow" />
</p>

---

## ✨ Features

* News list with title, source, and publication time
* Article details screen (image, content)
* Pull‑to‑refresh and error/empty states
* Light theme with Material 3
* Strict separation of layers for testability

---

## 🧰 Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose, Material 3
* **Architecture:** MVVM + Clean Architecture (domain/data/presentation)
* **Reactivity:** Kotlin Coroutines & Flow
* **DI:** Dagger Hilt
* **Navigation:** Navigation Compose with type‑safe arguments
* **Networking:** Retrofit, OkHttp, Gson
* **Serialization:** Gson
* **Build:** Gradle (KTS), R8/ProGuard enabled

---

## 🏗️ Project Structure

```
app/
 ├─ data/
 │   ├─ remote/           # Retrofit services, DTOs
 │   ├─ repository/       # Repository impl mapping DTO -> Domain
 │  
 ├─ domain/
 │   ├─ model/            # Domain models
 │   └─ repository/       # Repository contracts (interfaces)
 ├─ presentation/
 │   ├─ navigation/       # Nav graph + type‑safe args
 │   ├─ newslist/         # List screen (ViewModel, UI)
 │   └─ newsdetail/       # Detail screen (ViewModel, UI)
 ├─ di/                   # Hilt modules
 ├─ core/                 # Result wrappers, error handling, utils
 └─ build.gradle.kts
```

---

## ⚙️ Configuration

Set your API base URL and (optionally) API key in **`gradle.properties`** (project level):

```properties
# gradle.properties
API_BASE_URL=https://api.yournewsprovider.com/
```

Expose them to BuildConfig in **`app/build.gradle.kts`**:

```kotlin
android {
    defaultConfig {
        buildConfigField("String", "API_BASE_URL", "\"${properties["API_BASE_URL"]}\"")
        buildConfigField("String", "NEWS_API_KEY", "\"${properties["NEWS_API_KEY"] ?: ""}\"")
    }
}
```

Configure Retrofit using the values:

```kotlin
@Provides
@Singleton
fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.API_BASE_URL)
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
```


## ▶️ Getting Started

1. **Requirements**

   * Android Studio Koala or newer
   * JDK 17
   * Android Gradle Plugin 8.x
2. **Clone**

   ```bash
   git clone https://github.com/RxSajib/Media-365-Sajib-Roy-.git
   ```
3. **Configure**: Add `API_BASE_URL` `gradle.properties`.
4. **Run**: Sync Gradle and run the app from Android Studio.



## 🔐 ProGuard / R8

* Keep models used by Moshi/Gson as needed
* Sample keep rules (Gson):



## 🧭 Navigation (Type‑safe Args)

If passing an article ID or URL between screens:

```kotlin
@Serializable
data class ArticleArg(val id: String)

// Usage
navController.navigate("details/${argJson}")
```

Or use Navigation Compose’s `navArgument` with typed routes.


## 🧹 Code Style

* Kotlin DSL Gradle

```bash
./gradlew ktlintCheck
./gradlew detekt
```



## 📄 License

MIT © Sajib Roy


## 🙏 Acknowledgements

* News API provider
* Android community samples for Compose & Hilt

---

### Short Project Description (for GitHub)

> **Media 365 Home** — A minimal, well‑architected Android news app using Kotlin, Jetpack Compose, MVVM, Flow, Hilt, and Retrofit. Clean code, type‑safe navigation.
