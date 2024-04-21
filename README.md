Cartoon App is an Android app that showcases the implementation of various Android Jetpack components. This project leverages technologies such as Pagination, Coroutine, Pagination Adapter, RecyclerView, MVVM architecture, Retrofit, Hilt, and Coil. The app consumes data from the open-source API provided by [The Rick and Morty API](https://rickandmortyapi.com/).

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Architecture](#architecture)
- [API Usage](#api-usage)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Cartoon App is a mobile app designed to explore information about the characters, locations, and episodes from the popular animated series "Rick and Morty." This project serves as a practical example of integrating Jetpack components and other modern Android development practices.

## Features

- **Pagination:** Seamless loading of characters, locations, and episodes, providing a smooth browsing experience.
- **Coroutine:** Asynchronous programming using Kotlin Coroutines ensures responsive and performant user interactions.
- **Pagination Adapter:** Custom adapters for RecyclerViews efficiently handle paginated data sets.
- **RecyclerView:** Displaying information in a scrollable and efficient list.
- **MVVM Architecture:** A clean architecture using the Model-View-ViewModel pattern for better separation of concerns.
- **Retrofit:** Utilizing Retrofit for type-safe HTTP requests, interacting with the Rick and Morty API.
- **Hilt:** Dependency injection library simplifying the setup and management of dependencies.
- **Coil:** Image loading library for efficient loading and caching of character avatars.

## Tech Stack

- Kotlin
- Android Jetpack Components
  - Paging
  - ViewModel
  - LiveData
- Coroutine
- Retrofit
- Hilt (Dagger)
- Coil
- RecyclerView

## Getting Started

To run the app locally, follow these steps:

1. Clone this repository: `git clone git@github.com:divyanshuk10/Cartoon-App.git`
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Architecture

The app follows the MVVM + Module based clean architecture pattern:

- **Model:** Represents the data and business logic, fetching data from the Rick and Morty API.
- **View:** Displays the UI and captures user input.
- **ViewModel:** Acts as a mediator between the Model and View, handling UI-related logic and data fetching.
- **model:** Acts as a mediator between the Model and View, handling UI-related logic and data fetching.
- **data:** Consumes network and model module and Contains logic related to data fetching via network source.
- **network:** Consumes model and common module. This module contains code related to API services like retrofit, okhttp and network calls for fetching data from the network service.
- **common:** This module contains code related to common and utils

## API Usage

The app consumes the open-source API provided by [The Rick and Morty API](https://rickandmortyapi.com/). For details on how to use the API, refer to their [documentation](https://rickandmortyapi.com/documentation/).

## Screenshots

<img src="https://github.com/divyanshuk10/Cartoon-App/assets/19980597/9485dcb4-634e-49ed-909c-4624ca4a1aa9" alt="Trulli" width="250" >

<img src="https://github.com/divyanshuk10/Cartoon-App/assets/19980597/f80cf61d-a716-4404-88c4-cbb2a82da2b7" alt="Trulli" width="250" >

<img src="https://github.com/divyanshuk10/Cartoon-App/assets/19980597/622adb26-36e2-4251-8476-8d3622ac7070" alt="Trulli" width="250" >

## Contributing

If you would like to contribute to this project, please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify the code as per your requirements.

Enjoy exploring the multiverse with Rick and Morty Explorer! 🚀🌌
