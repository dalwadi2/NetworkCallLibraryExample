# NetworkCallLibraryExample

## Problem Statement
Build an app to render a custom UI. The app will have 2 modules:

### Network Module
- Create a Network interface with 2 methods as
- JSONObject fetchCustomUI (String URL): This will connect to a URL and return the JSON object
found in the URL.
- byte[] fetchLogo (String URL): This will connect to a URL and return the image data. The URL is
found in the above custom json
- Interface will be called by the App module to perform the operations.
- Create a jar/aar file and include this in the app module.

### App Module:
- This contains all the UI elements and includes the jar/aar file.
- There will be 2 activities in the app.
- Activity 1 will call fetchCustomUI() and render the UI based on the JSON received.
- UI elements are to be sent to Activity 2 in the ‘key’ fields mentioned in the custom JSON
- Activity 2 will display all the elements passed by Activity 1.
- Errors and exceptions to be handled gracefully.
- Custom UI URL: https://demo.ezetap.com/mobileapps/android_assignment.json

### Recording

https://user-images.githubusercontent.com/16306370/210635901-0a856efd-26a7-4b4f-aacf-be50cb996331.mp4

