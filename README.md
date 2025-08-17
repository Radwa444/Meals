# 🍽️ MealsApp

![Kotlin](https://img.shields.io/badge/Kotlin-100%25-blue)
![Retrofit](https://img.shields.io/badge/Retrofit-Implemented-brightgreen)
![Hilt](https://img.shields.io/badge/Hilt-DI-orange)
![StateFlow](https://img.shields.io/badge/StateFlow-Reactive-blueviolet)
![MVVM](https://img.shields.io/badge/MVVM-Clean%20Architecture-green)

---

## **Project Description**
**MealsApp** is a modern Android application that fetches meal data from a remote API and displays it in a clean, interactive, and responsive UI.  
The app follows **MVVM** design pattern combined with **Clean Architecture** to ensure maintainable, scalable, and testable code.

---

## **Project Architecture**
- **Multi-Module Structure:**
  - `app` → Contains UI and Android-specific components.
  - `domain` → Contains business logic and use cases.
  - `data` → Handles data sources, API calls, and repositories.
- **MVVM (Model-View-ViewModel)** → Separates UI from business logic.
- **Clean Architecture** → Ensures separation of concerns and testability.

---

## **Technologies & Tools Used**
- **Kotlin** → Main programming language.
- **Coroutines** → For asynchronous programming and background tasks.
- **StateFlow** → Used for reactive UI updates and holding data from API.
- **Retrofit** → Networking library to fetch data from API.
- **Hilt** → Dependency Injection for clean and testable code.


---

## **Features**
- Fetch meals from **Fake API**.
- Display meals in a **RecyclerView** with smooth UI.
- Uses **StateFlow** to observe and update UI reactively.
- Dependency Injection with **Hilt** for clean code.
- Modular architecture ensures **scalable and maintainable** code.

---

## **Project Structure**


