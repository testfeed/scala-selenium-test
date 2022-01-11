### Steps to run the test

#### Run the juice shop docker image
```
sudo docker run --rm -p 3000:3000 bkimminich/juice-shop:v13.0.3
```

#### Download the Mozilla geckodriver
- https://github.com/mozilla/geckodriver/releases/download/v0.30.0/geckodriver-v0.30.0-linux64.tar.gz
- untar it and make it executable

```
    tar -xzvf geckodriver-v0.30.0-linux64.tar.gz -C /home/$USER/
    chmod +x /home/$USER/geckodriver
```

#### Run the tests

```
    sbt -Dwebdriver.gecko.driver=/home/$USER/geckodriver test
```
