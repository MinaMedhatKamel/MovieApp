# MovieApp
This Task is for Yassir company process interview
### Usecases
- List screen.
  - Load the data from discovery api and display them in a gradle view.
  - display the image, title and the year of the movie.
  - on click on any item it navigates to the detailsscreen
  - add the infinity scrolling with paging functionality to the list
  - <img width="200" alt="image" src="https://user-images.githubusercontent.com/10800558/174817062-01321055-7af5-4c9b-8818-d184f3417502.png">
- Details screen:
  - display the details of the movie by calling the details api.
  - back button returns back to the list screen.
  - <img width="200" alt="image" src="https://user-images.githubusercontent.com/10800558/174817707-24f81dae-b80e-47e6-9744-e958c1c69a7a.png">
  - <img width="200" alt="image" src="https://user-images.githubusercontent.com/10800558/174817875-db0d1574-9527-4dbe-9161-31a6c8be4318.png">

 
### architecture:
- Multi modules project.
  - I made a multi modules project based on the features modules of the requirment as we have list and details features each one of them has its own         sperated module and can be extracted for getting more maintainability, testability and reusability.
  - Project modules:
    - App Module: handling the mainactivity and navigation
    - common: handling the shared base clases, data, styles, resources and common resubale ui components between the features.
    - movieslist: movies list features I applyied the MVI architecture for the by separating the layers from the data to the list screen.
    - moviesdetails: movies details features I applyied the MVI architecture for the by separating the layers from the data to the details screen.
 - MVI architecture layers:
    - data layer: contains the models and retrofit APi related to this feature.
    - di: contains the dependancy injections modules.
    - domain: contains the usecases of each module.
    - intent: the intents or the actions that could be send from the view to the viewmodel.
    - state: the ui state that should be applied to the view
    - ui compose functions for displaying the ui.
    - and finaly the viewmodel
 - BuildSrc: for handling the dependancies in a good way.
### Technologies:
* `Kotlin` + `Coroutines` + `flow`
* Hilt for dependancy injection with Multi-Modules support.
* Retrofit2 & Gson & okhttp
* Pagging 3
* Material Design
* View Binding
* Android Jetpack's Navigation
* `compose` with `MVI`
* `junit` with `mockk` with `turbine` and `CoroutinesTest` for testing.


### Testing:
* testing is supporting viewmodel testing, mapping data, coroutines and MVI architecture.
* sample domain testing check class `com.mina.movieslist.domain.GetMoviesUseCaseTest`
* sample viewModel Testing check class 'com.mina.moviedetails.MovieDetailsViewModelTest'




