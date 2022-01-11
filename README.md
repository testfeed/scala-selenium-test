### Steps to run the test

#### Download the Mozilla geckodriver
- https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-linux64.tar.gz
- untar it and make it executable

```
    tar -xzvf geckodriver-v0.24.0-linux64.tar.gz -C /home/$USER/
    chmod +x /home/$USER/geckodriver
```

#### Run the tests

```
    sbt -Dwebdriver.gecko.driver=/home/$USER/geckodriver test
```
