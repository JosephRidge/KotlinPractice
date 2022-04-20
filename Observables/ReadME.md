## Setting up the Data binding :

- In your app build gradle add :
       ``` buildFeatures {
                dataBinding true
            }
       ```
- Once added your ui controllers ( In this case : HomeFragment & HomeViewModel, NumbersFragment $ NumbersViewModel )
     In the event you have XMl layouts, for the fragment layouts the base tag should be altered to <layout> while for the main activity must contain the
     <merge>  tag as the base.

    -  Activity main xml
        ```
                <?xml version="1.0" encoding="utf-8"?>
                <merge>
                <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    xmlns:tools="http://schemas.android.com/tools"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    tools:context=".MainActivity">

                    <fragment
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:id="@+id/nav_host_fragment"
                        android:name="androidx.navigation.fragment.NavHostFragment"
                        app:defaultNavHost="true"
                        app:navGraph="@navigation/navigation"

                        />

                </androidx.constraintlayout.widget.ConstraintLayout>
                    </merge>
        ```
    -  Fragment xmls

        ```
        <?xml version="1.0" encoding="utf-8"?>
        <layout>
        <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".ui.home.HomeFragment">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Hello" />

        </FrameLayout>
            </layout>
        ```
Now Clean and Rebuild  your project , to allow the Data binding class to generate your ui controller binding classes

## Setting  up safe args

- in your apps build gradle file  add the safe args plugin id:
        ```
        plugins {
            .....
            id 'androidx.navigation.safeargs'
        }
        ```

- Under project build gradle  add the safe args in the dependencies section :
        ```
        buildscript {
            repositories {..}

            dependencies {
             .....
                classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0"
            }
        }
        ```
Note that if you try and place the navigation safe guard dependencies in the apps build gradle file it will not work but instead generate conflicts error.fragment

## Setting up The Variables, observables and observers
    - The variables and observables are set in the view model as the observers in the ui controller, the fragment.
    - Inside the View model we will encapsulate the Livedata :
        ```
        private val _numbers = MutableLiveData<Int>() // Scoped in the View model
             val number : LiveData<Int> //This is the observables exposed to the UI controller using the backing properties ie getters and setters
                get() = _numbers
                ```
    -  Inside the View Fragment will initialize the data binding object , having set up your dataBinding object well .
        ```
        private lateinit var binding:HomeFragmentBinding // Variable initialization
         // in onCreateView() method :
         binding  = DataBindingUtil.inflate(
                     inflater,
                     R.layout.home_fragment,
                     container,
                     false)
                     ```
    - Initialize the viewModel object :
            ` viewModel = ViewModelProvider(this).get(HomeViewModel::class.java) `

    - Initialize and define the observer  :
        ```
         viewModel.number.observe(viewLifecycleOwner, Observer {
                    number ->
                    if(number == 10){
                        val action = HomeFragmentDirections.actionHomeFragmentToNumbersFragment()
                        NavHostFragment.findNavController(this).navigate(action)
                    }
                })
              ```


