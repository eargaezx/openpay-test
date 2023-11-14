# openpay-test
## Developer: Eduardo Argaez

## Version 1.0.0
⋅⋅⋅

### Screeen 1. Access permisions control:
![Screenshot_20231114_135309_Permission controller](https://github.com/eargaezx/openpay-test/assets/143432782/d4b1e39b-c6f7-45b5-9f7c-59d987ac0941)

![Screenshot_20231114_135317_Permission controller](https://github.com/eargaezx/openpay-test/assets/143432782/4610fe8a-bc70-48fe-9e2f-fea4f8600561)


### Screen 2. Most popular user on themoviedb, with general information, own images, reviews:
![Screenshot_20231114_134518_OpenpayTest](https://github.com/eargaezx/openpay-test/assets/143432782/6e1d81ba-075a-46dc-bfca-879e5dc36068)



### Screen 3. Paginated movies sparated by popular, top rated, most rated:
![Screenshot_20231114_134531_OpenpayTest](https://github.com/eargaezx/openpay-test/assets/143432782/90061d39-8d3c-4297-9ed8-36ae94fafb3f)



### Screen 4. Location map on realtime database, service runing on foregroun that capture de user location every lapsed time 
![Screenshot_20231114_134546_OpenpayTest](https://github.com/eargaezx/openpay-test/assets/143432782/3e5c1f50-087e-4e57-a14c-e9a15a468376)



### Screen 5. Realtime load images storaged firebase picked from gallery or camera
![Screenshot_20231114_134552_OpenpayTest](https://github.com/eargaezx/openpay-test/assets/143432782/374beaab-2708-44e4-be7e-b92755d89e50)



### Screen 6. Firebase storage and firebase database of user locations, user images
<img width="1277" alt="Captura de pantalla 2023-11-14 a la(s) 1 46 52 p m" src="https://github.com/eargaezx/openpay-test/assets/143432782/ccd9c070-90a3-4ac2-9f47-ba63d7908320">

<img width="1280" alt="Captura de pantalla 2023-11-14 a la(s) 1 46 19 p m" src="https://github.com/eargaezx/openpay-test/assets/143432782/14c0b266-600c-4143-b90f-e6074ad54f8c">

<img width="1279" alt="Captura de pantalla 2023-11-14 a la(s) 1 47 23 p m" src="https://github.com/eargaezx/openpay-test/assets/143432782/90cec48e-542e-4137-af4e-f78e8209a5fe">


### Project documentation
clean architecture modules
data - The data layer implements the repository interface that the domain layer defines. This layer provide a single 
domain - The domain layer contains the UseCases that encapsulate a single and very specific task that can be performed. This task is part of the business logic of the application. (Kotlin module that cannot access any other module)
app - Presentation MVVM with ViewModels exposing LiveData that the UI consume. The ViewModel does not know anything about it's consumers. (Android module that can only access domain module)


