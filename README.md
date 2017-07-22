# ArchitectureComponents
***Playing around with the new Android Architecture Components.***

A simple counter thread counts every 500ms, displays the current count inside a simple Activity layout.

This sample project has two Activities:

**LifecycleObserverActivity -**
A LifecycleObserver implementation (LifecycleObserverCounter) is used to start/stop the counting based on the Activity lifecycle.

**LiveDataActivity -**
A LiveData implementation (= abstraction over the LifecycleObserver interface) is used to start/stop the counting based on the Activity lifecycle.


**Third party libraries used:**


[LeakCanary](https://github.com/square/leakcanary)
